(ns spicy-breakfast.logic-test
  (:require [clojure.test :refer [deftest is]]
            [spicy-breakfast.logic :as logic]))

(deftest price-products-test
  (is (= 56.0
         (logic/price-products
           {"price" 3.0
            "bulkPricing" {"amount" 10
                           "totalPrice" 25.0}}
           22))
      "Should be 2 x bulk price 25.0 + 2 x normal price 3.0 == 56.0")
  (is (= 63.0
         (logic/price-products
           {"price" 3.0}
           21))
      "Should handle missing bulkPricing")
  (is (= 15.54
         (logic/price-products
           {"price" 0.02}
           777))
      "Money should not suffer from small float math errors")
  (is (= 0.07
         (logic/price-products
           {"price" 0.02
            "bulkPricing" {"amount" 10
                           "totalPrice" 0.01}}
           13))
      "Money should not suffer from small float math errors in bulk pricing"))

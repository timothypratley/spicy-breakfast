(ns spicy-breakfast.view.cart
  (:require [spicy-breakfast.logic :as logic]
            [soda-ash.core :as sa]
            [devcards.core :refer-macros [defcard-rg]]
            [clojure.string :as str]))

(defn cart [order]
  [sa/Container
   [sa/Header {:as "h2"} "Cart"]
   [sa/ListSA
    {:divided true
     :relaxed true}
    (doall
      (for [[id {:keys [product number price]}]
            (sort-by (comp str/lower-case #(get % "name") :product val)
                     order)
            :let [{:strs [name]} product]]
        ^{:key id}
        [sa/ListItem
         [sa/ListContent
          (str name " x " number)
          [:span
           {:style {:float "right"}}
           (logic/moneyf price)]]]))
    [sa/ListItem "Total"
     [:span
      {:style {:float "right"}}
      (logic/moneyf (logic/order-total order))]]]])


;; Example

(def example-order
  {1 {:product {"name" "Brownie"}
      :number 1
      :price 3}
   2 {:product {"name" "Key Lime Cheesecake"}
      :number 2
      :price 5}
   3 {:product {"name" "Cookie"}
      :number 6
      :price 12.50}})

(defcard-rg cart-card
  [cart example-order])

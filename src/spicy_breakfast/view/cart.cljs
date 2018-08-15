(ns spicy-breakfast.view.cart
  (:require [soda-ash.core :as sa]
            [devcards.core :refer-macros [defcard-rg]]))

(defn cart [{:keys [products total-price]}]
  [sa/Container
   [sa/Header
    {:as "h2"}
    "Cart"]
   [sa/ListSA
    {:divided true
     :relaxed true}
    (doall
      (for [{:keys [id name count price]} products]
        ^{:key id}
        [sa/ListItem
         [sa/ListContent
          (str name " x " count)
          [:span {:style {:float "right"}} price]]]))
    [sa/ListItem "Total"
     [:span {:style {:float "right"}} total-price]]]])


;; Example

(def example-cart
  {:total-price 100
   :products [{:id 1
               :name "Brownie"
               :count 1
               :price 2}
              {:id 2
               :name "Key Lime Cheesecake"
               :count 2
               :price 16}
              {:id 3
               :name "Cookie"
               :count 6
               :price 7.5}]})

(defcard-rg cart-card
  [cart example-cart])

(ns spicy-breakfast.view.product-list
  (:require [soda-ash.core :as sa]
            [devcards.core :refer-macros [defcard-rg]]
            [spicy-breakfast.logic :as logic]
            [spicy-breakfast.model :as model]))

(defn product-list [products]
  [sa/ItemGroup
   (doall
     (for [{:strs [id name imageURL price bulkPricing] :as product} products]
       ^{:key id}
       [sa/Item
        [sa/ItemImage {:floated "left"
                       :src imageURL
                       :size "small"}]
        [sa/ItemContent
         [sa/ItemHeader name]
         [sa/ItemDescription
          (logic/moneyf price)
          (when-let [{:strs [amount totalPrice]} bulkPricing]
            (str " or " amount " for "
                 (logic/moneyf totalPrice)))]
         [:br]
         [sa/Button
          {:on-click
           (fn click-add-to-cart [event]
             (model/add-to-cart! product))}
          "add to cart"]]]))])


;; Example

(def example-products
  [{"id" 1
    "name" "Brownie"
    "imageURL" "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHdr1eTXEMs68Dx-b_mZT0RpifEQ8so6A1unRsJlyJIPe0LUE2HQ"
    "price" 2
    "bulkPricing" {"amount" 4
                   "totalPrice" 7}}
   {"id" 2
    "name" "Key Lime Cheesecake"
    "imageURL" "http://1.bp.blogspot.com/-7we9Z0C_fpI/T90JXcg3YsI/AAAAAAAABn4/EN7u2vMuRug/s1600/key+lime+cheesecake+slice+in+front.jpg"
    "price" 8
    "bulkPricing" nil}
   {"id" 3
    "name" "Cookie"
    "imageURL" "http://www.mayheminthekitchen.com/wp-content/uploads/2015/05/chocolate-cookie-square.jpg"
    "price" 1.25
    "bulkPricing" {"amount" 6
                   "totalPrice" 6}}
   {"id" 4
    "name" "Mini Gingerbread Donut"
    "imageURL" "https://s3.amazonaws.com/pinchofyum/gingerbread-donuts-22.jpg"
    "price" 0.5
    "bulkPricing" nil}])

(defcard-rg product-list-card
  [product-list example-products])

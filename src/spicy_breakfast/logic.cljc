(ns spicy-breakfast.logic)

(defn price-products
  "Given a product and number, apply bulk pricing to figure out the final cost."
  [product number]
  (let [{:strs [price bulkPricing]} product]
    (if-let [{:strs [amount totalPrice]} bulkPricing]
      (/ (+ (* (quot number amount) (* 100 totalPrice))
            (* (rem number amount) (* 100 price)))
         100)
      (/ (* number (* 100 price))
         100))))

(defn price-line-item [{:keys [product number] :as line-item}]
  (assoc line-item :price (price-products product number)))

(defn add-product-to-line-item
  "Reprices a line item based on an additional item being included"
  [line-item]
  (-> line-item
      (update :number inc)
      (price-line-item)))

(defn update-or-add-line-item
  "Either creates a new line item, or adds to and reprices an existing line item."
  [line-item product]
  (if line-item
    (add-product-to-line-item line-item)
    {:product product
     :number 1}))

(defn add-to-cart
  "Transition app-state by adding a product to the shopping cart."
  [app-state {:keys [id] :as product}]
  (update-in app-state [:cart id] update-or-add-line-item product))

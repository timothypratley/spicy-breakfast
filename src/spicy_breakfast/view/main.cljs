(ns spicy-breakfast.view.main
  (:require [spicy-breakfast.view.cart :as cart]
            [spicy-breakfast.view.product-list :as product-list]
            [reagent.core :as reagent]
            [reagent.ratom :refer-macros [reaction]]))

(defn main [app-state add-to-cart]
  (reagent/with-let
    [products (reaction (:products @app-state))
     categories (reaction (keys @products))
     current-category (reaction (:current-category @app-state (first @categories)))
     current-products (reaction (get @products @current-category))
     cart (reaction (:cart @app-state))]
    [:div
     [:h3 "Spicy breakfast"]
     [:div (str @categories)]
     [product-list/product-list @current-products add-to-cart]
     [cart/cart @cart]]))

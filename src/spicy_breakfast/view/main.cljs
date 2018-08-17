(ns spicy-breakfast.view.main
  (:require [spicy-breakfast.view.cart :as cart]
            [spicy-breakfast.view.product-list :as product-list]
            [reagent.core :as reagent]
            [reagent.ratom :refer-macros [reaction]]
            [soda-ash.core :as sa]))

(defn main [app-state]
  (reagent/with-let
    [products (reaction (:products @app-state))
     categories (reaction (keys @products))
     current-category (reaction (:current-category @app-state (first @categories)))
     current-products (reaction (get @products @current-category))
     cart (reaction (:cart @app-state))]
    [sa/Container
     [sa/Header {:as "h1"}
      [sa/Image {:src "favicon.png"}]
      "Welcome to the Spicy Breakfast shop"]
     [:br]
     [sa/Grid {:columns 2}
      [sa/GridRow
       [sa/GridColumn {:width 10}
        [product-list/product-list @current-products]]
       [sa/GridColumn {:width 6}
        [cart/cart @cart]]]]]))

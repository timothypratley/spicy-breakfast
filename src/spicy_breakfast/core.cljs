(ns spicy-breakfast.core
    (:require [spicy-breakfast.communication :as communication]
              [spicy-breakfast.model :as model]
              [spicy-breakfast.view.main :as main]
              [goog.dom :as dom]
              [reagent.core :as reagent]))

(defn main []
  (communication/fetch-products)
  (when-let [app (dom/getElement "app")]
    (reagent/render-component [main/main model/app-state model/add-to-cart] app)))

(main)

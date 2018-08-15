(ns spicy-breakfast.core
    (:require [spicy-breakfast.view.main :as main]
              [spicy-breakfast.model :as model]
              [goog.dom :as dom]
              [reagent.core :as reagent :refer [atom]]))

(defn main []
  (model/fetch-products)
  (when-let [app (dom/getElement "app")]
    (reagent/render-component [main/main model/app-state model/add-to-cart] app)))

(main)

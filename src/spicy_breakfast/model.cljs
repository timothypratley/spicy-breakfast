(ns spicy-breakfast.model
  (:require [reagent.core :as reagent]
            [spicy-breakfast.logic :as logic]))

(defonce app-state
  (reagent/atom {}))

(defn add-to-cart! [product]
  (swap! app-state logic/add-to-cart product))

(defn receive-products [products]
  (swap! app-state assoc :products products))
(ns spicy-breakfast.model
  (:require [reagent.core :as reagent]
            [spicy-breakfast.logic :as logic]))

(defonce app-state
  (reagent/atom {}))

(defn receive-products [products]
  (swap! app-state assoc :products products))

(defn add-to-cart! [product]
  (swap! app-state logic/add-to-cart product))

(defn remove-from-cart! [product]
  (swap! app-state logic/remove-from-cart product))
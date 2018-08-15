(ns spicy-breakfast.model
  (:require [goog.net.XhrIo :as xhr]
            [reagent.core :as reagent]))

(defonce app-state
  (reagent/atom {}))

(defn fetch-products []
  (xhr/send "products-data.json"
            (fn [event]
              (let [response (.-target event)]
                (if (= 200 (.getStatus response))
                  (swap! app-state assoc :products (js->clj (.getResponseJson response)))
                  (println "Bad response to fetch-products" response))))))

(defn add-to-cart [id]
  ;; TODO
  #_(swap! app-state update-in [:cart id] (fnil inc 0)))

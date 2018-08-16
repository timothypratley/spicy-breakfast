(ns spicy-breakfast.communication
  (:require [spicy-breakfast.model :as model]
            [goog.net.XhrIo :as xhr]))

(defn fetch-products []
  (xhr/send "products-data.json"
            (fn [event]
              (let [response (.-target event)]
                (if (= 200 (.getStatus response))
                  (model/receive-products (js->clj (.getResponseJson response)))
                  (println "Bad response to fetch-products" response))))))

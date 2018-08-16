(defproject spicy-breakfast "0.1.0-SNAPSHOT"
  :description "An online shopping experience"
  :url "http://github.com/timothypratley/spicy-breakfast"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.7.1"

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [org.clojure/core.async  "0.4.474"]
                 [reagent "0.8.1"]
                 [soda-ash "0.82.2"]
                 [devcards "0.2.5"]]

  :plugins [[lein-figwheel "0.5.16"]
            [lein-cljsbuild "1.1.7" :exclusions [[org.clojure/clojure]]]
            [lein-doo "0.1.10"]]

  :source-paths ["src"]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel {:open-urls ["http://localhost:3449/index.html"]}
                :compiler {:main spicy-breakfast.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/spicy_breakfast.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true
                           :preloads [devtools.preload]}}
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/compiled/spicy_breakfast.js"
                           :main spicy-breakfast.core
                           :optimizations :advanced
                           :pretty-print false}}
               {:id "test"
                :source-paths ["src" "test"]
                :compiler {:output-to "resources/public/js/compiled/testable.js"
                           :main spicy-breakfast.test-runner
                           :optimizations :advanced}}
               {:id "devcards"
                :source-paths ["src"]
                :figwheel {:devcards true}
                :compiler {:main "spicy-breakfast.core"
                           :asset-path "js/compiled/devcards_out"
                           :output-to "resources/public/js/compiled/spicy_breakfast_devcards.js"
                           :output-dir "resources/public/js/compiled/devcards_out"
                           :source-map-timestamp true }}]}

  :figwheel {:css-dirs ["resources/public/css"]}

  :doo {:build "test"}

  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.10"]
                                  [figwheel-sidecar "0.5.16"]
                                  [cider/piggieback "0.3.8"]
                                  [org.clojure/tools.nrepl "0.2.13"]]
                   :source-paths ["src" "dev"]
                   :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
                   :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                                     :target-path]}})

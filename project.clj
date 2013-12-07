(defproject csrf "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring "1.2.1"]
                 [cheshire "5.2.0"]
                 [ring-anti-forgery "0.3.0"]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler csrf.core/app})

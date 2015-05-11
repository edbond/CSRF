(defproject csrf "0.1.1-SNAPSHOT"
  :description "Example of broken CSRF token"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.4"]
                 [ring "1.3.2"]
                 [ring/ring-defaults "0.1.5"]
                 [cheshire "5.4.0"]
                 [ring/ring-anti-forgery "1.0.0"]]
  :plugins [[lein-ring "0.9.3"]
            [lein-ancient "0.5.5"]]
  :ring {:handler csrf.core/app})

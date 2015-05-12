(ns csrf.core
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :refer [resources not-found]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.session :refer [wrap-session]]
            [ring.middleware.anti-forgery :refer :all]
            [ring.middleware.session.cookie :refer (cookie-store)]
            [cheshire.core :refer :all])
  (:gen-class))


(defroutes app-routes
  (GET "/" [] (generate-string {:csrf-token
                                *anti-forgery-token*}))
  (POST "/send" [email] "ok")
  (resources "/")
  (not-found "Not Found"))

(def app
  (-> app-routes
   (wrap-defaults site-defaults) ; default behavior adds anti-forgery
   (wrap-session {:cookie-attrs {:max-age 3600}
                  :store (cookie-store {:key "ahY9poQuaghahc7I"})})))

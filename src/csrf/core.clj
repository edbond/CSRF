(ns csrf.core
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :refer [resources not-found]]
            [compojure.handler :refer [site]]
            [ring.middleware.session :refer [wrap-session]]
            [ring.middleware.anti-forgery :refer :all]
            [ring.middleware.session.cookie :refer (cookie-store)]
            [cheshire.core :refer :all]))


(defroutes app-routes
  (GET "/" [] (generate-string {:csrf-token
                                *anti-forgery-token*}))
  (POST "/send" [email] "ok")
  (resources "/")
  (not-found "Not Found"))

(def app
  (->
   (site app-routes)
   (wrap-anti-forgery)
   (wrap-session {:cookie-attrs {:max-age 3600}
                  :store (cookie-store {:key "ahY9poQuaghahc7I"})})))

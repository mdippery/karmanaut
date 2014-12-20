(ns karmanaut.client
  (:require [clj-http.client :as client])
  (:require [clojure.data.json :as json]))

(defn url [username]
  (str "http://www.reddit.com/user/" username "/about.json"))

(def client-params {:client-params {"http.useragent" "karmanaut/1.0.0 by mipadi - michael@monkey-robot.com"}})

(defn resp [username]
  (client/get (url username) client-params))

(defn body [username]
  (json/read-str (:body (resp username))))

(defn user-data [username]
  ((body username) "data"))

(defn user-key [username data-key]
  ((user-data username) data-key))

(defn link-karma [username]
  (user-key username "link_karma"))

(defn comment-karma [username]
  (user-key username "comment_karma"))

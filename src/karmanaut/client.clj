(ns karmanaut.client
  (:require [clj-http.client :as client])
  (:require [clojure.data.json :as json])
  (:require [karmanaut.utils :as utils]))

(defn url [username]
  (str "http://www.reddit.com/user/" username "/about.json"))

(def user-agent
  (str "karmanaut/" utils/version " by mipadi - michael@monkey-robot.com"))

(def client-params
  {:client-params {"http.useragent" user-agent}})

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

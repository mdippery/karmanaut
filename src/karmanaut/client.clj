(ns karmanaut.client
  (:require [clj-http.client :as client])
  (:require [clojure.data.json :as json]))

(defn url [username]
  (str "http://www.reddit.com/user/" username ".json"))

(defn resp [username]
  (client/get (url username)))

(defn body [username]
  (json/read-str (:body (resp username))))

(defn items [username]
  ((body username) "items"))

(defn user-data [username]
  ((items username) 0))

(defn user-key [username data-key]
  ((user-data username) data-key))

(defn display-name [username]
  (user-key username "display_name"))

(defn rep [username]
  (user-key username "reputation"))

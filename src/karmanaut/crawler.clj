(ns karmanaut.crawler
  (:require [karmanaut.client :as client]
            [karmanaut.db :as db]
            [karmanaut.utils :as utils]
            [monger.collection :as mc]))

(defn create-user-map [username]
  ; We're actually making two calls to the Stack Overflow API
  ; here -- should find a way to save the data from one call
  ; and re-use it.
  {:username username,
   :display-name (client/display-name username),
   :rep (client/rep username)})

(defn crawl-users [usernames]
  (map create-user-map usernames))

(defn create-user-document [user-map]
  {:_id (:username user-map), :display_name (:display-name user-map)})

(defn create-sample-document [user-map]
  {:user (:username user-map),
   :timestamp (utils/utcnow),
   :reputation (:rep user-map)})

(defn update-user! [user-map]
  (mc/update db/db
             "users"
             {:_id (:username user-map)}
             {:display_name (:display-name user-map)}))

(defn create-sample! [user-map]
  (mc/insert db/db "samples" (create-sample-document user-map)))

(defn update-users! [user-maps]
  (dorun (map update-user! user-maps)))

(defn insert-samples! [user-maps]
  (dorun (map create-sample! user-maps)))

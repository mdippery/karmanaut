(ns karmanaut.crawler
  (:require [karmanaut.client :as client]
            [karmanaut.db :as db]
            [karmanaut.utils :as utils]
            [monger.collection :as mc]))

(defn create-user-map [username]
  ; We're actually making two calls to the Reddit API
  ; here -- should find a way to save the data from one call
  ; and re-use it.
  {:username username,
   :link-karma (client/link-karma username),
   :comment-karma (client/comment-karma username)})

(defn crawl-users [usernames]
  (map create-user-map usernames))

(defn create-user-document [user-map]
  {:_id (:username user-map)})

(defn create-sample-document [user-map]
  (let [hours (utils/hours-since-midnight (utils/utcnow))
        stats {(str "link_karma." hours) (:link-karma user-map),
               (str "comment_karma." hours) (:comment-karma user-map)}]
    {"$set" stats}))

(defn create-query-document [user-map]
  {:user (:username user-map),
   :timestamp (utils/midnight (utils/utcnow))})

(defn create-sample! [user-map]
  (mc/upsert db/db "samples" (create-query-document user-map) (create-sample-document user-map) {:upsert true}))

(defn insert-samples! [user-maps]
  (doseq [u user-maps] (create-sample! u)))

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
  (let [mn (utils/midnight (utils/utcnow))
        secs (utils/seconds-since-midnight (utils/utcnow))
        stats {(str "link_karma." secs) (:link-karma user-map),
               (str "comment_karma." secs) (:comment-karma user-map)}]
    {:user (:username user-map),
     :timestamp mn,
     "$set" stats}))

(defn create-sample! [user-map]
  (let [q {:user (:username user-map),
           :timestamp (utils/midnight (utils/utcnow))}]
    (mc/upsert db/db "samples" q (create-sample-document user-map) {:upsert true})))

(defn insert-samples! [user-maps]
  (dorun (map create-sample! user-maps)))

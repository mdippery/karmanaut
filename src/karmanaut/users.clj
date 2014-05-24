(ns karmanaut.users
  (:require [karmanaut.db :as db]
            [monger.collection :as mc]))

(def ^{:private true} coll "users")

(def subjects
  (let [subject-maps (mc/find-maps db/db coll)]
    (map #(:_id %) subject-maps)))

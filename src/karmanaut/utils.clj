(ns karmanaut.utils
  (:import [java.util Date]))

(defn env [key default]
  (get (System/getenv) key default))

(defn version []
  (-> "project.clj" slurp read-string (nth 2)))

(defn utcnow []
  (Date.))

(defn long-to-date
  "Reddit timestamps are the number of seconds since the
  Unix epoch, in UTC."
  [epoch]
  (Date. (* 1000 (long epoch))))

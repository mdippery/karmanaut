(ns karmanaut.utils
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:import [java.util Calendar
                      Date
                      GregorianCalendar
                      TimeZone]))

(defn env [key default]
  (get (System/getenv) key default))

(defn version []
  (if (.exists (io/as-file "project.clj"))
    (-> "project.clj" slurp read-string (nth 2))
    (-> (eval 'karmanaut.utils) .getPackage .getImplementationVersion)))

(defn utcnow []
  (Date.))

(defn utcnow-midnight []
  (let [tz (TimeZone/getTimeZone "UTC")
        c (GregorianCalendar. tz)]
    (doto c
      (.set Calendar/HOUR_OF_DAY 0)
      (.set Calendar/MINUTE 0)
      (.set Calendar/SECOND 0)
      (.set Calendar/MILLISECOND 0))
    (.getTime c)))

(defn long-to-date
  "Reddit timestamps are the number of seconds since the
  Unix epoch, in UTC."
  [epoch]
  (Date. (* 1000 (long epoch))))

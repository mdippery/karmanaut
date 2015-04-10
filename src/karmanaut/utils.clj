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

(defn midnight [dt]
  "Returns the given datetime at midnight"
  (let [tz (TimeZone/getTimeZone "UTC")
        c (GregorianCalendar. tz)]
    (doto c
      (.setTime dt)
      (.set Calendar/HOUR_OF_DAY 0)
      (.set Calendar/MINUTE 0)
      (.set Calendar/SECOND 0)
      (.set Calendar/MILLISECOND 0))
    (.getTime c)))

(defn seconds-since-epoch [dt]
  "Number of seconds elapsed since the Unix epoch"
  (quot (.getTime dt) 1000))

(defn hours-since-midnight [dt]
  "Number of hours elapsed since midnight"
  (let [mn (midnight dt)
        mnsec (seconds-since-epoch mn)
        dtsec (seconds-since-epoch dt)]
    (quot (- dtsec mnsec) (* 60 60))))

(defn long-to-date
  "Reddit timestamps are the number of seconds since the
  Unix epoch, in UTC."
  [ts]
  (Date. (* 1000 (long ts))))

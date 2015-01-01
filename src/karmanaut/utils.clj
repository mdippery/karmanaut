(ns karmanaut.utils
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:import [java.util Date]))

(defn env [key default]
  (get (System/getenv) key default))

(defn version []
  (if (.exists (io/as-file "project.clj"))
    (-> "project.clj" slurp read-string (nth 2))
    (-> (eval 'karmanaut.utils) .getPackage .getImplementationVersion)))

(defn utcnow []
  (Date.))

(defn long-to-date
  "Reddit timestamps are the number of seconds since the
  Unix epoch, in UTC."
  [epoch]
  (Date. (* 1000 (long epoch))))

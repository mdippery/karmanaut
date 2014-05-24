(ns karmanaut.utils-test
  (:require [clojure.test :refer :all]
            [karmanaut.utils :refer :all])
  (:import [java.text SimpleDateFormat]
           [java.util TimeZone]))

(deftest test-env
  (is (instance? String (env "HOME" "/Users/mdippery"))))

(deftest test-long-to-date
  (let [expected "2008-03-31T22:55:26.000Z"
        actual (long-to-date 1207004126)
        formatter (SimpleDateFormat. "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")]
    (doto formatter
      (.setTimeZone (TimeZone/getTimeZone "UTC")))
    (is (= expected (.format formatter actual)))))

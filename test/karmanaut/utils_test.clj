(ns karmanaut.utils-test
  (:require [clojure.test :refer :all]
            [karmanaut.utils :refer :all]))

(deftest test-env
  (is (instance? String (env "HOME" "/Users/mdippery"))))

(deftest test-long-to-date
  (let [expected "2008-03-31T22:55:26.000-00:00"
        actual (long-to-date 1207004126)]
    (is (= expected (str actual)))))

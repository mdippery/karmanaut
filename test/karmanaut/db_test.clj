(ns karmanaut.db-test
  (:require [clojure.test :refer :all]
            [karmanaut.db :refer :all]))

(deftest test-db-url
  (is (= "mongodb://localhost:27017/karmanaut" db-url)))

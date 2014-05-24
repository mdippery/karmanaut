(ns karmanaut.utils-test
  (:require [clojure.test :refer :all]
            [karmanaut.utils :refer :all]))

(deftest test-env
  (is (instance? String (env "HOME" "/Users/mdippery"))))

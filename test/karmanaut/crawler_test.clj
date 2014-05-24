(ns karmanaut.crawler-test
  (:require [clojure.test :refer :all]
            [karmanaut.crawler :refer :all]))

(def ^{:private true} user-map {:username "mipadi",
                                :link-karma 4431,
                                :comment-karma 26312})

(deftest test-create-user-map
  (let [user-map (create-user-map "mipadi")]
    (is (= "mipadi" (:username user-map)))))

(deftest test-create-user-document
  (is (= {:_id "mipadi"} (create-user-document user-map))))

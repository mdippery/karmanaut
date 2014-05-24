(ns karmanaut.crawler-test
  (:require [clojure.test :refer :all]
            [karmanaut.crawler :refer :all]))

(def ^{:private true} user-map {:username "mipadi",
                                :display-name "mipadi",
                                :rep 100000})

(deftest test-create-user-map
  (let [user-map (create-user-map "mipadi")]
    (is (= "mipadi" (:username user-map)))
    (is (= "mipadi" (:display-name user-map)))))

(deftest test-create-user-document
  (is (= {:_id "mipadi", :display_name "mipadi"}
         (create-user-document user-map))))

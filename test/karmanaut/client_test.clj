(ns karmanaut.client-test
  (:require [clojure.test :refer :all]
            [karmanaut.client :refer :all]))

(deftest test-url
  (is (= "http://www.reddit.com/user/mipadi.json")))

(deftest test-resp
  (is (instance? clojure.lang.PersistentArrayMap (resp "mipadi"))))

(deftest test-body
  (is (instance? clojure.lang.PersistentArrayMap (body "mipadi"))))

(deftest test-items
  (is (instance? clojure.lang.PersistentVector (items "mipadi"))))

(deftest test-user-data
  (is (instance? clojure.lang.PersistentHashMap (user-data "mipadi"))))

(deftest test-user-key
  (is (= "mipadi" (user-key "mipadi" "user_id"))))

(deftest test-display-name
  (is (= "mipadi" (display-name "mipadi"))))

(deftest test-reputation
  (is (instance? Long (rep "mipadi"))))

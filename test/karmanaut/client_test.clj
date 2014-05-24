(ns karmanaut.client-test
  (:require [clojure.test :refer :all]
            [karmanaut.client :refer :all]))

(deftest test-url
  (is (= "http://www.reddit.com/user/mipadi.json")))

(deftest test-resp
  (is (instance? clojure.lang.PersistentArrayMap (resp "mipadi"))))

(deftest test-body
  (is (instance? clojure.lang.PersistentArrayMap (body "mipadi"))))

(deftest test-user-data
  (is (instance? clojure.lang.PersistentHashMap (user-data "mipadi"))))

(deftest test-user-key
  (is (= "34agu" (user-key "mipadi" "id"))))

(deftest test-link-karma
  (is (instance? Long (link-karma "mipadi"))))

(deftest test-comment-karma
  (is (instance? Long (comment-karma "mipadi"))))

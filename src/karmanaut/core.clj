(ns karmanaut.core
  (:require [karmanaut.users :as users]
            [karmanaut.crawler :as crawler])
  (:gen-class))

(defn -main [& args]
  (-> users/subjects
      crawler/crawl-users
      crawler/insert-samples!))

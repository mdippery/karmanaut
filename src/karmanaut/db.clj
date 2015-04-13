(ns karmanaut.db
  (:require [karmanaut.utils :as utils]
            [monger.core :as mg]))


(def db-url (utils/env "CHAMELEON_MONGODB_URL" "mongodb://localhost:27017/karmanaut"))

(def db
  (-> db-url
      mg/connect-via-uri
      :db))

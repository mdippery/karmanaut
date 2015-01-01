(def project-version "1.0.0")

(defproject karmanaut project-version
  :description "Takes samples of Reddit reputation over time"
  :url "https://github.com/mdippery/karmanaut"
  :license {:name "3-Clause BSD"
            :url "http://opensource.org/licenses/BSD-3-Clause"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "0.9.1"]
                 [org.clojure/data.json "0.2.4"]
                 [com.novemberain/monger "2.0.0-rc1"]]
  :main ^:skip-aot karmanaut.core
  :target-path "target/%s"
  :jar-name "karmanut.jar"
  :uberjar-name "karmanaut-standalone.jar"
  :manifest {"Implementation-Version" ~project-version}
  :profiles {:uberjar {:aot :all}})

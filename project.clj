(defproject karmanaut "1.0.0"
  :description "Takes samples of Reddit reputation over time"
  :url "https://github.com/mdippery/karmanaut"
  :license {:name "3-Clause BSD"
            :url "http://opensource.org/licenses/BSD-3-Clause"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "0.6.3"]
                 [org.clojure/data.json "0.2.4"]
                 [com.novemberain/monger "2.0.0-rc1"]]
  :main ^:skip-aot karmanaut.core
  :target-path "target/%s"
  :jar-name "karmanut.jar"
  :uberjar-name "karmanaut-standalone.jar"
  :profiles {:uberjar {:aot :all}})

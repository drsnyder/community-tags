(ns user
  (:require [community-tags.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [community-tags.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'community-tags.core/repl-server))

(defn stop []
  (mount/stop-except #'community-tags.core/repl-server))

(defn restart []
  (stop)
  (start))



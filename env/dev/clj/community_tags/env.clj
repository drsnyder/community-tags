(ns community-tags.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [community-tags.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[community-tags started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[community-tags has shut down successfully]=-"))
   :middleware wrap-dev})

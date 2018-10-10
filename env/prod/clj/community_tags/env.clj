(ns community-tags.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[community-tags started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[community-tags has shut down successfully]=-"))
   :middleware identity})

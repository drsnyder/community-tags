(ns community-tags.db.core
  (:require [mount.core :refer [defstate]]
            [community-tags.config :refer [env]]
            [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.cypher :as cy]))

(defstate ^:dynamic *db*
  :start (nr/connect (env :neo4j-url)))

(defn tidy-community-tags [tags]
  (map #(-> {}
            (assoc :community (get % "c.name"))
            (assoc :tag (get % "t.name"))
            (assoc :values (get % "r.values")))
       tags))

(defn community-tag-query [community]
  (format "MATCH (c:Community {name: '%s'})-[r:HAS_TAG]->(t:Tag) RETURN c.name, r.values, t.name" community))

(defn tag-community-query [tag]
  (format "MATCH (c:Community)-[r:HAS_TAG]->(t:Tag {name: '%s'}) RETURN c.name, r.values, t.name" tag))

(defn community-tags [community]
  (tidy-community-tags
    (cy/tquery *db* (community-tag-query community))))

(defn tag-communities [tag]
  (map #(get % :community) 
    (tidy-community-tags 
         (cy/tquery *db* (tag-community-query tag)))))

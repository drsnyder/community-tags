(ns community-tags.routes.home
  (:require [community-tags.layout :as layout]
            [community-tags.db.core :as db]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defn community-tags-route [name]
  (db/community-tags name))

(defn tag-communities-route [name]
  (db/tag-communities name))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/community/:name/tags" [name] {:body (community-tags-route name)})
  (GET "/tag/:name/communities" [name] {:body (tag-communities-route name)})
  (GET "/about" [] (about-page)))


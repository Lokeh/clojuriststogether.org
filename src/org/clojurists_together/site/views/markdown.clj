(ns org.clojurists-together.site.views.markdown
  (:require [org.clojurists-together.site.views.common :as common]
            [markdown.core :as md]
            [hiccup.util]
            [compojure.core :as compojure :refer [GET]]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn markdown-view [filename]
  (when-let [md (some-> (io/resource (str "markdown/" filename))
                        (slurp)
                        (md/md-to-html-string-with-meta
                          :inhibit-separator "%"
                          :heading-anchors true))]
    (let [title (str/trim (first (:title (:metadata md))))
          page-class (str/replace filename #".md$" "")]
      (common/template title
                       [:main.markdown-page {:class page-class} [:h1.page-title title]
                        (hiccup.util/raw-string (:html md))]))))


(defn routes []
  (compojure/routes
    (GET "/companies/" [] (markdown-view "companies.md"))
    (GET "/contact/" [] (markdown-view "contact.md"))
    (GET "/developers/" [] (markdown-view "developers.md"))
    (GET "/faq/" [] (markdown-view "faq.md"))
    (GET "/docs/paypal-update/" [] (markdown-view "docs/paypal-update.md"))
    (GET "/members/" [] (markdown-view "members.md"))
    (GET "/open-source/" [] (markdown-view "open-source.md"))
    (GET "/beyond/" [] (markdown-view "beyond.md"))
    (GET "/projects/" [] (markdown-view "projects.md"))
    (GET "/jobs/" [] (markdown-view "jobs.md"))
    (GET "/team/" [] (markdown-view "team.md"))
    (GET "/transparency/" [] (markdown-view "transparency.md"))
    (GET "/news/:id/" [id] (markdown-view (str "news/" id ".md")))
    (GET "/news/" [] (markdown-view "news.md"))))

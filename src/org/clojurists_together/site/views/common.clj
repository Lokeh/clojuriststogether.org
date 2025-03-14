(ns org.clojurists-together.site.views.common
  (:require [org.clojurists-together.site.utils :refer [html5]]
            [hiccup.page :refer [include-css]]))

(defn common-head []
  (list
    [:meta {:charset "utf-8"}]
    [:meta {:name "description" :content "Funding critical Clojure open source software"}]
    [:meta {:name "keywords" :content "clojure, dependencies, version, up to date version, out of date version"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
    [:meta {:name "author" :content "Deps"}]
    (include-css "/app.css")
    [:link {:rel "shortcut icon" :href "/favicon.ico"}]
    [:link {:rel "apple-touch-icon" :sizes "180x180" :href "/apple-touch-icon.png"}]
    [:link {:rel "icon" :type "image/png" :sizes "32x32" :href "/favicon-32x32.png"}]
    [:link {:rel "icon" :type "image/png" :sizes "16x16" :href "/favicon-16x16.png"}]
    [:link {:rel "mask-icon" :href "/safari-pinned-tab.svg":color "#5bbad5"}]))

(defn add-spaces [list]
  (vec (cons (first list)
             (interpose "\n" (rest list)))))

(defn header []
  [:header
   [:a {:href "/"}
    [:img.header-logo {:src "/header-logo.png"}]
    #_[:h1.logo "Clojurists Together"]]
   (add-spaces
     [:ul
      [:li [:a {:href "/open-source/"} "OSS Projects"]]
      [:li [:a {:href "/companies/"} "Companies"]]
      [:li [:a {:href "/developers/"} "Developers"]]
      [:li [:a {:href "/members/"} "Members"]]
      [:li [:a {:href "/news/"} "News"]]
      [:li [:a {:href "/projects/"} "Projects"]]
      [:li [:a {:href "/jobs/"} "Jobs"]]])])

(defn common-footer []
  [:footer
   [:hr]
   [:div {:style "margin: 0 auto; max-width: 1200px;"}
    [:a {:href "https://sfconservancy.org/supporter"}
     [:img {:style "width: 100%;"
            :src   "https://sfconservancy.org/img/banners/2018-project.jpg"
            :alt   "Conservancy helps make our work possible. Please donate to them today to support community-driven free software projects!"}]]]
   (add-spaces
     [:ul
      [:li [:a {:href "/open-source/"} "Open Source Projects"]]
      [:li [:a {:href "/companies/"} "Companies"]]
      [:li [:a {:href "/developers/"} "Developers"]]
      [:li [:a {:href "/members/"} "Members"]]
      [:li [:a {:href "/news/"} "News"]]
      [:li [:a {:href "/projects/"} "Projects"]]
      [:li [:a {:href "/jobs/"} "Jobs"]]
      [:li [:a {:href "/transparency/"} "Transparency"]]
      [:li [:a {:href "/beyond/"} "Beyond Clojurists Together"]]
      [:li [:a {:href "/faq/"} "FAQ"]]
      [:li [:a {:href "/team/"} "Team"]]
      [:li [:a {:href "/contact/"} "Contact"]]
      [:li [:a {:href "https://github.com/clojurists-together/clojuriststogether.org"} "Source"]]
      ])])



(defn template [title & body]
  (html5 {:lang "en"}
         [:head
          [:title (str title " - Clojurists Together")]
          (common-head)]
         [:body.site
          (header)
          body
          (common-footer)]))

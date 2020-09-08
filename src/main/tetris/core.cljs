(ns tetris.core
  (:require [reagent.core :as r]
            [reagent.dom :as rd]
            ["react" :refer [useState]]))

(defn my-incrementer []
  (let [[s ss] (useState 0)]
    [:div
      s
      [:button {:on-click #(ss (inc s))} "Increase"]]))

(defn some-component []
    [:div
     [:h3 "I am superman!"]
     [my-incrementer]])

(defn ^:dev/after-load mountit []
  (rd/render [some-component]
            (js/document.querySelector "#app")
            (r/create-compiler {:function-components true})))

(comment
  (mountit))
(ns clj.day09
  (:require [clojure.string :as str]))

(defn sliding-window [numbers length] (partition (inc length) 1 numbers))

(defn no-addends? [pred numbers] (empty? (for [a numbers b numbers :when (= pred (+ a b))] pred)))

(defn find-first-without-addend [numbers length] (last (first (filter #(no-addends? (last %) %) (sliding-window numbers length)))))
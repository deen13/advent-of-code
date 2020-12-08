(ns clj.day06
  (:require [clojure.string :as str]))

(defn not-blank [s] (not (= '("") s)))
(defn chunked [s] (filter not-blank (partition-by clojure.string/blank? s)))

(defn count-group-anyone [x] (count (frequencies x)))
(defn count-anyone [g] (reduce + (map count-group-anyone (map clojure.string/join (chunked g)))))

(defn count-group-everyone [n]
  (let [groups (apply merge-with + (vec n)) max (count n)]
    (filter (fn [[_ v]] (= max v)) groups)))
(defn count-everyone [g] (reduce + (map count (map count-group-everyone (map #(map frequencies %) (chunked g))))))

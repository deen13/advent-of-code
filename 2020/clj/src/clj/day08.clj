(ns clj.day08
  (:require [clojure.string :as str]))

(defn split-instruction-parameter [line]
  (let [[code param] (str/split line #" ")]
    [code (Integer/parseInt param)]))

(defn evaluate [code step acc]
  (let [[code value] (nth code step)]
    (cond
      (= code "acc") [(inc step) (+ acc value)]
      (= code "jmp") [(+ step value) acc]
      (= code "nop") [(inc step) acc])))

(defn run [code]
  (loop [step 0 acc 0 visited #{}]
    (cond
      (contains? visited step) [acc]
      (>= step (count code)) [acc]
      :else (let [[next-step new-acc] (evaluate code step acc)]
              (recur next-step new-acc (conj visited step))))))

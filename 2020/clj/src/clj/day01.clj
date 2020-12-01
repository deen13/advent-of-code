(ns clj.day01)

(defn is-2020? [& args] (= 2020 (apply + args)))

(defn find-tuple-product [lines] (reduce * (first (for [a lines b lines :when (is-2020? a b)] [a b]))))

(defn find-triple-product [lines] (reduce * (first (for [a lines b lines c lines :when (is-2020? a b c)] [a b c]))))

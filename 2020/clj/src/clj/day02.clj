(ns clj.day02)

(defn parse-line [line]
  (let [[min max char _ text] (clojure.string/split line #"[ \- :]")]
    [(Integer/parseInt min) (Integer/parseInt max) (first char) text]))

(defn matches-count [[min max char text]] (<= min (get (frequencies text) char 0) max))

(defn matches-policy [[one two char text]]
  (let [c1 (nth text (dec one))
        c2 (nth text (dec two))]
    (and
      (or (= c1 char) (= c2 char))
      (not= c1 c2))))

(defn count-matches [l p] (count (filter p (map parse-line l))))

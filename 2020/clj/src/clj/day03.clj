(ns clj.day03)

(defn- collector [lines [dx dy]]
  (count
    (filter
      #(= % \#)
      (map-indexed
        (fn [i l] (nth l (mod (* dx i) 31)))
        (take-nth dy lines)))))

(defn find-linear [lines]
  (collector lines [3 1]))

(defn find-alternating [lines]
  (apply *
         (for [mp [[1 1] [3 1] [5 1] [7 1] [1 2]]]
           (collector lines mp))))

(ns clj.day05-test
  (:require [clojure.test :refer :all]
            [clj.day05 :refer :all]))

(def entries (clojure.string/split-lines (slurp "resources/day05.input")))

(deftest helpers
  (testing "binary conversion"
    (is (= "1000110101" (to-binary "BFFFBBFRLR")))
    (is (= 565 (parse-binary "1000110101")))))

(deftest part1
  (testing "find highest number"
    (is (= 864 (find-max entries)))))



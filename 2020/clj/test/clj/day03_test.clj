(ns clj.day03-test
  (:require [clojure.test :refer :all]
            [clj.day03 :refer :all]))

(def entries (clojure.string/split-lines (slurp "resources/day03.input")))

(deftest part1
  (testing "find trees in linear pattern"
    (is (= 209 (find-linear entries)))))

(deftest part2
  (testing "find trees in alternating pattern"
    (is (= 1574890240 (find-alternating entries)))))


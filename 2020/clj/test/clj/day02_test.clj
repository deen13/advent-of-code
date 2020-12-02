(ns clj.day02-test
  (:require [clojure.test :refer :all]
            [clj.day02 :refer :all]))

(def entries (clojure.string/split-lines (slurp "resources/day02.input")))

(deftest helper
  (testing "extract parts of string"
    (is (= false (matches-count '[1 2 \x "xxxxwxxxxxxx"])))
    (is (= true (matches-count '[11 12 \x "xxxxwxxxxxxx"])))
    (is (= true (matches-policy '[1 3 \x "xxbxwxxxxxxx"])))
    (is (= '[11 12 \x "xxxxwxxxxxxx"] (parse-line "11-12 x: xxxxwxxxxxxx")))))

(deftest part1
  (testing "check if a password matches the count"
    (is (= 625 (count-matches entries matches-count)))))

(deftest part2
  (testing "check if a password matches the policy"
    (is (= 391 (count-matches entries matches-policy)))))


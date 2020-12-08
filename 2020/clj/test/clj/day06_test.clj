(ns clj.day06-test
  (:require [clojure.test :refer :all]
            [clj.day06 :refer :all]))

(def entries (clojure.string/split-lines (slurp "resources/day06.input")))
(def entries-small (clojure.string/split-lines (slurp "resources/day06-small.input")))

(deftest helpers
  (testing "count a standalone group"
    (is (= 3 (count-group-anyone "abac")))))

(deftest part1
  (testing "count anyone"
    (is (= 6683 (count-anyone entries)))))


(deftest part2
  (testing "count everyone"
    (is (= 6 (count-everyone entries-small)))
    (is (= 6 (count-everyone entries)))))

(ns clj.day09-test
  (:require [clojure.test :refer :all]
            [clj.day09 :refer :all]))

(def entries (map #(Long/parseLong %) (clojure.string/split-lines (slurp "resources/day09.input"))))
(def entries-small (map #(Integer/parseInt %) (clojure.string/split-lines (slurp "resources/day09-small.input"))))

(deftest helpers
  (testing "sliding-window"
    (is (= '((1 2 3) (2 3 4))
           (sliding-window '[1 2 3 4] 3))))
  (testing "no-addends"
    (is (= false (no-addends? 3 '(1 2))))
    (is (= true (no-addends? 5 '(1 2))))))

(deftest part1
  (testing
    (is (= 100 (find-first-without-addend '(1 2 3 4 5 100) 5)))
    (is (= 127 (find-first-without-addend entries-small 5)))
    (is (= 100 (find-first-without-addend entries 25)))))

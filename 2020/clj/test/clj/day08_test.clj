(ns clj.day08-test
  (:require [clojure.test :refer :all]
            [clj.day08 :refer :all]))

(def entries (clojure.string/split-lines (slurp "resources/day08.input")))
(def entries-small (clojure.string/split-lines (slurp "resources/day08-small.input")))

(deftest helpers
  (testing "split line into instruction and parameter"
    (is (= ["nop" +0] (split-instruction-parameter "nop +0"))))
  (testing "evaluate instructions"
    (is (= [1 2] (evaluate [["acc" +2]] 0 0)))
    (is (= [1 0] (evaluate [["nop" +2]] 0 0)))
    (is (= [3 0] (evaluate [["jmp" +3]] 0 0)))))

(deftest part1
  (testing "part one with small and real input"
    (is (= [5] (run (map split-instruction-parameter entries-small))))
    (is (= [1451] (run (map split-instruction-parameter entries))))))

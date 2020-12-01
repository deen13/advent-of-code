(ns clj.day01-test
  (:require [clojure.test :refer :all]
            [clj.day01 :refer :all]
            [clojure.string :as str]))

(def lines (map read-string (str/split-lines (slurp "resources/day01.input"))))

(deftest helper
  (testing "check if sum of numbers eq 2020"
    (is (= false (is-2020? 2000 19)))
    (is (= true (is-2020? 2000 20)))
    (is (= true (is-2020? 2000 10 10)))))

(deftest part-1
  (testing "is sum of a and b 2020"
    (is (= 514579 (find-tuple-product [1721 979 366 299 675 1456])))
    (is (= 876459 (find-tuple-product lines)))))

(deftest part-2
  (testing "is sum of a, b and c 2020"
    (is (= 241861950 (find-triple-product [1721 979 366 299 675 1456])))
    (is (= 116168640 (find-triple-product lines)))))


(ns clj.day05)

(defn to-binary [s] (clojure.string/replace s #"[B,R]|[F,L]" {"B" "1" "R" "1" "F" "0" "L" "0"}))

(defn parse-binary [^String b] (BigInteger. b 2))

(defn find-max [s] (apply max (map parse-binary (map to-binary s))))

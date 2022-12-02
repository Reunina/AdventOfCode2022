(ns adventOfCode2022.day01
  (:require
   [clojure.string :as string]
   [clojure.java.io :refer [resource]]))

(defn preparedata [data]
  (->> data
       (map #(string/split % #"\n"))
       (mapv #(reduce + (map (fn [v] (Integer/parseInt v)) %))))) 

(defn read-input [file regexp]
  (-> (resource file)
      slurp
      (string/split  regexp)))

(defn part-01 [file]
  (let [raw-data (read-input file #"\n\n")
        data (preparedata raw-data)]
    (apply max data)))

(defn part-02 [file]
  (let [raw-data (read-input file #"\n\n")
        data (preparedata raw-data)]
    (reduce + (take 3   (reverse   (sort data))))))


(=  45000  (part-02  "inputs/input_day01_test.txt"))
(=  197400  (part-02  "inputs/input_day01.txt"))

(=  24000  (part-01  "inputs/input_day01_test.txt"))
(=  69206  (part-01  "inputs/input_day01.txt"))


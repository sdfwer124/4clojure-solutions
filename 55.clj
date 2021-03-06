;; 55 Count Occurrences

OBJECTIVE:

Return a map containing the number of occurences of each distinct item in a sequence without using frequencies:

user=> (__ [1 1 2 3 2 1 1])
{1 4, 2 2, 3 1}

FUNCTION:

reduce #(assoc % %2 (inc (% %2 0))) {}

(defn freqs [s]
  (loop [s s freq-map {}]
    (if (empty? s)
      freq-map
      (recur (rest s)
        (assoc freq-map (first s) (inc (get freq-map (first s) 0)))))))

BREAKDOWN AND PROOF:

user=> (freqs [1 1 2 3 2 1 1])
{1 4, 2 2, 3 1}

(loop [s s freq-map {}]

(loop [s [1 1 2 3 2 1 1] freq-map {}]

=> (empty? [1 1 2 3 2 1 1])
false

=> (rest [1 1 2 3 2 1 1])
(1 2 3 2 1 1)

=> (first [1 1 2 3 2 1 1])
1

=> (get {} 1 0)
0

=> (inc 0)
1

=> (assoc {} 1 1)
{1 1}

(recur '(1 2 3 2 1 1) {1 1})

=> (rest '(1 2 3 2 1 1))
(2 3 2 1 1)
=> (first '(1 2 3 2 1 1))
1
=> (get {1 1} 1 0)
1
=> (inc 1)
2
=> (assoc {1 1} 1 2)
{1 2}

recur

=> (rest '(2 3 2 1 1))
(3 2 1 1)
=> (first '(2 3 2 1 1))
2
=> (get {1 2} 2 0)
0
=> (inc 0)
1

(assoc freq-map (first s) (inc (get freq-map (first s) 0)
=> (assoc {1 2} 2 1)
{1 2, 2 1}

recur...

=> (rest '(3 2 1 1))
(2 1 1)
=> (first '(3 2 1 1))
3
=> (get {1 2, 2 1} 3 0)
0
(assoc freq-map (first s) (inc (get freq-map (first s) 0)
=> (assoc {1 2, 2 1} 3 1)
{1 2, 2 1, 3 1}

recur...
=> (rest '(2 1 1))
(1 1)
=> (first '(2 1 1))
2
(get freq-map (first s) 0)
=> (get {1 2, 2 1 3 1} 2 0)
1
=> (assoc {1 2, 2 1 3 1} 2 2)
{1 2, 2 2, 3 1}
=> (rest '(1 1))
(1)
=> (first '(1 1))
1
=> (get {1 2, 2 2 3 1} 1 0)
2
(assoc {1 2, 2 2 3 1} 1 3)
=> (assoc {1 2, 2 2 3 1} 1 3)
{1 3, 2 2, 3 1}
=> (rest '(1))
()
=> (first '(1))
1
=> (get {1 3, 2 2, 3 1} 1 0)
3
=> (assoc {1 2, 2 2 3 1} 1 4)
{1 4, 2 2, 3 1}

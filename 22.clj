{:_id 22 :restricted ["count"], :title "Count a Sequence" :tests ["(= (__ '(1 2 3 3 1)) 5)" "(= (__ \"Hello World\") 11)" "(= (__ [[1 2] [3 4] [5 6]]) 3)" "(= (__ '(13)) 1)" "(= (__ '(:a :b :c)) 3)"], :description "Write a function which returns the total number of elements in a sequence.", :tags ["easy" "seqs" "core-functions"]}


user=> (#(loop [x % acc 0]
           (if (empty? x)
                acc
               (recur (rest x)
                      (inc acc))))
[1 2 3 3 1])
5

; name func

(defn count-elements [s]
  (loop [x s acc 0]
    (if (empty? x)
         acc
        (recur (rest x) (inc acc)))))

user=> (count-elements [1 2 3 3 1])
5

; just the body, w/ args:

(loop [x [1 2 3 3 1] acc 0]
  (if (empty? [1 2 3 3 1])
    acc
    (recur (rest [1 2 3 3 1])
           (inc acc))))

user=> (empty? [1 2 3 3 1])
false

; so we recur with:
=> (rest [1 2 3 3 1])
(2 3 3 1)
; and acc is incremented to 1.
=> (empty? '(2 3 3 1))
false
=> (rest '(2 3 3 1))
(3 3 1)
; acc = 2
=> (empty? '(3 3 1))
false
=> (rest '(3 3 1))
(3 1)
; acc = 3
=> (empty? '(3 1))
false
=> (rest '(3 1))
(1)
; acc = 4
=> (empty? '(1))
false
=> (rest '(1))
()
; acc = 5
=> (empty? '())
true
; so instead of recurring,
; we return acc, which is 5

{:_id 19 :restricted ["last"], :title "Last Element"
 :tests [
 "(= (__ [1 2 3 4 5]) 5)"
 "(= (__ '(5 4 3)) 3)"
 "(= (__ [\"b\" \"c\" \"d\"]) \"d\")"]
:description "Write a function which returns the last element in a sequence."}

user=> (source last)
(defn last [s]
        (if (next s)
          (recur (next s))
          (first s)))

user=> (__ [1 2 3 4 5])
5

#(if (next %)
     (recur (next %))
     (first %))

user=> (#(if (next %)
             (recur (next %))
             (first %))
[1 2 3 4 5])
5

(defn get-last-item [coll]
  (if (next coll)
    (recur (next coll))
    (first coll)))

(get-last-item [1 2 3 4 5])

(if (next coll)

user=> (next [1 2 3 4 5])
(2 3 4 5)
user=> (next '(2 3 4 5))
(3 4 5)
user=> (next '(3 4 5))
(4 5)
user=> (next '(4 5))
(5)
user=> (next [5])
nil

(if (next coll)

; This form is asking, "Is there something next?", which is another way of asking, "Is it the last one?"
; If the answer is "Yes, there's more", the function returns true which makes the if call recur,
; so we do it again with the rest of the coll by calling next on it:

(recur (next coll))

; until we get to:
(next [5])
; which returns:
nil

; and that means we call
(first [5])
; which returns our final answer,
5

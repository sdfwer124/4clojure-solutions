;; 105 Identify keys and values [m]

Takes seq of keys and vals, returns a map such that
each key in the map is a keyword,
and the value is a seq of all the numbers (if any)
between it and the next keyword in the sequence.

(defn key-val [c]
  (loop [[f & r] c, kvm {}]
    (if (nil? f)
      kvm
     (let [[vs l] (split-with (complement keyword?) r)]
       (recur l (assoc kvm f vs))))))
#'user/key-val
user> (key-val [])
{}
user> (key-val [:a 1])
{:a (1)}
user> (key-val [:a 1 :b 2])
{:a (1), :b (2)}
user> (key-val [:a 1 2 3 :b :c 4])
{:a (1 2 3), :b (), :c (4)}

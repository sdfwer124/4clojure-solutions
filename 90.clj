;; 90 Cartesian Product of two sets

((fn [s1 s2] (set (for [a s1 b s2] [a b])))
 #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
;;=> #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}

#(set (for [a % b %2] [a b]))

((fn [s1 s2] (set (for [a s1 b s2] [a b]))) #{1 2 3} #{4 5})
;;=> #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}

(count ((fn [s1 s2] (set (for [a s1 b s2] [a b]))) (into #{} (range 10)) (into #{} (range 30))))
;;=> 300

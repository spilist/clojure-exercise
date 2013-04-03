(ns four_boxes
  (:gen-class))

(defn -main [& args]
  (println "Hello world"))

(defn recArea [x1 y1 x2 y2]
  (* (- x2 x1) (- y2 y1)))

(defn p1k3 [x1a y1a x2a y2a x1b y1b x2b y2b] 
  (and (< x1b x1a) (<= y1a y1b y2a)))

(defn p1k6 [x1a y1a x2a y2a x1b y1b x2b y2b]
  (and (< x1b x1a) (< y1b y1a)))

(defn p1k7 [x1a y1a x2a y2a x1b y1b x2b y2b] 
  (and (<= x1a x1b x2a) (< y1b y1a)))

(defn p1k4 [x1a y1a x2a y2a x1b y1b x2b y2b] 
  (and (<= x1a x1b x2a) (<= y1a y1b y2a)))

(defn p2k4 [x1a y1a x2a y2a x1b y1b x2b y2b] 
  (and (<= x1a x2b x2a) (<= y1a y2b y2a)))

(defn p2k1 [x1a y1a x2a y2a x1b y1b x2b y2b] 
  (and (<= x1a x2b x2a) (< y2a y2b)))

(defn p2k2 [x1a y1a x2a y2a x1b y1b x2b y2b] 
  (and (< x2a x2b) (< y2a y2b)))

(defn p2k5 [x1a y1a x2a y2a x1b y1b x2b y2b] 
  (and (< x2a x2b) (<= y1a y2b y2a)))

(defn rec2AreaOverlap [x1a y1a x2a y2a x1b y1b x2b y2b]
  (cond
   (and (p1k3 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k1 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1a y1b x2b y2a)
   (and (p1k3 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k2 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1a y1b x2a y2a)
   (and (p1k3 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k4 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1a y1b x2b y2b)
   (and (p1k3 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k5 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1a y1b x2a y2b)

   (and (p1k4 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k1 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1b y1b x2b y2a)
   (and (p1k4 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k2 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1b y1b x2a y2a)
   (and (p1k4 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k4 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1b y1b x2b y2b)
   (and (p1k4 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k5 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1b y1b x2a y2b)

   (and (p1k6 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k1 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1a y1a x2b y2a)
   (and (p1k6 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k2 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1a y1a x2a y2a)
   (and (p1k6 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k4 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1a y1a x2b y2b)
   (and (p1k6 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k5 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1a y1a x2a y2b)

   (and (p1k7 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k1 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1b y1a x2b y2a)
   (and (p1k7 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k2 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1b y1a x2a y2a)
   (and (p1k7 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k4 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1b y1a x2b y2b)
   (and (p1k7 x1a y1a x2a y2a x1b y1b x2b y2b) (p2k5 x1a y1a x2a y2a x1b y1b x2b y2b)) (recArea x1b y1a x2a y2b)
   :else 0
  ))

(defn rec2Area [x1a y1a x2a y2a x1b y1b x2b y2b]
  (- (+ (recArea x1a y1a x2a y2a) (recArea x1b y1b x2b y2b))
     (rec2AreaOverlap x1a y1a x2a y2a x1b y1b x2b y2b)))
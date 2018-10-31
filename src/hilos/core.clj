(ns hilos.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

  (defn -main

    [& args]

    (foo "ejecutando")

    

    ; (defn factorial [n]
    ;   (apply * (map bigint (range 1 (inc n))))
    ; )
  

    ; (def result (future (Thread/sleep 3000) (factorial 100)))
      

    ; (let [result (future (Thread/sleep 3000) (+ 1 1))]
    ;   (println "Resultado: " @result)
    ;   (println "3 segundos antes")
    ; )
    ; (println (deref result))

    (defn deficiente [n]
      (def lista [])
      (loop [x (- n 1)]
        (when (> x 0)
          (conj lista x)
          (if (= (mod n x) 0)
            (def lista (conj lista x))
          )
          (recur (- x 1))
        )
      )
      (println lista)
      (if (< n (reduce + lista))(println "abudante")(println "deficiente"))
      (reduce + lista)
    )
    
    (def result (future (deficiente 18)))

    (println (deref result))


      


  )
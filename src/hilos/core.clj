;;Luis Alejandro Peña Montoya A01650535
;;Ana Karen Campos Garcia     A01335037

(ns hilos.core)

(defn -main

  [& args]


  (defn deficiente [n]
    (println "Ejercicio 1")
    (def lista [])
    (loop [x (- n 1)]
      (when (> x 0)
        (conj lista x)
        (if (= (mod n x) 0)
          (def lista (conj lista x)))

        (recur (- x 1))))

    (println lista)
    (if (< n (reduce + lista))(println "Deficiente"))
    (reduce + lista))
  (defn abundante [n]
    (println "Ejercicio 1")
    (def lista [])
    (loop [x (- n 1)]
      (when (> x 0)
        (conj lista x)
        (if (= (mod n x) 0)
          (def lista (conj lista x)))

        (recur (- x 1))))

    (println lista)
    (if (> n (reduce + lista))(println "Abundante"))
    (reduce + lista)
  )

  (def result (future (deficiente (bigint (rand-int 30)))))
  (def result2 (future (deficiente (bigint (rand-int 30)))))
  (def result3 (future (deficiente (bigint (rand-int 30)))))
  (def result4 (future (deficiente (bigint (rand-int 30)))))
  (def result5 (future (deficiente (bigint (rand-int 30)))))
  (def result6 (future (deficiente (bigint (rand-int 30)))))
  (def result7 (future (deficiente (bigint (rand-int 30)))))
  (def result8 (future (deficiente (bigint (rand-int 30)))))
  (def result9 (future (deficiente (bigint (rand-int 30)))))
  (def result10 (future (deficiente (bigint (rand-int 30)))))
  (def result11 (future (abundante (bigint (rand-int 30)))))
  (def result12 (future (abundante (bigint (rand-int 30)))))
  (def result13 (future (abundante (bigint (rand-int 30)))))
  (def result14 (future (abundante (bigint (rand-int 30)))))
  (def result15 (future (abundante (bigint (rand-int 30)))))
  (def result16 (future (abundante (bigint (rand-int 30)))))
  (def result17 (future (abundante (bigint (rand-int 30)))))
  (def result18 (future (abundante (bigint (rand-int 30)))))
  (def result19 (future (abundante (bigint (rand-int 30)))))
  (def result20 (future (abundante (bigint (rand-int 30)))))
  

  (println (deref result))
  (println (deref result2))
  (println (deref result3))
  (println (deref result4))
  (println (deref result5))
  (println (deref result6))
  (println (deref result7))
  (println (deref result8))
  (println (deref result9))
  (println (deref result10))
  (println (deref result11))
  (println (deref result12))
  (println (deref result13))
  (println (deref result14))
  (println (deref result15))
  (println (deref result16))
  (println (deref result17))
  (println (deref result18))
  (println (deref result19))
  (println (deref result20))


  (defn google [palabra]
    (str "https://www.google.com/search?source=hp&ei=" palabra))

  (defn bing [palabra]
    (str "https://www.bing.com/search?q=" palabra))

  (defn busqueda [n]
    (println "\nEjercicio 2\n \n")
    (let [resultadoG (promise)]
      (future (if-let [html (slurp (google n))]
                (deliver resultadoG html)))
      (println @resultadoG "\n\n"))
    (let [resultadoB (promise)]
      (future (if-let [html (slurp (bing n))]
                (deliver resultadoB html)))
      (println @resultadoB)))

  (defn busquedaMotores [palabra & buscador]
    (println "\n\nFunción actualizada\n\n")
    (let [buscadores {:bing bing :google google}
          resultado (promise)]
      (doseq [nbuscador buscador]
        (future (if-let [html (slurp ((get buscadores nbuscador) palabra))]
                  (deliver resultado html))))
      (println (deref resultado 1000 :timeout))))

  (busqueda "Clojure")
  (busquedaMotores "Lisp" :bing))

(ns hilos.core)

(defn -main

  [& args]

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
    (println "Ejercicio 1")
    (def lista [])
    (loop [x (- n 1)]
      (when (> x 0)
        (conj lista x)
        (if (= (mod n x) 0)
          (def lista (conj lista x)))

        (recur (- x 1))))

    (println lista)
    (if (< n (reduce + lista))(println "Abudante")(println "Deficiente"))
    (reduce + lista))

  (def result (future (deficiente 18)))

  (println (deref result))

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

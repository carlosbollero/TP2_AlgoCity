TP2_AlgoCity
============

*TP java* - Algoritmos y Programación III - **FIUBA**



Supuestos:
==========
- La capacidad de una unidad es igual a la capacidad total menos el porcentaje de daños
  esfectuado por un terremoto.
- La estacion de bomberos y el pozo de agua no es afectado por una catastrofe.
- Para agregar una Unidad se deben cumplir previamente todos los requisitos.
- Las rutas las repara completamente EstacionDeBomberos.
- La poblacion va a variar segun un cálculo entre la CAPACIDAD_TOTAL de poblacion
  y la CAPACIDAD_DE_EMPLEO. Ese cálculo va a dar una taza de crecimiento que va a
  actualizar la poblacion turno a turno.
- La catastrofe va a producir que la CAPACIDAD_TOTAL (segun el porcetaje de daño que tenga cada unidad)
  disminuya y actualizar el indice.


# Requisitos

* Librería de grafos [JGraphT](http://jgrapht.org/).
* Descarga [Windows](http://prdownloads.sourceforge.net/jgrapht/jgrapht-0.9.0.zip?download).
* Descarga [Linux](http://prdownloads.sourceforge.net/jgrapht/jgrapht-0.9.0.tar.gz?download).
* Código fuente  <https://github.com/jgrapht/jgrapht>.


Consultas:
==========
- Es correcto trabajar las unidades como Singleton y que la población se maneje de manera externa?




- Como reacciona una población a una catastrofe:
	cuanto decrece la poblacion de una unidad residencial/industrial.
	como reacciona una central electrica ante una catástrofe.
- Tener un indice de "bienestar" para controlar el flujo de población a la ciudad.
- Unidades de servicio reciben daños????
- Terremoto cuanto daño hace en el picentro
- Revisar interfaz Ubicable porque no estamos seguros
- Hay diferencias entre lo que puede ser destruido y lo que puede ser reparado.

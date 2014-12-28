#Errores

- En el test de RegistroUsuarios, depende de que se haya creado previamente un archivo.
  O que se haya corrido previamente otro test. Hay que modificarlo.  [PENDIENTE]
- Conexion con tuberías y con red eléctrica se evaluar de la misma manera.
  También se mide el radio. [CARLOS]
- En la ventana de inicio, el panel para elegir entre la lista de usuarios,
  depende de que la carpeta /saved/ esté creada y no vacía. [SOLUCIONADO]

#Faltantes
- Interacción botones--crear unidad--agregar a mapa. [PENDIENTE]
- Arreglar MapasIntegralTest. [SOLUCIONADO]
- Poder mostrar tuberías en la vista subterranea. [SOLUCIONADO]


TP2_AlgoCity
============

*TP java* - Algoritmos y Programación III - **FIUBA**

# Requisitos

* Librería de grafos [JGraphT](http://jgrapht.org/).
* Descarga [Windows](http://prdownloads.sourceforge.net/jgrapht/jgrapht-0.9.0.zip?download).
* Descarga [Linux](http://prdownloads.sourceforge.net/jgrapht/jgrapht-0.9.0.tar.gz?download).
* Código fuente  <https://github.com/jgrapht/jgrapht>.

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


Consultas:
==========


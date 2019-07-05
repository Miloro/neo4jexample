# TP-Performance
El objetivo de este TP es simular el escenario que ocurre al desarrollar una aplicación y 
la misma no cumple con los requerimientos no funcionales de Performance en sus consultas. 

### Enunciado
El enunciado del TP es simple. La idea es llevar al mínimo los tiempos de los listados cambiando 
para eso la lógica de negocio, los mapeos de hibernate, las consultas y la estructura de la base. 

Si es necesario cambiar la estructura de la base, se deben proveer los medios para preservar los 
datos, convirtiendo o generando los datos nuevos.  

### Consideraciones:
* Se debe minimizar los cambios sobre la lógica de negocios.

* Por la dificultad que cambiar la estructura de la BD conlleva se debería poder evitar. Antes de 
hacer un cambio de estructura física pensar si se puede realizar el cambio con una vista. 

* No se puede ejecutar consultas SQL Nativas.

### Aclaraciones:
Los Listados se pueden probar ejecutando el test `ListadosTest`

El listado de Máximos Salarios no funciona con el volumen de datos, hacerlo andar es parte del ejercicio.

Se deben cargar todos los datos en la base de datos. Para hacerlo hacer lo siguiente:

1. Descomprimir el tar.bz employees_db que esta en `src/main/resources` (tar -xvjf employees_db-final-1.0.6.tar.bz)
2. Dentro de la carpeta ejecutar `mysql -uroot -proot -t < employees.sql`
3. Se debería haber generado la base de datos employees.

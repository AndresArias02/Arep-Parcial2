# Arep-Parcial2
## Servicios de busqueda lineal y binaria completos junto con los metodos de los controladores que permiten resibir la peticiones segun la busqueda que se desee implementar:
Sus servicios  deben incluir dos funciones. 
Uno recibe una lista de cadenas y un valor a buscar e implementa la búsqueda lineal :  linearSearch(lista, valor) retorna un json con el índice de la primera aparición del valor o con -1 si no encuentra el valor
Uno recibe una lista ordenada de cadenas y un valor a buscar e implementa la búsqueda binaria de manera recursiva : binarySearch(n), retorna un json con el índice de la primera aparición del valor o con -1 si no encuentra el valor.
PARA AMBAS IMPLEMENTACIONES ESCRIBA EL ALGORITMO. Usted debe implementar las dos funciones, no debe usar funciones de una librería o del API (si ya existen).

La búsqueda lineal y la búsqueda binaria son dos algoritmos fundamentales utilizados para encontrar un elemento específico en un conjunto de datos. Aquí te describo en detalle cómo funcionan estos dos algoritmos:

- Búsqueda Lineal
La búsqueda lineal, también conocida como búsqueda secuencial, es un método simple y directo para encontrar un elemento en un conjunto de datos. Funciona de la siguiente manera:

Inicio: Comenzar desde el primer elemento del conjunto de datos.
Comparación: Comparar cada elemento con el valor buscado.
Resultado:
Si el elemento actual es igual al valor buscado, se retorna la posición de ese elemento, indicando así que el elemento ha sido encontrado.
Si el elemento actual no es igual al valor buscado, se pasa al siguiente elemento.
Finalización: Este proceso continúa hasta que se encuentra el elemento o se ha recorrido todo el conjunto de datos.
No encontrado: Si se llega al final del conjunto sin encontrar el valor, se indica que el elemento no está presente.
La búsqueda lineal no requiere que los datos estén ordenados y es efectiva para conjuntos de datos pequeños, pero su eficiencia disminuye a medida que el tamaño del conjunto de datos aumenta, ya que en el peor caso, se deben comparar todos los elementos.

 public Response linearSearch(List<Integer> values, Integer value) {
        int output = -1;
        List<String> stringValues = Collections.singletonList(values.toString());
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(value)) {
                output = i;
            }
        }
        return new Response("linearSearch", stringValues, String.valueOf(value), String.valueOf(output));
    }

- Búsqueda Binaria
La búsqueda binaria es un método más eficiente que la búsqueda lineal, pero requiere que el conjunto de datos esté ordenado previamente. Su proceso se describe de la siguiente manera:

Inicio: Determinar los índices de inicio y fin del conjunto de datos, que inicialmente son el primer y último elemento, respectivamente.
División: Calcular el índice medio del conjunto de datos actual y comparar el elemento en esta posición con el valor buscado.
Comparación:
Si el elemento medio es igual al valor buscado, se retorna la posición de este elemento, indicando que se ha encontrado.
Si el elemento medio es mayor que el valor buscado, se descarta la mitad superior del conjunto y se repite el proceso con la mitad inferior.
Si el elemento medio es menor que el valor buscado, se descarta la mitad inferior del conjunto y se repite el proceso con la mitad superior.
Iteración: El proceso se repite, reduciendo a la mitad el tamaño del conjunto de datos en cada paso.
Finalización: Este proceso continúa hasta que se encuentra el valor o el subconjunto se reduce a cero.
La búsqueda binaria es muy eficiente en conjuntos de datos grandes, ya que reduce significativamente el número de comparaciones necesarias en comparación con la búsqueda lineal, logrando una complejidad temporal de O(log n), donde n es el número de elementos en el conjunto de datos.

private int binary(List<Integer> values, Integer value){
        int output = -1;
        int lastIndex = values.size();
        int mediumIndex = lastIndex / 2;
        if(Objects.equals(values.get(mediumIndex), value)){
            return output = mediumIndex;
        }
        if(value < values.get(mediumIndex)){
            return binary(values.subList(0,mediumIndex), value);
        }
        if(value > values.get(mediumIndex)){
            return binary(values.subList(mediumIndex,values.size() - 1), value);
        }
        return output;
    }
## La parte del cliente que permite introducir la lista con los valores ya sea que esten ordenados o no y y el valor especifico a buscar tambien se encuentra implementado en html y javascript :
<!DOCTYPE html>
<html>
<head>
    <title>Form Example</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h1>LinearSearch</h1>
<form>
    <label for="value">Value:</label><br>
    <label for="list">List:</label><br>
    <input type="text" id="value" name="value"><br><br>
    <input type="text" id="list" name="list"><br><br>
    <input type="button" value="Submit" onclick="loadGetMsg()">
</form>
<div id="getrespmsg"></div>

<script>
    function loadGetMsg() {
        let valueVar = document.getElementById("value").value;
        let listVar = document.getElementById("list").value;
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {
            document.getElementById("getrespmsg").innerHTML =
            this.responseText;
        }
        xhttp.open("GET", "/linearSearch?list="+listVar+"&value="+valueVar);
        xhttp.send();
    }
</script>

<h1>BinarySearch</h1>
<form action="/">
    <label for="value">Value:</label><br>
    <label for="list">List:</label><br>
    <input type="text" id="valueBS" name="value"><br><br>
    <input type="text" id="listBS" name="list"><br><br>
    <input type="button" value="Submit" onclick="loadGetMsg()">
</form>
<div id="getrespmsgg"></div>

<script>
    function loadGetMsgg() {
        let valueVar = document.getElementById("valueBS").value;
        let listVar = document.getElementById("listBS").value;
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {
            document.getElementById("getrespmsgg").innerHTML =
            this.responseText;
        }
        xhttp.open("GET", "/binarySearch?list="+listVar+"&value="+valueVar);
        xhttp.send();
    }
</script>
</body>
</html>

## Falta el despliegue en AWS , el algoritmo de round robin no lo pude terminar para seleccionara el servidor de forma aleatoria para que de respuesta a la peticion y falta la integracion del HttpConnection. 


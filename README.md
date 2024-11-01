# Microservicios - Servicios Matemáticos

## Descripción

Este proyecto está diseñado para implementar una arquitectura de microservicios que compute funciones de ordenamiento. El sistema incluye un servicio para realizar operaciones de búsqueda lineal y binaria, desplegado en múltiples instancias de EC2, junto con un servicio proxy que gestiona las solicitudes entrantes y las distribuye utilizando un algoritmo de round-robin.

## Características

- **Arquitectura de Microservicios**: La aplicación consta de servicios separados para manejar operaciones matemáticas, asegurando modularidad y facilidad de mantenimiento.
- **Balanceo de Carga**: Se implementa un servicio proxy para balancear las solicitudes entre múltiples instancias del servicio matemático utilizando una estrategia de round-robin.
- **Configuración Dinámica**: El proxy puede ser configurado usando variables de entorno para establecer las direcciones y puertos de las instancias del servicio matemático.
- **Cliente Web Asincrónico**: Se proporciona un cliente web mínimo que utiliza HTML y JavaScript para interactuar con el servicio proxy, permitiendo a los usuarios realizar operaciones de búsqueda de forma asíncrona.

## Arquitectura

- **Servicio Matemático**: Implementa funciones de búsqueda lineal y binaria.
- **Servicio Proxy**: Actúa como intermediario que reenvía solicitudes desde los clientes a las instancias del servicio matemático.
- **Cliente Web**: Una interfaz HTML simple para invocar funciones de búsqueda.

## Tecnologías Utilizadas

- **Spring Boot**: Para construir los microservicios y gestionar dependencias.
- **Java**: El lenguaje de programación principal utilizado para los servicios backend.
- **HTML/CSS/JavaScript**: Para la interfaz del cliente web.

# Endpoints de la API

## Endpoints del Servicio Matemático:
- `GET /LinearSearch?list=<valores-separados-por-comas>&value=<valor-a-buscar>`
- `GET /BinarySearch?list=<valores-separados-por-comas>&value=<valor-a-buscar>`

## Endpoints del Servicio Proxy:
- `GET /proxy/LinearSearch?list=<valores-separados-por-comas>&value=<valor-a-buscar>`
- `GET /proxy/BinarySearch?list=<valores-separados-por-comas>&value=<valor-a-buscar>`

# Uso

## Búsqueda Lineal:
Ingresa una lista de enteros separados por comas y un valor a buscar en el formulario de Búsqueda Lineal, luego haz clic en "Enviar".

![image](https://github.com/user-attachments/assets/c005a5ee-930d-4e03-876e-13176639d5ee)

## Búsqueda Binaria:
De manera similar, llena el formulario de Búsqueda Binaria con una lista separada por comas y un valor a buscar.

![image](https://github.com/user-attachments/assets/07569371-68f6-4420-98b3-0a03a12067c6)

# Ejemplos de Solicitudes

## Búsqueda Lineal:
```bash
GET /proxy/LinearSearch?list=5,2,3,7,8&value=3
```
## Búsqueda Binaria:
```bash 
GET /proxy/BinarySearch?list=1,2,3,4,2&value=4
```
# Resumen de Clases

- **MathController**: Maneja las solicitudes entrantes para operaciones de búsqueda e interactúa con MathService.
- **ProxyController**: Recibe solicitudes de los clientes y las reenvía a la instancia del servicio matemático correspondiente.
- **MathService**: Contiene la lógica para las operaciones de búsqueda lineal y binaria.
- **Response**: Una clase de modelo para estructurar las respuestas del servicio matemático.

# Conclusión

Este proyecto sirve como un prototipo fundamental para una arquitectura de microservicios escalable enfocada en cálculos matemáticos, demostrando balanceo de carga, interacciones web asíncronas y configuraciones basadas en entorno.

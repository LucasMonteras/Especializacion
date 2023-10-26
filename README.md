## Arquitectura de software

Podemos entender a la arquitectura de software como el conjunto de decisiones que se llevan a cabo para crear un sistema que satisface los requerimientos planteados.

## ¿Que son los Microsevicios?

Los microservicios son un enfoque arquitectónico y organizativo para el desarrollo de software que se basa en dividir una aplicación monolítica en pequeños servicios independientes y autónomos. Esto se hace por varias razones importantes:

1. **Escalabilidad y Flexibilidad:** Los microservicios permiten que los diferentes componentes de una aplicación sean escalables de manera independiente. Esto significa que puedes asignar más recursos a un servicio específico si es necesario, sin afectar a otros componentes. Por ejemplo, si tienes una aplicación de comercio electrónico, puedes escalar el servicio de carrito de compras en momentos de alta demanda sin tocar otras partes de la aplicación.
2. **Mantenimiento y Despliegue Sencillo:** Cada microservicio puede ser desarrollado, probado y desplegado de forma independiente. Esto facilita la implementación de nuevas características o correcciones de errores sin afectar a otras partes de la aplicación. Por ejemplo, si necesitas actualizar la función de autenticación, solo tienes que trabajar en el servicio de autenticación, sin preocuparte por el resto de la aplicación.
3. **Tecnología Diversa:** Cada microservicio puede utilizar tecnologías diferentes, lo que te permite elegir la mejor herramienta para cada tarea. Por ejemplo, podrías utilizar Node.js para un servicio que maneja transacciones en tiempo real, y Python para un servicio que procesa datos de manera intensiva.
4. **Facilita la Colaboración:** Los equipos pueden trabajar de manera independiente en microservicios específicos. Esto facilita la colaboración y la agilidad en el desarrollo. Cada equipo es responsable de su propio microservicio y puede tomar decisiones técnicas que mejor se adapten a sus necesidades.
5. **Reutilización de Código:** Los microservicios pueden ser reutilizados en diferentes partes de una aplicación o incluso en otras aplicaciones, lo que reduce la duplicación de esfuerzos y fomenta la eficiencia en el desarrollo.
6. **Resistencia a Fallos:** Si un microservicio falla, no necesariamente afectará a toda la aplicación. Puedes diseñar la arquitectura para que otros microservicios sigan funcionando incluso si uno de ellos presenta problemas.

En resumen, los microservicios ofrecen una forma de desarrollar software que es más escalable, flexible, fácil de mantener, y que permite una colaboración efectiva entre equipos de desarrollo. Sin embargo, también introducen desafíos, como la gestión de la comunicación entre microservicios y la necesidad de monitorear y asegurar cada uno de ellos. Por lo tanto, es importante evaluar si esta arquitectura es adecuada para tu proyecto antes de adoptarla.

![Captura de pantalla 2023-10-03 181341](https://github.com/LucasMonteras/Especializacion/assets/100173868/ed37e458-796c-4246-9e53-128da1f028dd)


## ¿Cuál es una de las desventajas de la arquitectura de microservicios en términos de rendimiento?

Una de las desventajas de la arquitectura de microservicios en términos de rendimiento está relacionada con la comunicación entre microservicios. Aunque esta arquitectura ofrece muchas ventajas, la comunicación entre los diferentes servicios puede tener un impacto negativo en el rendimiento por varias razones:

1. **Overhead de Red:** Cuando los microservicios se comunican entre sí, generalmente lo hacen a través de la red. Esto introduce cierto overhead en términos de latencia y uso de ancho de banda. En una arquitectura monolítica, las funciones internas se llaman directamente en la misma aplicación, lo que tiende a ser más eficiente en cuanto a la velocidad de comunicación.
2. **Problemas de Latencia:** Si tienes una aplicación con muchos microservicios que dependen unos de otros, cada solicitud puede requerir múltiples llamadas de red para completarse. Esto puede aumentar la latencia perceptible para los usuarios, especialmente en comparación con una aplicación monolítica que realiza llamadas internas de manera más rápida.
3. **Complejidad de la Gestión de la Comunicación:** La gestión de la comunicación entre microservicios puede ser compleja. Los equipos de desarrollo deben implementar y mantener mecanismos para manejar la comunicación, como protocolos de comunicación, serialización y deserialización de datos, control de errores y gestión de versiones de API. Esta complejidad adicional puede afectar negativamente la velocidad de desarrollo y el rendimiento.
4. **Posible Sobrecarga de Recursos:** Si los microservicios no se diseñan y escalan adecuadamente, pueden consumir más recursos de los necesarios. Por ejemplo, en un escenario en el que muchos microservicios realicen llamadas constantemente, los servidores y la infraestructura subyacente pueden verse sobrecargados, lo que afecta negativamente el rendimiento general de la aplicación.

Para abordar estas desventajas en términos de rendimiento, es importante diseñar cuidadosamente la arquitectura de microservicios, optimizar la comunicación entre ellos, implementar técnicas de almacenamiento en caché y considerar el uso de tecnologías de comunicación eficientes como gRPC. Además, es fundamental monitorear y realizar ajustes en la escalabilidad de los microservicios para garantizar un rendimiento óptimo en el entorno de producción.

## **Componente Circulo "Veiter"**

Este componente actúa como un intermediario entre la comunicación de dos servicios. Su objetivo principal es identificar si alguno de los servicios está experimentando problemas o está caído. Cuando detecta una falla en uno de los servicios, corta la comunicación entre ellos y devuelve una respuesta genérica. Esto se hace para evitar que la falla de un servicio afecte negativamente a todo el sistema, permitiendo que el sistema continúe funcionando parcialmente. Además, el componente "Veiter" registra todas las fallas que detecta y puede tomar medidas dependiendo de la cantidad de fallas que ocurran.

## **Componente de Configuración**

Este componente actúa como un repositorio centralizado de configuraciones para los diferentes servicios de la aplicación. Cada vez que se despliega un nuevo servicio, este componente se encarga de buscar y proporcionar la configuración necesaria para ese servicio. La ventaja principal es que la configuración se mantiene en un único lugar, lo que facilita su actualización, modificación y gestión. De esta manera, no es necesario realizar cambios manuales en cada uno de los componentes cuando se necesita ajustar la configuración.

## **Componente de Monitoreo**

El componente de monitoreo desempeña un papel fundamental en la supervisión de todos los servicios que componen la aplicación. Su función principal es recopilar métricas y datos de rendimiento de cada uno de estos servicios. Luego, presenta esta información de manera organizada en un dashboard, que es una interfaz gráfica que permite a los administradores y desarrolladores observar el estado y el rendimiento de los servicios en tiempo real. Esta visualización de métricas ayuda a tomar decisiones informadas y a tomar medidas para mejorar el rendimiento y la disponibilidad de los servicios.

## **Traceo Distribuido**

El traceo distribuido es una técnica que se utiliza para rastrear y registrar el flujo de una solicitud a través de varios servicios en una arquitectura de microservicios. Permite seguir el recorrido de una solicitud a medida que viaja a través de diferentes componentes y servicios, lo que facilita la identificación de cuellos de botella y problemas de rendimiento en la aplicación. El traceo distribuido es esencial para comprender y depurar problemas complejos en un entorno de microservicios, ya que proporciona una visión detallada de cómo interactúan los servicios entre sí y ayuda a mejorar la eficiencia y el rendimiento del sistema en su conjunto.


![image](https://github.com/LucasMonteras/Especializacion/assets/100173868/67d2fb21-c5fb-4eee-8c73-f492243f6a5c)


## Check point de conocimiento

![image](https://github.com/LucasMonteras/Especializacion/assets/100173868/dd762e20-e214-4576-8ee6-39782e6dc97d)

![image](https://github.com/LucasMonteras/Especializacion/assets/100173868/d15ca792-e429-4682-a0f1-c2274e028c66)

![image](https://github.com/LucasMonteras/Especializacion/assets/100173868/ea395bdd-107e-4015-be08-66c7977e5cde)

![image](https://github.com/LucasMonteras/Especializacion/assets/100173868/695d2d69-6153-4238-ab60-931dec341c84)




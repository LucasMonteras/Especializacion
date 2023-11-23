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

# Componentes de Spring Cloud

Componenetes que implementan patrones de diseños

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/606180c3-2757-4bc5-a13f-2e137cfa2b81/Untitled.png)


## Eureka

Es el encargado del registro y descubrimiento de microservicios .Resuelve la necesidad de llevar el registro de los servicios disponibles dentro del sistema y donde estan ubicados . En caso que escale un servicio por demanda este llevara el registro de los que estan disponibles asi tambien cuando deja de estar disponible por baja demanda y sacarlo del registro . Ejemplo el servicio A consume el B , pero este escalo y necesita un componente que tenga los registros y ubicacion  para darselo al servicio A y asi comunicarse .

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/2f049d56-73ff-4399-ac3d-152627ee2e04/Untitled.png)


# Arquitecturea de Eureka server

Se pude dividir a Eureka en dos en 2 grandes componentes : 

**Eureca server** : Es el encargado de llevar el registro de todos los servicios disponibles .

**Eureca cliente** : (En cada uno de los servicos ). Se comunica con el servidor (eurekas server) e informa que un servicio esta disponible y obtiene la lista de los servicios disponibles para luego poder comunicarse.

Esto sucede porque eureka expone una API REST . Tiene una serie de metodos y los mas utilizados para este flujo son :

1 **Registrar microservicos (enpoint) :** Cuando un  cliente (eurka client) se despliegue , va a consumir este enpoint y va mandar cierta info .

2 **Obtener listado de ms (enpoint):** Cuando quiera comuniarse con otro servicio del ecosistema , pide el listado de serviciosque estan disponibles 

3 **Actualizar estado de ms(enpoint):** Ecucha el estado de cada uno de los servicios . En todo momento eurka client manda un msj a eureka server que esta disponible , si el lapso de tiempo se interrumpio entonces ese servicio ya no esta disponible y eureca va suponer que ya no esta y lo ilimina del registro .

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/10d3cf0a-e165-40cd-86ad-c685374cf122/Untitled.png)


## Configuracion de Ereka server

Se crea el preoyectos desde [start.spring.io](http://start.spring.io)  , uno como eureka-cliente con las dependencias Spring web y Eureka discovery client . El otro como eureka-server tambien con las dependencias spring web y eureka server 

En eureka-server en la clase principal se agrega una anotacion para habilitar el proyecto de spring boot como servidor de eureka (@EnableEurekaServer).

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/a1ef5a56-d9d5-47ca-ac34-1ec49b6fd60b/Untitled.png)


En el application.properties se le indica el nombre , el puerto , se coloca anotacion para que el proyecto no figure como cliente disponible.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/1f30039d-0568-46c0-91f2-1dcdc84fd7a6/Untitled.png)

En los clientes se le agrega la dependencia en caso de no crear el proyecto desde cero y se configura solo . En [application.properties](http://application.properties) se le configura el nombre y el puerto.


![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/b55a7674-6c76-4778-b6e1-b5d7ab037817/Untitled.png)


## Spring boot Actuator (monitorea nuestros microservicios).

- Libreria que proporciona herrmamientas de monitoreo y administracion .
- Se accede mediante endpoints REST o JSX .
- Nos informa sobre el estado de cada microservicio.
- Es personalizable.

Actuator nos dice que esta en servicio si esta en ejecucion pero puede estar en ejecucion pero no conectado con la base de datos y caida esa parte por eso hay que configurarla con ciertas condiciones y figure que no esta disponible por no estar conectada a la base de datos .

Link documentacion oficial : https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.enabling

## Configuracion en sistemas distribuidos

Configuración centralizada o el Config Server 

En un proyecto tenemos la confg en un archivo [application.properties](http://application.properties) , en donde tenemos la configuración de la base de datos , configuración de seguridad etc .Estas configuraciones cambian dependiendo del ambiente en donde estemos trabajando (local,testing) esto hace dificil el mantener y actualizarlo .

El config-server va persistir todas estas configuraciones (application.properties) y cada vez que se despligue un sevicio este lo va a buscar en el config-server de tal ambiente . De esta manera estaria toda la configuración centralizada en un solo componente

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/14031096-6b9f-4e28-8875-908add921bcf/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/e5874cf9-2eec-4354-a68b-7edae1aaf7e9/Untitled.png)

Es el encargado de proveer los archivos de configuración a los servicios , asi el config-server va a guardar los archivos de configuracion en un repositorio (github).El config-server busca en git  la configuracion  este se lo pasa y asi tambien se lo pasa al servicio , el servico a su vez va a rener un cliente config-server-client , para qe config-server sepa cual archivo descargar se repeta una nomeclatura especifica SE CREA ARCHIVOS CONFORMADOS POR {EL NOMBRE DEL SERVICIO}-{AMBINETE}.properties ej productsService-test.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/d23f89d6-90ca-467b-b632-aa4fea6b07d5/Untitled.png)

Se crea un nuevo proyecto desde [start.spring.io](http://start.spring.io) como simepre con la dependencia Config Server , una vez creado habilitamos como servidor de configuraciones con la anotacion  @EnableCconfigSeerver (https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_spring_cloud_config_server) y en la properties setea la direccion del git :

`server.port: 8888
spring.cloud.config.server.git.uri: file://${user.home}/config-repo`

Con esto ya esta configurado el confi-server y ahora la configuracion de product-service que va a ser cliente de config-server :

En el archivo pom.xml del proyecto product-service, se debe agregar la siguiente dependencia:

`<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-config</artifactId>
</dependency>`

En la documentación del cliente de configuración (config client), se nos indica qué hacer. Lo único que debemos hacer es especificar la dirección del config-server. Una opción es indicarle a Eureka el nombre del servicio, ya que este lleva el registro de los mismos. La otra opción es hacerlo con el host.

Para utilizar un repositorio privado , en la parter de autenticacion se puede utilizar ssh , una clave para el repositorio ssh en el siguiente link esta la doc https://docs.github.com/es/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account  .La clave publica en el dashboar de git y la privada seteamos en le proyecto config-server , en la configuracion combio de protocolo ssh , el algoritmo de la doc oficial ssh-rsa . 

Para integrar eureka se agrega la dependencia  `<artifactId>spring-cloud-starter-netfix-eureka-client</artifactId>`  en config-server y desde product-service modificamos la configuracion en ves de indicarle el puerto y el host solamente el nombre del servicio de esa manera lo va a ir a buscar eureka y va saber donde esta ubicado , con solo ejecutarlo se va a registrar en eureka . Ademas hay que nombrarlo spring.application.name=” config-service ” ,tener cuidado con el nombre.

En la doc de Config Client no va a facilitar las properties para :

`spring.cloud.config.discovery.enabled=true` : Habilitar el descubrimineto de config-server utilizando eureka 

`spring.cloud.config.discovery.servideId` = Nombre con el que se esta registrando el config-server (osea el config-server)

`spring.config.import =optional:configserver`  = indica el config server , en caso que pueda encontrar lo anterior .

`eureka.instance.hostname=localhost`  = para que eureka utilice de manera local sino por defecto utiliza un numero de ip “ tener en cuenta cuando se trabaje de manera local ” .Tanto en el config-server 

# Invocaciones REST declarativas y balanceo de carga

## Feign

Documnetacion:https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/#netflix-feign-starter

 Es una libreria que actua como: “Cliente REST que manda peticiones a una API” , es una libreria de spring cloud que se integra con el resto de los componentes Ej con esta libreria podriamos mandar una peticion a un servicio de nuestro sistema utilizando el nombre porque se integra con eureka en lugar de estar acoplado a una dirección y puerto , si desplegamos otra instancias de product-service seguiria funcionando nuestro codigo y no tendriamos que hacer ninguna modificación.

Feing es un cliente REST declarativo , quiere decir que tenemos que agregar anotaciones a los metodos de una interfaz pero no vamos a tener que implementar esos metodos . Con estas anotaciones configuramos a donde por ej a donde queremos mandar la peticion , que metodos queremos utilizar , si queremos mandar header etc , pero nunca vamos a desarrolar el metodo completo eso los hace feign por nosotros . A su vez se va a integar con eureka para obtener la ubicacion real de ese servicio .

Para poder integrar feign en este caso es crear un proyecto nuevo Checkout para que se pueda comunicar con el de producto .Se crea como siempre en [start.spring.io](http://start.spring.io) con las siguientes dependecias : 

- Eureka Discovery Cliente
- Config Client
- Spring Web (vamos a crear una API en este servicio)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/c4998ad6-fd06-487e-9ddd-ecb387389824/Untitled.png)


Una vez creado en application propewrties :

[`spring.application.name](http://spring.application.name) = checkout-service` 

`server.port = 8081` 

`spring.cloud.config.discovery.enable = true`   (habilitación para utilizar config-service)

`spring.cloud.config.discovery.serviceId = config-service`   (habilitación para utilizar config-service)

Se crea un controller el cual recibi un listado  de ID y devuleve una instancia de checkout , un JSON que representa lo que seria un checkout . ¿Que es un Chekout ? Tiene un id , una url , el total de algo (totoalAlmounds) y metodos disponibles ej representa a la ultima instancia previo a la compra de unos productos .A este enpoint le llegan listado de productos , vamos a ir a buscar a la API de productos estos productos ,vamos agarra el precio de los productos y los vamos sumar y vamos a crear las nueva instancia de checkput indicando el precio total (totoalAlmounds), la url que seria la que el cliente tendria que entrar para poder realizar la compra y metodos disponibles seria tarjeta de creditos , debito etc

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/5d290adb-e7cc-4b4a-bbf3-eb309ff0d137/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6102c196-0ac4-4365-b675-35ab38e41efe/f1715b5c-2859-4c47-b966-2af638477011/Untitled.png)




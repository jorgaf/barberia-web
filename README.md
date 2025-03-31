# Barbería Web

Hasta el momento ha trabajo con varias vresiones de la gestión de citas de una barbería.

Posiblemente ahora mismo se esté preguntando si todo lo aprendido, en realidad, le permite construir algún tipo de aplicación de uso común hoy en día como las aplicaciones Web.

Este proyecto es una muestra de lo anterior, ya que usa como base el proyecto [barberia-jpa](https://github.com/jorgaf/barberia-jpa) para construir una aplicación Web con una funcionalidad limitada, pero, llena de potencial.

Además de JPA, usa patrones para su construcción. Espero que recuerde ese tema discutivo hace poco.

Para la creación de la aplicación Web se usó un framework denominado [Spring-boot](https://spring.io/projects/spring-boot), parte de la familia Spring, que se caracteriza por ser una de las más usadas dentro del mundo Java.

Clone el proyecto y revise el código ¿ha podido encontrar las entidades *JPA*? Si no es así vaya al paquete [model](src/java/main/ec/edu/utpl/carreras/computacion/barberiaweb/model).

Además este proyecto se basa en el patron Repository (ver [CitaRepository.java](src/java/main/ec/edu/utpl/carreras/computacion/barberiaweb/repository/CitaRepository.java)), aunque al estar basado en Spring su código se reduce, aunque su funcionamiento es el mismo. Ademas se usan otra buena práctica como lo es Service (ver [CitaService.java](src/java/main/ec/edu/utpl/carreras/computacion/barberiaweb/service/CitaService.java)).

Además se usa plantillas (templates) de [Thymeleaf](http://thymeleaf.org) para la construcción de la página en donde se mezclan los datos recuperados desde la base con las etiquetas html.

Finalmente se usa un controlador que se encarga de recuperar los datos de la base y enviarlos a la plantilla. Ver la clase [CitaController.java](src/main/java/ec/edu/utpl/carreras/computacion/barberiaweb/controller/CitaController.java).

Una vez que ejecute el método main (src/main/java/ec/edu/utpl/carreras/computacion/barberiaweb/BarberiaWebApplication.java#L9) debe abrir un navegador Web visitar la url: [http://localhost:8080/citas](http://localhost:8080/citas).

La funcionalidad es básica, muestra únicamente una tabla con las citas.

¿Cómo se puede modificar la aplicación para que la interfaz mejore? Proponga algunas alternativas.
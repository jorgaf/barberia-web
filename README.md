# Barbería Web

Hasta el momento ha trabajado con varias vresiones de la gestión de citas de una barbería.

Posiblemente ahora mismo se esté preguntando si todo lo aprendido, en realidad, le permite construir algún tipo de aplicación de uso común hoy en día como las aplicaciones Web.

Este proyecto es una muestra de lo anterior, ya que usa como base el proyecto [barberia-jpa](https://github.com/jorgaf/barberia-jpa) para construir una aplicación Web con una funcionalidad limitada, pero, llena de potencial.

Además de JPA, usa patrones para su construcción. Espero que recuerde ese tema discutivo hace poco.

Para la creación de la aplicación Web se usó un framework denominado [Spring-boot](https://spring.io/projects/spring-boot), parte de la familia Spring, que se caracteriza por ser una de las más usadas dentro del mundo Java.

Clone el proyecto y revise el código ¿ha podido encontrar las entidades *JPA*? Si no es así vaya al paquete [model](src/main/java/ec/edu/utpl/carreras/computacion/barberiaweb/model).

Además este proyecto se basa en el patron Repository (ver [CitaRepository.java](src/main/java/ec/edu/utpl/carreras/computacion/barberiaweb/repository/CitaRepository.java)), aunque al estar basado en Spring su código se reduce, aunque su funcionamiento es el mismo. Ademas se usan otra buena práctica como lo es Service (ver [CitaService.java](src/main/java/ec/edu/utpl/carreras/computacion/barberiaweb/service/CitaService.java)).

Además se usa plantillas (templates) de [Thymeleaf](http://thymeleaf.org) para la construcción de la página en donde se mezclan los datos recuperados desde la base con las etiquetas html.

Finalmente se usa un controlador que se encarga de recuperar los datos de la base y enviarlos a la plantilla. Ver la clase [CitaController.java](src/main/java/ec/edu/utpl/carreras/computacion/barberiaweb/controller/CitaController.java).

Una vez que ejecute el método main (src/main/java/ec/edu/utpl/carreras/computacion/barberiaweb/BarberiaWebApplication.java#L9) debe abrir un navegador Web visitar la url: [http://localhost:8080/citas](http://localhost:8080/citas).

La funcionalidad es básica, muestra únicamente una tabla con las citas.

¿Cómo se puede modificar la aplicación para que la interfaz mejore? Proponga algunas alternativas.

Respuesta:

Una posible respuesta propuesta por usted, fue el uso de hojas de estilo (css) para mejorar la presentación.

Efectivamente está en lo correcto, una hoja de estilo es el mejor mecanismo para lograr mejorar la presentación, pero, aprender a crear un css puede ser una tarea bastante compleja considerando, por ejemplo, la existencia de múltiples navegadores y cada uno con diferentes versiones. Intentar que un estilo funcione en todos ellos es un reto.

Una forma de evitar este reto es usar una de las tantas hojas de estilos que están disponibles de forma gratuita. Aquí se usóa [tailwindcss](https://tailwindcss.com) que es muy potente y permite personalizar muchas de las características de los elementos de html.

En este caso, revise el archivo [citastmplt.html](src/main/resources/templates/citastmplt.html) y observarán que se han agregado varios elementos para poder usar esa hoja de estilos.

Es momentos de algunas preguntas:

- ¿Qué pasaría si se agrega una nueva cita?
- ¿Qué debería hacer el usuario de nuestra aplicación?
- ¿Qué se puede implementar buscando la automatización?

Respuestas:

Las respuestas a las pregunta son:

- Si se agrega una nueva cita, el listado que se muestra seguirá presentando los mismos datos.
- El usuario debería refrescar la página, es decir, volver a cargarla.
- Se debe buscar una forma para refrescar automáticamente la página.

La respuesta a la tercer pregunta se debe ampliar, si bien existen diferentes formas de hacer esto, aquí se usará una librería denominada [htmx](https://htmx.org), así puede conocer una tendencia dentro del desarrollo Web.

htmx es una librería es una librería que permite acceder a las funciones modernas del navegador directamente desde HTML, en lugar de usar javascript. Para trabajar con htmx se debe agregar el script (ver [aquí](src/main/resources/templates/citastmplt.html#L7)).

También se dividió el archivo [citastmplt.html](src/main/resources/templates/citastmplt.html) en dos partes, la primera con la información general, mientras que la segunda [tabletmplt.html](src/main/resources/templates/tabletmplt.html), esta división se hizo ya que no se actualizará toda la página, sino sólo un fragmento, la tabla.

Para actualizar únicamente la tabla se usará htmx y sus atributos, ver [tabletmplt.html](src/main/resources/templates/tabletmplt.html#L12). Esos atributos señalan que se invocará a la URL /citas/update, que el código que recibirá se ubicar reemplazando al elemento con id: table-citas y todo esto se hará una vez que se ha cargado la tabla, eso sí, demorando la llamada 60 segundos.

Por ahora, la aplicación quedá hasta ahí.
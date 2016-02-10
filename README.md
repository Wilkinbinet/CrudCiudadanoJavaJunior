CrudCiudadanoJavaJunior

Información Técnica

La aplicación está construida mediante la mayoría de los requerimientos de la prueba, fue corrida y desplegada bajo el servidor wildfly 8.2, se utilizaron las librerías que ya posee el mismo desaprovechando con ello las funcionalidades de Maven, en este servidor se tuvieron que ajustar varios items para eclipseLink(unas de las cosas que me dio más trabajo).

Es un proyecto Java EE con su módulo EJB y Web además de ellos se realizó las pruebas con JUNIT a la mayoría de los métodos creados, 
Para el buen funcionamiento de la aplicación Web se recomienda ejecutar las pruebas unitarias antes de la aplicación web en el siguiente orden (país, ciudad, estado ,tipoTlfn), ya que otras tablas son dependiente de la misma y necesitan ser pobladas bien sea directamente en la base de datos o con los uniTest ya señalados para así crear un ciudadano en el módulo web.

Dada la normalización de las tablas tenía una duda sobre ello, ya que bien para una aplicación de prueba los campos señalados prácticamente ya estaban normalizados para un CIUDADANO, pero como en la misma decía normalizar, la normalice casi a su máxima expresión aunque quizás pueda faltar más.

La aplicación realizada le faltan algunos detalles ya que el tiempo no me alcanzo bien, quizás no la fuera sacado en dos días pero quizás si en 3 a su máxima funcionalidad, solo que como yo comente actualmente estoy trabajando sobre aviso a renuncia y mi horario es de 8:30 a 5:30 pm y sábados de 8:30 a 12:30 y sin olvidar que resido en Bani, mi aviso de renuncia va hasta que consiga algo que valla más con mi currículo que es la programación basada en todo el mundo Java y Oracle por eso es la postulación a este trabajo, a nivel Web le falta un poco a nivel visual, allí utilice PRIMEFACES.

Ahora es importante comentar que es lo que esta allí no es mi máximo potencia debido a lo ya explicado, pero allí se puede notar que tengo por lo menos el conocimiento de lo que estoy haciendo y que quizás me falta por aprender y mejorar muchas cosas.

Gracias por la oportunidad cualquier información y consejo es bien recibida wilkinbinet@gmail.com


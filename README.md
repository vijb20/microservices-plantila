# microservices-plantila
Esta es una plantilla de un conjunto de app que usan la arquitectura de microservicios
el proyecto se basa en dos videos 
https://youtu.be/t0D4OPcugyI?si=J-XCr4TKKlXswCsE
https://youtu.be/pzxtXifloSE?si=xU1O206L8xkw0aJZ

Creando el proyecto base o el que va a contener los modulos necesarios para esta plantilla
https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
ir a la seccion CREATING PROJECT y copiar la linea de comando
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=SpringMicroservices -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false

agregando swager a los apis de tipo rest
algunos videos https://www.youtube.com/watch?v=SVZZ3B5gwuM esta en español
https://www.youtube.com/watch?v=-SzKqwgPTyk&t=276s  esta en español
https://www.youtube.com/watch?v=2o_3hjUPAfQ en ingles
Se agrega la siguiente dependency
    	<dependency>
		   <groupId>org.springdoc</groupId>
		   <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
		   <version>2.6.0</version>
		</dependency>
luego se agrega una clase OpenApiConfig la cual tiene unas definiciones iniciales del swager
la ruta por defecto es {local}/swagger-ui.html como ejemplo http://localhost:8081/swagger-ui.html


Se agrega el app server eureka
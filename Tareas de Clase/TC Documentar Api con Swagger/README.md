# **Swagger**


## **_<span style="text-decoration:underline;">INSTALACIÓN</span>⠀⠀_**


Para documentar una aplicación con Swagger lo primero que debemos hacer es es agregar las siguientes librerías en el archivo pom.xml:

![alt_text](img/1.png "image_tooltip")


La primera dependencia (  springfox-swagger2` ` ) es la más importante, pues es la  encargada de analizar la estructura de nuestro proyecto y crear los metadatos para crear la auto documentación del API.

Por otro lado la segunda ( springfox-swagger-ui  ) se encarga de tomar los metadatos de la primera y crear una interfaz visual amigable al usuario.


## **_<span style="text-decoration:underline;">CONFIGURACIÓN</span>⠀⠀<span style="text-decoration:underline;"> </span>_** 

Lo segundo que haremos será crear el paquete config donde alojaremos el fichero de configuración de Swagger SwaggerConfig . 


![alt_text](img/2.png "image_tooltip")


Con este archivo le indicamos a Swagger que es lo que debe tomar como punto de referencia para crear la documentación. Para esto, debemos de crear una clase que este anotada con **@Configuration y @EnableSwagger2** y tenga un método que cree el objeto Docket:


![alt_text](img/3.png "image_tooltip")


Dentro del método  institutoApi  construimos el objeto Docket, en el cual le indicamos que tome todos los servicios que se encuentren en el paquete es.iespuertodelacruz.juan.matriculas.controller y los auto documente por nosotros.

Por último , en el método getApiInfo, creamos el objeto ApiInfo, el cual define los datos de la propiedad del API, como su nombre, email , tipo de licencia, etc.


## **_⠀<span style="text-decoration:underline;">LANZAR APLICACIÓN</span>⠀⠀<span style="text-decoration:underline;"> </span>_** 

Al lanzar la aplicación, tenemos que acceder a la ruta localhost:puerto/swagger-iu.html, en nuestro caso sería  : [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


![alt_text](img/4.png "image_tooltip")  


![alt_text](img/5.png "image_tooltip")


## **_⠀<span style="text-decoration:underline;">DOCUMENTACIÓN</span>⠀⠀<span style="text-decoration:underline;"> </span>_** 


### **@ApiOperation**

Sirve para especificar que devuelve una ruta en específico.

![alt_text](img/6.png "image_tooltip")



### **@ApiParam**

Sirve para especificar las propiedades de los parámetros a recibir , entre ellos el nombre , tipo , descripción , si es opcional o no , etc.


![alt_text](img/7.png "image_tooltip")


## **_⠀<span style="text-decoration:underline;">CONSULTAS</span>⠀⠀<span style="text-decoration:underline;"> </span>_** 

### **Alumnos**

* GET /api/alumnos  
![alt_text](img/8.png "image_tooltip")
* POST /api/alumnos  
![alt_text](img/9.png "image_tooltip")
* GET /api/alumnos/{id}  
![alt_text](img/10.png "image_tooltip")
* PUT /api/alumnos/{id}  
![alt_text](img/11.png "image_tooltip")
* DELETE /api/alumnos/{id}  
![alt_text](img/12.png "image_tooltip")
* POST /api/alumnos/{id}/matriculas  
![alt_text](img/13.png "image_tooltip")



### **Asignaturas**



* GET /api/asignaturas  
![alt_text](img/14.png "image_tooltip")
* POST /api/asignaturas  
![alt_text](img/15.png "image_tooltip")
* GET /api/asignaturas/{id}  
![alt_text](img/16.png "image_tooltip")
* PUT /api/asignaturas/{id}  
![alt_text](img/17.png "image_tooltip")
* DELETE /api/asignaturas/{id}  
![alt_text](img/18.png "image_tooltip")


### **Matriculas**

* GET /api/matriculas  
![alt_text](img/19.png "image_tooltip")  
* GET /api/matriculas/{id}  
![alt_text](img/20.png "image_tooltip")
* PUT /api/matriculas/{id}  
![alt_text](img/21.png "image_tooltip")
* DELETE /api/matriculas/{id}  
![alt_text](img/22.png "image_tooltip")
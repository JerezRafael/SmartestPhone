# SmartestPhone
### Descripcion de la web
SmartestPhone es una web para comparar teléfonos móviles (a partir de ahora smartphones) que se basará en las aportaciones de los usuarios introduciendo smartphones nuevos que no esten en la base de datos para asi ampliarla. Se podrán consultar las especificaciones técnicas de cada smartphone en apartados ya creados (ej. dimensiones de pantalla, procesador, cámara) y también ver las últimas noticias añadidas por los usuarios del smarphone.
-  Parte Pública: Se podrán ver las características y noticias de cada smartphone.
-  Parte Privada: Se podrán crear y editar smartphones, añadir procesadores, camaras y noticias y borrar cualquiera de estos.
### Entidades principales
- Usuario: Los usuarios pueden añadir nuevos smartphones, procesadores, cámaras y noticias a la base de datos.
- Administrador: Puede borrar cualquier smartphone, procesador, cámara y noticia del servidor asi como cualquier cosa que pueda hacer el usuario normal.
- Smartphone: Es cada teléfono móvil que se puede consultar o añadir en la web con varias características básicas como atributos.
- Procesador y cámara - Son entidades separadas del smartphone que pueden ser utilizables por varios smartphones a la vez y no dependen de estos.
- Noticias: Son las noticias añadidas por los usuarios a cada smartphone o marca.
### Servicio Interno
La web tendrá un servicio de mail que enviará un correo electronico a cada usuario cuando se registre un nuevo smartphone o una nueva noticia.
### Integrantes
- Rafael Jerez Molinero
  r.jerez@alumnos.urjc.es
  https://github.com/JerezRafael
- David Pleite Domingo
  d.pleite@alumnos.urjc.es
  https://github.com/dpleite94

## Fase 2

### Diagrama de navegación
Aquí se puede observar como se puede pasar de una página a otra en la web.
![Diagrama de navegación](https://i.imgur.com/gc86CO4.jpg)

### Modelo de datos
Modelo representando las tablas creadas en MySQL.
![Modelo datos](https://i.imgur.com/zi3HL3O.png)

### Diagrama entidad/relación
Modelo E/R en el que un smartphone esta compuesto de una pantalla, unas dimensiones, una cámara, un procesador y forma parte de 0 o N noticias. Una cámara puede formar parte de 0 o N smartphones, al igual que un procesador, y una noticia puede hablar de 1 o N smartphones.
![Diagrama E/R](https://i.imgur.com/ldAAT5B.jpg)

### Páginas web:

#### Inicio
Es la página inicial, desde esta se puede acceder a todas las demás, podemos buscar un smartphone y acceder a la web de detalles y podemos tambien ir a añadir un nuevo smartphone, procesador, cámara o noticia, a la página de gestión y ver las noticias.
![inicio](https://i.imgur.com/lHseUbj.png)

#### Añadir smartphone
Esta web es unicamente para añadir un smartphone nuevo, una vez puestas todas las caracteristicas se puede añadir y ya volver a la página de inicio.
![añadirSmartphone](https://i.imgur.com/7C1yd3N.png)

#### Añadir camara
Esta pantalla permite añadir una cámara. Todas las camaras que se vayan añadiendo se podrán reutilizar desde la pantalla de añadir smartphone.
![añadirCamara](https://i.imgur.com/fwyDRhh.png)

#### Añadir procesador
Esta pantalla permite añadir un procesador. Al igual que las cámaras, todos los procesadores que se vayan añadiendo se podrán reutilizar desde la pantalla de añadir smartphone.
![añadirProcesador](https://i.imgur.com/ymwCPel.png)

#### Añadir noticias
Esta pantalla permite añadir una noticia. Se deberá rellenar un título de noticia, añadir un enlace que redireccione a la noticia y uno o varios smartphones con los que esté relacionada dicha noticia.
![añadirNoticias](https://i.imgur.com/ZwNBJeN.png)

#### Detalles
En esta web se ven todas las características de un smartphone.
![detalles](https://i.imgur.com/MwD1OD0.png)

#### Modificar
En esta web se pueden modificar todas las características de un smartphone.
![modificar](https://i.imgur.com/7ZMhhuj.png)

#### Noticias
Pantalla en la que se podrán consultar todas las noticias o solo las relacionadas con cada smartphone.
![noticias](https://i.imgur.com/exXhoom.png)

#### Gestión
Página en la que solo puede acceder el administrador y que te permite borrar smartphones, cámaras, procesadores y noticias.
![gestion](https://i.imgur.com/UOcnkkD.png)

## Fase 3

### Diagrama de navegación
Aquí se puede observar como se puede pasar de una página a otra en la web, pero como existen diferentes tipos de usuarios vamos a mostrar la navegación para cada tipo:

#### Usuario desconocido
![usuarioDesconocido](https://i.imgur.com/dprZDCc.jpg)

#### Usuario registrado
![usuarioRegistrado](https://i.imgur.com/aogSsh1.jpg)

#### Usuario administrador
![usuarioAdministrador](https://i.imgur.com/W6rd7SA.jpg)

### Diagrama de clases y templates
![diagClasesTemplates](https://i.imgur.com/9GT2l8w.jpg)
Azul = Controladores; 
Rosa = Templates; 
Naranja = Repositorios; 
Verde claro = Entidades; 
Verde oscuro = Clases normales.

### Páginas web:

#### Inicio
Es la página inicial, desde esta se puede acceder a todas las demás, podemos buscar un smartphone y acceder a la web de detalles y podemos tambien ir a añadir un nuevo smartphone, procesador, cámara o noticia (antes se tiene que iniciar sesión, o en caso de no tener cuenta, registrarse), ver las noticias y también ir a la página de gestión (sólo aparece si se ha iniciado sesión como administrador).
![inicio](https://i.imgur.com/enE6nFz.png)

#### Añadir smartphone
Esta web es unicamente para añadir un smartphone nuevo, una vez puestas todas las caracteristicas se puede añadir y ya volver a la página de inicio.
![añadirSmartphone](https://i.imgur.com/tfcyhFi.png)

#### Añadir camara
Esta pantalla permite añadir una cámara. Todas las camaras que se vayan añadiendo se podrán reutilizar desde la pantalla de añadir smartphone.
![añadirCamara](https://i.imgur.com/meTkVr6.png)

#### Añadir procesador
Esta pantalla permite añadir un procesador. Al igual que las cámaras, todos los procesadores que se vayan añadiendo se podrán reutilizar desde la pantalla de añadir smartphone.
![añadirProcesador](https://i.imgur.com/xUWOdtK.png)

#### Añadir noticias
Esta pantalla permite añadir una noticia. Se deberá rellenar un título de noticia, añadir un enlace que redireccione a la noticia y uno o varios smartphones con los que esté relacionada dicha noticia.
![añadirNoticias](https://i.imgur.com/B0ZTHbD.png)

#### Detalles
En esta web se ven todas las características de un smartphone.
![detalles](https://i.imgur.com/NFtDkci.png)

#### Modificar
En esta web se pueden modificar todas las características de un smartphone.
![modificar](https://i.imgur.com/ZWyOYBa.png)

#### Noticias
Pantalla en la que se podrán consultar todas las noticias o sólo las relacionadas con cada smartphone.
![noticias](https://i.imgur.com/qJjSSxA.png)

#### Gestión
Página en la que solo puede acceder el administrador y que te permite borrar smartphones, cámaras, procesadores y noticias.
![gestion](https://i.imgur.com/e0tTrSE.png)

#### Iniciar sesión
Página para poder iniciar sesión ya se tenga rol de usuario o rol de administrador. Te permite añadir smartphones, cámaras, procesadores y noticias si eres usuario normal y si eres adminitrador además, entrar en la web de gestión.
![iniciarSesion](https://i.imgur.com/mHZ5u5q.png)

#### Registarse
Página para registrarse si no se tiene cuenta.
![registrarse](https://i.imgur.com/XWHhmOA.png)

#### Cerrar sesión
Página para cerrar la sesión.
![cerrarSesion](https://i.imgur.com/T6Ug4I2.png)

### Interfaz entre el servicio y la aplicación web

La interfaz entre el servicio interno y la aplicación web consiste en un controlador REST en el servidor de mail por el que la aplicación web mediante un cliente REST le manda únicamente un objeto smartphone o noticia, dependiendo del caso, al crearse en la web para que el servicio acceda a la base de datos, obtenga todas las direcciones de email de los usuarios y les envíe algunos detalles del objeto pasado por parámetro, como la marca y el modelo si es un smartphone o el título y la url de la noticia en el segundo caso. 

Los objetos pasados por parámetro están en memoria hasta que se resuelva la solicitud, no se guardan en ningún sitio y los emails se obtienen de la base de datos mediante el repositorio de los usuarios.

### Instrucciones para desplegar la aplicación

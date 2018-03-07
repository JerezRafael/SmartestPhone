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
![Diagrama de navegación](https://lh3.googleusercontent.com/-iElodFqOi0w/Wpae7oBOeJI/AAAAAAAALns/FNO693kfao0tyxfTAo530u8ApfOhkOeJwCJoC/w663-h393-n-rw/diagNavegFase2.jpg)

### Modelo de datos
Modelo representando las tablas creadas en MySQL.
![Modelo datos](https://lh3.googleusercontent.com/-JczxlnhkGZc/WpafAYZgeBI/AAAAAAAALoA/M1MMjWh4S88V9cfbiEz90fQd1T8IYCXjQCJoC/w663-h612-n-rw/modelodatosFase2.png)

### Diagrama entidad/relación
Modelo E/R en el que un smartphone esta compuesto de una pantalla, unas dimensiones, una cámara, un procesador y forma parte de 0 o N noticias. Una cámara puede formar parte de 0 o N smartphones, al igual que un procesador, y una noticia puede hablar de 1 o N smartphones.
![Diagrama E/R](https://lh3.googleusercontent.com/-_UwcAcF-TpM/WpaiEXOWCLI/AAAAAAAALo4/iYuWGd2bEgUNW9UruRF-g-t7z2Sy_sg6gCJoC/w663-h250-n-rw/diagERFase2.jpg)

### Páginas web:

#### Inicio
Es la página inicial, desde esta se puede acceder a todas las demás, podemos buscar un smartphone y acceder a la web de detalles y podemos tambien ir a añadir un nuevo smartphone, procesador, cámara o noticia y a la página de gestión.
![inicio](https://i.imgur.com/r8BNSQ7.png)

#### Añadir smartphone
Esta web es unicamente para añadir un smartphone nuevo, una vez puestas todas las caracteristicas se puede añadir y ya volver a la página de inicio.
![añadirSmartphone](https://i.imgur.com/Fdv6IDq.png)

#### Añadir camara
Esta pantalla permite añadir una cámara. Todas las camaras que se vayan añadiendo se podrán reutilizar desde la pantalla de añadir smartphone.
![añadirCamara](https://i.imgur.com/32O4XMW.png)

#### Añadir procesador
Esta pantalla permite añadir un procesador. Al igual que las cámaras, todos los procesadores que se vayan añadiendo se podrán reutilizar desde la pantalla de añadir smartphone.
![añadirProcesador](https://i.imgur.com/9PEcSrP.png)

#### Añadir noticias
Esta pantalla permite añadir una noticia. Se deberá rellenar un título de noticia, añadir un enlace que redireccione a la noticia y uno o varios smartphones con los que esté relacionada dicha noticia.
![añadirNoticias](https://i.imgur.com/IViyuc3.png)

#### Detalles
En esta web se ven todas las características de un smartphone.
![detalles](https://i.imgur.com/kJl2Rcf.png)

#### Modificar
En esta web se pueden modificar todas las características de un smartphone
![modificar](https://i.imgur.com/m3ceM2Y.png)

#### Noticias
Pantalla en la que se podrán consultar todas las noticas o solo las relacionadas con cada smartphone.
![noticias](https://i.imgur.com/sb9GfNL.png)

#### Gestión
Página en la que solo puede acceder el administrador y que te permite borrar smartphones, cámaras, procesadores y noticias.
![gestion](https://i.imgur.com/qv4w9ZN.png)

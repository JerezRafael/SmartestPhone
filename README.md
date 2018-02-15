# SmartestPhone
## Descripcion de la web
SmartestPhone es una web para comparar teléfonos móviles (a partir de ahora smartphones) que se basará en las aportaciones de los usuarios introduciendo smartphones nuevos que no esten en la base de datos para asi ampliarla. Se podrán consultar las especificaciones técnicas de cada smartphone en apartados ya creados (ej. dimensiones de pantalla, procesador, cámara) y también ver las últimas noticias añadidas por los usuarios del smarphone.
-  Parte Pública: Se podrán comparar smartphones y ver las características y noticias de cada uno.
-  Parte Privada: Se podrán editar los smartphones, añadirlos a favoritos de la cuenta, añadir noticias y consultar las actividades de la cuenta.
## Entidades principales
- Usuario: Los usuarios pueden añadir smartphones a favoritos para consultarlos rápidamente y pueden añadir un smartphone nuevo a la base de datos previa aprobación del administrador o el usuario veterano.
- Usuario de alta gama: Es un usuario normal que cuando consigue una cierta antigüedad en la web y realiza una serie de acciones se convierte en usuario de alta gama. Puede aprobar o declinar la inclusión de nuevos smartphones por parte de un usuario y solicitar al administrador la creación de una nueva característica del smartphone a poder comparar.
- Administrador: Puede administrar las cuentas asi como eliminarlas, desbloquearlas o convertirlas en usuario de alta gama o administrador. Tambien aprueba la inclusión de una nuevas caracteristicas del smartphone a poder comparar y de nuevos smartphones a la base de datos.
- Smartphone: Es cada teléfono móvil que se puede consultar o añadir en la web.
- Características: Es cada uno de los campos que tiene un smartphone en sus especificaciones técnicas. Son comunes para todos los móviles.
- Noticias: Son las noticias añadidas por los usuarios a cada smartphone o marca.
## Servicio Interno
La web tendrá un apartado de notificaciones para que se avise al usuario cuando se modifique la información de un smartphone, haya una nueva noticia o se añada algun smartphone nuevo a la marca que el sigue.
## Integrantes
- Rafael Jerez Molinero
  r.jerez@alumnos.urjc.es
  https://github.com/JerezRafael
- David Pleite Domingo
  d.pleite@alumnos.urjc.es
  https://github.com/dpleite94
- Jorge Contreras Padilla
  j.contrerasp@alumnos.urjc.es
  https://github.com/jorgecontreras95
## Trello
https://trello.com/b/TDEqe3A9

# Fase 2

## Diagrama de navegación

![Diagrama de navegación](https://lh3.googleusercontent.com/-JEu8ZIC7EiQ/WoVTkfoKZUI/AAAAAAAALj8/2KFM1XC0cl0ojGY71E2NvgzXJ3seB1bTQCL0BGAs/w663-d-h222-n-rw/diagNaveg.jpg)

Desde la página de INICIO podemos ir a la página de AÑADIR y a la de DETALLES en el caso que se haya hecho alguna consulta. Desde AÑADIR y DETALLES se puede volver al INICIO. Desde DETALLES se puede volver a AÑADIR para realizar algún cambio.

## Modelo de datos
![Modelo datos](https://lh3.googleusercontent.com/-pl8usEPQrfk/WoVKb43_xzI/AAAAAAAALjY/-HoBDA8Qu-wh3g9y7srBSAFbd5wp2mGfwCJoC/w663-h282-n-rw/diagclases.jpg)

Tenemos dos controladores: el de inicio que utiliza de templates inicio.html y añadir.html para sus repectivos métodos greeting; SmartPhoneController cuyos templates utilizados son inicio.html para buscar(), añadir.html para añadirSmartPhone() y detalles.html para greetingDetalles(). También el propio repositorio de smartphone.

## Diagrama entidad/relación
![Diagrama E/R](https://lh3.googleusercontent.com/-dm_7BsL0vrM/WoVKgM3pIdI/AAAAAAAALjY/iNiu14snpjYyrj_QzPVzPuwkGgD5D90cACJoC/w663-h450-n-rw/diagER.jpg)

Existe una entidad principal que es SmartPhone, que tiene una cámara, un SO, un procesador, una pantalla y unas dimensiones.

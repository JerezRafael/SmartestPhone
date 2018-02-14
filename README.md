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

## Modelo de datos
![Modelo datos](https://lh3.googleusercontent.com/kb2sQ9Sb3xSX6HQkaxy_lLzgCuakv7rzCkc8J7iKolQ86183T8kLDrQw-0jiFwOG3P-E2mDJJoInob_rV37LyZazDxkXBClkgGUKkBL8QV15H1tyn3v4cNxrOJNkGMETBtnrrGcovewQ-hmviEmi-xSOSmka25fw7icrmG0Z_eW0GURQoB4Ft-neqJSvsuc7Y49yG7Fc40CCuGsZLdGWe7hFzd99H5PXs0ZvEUGTTQZoDDJP-qNBfiGRX2O9rysK0Cx1UH5CDngrMuVdWBNGgOFIRyhATEg8Hi9n1yxWp1G2Fh56guoueEu-sb8e9NJxtTJxW9DJXQ97g-_bkLW57ZzV2zaWeEKI5KG72st0a4Gw4PF-ZX77pToVVZkNhtGEZnlECsy5zFzV3NarBxfROw10VksouHE2Zffh6JvDI1RXIVt2jy0sxyKCakriyg8ubQuMFm88uRDgq9kvy5xZEfSWiOJVXUK9Wh0IRLyjktg62wJph-3ZnC5dE2vIYCZXtuw0dQ__vTnYbvvx1Hb19mLjtgM3p4NTHub2Q3qL8U2MJ-m1IYsnlAxIRo6KvSB2xSHJwZz2RPS06dB2EHNdY_m-oFR4p-5_PTlcjiA=w992-h422-no)

Tenemos dos controladores: el de inicio que utiliza de templates inicio.html y añadir.html para sus repectivos métodos greeting; SmartPhoneController cuyos templates utilizados son inicio.html para buscar(), añadir.html para añadirSmartPhone() y detalles.html para greetingDetalles(). También el propio repositorio de smartphone.

## Diagrama entidad/relación
![Diagrama E/R](https://lh3.googleusercontent.com/9C6rDBhaS-Qkz_8q4kIVZbm5cvQXzcsAWjT1LI0Img2TSrgC_GWDH2zQQ3sVfCl5JHe367CNYbPJyLranvh77uHIbJV9joy-yOUHUB8KUZSR7McZ96csZ_k1JBH2Fj2eYrrCuOF481ypFrdn6XuSX0EygbOAT_7w5fa3ySPBTAnm-E7ZbjS-bGPOgcB1Z8ukpt6zqbRLlk7vbajhxvAR7H4cdI5YVfxzi52OqUe63UHjK3giNZ1aaMOvVXVYJBRQ0FGIjLe8WRzzZ9utHP_WWqzh6GVK4IZlvtVpIx5QnKSpZzLmLwBl3MoqIBAztaoGHfobw012pQcwmAU-ZXTs2ctPWnpQI1lS0KIn79d4njZTPqG1pLV_5JQ51DXPNCSzJ1uyYoFEFYyjgjrriL6JP1o4lMDjIdwidrDd0T4n5cTV9YdWPl2FSC-B9KGvmo73OFVKCqB77_znBqdWcijUywlUrMAfvGzscVWm7O5CAlZTfMGAJT9U3Oc1UnyaVlveBSmUPRh8l6WpfEM-whKZNvt4QIm5e3BTsq7xRSXXyfz--gxtzu9p14XrebkH0fKDzA6PJ3SMpAA6uiDxV-6hI3Kti-upkMyDjSCwlGo=w1273-h865-no)

Existe una entidad principal que es SmartPhone, que tiene una cámara, un SO, un procesador, una pantalla y unas dimensiones.

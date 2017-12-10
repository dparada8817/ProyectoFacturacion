# ProyectoFacturacion

David Parada

Danny Mejia

Santos Valdes

 


  

## Rediseño del Sistema de Facturacion

Para el rediseño de la arquitectura del sistema de facturacion se plantea una arquitectura de microservicios orientada a eventos para la comunicacion entre ellos y con esto poder brindar facil escalabilidad para poder logar soportar altos volumenes de transacciones. 




![alt text](https://github.com/dparada8817/ProyectoFacturacion/blob/master/ProyectoFacturacion.jpg)



### Microservicios creados:

#### zuul-proxy
Es el componente actua como proxy reverso para ser el unico punto de entrada de las aplicaciones externas a nuestro sistema, este se conecta con el servidor de eureka para redireccionar las peticiones a los microservios.
- Rutas expuetas
    - http://localhost:1111/routes  : retorna las posibles rutas de acceso a los ms atraves del proxy
 
#### eureka-server
Es el componente actua como servidor de registry donde los servicios se autoregistran al momento de levantar y donde el proxy reverso viene a preguntar la localizacion de los componentes para redireccionar las peticiones
- Rutas expuestas
    
    rutas en la cual se ven los servicios registra atraves del proxy o directamente en el servidor 
    - http://localhost:1111/proyecto-facturacion/eurekaserver/
    - http://localhost:1112/
    

#### Ms-Facturacion
Es el componente que se encarga de manejar la facturacion del sistema, tiene como funciones persistir las facturas, comunicarse con el componente  sap para este registre la factura y con el componente clientes para crear/actualizar el cliente.
- Rutas expuetas
    - http://localhost:1111/proyecto-facturacion/msfacturacion/factura  : servicio para registrar la factura
        
          {
                "cliente":{
                    "dni":"C11282337",
                    "nombre":"David",
                    "direccion":"calle 123"
                },
                "producto":[
                    {
                        "producto":"es",
                        "cantidad":1
                    }
                ]
        	}
    - http://localhost:1111/proyecto-facturacion/msfacturacion/facturas : retorna todas las facturas creadas
    
    - http://localhost:1115/h2 : ruta para acceder al servidor de db del ms, los datos de ingreso son: 
    
            JDBC URL: jdbc:h2:file:~/facturacion 
            Usuario: facturacion 
            sin contraseña
            
#### Ms-Clientes

Es el componente que se encarga de ofrecer un manejo centralizado de los clientes. recibe la informacion de los clientes desde el componente de facturacion para su gestion
- Rutas expuetas
    - http://localhost:1111/proyecto-facturacion/msclientes/clientes se encarga de listar todos los clientes creados
    - http://localhost:1117/h2 : ruta para acceder al servidor de db del ms, los datos de ingreso son: 
        
                JDBC URL: jdbc:h2:file:~/cliente 
                Usuario: cliente 
                sin contraseña

    
 
#### Ms-Sap

Es el componente que se encarga de asentar las facturas y generar el evento para que los demas sistemas hagan con esta su tarea necesaria
- Rutas expuestas
    - http://localhost:1111/proyecto-facturacion/mssap/facturas retorna las facturas asentadas en el sistema de sap
    - http://localhost:1114/h2 : ruta para acceder al servidor de db del ms, los datos de ingreso son: 
            
                    JDBC URL: jdbc:h2:file:~/sap 
                    Usuario: sap 
                    sin contraseña


#### Ms-Compras
El componente maneja la base de datos de compras y recibe la información desde el componente de clientes para amacenar clientes y desde el componente de SAP para las facturas
- Rutas expuestas
    - http://localhost:1111/proyecto-facturacion/mscompras/clientes retorna los clientes que se encuentran en el sistema de compras
    - http://localhost:1111/proyecto-facturacion/mscompras/facturas retorna las facturas que se encuentran en el sistema de compras
    - http://localhost:1116/h2 : ruta para acceder al servidor de db del ms, los datos de ingreso son:
         
            JDBC URL: jdbc:h2:file:~/compras
            Usuario: compras
            sin contraseña

#### Ms-BI
El componente de BI se alimenta de las facturas asentadas en en el componente de SAP para su tratamiento interno
- Rutas expuestas
    -  http://localhost:1111/proyecto-facturacion/msbi/facturas retorna las facturas que se encuentran en el sistema de BI
    - http://localhost:1118/h2 : ruta para acceder al servidor de db del ms, los datos de ingreso son:
        
            JDBC URL: jdbc:h2:file:~/bi
            Usuario: bi
            sin contraseña

## Como correr el proyecto

para levantar todos los microservicio se debe ejecutar el archivo "runAll.bat" que se encuentra en la raiz del proyecto

para levantarlos prograsivamente se debe correr el archivo run.bat que se encuentra en la carpeta de cada microservicio 






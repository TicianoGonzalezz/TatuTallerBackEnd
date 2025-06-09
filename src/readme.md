Universidad ORT Uruguay
Facultad de Ingeniería







Plataforma Web de Gestión y Comercialización para Tatú Cerámica. 
Entregado como requisito para la obtención del título de Analista en Tecnologías de la Información






María Sofía Pérez– Nro. 157427
Ticiano González- Nro. 255124
Tutor: Sebastián Pombo

2025
 
Declaración de autoría

Nosotros, María Sofía Pérez y Ticiano González, declaramos que el trabajo que se presenta en esta obra es de nuestra propia mano. Podemos asegurar que:
●	La obra fue producida en su totalidad mientras realizamos el Proyecto Integrador de la carrera Analista en Tecnologías de la Información;
●	Cuando hemos consultado el trabajo publicado por otros, lo hemos atribuido con claridad;
●	Cuando hemos citado obras de otros, hemos indicado las fuentes. Con excepción de estas citas, la obra es enteramente nuestra;
●	En la obra, hemos acusado recibo de las ayudas recibidas;
●	Cuando la obra se basa en trabajo realizado juntamente con otros, hemos explicado claramente qué fue contribuido por otros, y qué fue contribuido por nosotros;
●	Ninguna parte de este trabajo se ha publicado previamente a su entrega, excepto donde se han aclarado las correspondientes.


                                 
María Sofía Pérez			Ticiano González
Nro. 157427				Nro. 255124





          
Abstract
Este documento presenta la planificación y documentación del desarrollo de una aplicación web destinada a mejorar la gestión integral de Tatú Taller, un emprendimiento cerámico que ofrece tanto formación como la venta de insumos relacionados. 
El sistema propuesto busca optimizar la reserva de clases, automatizar notificaciones, gestionar la venta de productos y organizar a los usuarios. Para su desarrollo se utilizarán tecnologías como Java con Spring Boot, MySQL, React, HTML, CSS con Tailwind, además de herramientas como GitHub y Trello. Se trabajará bajo la metodología ágil Scrum, organizando el proyecto en Sprint iterativos. 
Como resultado, se espera contar con un sistema funcional y adaptado a las necesidades reales del emprendimiento.

















Palabras clave
●	Gestión de reservas

●	Gestión de clases

●	Ecommerce

●	Notificaciones automáticas

●	Gestión de alumnos

●	Desarrollo web

●	Spring Boot

●	Java

●	React

●	MySQL

●	Tailwind CSS

●	Interfaz de usuario

●	Control de acceso

●	Reservas en línea

●	Gestión de productos

●	Scrum

●	GitHub

●	Trello
 
Índice
Declaración de autoría	1
Abstract	2
Palabras clave	3
Índice	4
Introducción	5
Anteproyecto	6
Presentación del cliente	6
Presentación del problema	7
Alternativas y solución propuesta	8
Tecnologías y herramientas seleccionadas	8
Lista de necesidades	10
Objetivos del proyecto	12
Actores involucrados	13
Lista de requerimientos	14
Requerimientos funcionales	14
Requerimientos no funcionales	23
Alcances y limitaciones	25
Arquitectura	25
Modelos y documentos de diseño	29
Diagrama conceptual	29
Diagrama de casos de uso	30
Plan de proyecto	31
Metodología	31
Plan de gestión de riesgos	32
Identificación de riesgos	33
Clasificación y Priorización de riesgos	33
Estrategias de respuesta	33
Responsables y seguimiento	34
Matriz de riesgos	34
Plan de calidad (SQA)	36
Plan de configuración de software (SCM)	38
Plan de capacitación	40
Capacitación del equipo de desarrollo	40
Capacitación del cliente	40
Cronograma de trabajo y estimación de esfuerzo	41
Compromiso de proyecto	46
ANEXO	47


 
Introducción

El proyecto pretende diseñar y desarrollar una plataforma web para Tatú Taller, un espacio artístico dedicado a la formación en cerámica y a la comercialización de insumos cerámicos. A través de esta solución tecnológica, se busca optimizar la gestión de inscripciones a clases, el registro de asistencias y la venta de productos, acompañando el crecimiento y profesionalización del taller.
Actualmente, Tatú Taller enfrenta desafíos derivados de su reciente expansión, con la apertura de una nueva sede, un aumento en el número de alumnos y una apuesta por seguir creciendo. Este crecimiento ha generado que algunas tareas administrativas se vuelvan más lentas, por lo que la automatización de procesos se presenta como una solución clave para profesionalizar y optimizar la gestión interna.
El proyecto contempla el desarrollo de una solución a medida utilizando tecnologías como Java con Spring Boot para el backend y React para el frontend, siguiendo un enfoque de arquitectura basada en MVC (Modelo-Vista-Controlador) y separación de capas. La plataforma incluirá funcionalidades de registro y autenticación de usuarios, inscripción y control de asistencias, gestión de productos y ventas en línea, así como un panel administrativo para la visualización de estadísticas y la administración general del sistema.
Con esta iniciativa, se busca no solo resolver las necesidades actuales del cliente, sino también sentar las bases para su futura expansión, fortaleciendo su identidad como un espacio comunitario de referencia en el ámbito de la cerámica.





Anteproyecto

Presentación del cliente

Tatú Taller es un espacio dedicado a la cerámica que apuesta por la accesibilidad y la expansión de esta disciplina. Su propuesta combina formación, coworking artístico y comercialización de insumos, creando un ecosistema que facilita el desarrollo de ceramistas en distintas etapas de su camino. Ofrece clases para todos los niveles, desde formación profesional hasta aprendizaje libre, además de un espacio de trabajo compartido donde los ceramistas pueden alquilar un lugar sin necesidad de montar su propio estudio. También dispone de hornos para alquiler y vende insumos cerámicos, consolidándose como un punto de referencia dentro de la comunidad.
En los últimos años, Tatú Taller ha experimentado un crecimiento significativo, reflejado en el aumento de su comunidad y la diversificación de su oferta. Como parte de esta expansión, recientemente inauguraron una nueva sede, reafirmando su compromiso con el crecimiento y la generación de nuevas oportunidades dentro del sector. Sin embargo, este desarrollo ha traído consigo nuevos desafíos en la gestión de su espacio y procesos internos.
El taller es gestionado por un equipo de cuatro personas, todas ellas artistas con trayectorias diversas, cuya convivencia y colaboración han dado forma a un espacio de trabajo con una identidad fuerte y un espíritu comunitario. Su enfoque pedagógico se distingue por la apertura y la flexibilidad en la enseñanza, promoviendo un ambiente accesible, dinámico y en constante evolución.
9 profesores que dan clases, unos 60 alumnos, 17 que usan el trabajo y una cantidad considerable de personas que asisten al taller para hornear sus piezas (aunque no se determina la cifra exacta). Este ecosistema diverso de colaboradores y estudiantes fomenta un ambiente creativo y de intercambio constante.
El vínculo cercano al espacio permitió llegar a Tatú Taller, ya que una de las integrantes del equipo es alumna del taller y ha vivido en primera persona su propuesta de valor y los desafíos organizativos diarios. A partir de esta experiencia, se identificó la oportunidad de aportar una solución tecnológica que facilite su gestión y acompañe su crecimiento.

Presentación del problema

Tatú Taller ha experimentado un importante crecimiento en los últimos años, lo que ha permitido expandir tanto su comunidad como los servicios que ofrece, incluyendo la apertura de una nueva sede. Este avance refleja su compromiso con el desarrollo de la cerámica como una disciplina accesible y abierta para todos. Sin embargo, este crecimiento también ha generado desafíos en la gestión operativa, lo que ha aumentado la carga de trabajo del equipo administrativo y afectado la eficiencia de los procesos internos.
Actualmente, la gestión del taller se lleva a cabo de manera manual y autogestionada. Los principales procesos de negocio incluyen la gestión de clases y alumnos, la reserva de espacios y hornos, y la venta de insumos cerámicos. La inscripción y el seguimiento de los alumnos se realiza mediante hojas de cálculo y comunicación directa por WhatsApp o correo electrónico, lo que dificulta la consulta centralizada de cupos, horarios y estados de inscripción. Por otro lado, las reservas de los espacios de coworking y hornos se coordinan a través de una agenda compartida, lo que genera sobrecarga administrativa y desorganización. Además, la venta de productos cerámicos se realiza de forma presencial, sin un catálogo digital ni un sistema automatizado para controlar el stock.
El aumento de la demanda y la carga administrativa han puesto de manifiesto las limitaciones de los procesos actuales. La falta de automatización implica un uso ineficiente del tiempo, ya que el equipo se ve obligado a realizar tareas repetitivas, lo que les impide enfocarse en actividades estratégicas. Esta gestión manual también aumenta el riesgo de errores en las reservas y clases, generando confusión entre los usuarios. Además, la falta de digitalización limita las posibilidades de expansión, dificultando la implementación de nuevos servicios como la venta en línea de productos cerámicos.
Aunque la situación actual permite mantener un trato cercano y personalizado con los usuarios y una flexibilidad en la gestión de horarios y espacios, también existen desventajas significativas, como la elevada carga operativa y la ineficiencia en la gestión de reservas y clases, que requieren urgentemente un cambio.
Ante este panorama, la propuesta de mejora es desarrollar una plataforma web que automatice la gestión de clases, alumnos y reservas. Además, se integraría un sistema de e-commerce para la venta de insumos cerámicos, ampliando las posibilidades comerciales del taller. Esta solución permitirá mejorar la eficiencia operativa, reducir la carga administrativa y reforzar la identidad de Tatú Taller como un espacio en expansión, alineado con su visión de profesionalización.

Alternativas y solución propuesta

Actualmente, no existe en el mercado un producto que resuelva la problemática de Tatú Taller, ya que las soluciones existentes no están diseñadas para las particularidades de su operación. Si bien es cierto que hay plataformas que ofrecen funcionalidades como la gestión de usuarios o un sistema de e-commerce, estas no son aplicables en este caso, dado que la empresa requiere un producto único, moldeado completamente a sus necesidades y procesos.
La decisión de desarrollar una solución a medida se fundamenta en que nuestro cliente busca una herramienta novedosa y funcional que le permita organizarse mejor y automatizar ciertos procesos clave, como la gestión de reservas de clases y la administración de la base de datos de alumnos. 
Además, al conocer de cerca al cliente, podemos ofrecerle un servicio adaptado diario, generando beneficio mutuo: Tatú Taller tendrá una herramienta personalizada para optimizar su funcionamiento, y nosotros, como desarrolladores, obtendremos experiencia práctica y la satisfacción de entregar un producto acorde a la realidad de la empresa.
Tecnologías y herramientas seleccionadas

Java con Spring Boot  (Backend):

Seleccionamos esta tecnología por su robustez, escalabilidad y el respaldo de una amplia comunidad. Spring Boot nos permite desarrollar APIs RESTful eficientes, facilitando la conexión del backend con múltiples frontends. Aunque reconocemos que actualmente no tenemos una capacitación completa en esta herramienta, consideramos la mejor opción para el proyecto, por lo que planificamos realizar una formación específica que nos permita aprovechar todo su potencial.
Spring Data JPA (Persistencia y acceso a datos):

Elegimos esta como tecnología de persistencia por integración con Spring Boot y su capacidad de simplificar el acceso a bases de datos como MySQL-
React con JavaScript (Frontend):

Esta librería fue elegida por su capacidad de construir interfaces dinámicas e interactivas. React permitirá ofrecer al cliente una experiencia de usuario fluida y moderna, facilitando la navegación y el acceso a las distintas funcionalidades de la plataforma.
Tailwind CSS (Diseño):

Este framework facilita la creación rápida de interfaces limpias y coherentes visualmente. Lo seleccionamos por su flexibilidad y por permitirnos mantener una estética profesional sin la necesidad de desarrollar hojas de estilo personalizadas desde cero.
MySQL (Base de datos):

Elegimos MySQL por su amplia adopción y compatibilidad con las tecnologías seleccionadas. Reconocemos que no contamos con sólidos conocimientos actualmente, pero consideramos que es la mejor alternativa para las necesidades del cliente y planificamos capacitarnos para garantizar un diseño y gestión de base de datos eficiente y escalable.
Proveedor de servidor en la nube:

Optaremos por un servidor en la nube debido a su flexibilidad y escalabilidad, lo que nos permitirá alojar el sistema de manera eficiente. Aunque aún estamos evaluando el proveedor más adecuado, esta opción nos ofrece la capacidad de adaptarnos al crecimiento del proyecto. Además, tomaremos en cuenta los costos de mantenimiento y operación para seleccionar la solución más conveniente a largo plazo. También consideraremos las recomendaciones que recibamos durante el taller d
e deploy para asegurarnos de tomar la mejor decisión.
Scrum (Metodología ágil):
Aplicaremos esta metodología para asegurar una entrega incremental y continua de valor, promoviendo una colaboración constante con el cliente y facilitando la adaptación rápida ante cambios de necesidades. Contamos con una base teórica sólida sobre Scrum, y este proyecto nos permitirá afianzar su aplicación práctica.
GitHub y Trello (Gestión del proyecto):

Utilizaremos GitHub para el control de versiones del código y Trello para la organización del trabajo y seguimiento de tareas. Estas herramientas fomentan una colaboración clara y ordenada entre los miembros del equipo.
En conclusión, todas las tecnologías seleccionadas fueron pensadas en función de las necesidades del cliente y los objetivos del proyecto, priorizando la escalabilidad, la eficiencia y la posibilidad de brindar una experiencia de usuario de calidad, por encima de la comodidad del equipo de desarrollo. Reconocemos los desafíos que implica aprender y dominar estas herramientas, pero estamos comprometidos a capacitarnos para llevar adelante un producto que cumpla con las expectativas de nuestro cliente.


Lista de necesidades

●	N1- Sistema de gestión de reservas de clases:

Permitir que los alumnos reserven sus clases de manera autónoma y organizada, evitando gestiones manuales y asegurando la disponibilidad de los cupos. Este sistema debe ser accesible, claro, fácil de usar y permitir una correcta visualización de las clases disponibles.

●	N2- Base de datos de usuarios y clases:

Contar con un registro seguro y completo de los alumnos, administradores, profesores y clases incluyendo sus datos personales e historial de asistencia. El acceso debe ser sencillo tanto para los administradores como para los alumnos.

●	N3- Navegación clara e informativa para los usuarios:

Ofrecer una navegación fluida y bien estructurada donde los usuarios puedan consultar su historial de clases, próximas reservas y obtener indicaciones claras sobre fechas, horarios y ubicación del taller.

●	N4- Interfaz amigable y accesible:

La plataforma debe ofrecer una experiencia de usuario intuitiva y fácil de usar, asegurando que cualquier persona, independientemente de su nivel de conocimiento técnico, pueda navegar y realizar las acciones necesarias sin dificultad. Además, la interfaz debe cumplir con los estándares de accesibilidad, garantizando que personas con discapacidades, como aquellas con dificultades visuales o motoras, puedan interactuar con el sistema de manera eficiente y sin barreras.

●	N5- Identidad visual del taller reflejada en la plataforma:

El diseño y la estética de la web deben estar alineados con la identidad del taller, transmitiendo su estilo. Esto crea una conexión emocional con los usuarios y fortalece la imagen del taller.

●	N6- Ofrecimiento completo de servicios del taller:

Detallar y organizar la información sobre los servicios del taller, como las clases de cerámica, el coworking, el uso de hornos y la venta de insumos. La plataforma debe permitir a los usuarios conocer todo lo que el espacio ofrece de manera clara y accesible, facilitando la toma de decisiones sobre el uso de estos recursos.

●	N7- E-commerce: 

Crear una tienda online para la venta de productos cerámicos del taller, desarrollando un sistema robusto y seguro para la gestión de compras. El objetivo es ampliar el alcance comercial del taller, optimizando la experiencia de compra en línea, sin que se tenga que gestionar internamente la parte de pagos online. Para ello, se integrará la plataforma de Mercado Libre como medio de pago, garantizando transacciones seguras y fáciles para los usuarios.

●	N8- Integración con Mercado Libre (ML): 

Integrar Mercado Libre como plataforma de pago dentro de la tienda online para facilitar la gestión de pagos de forma segura y eficiente. Esto permitirá que los clientes realicen transacciones de forma directa, sin que el taller tenga que gestionar internamente el proceso de pagos, optimizando tanto la experiencia del usuario como la administración del sistema.

●	N9- Visibilidad y organización para administradores y profesores:

Proveer a los profesores con herramientas claras para consultar el historial de clases, la asistencia de los alumnos y facilitar la planificación de las actividades y recursos del taller.

●	N10- Facilidad de mantenimiento y escalabilidad:

El sistema debe ser diseñado con la flexibilidad necesaria para adaptarse a futuros cambios y la posibilidad de agregar nuevas funcionalidades o realizar ajustes según evolucione el taller.
●	N11 - Acceso seguro al sistema:

 El sistema debe permitir el registro, inicio de sesión y cierre de sesión para alumnos y administradores. El acceso debe ser seguro, utilizando la opción de inicio de sesión mediante cuentas de Google para los usuarios. Además, el sistema debe garantizar que los usuarios puedan cerrar sesión de manera segura y eficiente, protegiendo sus datos personales y evitando accesos no autorizados.
●	N12 - Gestión de roles y permisos:

El sistema debe permitir la gestión eficiente de diferentes roles de usuario (como administradores, profesores y alumnos), asignando permisos específicos a cada uno según sus funciones dentro de la plataforma. Esto garantizará que cada tipo de usuario pueda acceder únicamente a las funcionalidades y datos que le corresponden, manteniendo la seguridad y privacidad de la información. La plataforma debe ser flexible para agregar o modificar roles según sea necesario.



Objetivos del proyecto  

ID	TÍTULO	DESCRIPCIÓN	INDICADOR	FECHA
1	Capacitación previa	Realizar la capacitación necesaria en tecnologías clave antes de comenzar a programar.	90% de la capacitación terminada en Java Spring Boot, React y MySQL.	Antes de la primera línea de código
2	Producto en condiciones de poder ser utilizado	Entregar un producto completamente funcional y testeado al finalizar el proyecto.	Sistema operativo con pruebas de aceptación superadas en más del 90%.	Entrega final
3	Mantener el orden y la documentación y artefactos actualizada	Aplicar correctamente la metodología ágil Scrum a lo largo del proyecto.	Realizar al menos el 90% de las ceremonias principales (daily, planning, review, retro).	Durante todo el proyecto
4	Entrega producto de software de calidad	Implementar pruebas unitarias en componentes críticos del backend y frontend.	Cobertura mínima del 90% en funciones críticas.	Antes de la entrega final
5	Cumplimiento del alcance	Completar al menos el 90% de los requerimientos definidos inicialmente.	Porcentaje de historias finalizadas respecto al backlog inicial ≥ 90%.	Entrega final
6	Calidad del código	Mantener una alta calidad del código durante todo el desarrollo.	Resultado de 90% en análisis de calidad del código (uso de herramientas de análisis estático).	Durante todo el proyecto
7	Gestión de tiempos de desarrollo	Cumplir con los tiempos establecidos para la implementación de cada funcionalidad o historia de usuario.	90% de las historias completadas dentro del tiempo estimado.	Durante todo el proyecto


Actores involucrados

●	Beneficiarios Directos
Los principales beneficiarios del proyecto serán Tatú Taller y sus usuarios. El taller contará con una plataforma que optimizará la gestión de clases, el historial de los alumnos y la reserva de espacios. Esto les permitirá mejorar la organización interna y proporcionar un servicio más eficiente tanto a los ceramistas como a los estudiantes.
Asimismo, los alumnos y ceramistas que interactúan con el taller disfrutarán de una experiencia más ordenada y accesible, facilitando la interacción con las distintas actividades y servicios que ofrece el espacio.


•	Responsables del Desarrollo
El proyecto lo ejecutarán los estudiantes del equipo de desarrollo, quienes se encargarán de crear e implementar la plataforma. Durante el proceso, nos encargaremos de analizar y aplicar los conocimientos adquiridos durante nuestra formación académica, enfrentándonos a nuevos desafíos técnicos que nos permitirán crecer profesionalmente. 
●	Toma de decisiones
Las decisiones clave relacionadas con el proyecto serán tomadas principalmente por los responsables de Tatú Taller, quienes definirán las especificaciones funcionales y operativas de la plataforma. Su involucramiento será esencial para garantizar que el producto final cumpla con sus expectativas y necesidades.
Adicionalmente, el tutor académico supervisará el avance del proyecto, brindando retroalimentación sobre las metodologías de trabajo, asegurando que se cumplan los estándares académicos y orientando en cuanto a buenas prácticas en el desarrollo de software.
●	Financiamiento
Aunque el proyecto es académico, Tatú Taller asumirá los costos asociados al dominio y al servidor, si es necesario, para garantizar el funcionamiento de la plataforma una vez completado el proyecto. Este compromiso financiero asegurará la viabilidad del sistema a largo plazo.
Por su parte, nosotros, como equipo de desarrollo, contribuiremos al proyecto con nuestro tiempo, esfuerzo y aprendizaje. Este trabajo nos permitirá adquirir valiosas experiencias creando software, y desarrollar un producto adaptado a las necesidades y expectativas del cliente.

Lista de requerimientos

Requerimientos funcionales

ID	Nombre	Descripción	Prioridad
RF01	ABM (alta, baja y modificación) de clases	Los administradores y profesores deben poder gestionar las clases en el sistema, lo que incluye crear nuevas clases, modificar detalles de las existentes y eliminar clases que ya estén programadas o disponibles. 
Esta funcionalidad debe ser accesible a través de una interfaz de usuario clara y sencilla. Los cambios deben reflejarse automáticamente en la plataforma para mantener la disponibilidad y la organización de las clases actualizadas.	ALTA
RF02	Reserva de clases para alumnos	Los alumnos previamente logueados podrán seleccionar y reservar clases disponibles de manera autónoma, con la posibilidad de elegir entre los horarios, cupos y talleristas disponibles. 	ALTA
RF03	Confirmación de reserva	Una vez realizada la reserva, el sistema deberá generar y mostrar automáticamente la confirmación detallada con la información de la clase, días, horario y tallerista seleccionados.	MEDIA
RF04	Cancelación de reservas	Los alumnos tendrán la opción de cancelar sus reservas 48 horas antes del comienzo del mes. En el caso contrario, el sistema no permitirá la cancelación	MEDIA
RF05	Gestión de cupos disponibles	El sistema deberá actualizar automáticamente los cupos disponibles en tiempo real, garantizando que los usuarios siempre vean la cantidad correcta de clases disponibles al momento de realizar una reserva.	ALTA
RF06	Notificaciones de recordatorio	En la sección de mensajes, los alumnos deberán recibir recordatorios automáticos a los alumnos sobre las clases próximas, indicando la fecha, hora y lugar, 24 horas antes del comienzo de esta.	BAJA
RF07	Visualización de clases 	El sistema deberá mostrar de manera clara e intuitiva mediante un calendario todos los cursos mensuales disponibles para reserva, detallando la fecha, hora, tallerista a cargo y cupos restantes 	ALTA
RF08	Listado de clases previas.	El sistema deberá mostrar a los alumnos un listado de los días de clase dictados junto a la asistencia correspondiente	MEDIA
RF09	Registro de asistencias	Los profesores podrán pasar lista en clase marcando la asistencia o no asistencia de los alumnos inscriptos al curso en cuestión.	ALTA
RF10	Alerta por 3 faltas consecutivas	El sistema deberá informar al alumno a través de la sección de mensajes la inasistencia consecutiva. El sistema también informará a los administradores en su sección de mensajes de alerta. Ellos tendrán la potestad de ignorar la alerta, multar o dar de baja al alumno como consecuencia.	MEDIA
RF11	Notificaciones por cambio de clases	El sistema notificará con una antelación de al menos 24hs al alumno mediante la sección mensajes cuando alguna característica de alguna clase de su curso (horario, día) sea modificada.	BAJA
RF12	Acceso a la información de alumnos	El sistema debe permitir a los administradores y profesores consultar la información completa de los alumnos, incluyendo sus datos personales y el historial de clases en las que se han inscripto. No así sus credenciales para el inicio de sesión.	ALTA
RF13	Eliminación de alumnos	El sistema debe permitir eliminar registros de alumnos cuando sea necesario, garantizando que se eliminen tanto los datos personales como el historial de clases asociados.	ALTA
RF14	Actualización de datos de alumnos	El sistema debe permitir que los alumnos puedan modificar datos personales, como dirección, número de teléfono, entre otros.	ALTA
RF16	Búsqueda de alumnos	El sistema debe permitir a los administradores realizar búsquedas de alumnos por nombre o cédula, en su defecto aparecerá la lista completa de alumnos registrados 	ALTA
RF17	Integración con clases 	El sistema debe permitir asociar a los alumnos con las clases en las que se inscriben, registrando la relación entre el alumno y las clases de forma clara y precisa.	ALTA
RF18	Estructura de navegación intuitiva.	La plataforma debe contar con una barra de navegación o menú principal visible en todas las páginas. Además, debe incluir secciones clave como "Historial de clases", "Próximas reservas", "Fechas y horarios" y "Ubicación del taller". Los elementos deben estar organizados jerárquicamente para facilitar el acceso rápido a la información.	ALTA 
RF19	Actualización en tiempo real de la información	El sistema debe actualizar automáticamente los datos de clases, reservas y horarios en tiempo real para mantener la información disponible al usuario siempre actualizada	ALTA
RF20	Accesibilidad a la información del usuario	Debe haber una pantalla de inicio que muestre resúmenes visuales de las próximas clases, el historial de reservas y cualquier acción pendiente. Los enlaces o botones deben estar bien diferenciados para realizar reservas, visualizar clases pasadas o próximas y consultar detalles sobre la ubicación.	ALTA
RF21	Indicaciones claras	Las fechas y horarios deben destacarse con colores y tipografías que faciliten la lectura. También se debe integrar un mapa interactivo para que los usuarios puedan localizar fácilmente el taller.	MEDIA
RF22	Barra de búsqueda general 	La plataforma debe contar con una barra de búsqueda en el menú principal que permita localizar rápidamente clases, talleres o cualquier información relevante.	MEDIA 
RF23	Diseño limpio	La plataforma debe tener espacios amplios entre los elementos, botones de acción grandes y fáciles de identificar. Se deben utilizar íconos y etiquetas claras para cada sección y acción. Los colores y tipografía deben ser legibles y amigables para la vista.	ALTA
RF25	Mensajes claros	La plataforma debe mostrar mensajes de error, advertencia o confirmación fáciles de entender cuando los usuarios realicen una acción o cuando haya algún problema.
	ALTA
RF26	Diseño alineado con la identidad del taller	El diseño debe hacer uso consistente de los colores, tipografía y logotipo del taller en toda la plataforma. 	ALTA 
RF27	Experiencia visual integrada	El diseño visual debe ser consistente entre la plataforma y redes sociales, reforzando la identidad del Taller	ALTA
RF28	Presentación clara de servicios	La plataforma debe contar con secciones bien definidas para cada servicio y éste deberá tener una descripción detallada sobre qué incluye. También cada sección tendrá su imagen representativa para dar una visión más completa a los usuarios. 	MEDIA
RF29	Acceso a información adicional	La plataforma contará con una sección de preguntas frecuentes para resolver dudas. También se debe proporcionar acceso a contacto directo para consultas sobre servicios.	MEDIA
RF30
	Carrito de compras	El sistema debe permitir agregar productos disponibles a un carrito de compras persistente durante la sesión sin necesidad de estar registrado.	ALTA
RF31
	Visualización del contenido del carrito	El sistema debe permitir revisar el contenido del carrito en cualquier momento con subtotales, cantidades y total general.	ALTA 
RF32	Modificación del carrito	El sistema debe permitir al usuario eliminar, vaciar y cambiar cantidades de los productos ingresados en el carrito de compras antes de continuar con la misma.	ALTA
RF33	Accesibilidad del carrito en todo el sitio	El ícono del carrito debe estar visible en toda la navegación para facilitar el acceso rápido.	MEDIA
RF34	Validación de stock en tiempo real	El sistema debe verificar el stock disponible antes de permitir agregar un producto al carrito y nuevamente antes de redirigir al pago. Si no hay disponibilidad, el sistema enviará un mensaje al usuario y no se agregará el producto al carrito. 	
RF35	Visualización pública de productos	El sistema debe permitir a cualquier usuario, sin necesidad de registro, navegar libremente por la tienda online y ver la oferta de productos.	ALTA
RF36	Detalle del producto	Los usuarios deben poder acceder al detalle de cada producto (nombre, descripción, precio, imagen) sin necesidad de registro. Debe haber un botón de agregar al carrito desde esta página.	MEDIA
RF37	Filtrado de productos	El usuario debe poder buscar productos por nombre, categoría o precio, y aplicar filtros como tipo de producto o rango de precio	MEDIA
RF38	Pago con Mercado Pago	Al confirmar el pedido, el usuario deberá iniciar sesión en la plataforma en el caso de no haberse logueado. Si el usuario no tiene cuenta, se le muestra la opción de registro. Una vez registrado o logueado con éxito podrá el sistema redirigirá al usuario al entorno de pago de Mercado Libre con los datos del pedido. 	ALTA
RF39	Confirmación del pedido tras la compra	Una vez completado el pago con Mercado Libre o confirmado el pedido con método de pago en efectivo el sistema debe redirigir al usuario a una página de “compra exitosa”, con un resumen del pedido y agradecimiento	ALTA
RF40	Alta de pedido	Una vez completado el pago en Mercado Libre, el sistema deberá recibir y procesar la confirmación automática del pago exitoso para ingresar al pedido a la base de datos así el taller puede tener acceso a él y seguir su curso.  El pedido tendrá un estado pendiente de forma inicial.	ALTA
RF41	Notificación de pedido nuevo	El sistema enviará una notificación a los administradores en la sección pedidos pendientes con la información detallada del pedido y del cliente para poder entregarlo posteriormente. Los administradores deben cambiar el estado del pedido a “entregado” una vez completado el mismo. 	ALTA
RF42	Visualización de historial de pedidos	Los usuarios con registro deben poder ver el historial de compras junto con el estado de cada pedido. 	MEDIA

RF43	Visualización de políticas de envío y devoluciones	Los productos y el proceso de compra deben mostrar accesos visibles a las políticas de envío y devoluciones.	ALTA
RF44	Recompra rápida 	Desde el historial de compras, el usuario debe poder repetir pedidos anteriores si los productos aún están disponibles, en el caso de no estarlo, el sistema mostrará mensaje de error. 	BAJA
RF45	Elección de método de pago	El carrito deberá ofrecer dos opciones de pago: efectivo o mercado pago. En ambos casos el usuario deberá estar registrado y logueado en la plataforma para poder confirmar el mismo. 	
RF46	Pago en efectivo	Una vez seleccionado el método de pago en efectivo, el sistema redirigirá al usuario a la página de "gracias por tu compra” mostrando métodos de comunicación con el taller (teléfono de contacto y mail). El pedido quedará dado de alta en la base de datos con un estado “pendiente”.	
RF47	Recuperación de carrito abandonado	Si un usuario deja el carrito sin completar la compra, el sistema podrá recordárselo al volver al ingresar a la plataforma.	BAJA
RF48	ABM de productos 	Los administradores podrán agregar, modificar y eliminar productos disponibles en la tienda, así como actualizar stock e imágenes	ALTA
RF49	Reporte de ventas del ecommerce 	El sistema debe ofrecer una gráfica de las ventas mes/producto.
	ALTA
RF50	Login de usuarios	El sistema debe permitir a los usuarios previamente registrados hacer el inicio de sesión con sus credenciales correctas. En caso de error, el sistema informará y permitirá intentarlo nuevamente.	ALTA
RF51	Logout de usuarios	El sistema debe permitir a los usuarios mediante un botón visible en todas las páginas de la plataforma, salir de sesión.	ALTA
RF52	Registro de alumnos.	El sistema debe permitir que nuevos usuarios se registren creando una cuenta mediante la introducción de su nombre completo, dirección de correo electrónico válida y una contraseña segura.
  El sistema debe validar que el correo no esté previamente registrado y notificar al usuario en caso de errores durante el proceso. 
Los datos del nuevo usuario deben almacenarse en la base de datos del sistema al finalizar exitosamente el registro.	ALTA
RF53	Asignación automática de rol en el registro	Al registrarse, un usuario será asignado automáticamente al rol "Alumno", y solo un administrador podrá modificar su rol posteriormente	ALTA
RF55	ABM de profesores	El sistema debe permitir a los administradores dar de alta, baja o modificar a los usuarios profesores. 	ALTA




Requerimientos no funcionales


RNF01 – Deploy Web

La aplicación debe estar disponible a través de un servidor web accesible tanto desde computadoras como dispositivos móviles.
RNF03 – Responsive Design

La interfaz debe estar optimizada para distintos tamaños de pantalla, garantizando una experiencia fluida en smartphones, tablets y computadoras.

RNF04 – Navegación Intuitiva y accesible

El diseño debe ser simple, claro y accesible, permitiendo que tanto alumnos como administradores puedan utilizar la plataforma sin necesidad de asistencia técnica.
Debe también cumplir con las pautas de accesibilidad web (WCAG 2.1) para garantizar que sea accesible para todos los usuarios. Esto incluye asegurar contrastes de color adecuados para personas con dificultades visuales, soporte para lectores de pantalla y navegación por teclado. Los controles interactivos deben ser manejables por personas con limitaciones motoras.

RNF05 – Manual de Usuario

Se debe elaborar un manual digital de uso que explique las principales funcionalidades del sistema (registro, inscripción, asistencia, etc.).


RNF06 – Material Audiovisual Complementario

Se deben desarrollar videos cortos de capacitación que complementen el manual, mostrando cómo realizar acciones comunes dentro del sistema.

RNF07 – Gestión de Sesiones Seguras

El sistema debe garantizar la seguridad de las sesiones de usuario mediante autenticación segura y cierre de sesión automático tras inactividad prolongada.

RNF08 – Protección de Datos Personales

La información personal de los usuarios debe resguardarse cumpliendo con buenas prácticas de protección de datos, como cifrado de contraseñas y uso de HTTPS.
RNF09 – Escalabilidad

La aplicación mantendrá un buen desempeño, se le realizaran pruebas de stress, la misma deberá soportar hasta un máximo de 10 personas sin bajar el rendimiento.
RNF 10 – Navegador

La plataforma web deberá ser soportada por navegadores Google Chrome, Mozilla Firefox y Edge. Se probarán en los diferentes navegadores para probar su buen funcionamiento.
RNF 11- Persistencia de la información

Toda la información se almacenará en una base de datos
RNF 12 – Escalabilidad

La aplicación mantendrá un buen desempeño, se le realizaran pruebas de stress, la misma deberá soportar hasta un máximo de 10 personas sin bajar el rendimiento.
RNF 13 - Integración con API Externa (Mercado Pago)

El sistema debe integrar la solución Checkout Pro de Mercado Libre configurándola a través de la documentación y guía expuesto por ML/developers. La configuración será para páginas web y el cliente deberá otorgar las credenciales necesarias para poder completar de manera exitosa la integración

Alcances y limitaciones

El objetivo de este proyecto es desarrollar una plataforma web para la gestión del taller de cerámica. Dentro del alcance se incluye la posibilidad de que los alumnos se registren, inicien sesión, se inscriban a clases y cursos, consulten su historial de asistencias y accedan a la información de los servicios adicionales propuestos, como el alquiler de horno y espacio de coworking. También tendrán acceso a una tienda online con productos del taller, donde se habilitará el pago online a través de Mercado Libre para la compra de productos.
El sistema enviará notificaciones automáticas ante determinadas situaciones, como recordatorios de clase, cambios de horario o faltas reiteradas.
Por parte de los administradores, la plataforma permitirá gestionar la base de datos de alumnos, registrar asistencias, modificar horarios, administrar productos del ecommerce y visualizar estadísticas relevantes desde un panel de control. También se incluirá la posibilidad de gestionar los roles de los usuarios.
Quedan fuera del alcance del proyecto para esta instancia pudiendo ser objetivo de mejora para el futuro, el desarrollo de una app móvil nativa, la gestión contable del taller, las funcionalidades de comunicación interna como mensajería entre usuarios, la gestión de reservas de hornos y de espacio de coworking, y la cadetería de los productos comprados.
Arquitectura

La arquitectura propuesta para la aplicación web de Tatú Taller se basa en una estructura de alto nivel y un patrón MVC para el backend. Esta organización permite una gestión clara y eficiente tanto en el desarrollo como en el mantenimiento del sistema.
La arquitectura de alto nivel describe cómo los distintos componentes del sistema interactúan entre sí. En este caso, el sistema se divide en tres capas principales:
1.	Cliente (Frontend): La interfaz con la que los usuarios interactúan. En nuestro proyecto, esta capa está desarrollada utilizando React para la interfaz de usuario y Tailwind CSS para el diseño responsivo. El frontend se comunica con el backend mediante solicitudes HTTP, enviando datos de los usuarios (alumnos, profesores, administradores) y recibiendo respuestas procesadas por el backend.
2.	Backend (Servidor): Es el componente central que se encarga de procesar las solicitudes del frontend, gestionar la lógica de negocio y acceder a los datos almacenados en la base de datos. El backend está desarrollado en Java utilizando el framework Spring Boot, y sigue el patrón MVC para garantizar una organización clara y eficiente de la lógica interna.
3.	Base de Datos: En nuestra aplicación, la base de datos MySQL almacena toda la información relevante de la plataforma, como datos de usuarios, clases, productos, y reservas. El backend interactúa con la base de datos para realizar operaciones de lectura, escritura y actualización según las solicitudes del frontend.
Esta arquitectura de alto nivel asegura que la comunicación entre el cliente, el backend y la base de datos sea eficiente, escalable y bien organizada. Además, facilita la integración de nuevos componentes, como servicios externos o APIs (por ejemplo, para pagos con Mercado Pago o autenticación con Google OAuth 2.0), sin afectar el funcionamiento general del sistema.
El backend de Tatú Taller sigue el patrón MVC (Modelo-Vista-Controlador) para organizar la lógica interna de manera eficiente. Este patrón permite separar la aplicación en tres componentes principales:
1.	Modelo (Model): El modelo se encarga de la gestión de los datos y la lógica de negocio. En el contexto de nuestra aplicación, el modelo interactúa directamente con la base de datos a través de Spring Data, realizando operaciones CRUD (crear, leer, actualizar, eliminar) para mantener actualizada la información. Además, el modelo contiene las reglas de negocio, como el cálculo de precios de clases o la verificación de disponibilidad de productos.
2.	Vista (View): En un backend basado en Spring Boot, la vista no es directamente responsable de la presentación, ya que se enfoca más en la generación de respuestas que se enviarán al frontend. En este caso, la vista está representada por los datos en formato JSON que el controlador envía al frontend (React). La vista, por lo tanto, se limita a la presentación de datos y no tiene ninguna lógica de procesamiento.
3.	Controlador (Controller): El controlador actúa como el intermediario entre el modelo y la vista. En nuestra aplicación, el controlador gestiona las solicitudes HTTP que llegan desde el frontend (por ejemplo, el registro de un usuario, la reserva de clases, etc.). El controlador recibe estas solicitudes, invoca la lógica de negocio del modelo y devuelve los datos correspondientes al frontend en formato JSON. Además, el controlador se encarga de manejar las respuestas a las acciones del usuario, como la creación de clases, la consulta de reservas y la gestión de usuarios.
La separación en capas del sistema, tanto en el patrón MVC como en la arquitectura de alto nivel, facilita el mantenimiento y la escalabilidad del sistema. Cada componente tiene una responsabilidad clara, lo que hace más fácil realizar modificaciones o ampliaciones sin afectar otras partes de la aplicación. Además, esta organización mejora la modularidad, permitiendo cambios en el frontend o en el backend de forma independiente.
El uso del patrón MVC en el backend garantiza que la lógica de negocio, la presentación y la gestión de datos estén bien separadas, lo que mejora la organización del código y facilita el mantenimiento a largo plazo.

 Ilustración 1. Diagrama MVC


 
Ilustración 2. Arquitectura de alto nivel



Modelos y documentos de diseño


■	Diagrama conceptual


 
Ilustración 3. Diagrama Conceptual


Diagrama de casos de uso

 
Ilustración 4. Diagrama de Casos de Uso






Plan de proyecto


Metodología

Para la gestión y desarrollo del proyecto se optó por utilizar un marco de trabajo ágil basado en Scrum, adaptado a la realidad de nuestro equipo, conformado por dos desarrolladores con el acompañamiento de un tutor. Desde el inicio del proyecto, se decidió adoptar esta metodología, ya que permite organizar el trabajo de manera iterativa e incremental, favoreciendo una planificación clara, entregas frecuentes y la capacidad de adaptarse a los cambios que puedan surgir durante el desarrollo.
La aplicación de Scrum comenzó el 24 de marzo, fecha en la que se llevó a cabo la primera reunión con el cliente. En dicha instancia se identificaron las principales necesidades del espacio y del equipo de gestión, lo cual sirvió de punto de partida para, posteriormente, trazar los requerimientos funcionales y no funcionales del sistema a desarrollar. A partir de esa reunión inicial se realizó una planificación interna y se dio comienzo al primer Sprint, estableciendo una dinámica de trabajo basada en iteraciones de dos semanas de duración, que se mantendrá constante durante todo el proyecto.
Dado que el equipo de trabajo está compuesto únicamente por dos personas, el marco de Scrum ha sido adaptado a nuestras posibilidades. Ambos integrantes conformamos el equipo de desarrollo y, al mismo tiempo, asumimos las responsabilidades correspondientes a los demás roles del marco, como Scrum Máster y Product Owner. Esto implica que nos encargamos de facilitar las ceremonias, priorizar tareas, organizar el Backlog y asegurar que se cumpla con el marco metodológico. El cliente, por su parte, participa como stakeholder, aportando información clave, validando entregas y acompañando el avance del proyecto.
Las reuniones diarias se implementan en un formato adaptado, mediante el envío de audios breves en los que compartimos avances, obstáculos y objetivos del día, permitiendo mantener una comunicación fluida, coordinación y seguimiento constante. Al finalizar cada Sprint, se realiza una revisión con el cliente y una retrospectiva interna, sosteniendo así las ceremonias fundamentales del marco ágil con los recursos disponibles.
Como herramienta de apoyo para la gestión del trabajo, utilizamos Trello para organizar el Backlog del producto y los tableros correspondientes a cada Sprint. Esta herramienta nos permite visualizar el estado de las tareas, asignar responsabilidades, registrar el progreso y facilitar el monitoreo tanto entre los miembros del equipo como por parte del tutor.
La elección de esta metodología y su implementación adaptada nos ha permitido avanzar con claridad, estructura y flexibilidad, manteniendo siempre el foco en la entrega continua de valor y el cumplimiento progresivo de los objetivos del proyecto.

Plan de gestión de riesgos


La gestión de riesgos es fundamental para asegurar que el proyecto se desarrolle de manera exitosa y que podamos cumplir con los plazos y objetivos establecidos. Desde el inicio del proyecto, implementamos un enfoque sistemático para identificar, clasificar y gestionar los riesgos. Este proceso es continuo y se revisa periódicamente en cada Sprint Planning y Sprint Retrospective.

Identificación de riesgos
Los dos miembros del equipo identificaron riesgos juntos. Iniciamos este proceso con una lluvia de ideas, donde todos identificaron posibles riesgos tanto técnicos como operativos. También analizamos los requerimientos obtenidos durante la reunión con el cliente, lo cual nos permitió identificar posibles riesgos relacionados con la ambigüedad de algunos requerimientos o con la viabilidad de ciertas funcionalidades. Además, se realizó un análisis FODA que permitió identificar fortalezas, oportunidades, debilidades y amenazas del proyecto, lo que nos dio una visión más clara de los riesgos a los que podríamos enfrentarnos. Este análisis fue expuesto y discutido para garantizar que todos los riesgos fueran debidamente comprendidos y abordados.
Hasta el momento, no hemos consultado expertos; pero consideramos que podría ser útil en el futuro si surgen dudas técnicas o riesgos que no podamos abordar internamente y, de ser necesario, lo implementaremos para mejorar la gestión del proyecto.
Clasificación y Priorización de riesgos
Una vez identificados los riesgos, se procedió a clasificarlos según tres criterios: probabilidad, impacto y exposición al riesgo. 
La probabilidad fue determinada con base en la posibilidad de que un riesgo ocurriera, clasificándose como:
1.	Baja:  El riesgo tiene menos del 30% de probabilidad de ocurrir. 
2.	Media:  El riesgo tiene una probabilidad de ocurrir entre el 30% y el 70%. 
3.	Alta: El riesgo tiene más del 70% de probabilidad de ocurrir en el proyecto. 
El impacto se evaluó en términos del daño que el riesgo podría causar al proyecto, y también se clasificó en: 
1.	Bajo: El impacto es mínimo. Puede resultar en una demora de menos de un 10% del tiempo total. No afectará la funcionalidad principal del sistema ni la satisfacción del cliente.
2.	Medio: El impacto tiene efectos notables, pero no compromete el proyecto por completo. Puede causar un retraso de entre un 10% y un 30% afectando la calidad, pero sin impedir el éxito del proyecto. 
3.	Alto: El riesgo tendrá consecuencias significativas y afectará de manera crítica al proyecto. Esto puede incluir retrasos importantes, pérdida de calidad, o incluso la cancelación del proyecto.
Finalmente, calculamos la exposición al riesgo, que es el resultado de combinar la probabilidad y el impacto, lo que nos permitió priorizar los riesgos que tienen mayor potencial de afectar el desarrollo del proyecto.
Estrategias de respuesta
Para cada riesgo identificado, definimos estrategias de respuesta que incluyen acciones preventivas, para evitar que ocurran; acciones de mitigación, para reducir la probabilidad y el impacto de los riesgos; y planes de contingencia, que se activarían si los riesgos se materializan. Estas estrategias ya están implementadas y se revisan en cada Sprint para asegurar que sigan siendo efectivas.

Responsables y seguimiento
El seguimiento y la gestión de los riesgos son los encargados directos del desarrollo del proyecto, solo de los dos miembros del equipo. Esto nos permite actuar rápidamente ante cualquier riesgo que se identifique y asegurarnos de que las medidas preventivas o correctivas se implementen de manera oportuna.
Matriz de riesgos
Los riesgos identificados se organizaron en una matriz de riesgos, la cual facilita la visualización de los riesgos con mayor probabilidad e impacto. Esta herramienta nos ayuda a priorizar la atención y los recursos en los riesgos más críticos, asegurando que podamos gestionarlos de forma efectiva y eficiente a lo largo del proyecto.


Identificación	Detalle	Probabilidad	Impacto	Nivel de exposición
R1	Cambios en los requerimientos del cliente	Alta	Alta	Alta
R2	Cambios de prioridades del cliente	Media	Alta	Alta
R3	Falta de disponibilidad del cliente	Media	Alta	Alta
R4	Subestimación de los tiempos de trabajo 	Media	Alta	Alta
R5	Fallas técnicas con las herramientas utilizadas	Media	Alta	Alta
R6	Pérdida de datos	Media 	Alta	 Alta
R7	Enfermedad de un integrante	Media	Alta	Alta
R8	Inexperiencia con tecnologías propuestas	Alta	Media	Alta
R9	Cambios en los requerimientos en etapas tardías	Media	Alto	Alto
R10	Falta de entendimiento entre los integrantes	Media	Media	Media
R11	Conflictos personales o desmotivación.	Baja	Alta	Media
R12	Cambios en la disponibilidad horaria	Media	Media	Media
R13	Falta de documentación clara	Media	Media	Media
R14	Falta de foco debido a otras actividades académicas	Media	Media	Media
R15	Dificultad para implementar un diseño simple y fácil de comprender	Baja	Media	Baja

Tabla 1. Riesgos identificados

Identificación	Plan de mitigación	     Plan de contingencia

R1	Registrar todo en documentación; validar con cliente antes de avanzar	Modificar alcance del proyecto.
R2	Mantener motivado al cliente con entrega de incrementos. Firma de acuerdo de compromiso.	Modificar alcance del proyecto.
R3	Coordinar agenda con antelación y mantener canales alternativos de comunicación.	Avanzar según lo pautado.
R4	Realizar una planificación realista y añadir margen de tiempo para posibles imprevistos.	Modificar alcance del proyecto.
R5	Backups frecuentes y pruebas exhaustivas antes de las entregas de cada incremento.	Cambiar las tecnologías propuestas por las de mayor conocimiento y experiencia por parte del equipo. Modificar alcance del proyecto.
R6	Gestión de versionado riguroso en GitHub con buenas prácticas y backups con versionados en carpetas.	Modificar alcance del proyecto y rehacer tareas.
R7	Estar en conocimiento de las responsabilidades de cada integrante; utilizar tablero de tareas organizado y actualizado	Modificar alcance del proyecto
R8	Capacitación inicial y división por fortalezas	Modificar el alcance y utilizar tecnologías conocidas.
R9	Gestionar los cambios de manera rigurosa y evaluar el impacto de estos en el cronograma antes de aprobarlos.	Modificar alcance del proyecto.
R10	Comunicación diaria por mensaje de audio, reuniones por sprint, organización exhaustiva mediante tablero. 	
R11	Objetivos claros, empatía y diálogo constante.	
R12	Planificación semanal con margen	
R13	Documentar en tiempo real y usar herramientas compartidas	
R14	Planificación cruzada de entregas; seguimiento del calendario institucional	
R15	Aplicar principios de diseños simples y revisar continuamente las decisiones de arquitectura desde etapas tempranas y durante todo el proyecto.	

Tabla 2. Gestión de riesgos


Plan de calidad (SQA)


Para asegurar un desarrollo ordenado y un producto final con los requisitos del cliente, se definió un plan de calidad que abarca tanto el código fuente, el producto final, el proceso de desarrollo y la documentación.
Buenas prácticas 

El lenguaje de programación principal será Java, utilizando el framework Spring Boot, por lo que se adoptarán convenciones de estilo y organización generalmente aceptadas en este ecosistema. Entre las principales decisiones se destacan:
●	Nomenclatura clara y consistente:
Las clases se nombrarán utilizando Pascal Case.
Las variables y métodos se nombrarán en camel Case.
Los atributos privados se indicarán, en lo posible, con un guion bajo inicial.
Se evitarán nombres genéricos o poco descriptivos para favorecer la comprensión del código.

●	Buena legibilidad y uso de comentarios:
Se fomentará el uso de comentarios breves que expliquen la lógica detrás de los bloques de código más relevantes, sin caer en la sobre explicación.
Se utilizarán bloques de documentación para describir el propósito general de las clases y los métodos, siguiendo el estándar de comentarios de JavaDoc.

●	Estructura y organización del código:
Se respetará la estructura típica de proyectos Spring Boot (separación clara entre controladores, servicios, repositorios y modelos).
Los métodos serán breves, con responsabilidades bien definidas, y se aplicará la división en funciones auxiliares si es necesario.
Se evitará la repetición innecesaria de código mediante la reutilización y la correcta abstracción.

●	Control de errores:
Se implementará un manejo adecuado de excepciones mediante bloques try-catch, especialmente en interacciones con la base de datos o en la recepción de datos externos.
Las excepciones personalizadas se utilizarán en los casos en que se deseen mensajes específicos o flujos de control diferenciados.

●	Evitar hardcodeados:
Se utilizarán constantes para representar valores fijos en lugar de escribir esos valores directamente en el código.

●	Validación y pruebas durante el desarrollo:
Aunque no se implementarán herramientas automatizadas avanzadas, se pondrá foco en validar el código frecuentemente mediante ejecución manual de pruebas y revisión mutua entre los integrantes.
En algunos casos, se podrán utilizar herramientas simples del entorno de desarrollo como inspecciones automáticas del IDE (IntelliJ) para identificar código duplicado, no utilizado o mal estructurado.

Calidad del proceso

Para garantizar un seguimiento efectivo del proyecto se utilizará una versión adaptada de Scrum, con planificación de tareas por Sprint, revisión de avances e identificación temprana de desvíos.
El backlog será gestionado mediante Trello, lo que permite visualizar claramente el estado de cada tarea y los responsables.
Calidad del producto

Se realizarán distintos tipos de pruebas a lo largo del desarrollo:
●	Pruebas unitarias: cada componente será probado de forma individual para asegurar su correcto funcionamiento.

●	Revisión de código por pares: cada integrante probará funcionalidades desarrolladas por el otro.

●	Revisión de código asistida: Revisión automática del código mediante herramientas de IA (ChatGPT) para detectar errores, malas prácticas y complejidad innecesaria antes de pruebas funcionales.

●	Pruebas de integración: una vez integradas los distintos incrementos, se verificará que interactúen correctamente entre sí.

●	Pruebas de sistema: en etapas avanzadas se probará el sistema de forma completa, evaluando flujos reales de uso.

●	Pruebas con el cliente (UAT): al finalizar cada sprint se validará junto al cliente la funcionalidad entregada.

Los casos de prueba se documentarán claramente, registrando los escenarios esperados y los resultados obtenidos. De esta manera se asegura trazabilidad y posibilidad de retrabajo si es necesario.
Calidad de la documentación

Se seguirán los lineamientos de la Universidad en los documentos 302, 303 y 306.
La documentación incluirá tanto aspectos técnicos del sistema como justificaciones de diseño, arquitectura utilizada y decisiones tomadas durante el proceso. También se documentará cómo se realizaron las pruebas y los resultados obtenidos.
Gestión de cambios y retrabajo

Ante la detección de errores o cambios en los requerimientos, se registrará el origen del hallazgo, la acción tomada, su impacto y las tareas derivadas. Estos cambios serán gestionados y replanificados dentro de los Sprint siguientes según su prioridad y complejidad.
Instancias de validación

Cada entregable será verificado por el equipo mediante pruebas funcionales, y posteriormente se realizará una instancia de validación con el cliente, quedando registrada su aceptación o las observaciones para su ajuste.

Plan de configuración de software (SCM)


Con el objetivo de mantener un desarrollo ordenado, controlado y trazable, se definió una estrategia de gestión de la configuración del software basada en el uso de Git como sistema de control de versiones, alojado en un repositorio privado de GitHub.
Gestión del versionado
Todo el código fuente y los recursos asociados al proyecto (artefactos de diseño, gestión, evidencias, entre otros) se almacenan en un repositorio central en GitHub. Esto permite:
●	Acceso remoto desde cualquier dispositivo.

●	Historial completo de cambios.

●	Seguimiento de versiones, ramas y merges.

●	Posibilidad de revertir cambios en caso de errores.

Estrategia de ramas
Se definió una estructura de ramas simple pero efectiva para el control del flujo de trabajo:
●	MAIN: contiene la versión estable del proyecto, es decir, aquella que está lista para ser desplegada o entregada.

●	DEVELOP: contiene la versión más actual en desarrollo. Es donde se integran los nuevos cambios antes de ser considerados estables.

●	FEATURE/NOMBRE: se crean ramas específicas para trabajar en funcionalidades nuevas o partes concretas del proyecto. Estas ramas se crean a partir de develop y, una vez finalizadas, se integran nuevamente a esta rama mediante pull request.

Fusión de cambios y promociones de versiones
●	El merge de una rama feature/* a develop se realiza únicamente cuando la funcionalidad está completa, sin errores conocidos, y ha sido revisada por el otro integrante del equipo.

●	La rama main se actualiza únicamente cuando se alcanza una versión completamente funcional, con pruebas realizadas y preparada para la entrega al cliente o la presentación en clase.

●	Antes de hacer merge a main, se deben realizar pruebas de integración completas para asegurar que los componentes convivan correctamente.

Control de versiones entregables
Para mantener un registro claro de los avances significativos, se utilizarán tags en el repositorio para marcar versiones entregables o hitos importantes del proyecto.
Gestión de cambios
Cada modificación al proyecto debe ser justificada mediante un mensaje de commit claro y descriptivo. En caso de necesitar realizar cambios significativos en una funcionalidad ya implementada, se abrirá una nueva rama basada en develop, respetando el mismo flujo de trabajo.




Plan de capacitación


Capacitación del equipo de desarrollo
El equipo ha identificado la necesidad de fortalecer sus conocimientos en algunas de las tecnologías seleccionadas para el desarrollo del sistema, especialmente Spring Boot como framework principal y MySQL como sistema gestor de bases de datos.
Con ese objetivo, se planificó una capacitación en el corto plazo, basada en:
●	La realización de un curso online de Spring Boot para adquirir una base sólida sobre el framework.

●	La revisión y estudio de la documentación oficial tanto de Spring Boot como de MySQL.

●	La aplicación práctica de los conocimientos adquiridos durante el desarrollo del proyecto.

Esta capacitación pretende asegurar que el equipo esté preparado para enfrentar los desafíos del proyecto, garantizando una correcta implementación de la solución.
Capacitación del cliente
Dado que se trata de un cliente funcional, la capacitación estará centrada en garantizar una comprensión adecuada del funcionamiento del sistema desde el punto de vista del usuario final. Esta capacitación se llevará a cabo principalmente a través de:
●	Demostraciones funcionales (demos) durante las entregas parciales, donde se explicarán las funcionalidades implementadas en cada iteración.

●	UATs (User Acceptance Tests): estas pruebas serán acompañadas por explicaciones funcionales que servirán también como instancia de aprendizaje.

●	Manuales de usuario: se entregará documentación accesible y clara sobre el uso del sistema.

●	Videos breves: en caso de ser necesario, se podrán generar videos explicativos que sirvan como guía para tareas frecuentes.

Estas acciones permitirán no solo validar el sistema junto al cliente, sino también facilitar su apropiación del producto desde etapas tempranas.
Además, se acordaron estándares comunes de codificación, diseño y documentación, que servirán como referencia a lo largo de todo el proyecto, permitiendo mantener coherencia y calidad.


Cronograma de trabajo y estimación de esfuerzo


Fecha: 24/03/2025 al 06/04/2025
Sprint	Tarea	Horas estimadas	Horas reales
1	Definición del problema	15	15
	Análisis del cliente	10	10
	Definición de solución propuesta	12	12
	Presentación tema del proyecto	5	5
	Reunión con cliente	2	2
	Planning equipo	4	4
	Dailys 	3.5	3.5
	Taller proyecto	6	6
	TOTAL	57,5	57,5
Fecha: 07/04/2025 al 20/04/2025
Sprint	Tarea	Horas estimadas	Horas reales
2	Documentación anteproyecto	40	40
	Reunión con cliente	2	2
	Reunión de equipo	4	4
	Dailys	3.5	3.5
	Taller proyecto	6	6
	TOTAL	55,5	55,5
Fecha: 21/04/2025 al 04/05/2025
Sprint	Tarea	Horas estimadas	Horas reales
3	Tutorías	4	4
	Documentación anteproyecto	30	30
	Reunión con cliente	2	2
	Reunión de equipo	4	4
	Dailys	3.5	3.5
	Taller proyecto	6	6
	TOTAL	49.5	49.5
Fecha: 5/05/2025 al 18/05/2025
Sprint	Tarea	Horas estimadas	Horas reales
4	Tutorías	3	3
	Documentación anteproyecto	15	15
	Capacitación	15	15
	Entrega anteproyecto	2	2
	Taller deploy	6	6
	Reunión con cliente	2	1
	Reunión de equipo	4	4
	Dailys	3.5	3.5
	Taller proyecto	6	6
	TOTAL	56.5	56.5
Fecha: 19/05/2025 al 1/06/2025
Sprint	Tarea	Horas estimadas	Horas reales
5	Tutorías	3	
	Capacitación SpringBoot + MySQL	40	
	Documentación	15	
	Prototipado	20	
	Reunión con cliente	2	
	Reunión de equipo	2	
	Dailys 	3.5	
	Taller deploy	12	
	Configuración de ambiente	2	
	TOTAL	99,5	
Fecha: 2/06/2025 al 15/06/2025
Sprint	Tarea	Horas estimadas	Horas reales
6	Tutorías	3	
	Capacitación	15	
	Creación de proyecto en gitHub	1	
	Primer caso de éxito deploy	5	
	Gestión proyecto	6	
	Gestión de riesgo	6	
	Reunión con cliente	2	
	Reunión de equipo	2	
	Taller deploy	3	
	RF02	2	
	RF05	1	
	RF04	2	
	RF03	2	
	RF18	2	
	RF50	5	
	RF51	3	
	Pruebas cruzadas	10	
	RF01	3	
	RF52	3	
	RF53	2	
	RF48	3	
	RF55	3	
	RF07	3	
	TOTAL	92	
Fecha: 16/06/2025 al 29/06/2025
Sprint	Tarea	Horas estimadas	Horas reales
7	Reunión de equipo	2	
	Dailys	3	
	Tutorías	3	
	Reunión con cliente	4	
	Documentación	10	
	Pruebas cruzadas	10	
	RF08	3	
	RF09	4	
	RF013	2	
	RF12	3	
	RF14	2	
	RF016	2	
	RF17	2	
	RF21	2	
	RF35	4	
	RF23	1	
	RF25	4	
	RF26	2	
	RF37	3	
	TOTAL	66	
Fecha: 30/06/2025 al 13/07/2025
Sprint	Tarea	Horas estimadas	Horas reales
8	Reunión de equipo	2	
	Dailys	3	
	Tutorías	3	
	Documentación	10	
	RF30	5	
	RF31	4	
	RF32	5	
	RF33	2	
	RF34	3	
	RF36	4	
	RF19	5	
	Testing	15	
	TOTAL	61	
Fecha: 14/07/2025 al 27/07/2025
Sprint	Tarea	Horas estimadas	Horas reales
9	Reunión de equipo	2	
	Dailys	3	
	Tutorías	3	
	Reunión con cliente	4	
	Documentación	15	
	RF29	2	
	RF28	2	
	RF27	6	
	RF20	2	
	Testing	15	
	TOTAL	55	
Fecha: 28/07/2025 al 10/08/2025
Sprint	Tarea	Horas estimadas	Horas reales
10	Reunión de equipo	3	
	Dailys	3	
	Reunión con el cliente	4	
	Documentación	10	
	RF40	6	
	RF41	8	
	RF42	5	
	RF44	5	
	RF47	4	
	Testing	20	
	TOTAL	68	
Fecha: 11/08/2025 al 24/08/2025
Sprint	Tarea	Horas estimadas	Horas reales
11	Reunión de equipo	2	
	Daylis	3	
	Reunión con el cliente	4	
	Documentación	15	
	RF38	12	
	RF39	8	
	RF43	6	
	RF45	7	
	RF46	2	
	Testing	20	
	TOTAL	79	
Fecha: 25/08/2025 al 07/09/2025
Sprint	Tarea	Horas estimadas	Horas reales
12	Reunión de equipo	2	
	Dailys	3	
	Reunión final cliente	3	
	Capacitación cliente	2	
	RF49	5	
	RF10	4	
	RF11	4	
	Documentación	20	
	Testing 	20	
	TOTAL	64	

Compromiso de proyecto


El desarrollo del presente proyecto requiere un fuerte compromiso tanto por parte del equipo como del cliente, con el fin de garantizar una correcta ejecución y cumplimiento de los objetivos establecidos.
Desde el equipo, nos comprometemos a destinar aproximadamente de 35 a 40 horas por sprint por integrante, distribuidas de acuerdo con las tareas y responsabilidades de cada etapa del proyecto. Estas horas incluyen actividades de análisis, diseño, desarrollo, pruebas, documentación y reuniones de seguimiento. Además, asumimos la responsabilidad de cumplir con los plazos y objetivos definidos, garantizando que entregaremos los incrementos y funcionalidades acordadas en cada sprint. En caso de cualquier inconveniente, nos comprometemos a informar al cliente y ajustar los tiempos o las prioridades según sea necesario.

Por parte del cliente, se acordó una disponibilidad activa para consultas y validaciones necesarias durante todo el ciclo de vida del proyecto. Se estableció además la designación de interlocutores válidos para facilitar la comunicación y toma de decisiones, contemplando la necesidad de contar con respaldo alternativo en caso de que el principal referente no esté disponible.
Asimismo, se acordó realizar una reunión al final de cada sprint en la cual se presentará el incremento del proyecto para obtener retroalimentación y asegurar que el desarrollo se ajusta a las expectativas y necesidades del cliente.









ANEXO
Análisis FODA 
ACTAS DE REUNIONES




















Universidad ORT Uruguay
Facultad de Ingeniería







Plataforma Web de Gestión y Comercialización para Tatú Cerámica. 
Entregado como requisito para la obtención del título de Analista en Tecnologías de la Información






María Sofía Pérez– Nro. 157427
Ticiano González- Nro. 255124
Tutor: Sebastián Pombo

2025
 
Declaración de autoría

Nosotros, María Sofía Pérez y Ticiano González, declaramos que el trabajo que se presenta en esta obra es de nuestra propia mano. Podemos asegurar que:
●	La obra fue producida en su totalidad mientras realizamos el Proyecto Integrador de la carrera Analista en Tecnologías de la Información;
●	Cuando hemos consultado el trabajo publicado por otros, lo hemos atribuido con claridad;
●	Cuando hemos citado obras de otros, hemos indicado las fuentes. Con excepción de estas citas, la obra es enteramente nuestra;
●	En la obra, hemos acusado recibo de las ayudas recibidas;
●	Cuando la obra se basa en trabajo realizado juntamente con otros, hemos explicado claramente qué fue contribuido por otros, y qué fue contribuido por nosotros;
●	Ninguna parte de este trabajo se ha publicado previamente a su entrega, excepto donde se han aclarado las correspondientes.


                                 
María Sofía Pérez			Ticiano González
Nro. 157427				Nro. 255124





          
Abstract
Este documento presenta la planificación y documentación del desarrollo de una aplicación web destinada a mejorar la gestión integral de Tatú Taller, un emprendimiento cerámico que ofrece tanto formación como la venta de insumos relacionados. 
El sistema propuesto busca optimizar la reserva de clases, automatizar notificaciones, gestionar la venta de productos y organizar a los usuarios. Para su desarrollo se utilizarán tecnologías como Java con Spring Boot, MySQL, React, HTML, CSS con Tailwind, además de herramientas como GitHub y Trello. Se trabajará bajo la metodología ágil Scrum, organizando el proyecto en Sprint iterativos. 
Como resultado, se espera contar con un sistema funcional y adaptado a las necesidades reales del emprendimiento.

















Palabras clave
●	Gestión de reservas

●	Gestión de clases

●	Ecommerce

●	Notificaciones automáticas

●	Gestión de alumnos

●	Desarrollo web

●	Spring Boot

●	Java

●	React

●	MySQL

●	Tailwind CSS

●	Interfaz de usuario

●	Control de acceso

●	Reservas en línea

●	Gestión de productos

●	Scrum

●	GitHub

●	Trello
 
Índice
Declaración de autoría	1
Abstract	2
Palabras clave	3
Índice	4
Introducción	5
Anteproyecto	6
Presentación del cliente	6
Presentación del problema	7
Alternativas y solución propuesta	8
Tecnologías y herramientas seleccionadas	8
Lista de necesidades	10
Objetivos del proyecto	12
Actores involucrados	13
Lista de requerimientos	14
Requerimientos funcionales	14
Requerimientos no funcionales	23
Alcances y limitaciones	25
Arquitectura	25
Modelos y documentos de diseño	29
Diagrama conceptual	29
Diagrama de casos de uso	30
Plan de proyecto	31
Metodología	31
Plan de gestión de riesgos	32
Identificación de riesgos	33
Clasificación y Priorización de riesgos	33
Estrategias de respuesta	33
Responsables y seguimiento	34
Matriz de riesgos	34
Plan de calidad (SQA)	36
Plan de configuración de software (SCM)	38
Plan de capacitación	40
Capacitación del equipo de desarrollo	40
Capacitación del cliente	40
Cronograma de trabajo y estimación de esfuerzo	41
Compromiso de proyecto	46
ANEXO	47


 
Introducción

El proyecto pretende diseñar y desarrollar una plataforma web para Tatú Taller, un espacio artístico dedicado a la formación en cerámica y a la comercialización de insumos cerámicos. A través de esta solución tecnológica, se busca optimizar la gestión de inscripciones a clases, el registro de asistencias y la venta de productos, acompañando el crecimiento y profesionalización del taller.
Actualmente, Tatú Taller enfrenta desafíos derivados de su reciente expansión, con la apertura de una nueva sede, un aumento en el número de alumnos y una apuesta por seguir creciendo. Este crecimiento ha generado que algunas tareas administrativas se vuelvan más lentas, por lo que la automatización de procesos se presenta como una solución clave para profesionalizar y optimizar la gestión interna.
El proyecto contempla el desarrollo de una solución a medida utilizando tecnologías como Java con Spring Boot para el backend y React para el frontend, siguiendo un enfoque de arquitectura basada en MVC (Modelo-Vista-Controlador) y separación de capas. La plataforma incluirá funcionalidades de registro y autenticación de usuarios, inscripción y control de asistencias, gestión de productos y ventas en línea, así como un panel administrativo para la visualización de estadísticas y la administración general del sistema.
Con esta iniciativa, se busca no solo resolver las necesidades actuales del cliente, sino también sentar las bases para su futura expansión, fortaleciendo su identidad como un espacio comunitario de referencia en el ámbito de la cerámica.





Anteproyecto

Presentación del cliente

Tatú Taller es un espacio dedicado a la cerámica que apuesta por la accesibilidad y la expansión de esta disciplina. Su propuesta combina formación, coworking artístico y comercialización de insumos, creando un ecosistema que facilita el desarrollo de ceramistas en distintas etapas de su camino. Ofrece clases para todos los niveles, desde formación profesional hasta aprendizaje libre, además de un espacio de trabajo compartido donde los ceramistas pueden alquilar un lugar sin necesidad de montar su propio estudio. También dispone de hornos para alquiler y vende insumos cerámicos, consolidándose como un punto de referencia dentro de la comunidad.
En los últimos años, Tatú Taller ha experimentado un crecimiento significativo, reflejado en el aumento de su comunidad y la diversificación de su oferta. Como parte de esta expansión, recientemente inauguraron una nueva sede, reafirmando su compromiso con el crecimiento y la generación de nuevas oportunidades dentro del sector. Sin embargo, este desarrollo ha traído consigo nuevos desafíos en la gestión de su espacio y procesos internos.
El taller es gestionado por un equipo de cuatro personas, todas ellas artistas con trayectorias diversas, cuya convivencia y colaboración han dado forma a un espacio de trabajo con una identidad fuerte y un espíritu comunitario. Su enfoque pedagógico se distingue por la apertura y la flexibilidad en la enseñanza, promoviendo un ambiente accesible, dinámico y en constante evolución.
9 profesores que dan clases, unos 60 alumnos, 17 que usan el trabajo y una cantidad considerable de personas que asisten al taller para hornear sus piezas (aunque no se determina la cifra exacta). Este ecosistema diverso de colaboradores y estudiantes fomenta un ambiente creativo y de intercambio constante.
El vínculo cercano al espacio permitió llegar a Tatú Taller, ya que una de las integrantes del equipo es alumna del taller y ha vivido en primera persona su propuesta de valor y los desafíos organizativos diarios. A partir de esta experiencia, se identificó la oportunidad de aportar una solución tecnológica que facilite su gestión y acompañe su crecimiento.

Presentación del problema

Tatú Taller ha experimentado un importante crecimiento en los últimos años, lo que ha permitido expandir tanto su comunidad como los servicios que ofrece, incluyendo la apertura de una nueva sede. Este avance refleja su compromiso con el desarrollo de la cerámica como una disciplina accesible y abierta para todos. Sin embargo, este crecimiento también ha generado desafíos en la gestión operativa, lo que ha aumentado la carga de trabajo del equipo administrativo y afectado la eficiencia de los procesos internos.
Actualmente, la gestión del taller se lleva a cabo de manera manual y autogestionada. Los principales procesos de negocio incluyen la gestión de clases y alumnos, la reserva de espacios y hornos, y la venta de insumos cerámicos. La inscripción y el seguimiento de los alumnos se realiza mediante hojas de cálculo y comunicación directa por WhatsApp o correo electrónico, lo que dificulta la consulta centralizada de cupos, horarios y estados de inscripción. Por otro lado, las reservas de los espacios de coworking y hornos se coordinan a través de una agenda compartida, lo que genera sobrecarga administrativa y desorganización. Además, la venta de productos cerámicos se realiza de forma presencial, sin un catálogo digital ni un sistema automatizado para controlar el stock.
El aumento de la demanda y la carga administrativa han puesto de manifiesto las limitaciones de los procesos actuales. La falta de automatización implica un uso ineficiente del tiempo, ya que el equipo se ve obligado a realizar tareas repetitivas, lo que les impide enfocarse en actividades estratégicas. Esta gestión manual también aumenta el riesgo de errores en las reservas y clases, generando confusión entre los usuarios. Además, la falta de digitalización limita las posibilidades de expansión, dificultando la implementación de nuevos servicios como la venta en línea de productos cerámicos.
Aunque la situación actual permite mantener un trato cercano y personalizado con los usuarios y una flexibilidad en la gestión de horarios y espacios, también existen desventajas significativas, como la elevada carga operativa y la ineficiencia en la gestión de reservas y clases, que requieren urgentemente un cambio.
Ante este panorama, la propuesta de mejora es desarrollar una plataforma web que automatice la gestión de clases, alumnos y reservas. Además, se integraría un sistema de e-commerce para la venta de insumos cerámicos, ampliando las posibilidades comerciales del taller. Esta solución permitirá mejorar la eficiencia operativa, reducir la carga administrativa y reforzar la identidad de Tatú Taller como un espacio en expansión, alineado con su visión de profesionalización.

Alternativas y solución propuesta

Actualmente, no existe en el mercado un producto que resuelva la problemática de Tatú Taller, ya que las soluciones existentes no están diseñadas para las particularidades de su operación. Si bien es cierto que hay plataformas que ofrecen funcionalidades como la gestión de usuarios o un sistema de e-commerce, estas no son aplicables en este caso, dado que la empresa requiere un producto único, moldeado completamente a sus necesidades y procesos.
La decisión de desarrollar una solución a medida se fundamenta en que nuestro cliente busca una herramienta novedosa y funcional que le permita organizarse mejor y automatizar ciertos procesos clave, como la gestión de reservas de clases y la administración de la base de datos de alumnos. 
Además, al conocer de cerca al cliente, podemos ofrecerle un servicio adaptado diario, generando beneficio mutuo: Tatú Taller tendrá una herramienta personalizada para optimizar su funcionamiento, y nosotros, como desarrolladores, obtendremos experiencia práctica y la satisfacción de entregar un producto acorde a la realidad de la empresa.
Tecnologías y herramientas seleccionadas

Java con Spring Boot  (Backend):

Seleccionamos esta tecnología por su robustez, escalabilidad y el respaldo de una amplia comunidad. Spring Boot nos permite desarrollar APIs RESTful eficientes, facilitando la conexión del backend con múltiples frontends. Aunque reconocemos que actualmente no tenemos una capacitación completa en esta herramienta, consideramos la mejor opción para el proyecto, por lo que planificamos realizar una formación específica que nos permita aprovechar todo su potencial.
Spring Data JPA (Persistencia y acceso a datos):

Elegimos esta como tecnología de persistencia por integración con Spring Boot y su capacidad de simplificar el acceso a bases de datos como MySQL-
React con JavaScript (Frontend):

Esta librería fue elegida por su capacidad de construir interfaces dinámicas e interactivas. React permitirá ofrecer al cliente una experiencia de usuario fluida y moderna, facilitando la navegación y el acceso a las distintas funcionalidades de la plataforma.
Tailwind CSS (Diseño):

Este framework facilita la creación rápida de interfaces limpias y coherentes visualmente. Lo seleccionamos por su flexibilidad y por permitirnos mantener una estética profesional sin la necesidad de desarrollar hojas de estilo personalizadas desde cero.
MySQL (Base de datos):

Elegimos MySQL por su amplia adopción y compatibilidad con las tecnologías seleccionadas. Reconocemos que no contamos con sólidos conocimientos actualmente, pero consideramos que es la mejor alternativa para las necesidades del cliente y planificamos capacitarnos para garantizar un diseño y gestión de base de datos eficiente y escalable.
Proveedor de servidor en la nube:

Optaremos por un servidor en la nube debido a su flexibilidad y escalabilidad, lo que nos permitirá alojar el sistema de manera eficiente. Aunque aún estamos evaluando el proveedor más adecuado, esta opción nos ofrece la capacidad de adaptarnos al crecimiento del proyecto. Además, tomaremos en cuenta los costos de mantenimiento y operación para seleccionar la solución más conveniente a largo plazo. También consideraremos las recomendaciones que recibamos durante el taller d
e deploy para asegurarnos de tomar la mejor decisión.
Scrum (Metodología ágil):
Aplicaremos esta metodología para asegurar una entrega incremental y continua de valor, promoviendo una colaboración constante con el cliente y facilitando la adaptación rápida ante cambios de necesidades. Contamos con una base teórica sólida sobre Scrum, y este proyecto nos permitirá afianzar su aplicación práctica.
GitHub y Trello (Gestión del proyecto):

Utilizaremos GitHub para el control de versiones del código y Trello para la organización del trabajo y seguimiento de tareas. Estas herramientas fomentan una colaboración clara y ordenada entre los miembros del equipo.
En conclusión, todas las tecnologías seleccionadas fueron pensadas en función de las necesidades del cliente y los objetivos del proyecto, priorizando la escalabilidad, la eficiencia y la posibilidad de brindar una experiencia de usuario de calidad, por encima de la comodidad del equipo de desarrollo. Reconocemos los desafíos que implica aprender y dominar estas herramientas, pero estamos comprometidos a capacitarnos para llevar adelante un producto que cumpla con las expectativas de nuestro cliente.


Lista de necesidades

●	N1- Sistema de gestión de reservas de clases:

Permitir que los alumnos reserven sus clases de manera autónoma y organizada, evitando gestiones manuales y asegurando la disponibilidad de los cupos. Este sistema debe ser accesible, claro, fácil de usar y permitir una correcta visualización de las clases disponibles.

●	N2- Base de datos de usuarios y clases:

Contar con un registro seguro y completo de los alumnos, administradores, profesores y clases incluyendo sus datos personales e historial de asistencia. El acceso debe ser sencillo tanto para los administradores como para los alumnos.

●	N3- Navegación clara e informativa para los usuarios:

Ofrecer una navegación fluida y bien estructurada donde los usuarios puedan consultar su historial de clases, próximas reservas y obtener indicaciones claras sobre fechas, horarios y ubicación del taller.

●	N4- Interfaz amigable y accesible:

La plataforma debe ofrecer una experiencia de usuario intuitiva y fácil de usar, asegurando que cualquier persona, independientemente de su nivel de conocimiento técnico, pueda navegar y realizar las acciones necesarias sin dificultad. Además, la interfaz debe cumplir con los estándares de accesibilidad, garantizando que personas con discapacidades, como aquellas con dificultades visuales o motoras, puedan interactuar con el sistema de manera eficiente y sin barreras.

●	N5- Identidad visual del taller reflejada en la plataforma:

El diseño y la estética de la web deben estar alineados con la identidad del taller, transmitiendo su estilo. Esto crea una conexión emocional con los usuarios y fortalece la imagen del taller.

●	N6- Ofrecimiento completo de servicios del taller:

Detallar y organizar la información sobre los servicios del taller, como las clases de cerámica, el coworking, el uso de hornos y la venta de insumos. La plataforma debe permitir a los usuarios conocer todo lo que el espacio ofrece de manera clara y accesible, facilitando la toma de decisiones sobre el uso de estos recursos.

●	N7- E-commerce: 

Crear una tienda online para la venta de productos cerámicos del taller, desarrollando un sistema robusto y seguro para la gestión de compras. El objetivo es ampliar el alcance comercial del taller, optimizando la experiencia de compra en línea, sin que se tenga que gestionar internamente la parte de pagos online. Para ello, se integrará la plataforma de Mercado Libre como medio de pago, garantizando transacciones seguras y fáciles para los usuarios.

●	N8- Integración con Mercado Libre (ML): 

Integrar Mercado Libre como plataforma de pago dentro de la tienda online para facilitar la gestión de pagos de forma segura y eficiente. Esto permitirá que los clientes realicen transacciones de forma directa, sin que el taller tenga que gestionar internamente el proceso de pagos, optimizando tanto la experiencia del usuario como la administración del sistema.

●	N9- Visibilidad y organización para administradores y profesores:

Proveer a los profesores con herramientas claras para consultar el historial de clases, la asistencia de los alumnos y facilitar la planificación de las actividades y recursos del taller.

●	N10- Facilidad de mantenimiento y escalabilidad:

El sistema debe ser diseñado con la flexibilidad necesaria para adaptarse a futuros cambios y la posibilidad de agregar nuevas funcionalidades o realizar ajustes según evolucione el taller.
●	N11 - Acceso seguro al sistema:

 El sistema debe permitir el registro, inicio de sesión y cierre de sesión para alumnos y administradores. El acceso debe ser seguro, utilizando la opción de inicio de sesión mediante cuentas de Google para los usuarios. Además, el sistema debe garantizar que los usuarios puedan cerrar sesión de manera segura y eficiente, protegiendo sus datos personales y evitando accesos no autorizados.
●	N12 - Gestión de roles y permisos:

El sistema debe permitir la gestión eficiente de diferentes roles de usuario (como administradores, profesores y alumnos), asignando permisos específicos a cada uno según sus funciones dentro de la plataforma. Esto garantizará que cada tipo de usuario pueda acceder únicamente a las funcionalidades y datos que le corresponden, manteniendo la seguridad y privacidad de la información. La plataforma debe ser flexible para agregar o modificar roles según sea necesario.



Objetivos del proyecto  

ID	TÍTULO	DESCRIPCIÓN	INDICADOR	FECHA
1	Capacitación previa	Realizar la capacitación necesaria en tecnologías clave antes de comenzar a programar.	90% de la capacitación terminada en Java Spring Boot, React y MySQL.	Antes de la primera línea de código
2	Producto en condiciones de poder ser utilizado	Entregar un producto completamente funcional y testeado al finalizar el proyecto.	Sistema operativo con pruebas de aceptación superadas en más del 90%.	Entrega final
3	Mantener el orden y la documentación y artefactos actualizada	Aplicar correctamente la metodología ágil Scrum a lo largo del proyecto.	Realizar al menos el 90% de las ceremonias principales (daily, planning, review, retro).	Durante todo el proyecto
4	Entrega producto de software de calidad	Implementar pruebas unitarias en componentes críticos del backend y frontend.	Cobertura mínima del 90% en funciones críticas.	Antes de la entrega final
5	Cumplimiento del alcance	Completar al menos el 90% de los requerimientos definidos inicialmente.	Porcentaje de historias finalizadas respecto al backlog inicial ≥ 90%.	Entrega final
6	Calidad del código	Mantener una alta calidad del código durante todo el desarrollo.	Resultado de 90% en análisis de calidad del código (uso de herramientas de análisis estático).	Durante todo el proyecto
7	Gestión de tiempos de desarrollo	Cumplir con los tiempos establecidos para la implementación de cada funcionalidad o historia de usuario.	90% de las historias completadas dentro del tiempo estimado.	Durante todo el proyecto


Actores involucrados

●	Beneficiarios Directos
Los principales beneficiarios del proyecto serán Tatú Taller y sus usuarios. El taller contará con una plataforma que optimizará la gestión de clases, el historial de los alumnos y la reserva de espacios. Esto les permitirá mejorar la organización interna y proporcionar un servicio más eficiente tanto a los ceramistas como a los estudiantes.
Asimismo, los alumnos y ceramistas que interactúan con el taller disfrutarán de una experiencia más ordenada y accesible, facilitando la interacción con las distintas actividades y servicios que ofrece el espacio.


•	Responsables del Desarrollo
El proyecto lo ejecutarán los estudiantes del equipo de desarrollo, quienes se encargarán de crear e implementar la plataforma. Durante el proceso, nos encargaremos de analizar y aplicar los conocimientos adquiridos durante nuestra formación académica, enfrentándonos a nuevos desafíos técnicos que nos permitirán crecer profesionalmente. 
●	Toma de decisiones
Las decisiones clave relacionadas con el proyecto serán tomadas principalmente por los responsables de Tatú Taller, quienes definirán las especificaciones funcionales y operativas de la plataforma. Su involucramiento será esencial para garantizar que el producto final cumpla con sus expectativas y necesidades.
Adicionalmente, el tutor académico supervisará el avance del proyecto, brindando retroalimentación sobre las metodologías de trabajo, asegurando que se cumplan los estándares académicos y orientando en cuanto a buenas prácticas en el desarrollo de software.
●	Financiamiento
Aunque el proyecto es académico, Tatú Taller asumirá los costos asociados al dominio y al servidor, si es necesario, para garantizar el funcionamiento de la plataforma una vez completado el proyecto. Este compromiso financiero asegurará la viabilidad del sistema a largo plazo.
Por su parte, nosotros, como equipo de desarrollo, contribuiremos al proyecto con nuestro tiempo, esfuerzo y aprendizaje. Este trabajo nos permitirá adquirir valiosas experiencias creando software, y desarrollar un producto adaptado a las necesidades y expectativas del cliente.

Lista de requerimientos

Requerimientos funcionales

ID	Nombre	Descripción	Prioridad
RF01	ABM (alta, baja y modificación) de clases	Los administradores y profesores deben poder gestionar las clases en el sistema, lo que incluye crear nuevas clases, modificar detalles de las existentes y eliminar clases que ya estén programadas o disponibles. 
Esta funcionalidad debe ser accesible a través de una interfaz de usuario clara y sencilla. Los cambios deben reflejarse automáticamente en la plataforma para mantener la disponibilidad y la organización de las clases actualizadas.	ALTA
RF02	Reserva de clases para alumnos	Los alumnos previamente logueados podrán seleccionar y reservar clases disponibles de manera autónoma, con la posibilidad de elegir entre los horarios, cupos y talleristas disponibles. 	ALTA
RF03	Confirmación de reserva	Una vez realizada la reserva, el sistema deberá generar y mostrar automáticamente la confirmación detallada con la información de la clase, días, horario y tallerista seleccionados.	MEDIA
RF04	Cancelación de reservas	Los alumnos tendrán la opción de cancelar sus reservas 48 horas antes del comienzo del mes. En el caso contrario, el sistema no permitirá la cancelación	MEDIA
RF05	Gestión de cupos disponibles	El sistema deberá actualizar automáticamente los cupos disponibles en tiempo real, garantizando que los usuarios siempre vean la cantidad correcta de clases disponibles al momento de realizar una reserva.	ALTA
RF06	Notificaciones de recordatorio	En la sección de mensajes, los alumnos deberán recibir recordatorios automáticos a los alumnos sobre las clases próximas, indicando la fecha, hora y lugar, 24 horas antes del comienzo de esta.	BAJA
RF07	Visualización de clases 	El sistema deberá mostrar de manera clara e intuitiva mediante un calendario todos los cursos mensuales disponibles para reserva, detallando la fecha, hora, tallerista a cargo y cupos restantes 	ALTA
RF08	Listado de clases previas.	El sistema deberá mostrar a los alumnos un listado de los días de clase dictados junto a la asistencia correspondiente	MEDIA
RF09	Registro de asistencias	Los profesores podrán pasar lista en clase marcando la asistencia o no asistencia de los alumnos inscriptos al curso en cuestión.	ALTA
RF10	Alerta por 3 faltas consecutivas	El sistema deberá informar al alumno a través de la sección de mensajes la inasistencia consecutiva. El sistema también informará a los administradores en su sección de mensajes de alerta. Ellos tendrán la potestad de ignorar la alerta, multar o dar de baja al alumno como consecuencia.	MEDIA
RF11	Notificaciones por cambio de clases	El sistema notificará con una antelación de al menos 24hs al alumno mediante la sección mensajes cuando alguna característica de alguna clase de su curso (horario, día) sea modificada.	BAJA
RF12	Acceso a la información de alumnos	El sistema debe permitir a los administradores y profesores consultar la información completa de los alumnos, incluyendo sus datos personales y el historial de clases en las que se han inscripto. No así sus credenciales para el inicio de sesión.	ALTA
RF13	Eliminación de alumnos	El sistema debe permitir eliminar registros de alumnos cuando sea necesario, garantizando que se eliminen tanto los datos personales como el historial de clases asociados.	ALTA
RF14	Actualización de datos de alumnos	El sistema debe permitir que los alumnos puedan modificar datos personales, como dirección, número de teléfono, entre otros.	ALTA
RF16	Búsqueda de alumnos	El sistema debe permitir a los administradores realizar búsquedas de alumnos por nombre o cédula, en su defecto aparecerá la lista completa de alumnos registrados 	ALTA
RF17	Integración con clases 	El sistema debe permitir asociar a los alumnos con las clases en las que se inscriben, registrando la relación entre el alumno y las clases de forma clara y precisa.	ALTA
RF18	Estructura de navegación intuitiva.	La plataforma debe contar con una barra de navegación o menú principal visible en todas las páginas. Además, debe incluir secciones clave como "Historial de clases", "Próximas reservas", "Fechas y horarios" y "Ubicación del taller". Los elementos deben estar organizados jerárquicamente para facilitar el acceso rápido a la información.	ALTA 
RF19	Actualización en tiempo real de la información	El sistema debe actualizar automáticamente los datos de clases, reservas y horarios en tiempo real para mantener la información disponible al usuario siempre actualizada	ALTA
RF20	Accesibilidad a la información del usuario	Debe haber una pantalla de inicio que muestre resúmenes visuales de las próximas clases, el historial de reservas y cualquier acción pendiente. Los enlaces o botones deben estar bien diferenciados para realizar reservas, visualizar clases pasadas o próximas y consultar detalles sobre la ubicación.	ALTA
RF21	Indicaciones claras	Las fechas y horarios deben destacarse con colores y tipografías que faciliten la lectura. También se debe integrar un mapa interactivo para que los usuarios puedan localizar fácilmente el taller.	MEDIA
RF22	Barra de búsqueda general 	La plataforma debe contar con una barra de búsqueda en el menú principal que permita localizar rápidamente clases, talleres o cualquier información relevante.	MEDIA 
RF23	Diseño limpio	La plataforma debe tener espacios amplios entre los elementos, botones de acción grandes y fáciles de identificar. Se deben utilizar íconos y etiquetas claras para cada sección y acción. Los colores y tipografía deben ser legibles y amigables para la vista.	ALTA
RF25	Mensajes claros	La plataforma debe mostrar mensajes de error, advertencia o confirmación fáciles de entender cuando los usuarios realicen una acción o cuando haya algún problema.
	ALTA
RF26	Diseño alineado con la identidad del taller	El diseño debe hacer uso consistente de los colores, tipografía y logotipo del taller en toda la plataforma. 	ALTA 
RF27	Experiencia visual integrada	El diseño visual debe ser consistente entre la plataforma y redes sociales, reforzando la identidad del Taller	ALTA
RF28	Presentación clara de servicios	La plataforma debe contar con secciones bien definidas para cada servicio y éste deberá tener una descripción detallada sobre qué incluye. También cada sección tendrá su imagen representativa para dar una visión más completa a los usuarios. 	MEDIA
RF29	Acceso a información adicional	La plataforma contará con una sección de preguntas frecuentes para resolver dudas. También se debe proporcionar acceso a contacto directo para consultas sobre servicios.	MEDIA
RF30
	Carrito de compras	El sistema debe permitir agregar productos disponibles a un carrito de compras persistente durante la sesión sin necesidad de estar registrado.	ALTA
RF31
	Visualización del contenido del carrito	El sistema debe permitir revisar el contenido del carrito en cualquier momento con subtotales, cantidades y total general.	ALTA 
RF32	Modificación del carrito	El sistema debe permitir al usuario eliminar, vaciar y cambiar cantidades de los productos ingresados en el carrito de compras antes de continuar con la misma.	ALTA
RF33	Accesibilidad del carrito en todo el sitio	El ícono del carrito debe estar visible en toda la navegación para facilitar el acceso rápido.	MEDIA
RF34	Validación de stock en tiempo real	El sistema debe verificar el stock disponible antes de permitir agregar un producto al carrito y nuevamente antes de redirigir al pago. Si no hay disponibilidad, el sistema enviará un mensaje al usuario y no se agregará el producto al carrito. 	
RF35	Visualización pública de productos	El sistema debe permitir a cualquier usuario, sin necesidad de registro, navegar libremente por la tienda online y ver la oferta de productos.	ALTA
RF36	Detalle del producto	Los usuarios deben poder acceder al detalle de cada producto (nombre, descripción, precio, imagen) sin necesidad de registro. Debe haber un botón de agregar al carrito desde esta página.	MEDIA
RF37	Filtrado de productos	El usuario debe poder buscar productos por nombre, categoría o precio, y aplicar filtros como tipo de producto o rango de precio	MEDIA
RF38	Pago con Mercado Pago	Al confirmar el pedido, el usuario deberá iniciar sesión en la plataforma en el caso de no haberse logueado. Si el usuario no tiene cuenta, se le muestra la opción de registro. Una vez registrado o logueado con éxito podrá el sistema redirigirá al usuario al entorno de pago de Mercado Libre con los datos del pedido. 	ALTA
RF39	Confirmación del pedido tras la compra	Una vez completado el pago con Mercado Libre o confirmado el pedido con método de pago en efectivo el sistema debe redirigir al usuario a una página de “compra exitosa”, con un resumen del pedido y agradecimiento	ALTA
RF40	Alta de pedido	Una vez completado el pago en Mercado Libre, el sistema deberá recibir y procesar la confirmación automática del pago exitoso para ingresar al pedido a la base de datos así el taller puede tener acceso a él y seguir su curso.  El pedido tendrá un estado pendiente de forma inicial.	ALTA
RF41	Notificación de pedido nuevo	El sistema enviará una notificación a los administradores en la sección pedidos pendientes con la información detallada del pedido y del cliente para poder entregarlo posteriormente. Los administradores deben cambiar el estado del pedido a “entregado” una vez completado el mismo. 	ALTA
RF42	Visualización de historial de pedidos	Los usuarios con registro deben poder ver el historial de compras junto con el estado de cada pedido. 	MEDIA

RF43	Visualización de políticas de envío y devoluciones	Los productos y el proceso de compra deben mostrar accesos visibles a las políticas de envío y devoluciones.	ALTA
RF44	Recompra rápida 	Desde el historial de compras, el usuario debe poder repetir pedidos anteriores si los productos aún están disponibles, en el caso de no estarlo, el sistema mostrará mensaje de error. 	BAJA
RF45	Elección de método de pago	El carrito deberá ofrecer dos opciones de pago: efectivo o mercado pago. En ambos casos el usuario deberá estar registrado y logueado en la plataforma para poder confirmar el mismo. 	
RF46	Pago en efectivo	Una vez seleccionado el método de pago en efectivo, el sistema redirigirá al usuario a la página de "gracias por tu compra” mostrando métodos de comunicación con el taller (teléfono de contacto y mail). El pedido quedará dado de alta en la base de datos con un estado “pendiente”.	
RF47	Recuperación de carrito abandonado	Si un usuario deja el carrito sin completar la compra, el sistema podrá recordárselo al volver al ingresar a la plataforma.	BAJA
RF48	ABM de productos 	Los administradores podrán agregar, modificar y eliminar productos disponibles en la tienda, así como actualizar stock e imágenes	ALTA
RF49	Reporte de ventas del ecommerce 	El sistema debe ofrecer una gráfica de las ventas mes/producto.
	ALTA
RF50	Login de usuarios	El sistema debe permitir a los usuarios previamente registrados hacer el inicio de sesión con sus credenciales correctas. En caso de error, el sistema informará y permitirá intentarlo nuevamente.	ALTA
RF51	Logout de usuarios	El sistema debe permitir a los usuarios mediante un botón visible en todas las páginas de la plataforma, salir de sesión.	ALTA
RF52	Registro de alumnos.	El sistema debe permitir que nuevos usuarios se registren creando una cuenta mediante la introducción de su nombre completo, dirección de correo electrónico válida y una contraseña segura.
  El sistema debe validar que el correo no esté previamente registrado y notificar al usuario en caso de errores durante el proceso. 
Los datos del nuevo usuario deben almacenarse en la base de datos del sistema al finalizar exitosamente el registro.	ALTA
RF53	Asignación automática de rol en el registro	Al registrarse, un usuario será asignado automáticamente al rol "Alumno", y solo un administrador podrá modificar su rol posteriormente	ALTA
RF55	ABM de profesores	El sistema debe permitir a los administradores dar de alta, baja o modificar a los usuarios profesores. 	ALTA




Requerimientos no funcionales


RNF01 – Deploy Web

La aplicación debe estar disponible a través de un servidor web accesible tanto desde computadoras como dispositivos móviles.
RNF03 – Responsive Design

La interfaz debe estar optimizada para distintos tamaños de pantalla, garantizando una experiencia fluida en smartphones, tablets y computadoras.

RNF04 – Navegación Intuitiva y accesible

El diseño debe ser simple, claro y accesible, permitiendo que tanto alumnos como administradores puedan utilizar la plataforma sin necesidad de asistencia técnica.
Debe también cumplir con las pautas de accesibilidad web (WCAG 2.1) para garantizar que sea accesible para todos los usuarios. Esto incluye asegurar contrastes de color adecuados para personas con dificultades visuales, soporte para lectores de pantalla y navegación por teclado. Los controles interactivos deben ser manejables por personas con limitaciones motoras.

RNF05 – Manual de Usuario

Se debe elaborar un manual digital de uso que explique las principales funcionalidades del sistema (registro, inscripción, asistencia, etc.).


RNF06 – Material Audiovisual Complementario

Se deben desarrollar videos cortos de capacitación que complementen el manual, mostrando cómo realizar acciones comunes dentro del sistema.

RNF07 – Gestión de Sesiones Seguras

El sistema debe garantizar la seguridad de las sesiones de usuario mediante autenticación segura y cierre de sesión automático tras inactividad prolongada.

RNF08 – Protección de Datos Personales

La información personal de los usuarios debe resguardarse cumpliendo con buenas prácticas de protección de datos, como cifrado de contraseñas y uso de HTTPS.
RNF09 – Escalabilidad

La aplicación mantendrá un buen desempeño, se le realizaran pruebas de stress, la misma deberá soportar hasta un máximo de 10 personas sin bajar el rendimiento.
RNF 10 – Navegador

La plataforma web deberá ser soportada por navegadores Google Chrome, Mozilla Firefox y Edge. Se probarán en los diferentes navegadores para probar su buen funcionamiento.
RNF 11- Persistencia de la información

Toda la información se almacenará en una base de datos
RNF 12 – Escalabilidad

La aplicación mantendrá un buen desempeño, se le realizaran pruebas de stress, la misma deberá soportar hasta un máximo de 10 personas sin bajar el rendimiento.
RNF 13 - Integración con API Externa (Mercado Pago)

El sistema debe integrar la solución Checkout Pro de Mercado Libre configurándola a través de la documentación y guía expuesto por ML/developers. La configuración será para páginas web y el cliente deberá otorgar las credenciales necesarias para poder completar de manera exitosa la integración

Alcances y limitaciones

El objetivo de este proyecto es desarrollar una plataforma web para la gestión del taller de cerámica. Dentro del alcance se incluye la posibilidad de que los alumnos se registren, inicien sesión, se inscriban a clases y cursos, consulten su historial de asistencias y accedan a la información de los servicios adicionales propuestos, como el alquiler de horno y espacio de coworking. También tendrán acceso a una tienda online con productos del taller, donde se habilitará el pago online a través de Mercado Libre para la compra de productos.
El sistema enviará notificaciones automáticas ante determinadas situaciones, como recordatorios de clase, cambios de horario o faltas reiteradas.
Por parte de los administradores, la plataforma permitirá gestionar la base de datos de alumnos, registrar asistencias, modificar horarios, administrar productos del ecommerce y visualizar estadísticas relevantes desde un panel de control. También se incluirá la posibilidad de gestionar los roles de los usuarios.
Quedan fuera del alcance del proyecto para esta instancia pudiendo ser objetivo de mejora para el futuro, el desarrollo de una app móvil nativa, la gestión contable del taller, las funcionalidades de comunicación interna como mensajería entre usuarios, la gestión de reservas de hornos y de espacio de coworking, y la cadetería de los productos comprados.
Arquitectura

La arquitectura propuesta para la aplicación web de Tatú Taller se basa en una estructura de alto nivel y un patrón MVC para el backend. Esta organización permite una gestión clara y eficiente tanto en el desarrollo como en el mantenimiento del sistema.
La arquitectura de alto nivel describe cómo los distintos componentes del sistema interactúan entre sí. En este caso, el sistema se divide en tres capas principales:
1.	Cliente (Frontend): La interfaz con la que los usuarios interactúan. En nuestro proyecto, esta capa está desarrollada utilizando React para la interfaz de usuario y Tailwind CSS para el diseño responsivo. El frontend se comunica con el backend mediante solicitudes HTTP, enviando datos de los usuarios (alumnos, profesores, administradores) y recibiendo respuestas procesadas por el backend.
2.	Backend (Servidor): Es el componente central que se encarga de procesar las solicitudes del frontend, gestionar la lógica de negocio y acceder a los datos almacenados en la base de datos. El backend está desarrollado en Java utilizando el framework Spring Boot, y sigue el patrón MVC para garantizar una organización clara y eficiente de la lógica interna.
3.	Base de Datos: En nuestra aplicación, la base de datos MySQL almacena toda la información relevante de la plataforma, como datos de usuarios, clases, productos, y reservas. El backend interactúa con la base de datos para realizar operaciones de lectura, escritura y actualización según las solicitudes del frontend.
Esta arquitectura de alto nivel asegura que la comunicación entre el cliente, el backend y la base de datos sea eficiente, escalable y bien organizada. Además, facilita la integración de nuevos componentes, como servicios externos o APIs (por ejemplo, para pagos con Mercado Pago o autenticación con Google OAuth 2.0), sin afectar el funcionamiento general del sistema.
El backend de Tatú Taller sigue el patrón MVC (Modelo-Vista-Controlador) para organizar la lógica interna de manera eficiente. Este patrón permite separar la aplicación en tres componentes principales:
1.	Modelo (Model): El modelo se encarga de la gestión de los datos y la lógica de negocio. En el contexto de nuestra aplicación, el modelo interactúa directamente con la base de datos a través de Spring Data, realizando operaciones CRUD (crear, leer, actualizar, eliminar) para mantener actualizada la información. Además, el modelo contiene las reglas de negocio, como el cálculo de precios de clases o la verificación de disponibilidad de productos.
2.	Vista (View): En un backend basado en Spring Boot, la vista no es directamente responsable de la presentación, ya que se enfoca más en la generación de respuestas que se enviarán al frontend. En este caso, la vista está representada por los datos en formato JSON que el controlador envía al frontend (React). La vista, por lo tanto, se limita a la presentación de datos y no tiene ninguna lógica de procesamiento.
3.	Controlador (Controller): El controlador actúa como el intermediario entre el modelo y la vista. En nuestra aplicación, el controlador gestiona las solicitudes HTTP que llegan desde el frontend (por ejemplo, el registro de un usuario, la reserva de clases, etc.). El controlador recibe estas solicitudes, invoca la lógica de negocio del modelo y devuelve los datos correspondientes al frontend en formato JSON. Además, el controlador se encarga de manejar las respuestas a las acciones del usuario, como la creación de clases, la consulta de reservas y la gestión de usuarios.
La separación en capas del sistema, tanto en el patrón MVC como en la arquitectura de alto nivel, facilita el mantenimiento y la escalabilidad del sistema. Cada componente tiene una responsabilidad clara, lo que hace más fácil realizar modificaciones o ampliaciones sin afectar otras partes de la aplicación. Además, esta organización mejora la modularidad, permitiendo cambios en el frontend o en el backend de forma independiente.
El uso del patrón MVC en el backend garantiza que la lógica de negocio, la presentación y la gestión de datos estén bien separadas, lo que mejora la organización del código y facilita el mantenimiento a largo plazo.

 Ilustración 1. Diagrama MVC


 
Ilustración 2. Arquitectura de alto nivel



Modelos y documentos de diseño


■	Diagrama conceptual


 
Ilustración 3. Diagrama Conceptual


Diagrama de casos de uso

 
Ilustración 4. Diagrama de Casos de Uso






Plan de proyecto


Metodología

Para la gestión y desarrollo del proyecto se optó por utilizar un marco de trabajo ágil basado en Scrum, adaptado a la realidad de nuestro equipo, conformado por dos desarrolladores con el acompañamiento de un tutor. Desde el inicio del proyecto, se decidió adoptar esta metodología, ya que permite organizar el trabajo de manera iterativa e incremental, favoreciendo una planificación clara, entregas frecuentes y la capacidad de adaptarse a los cambios que puedan surgir durante el desarrollo.
La aplicación de Scrum comenzó el 24 de marzo, fecha en la que se llevó a cabo la primera reunión con el cliente. En dicha instancia se identificaron las principales necesidades del espacio y del equipo de gestión, lo cual sirvió de punto de partida para, posteriormente, trazar los requerimientos funcionales y no funcionales del sistema a desarrollar. A partir de esa reunión inicial se realizó una planificación interna y se dio comienzo al primer Sprint, estableciendo una dinámica de trabajo basada en iteraciones de dos semanas de duración, que se mantendrá constante durante todo el proyecto.
Dado que el equipo de trabajo está compuesto únicamente por dos personas, el marco de Scrum ha sido adaptado a nuestras posibilidades. Ambos integrantes conformamos el equipo de desarrollo y, al mismo tiempo, asumimos las responsabilidades correspondientes a los demás roles del marco, como Scrum Máster y Product Owner. Esto implica que nos encargamos de facilitar las ceremonias, priorizar tareas, organizar el Backlog y asegurar que se cumpla con el marco metodológico. El cliente, por su parte, participa como stakeholder, aportando información clave, validando entregas y acompañando el avance del proyecto.
Las reuniones diarias se implementan en un formato adaptado, mediante el envío de audios breves en los que compartimos avances, obstáculos y objetivos del día, permitiendo mantener una comunicación fluida, coordinación y seguimiento constante. Al finalizar cada Sprint, se realiza una revisión con el cliente y una retrospectiva interna, sosteniendo así las ceremonias fundamentales del marco ágil con los recursos disponibles.
Como herramienta de apoyo para la gestión del trabajo, utilizamos Trello para organizar el Backlog del producto y los tableros correspondientes a cada Sprint. Esta herramienta nos permite visualizar el estado de las tareas, asignar responsabilidades, registrar el progreso y facilitar el monitoreo tanto entre los miembros del equipo como por parte del tutor.
La elección de esta metodología y su implementación adaptada nos ha permitido avanzar con claridad, estructura y flexibilidad, manteniendo siempre el foco en la entrega continua de valor y el cumplimiento progresivo de los objetivos del proyecto.

Plan de gestión de riesgos


La gestión de riesgos es fundamental para asegurar que el proyecto se desarrolle de manera exitosa y que podamos cumplir con los plazos y objetivos establecidos. Desde el inicio del proyecto, implementamos un enfoque sistemático para identificar, clasificar y gestionar los riesgos. Este proceso es continuo y se revisa periódicamente en cada Sprint Planning y Sprint Retrospective.

Identificación de riesgos
Los dos miembros del equipo identificaron riesgos juntos. Iniciamos este proceso con una lluvia de ideas, donde todos identificaron posibles riesgos tanto técnicos como operativos. También analizamos los requerimientos obtenidos durante la reunión con el cliente, lo cual nos permitió identificar posibles riesgos relacionados con la ambigüedad de algunos requerimientos o con la viabilidad de ciertas funcionalidades. Además, se realizó un análisis FODA que permitió identificar fortalezas, oportunidades, debilidades y amenazas del proyecto, lo que nos dio una visión más clara de los riesgos a los que podríamos enfrentarnos. Este análisis fue expuesto y discutido para garantizar que todos los riesgos fueran debidamente comprendidos y abordados.
Hasta el momento, no hemos consultado expertos; pero consideramos que podría ser útil en el futuro si surgen dudas técnicas o riesgos que no podamos abordar internamente y, de ser necesario, lo implementaremos para mejorar la gestión del proyecto.
Clasificación y Priorización de riesgos
Una vez identificados los riesgos, se procedió a clasificarlos según tres criterios: probabilidad, impacto y exposición al riesgo. 
La probabilidad fue determinada con base en la posibilidad de que un riesgo ocurriera, clasificándose como:
1.	Baja:  El riesgo tiene menos del 30% de probabilidad de ocurrir. 
2.	Media:  El riesgo tiene una probabilidad de ocurrir entre el 30% y el 70%. 
3.	Alta: El riesgo tiene más del 70% de probabilidad de ocurrir en el proyecto. 
El impacto se evaluó en términos del daño que el riesgo podría causar al proyecto, y también se clasificó en: 
1.	Bajo: El impacto es mínimo. Puede resultar en una demora de menos de un 10% del tiempo total. No afectará la funcionalidad principal del sistema ni la satisfacción del cliente.
2.	Medio: El impacto tiene efectos notables, pero no compromete el proyecto por completo. Puede causar un retraso de entre un 10% y un 30% afectando la calidad, pero sin impedir el éxito del proyecto. 
3.	Alto: El riesgo tendrá consecuencias significativas y afectará de manera crítica al proyecto. Esto puede incluir retrasos importantes, pérdida de calidad, o incluso la cancelación del proyecto.
Finalmente, calculamos la exposición al riesgo, que es el resultado de combinar la probabilidad y el impacto, lo que nos permitió priorizar los riesgos que tienen mayor potencial de afectar el desarrollo del proyecto.
Estrategias de respuesta
Para cada riesgo identificado, definimos estrategias de respuesta que incluyen acciones preventivas, para evitar que ocurran; acciones de mitigación, para reducir la probabilidad y el impacto de los riesgos; y planes de contingencia, que se activarían si los riesgos se materializan. Estas estrategias ya están implementadas y se revisan en cada Sprint para asegurar que sigan siendo efectivas.

Responsables y seguimiento
El seguimiento y la gestión de los riesgos son los encargados directos del desarrollo del proyecto, solo de los dos miembros del equipo. Esto nos permite actuar rápidamente ante cualquier riesgo que se identifique y asegurarnos de que las medidas preventivas o correctivas se implementen de manera oportuna.
Matriz de riesgos
Los riesgos identificados se organizaron en una matriz de riesgos, la cual facilita la visualización de los riesgos con mayor probabilidad e impacto. Esta herramienta nos ayuda a priorizar la atención y los recursos en los riesgos más críticos, asegurando que podamos gestionarlos de forma efectiva y eficiente a lo largo del proyecto.


Identificación	Detalle	Probabilidad	Impacto	Nivel de exposición
R1	Cambios en los requerimientos del cliente	Alta	Alta	Alta
R2	Cambios de prioridades del cliente	Media	Alta	Alta
R3	Falta de disponibilidad del cliente	Media	Alta	Alta
R4	Subestimación de los tiempos de trabajo 	Media	Alta	Alta
R5	Fallas técnicas con las herramientas utilizadas	Media	Alta	Alta
R6	Pérdida de datos	Media 	Alta	 Alta
R7	Enfermedad de un integrante	Media	Alta	Alta
R8	Inexperiencia con tecnologías propuestas	Alta	Media	Alta
R9	Cambios en los requerimientos en etapas tardías	Media	Alto	Alto
R10	Falta de entendimiento entre los integrantes	Media	Media	Media
R11	Conflictos personales o desmotivación.	Baja	Alta	Media
R12	Cambios en la disponibilidad horaria	Media	Media	Media
R13	Falta de documentación clara	Media	Media	Media
R14	Falta de foco debido a otras actividades académicas	Media	Media	Media
R15	Dificultad para implementar un diseño simple y fácil de comprender	Baja	Media	Baja

Tabla 1. Riesgos identificados

Identificación	Plan de mitigación	     Plan de contingencia

R1	Registrar todo en documentación; validar con cliente antes de avanzar	Modificar alcance del proyecto.
R2	Mantener motivado al cliente con entrega de incrementos. Firma de acuerdo de compromiso.	Modificar alcance del proyecto.
R3	Coordinar agenda con antelación y mantener canales alternativos de comunicación.	Avanzar según lo pautado.
R4	Realizar una planificación realista y añadir margen de tiempo para posibles imprevistos.	Modificar alcance del proyecto.
R5	Backups frecuentes y pruebas exhaustivas antes de las entregas de cada incremento.	Cambiar las tecnologías propuestas por las de mayor conocimiento y experiencia por parte del equipo. Modificar alcance del proyecto.
R6	Gestión de versionado riguroso en GitHub con buenas prácticas y backups con versionados en carpetas.	Modificar alcance del proyecto y rehacer tareas.
R7	Estar en conocimiento de las responsabilidades de cada integrante; utilizar tablero de tareas organizado y actualizado	Modificar alcance del proyecto
R8	Capacitación inicial y división por fortalezas	Modificar el alcance y utilizar tecnologías conocidas.
R9	Gestionar los cambios de manera rigurosa y evaluar el impacto de estos en el cronograma antes de aprobarlos.	Modificar alcance del proyecto.
R10	Comunicación diaria por mensaje de audio, reuniones por sprint, organización exhaustiva mediante tablero. 	
R11	Objetivos claros, empatía y diálogo constante.	
R12	Planificación semanal con margen	
R13	Documentar en tiempo real y usar herramientas compartidas	
R14	Planificación cruzada de entregas; seguimiento del calendario institucional	
R15	Aplicar principios de diseños simples y revisar continuamente las decisiones de arquitectura desde etapas tempranas y durante todo el proyecto.	

Tabla 2. Gestión de riesgos


Plan de calidad (SQA)


Para asegurar un desarrollo ordenado y un producto final con los requisitos del cliente, se definió un plan de calidad que abarca tanto el código fuente, el producto final, el proceso de desarrollo y la documentación.
Buenas prácticas 

El lenguaje de programación principal será Java, utilizando el framework Spring Boot, por lo que se adoptarán convenciones de estilo y organización generalmente aceptadas en este ecosistema. Entre las principales decisiones se destacan:
●	Nomenclatura clara y consistente:
Las clases se nombrarán utilizando Pascal Case.
Las variables y métodos se nombrarán en camel Case.
Los atributos privados se indicarán, en lo posible, con un guion bajo inicial.
Se evitarán nombres genéricos o poco descriptivos para favorecer la comprensión del código.

●	Buena legibilidad y uso de comentarios:
Se fomentará el uso de comentarios breves que expliquen la lógica detrás de los bloques de código más relevantes, sin caer en la sobre explicación.
Se utilizarán bloques de documentación para describir el propósito general de las clases y los métodos, siguiendo el estándar de comentarios de JavaDoc.

●	Estructura y organización del código:
Se respetará la estructura típica de proyectos Spring Boot (separación clara entre controladores, servicios, repositorios y modelos).
Los métodos serán breves, con responsabilidades bien definidas, y se aplicará la división en funciones auxiliares si es necesario.
Se evitará la repetición innecesaria de código mediante la reutilización y la correcta abstracción.

●	Control de errores:
Se implementará un manejo adecuado de excepciones mediante bloques try-catch, especialmente en interacciones con la base de datos o en la recepción de datos externos.
Las excepciones personalizadas se utilizarán en los casos en que se deseen mensajes específicos o flujos de control diferenciados.

●	Evitar hardcodeados:
Se utilizarán constantes para representar valores fijos en lugar de escribir esos valores directamente en el código.

●	Validación y pruebas durante el desarrollo:
Aunque no se implementarán herramientas automatizadas avanzadas, se pondrá foco en validar el código frecuentemente mediante ejecución manual de pruebas y revisión mutua entre los integrantes.
En algunos casos, se podrán utilizar herramientas simples del entorno de desarrollo como inspecciones automáticas del IDE (IntelliJ) para identificar código duplicado, no utilizado o mal estructurado.

Calidad del proceso

Para garantizar un seguimiento efectivo del proyecto se utilizará una versión adaptada de Scrum, con planificación de tareas por Sprint, revisión de avances e identificación temprana de desvíos.
El backlog será gestionado mediante Trello, lo que permite visualizar claramente el estado de cada tarea y los responsables.
Calidad del producto

Se realizarán distintos tipos de pruebas a lo largo del desarrollo:
●	Pruebas unitarias: cada componente será probado de forma individual para asegurar su correcto funcionamiento.

●	Revisión de código por pares: cada integrante probará funcionalidades desarrolladas por el otro.

●	Revisión de código asistida: Revisión automática del código mediante herramientas de IA (ChatGPT) para detectar errores, malas prácticas y complejidad innecesaria antes de pruebas funcionales.

●	Pruebas de integración: una vez integradas los distintos incrementos, se verificará que interactúen correctamente entre sí.

●	Pruebas de sistema: en etapas avanzadas se probará el sistema de forma completa, evaluando flujos reales de uso.

●	Pruebas con el cliente (UAT): al finalizar cada sprint se validará junto al cliente la funcionalidad entregada.

Los casos de prueba se documentarán claramente, registrando los escenarios esperados y los resultados obtenidos. De esta manera se asegura trazabilidad y posibilidad de retrabajo si es necesario.
Calidad de la documentación

Se seguirán los lineamientos de la Universidad en los documentos 302, 303 y 306.
La documentación incluirá tanto aspectos técnicos del sistema como justificaciones de diseño, arquitectura utilizada y decisiones tomadas durante el proceso. También se documentará cómo se realizaron las pruebas y los resultados obtenidos.
Gestión de cambios y retrabajo

Ante la detección de errores o cambios en los requerimientos, se registrará el origen del hallazgo, la acción tomada, su impacto y las tareas derivadas. Estos cambios serán gestionados y replanificados dentro de los Sprint siguientes según su prioridad y complejidad.
Instancias de validación

Cada entregable será verificado por el equipo mediante pruebas funcionales, y posteriormente se realizará una instancia de validación con el cliente, quedando registrada su aceptación o las observaciones para su ajuste.

Plan de configuración de software (SCM)


Con el objetivo de mantener un desarrollo ordenado, controlado y trazable, se definió una estrategia de gestión de la configuración del software basada en el uso de Git como sistema de control de versiones, alojado en un repositorio privado de GitHub.
Gestión del versionado
Todo el código fuente y los recursos asociados al proyecto (artefactos de diseño, gestión, evidencias, entre otros) se almacenan en un repositorio central en GitHub. Esto permite:
●	Acceso remoto desde cualquier dispositivo.

●	Historial completo de cambios.

●	Seguimiento de versiones, ramas y merges.

●	Posibilidad de revertir cambios en caso de errores.

Estrategia de ramas
Se definió una estructura de ramas simple pero efectiva para el control del flujo de trabajo:
●	MAIN: contiene la versión estable del proyecto, es decir, aquella que está lista para ser desplegada o entregada.

●	DEVELOP: contiene la versión más actual en desarrollo. Es donde se integran los nuevos cambios antes de ser considerados estables.

●	FEATURE/NOMBRE: se crean ramas específicas para trabajar en funcionalidades nuevas o partes concretas del proyecto. Estas ramas se crean a partir de develop y, una vez finalizadas, se integran nuevamente a esta rama mediante pull request.

Fusión de cambios y promociones de versiones
●	El merge de una rama feature/* a develop se realiza únicamente cuando la funcionalidad está completa, sin errores conocidos, y ha sido revisada por el otro integrante del equipo.

●	La rama main se actualiza únicamente cuando se alcanza una versión completamente funcional, con pruebas realizadas y preparada para la entrega al cliente o la presentación en clase.

●	Antes de hacer merge a main, se deben realizar pruebas de integración completas para asegurar que los componentes convivan correctamente.

Control de versiones entregables
Para mantener un registro claro de los avances significativos, se utilizarán tags en el repositorio para marcar versiones entregables o hitos importantes del proyecto.
Gestión de cambios
Cada modificación al proyecto debe ser justificada mediante un mensaje de commit claro y descriptivo. En caso de necesitar realizar cambios significativos en una funcionalidad ya implementada, se abrirá una nueva rama basada en develop, respetando el mismo flujo de trabajo.




Plan de capacitación


Capacitación del equipo de desarrollo
El equipo ha identificado la necesidad de fortalecer sus conocimientos en algunas de las tecnologías seleccionadas para el desarrollo del sistema, especialmente Spring Boot como framework principal y MySQL como sistema gestor de bases de datos.
Con ese objetivo, se planificó una capacitación en el corto plazo, basada en:
●	La realización de un curso online de Spring Boot para adquirir una base sólida sobre el framework.

●	La revisión y estudio de la documentación oficial tanto de Spring Boot como de MySQL.

●	La aplicación práctica de los conocimientos adquiridos durante el desarrollo del proyecto.

Esta capacitación pretende asegurar que el equipo esté preparado para enfrentar los desafíos del proyecto, garantizando una correcta implementación de la solución.
Capacitación del cliente
Dado que se trata de un cliente funcional, la capacitación estará centrada en garantizar una comprensión adecuada del funcionamiento del sistema desde el punto de vista del usuario final. Esta capacitación se llevará a cabo principalmente a través de:
●	Demostraciones funcionales (demos) durante las entregas parciales, donde se explicarán las funcionalidades implementadas en cada iteración.

●	UATs (User Acceptance Tests): estas pruebas serán acompañadas por explicaciones funcionales que servirán también como instancia de aprendizaje.

●	Manuales de usuario: se entregará documentación accesible y clara sobre el uso del sistema.

●	Videos breves: en caso de ser necesario, se podrán generar videos explicativos que sirvan como guía para tareas frecuentes.

Estas acciones permitirán no solo validar el sistema junto al cliente, sino también facilitar su apropiación del producto desde etapas tempranas.
Además, se acordaron estándares comunes de codificación, diseño y documentación, que servirán como referencia a lo largo de todo el proyecto, permitiendo mantener coherencia y calidad.


Cronograma de trabajo y estimación de esfuerzo


Fecha: 24/03/2025 al 06/04/2025
Sprint	Tarea	Horas estimadas	Horas reales
1	Definición del problema	15	15
	Análisis del cliente	10	10
	Definición de solución propuesta	12	12
	Presentación tema del proyecto	5	5
	Reunión con cliente	2	2
	Planning equipo	4	4
	Dailys 	3.5	3.5
	Taller proyecto	6	6
	TOTAL	57,5	57,5
Fecha: 07/04/2025 al 20/04/2025
Sprint	Tarea	Horas estimadas	Horas reales
2	Documentación anteproyecto	40	40
	Reunión con cliente	2	2
	Reunión de equipo	4	4
	Dailys	3.5	3.5
	Taller proyecto	6	6
	TOTAL	55,5	55,5
Fecha: 21/04/2025 al 04/05/2025
Sprint	Tarea	Horas estimadas	Horas reales
3	Tutorías	4	4
	Documentación anteproyecto	30	30
	Reunión con cliente	2	2
	Reunión de equipo	4	4
	Dailys	3.5	3.5
	Taller proyecto	6	6
	TOTAL	49.5	49.5
Fecha: 5/05/2025 al 18/05/2025
Sprint	Tarea	Horas estimadas	Horas reales
4	Tutorías	3	3
	Documentación anteproyecto	15	15
	Capacitación	15	15
	Entrega anteproyecto	2	2
	Taller deploy	6	6
	Reunión con cliente	2	1
	Reunión de equipo	4	4
	Dailys	3.5	3.5
	Taller proyecto	6	6
	TOTAL	56.5	56.5
Fecha: 19/05/2025 al 1/06/2025
Sprint	Tarea	Horas estimadas	Horas reales
5	Tutorías	3	
	Capacitación SpringBoot + MySQL	40	
	Documentación	15	
	Prototipado	20	
	Reunión con cliente	2	
	Reunión de equipo	2	
	Dailys 	3.5	
	Taller deploy	12	
	Configuración de ambiente	2	
	TOTAL	99,5	
Fecha: 2/06/2025 al 15/06/2025
Sprint	Tarea	Horas estimadas	Horas reales
6	Tutorías	3	
	Capacitación	15	
	Creación de proyecto en gitHub	1	
	Primer caso de éxito deploy	5	
	Gestión proyecto	6	
	Gestión de riesgo	6	
	Reunión con cliente	2	
	Reunión de equipo	2	
	Taller deploy	3	
	RF02	2	
	RF05	1	
	RF04	2	
	RF03	2	
	RF18	2	
	RF50	5	
	RF51	3	
	Pruebas cruzadas	10	
	RF01	3	
	RF52	3	
	RF53	2	
	RF48	3	
	RF55	3	
	RF07	3	
	TOTAL	92	
Fecha: 16/06/2025 al 29/06/2025
Sprint	Tarea	Horas estimadas	Horas reales
7	Reunión de equipo	2	
	Dailys	3	
	Tutorías	3	
	Reunión con cliente	4	
	Documentación	10	
	Pruebas cruzadas	10	
	RF08	3	
	RF09	4	
	RF013	2	
	RF12	3	
	RF14	2	
	RF016	2	
	RF17	2	
	RF21	2	
	RF35	4	
	RF23	1	
	RF25	4	
	RF26	2	
	RF37	3	
	TOTAL	66	
Fecha: 30/06/2025 al 13/07/2025
Sprint	Tarea	Horas estimadas	Horas reales
8	Reunión de equipo	2	
	Dailys	3	
	Tutorías	3	
	Documentación	10	
	RF30	5	
	RF31	4	
	RF32	5	
	RF33	2	
	RF34	3	
	RF36	4	
	RF19	5	
	Testing	15	
	TOTAL	61	
Fecha: 14/07/2025 al 27/07/2025
Sprint	Tarea	Horas estimadas	Horas reales
9	Reunión de equipo	2	
	Dailys	3	
	Tutorías	3	
	Reunión con cliente	4	
	Documentación	15	
	RF29	2	
	RF28	2	
	RF27	6	
	RF20	2	
	Testing	15	
	TOTAL	55	
Fecha: 28/07/2025 al 10/08/2025
Sprint	Tarea	Horas estimadas	Horas reales
10	Reunión de equipo	3	
	Dailys	3	
	Reunión con el cliente	4	
	Documentación	10	
	RF40	6	
	RF41	8	
	RF42	5	
	RF44	5	
	RF47	4	
	Testing	20	
	TOTAL	68	
Fecha: 11/08/2025 al 24/08/2025
Sprint	Tarea	Horas estimadas	Horas reales
11	Reunión de equipo	2	
	Daylis	3	
	Reunión con el cliente	4	
	Documentación	15	
	RF38	12	
	RF39	8	
	RF43	6	
	RF45	7	
	RF46	2	
	Testing	20	
	TOTAL	79	
Fecha: 25/08/2025 al 07/09/2025
Sprint	Tarea	Horas estimadas	Horas reales
12	Reunión de equipo	2	
	Dailys	3	
	Reunión final cliente	3	
	Capacitación cliente	2	
	RF49	5	
	RF10	4	
	RF11	4	
	Documentación	20	
	Testing 	20	
	TOTAL	64	

Compromiso de proyecto


El desarrollo del presente proyecto requiere un fuerte compromiso tanto por parte del equipo como del cliente, con el fin de garantizar una correcta ejecución y cumplimiento de los objetivos establecidos.
Desde el equipo, nos comprometemos a destinar aproximadamente de 35 a 40 horas por sprint por integrante, distribuidas de acuerdo con las tareas y responsabilidades de cada etapa del proyecto. Estas horas incluyen actividades de análisis, diseño, desarrollo, pruebas, documentación y reuniones de seguimiento. Además, asumimos la responsabilidad de cumplir con los plazos y objetivos definidos, garantizando que entregaremos los incrementos y funcionalidades acordadas en cada sprint. En caso de cualquier inconveniente, nos comprometemos a informar al cliente y ajustar los tiempos o las prioridades según sea necesario.

Por parte del cliente, se acordó una disponibilidad activa para consultas y validaciones necesarias durante todo el ciclo de vida del proyecto. Se estableció además la designación de interlocutores válidos para facilitar la comunicación y toma de decisiones, contemplando la necesidad de contar con respaldo alternativo en caso de que el principal referente no esté disponible.
Asimismo, se acordó realizar una reunión al final de cada sprint en la cual se presentará el incremento del proyecto para obtener retroalimentación y asegurar que el desarrollo se ajusta a las expectativas y necesidades del cliente.









ANEXO
Análisis FODA 
ACTAS DE REUNIONES





















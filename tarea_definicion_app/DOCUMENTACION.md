
<div align="justify">

<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="Definicin_de_una_app_personal_0"></a>Definición de una app personal</h1>
<h2 class="code-line" data-line-start=1 data-line-end=2 ><a id="App_Libro__1"></a>🕮 Booknown 🕮</h2>
<p class="has-line-data" data-line-start="2" data-line-end="3">Autor: Ricardo Baloira Armas</p>
<br>
<h2 class="code-line" data-line-start=4 data-line-end=5 ><a id="Planteamiento_de_la_app_4"></a>Planteamiento de la app</h2>
<p class="has-line-data" data-line-start="5" data-line-end="6">Esta app provee a sus usuarios de una plataforma en la que poder no solo compartir sus propios libros, sino también leer, valorar y comentar las obras escritas por los otros usuarios de la app, existiendo en ella una comunidad de escritores y/o apasionados de la lectura que interactuará constantemente entre sí de diversas maneras.</p>
<p class="has-line-data" data-line-start="7" data-line-end="8">Al hablar de los tipos de comunicación existentes nos referimos, además de a la publicación de libros, al acto de escribir y compartir reseñas de dichos libros con el autor, cuya puntuación afectará a la puntuación media que tiene el libro en cuestión y por consiguiente a la posición que este ocupará en el catálogo de la comunidad donde se almacenan otros libros del mismo género. No obstante, a la hora de ordenar los libros en las diferentes listas no solo se tendrá en cuenta la puntuación media de cada libro, sino también si su autor decidió realizar un pago opcional para destacar su libro en el catálogo.</p>
<p class="has-line-data" data-line-start="9" data-line-end="10">A fin de diferenciarse de apps similares esta aplicación permitirá la comunicación entre usuarios en chats grupales que podrán ser tanto públicos como privados, aparte de proveer contacto con editoriales y agentes literarios (los cuales mediante el uso de una marca en su avatar serán distinguidos del resto de usuarios) posiblemente interesados en la publicación de los libros de aquellos usuarios cuyas obras gozan de buena opinión en la comunidad. Para poder estar en la plataforma, dichas editoriales y agentes literarios deberán efectuar un pago, actuando de este modo como patrocinadores de la aplicación que, de cara al usuario, será completamente gratuita exceptuando el pago opcional por destacar sus libros en los catálogos.</p>
<br>
<h2 class="code-line" data-line-start=11 data-line-end=12 ><a id="Esquema_de_BBDD_11"></a>Esquema de BBDD</h2>
<p class="has-line-data" data-line-start="12" data-line-end="13">En base a las pautas establecidas en el planteamiento de la app, creamos el siguiente modelo entidad-relación que sentará las bases para nuestro proyecto:</p>
<br>
<div align="center">
  <img src="https://user-images.githubusercontent.com/73242474/136458537-a8629de4-c404-4ed8-920e-9da7fb8b170b.png">
</div>
<br>
<p class="has-line-data" data-line-start="5" data-line-end="6">Como podemos observar, el modelo en cuestión consta de cinco entidades (Usuario, Review, Libro, BibliotecaPersonal y Género) y cuatro relaciones (Escribe, Realiza, Tiene y Pertenece). De este modo vemos que la base de datos de nuestra aplicación constará de cinco tablas, relacionadas entre sí de la forma descrita en este modelo. Cabe destacar que los atributos UsuarioEspecial y PagoOpcional de las entidades Usuario y Libro son atributos booleanos cuya función es indicar si el usuario se trata de una editorial o un agente literario, en el caso de UsuarioEspecial, y de mostrar si el Usuario realizó el pago necesario para destacar su libro en el catálogo, en el caso de PagoOpcional.</p>
</div>

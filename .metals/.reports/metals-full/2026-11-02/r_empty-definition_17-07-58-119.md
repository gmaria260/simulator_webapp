error id: file:///C:/xampp/htdocs/simulator_webapp/app/views/main.scala.html:
file:///C:/xampp/htdocs/simulator_webapp/app/views/main.scala.html
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 293
uri: file:///C:/xampp/htdocs/simulator_webapp/app/views/main.scala.html
text:
```scala
@*
  Main page layout
*@
@(title: String)(content: Html)(implicit assetsFinder: AssetsFinder)

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>@title</title>

        <link rel="stylesheet"
              media="screen"
              href="@assetsFinder.path("stylesheets@@/main.css")">

        <link rel="shortcut icon"
              type="image/png"
              href="@assetsFinder.path("images/favicon.png")">
    </head>

    <body>
        @content
    </body>
    <script src="@assetsFinder.path("javascripts/dataTable.js")" defer></script>
</html>
```


#### Short summary: 

empty definition using pc, found symbol in pc: 
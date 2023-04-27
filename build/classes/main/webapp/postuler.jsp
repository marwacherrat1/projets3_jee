<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="motivations.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/18d2ef7c15.js" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">    
   <link rel="stylesheet" href="fontawesome/css/all.min.css">


  </head>
  <body >
    
    <header>
      <h1>Bienvenue ${sessionScope.nom} ${sessionScope.prenom}</h1>
    </header>
    <nav>



      <ul>
         <li style="float:left" class="dropdown">
          <div class="dropdown-content">
            <li><a href="${s}#profil">Acceuil</a></li>
          
      
           </div>
         </li>
         <li style="float:right"><a href="Deconnexion">Déconnexion</a></li>
</ul>
</nav>
<div>
<main>
<div class="container">

<div>
<form action="postulerservlet" method="POST">
<input type="hidden" value="${ido}" name="ido">
<label class="center"> Veuillez entrer votre letrre de motivation</label>
<textarea  name="motivation" ></textarea>
<P><input type="submit" value="Postuler"><br></P>

</form>
</div>
</div>
</main></div>
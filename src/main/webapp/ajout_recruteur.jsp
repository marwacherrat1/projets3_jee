<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout recruteur</title>
<link rel="stylesheet" href="ajoutrecruteu.css">
</head>
<body >
<header>
      <h1>Création d'un compte recruteur</h1>
</header>
<nav>
  <ul>
   <li style="float:left" class="dropdown">
 <div class="dropdown-content">
            <li><a href="all#profil">Acceuil</a></li>

            
           
      
           </div>
         </li>
         <li style="float:right"><a href="Deconnexion">Déconnexion</a></li>
  </ul>
</nav>
<div class="container">
  <form  action="AJOUTC" action="POST">
    
    <input type="text" name="nom" placeholder="nom"><br>
     <input type="email" name="mail" placeholder="Email"><br>
    <input type="text" name="addresse"placeholder="addresse"><br>
    <input type="password" name="passwd" placeholder="Mot de passe"><br>
    <input type="text" name="description" placeholder="description"><br>
    <input type="submit" value="créer"><br>
   
  </form>


  
</div>
<footer>
      <p>Copyright © [Année] [Nom de votre entreprise]</p>
  </footer>
</body>
</html>
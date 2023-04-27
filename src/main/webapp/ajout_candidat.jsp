<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout recruteur</title>
<link rel="stylesheet" href="ajoutercandidaT.css">
</head>
<body >
<header>
      <h1>Création d'un compte candidat</h1>
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
<p class='center'>création d'un compte candidat</p>
<div class="container">
  <form action="ajouter_candidat" >
    
    <input type="text" name="nom" placeholder="nom"><br>
    <input type="text" name="prenom" placeholder="prenom"><br>
    <input type="email" name="Email" placeholder="Email"><br>
    <input type="text" name="tel"placeholder="téléphone"><br>
    <input type="text" name="competences" placeholder="competences"><br>
    <input type="text" name="projets" placeholder="projets"><br>
    <input type="text" name="diplomes" placeholder="diplomes"><br>
    <input type="text" name="langues" placeholder="langues"><br>
    <input type="number" name="age" placeholder="age"><br>
    <input type="password" name="paswd" placeholder="mot de passe"><br>
    
     <input type="submit" value="créer"><br>

  </form>
  </div>

  
</body>
</html>
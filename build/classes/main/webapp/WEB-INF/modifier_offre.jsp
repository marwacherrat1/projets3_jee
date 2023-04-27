<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout recruteur</title>
<link rel="stylesheet" href="modifieroffr.css">
</head>
<body >
<header>
      <h1>Modification de l'offre </h1>
</header>
<nav>
  <ul>
   <li style="float:left" class="dropdown">

          <li> <a href="${s}#profil">Acceuil</a></li>
          
   </li>
   <li style="float:right"><a href="Deconnexion">Déconnexion</a></li>
  </ul>
</nav>
<div class="container">
  <form  action="modifieroffre" action="POST">
    <p><label>ID de l'offre </label>
    <input type="password" name="idoffre" value="${ offre.idoffre }"readonly><br></p>
    <p><label>Titre de l'offre</label>
    <input type="text" name="titre" value="${ offre.titre }"><br></p>
    
     <p><label>Date limite</label>
    <input type="date" name="delai" value="${ offre.delai }"><br></p>
     <p><label>Date de l'offre</label>
    <input type="date" name="dateoffre" value="${ offre.dateoffre }" readonly><br></p>
     
     <p><label>Description</label>
    <input type="text" name="description" value="${offre.description}"><br></p>
     
     <p><label>Competences</label>
    <input type="text" name="competence" value="${offre.competence}"><br></p>
     
     
    <P><input type="submit" value="modifier"><input type="reset" value="annuler"><br></P>
    
    
 
  </form>


  
</div>
<footer>
      <p>Copyright © [Année] [Nom de votre entreprise]</p>
  </footer>
</body>
</html>
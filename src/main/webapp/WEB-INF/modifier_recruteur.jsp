<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout recruteur</title>
<link rel="stylesheet" href="modifrecruteur.css">
</head>
<body >
<header>
      <h1>Modififcation d'un compte recruteur</h1>
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
<div class="container">

  <form  action="modifier_recruteurall" action="POST">
    <input type="hidden" value="${s}" name="s">
    
    <p><label>Id du recruteur:</label>
    <input type="password" name="idr" value="${ recruteur.idr }"readonly><br></p>
    <p><label>Nom recruteur</label>
    <input type="text" name="nom" value="${ recruteur.nom }"><br></p>
     <p><label>Mail du recruteur</label>
    <input type="email" name="mail"value="${ recruteur.mail}"><br></p>
     <p><label>addresse recruteur</label>
    <input type="text" name="addresse" value="${ recruteur.adresse}"><br></p>
     <p><label>mot de passe</label>
    <input type="password" name="passwd" value="${ recruteur.passwd }"><br></p>
     <p><label>Description</label>
    <input type="text" name="description" value="${ recruteur.description }"><br></p>
     
    <P><input type="submit" value="modifier"><input type="reset" value="annuler"><br></P>
    
   
  </form>


  
</div>
<footer>
      <p>Copyright © [Année] [Nom de votre entreprise]</p>
  </footer>
</body>
</html>
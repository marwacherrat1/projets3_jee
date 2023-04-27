<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Candidat</title>
<link rel="stylesheet" href="modifcandidat.css">
</head>
<body >
<header>
      <h1>Modification du Candidat</h1>
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
 <form action="modifier_candidat" action="POST" >
 <p><label>Id Candidat</label>
    
    <input type="password" name="idc" value="${candidat.idc}"readonly><br></p>
     
    <p><label>Nom Candidat</label>
    
    <input type="text" name="nom" value="${candidat.nom}"><br></p>
    <p><label>Prenom Candidat</label>    
    <input type="text" name="prenom" value="${candidat.prenom}"><br></p>
    <p><label>  Email Candidat</label>
    <input type="email" name="Email" value="${candidat.mail}"><br></p>
    <p><label>Téléphone Candidat</label>
    <input type="text" name="tel" value="${candidat.tel}"><br></p>
    <p><label> Competences Candidat</label>
    <input type="text" name="competences" value="${candidat.competences}"><br></p>
    <p><label> Projets Candidat</label>
    <input type="text" name="projets" value="${candidat.projets}"><br></p>
    <p><label> Diplomes Candidat</label>
    <input type="text" name="diplomes" value="${candidat.diplomes}"><br></p>
    <p><label> Langues Candidat</label>
    <input type="text" name="langues" value="${candidat.langues}"><br></p>
    <p><label> Age Candidat</label>
    <input type="number" name="age" value="${candidat.age}"><br></p>
    <p><label>Mot de passe Candidat</label>
    <input type="password" name="paswd" value="${candidat.paswd}"><br></p>
    
    <P><input type="submit" value="modifier"><input type="reset" value="annuler"><br></P>

  </form>
</div>
<footer>
      <p>Copyright © [Année] [Nom de votre entreprise]</p>
  </footer>
</body>
</html>
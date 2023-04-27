<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>responsive personal portfolio website design tutorail</title>
       <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/18d2ef7c15.js" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">    
   <link rel="stylesheet" href="fontawesome/css/all.min.css">
     
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="no.css">

</head>
<body>
    
<!-- header section starts  -->

<header>

    <div class="user">
        
        <h3 class="name">${sessionScope.nom} ${sessionScope.prenom}</h3>
       
    </div>
 
   <nav class="navbar">
        <ul>
            <li><a href="candidat#profil">Mon profil</a></li>
             <li><a href="candidat#nv">Mon cv</a>
            <li><a href="#postulations">Mes Postulations</a></li>
            <li><a href="#offres">Les offres</a></li>
            <li><a href="candidat#modifier">Modifier mon compte</a></li>
           
            <li><a href="Deconnexion">Déconnexion</a>
        </ul>
    </nav>

</header>

<!-- header section ends -->

<div id="menu" class="fas fa-bars"></div>

<!-- home section starts  -->


<!-- education section ends -->

<!-- portfolio section starts  -->





<!-- portfolio section ends -->

<!-- contact section starts  -->

<section class="contact" id="offres">

<h1 class="heading"> <span>Les</span> offres </h1>
<div class="box-container">
<form action="recherche" method="POST">
<div style="font-size:20px">
<i class="bi bi-search bi--2xl"  style="padding-left: 200px"></i></div>
<input name="rech" type="text">

</form>
<h3 class="center">veuillez trouvez les ofrres de ${rech} </h3>
<a class="center" href="candidat#offres"><i class="fa-solid fa-arrows-rotate fa-3x"></i></a>
  <table class="center">
          <tr>
            <th>Id_offre</th>
            <th>Titre offre</th>
            <th>Détails de l'offre</th>
            <th>Postuler</th>
           </tr>
           
      <% int coun = 1 ;%>
           
           <c:forEach var="offre" items="${ offres }">
            <tr style="width:20%">
            <td>Offre <%=coun%></td>
            <td><c:out value="${ offre.getTitre() }" /></td>
            <td><a href="offreprecis?ido=${offre.getIdoffre() }&user=${sessionScope.nom}&s=${'candidat'}"><span class="bi bi-display center"></span></a></td>
            <td><a href="ajoutpostulation?ido=${offre.getIdoffre()}&s=${'candidat'}">POSTULER</a></td>
            <% coun+=1; %>
            </tr>
             </c:forEach>
        </table>

</div>

</section>


<!-- scroll top button  -->





<section class="education" id="postulations">

<h1 class="heading"> Mes <span>postulations</span> </h1>

<div class="box-container">

  <table class="center">
    
      <tr>
        <th></th>
        <th>Lettre de motivation du candidat</th>
        <th>Détails offres</th>
        <th>Annuler postulation</th>
      </tr>
      
      <% int count = 1 ;%>
      <c:forEach var="p" items="${ postulations }">
      
      <tr>
            
        
        <td>Postulation <%=count%></td>       
        <td><a class ="center" href="lettremotivation?lettremotivation=${p.getLettremotivation()}&user=${sessionScope.nom}&s=${'candidat'}">Visualiser la lettre </a></td>
        <td><a class ="center" href="offreprecis?ido=${p.getId_offre() }&user=${sessionScope.nom}&s=${'candidat'}">Visualiser les informations sur l'offre</a></td>
        <td><a class="center" href="supprimerpostulation?idpo=${p.getId_postulation()}">Annuler la postulation</a></td>
        <%count+=1;%>
        
        
      </tr>
      
      </c:forEach>
  </table>
  </div>
</section>














<!-- jquery cdn link  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>
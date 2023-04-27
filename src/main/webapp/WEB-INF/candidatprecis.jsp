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
    <title>candidat</title>
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
            <li><a href="#profil">Mon profil</a></li>
             <li><a href="#nv">Mon cv</a>
            <li><a href="#postulations">Mes Postulations</a></li>
            <li><a href="#offres">Les offres</a></li>
            <li><a href="#modifier">Modifier mon compte</a></li>
           
            <li><a href="Deconnexion">Déconnexion</a>
        </ul>
    </nav>

</header>

<!-- header section ends -->

<div id="menu" class="fas fa-bars"></div>

<!-- home section starts  -->

<section class="home" id="profil">

    <h3>Bienvenue</h3>
    <h1>${sessionScope.nom}<span>${sessionScope.prenom}</span></h1>
    <p>Mail-->${sessionScope.mail}
    </p>
    <a href="#nv"><button class="btn">Visualiser cv</button></a>
    <a href="#modifier"><button class="btn">Modifier mon compte</button></a>
</section>

<!-- home section ends -->

<!-- about section starts  -->

<section class="about" id="nv">

<h1 class="heading"> <span>Mon</span>CV</h1>

<div class="row">
<div class="container">
  <div>
        <div class="cadre">
          <div class="c">
          <i class="fa-solid fa-circle-user fa-10x"></i>
          
          <h2>${sessionScope.nom} ${sessionScope.prenom}</h2></div>
           <hr>
          <div class="ca">
          <p><i class="fa fa-calendar"></i> Age : ${sessionScope.age}</p>
          <p><i class="fa fa-envelope"></i> Mail : ${sessionScope.mail}</p>
          <p><i class="fa fa-phone"></i> Téléphone : ${sessionScope.tel}</p>
          
          </div>
        </div>
      </div>
    
      <div >
        <div class="card">
          <h2><i class="fa fa-suitcase"></i> Projets</h2>
          <h5>j'ai déja effectué les projets suivantes :</h5>
          <p>${sessionScope.projets}</p>
        </div>
          <hr>
        <div class="card">
          <h2><i class="fa fa-suitcase"></i>Les Competences:</h2>
          

          <h5>Veuillez trouver  mes competences:</h5>
          <p>${sessionScope.competences}</p>
         
        </div>
         <hr>
        <div class="card">
          <h2><i class="fa fa-suitcase"></i> Les Langues:</h2>
          <h5>Veuillez trouver  les langues que je maitrise:</h5>
          <p>${sessionScope.langues}</p>
           
        </div>
        <hr>
        <div class="card">
          <h2><i class="fa fa-suitcase"></i> Les diplomes obtenues.</h2>
          <h5>Veuillez trouver  les diplomes que j'ai eu:</h5>
          <p>${sessionScope.diplomes}</p>
            
        </div>
         <hr>
      </div>
</div>
</div>
 


</section>

<!-- about section ends -->

<!-- education section starts  -->

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
        <%count+=1; %>
        
      </tr>
      </c:forEach>
  </table>
  </div>
</section>



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
<input name="rech" type="text" >

</form>
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

<section class="about" id="modifier">
  <h1 class="heading"> <span>Modifier</span> mon compte </h1>

  <div class="row">
     <div class="container2">
    <form action="modifsoncomptecandid" method="POST" >
    
<p><label>Id Candidat</label>
    <input type="hidden" name="s" value="Loginc">
    <input type="password" name="idc" value="${sessionScope.idc}"readonly><br></p>
     
    <p><label>Nom Candidat</label>
    
    <input type="text" name="nom" value="${sessionScope.nom}"><br></p>
    <p><label>Prenom Candidat</label>    
    <input type="text" name="prenom" value="${sessionScope.prenom}"><br></p>
    <p><label>  Email Candidat</label>
    <input type="email" name="mail" value="${sessionScope.mail}"><br></p>
    <p><label>Téléphone Candidat</label>
    <input type="text" name="tel" value="${sessionScope.tel}"><br></p>
    <p><label> Competences Candidat</label>
    <input type="text" name="competences" value="${sessionScope.competences}"><br></p>
    <p><label> Projets Candidat</label>
    <input type="text" name="projets" value="${sessionScope.projets}"><br></p>
    <p><label> Diplomes Candidat</label>
    <input type="text" name="diplomes" value="${sessionScope.diplomes}"><br></p>
    <p><label> Langues Candidat</label>
    <input type="text" name="langues" value="${sessionScope.langues}"><br></p>
    <p><label> Age Candidat</label>
    <input type="number" name="age" value="${sessionScope.age}"><br></p>
    <p><label>Mot de passe Candidat</label>
    <input type="password" name="paswd" value="${sessionScope.paswd}"><br></p>
    
    <P><input type="submit" value="modifier"><input type="reset" value="annuler"><br></P>
 
  </form>
</div>      
     
  
  
   
  </div>
  

</section>


<!-- scroll top button  -->















<!-- jquery cdn link  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>
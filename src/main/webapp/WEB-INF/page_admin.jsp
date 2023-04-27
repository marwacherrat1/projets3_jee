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
    <title>page administrateur</title>
       <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/18d2ef7c15.js" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">    
   <link rel="stylesheet" href="fontawesome/css/all.min.css">
     
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="administrateur.css">

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
            <li><a href="#rec">Les recruteurs</a></li>
            <li><a href="#c">Les candidats</a></li>
            <li><a href="#o">Les offres</a></li>
            <li><a href="#p">Les postulations</a></li>
            <li><a href="Deconnexion">Déconnexion</a>
        </ul>
    </nav>

</header>

<!-- header section ends -->

<div id="menu" class="fas fa-bars"></div>

<!-- home section starts  -->

<section class="home" id="profil">

    <h3>Bienvenue Mme</h3>
    <h1>${sessionScope.prenom}<span>${sessionScope.nom}</span></h1><br>
    <p><span>--> Téléphone:</span> ${sessionScope.tel }</p>
    <p><span>--> Mail:</span>${sessionScope.mail}
    </p>
   
</section>

<!-- home section ends -->

<!-- about section starts  -->

<section class="about" id="rec">

<h1 class="heading"> <span>Les </span> recruteurs </h1>
<br><br><br><br>
<div class="box-container">

  <div class="left">
    
        <a href="/JEE/ajout_recruteur.jsp">
            <i class="fa-solid fa-circle-plus fa-3x"> </i>
        </a>
   </div>
        
        <table class="center">
          <tr>
          <th></th>
          <th>nom</th>
          <th>mail</th>
          <th>adresse</th>

          <th>description</th>
          <th>supprimer</th>
          <th>modifier</th>
          </tr>
          <%int r=1; %>
          <c:forEach var="rec" items="${ recruteurs }">
          
            <tr >
            
            <td>Recruteur<%=r%></td>
            <td><c:out value="${ rec.nom }" /></td>
            <td><c:out value="${ rec.mail }" /> </td>
            <td><c:out value="${ rec.adresse }" /> </td>
            
            <td><c:out value="${ rec.description }" /> </td>
            <td><a href="supprec?idr=${ rec.getIdr() }"><span class="bi bi-trash-fill center"></span></a></td>
              <!-- modification recruteur -->
            <td><a href="trouver?idr=${ rec.getIdr() }&s=${'all'}"><span class="bi bi-pencil-fill center"></span></a></td>
            <%r+=1; %>
            </tr>
            </c:forEach>
            
 
        
          
          <!-- Afficher les données de la base de données ici -->
        </table>
</div>      



</section>

<!-- about section ends -->

<!-- education section starts  -->

<section class="about" id="c">

<h1 class="heading"> Les <span>Candidats</span> </h1>
<br><br><br><br>
<div class="box-container">

  <div class="left">
    
        <a href="/JEE/ajout_candidat.jsp">
            <i class="fa-solid fa-circle-plus fa-3x"> </i>
        </a>
   </div>
        <table class="center">
        
          <tr>
            <th></th>
            <th>nom</th>
            <th>prenom</th>
            <th>CV</th>
            <th>supprimer</th>
            <th>modifier</th>
            
          </tr>
          <%int c=1; %>
            <c:forEach var="candidat" items="${ candidats }">
            <tr style="width:20%">
            <td>Candidat<%=c%></td>
            <td><c:out value="${ candidat.nom }" /></td>
            <td><c:out value="${ candidat.prenom }" /></td>
            
             <td><a href="cv?idc=${ candidat.getIdc()}&user=${sessionScope.nom}+${sessionScope.prenom}&s=${'all'}"> <span class="bi bi-display center"></span></a></td>
            <%c+=1; %>
            <td><a href="supp?idc=${ candidat.getIdc() }"><span class="bi bi-person-dash-fill center "></span></a></td>
              <!-- Modifier candidat -->
            <td><a href="trouvercandidat?idc=${ candidat.getIdc() }&s=${'all'}"><span class="bi bi-pencil-fill center"></span></a></td>
            
            </tr>
            </c:forEach>
        

        </table>
  </div>
</section>






<!-- portfolio section ends -->

<!-- contact section starts  -->

<section class="about" id="o">

<h1 class="heading"> <span>Les</span> offres </h1>
<div class="box-container">
<br><br><br><br>
  <table class="center">
          <tr>
            <th></th>
            <th>Titre offre</th>
            <th>Détails de l'offre</th>
            <th>Refuser</th>
                     
          </tr>
          <%int o=1; %>
           <c:forEach var="offre" items="${ offres }">
            <tr style="width:20%">
            <td>Offre<%=o%></td>
             <td><c:out value="${ offre.getTitre() }" /></td>
             <%o+=1; %>
               <!-- afficher details offre d'id =ido -->
            <td><a href="offreprecis?ido=${offre.getIdoffre() }&user=${sessionScope.nom} + ${sessionScope.prenom}&s=${'all'}"><span class="bi bi-display center"></span></a></td>
             <!-- on donne à validation 0 pour passer au else ou offre sera supprimé -->
            <td><a class ="center" href="ajout_offre?ido=${offre.getIdoffre()}&validation=${0}&s=${'all'}">Refuser l'offre</a></td>
         
           
            </tr>
             </c:forEach>
        </table>
</div>

</section>

<section class="about" id="p">
  <h1 class="heading"> <span>Les</span> postulations </h1>
   <br><br><br><br>
 
     <div class="box-container">
        <table class="center">
          <tr>
            <th></th>
            <th>Candidat</th>
            <th>Offre</th>
            <th>lettre motivation</th>
            
          </tr>
          <%int p=1; %>
          <c:forEach var="p" items="${ postulations }">
            <tr style="width:20%">
            <td>Postulation<%=p%></td>
              <!-- Afficher cv candidat qui a postulé la postulation p -->
            <td><a class ="center" href="cv?idc=${p.getId_postulant()}&user=${sessionScope.nom}+${sessionScope.prenom}&s=${'all'}"><i class="fa-solid fa-circle-user"></i></a></td>
              <!-- afficher offre qui concerne la postulation -->
            <td><a class ="center" href="offreprecis?ido=${p.getId_offre()}&user=${sessionScope.nom}+${sessionScope.prenom}&s=${'all'}"><span class="bi bi-display center"></span></a></td>
             <!-- Afficher l. motivation que candidat a saisis pour cette offre -->
            <td><a class ="center" href="lettremotivation?lettremotivation=${p.getLettremotivation() }&user=${sessionScope.nom}+ ${sessionScope.prenom}&s=${'all'}">Visualiser la lettre </a></td>
           <%p+=1; %>
            </tr>
             </c:forEach>
          <!-- Afficher les données de la base de données ici -->
        </table>
</div>      
     
  
  
   
 

</section>





<!-- jquery cdn link  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>
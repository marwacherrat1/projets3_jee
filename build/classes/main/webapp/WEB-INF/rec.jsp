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
    <title>Recruteur</title>
       <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/18d2ef7c15.js" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">    
   <link rel="stylesheet" href="fontawesome/css/all.min.css">
     
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="styl.css">

</head>
<body>
    
<!-- header section starts  -->

<header>

    <div class="user">
        
        <h3 class="name">${sessionScope.nom}</h3>
        <p class="post">${sessionScope.adresse }</p>
    </div>
 
   <nav class="navbar">
        <ul>
            <li><a href="#profil">Mon profil</a></li>
            <li><a href="#nv">Publier nouveau offre</a></li>
            <li><a href="#postulations">Postulations</a></li>
            <li><a href="#offres">Mes offres</a></li>
            <li><a href="#modifier">Modifier mon compte</a></li>
            <li><a href="Deconnexion">Déconnexion</a>
        </ul>
    </nav>

</header>

<!-- header section ends -->

<div id="menu" class="fas fa-bars"></div>

<!-- home section starts  -->

<section class="home" id="profil">

    <h3>Hello</h3>
    <h1>${sessionScope.nom}<span> se situe à ${sessionScope.adresse}</span></h1>
    <p>${sessionScope.description}
    </p>
    <a href="#nv"><button class="btn">Publier un nouveau offre</button></a>
    <a href="#modifier"><button class="btn">Modifier mon compte</button></a>
</section>

<!-- home section ends -->

<!-- about section starts  -->

<section class="about" id="nv">

<h1 class="heading"> <span>Publier</span> l'offre </h1>

<div class="row">

<div class="container">
    <form action="ajout_offre" >
    <input type="hidden" name="validation" value="1">
    <label for="titre" class="center">Titre de l'offre :</label>
    <input type="text" id="titre" name="titre" required>
    <br>
    
    <label for="description" class="center">Description :</label>
    <textarea id="description"class="center" name="description"></textarea><br>
    
    <label for="date-limite" class="center">Délai :</label>
    <input type="date" id="date-limite" name="delai" required><br>
    
    <label for="date-offre" class="center">Date de l'offre :</label>
   
    
    <input type="date" id="date-offre" name="date" value=<%
   Date dNow = new Date( );
   SimpleDateFormat ft = 
   new SimpleDateFormat ("yyyy-MM-dd ");
  out.print(   ft.format(dNow));
  %> readonly> <br>
    <label for="competences" class="center" >Competences demandées :</label>
    <textarea id="competence" name="competences"></textarea><br>
    
<div class="center">
<input class="center" type="submit" value="Publier">
    </div>
 
  </form>
</div>      

</div>

</section>

<!-- about section ends -->

<!-- education section starts  -->

<section class="education" id="postulations">

<h1 class="heading"> Les <span>postulations</span> </h1>

<div class="box-container">

  <table class="center">
    
      <tr>
        <th></th>
        
        <th>CV du candidat ayant postulé</th>
        <th>Lettre de motivation du candidat</th>
        <th>Détails offres</th>
      </tr>
      <%int c=1; %>
      <c:forEach var="p" items="${ postulations }">
      <tr>
        <td>Postulation <%=c %></td>
        <%c+=1; %>
        <td><a class ="center" href="cv?idc=${p.getId_postulant()}&user=${sessionScope.nom}&s=${'recruteur'}">Visualiser cv candidat</a></td>
        <td><a class ="center" href="lettremotivation?lettremotivation=${p.getLettremotivation()}&user=${sessionScope.nom}&s=${'recruteur'}">Visualiser la lettre </a></td>
        <td><a class ="center" href="offreprecis?ido=${p.getId_offre() }&user=${sessionScope.nom}&s=${'recruteur'}"><span class="bi bi-display center"></span></a></td>
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

<h1 class="heading"> <span>Mes</span> offres </h1>
<div class="box-container">

  <table class="center">
          <tr>
            <th></th>
            <th>Titre offre</th>
            <th>Détails de l'offre</th>
            <th>Supprimer offre</th>
            <th>Modifier un offre</th>
            <%int count=1; %>
          </tr>
           <c:forEach var="offre" items="${ offres }">
            <tr style="width:20%">
            
            <td>Offre <%=count%></td>
            <%count+=1; %>
            <td><c:out value="${ offre.getTitre() }" /></td>
            <td><a href="offreprecis?ido=${offre.getIdoffre() }&user=${sessionScope.nom}&s=${'recruteur'}"><span class="bi bi-display center"></span></a></td>
            <td><a href="supprimeroffre?ido=${offre.getIdoffre() }">supprimer l'offre</a></td>
            <td><a href="trouveroffre?ido=${offre.getIdoffre() }&s=${'recruteur'}">modifier offre</a></td>
            

            </tr>
             </c:forEach>
        </table>

</div>

</section>

<section class="about" id="modifier">
  <h1 class="heading"> <span>Modifier</span> mon compte </h1>

  <div class="row">
     <div class="container">
    <form action="modifier_recruteurrecruteur" >
    <p>
    <input  type="hidden" name='page' value="${sessionScope.nom}">
    
    <input type= "password" id="idr" name="idr" value="${sessionScope.idr}" readonly><br>
    </p>
    <p>
    <label for="nom" class="center" >Nom de l'entreprise:</label>
    <input type="text" id="nom" name="nom" value ="${sessionScope.nom}"required>
    <br></p>
    <p>
    <label for="description" class="center">Description :</label>
    <textarea id="description"class="center" name="description" >${sessionScope.description}</textarea><br>
    </p>
    <label for="mail" class="center">Mail:</label>
    <input type="email" id="mail" name="mail"  value= "${sessionScope.mail}"required><br>
    <p>
    <label for="passwd" class="center">Mot de passe:</label> 
    <input type="password" id="passwd" name="passwd" value="${sessionScope.passwd}" > <br>
    </p>
    <p>
    <label for="addresse" class="center">Adresse:</label> 
    <input type="text" id="addresse" name="addresse" value="${sessionScope.adresse}" > <br>
    </p>
    
    <p><input type="submit" value="modifier"><input type="reset" value="annuler"><br></p>
    
 
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
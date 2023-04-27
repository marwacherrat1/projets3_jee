<!DOCTYPE html>
<html>
  <head>
    <title>CV</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="cv.css">
        <script src="https://kit.fontawesome.com/18d2ef7c15.js" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">    
   <link rel="stylesheet" href="fontawesome/css/all.min.css">
    
  </head>
  <body>

    
    <header>
      <h1>Bienvenue ${user} </h1>
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
      <div>
        <div class="cadre">
          <div class="c">
          <i class="fa-solid fa-circle-user fa-10x"></i>
          
          <h2>${candidat.nom} ${candidat.prenom}</h2></div>
           <hr>
          <div class="ca">
          <p><i class="fa fa-calendar"></i> Age : ${candidat.age}</p>
          <p><i class="fa fa-envelope"></i> Mail : ${candidat.mail}</p>
          <p><i class="fa fa-phone"></i> Téléphone : ${candidat.tel}</p>
          
          </div>
        </div>
      </div>
      <div>
        <div class="card">
          <h2><i class="fa fa-suitcase"></i> Projets</h2>
          <h5>j'ai déja effectué les projets suivantes :</h5>
          <p>${candidat.projets}</p>
        </div>
          <hr>
        <div class="card">
          <h2><i class="fa fa-suitcase"></i>Les Competences:</h2>
          

          <h5>Veuillez trouver  mes competences:</h5>
          <p>${candidat.competences}</p>
         
        </div>
         <hr>
        <div class="card">
          <h2><i class="fa fa-suitcase"></i> Les Langues:</h2>
          <h5>Veuillez trouver  les langues que je maitrise:</h5>
          <p>${candidat.langues}</p>
           
        </div>
        <hr>
        <div class="card">
          <h2><i class="fa fa-suitcase"></i> Les diplomes obtenues.</h2>
          <h5>Veuillez trouver  les diplomes que j'ai eu:</h5>
          <p>${candidat.diplomes}</p>
            
        </div>
         <hr>
      </div>
    </div>
 <footer>
      <p>Copyright © [Année] [Nom de votre entreprise]</p>
      </footer>
  </body>
</html>
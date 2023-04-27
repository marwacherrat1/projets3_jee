<!DOCTYPE html>
<html>
  <head>
    <title>CV</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="offreprecis.css">
        <script src="https://kit.fontawesome.com/18d2ef7c15.js" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">    
   <link rel="stylesheet" href="fontawesome/css/all.min.css">
    
  </head>
  <body>

    
    <header>
      <h1>Bienvenue ${user}</h1>
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

          <h2>Titre de l'offre : ${ offre.getTitre() }</h2></div>
           <hr>
          <div class="ca">
        
          <p> <i class="fa-solid fa-calendar"></i> Date du dépot de l'offre: ${offre.getDateoffre()}</p>
           <p><i class="fa-solid fa-calendar-xmark"></i> Délai de l'offre: ${offre.getDelai()}</p>
          <p><i class="fa-solid fa-building"></i> Offre postulé par: ${ recruteur.getNom()}</p>
          <p><i class="fa-regular fa-at"></i> Mail du postulant: ${recruteur.getMail()}</p>
          <p><i class="fa-solid fa-location-dot"></i> Adresse du propriétaire de l'offre : ${recruteur.getAdresse()}</p>
          
          </div>
        </div>
      </div>
      <div>
        <div class="card">
          <h2><i class="fa fa-suitcase"></i> Missions et description de l'offre</h2>
          <h5>Description de l'offre</h5>
          <p> ${ offre.getDescription() }</p>
        </div>
          <hr>
        <div class="card">
          <h2><i class="fa fa-suitcase"></i>Les Competences:</h2>
          

          <h5>Les competences demandés</h5>
          <p>${offre.getCompetence()}</p>
         
        </div>
         <hr>
        
      </div>
    </div>
 <footer>
      <p>Copyright © [Année] [Nom de votre entreprise]</p>
 </footer>
  </body>
</html>
 
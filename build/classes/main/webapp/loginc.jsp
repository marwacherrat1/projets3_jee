<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Connexion</title>
</head>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    display: flex;
    align-items: center;
    justify-content: center;
    background: linear-gradient(rgba(0,0,0,0.85), rgba(0,0,0,0.85)), url(image.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center;
}
h2{
  text-align: center;  
  color:red;
}

#cnx {
  background-color: #ffffff;
  opacity:0.65;
  margin: 180px auto;
  font-family: Raleway;
  padding: 40px;
  width: 50%;
  min-width: 300px;
}

h1 {
  text-align: center;  
}

input {
  padding: 10px;
  width: 100%;
  font-size: 17px;
  font-family: Raleway;
  border: 1px solid #aaaaaa;
}

/* Mark input boxes that gets an error on validation: */
input.invalid {
  background-color: #ffdddd;
}

/* Hide all steps by default: */
.tab {
  display: none;
}

button {
  background-color: #5499C7;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  font-size: 17px;
  font-family: Raleway;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
  color: #fff;
}



</style>
<body>

<form id="cnx" action="Loginc" method="post">
  <h1>connexion:</h1>
  <h2>${message}</h2>
  <label for="email">Mail du candidat:</label>
  <input type="text" id="email" name="email">
  <br>
  <label for="password">Mot de passe:</label>
  <input type="password" id="password" name="password">
  <br><br>
  <button type="submit" id="nextBtn" >Se connecter</button>
  
</form> 



</body>
</html>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<style>

#regForm {
  background-color: #ffffff;
  margin: 200px auto;
  font-family: Raleway;
  padding: 40px;
  width: 70%;
  min-width: 300px;
  opacity:0.65;
}

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



h1 {
  text-align: center;  
}

input {
  padding: 10px;
  width: 100%;
  font-size: 17px;
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
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}

#prevBtn {
  background-color: #5499C7;
}

/* Make circles that indicate the steps of the form: */
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #5499C7;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 0.5;
}

.step.active {
  opacity: 1;
}

/* Mark the steps that are finished and valid: */
.step.finish {
  background-color: #5499C7;
  }
</style>
<body>

<form id="regForm" class="form" action="InsCandidat" method="post" >
  <h1>Inscription candidat</h1>
  <!-- One "tab" for each step in the form: -->
  <div class="tab">informations personnels:
    <p><input type ="text" name="nom" placeholder="Nom" oninput="this.className = ''" ></p>
    <p><input type ="text" name="prenom" placeholder="Prenom" oninput="this.className = ''" ></p>
    <p><input type ="number" name="age" placeholder="age" oninput="this.className = ''" ></p>
    <p><input type ="text" name="tel" placeholder="Téléphone" oninput="this.className = ''" ></p>
  </div>

  
  <div class="tab">infos generale:
    <p><input type ="text" name="diplomes" placeholder="Diplomes" oninput="this.className = ''" ></p>
    <p><input  type ="text" name="competences" placeholder="Competences" oninput="this.className = ''" ></p>
    <p><input type ="text" name="langues" placeholder="Langues" oninput="this.className = ''" ></p>
    <p><input type ="text" name="projets" placeholder="Projets" oninput="this.className = ''" ></p>
    
  </div>
  
  <div class="tab">Infos de connexion:
    <p><input type ="email" name="mail" placeholder="Email" oninput="this.className = ''" ></p>
    <p><input type ="password" name="pswd"  type="password" placeholder="Mot de passe" oninput="this.className = ''" ></p>
    
  </div>
  
  <div class="tab">confirmation:
  </div>
  
  <div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div>
  </div>
  <!-- Circles which indicates the steps of the form: -->
  <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    
  </div>
</form>

<script>
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}
</script>

<script>
function addInput() {
    var container = document.getElementById("inputs");
    var newInput = document.createElement("input");
    newInput.type = "text";
    newInput.placeholder = "Entrer un champ";
    container.appendChild(newInput);
}
</script>
</body>
</html>
    
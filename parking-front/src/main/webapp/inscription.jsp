<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>



<head>
<title>Inscription</title>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>




  body{
  background-color:#F4EFE7;
  }
  
  div{
display:flex;
justify-content:center;
}
body{
background-color:#c0C8F8;
}



  footer{
	display:flex;
	flex-direction : column;
	margin-top :25px;
	width : 100%;
	/* background-color:#432BD4; */
	}
  #btnretour
  {
    width: 100%;
    margin-top: 10px;
  }
  #btn1
  {
    width: 100%;
    margin-top: 10px;
  }
  #btn2
  {
    width: 100%;
    margin-top: 10px;
  }

  </style>

  </head>

  <body>

    <div >
    <form action="#" method="POST">
    <fieldset>
    	<legend>Inscription</legend>
    <table>

      <td>Login : </td>
    	<td><input type = "text" placeholder = "entrez votre login" required /></td>
    	</tr>
      <td>Password: </td>
    	<td><input type = "password" placeholder = "entrez votre password" required /></td>
    	</tr>
      <td>Nom : </td>
    	<td><input type = "nom" placeholder = "entrez votre nom" required /></td>
    	</tr>
      <td>Prenom : </td>
    	<td><input type = "prenom" placeholder = "entrez votre prenom" required /></td>
    	</tr>
      <td>Type compte : </td>
    	<td><select>
          <option>Admin</option>
            <option>Responsable</option>
              <option>Utilisateur</option>

      </select>
    	</tr>
      <td>Votre entreprise : </td>
    	<td><input type = "text" placeholder = "entrez votre entreprise" required /></td>
    	</tr>
      <td>Date de naissance: </td>
    	<td><input type = "date" value="2000-01-01" required /></td>
    	</tr>
      <td>Mail : </td>
    	<td><input type = "text" placeholder = "entrez votre mail" required /></td>
    	</tr>
      <td>Civilite </td>
    	<td><input type = "text" placeholder = "entrez votre telephone" required /></td>
    	</tr>
      <td>Login : </td>
    	<td><select>
          <option>Femme</option>
            <option>Homme</option>
              <option>NB</option>

      </select></td>
    	</tr>
      </table>
      
	  
	  <footer>
	
		 <form action="#" method="POST">
		   <input id="btn1" class="btn btn-primary" type ="submit" value="S'inscrire" />
		   <input id="btn2" class="btn btn-warning" type ="reset" />
       <a href="index.html">
        <input
          id="btnretour"
          class="btn btn-secondary"
          type="button" value="Retour">
        
          
        </button>
      </a>
		  </form>
		  
		  
		 
		  </footer>












    </fieldset>
    </form>
    </div>








  </body>



  </html>

<script language="javascript">

function controle(formCreationUser) {

var firstname 	= document.getElementById("firstname").value;
var surname	 	= document.getElementById("surname").value;
var email 		= document.getElementById("email").value;
var password 	= document.getElementById("mdp").value;
var mobile 		= document.getElementById("mobile").value;
var address 	= document.getElementById("address").value;
var postalCode 	= document.getElementById("postalCode").value;
var city	 	= document.getElementById("city").value;
var dateOfBirth = document.getElementById("dateOfBirth").value;
var status	 	= document.getElementById("status").value;
var siret = document.getElementById("siret").value;

alert(firstname)

   $.ajax({
   				url : '/user', // La ressource ciblé
                type : 'POST', // Le type de la requête HTTP.
                data : { firstname : firstname, surname : surname, email : email, password : password, mobile : mobile, address : address, postalCode : postalCode, city : city, dateOfBirth : dateOfBirth,
                    status : status, siret :siret},
            });

}

function deletion(formDeletion) {

var id 	= document.getElementById("idDeletion").value;


alert(idDeletion)

   $.ajax({
   				url : '/user/'+id, // La ressource ciblé
                type : 'DELETE', // Le type de la requête HTTP.
            });

}

function Update(formUpdateUser) {

var id 	= document.getElementById("id").value;
var firstname 	= document.getElementById("firstnameUpdate").value;
var surname	 	= document.getElementById("surnameUpdate").value;
var password 	= document.getElementById("mdpUpdate").value;
var mobile 		= document.getElementById("mobileUpdate").value;
var address 	= document.getElementById("addressUpdate").value;
var postalCode 	= document.getElementById("postalCodeUpdate").value;
var city	 	= document.getElementById("cityUpdate").value;
var dateOfBirth = document.getElementById("dateOfBirthUpdate").value;

alert(firstname)

   $.ajax({
   				url : '/user/'+id, // La ressource ciblé
                type : 'PUT', // Le type de la requête HTTP.
                data : { firstname : firstname, surname : surname, password : password, mobile : mobile, address : address, postalCode : postalCode, city : city, dateOfBirth : dateOfBirth},
            });

}


</script>
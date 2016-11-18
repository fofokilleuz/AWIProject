var app = angular.module("myApp", ['ngCookies']);

//to control the ManageUser.html page
app.controller("manageLoginCtrl", function($scope, $http, $cookies) {
    
    /* function authenticate(formAuthenticate) {
        var userName = document.getElementById("userName").value;
        var mdp	= document.getElementById("mdp").value;

            $.ajax({
   				url : '/login', // La ressource ciblé
                type : 'POST', // Le type de la requête HTTP.
                data : { userName : userName, mdp : mdp},
            });
    }*/
    
    
    //Authentificate function to verify the good username and password
    $scope.authenticate = function() {
        var data = {
            userName : $scope.userName,
            mdp : $scope.mdp
        };
        $http.post('/login', data).then(function (response) {
            if (response.data)
            $scope.resultLogin = "You are connected!";
        }, function (response) {
                $scope.resultLogin = "An error was occured during connection!";
                $scope.dataafficher = data.userName;
        });
        
    };
    
    /*function isConnected(){
        var id = getCookie("idGoldFish");
        var token = getCookie("tokenGoldFish");
        
            $.ajax({
   				url : '/login/'+token+'/user/'+id, // La ressource ciblé
                type : 'GET', // Le type de la requête HTTP.
            });*/

    //isConnected function, to know if the user is connected
    $scope.isConnected = function() {
        
        var id = $cookies.get("idGoldFish");
        var token = $cookies.get("tokenGoldFish");

        $http.get("/login/" + token + "/user/" + id).then(function(response) {
            $scope.isConnected = "Vous êtes connecté" + id + token;
        }, function (response) {
            $scope.isConnected = "Vous n'êtes pas connecté ";
        });
    };
    
    
    /*function getCookie(name){
        if(document.cookie.length == 0)
            return null;
        var regSepCookie = new RegExp('(; )', 'g');
        var cookies = document.cookie.split(regSepCookie);

        for(var i = 0; i < cookies.length; i++){
            var regInfo = new RegExp('=', 'g');
            var infos = cookies[i].split(regInfo);
            if(infos[0] == name){
                return unescape(infos[1]);
            }
        }
        return null;
    }*/

    $scope.deconnection = function() {

        $http.post("/deconnection").then(function(response) {
            $scope.isntConnected = "Vous êtes déconnecté";
        }, function (response) {
            $scope.isntConnected = "Vous n'êtes pas déconnecté ";
        });
    };
    
    
    //
    $scope.isConnected();

});
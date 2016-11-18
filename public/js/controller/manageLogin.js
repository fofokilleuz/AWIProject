var app = angular.module("myApp", ['ngCookies']);

//to control the ManageUser.html page
app.controller("manageLoginCtrl", function($scope, $http, $cookies) {
    
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
    

    
    //
    $scope.isConnected();

});
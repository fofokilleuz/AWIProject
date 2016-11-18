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
    if (token !== undefined){
        //we verify is the person have a cookie
        $http.get("/login/" + token + "/user/" + id).then(function(response) {
            //if the person have a cookie we verify if its a simple user
            $http.get("/user/" + id).then(function(response) {
                window.location.assign("/homeUser")
            }, function (response) {
                 $scope.isConnected = "it's not a simple user" ;
             });
             $http.get("/seller/" + id).then(function(response) {
                   //window.location.assign("/homeSeller")
            }, function (response) {
                 $scope.isConnected = "it's not a seller" ;
             });
        }, function (response) {
            $scope.isConnected = "Don't try to hack our site with modify your cookies !";
        });
    } else {
        $scope.isConnected = "You aren't connected";
    }
    };

    $scope.isConnected();

});
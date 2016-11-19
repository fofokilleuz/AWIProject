var app = angular.module("myApp", ['ngCookies']);

//to control the ManageUser.html page
app.controller("manageLoginCtrl", function($scope, $window, $http, $cookies) {
    
    //Authentificate function to verify the good username and password
    $scope.authenticate = function() {
        var data = {
            userName : $scope.userName,
            mdp : $scope.mdp
        };
        $http.post('/login', data).then(function (response) {
            if (response.data){
                //reload the page to call isConnected
                window.location.reload();
            }
        }, function (response) {
                $scope.resultLogin = "Invalid username or password";
        });
        
    };
    
    //isConnected function, to know if the user is connected
    $scope.isConnected = function() {
        //the browser cookies
        var id = $cookies.get("idGoldFish");
        var token = $cookies.get("tokenGoldFish");
        var role = $cookies.get("roleGoldFish");

    if (token !== undefined){
        //we verify is the person have a correct token
        $http.get("/login/" + token + "/user/" + id).then(function(response) {
            //if the person have a cookie we verify if its a simple user or seller
            if (role == "su"){
                window.location.assign("/homeUser");
            } else if (role == "seller") {
                 window.location.assign("/homeSeller");
            }
        }, function (response) {
            $scope.isConnected = "Cookies have been modified";
        });
    }
    };

    $scope.isConnected();

});
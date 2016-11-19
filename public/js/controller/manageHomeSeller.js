var app = angular.module("myApp", ['ngCookies']);

//to control the HomeSeller.html page
app.controller("manageHomeSellerCtrl", function($scope,  $window, $http, $cookies) {
    
    $scope.deconnection = function() {

        $http.post("/deconnection").then(function(response) {
            window.location.assign("/")
        }, function (response) {
            $scope.isntConnected = "Vous n'êtes pas déconnecté ";
        });
    };
    
    //isConnected function, to know if the user is connected
    $scope.isConnected = function() {
        
        var id = $cookies.get("idGoldFish");
            //if the person have a cookie we verify if its a seller
            $http.get("/seller/" + id).then(function(response) {
                //if a seller with this id exist we verify token
                var token = $cookies.get("tokenGoldFish");
                var tokenU = response.data.token;
                if (token != tokenU ) {
                    window.location.assign("/")
                }
            }, function (response) {
                 window.location.assign("/")
             });

    };

    $scope.isConnected();
    
    
    
});
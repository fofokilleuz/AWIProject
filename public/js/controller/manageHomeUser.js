var app = angular.module("myApp", ['ngCookies']);

//to control the HomeUser.html page
app.controller("manageHomeUserCtrl", function($scope,  $window, $http, $cookies) {
    
    var idUser = $cookies.get("idGoldFish");
    
    $http.get("/user/" + idUser).then(function(response) {
        var user = response.data;
        $scope.idUser = user.idUser;
        $scope.email = user.email;
        $scope.userName = user.userName;
        $scope.firstname = user.firstname;
        $scope.lastname = user.lastname;
        $scope.mobile = user.mobile;
        $scope.address = user.address;
        $scope.postalCode = user.postalCode;
        $scope.city = user.city;
    }, function (response) {
    });
    
    $http.get("/products").then(function(response) {
        var products = $scope.products = response.data;
    }, function (response) {
        $scope.users = "An error was occured!" ;
    }); 
    
    $scope.updatePersonalInfo = function () {
        var idUser = $cookies.get("idGoldFish");
        var data = {
                    firstname : $scope.firstnameUpdate, 
                    lastname : $scope.lastnameUpdate, 
                    email : $scope.emailUpdate,
                    mobile : $scope.mobileUpdate
        };

        $http.put('/user/' + idUser, data).then(function (response) {
            if (response.data)
                window.location.reload();
        }, function (response) {
                $scope.resultUpdate = "An error was occured!";
        });
    };
    
    $scope.updateAddress = function () {
        var idUser = $cookies.get("idGoldFish");
        var data = {
                    address : $scope.addressUpdate, 
                    postalCode : $scope.postalCodeUpdate, 
                    city : $scope.cityUpdate 
        };

        $http.put('/user/' + idUser, data).then(function (response) {
            if (response.data)
                window.location.reload();
        }, function (response) {
                $scope.resultUpdate = "An error was occured!";
        });
    };
    
    
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
            //if the person have a cookie we verify if its a simple user
            $http.get("/user/" + id).then(function(response) {
                //if a simple user with this id existwe verify token
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

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
    
    $http.get("/sellers").then(function(response) {
        var sellers = $scope.sellers = response.data;
    }, function (response) {
        $scope.users = "An error was occured!" ;
    }); 
    
    $http.get("https://sellbook-polytech.eu-gb.mybluemix.net/products").then(function(response) {
        var productsInteroperability = $scope.productsInteroperability = response.data;
    }, function (response) {
        $scope.users = "An error was occured!" ;
    });
    
    $http.get("/user/" + idUser + "/diaries").then(function(response) {
        var diaries = $scope.diaries = response.data;
    }, function (response) {
        $scope.diaries = "An error was occured!" ;
    }); 



//FOR ACCOUNT    
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
    
    
//FOR DIARY
    $scope.createDiary = function() {
        var idUser = $cookies.get("idGoldFish");
        var data = {
                    name : $scope.nameDiary, 
                    description : $scope.description
        };
        $http.post('/user/' + idUser + "/diary", data).then(function (response) {
            window.location.reload();
        }, function (response) {
            $scope.resultUpdate = "An error was occured!";
        });
    }
    
    $scope.createGoal = function(idDiary) {
        var idUser = $cookies.get("idGoldFish");
        var data = {
                    name : $scope.nameGoal,
                    description : $scope.descriptionGoal
        };
        $http.post('/user/' + idUser + "/diary/" + idDiary +"/goal", data).then(function (response) {
            window.location.reload();
        }, function (response) {
            $scope.resultAddProducttoSeller = "An error was occured!";
        });
    }
    
    $scope.createEntry = function(idDiary) {
        var idUser = $cookies.get("idGoldFish");
        var data = {
                    description : $scope.descriptionEntry
        };
        $http.post('/user/' + idUser + "/diary/" + idDiary +"/entry", data).then(function (response) {
            window.location.reload();
        }, function (response) {
            $scope.resultAddProducttoSeller = "An error was occured!";
        });
    }
    
    
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
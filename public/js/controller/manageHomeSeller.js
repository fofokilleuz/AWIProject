var app = angular.module("myApp", ['ngCookies']);

//to control the HomeSeller.html page
app.controller("manageHomeSellerCtrl", function($scope,  $window, $http, $cookies) {
    
    
    var idSeller = $cookies.get("idGoldFish");
    $scope.idSeller = idSeller;
    
    $http.get("/seller/" + idSeller).then(function(response) {
        var seller = response.data;
        $scope.email = seller.email;
        $scope.userName = seller.userName;
        $scope.firstname = seller.firstname;
        $scope.lastname = seller.lastname;
        $scope.mobile = seller.mobile;
        $scope.address = seller.address;
        $scope.postalCode = seller.postalCode;
        $scope.city = seller.city;
        $scope.siret = seller.siret;
        $scope.urlweb = seller.urlweb;
    }, function (response) {
    });
    
    $http.get("/seller/" + idSeller + "/products").then(function(response) {
        var products = $scope.products = response.data;
        $scope.idProduct = products.idProduct;
    }, function (response) {
        $scope.users = "An error was occured!" ;
    });
    
    $http.get("https://sellbook-polytech.eu-gb.mybluemix.net/products").then(function(response) {
        var productsInteroperability = $scope.productsInteroperability = response.data;
    }, function (response) {
        $scope.users = "An error was occured!" ;
    });
    
    $http.get("/sellers").then(function(response) {
        var sellers = $scope.sellers = response.data;
    }, function (response) {
        $scope.users = "An error was occured!" ;
    });
    
    $scope.updatePersonalInfo = function () {
        var idSeller = $cookies.get("idGoldFish");
        var data = {
                    firstname : $scope.firstnameUpdate, 
                    lastname : $scope.lastnameUpdate, 
                    email : $scope.emailUpdate,
                    mobile : $scope.mobileUpdate,
                    siret : $scope.siretUpdate,
                    urlweb : $scope.urlwebUpdate
        };
        $http.put('/seller/' + idSeller, data).then(function (response) {
            if (response.data)
                window.location.reload();
        }, function (response) {
                $scope.resultUpdate = "An error was occured!";
        });
    };
    
    $scope.updateAddress = function () {
        var idSeller = $cookies.get("idGoldFish");
        var data = {
                    address : $scope.addressUpdate, 
                    postalCode : $scope.postalCodeUpdate, 
                    city : $scope.cityUpdate 
        };
        $http.put('/seller/' + idSeller, data).then(function (response) {
            if (response.data)
                window.location.reload();
        }, function (response) {
                $scope.resultUpdate = "An error was occured!";
        });
    };
    
    $scope.createProductToSeller = function() {
        var idSeller =  $cookies.get("idGoldFish");        
        var data = {
                    ref : $scope.ref, 
                    name : $scope.productName, 
                    price : $scope.price, 
                    qty : $scope.quantity, 
                    desc : $scope.description
        };
        $http.post('/seller/' + idSeller + "/product", data).then(function (response) {
            if (response.data)
                window.location.reload();
        }, function (response) {
        });
    };
    
    $scope.deleteProduct = function (idProduct) {
        $http.delete('/product/' + idProduct).then(function (response) {
            if (response.data)
                window.location.reload();
        }, function (response) {
                $scope.resultDelete = "An error was occured!" ;
        });
    };
    
    $scope.deconnection = function() {
        
        $http.post("/deconnection").then(function(response) {
            window.location.assign("/");
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
                    window.location.assign("/");
                }
            }, function (response) {
                 window.location.assign("/");
             });

    };

    $scope.isConnected();
    
    
    
});
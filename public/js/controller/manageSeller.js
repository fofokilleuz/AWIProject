var app = angular.module("myApp", []);

app.controller("manageSellerCtrl", function($scope, $http) {
    
    $scope.createSeller = function () {
        var data = {
                    firstname : $scope.firstname, 
                    lastname : $scope.lastname, 
                    email : $scope.email, 
                    password : $scope.password, 
                    mobile : $scope.mobile, 
                    address : $scope.address, 
                    postalCode : $scope.postalCode, 
                    city : $scope.city, 
                    siret : $scope.siret,
                    urlweb : $scope.urlweb,
        };

        $http.post('/seller', data).then(function (response) {
            if (response.data)
            $scope.resultCreate = "User was successfully created!";
        }, function (response) {
                $scope.resultCreate = "An error was occured!";
        });
    };
    
    
    $scope.deleteSeller = function () {
        var id =  $scope.idDeletion;
        $http.delete('/seller/' + id).then(function (response) {
            if (response.data)
            $scope.resultDelete = "Seller was successfully deleted! (id : " + id + " )";
        }, function (response) {
                $scope.resultDelete = "An error was occured!" ;
        });
    };


    $scope.updateSeller = function () {
        var id =  $scope.idUpdate;
        var data = {
                    firstname : $scope.firstnameUpdate, 
                    lastname : $scope.lastnameUpdate, 
                    email : $scope.emailUpdate, 
                    password : $scope.passwordUpdate, 
                    mobile : $scope.mobileUpdate, 
                    address : $scope.addressUpdate, 
                    postalCode : $scope.postalcodeUpdate, 
                    city : $scope.cityUpdate, 
                    siret : $scope.siretUpdate,
                    urlweb : $scope.urlwebUpdate
        };

        $http.put('/seller/' + id, data).then(function (response) {
            if (response.data)
            $scope.resultUpdate = "Seller was successfully updated!";
        }, function (response) {
                $scope.resultUpdate = "An error was occured!" + email;
        });
    };
    
    
    
    $scope.createProductToSeller = function() {
        var id =  $scope.idSellerToProduct;        
        var data = {
                    ref : $scope.ref, 
                    name : $scope.productName, 
                    price : $scope.price, 
                    qty : $scope.quantity, 
                    desc : $scope.description
        };
        
        $http.post('/seller/' + id + "/product", data).then(function (response) {
            if (response.data)
            $scope.resultAddProducttoSeller = "Product was successfully added to seller's id : " + id;
        }, function (response) {
            $scope.resultAddProducttoSeller = "An error was occured!";
        });
    };
    
    
});
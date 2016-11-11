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
        /**var id =  $scope.idDeletion;
        $http.delete('/user/' + id).then(function (response) {
            if (response.data)
            $scope.resultDelete = "User was successfully deleted! (id : " + id + " )";
        }, function (response) {
                $scope.resultDelete = "An error was occured!" ;
        });*/
    };


    $scope.updateSeller = function () {
        /**var id =  $scope.idDeletion;
        var data = {
                    firstname : $scope.firstnameUpdate, 
                    lastname : $scope.lastnameUpdate, 
                    email : $scope.emailUpdate, 
                    password : $scope.passwordUpdate, 
                    mobile : $scope.mobileUpdate, 
                    address : $scope.addressUpdate, 
                    postalCode : $scope.postalCodeUpdate, 
                    city : $scope.cityUpdate, 
        };

        $http.put('/user/' + id, data).then(function (response) {
            if (response.data)
            $scope.resultUpdate = "User was successfully updated!";
        }, function (response) {
                $scope.resultUpdate = "An error was occured!" + firstname + email;
        });*/
    };
    
    
});
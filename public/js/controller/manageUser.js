var app = angular.module("myApp", []);

//to control the ManageUser.html page
app.controller("manageUserCtrl", function($scope, $http) {
    
    $scope.createUser = function () {
        var data = {
                    firstname : $scope.firstname, 
                    lastname : $scope.lastname, 
                    email : $scope.email, 
                    password : $scope.password, 
                    mobile : $scope.mobile, 
                    address : $scope.address, 
                    postalCode : $scope.postalCode, 
                    city : $scope.city
        };

        $http.post('/user', data).then(function (response) {
            if (response.data)
            $scope.resultCreate = "User was successfully created!";
        }, function (response) {
                $scope.resultCreate = "An error was occured!";
        });
    };
    
    
     $scope.deleteUser = function () {
        var id =  $scope.idDeletion;
        $http.delete('/user/' + id).then(function (response) {
            if (response.data)
            $scope.resultDelete = "User was successfully deleted! (id : " + id + " )";
        }, function (response) {
                $scope.resultDelete = "An error was occured!" ;
        });
    };


    $scope.updateUser = function () {
        var id =  $scope.idUpdate;
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
        });
    };
});


//to control the AllUsers.html page
app.controller("allUsersCtrl", function($scope, $http) {
    
    $http.get("/users").then(function(response) {
        var users = $scope.users = response.data;
        $scope.id =response.data.id;
    }, function (response) {
        $scope.users = "An error was occured!" ;
    });
    
});

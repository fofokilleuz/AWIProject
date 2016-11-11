var app = angular.module("myApp", []);

app.controller("manageUserCtrl", function($scope, $http) {
    
    $scope.createUser = function () {
        var data = {
                    firstname : $scope.firstname, 
                    surname : $scope.surname, 
                    email : $scope.email, 
                    password : $scope.password, 
                    mobile : $scope.mobile, 
                    address : $scope.address, 
                    postalCode : $scope.postalCode, 
                    city : $scope.city, 
                    dateOfBirth : $scope.dateOfBirth,
                    status : $scope.statut,
                    siret : $scope.siret
        };

        
        $http.post('/user', data).then(function (response) {
            if (response.data)
            $scope.result = "Post Data Submitted Successfully!";
        }, function (response) {
                $scope.result = data;
        });
        
        
    };

    
});
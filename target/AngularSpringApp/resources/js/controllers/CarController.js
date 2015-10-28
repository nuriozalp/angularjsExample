'use strict';

/**
 * CarController
 * @constructor
 */
var CarController = function($scope, $http) {
    $scope.fetchCarsList = function() {
        $http.get('cars/carlist.json').success(function(carList,status){
            $scope.cars = carList;
            // alert(status);
        });
    };

    $scope.addNewCar = function(newCar) {
        $http.post('cars/addCar/' + newCar).success(function() {
            $scope.fetchCarsList();
        }).error(function (err, status,headers,config) {
      
              alert(err.message);
            console.error('Repos error', status, err);
        }).finally(function () {
                    alert("finally");
                    console.log("finally finished repos");
        });
        $scope.carName = '';
    };

    $scope.removeCar = function(car) {
        $http.delete('cars/removeCar/' + car).success(function() {
            $scope.fetchCarsList();
        });
    };

    $scope.removeAllCars = function() {
        $http.delete('cars/removeAllCars').success(function() {
            $scope.fetchCarsList();
        });

    };

    $scope.fetchCarsList();
};
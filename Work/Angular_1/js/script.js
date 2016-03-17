/**
 * Created by lenovo on 16-03-2016.
 */


var myApp = angular.module("myModule", []);

myApp.controller("myController", function ($scope) {
    var prop = {
        name: "Vinit",
        age: "21",
        company: "Wipro Digital",
        Location: "Bangalore",
    }

    $scope.message=prop;
});

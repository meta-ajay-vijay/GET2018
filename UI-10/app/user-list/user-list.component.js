'use strict';

angular.module('userList').
    component('userList',{
        templateUrl: 'user-list/user-list.template.html',
        controller: function UserListController($scope,$http){
            
            $scope.userData;

            var self= this;

            $http.get('http://localhost:3000/users').then(function(response){
                self.users = response.data;
            });

            /*$scope.postData=function(){
                $http({
                    method:'POST',
                    url:'http://localhost:3000/users/',
                    data: $scope.user,
                    dataType:'json'
                });

                window.location.reload();
            };*/
            $scope.postData=function(){
             if($scope.user.id === 'null'){
                    console.log("Post ho rha h");
                    $http({
                      method: 'POST',
                      url:'http://localhost:3000/users/',
                      data: $scope.user,
                      dataType:'json'
                    });
                 }else{
                    console.log("Put ho rha h");
                    $http.put('http://localhost:3000/users/' + $scope.user.id,$scope.user);
                 }
                 console.log("Jo hona tha ho gya");
                /*$scope.resetUser();*/
                window.location.reload();
              }

            $scope.editUser = function(id){
                 console.log(id);
                 console.log("Id get ho rha h");
                 $http({
                      method: 'GET',
                      url: 'http://localhost:3000/users/' + id
                     }).then(function (response){
                    $scope.user = response.data;
                    });
                    console.log("Jo hona tha ho gya");
                }

             $scope.resetUser = function(){
                 let user = {
                    "id" : "null",
                    "name": "",
                    "phone": "",
                    "location": ""
                  };
                  $scope.user = user;
                }

            $scope.show=function(userData){
                self.userData = userData;
            }
        }
    });

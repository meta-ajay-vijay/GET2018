'use strict';

angular.module('cartDetail').
component('cartDetail',{
    templateUrl: "cart-detail/cart-detail.template.html",
    controller: ['$routeParams','$http','$scope',function CartDetailController($routeParams,$http,$scope){

        var self = this;
        $http.get('http://localhost:3000/cart').then(function(response){
            self.items = response.data;
            var item;
           
        });

        $http.get('http://localhost:3000/products').then(function(response){
            self.products = response.data;
        });

        $scope.deleteAll=function(){

            var item = 1;
            var product = 1;

            self.products.forEach(function(product){
                product.showAddToCart = true;
                $http.put('http://localhost:3000/products/' + product.id,product);
            });

            self.items.forEach(function(item){
                $http.delete('http://localhost:3000/cart/' + item.id, item).then(function(response){
                    console.log("successfull");
                })
            });
            window.location.reload();
        }

        $scope.removeItem = function(item){
            item.count--;
            if (item.count == 0) {
             self.products.forEach(function(product){
                if(item.id === product.id){
                 product.showAddToCart = true;
                 $http.put('http://localhost:3000/products/' + product.id,product);
             }     
         });

             $http.put('http://localhost:3000/products/' + self.products.id,self.products);
             $http.delete('http://localhost:3000/cart/' + item.id,item);
         }else{
          $http.put('http://localhost:3000/cart/' + item.id,item);
      }
      window.location.reload();
  };

  $scope.addItem=function(item){
      item.count++;
      $http.put('http://localhost:3000/cart/' + item.id,item);
      window.location.reload();
  };


}]
});
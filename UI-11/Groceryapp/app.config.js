'use strict';

angular.module('shoppingApp').
    config(['$locationProvider','$routeProvider',
        function config($locationProvider,$routeProvider){

            $locationProvider.hashPrefix('!');

            $routeProvider.
                when('/products',{
                    template:'<product-list></product-list>'
                }).
                when('/products/cart/:cartCount',{
                    template:'<cart-detail></cart-detail>'
                }).
                when('/products/shipping',{
                    template:'<shipping-detail></shipping-detail>'
                }).
                when('/products/order-success',{
                    template:'<order-success></order-success>'
                }).
                when('/products/orders/:cartCount',{
                    template:'<orders></orders>'
                }).
                otherwise('/products');
        }
    ]);
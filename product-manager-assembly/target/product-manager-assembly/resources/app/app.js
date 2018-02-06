/**
 * Created by Administrator on 2017/9/12.
 */
var app=angular.module("myApp",["ngRoute","ngResource"]);

app.config(function($routeProvider,$locationProvider){
    $locationProvider.hashPrefix('');
    $routeProvider.
    when('/productList',{
        templateUrl:'../pages/product.html',
    }).
    when('/main',{
        templateUrl:'../pages/main.html'
    }).
    otherwise({
        redirectTo: "/productList"
    })
})


  app.run(["$rootScope",gorun])
function gorun($rootScope){
    //$rootScope.hintlog="保存成功!"
    //$rootScope.alertlog="数据不是想要的"
    //$rootScope.conformLog="您真的要确认吗?"
    /*alert弹框*/
    $rootScope.showAlert=function (){
        $("#mask").show()
        $("#alertlog").show()
    }
    $rootScope.hideAlert=function(){
        $("#mask").hide();
        $("#alertlog").hide();
    }
    $rootScope.alertPart=function(o){
        $rootScope.alertlog=o
        $rootScope.showAlert()
    }

}

app.service('sessionService', sessionService)
function sessionService($window,$rootScope) {

    return {
        set: set,
        get: get,
        setObject: setObject,
        getObject: getObject,
        remove: remove,
        clear: clear
    };

    function set(key, value) {
        $window.sessionStorage[key] = value;
    }

    function get(key) {
        return $window.sessionStorage[key] || '';
    }

    function setObject(key, value) {
        $window.sessionStorage[key] = JSON.stringify(value);
    }

    function getObject(key) {
        return JSON.parse($window.sessionStorage[key] || '{}');
    }

    function remove(key) {
        $window.sessionStorage.removeItem[key];
    }

    function clear() {
        $window.sessionStorage.clear();
    }

}

app.filter('textLengthSet', function() {
    return function(value, wordwise, max, tail) {
        if (!value) return '';

        max = parseInt(max, 10);
        if (!max) return value;
        if (value.length <= max) return value;

        value = value.substr(0, max);
        if (wordwise) {
            var lastspace = value.lastIndexOf(' ');
            if (lastspace != -1) {
                value = value.substr(0, lastspace);
            }
        }

        return value + (tail || ' …');//'...'可以换成其它文字
    };
});
app.controller("mainCont",["$scope","$http", "$resource", "$rootScope","$route","sessionService","$q","$location",function($scope,$http,$resource,$rootScope,$route,sessionService,$q,$location){
    $scope.$route = $route;
    function transData(a, idStr, pidStr, childrenStr) {
        var r = [], hash = {}, code = idStr, parentCode = pidStr, children = childrenStr, i = 0, j = 0, len = a.length;
        for (; i < len; i++) {
            hash[a[i][code]] = a[i];
        }
        for (; j < len; j++) {
            var aVal = a[j], hashVP = hash[aVal[parentCode]];
            if (hashVP) {
                !hashVP[children] && (hashVP[children] = []);
                hashVP[children].push(aVal);
            } else {
                r.push(aVal);
            }
        }
        return r;
    }

    function listfo()
    {
        var Oran=$resource('/userRule/rule');
        Oran.get(function (res) {
            console.log(res);
            $scope.namettt=res.admin.name;
            $scope.leafs = res.admin.leafs;
            $scope.jsonDataTree = transData($scope.leafs, 'code', 'parentCode', 'children');
            console.log($scope.jsonDataTree)
            angular.forEach($scope.jsonDataTree, function (d, index) {
                console.log($scope.jsonDataTree)
                $scope.namest = $scope.jsonDataTree[index].name;
                $scope.child = $scope.jsonDataTree[index].children;
                console.log($scope.child)
                //$scope.oneName = $scope.child.name;

                angular.forEach($scope.child, function (d, index) {
                    $scope.oneName = $scope.child[0].name;
                    console.log($scope.oneName)
                    //$scope.twoName = $scope.child[1].name;
                });
            });
        },function (err) {
            console.log("查询失败！")
        });
    }

    listfo();
    $scope.signOut=function(){
        window.location.href=window.location.origin + "/logout"
    }


}]);




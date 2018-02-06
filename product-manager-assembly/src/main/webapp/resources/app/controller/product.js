
app.controller("productCont",["$scope","$http", "$resource", "$rootScope","$route","sessionService","$q","$location",function($scope,$http,$resource,$rootScope,$route,sessionService,$q,$location){
    $scope.$route = $route;
    $scope.prolist = {
        proTypes: "",
        proTypest: "",
        proTypesg:"",
        proState:"",
        proName:"",
        pageSize:15
    }
    $scope.viewAll='全部';
    $scope.noneTip='暂无数据';
    $scope.none=false;

    /*列表*/
    function list(page)
    {
        var Oran=$resource('/product/getproductsbyconditions?type1='+$scope.prolist.proTypes+'&type2='+$scope.prolist.proTypest+'&type3='+$scope.prolist.proTypesg+'&state='+$scope.prolist.proState+'&keyofname='+encodeURI($scope.prolist.proName)+'&page='+page+'&size='+$scope.prolist.pageSize);
        Oran.get(function (res) {
            if(!res.executed){
                console.log(res)
                $scope.rowsList=[];
                $scope.totalData=0;
                $scope.totalPagess=0;
                $scope.PageCount=0;
                identifn()
            }else {
                $scope.none=true;
                console.log(res)
                $scope.rowsList=res.productInfoDTOS;
                $scope.totalData=res.total;
                if($scope.totalData===0){
                    $scope.none=false;
                }
                $scope.totalPagess=Math.ceil($scope.totalData/15);


                    $scope.PageCount=Math.ceil($scope.totalData/15);
                    $scope.numberKeyList=[];
                    $scope.page=page;
                    $scope.index=page-1;
                    if($scope.PageCount>10){
                        initFn(10)
                        identifn()
                    }else{
                        initFn($scope.PageCount)
                        identifn()
                    }

            }


        },function (err) {
            console.log("查询失败！")
        });
    };

    list(1)
    $scope.index=0;
    $scope.page=1;

    //临界点翻页变化
    function initFn(max){
        $scope.numberKeyList=[];
        if(max-9>0){
            for(var i=max-9;i<=max;i++){
                var obj={};
                obj.nmb=i;
                obj.isColor=false;
                $scope.numberKeyList.push(obj)
            }
        }
        else if(max==0){
            var obj={};
            obj.nmb=1;
            obj.isColor=false;
            $scope.numberKeyList.push(obj)
        }else {
            for(var i=1;i<=max;i++){
                var obj={};
                obj.nmb=i;
                obj.isColor=false;
                $scope.numberKeyList.push(obj)
            }
        }
    }
    //标识当前页
    function identifn(){
        angular.forEach($scope.numberKeyList,function(d,index){
            if($scope.numberKeyList[index].nmb==$scope.page){
                $scope.numberKeyList[index].isColor=true;
            }else{
                $scope.numberKeyList[index].isColor=false;
            }
        })
        if($scope.PageCount==1||$scope.PageCount==0){

            $scope.disabledArr=[true,true,true,true]
        }else{
            if($scope.page==1){
                $scope.disabledArr=[true,true,false,false]
            }else if($scope.page==$scope.PageCount){
                $scope.disabledArr=[false,false,true,true]
            }else{
                $scope.disabledArr=[false,false,false,false]
            }
        }
    }
    //点击重新生成翻页的变化
    function regenerate(){

        if($scope.index==0&&$scope.page-10>1){
            initFn($scope.page)
        }else if($scope.index==0&&$scope.page-10<=1){
            if($scope.PageCount<10){
                initFn($scope.PageCount)
            }else{
                initFn(10)
            }
        }else if($scope.index==9&&$scope.page+10<$scope.PageCount){
            initFn($scope.page+8)
        }else if($scope.index==9&&$scope.page+10>=$scope.PageCount){
            initFn($scope.PageCount)
        }
        identifn();
        console.log($scope.index)
    }
    //点击数字页
    $scope.tapNmbKey=function(page,index){
        $scope.page=page;
        $scope.index=index;
        regenerate();
        list($scope.page)
        $scope.go="";
    }
    //点击首页
    $scope.homeKey=function(){
        $scope.go="";
        $scope.page=1;
        $scope.index=0;
        regenerate();
        list($scope.page)
    };
    //点击上一页
    $scope.prevKey=function(){

        $scope.go="";
        if ($scope.index == 9) {
            $scope.index = 0;
            $scope.page--;
        } else {
            if($scope.index>0){
                $scope.index--
                $scope.page--;
            }else{
                $scope.index=9
                $scope.page--;
                $scope.index--
            }

        }
        list($scope.page);
        regenerate()
    };
    //点击下一页
    $scope.nextKey=function(){
        $scope.go="";

        if ($scope.index == 0) {
            $scope.index = 9;
            $scope.page++
        } else if($scope.index<9){
            $scope.page++;
            $scope.index++
        }else{
            $scope.index=0
            $scope.page++;
            $scope.index++;
        }




        // if($scope.index<9){
        //     $scope.page++;
        //     $scope.index++;
        // }
        // else if($scope.index == 0)
        // {
        //     $scope.index = 9;
        //     //$scope.page++;
        //     //$scope.index++;
        // }
        // else{
        //     $scope.index=0;
        //     $scope.page++;
        //     $scope.index++;
        // }

        //if ($scope.index == 0) {
        //    $scope.index = 9;
        //} else {
        //    if($scope.index<9){
        //        $scope.page++;
        //        $scope.index++
        //    }else{
        //        $scope.index=0
        //        $scope.page++;
        //        $scope.index++;
        //    }
        //}
        list($scope.page);

        regenerate()


        console.log($scope.index)
    };
    //点击尾页
    $scope.ShadoweKey=function(){
        $scope.go="";
        $scope.page=$scope.PageCount;
        $scope.index=9
        list($scope.page);
        regenerate()
    };
    $scope.jump=function(nmb){
        if(nmb>=1&&nmb<=$scope.PageCount){
            $scope.page=nmb;
            if(nmb>10){
                $scope.index=9
            }else{
                $scope.index=nmb-1
            }
            list($scope.page);
            regenerate()
        }else{
            $rootScope.alertPart("请输入有效页码");
            $scope.go=""
        }

    };

    /*确定按钮操作*/
    $rootScope.hideAlert=function(){
        $("#mask").hide();
        $("#alertlog").hide();
        if($scope.alertlog=="操作成功"){
            $('#audit-data').modal({backdrop: 'static', keyboard: false});
            $("#audit-data").modal("hide");
            list($scope.page);
        }
        if($scope.alertlog=="禁用成功")
        {
            $('#forbidden-data').modal({backdrop: 'static', keyboard: false});
            $("#forbidden-data").modal("hide");
            $scope.jinyins='';
            $scope.jinshuo="";
            $scope.forbDataForm.forbCause.$setUntouched();
            list($scope.page);
        }
        if($scope.alertlog=="启用成功")
        {
            $('#enable-data').modal({backdrop: 'static', keyboard: false});
            $("#enable-data").modal("hide");
            $scope.qiyins="";
            $scope.qishuo="";
            $scope.enabDataForm.cause.$setUntouched();
            list($scope.page);
        }
        if($scope.alertlog=="删除成功")
        {
            $('#delete-data').modal({backdrop: 'static', keyboard: false});
            $("#delete-data").modal("hide");
            $scope.delyins="";
            $scope.delshuo="";
            $scope.delDataForm.cause.$setUntouched();
            list($scope.page);
        }
    }


    /*列表 产品分类 三级联动*/

    $scope.getType1=function()
    {
        var Oran=$resource('/product/getpruducttypes');
        Oran.get(function (res) {
            console.log(res)
            $scope.Type1List=res.productEnumModels;
        },function (err) {
            console.log("查询失败！")
        });
    }
    $scope.getType1();
    $scope.getType2=function()
    {
        var Oran=$resource('/product/getpruducttypes?typeCode='+$scope.prolist.proTypes);
        Oran.get(function (res) {
            $scope.Type2List=res.productEnumModels;
        },function (err) {
            console.log("查询失败！")
        });
    }
    $scope.getType3=function()
    {
        var Oran=$resource('/product/getpruducttypes?typeCode='+$scope.prolist.proTypest);
        Oran.get(function (res) {
            $scope.Type3List=res.productEnumModels;
        },function (err) {
            console.log("查询失败！")
        });
    }



    /*查询*/
    $scope.lookup=function()
    {
        $scope.go='';
        list(1);
    }


    //点击重置
    $scope.reset=function()
    {
        $scope.go='';
        $scope.prolist = {
            proTypes: "",
            proTypest: "",
            proTypesg:"",
            proState:"",
            proName:"",
            pageSize:15
        }
        list(1);
    };


     var bizid;
    /*查看，审核点击弹出模态框*/
    $scope.chakan=function(id,targetId,idx)
    {
        $scope.currentIdx=idx
        $scope.activeTr=true;
        $scope.shuju(id);
        $scope.qujian=false;
        $scope.getQishu()
        $scope.shenremarks="";
        bizid=id;
        if(targetId=='view-data')
        {
            $('#view-data').modal({backdrop: 'static', keyboard: false});
            $("#view-data").modal("show");
            $('#viewTreeview').hide();
            var viewTreeview_options = {
                bootstrap2: false,
                levels: 5,
                onNodeChecked:nodeChecked ,
                onNodeUnchecked:nodeUnchecked,
                checkedIcon: "glyphicon glyphicon-check",
                data: buildDomTree('viewTreeview')
            };
            $('#viewTreeview').treeview(viewTreeview_options);

        }
        if(targetId=='audit-data')
        {
            $('#audit-data').modal({backdrop: 'static', keyboard: false});
            $("#audit-data").modal("show");
            $('#auditTreeview').hide()
            $scope.opinionChange=false;
            $scope.shenremarks="";
            $scope.auditDateForm.$setUntouched()
            $scope.auditDateForm.$setPristine();
            var auditTreeview_options = {
                bootstrap2: false,
                levels: 5,
                onNodeChecked:nodeChecked ,
                onNodeUnchecked:nodeUnchecked,
                checkedIcon: "glyphicon glyphicon-check",
                data: buildDomTree('auditTreeview')
            };
            $('#auditTreeview').treeview(auditTreeview_options);
        }

    }

    var editBizid;
    var productCode;
    $scope.pstListLength;
    function initEditModal() {
        $scope.editCommissions='select';
        $scope.editPositions='select';
        $scope.editInterestsTips=false;
        $scope.editComChange1=false;
        $scope.editComChange2=false;
        $scope.editComChange3=false;
        $scope.editMoneyresourcesTips=false;
        $scope.editLoantypesTips=false;
        $scope.editDanliangMax1=''
        $scope.editPositions='select';
        $scope.editCommissions='select';
        $scope.editNormalVal=''
        $scope.editDanliangMax='';
        // $scope.danliangMax=''
        $scope.editVal='';
    }
    /*数据*/
    $scope.shuju=function(id)
    {
        $.ajax({
            type:"GET",
            url:'/product/'+id+'/showproduct',
            async: false,
            success:function (res) {
                    if(res.success&&res.executed){
                        $scope.lookres=res;
                        console.log($scope.lookres);
                        editBizid=id;
                        productCode=res.productInfoDTO.productCode
                        $scope.supportList=$scope.lookres.supportTimeInfos; /*支持期数*/
                        $scope.commissionList=$scope.lookres.commissionConfigInfos; /*提成方案*/

                        $scope.repaymentList=$scope.lookres.repaymentInfoDTO; /*利率配置*/
                        if ($scope.editModal){//编辑产品时
                            $scope.commissionTypeList=[];
                            $scope.editStoreTree=[];//业务范围树
                            $scope.editStoreTree.push(res.storeConfigInfo);
                            initEditModal()
                            eiditLilvList();
                            if($scope.lookres.productInfoDTO.isEnabledLadder.name=='YES'){//如果是阶梯给最小值赋默认值
                                $scope.editDanliangMin1=$scope.commissionList[$scope.commissionList.length-1].upperLimit+1;
                            }
                            console.log($scope.commissionTypeList)
                            $scope.editCommissionList=[];
                            editComList();
                            $scope.editSupportList=[];
                            editSupportListFn();
                            $scope.addGetType2($scope.lookres.productInfoDTO.level1Code);
                            $scope.addGetType3($scope.lookres.productInfoDTO.level2Code);
                        }
                        $scope.isEnab=$scope.lookres.productInfoDTO.isEnabledLadder.displayName;
                        if($scope.isEnab=='否')
                        {
                            $scope.yincang=false;
                            $scope.myToggle="NO";
                        }
                        else
                        {
                            $scope.yincang=true;
                            $scope.myToggle="YES";
                        }
                    }else {
                        console.log(res)
                    }
                },
            error:function (err) {
                console.log("查询失败！")
            }


        })


    }

    $scope.showAddPro=function () {
        $('#addTreeview').hide()
        $("#add-data").modal("show");
        $scope.myToggle='YES';
        initLilv();
        $scope.clearAddForm();
        var addTreeview_options = {
            bootstrap2: false,
            levels: 5,
            showCheckbox: true,
            onNodeChecked:nodeChecked ,
            onNodeUnchecked:nodeUnchecked,
            checkedIcon: "glyphicon glyphicon-check",
            data: buildDomTree('addTreeview')
        };
        $('#addTreeview').treeview(addTreeview_options);
        $('#addTreeview').treeview('collapseAll', { silent: true });

    }
    /*审核按钮*/
    $scope.prtn=function(status)
    {
        if(!$scope.shenremarks){
            $scope.opinionChange=true;
            return
        }
        $scope.requestDTO = {
            "proState":status ,
            "stateRemarks":$scope.shenremarks
        }
        $http({
            method: 'PUT',
            url: '/product/'+bizid+'/checkproduct',
            data:$scope.requestDTO
        }).then(function(msg) {
            if(msg.data.success&&msg.data.executed){
                $rootScope.alertPart("操作成功");
            }else {
                $rootScope.alertPart("操作失败！");
                console.log(msg)
            }
        }, function() {
            $rootScope.alertPart("操作失败，请稍后重试！");
            console.log("操作失败，请稍后重试");
        });
    }





    /*禁用*/
    $scope.disables=function(id,idx)
    {
        $scope.currentIdx=idx
        bizid=id;
        $('#forbidden-data').modal({backdrop: 'static', keyboard: false});
        $("#forbidden-data").modal("show");
        $scope.jinyuanyi();
        $scope.forbDataForm.$setUntouched()
        $scope.forbDataForm.$setPristine();
        $scope.jinyinsChange=false;
        $scope.jinshuo="";
    }

    /*禁用原因接口*/
    $scope.jinyuanyi=function()
    {
        var Oran=$resource('/product/getunabletypes');
        Oran.get(function (res) {
            console.log(res)
            $scope.unabledsJ=res.list;
            console.log($scope.unabledsJ)
        }, function (err) {
            console.log("查询失败！")
        });
    }
    /*点击确定*/
    $scope.jinsure=function()
    {
        if(!$scope.jinyins){
            $scope.jinyinsChange=true;
            return;
        }
        var data={
        "dataName":$scope.jinyins,
        "stateRemarks":$scope.jinshuo
       }
        $http({
            method: 'PUT',
            url: '/product/'+bizid+'/unableproduct',
            data:data
        }).then(function(msg) {
            console.log(msg)
            if(msg.data.success&&msg.data.executed){
                $rootScope.alertPart("禁用成功");
            }else {
                $rootScope.alertPart("禁用失败");
                console.log(msg)
            }
        }, function() {
           console.log("禁用失败，请稍后重试");
            $rootScope.alertPart("禁用失败，请稍后重试！");
        });
    }

    /*启用*/
    $scope.enablest=function(id,idx)
    {
        $scope.currentIdx=idx
        bizid=id;
        $scope.qiyins="";
        $scope.qishuo="";
        $scope.qiyinsChange=false;
        $scope.enabDataForm.cause.$setUntouched();
        $scope.enabDataForm.cause.$setPristine();
        $('#enable-data').modal({backdrop: 'static', keyboard: false});
        $("#enable-data").modal("show");
        $scope.qiyuanyi();
    }


    /*启用原因*/
   /*原因，说明*/
    $scope.qiyuanyi=function()
    {
        var Oran=$resource('/product/getenabletypes');
        Oran.get(function (res) {
            $scope.enableList=res.list;
        }, function (err) {
            console.log("查询失败！")
        });
    }
    /*点击确定*/
    $scope.qisure=function()
    {
        if(!$scope.qiyins){
            $scope.qiyinsChange=true;
            return
        }else {
        $scope.requestDTO={
            "dataName":$scope.qiyins,
            "stateRemarks":$scope.qishuo
        }
        $http({
            method: 'PUT',
            url: '/product/'+bizid+'/enableproduct',
            data:$scope.requestDTO
        }).then(function(msg) {
            if(msg.data.success&&msg.data.executed){
                $rootScope.alertPart("启用成功");
            }else {
                console.log(msg)
                $rootScope.alertPart("启用失败");
            }

        }, function() {
            console.log("启用失败，请稍后重试");
            $rootScope.alertPart("启用失败，请稍后重试");
        });
        }
    }
    /*删除*/
    $scope.deleteest=function(id)
    {
        bizid=id;
        $scope.delyins="";
        $scope.delshuo="";
        $scope.delDataForm.cause.$setUntouched();
        $scope.delDataForm.cause.$setPristine();
        $scope.delyinsChange=false;
        $('#delete-data').modal({backdrop: 'static', keyboard: false});
        $("#delete-data").modal("show");
        $scope.delyuanyi();
    }


    /*删除原因*/
    $scope.delyuanyi=function()
    {
        var Oran=$resource('/product/getdeletedtypes');
        Oran.get(function (res) {
            console.log(res)
            $scope.delList=res.list;
        }, function (err) {
            console.log("查询失败！")
        });
    }
    /*点击确定*/
    $scope.delsure=function()
    {
        if(!$scope.delyins){
            $scope.delyinsChange=true;
            return;
        }else {
        $.ajax({
            async: false,
            url: '/product/'+bizid+'/deleteproduct',
            type: 'DELETE',
            //cache:false,
            dataType: "JSON",
            data:JSON.stringify({
                "dataValue": $scope.delyins,
                "stateRemarks": $scope.delshuo
            }),
            contentType:'application/json;charset=UTF-8',
            headers:{
                speciLan:'ch',
                devicetype:'web',
                userKey:123456
            },
            success: function(res) {
                if(res.executed&&res.success){
                    $rootScope.alertPart("删除成功");
                }else {
                    console.log(res);
                }
            },
            error:function () {
                console.log("删除失败！");
            }
        });
        }
    }







/*    create by duixintong*/
    $scope.clearAddForm=function (){
        empty()
        initLilv()
        $scope.proNameChange=false;
        $scope.addInterestsTips=false;
        $scope.addMoneyresourcesTips=false;
        $scope.addLoantypesTips=false;
        $scope.addSupportValPaichong=false;
        $scope.addProForm.addCommission.$error.max=false;
        $scope.addProForm.addCommission.$error.min=false;
        $scope.myToggle='YES';
        $scope.commissionListNull=false;
        $scope.lilvListNull=false;
        $scope.stroeTreeChange=false;
        $scope.commissionList=[];
        $scope.packageCode=[];
        $scope.repaymentList=[];
        $scope.supportList=[];
        $scope.addProForm.$setUntouched()
        $scope.addProForm.$setPristine();
        $scope.addComChange3=false;
        $scope.addLilvError=false;
        $scope.addProlist.proTypes='';
    }
    $scope.clearEditForm=function (){
        //清空利率添加
        editInitLilv()

        $scope.editSupportVal1=false;//请添加支持期数
        $scope.editSupportValPaichong=false;//支持期数重复
        $scope.editProForm.$setUntouched();
        $scope.editProForm.$setPristine();
        $scope.commissionList=[];
        $scope.repaymentList=[];
        $scope.supportList=[];
        $scope.packageCode=[];
        $scope.editModal=false;
    }
    /*新建*/
    var select={"value": 0,
        "name": "select",
        "displayName": "-请选择-"};
    $scope.getQishu=function () {
        $.ajax({
            async: false,
            url: '/product/getuienums',
            type: 'GET',
            cache:false,
            dataType: "JSON",
            success: function(res){
                if(res.success&&res.executed){
                    /*期数接口*/
                    res.supportTimes.unshift(select);
                    $scope.qishuList=res.supportTimes;
                    $scope.addSupport=$scope.qishuList[0].name;
                    /*职位接口*/
                    res.positions.unshift(select);
                    $scope.positionsList=res.positions;
                    $scope.addPositions=$scope.positionsList[0].name;
                    /*提成方式接口*/
                    res.commissions.unshift(select);
                    $scope.commissionsList=res.commissions;
                    $scope.addCommissions=$scope.commissionsList[0].name;
                    /*计息方式接口*/
                    res.interests.unshift(select);
                    $scope.interestsList=res.interests;
                    $scope.addInterests=$scope.commissionsList[0].name;
                    /*资金渠道接口*/
                    res.moneyresources.unshift(select);
                    $scope.moneyresourcesList=res.moneyresources;
                    $scope.addMoneyresources=$scope.moneyresourcesList[0].name;
                    /*放款至接口*/
                    res.loantypes.unshift(select);
                    $scope.loantypesList=res.loantypes;
                    $scope.addLoantypes=$scope.loantypesList[0].name;
                }else {
                    console.log(res)
                }
            },
            error:function () {
                console.log("接口请求失败！")
            }
        })
    };
    // 获取产品状态枚举
    $scope.getProState=function () {
        $.ajax({
            async: false,
            url: '/product/getuienums',
            type: 'GET',
            cache:false,
            dataType: "JSON",
            success: function(res){
                console.log(res)
                if(res.success&&res.executed){
                    /*产品状态*/
                    angular.forEach(res.productStates,function (item,idx) {
                        if(item.value==6){
                            res.productStates.splice(idx,1);//删除‘已删除’状态
                        }
                    })
                    $scope.proStates=res.productStates;

                }else {
                    console.log(res)
                }
            },
            error:function () {
                console.log("接口请求失败！")
            }
        })
    };
    $scope.getProState()
    /*利率接口*/
    $scope.getLilvProject=function () {
        $.ajax({
            async: false,
            url: '/product/getrepaymentkeysenums',
            type: 'GET',
            cache:false,
            dataType: "JSON",
            success: function(res) {
                if(res.success&&res.executed){
                    $scope.projectList=res.repaymentKeys;
                }else {
                    console.log(res)
                }
            },
            error:function () {
                console.log("接口请求失败！")
            }
        })
    };
    $scope.getLilvProject()

    /*利率类型接口*/
    $scope.getLilvType=function (lilv1) {
        var json1=JSON.parse(lilv1)
        var data={
            'name': json1.name,
            'type':'',
            'paytimeType':''
        };
        $.ajax({
            async: false,
            url: '/product/getrepaymentkeysenums',
            type: 'GET',
            cache:false,
            data: data,
            contentType:'application/json;charset=UTF-8',
            success: function(res) {
                if(res.success&&res.executed){
                    $scope.typeList=res.repaymentKeys;
                    if($scope.editModal){
                        $scope.editLilv2='';
                        $scope.editLilv3='';
                        $scope.editLilv4='';
                        $scope.editNecessary='';
                        $scope.editProForm.lilv2.$setPristine()
                        $scope.editProForm.lilv3.$setPristine()
                        $scope.editProForm.lilv4.$setPristine()
                    }else {
                        $scope.lilv2='';
                        $scope.lilv3='';
                        $scope.lilv4='';
                        $scope.addProForm.lilv2.$setPristine()
                        $scope.addProForm.lilv3.$setPristine()
                        $scope.addProForm.lilv4.$setPristine()
                        $scope.necessary='';
                    }
                }else {
                    console.log(res)
                }
            },
            error:function () {
                console.log("获取利率包失败")
            }
        })
    };

    /*利率付款日期类型接口*/
    $scope.getLilvPaytime=function (lilv1,lilv2) {
        var json1=JSON.parse(lilv1)
        var json2=JSON.parse(lilv2)
        var data={
            'name': json1.name,
            'type':json2.name,
            'paytimeType':''
        };
        $.ajax({
            async: false,
            url: '/product/getrepaymentkeysenums',
            type: 'GET',
            cache:false,
            data: data,
            contentType:'application/json;charset=UTF-8',
            success: function(res) {
                if(res.success&&res.executed) {
                    $scope.paytimeList = res.repaymentKeys;
                    if($scope.editModal){
                        $scope.editLilv3='';
                        $scope.editLilv4='';
                        $scope.editNecessary='';
                        $scope.editProForm.lilv3.$setPristine()
                        $scope.editProForm.lilv4.$setPristine()
                    }else {
                        $scope.lilv3='';
                        $scope.lilv4='';
                        $scope.addProForm.lilv3.$setPristine()
                        $scope.addProForm.lilv4.$setPristine()
                        $scope.necessary='';
                    }
                }else {
                    console.log(res)
                }
            },
            error:function () {
                console.log("获取利率包接口请求失败！")
            }
        })
    };

    $scope.getLilvPayval=function (lilv1,lilv2,lilv3) {
        var json1=JSON.parse(lilv1);
        var json2=JSON.parse(lilv2);
        var json3=JSON.parse(lilv3);
        var data={
            'name': json1.name,
            'type':json2.name,
            'paytimeType':json3.name
        };
        $.ajax({
            async: false,
            url: '/product/getrepaymentkeysenums',
            type: 'GET',
            cache:false,
            data: data,
            contentType:'application/json;charset=UTF-8',
            success: function(res) {
                if(res.success&&res.executed) {
                    $scope.payvalList = res.repaymentKeys;
                    if($scope.editModal){
                        $scope.editLilv4='';
                        $scope.editNecessary='';
                        $scope.editProForm.lilv4.$setPristine()
                    }else {
                        $scope.lilv4='';
                        $scope.addProForm.lilv4.$setPristine()
                        $scope.necessary='';
                    }
                }else {
                    console.log(res)
                }
            },
            error:function () {
                console.log("获取利率包失败")
            }
        })
    };
    $scope.packageCode=[];
    var pkgObj;
    var editPkgCode
    // 获取利率值
    $scope.llPayvalFnc=function (package) {
        var PayvalJson=JSON.parse(package);
        pkgObj={packageCode:PayvalJson.packageCode}
        editPkgCode=PayvalJson.packageCode;
        if($scope.editModal){
           $scope.editNecessary= PayvalJson.isChoice.name
        }else {
            $scope.necessary=PayvalJson.isChoice.name
        }
    };
    $scope.repaymentList=[];
    /*利率配置--添加*/
    $scope.addLilv=function (lilv1,lilv2,lilv3,lilv4,necessary) {
        var add=true;
        if(lilv1&&lilv2&&lilv3&&lilv4){

            var PayvalJson1=JSON.parse(lilv1);
            var PayvalJson2=JSON.parse(lilv2);
            var PayvalJson3=JSON.parse(lilv3);
            var PayvalJson4=JSON.parse(lilv4);
            if($scope.repaymentList.length>0){
                if(PayvalJson3.displayName==$scope.repaymentList[0].paytimeType.displayName){
                    add=true;
                }else {
                    add=false;
                }
            }else {
                add=true;
            }

            if(add){
                var obj={
                    name:PayvalJson1.displayName,
                    type:{
                        displayName:PayvalJson2.displayName
                    },
                    paytimeType:{
                        displayName:PayvalJson3.displayName
                    },
                    value:PayvalJson4.name,
                    isChoice:{
                        name:necessary
                    },
                    packageCode:editPkgCode
                };
                $scope.repaymentList.push(obj);
                $scope.packageCode.push(pkgObj)
                if($scope.editModal){
                    editInitLilv()
                }else {
                    initLilv()
                }
            }else {
                $scope.addLilvError=true;
                if($scope.editModal){
                    $scope.editLilv3Changes=true;
                }else {
                    $scope.lilv3Changes=true;
                }
            }

        }else {//数据验证
            if($scope.editModal){
                if(!lilv1){
                    $scope.editLilv1Change=true;
                }
                if(!lilv2){
                    $scope.editLilv2Change=true;
                }
                if(!lilv3){
                    $scope.editLilv3Change=true;
                }
                if(!lilv4){
                    $scope.editLilv4Change=true;
                }
            }else {
                if(!lilv1){
                    $scope.lilv1Change=true;
                }
                if(!lilv2){
                    $scope.lilv2Change=true;
                }
                if(!lilv3){
                    $scope.lilv3Change=true;
                }
                if(!lilv4){
                    $scope.lilv4Change=true;
                }
            }
        }
        console.log($scope.repaymentList);
        console.log($scope.packageCode);


    };
    /*利率配置--删除*/
    $scope.removeLilv=function (index) {
        console.log($scope.packageCode)
        $scope.repaymentList.splice(index,1);
        $scope.packageCode.splice(index,1);
        console.log($scope.repaymentList);
        console.log($scope.packageCode);
        $scope.editLilv3Changes=false;
        $scope.lilv3Changes=false;
    }

    // 添加产品-利率配置初始化
    function initLilv(){
        $scope.lilv1='';
        $scope.lilv2='';
        $scope.lilv3='';
        $scope.lilv4='';
        $scope.necessary='';
        $scope.lilv1Change=false;
        $scope.lilv2Change=false;
        $scope.lilv3Change=false;
        $scope.lilv3Changes=false;
        $scope.lilv4Change=false;
        $scope.addLilvError=false;
    }
    // 编辑产品-利率配置初始化
    function editInitLilv() {
        $scope.editLilv1='';
        $scope.editLilv2='';
        $scope.editLilv3='';
        $scope.editLilv4='';
        $scope.editNecessary='';
        $scope.editLilv1Change=false;
        $scope.editLilv2Change=false;
        $scope.editLilv3Change=false;
        $scope.editLilv3Changes=false;
        $scope.editLilv4Change=false;
        $scope.addLilvError=false;
    }


    /*下拉菜单树*/
    var dataTree
    function buildDomTree(str) {
        dataTree = [];
        function walk(nodes, data) {
            if (!nodes) {
                return;
            }
            $.each(nodes, function (id, node) {
                var obj = {
                    id: node.id,
                    text: node.name,
                    tags: [node.nodes.length > 0 ? node.nodes.length + ' child elements' : ''],
                    state: {
                        checked: str=='editTreeview'?node.checked:true,
                        expanded: true,
                        selected: true
                    },
                    type:str
                };
                if (node.nodes.length > 0) {
                    obj.nodes = [];
                    walk(node.nodes, obj.nodes);
                }
                data.push(obj);
            });
        }
        var myJson=[]
        if(str==='addTreeview'){
            $.ajax({
                type:"GET",
                url:"/product/getstoreconfigtree",
                async:false,
                contentType:'application/json;charset=UTF-8',
                success:function (res) {
                    if(res.success&&res.executed){
                        console.log(res.data)
                        myJson.push(res.data)
                        walk(myJson,dataTree);
                    }else {
                        console.log(res);
                    }
                },
                error:function () {
                    console.log("接口请求失败！")
                }
            })
        }else if(str==='editTreeview'){
            myJson.push($scope.lookres.storeConfigInfo)
            walk(myJson,dataTree);
        }else{
            if($scope.lookres.storeConfigInfoChecked){
                myJson.push($scope.lookres.storeConfigInfoChecked)
                walk(myJson,dataTree);
            }else {
                return
            }

        }

        return dataTree;
    }
    /*下拉菜单树配置*/

        var nodeCheckedSilent = false;
        function nodeChecked (event, node){

            if(nodeCheckedSilent){
                return;
            }
            nodeCheckedSilent = true;
            checkAllParent(node);
            checkAllSon(node);
            nodeCheckedSilent = false;

        }

        var nodeUncheckedSilent = false;
        function nodeUnchecked  (event, node){
            if(nodeUncheckedSilent)
                return;
            nodeUncheckedSilent = true;
            uncheckAllParent(node);
            uncheckAllSon(node);
            nodeUncheckedSilent = false;
        }
//选中全部父节点
        function checkAllParent(node) {
            $('#'+node.type).treeview('checkNode', node.nodeId, {silent: true});
            node.state.checked=true;
            var parentNode = $('#'+node.type).treeview('getParent', node.nodeId);
            if (!("nodeId" in parentNode)) {
                return;
            } else {
                checkAllParent(parentNode);
            }
        }
//取消全部父节点
        function uncheckAllParent(node){
            $('#'+node.type).treeview('uncheckNode',node.nodeId,{silent:true});
            node.state.checked=false;
            var siblings = $('#'+node.type).treeview('getSiblings', node.nodeId);
            var parentNode = $('#'+node.type).treeview('getParent',node.nodeId);
            if(!("nodeId" in parentNode)) {
                return;
            }
            var isAllUnchecked = true;  //是否全部没选中
            for(var i in siblings){
                if(siblings[i].state.checked){
                    isAllUnchecked=false;
                    break;
                }
            }
            if(isAllUnchecked){
                uncheckAllParent(parentNode);
            }
        }
//级联选中所有子节点
        function checkAllSon(node){
            $('#'+node.type).treeview('checkNode',node.nodeId,{silent:true});
            node.state.checked=true;
            if(node.nodes!=null&&node.nodes.length>0){
                for(var i in node.nodes){
                    checkAllSon(node.nodes[i]);
                }
            }
        }
//级联取消所有子节点
        function uncheckAllSon(node){
            $('#'+node.type).treeview('uncheckNode',node.nodeId,{silent:true});
            node.state.checked=false;
            if(node.nodes!=null&&node.nodes.length>0){
                for(var i in node.nodes){
                    uncheckAllSon(node.nodes[i]);
                }
            }

        }







    $scope.IsNum=function(num) {
        var reNum =/^\d+(\.{0,1}\d+){0,1}$/;
        if (reNum.test(num)&&num!=='') {
            return true;
        } else {
            return false;
        }
    }
    $scope.commissionList=[];
    /*---添加单量区间---*/
    // 数据校验
    $scope.addCommission=function (level,mode,val,min,max,positionsList,myToggle) {
        if($scope.editModal){
            if (level === 'select') {
                $scope.editComChange1 = true
            }
            if (mode === 'select') {
                $scope.editComChange2 = true
            }
            if(!$scope.IsNum(val)){
                $scope.editComChange3=true;
            }
            if(myToggle==='YES'){
                if (!max){
                    $scope.editProForm.maxlength.$pristine=false;
                    $scope.editProForm.maxlength1.$pristine=false;
                }
                if (!min){
                    $scope.editProForm.minlength.$pristine=false;
                }
                //开关添加
                var editReg1=$scope.editProForm.minlength.$valid&&$scope.editProForm.maxlength.$valid&&max>min&&level!='select'&&mode!='select'&&$scope.IsNum(val);
                //阶梯添加
                var editReg2=$scope.editProForm.maxlength1.$valid&&max>min&&level!='select'&&mode!='select'&&$scope.IsNum(val);
                if(editReg1||editReg2){
                    /*插入数据*/
                    addCommissionData(level,mode,val,min,max,positionsList,myToggle);
                    clearEditCommissionForm()
                }
            }else {
                //开关添加
                var editReg3=level!='select'&&mode!='select'&&($scope.editProForm.addCommissionNormal.$modelValue || $scope.editProForm.addCommissionNormal.$modelValue==0)&&$scope.IsNum(val);
                //普通添加
                var editReg4=level!='select'&&mode!='select'&&($scope.editProForm.addCommission.$modelValue || $scope.editProForm.addCommission.$modelValue==0)&&$scope.IsNum(val);
                if(editReg3||editReg4){
                    addCommissionData(level,mode,val,min,max,positionsList,myToggle);
                    clearEditCommissionForm()
                }
            }
        }else {
            $scope.commissionListNull=false
            if (level === 'select') {
                $scope.addProForm.normalPositions.$pristine = false
            }
            if (mode === 'select') {
                $scope.addProForm.normalCommissions.$pristine = false
            }
            if (!$scope.IsNum(val)) {
                $scope.addComChange3=true;
            }
            if (myToggle&&myToggle!='NO'){
                if (!max){
                    $scope.addProForm.maxlength.$pristine=false
                    $scope.addProForm.maxlength1.$pristine=false
                };
                if (!min){
                    $scope.addProForm.minlength.$pristine=false
                };
                //开关添加
                var reg1=$scope.addProForm.minlength.$valid&&$scope.addProForm.maxlength.$valid&&max>min&&level!='select'&&mode!='select'&&($scope.addProForm.addCommission.$modelValue || $scope.addProForm.addCommission.$modelValue==0)&&$scope.IsNum(val)
                //阶梯添加
                var reg2=$scope.addProForm.maxlength1.$valid&&max>min&&level!='select'&&mode!='select'&&($scope.addProForm.addCommission.$modelValue || $scope.addProForm.addCommission.$modelValue==0)&&$scope.IsNum(val);
                if(reg1||reg2){
                    /*插入数据*/
                    addCommissionData(level,mode,val,min,max,positionsList,myToggle);
                    clearAddCommissionForm()
                }
            }else {
                //开关添加
                var reg3=level!='select'&&mode!='select'&&($scope.addProForm.addCommission.$modelValue || $scope.addProForm.addCommission.$modelValue==0)&&$scope.IsNum(val);
                //普通添加
                var reg4=level!='select'&&mode!='select'&&($scope.addProForm.addCommissionNormal.$modelValue || $scope.addProForm.addCommissionNormal.$modelValue==0)&&$scope.IsNum(val);
                if(reg3||reg4){
                    addCommissionData(level,mode,val,min,max,positionsList,myToggle);
                    clearAddCommissionForm()
                }
            }

        }

    };
    // 清空提成方案校验（新建）
    function clearAddCommissionForm() {
        $scope.addDanliangMax1=''
        $scope.addPositions='select';
        $scope.addCommissions='select';
        $scope.addNormalVal=''
        $scope.addDanliangMax='';
        $scope.danliangMax=''
        $scope.addVal='';
        $scope.addProForm.normalPositions.$setPristine()
        $scope.addProForm.normalCommissions.$setPristine()
        $scope.addProForm.addCommission.$setPristine()
        $scope.addProForm.maxlength.$setPristine();
        $scope.addProForm.minlength.$setPristine();
        $scope.addProForm.maxlength1.$setPristine();
        $scope.addProForm.addCommission.$error.max=false;
        $scope.addProForm.addCommission.$error.min=false;
        $scope.addComChange3=false;

        $scope.val=''
    }
    // 清空提成方案校验（编辑）
    function clearEditCommissionForm() {
        $scope.editPositions='select';
        $scope.editCommissions='select';
        $scope.editNormalVal=''
        $scope.editDanliangMax='';
        $scope.editDanliangMin='';
        $scope.editVal='';
        $scope.editProForm.normalPositions.$setPristine()
        $scope.editProForm.normalCommissions.$setPristine()
        $scope.editProForm.addCommission.$setPristine()
        $scope.editProForm.maxlength.$setPristine();
        $scope.editProForm.minlength.$setPristine();
        $scope.editProForm.maxlength1.$setPristine();
        $scope.editProForm.addCommission.$error.max=false;
        $scope.editProForm.addCommission.$error.min=false;
    }

    // 添加提成方案
    $scope.commissionTypeList=[];//判断金额提成相加不大于1--大数组
    function addCommissionData(level,mode,val,min,max,positionsList,myToggle) {
        $scope.typeList=[]//判断金额提成相加不大于1--小数组
        if(myToggle && myToggle!='NO'){//阶梯方案
            if ($scope.editModal){ //编辑
                for(var i=1;i<positionsList.length;i++){
                    var pstObj1={lowerLimit:min,upperLimit:max,position:positionsList[i].name,commissionType:mode,commission:val};
                    $scope.typeList.push(pstObj1)
                    $scope.editCommissionList.push(pstObj1);
                    $scope.commissionList.push(pstObj1);
                }
                $scope.commissionTypeList.push($scope.typeList);
                console.log($scope.commissionTypeList)
                $scope.editDanliangMin1=max+1;
                clearEditCommissionForm()

            }else {//新建
                for(var j=1;j<positionsList.length;j++){
                    var pstObj2={lowerLimit:min,upperLimit:max,position:positionsList[j].name,commissionType:mode,commission:val};
                    $scope.typeList.push(pstObj2)
                    $scope.commissionList.push(pstObj2);
                }
                $scope.commissionTypeList.push($scope.typeList);
                $scope.addDanliangMin=max+1;
            }

        }else {  //非阶梯方案
            console.log($scope.editCommissionList)
            console.log($scope.commissionList)
            var sum=0;
            angular.forEach($scope.commissionList,function (item) {
                if(item.position==level){
                    sum+=1;
                }else {
                    sum+=0;
                }
            });

            if(!sum){
                var obj={position:level,commissionType:mode,commission:val};
                if($scope.editModal){
                    $scope.editCommissionList.push(obj);
                    clearEditCommissionForm()
                }
                $scope.commissionList.push(obj);
            }else {
                $rootScope.alertPart("您添加的提成方案已存在，请检查！")
            }
        }
        clearAddCommissionForm()
        console.log($scope.editCommissionList)
        console.log($scope.commissionList)
    }

    /*---删除单量区间---*/
    $scope.removeCommission=function (index,myToggle,positionsList) {
        /*删除数据*/
        if(myToggle&&myToggle!='NO'){//阶梯删除
            debugger
            if($scope.commissionList.length>=positionsList.length-1){
                $scope.addDanliangMin=$scope.commissionList[0].upperLimit+1;
            }
            if ($scope.editModal){
                $scope.editCommissionList.splice(index,positionsList.length-1);
                $scope.commissionTypeList.splice(index,1)
                if ($scope.editCommissionList.length==0){
                    clearEditCommissionForm()
                }
            }
            $scope.commissionList.splice(index,positionsList.length-1);
        }else {//非阶梯删除
            $scope.commissionList.splice(index,1);
            if ($scope.editModal){
                $scope.editCommissionList.splice(index, 1);
                if ($scope.editCommissionList.length==0){
                   clearEditCommissionForm()
                }
                console.log($scope.editCommissionList)
                clearEditCommissionForm()
            }
        }
        console.log($scope.commissionList)
        console.log($scope.commissionTypeList)
        if ( $scope.commissionList.length==0){
            $scope.myToggle="YES"
        }
        clearAddCommissionForm()

    }

    function empty() {
        $scope.val='';

        $scope.danliangMax='';
        $scope.supportVal='';
        $scope.addPositions='select';
        $scope.addCommissions='select';
        $scope.addSupport='select';
        $scope.addInterests='select';
        $scope.addMoneyresources='select';
        $scope.addLoantypes='select';

        $scope.addProlist = {
            proTypes: "",
            proTypest: "",
            proTypesg:"",

        }
        $scope.productName='';
        $scope.addSupportVal=false;
    }
    empty();


    function paichong(arr,curtVal) {
        var breakAdd=false;
        angular.forEach(arr,function (obj) {
            console.log(arr)
            console.log(curtVal)
            if(curtVal==obj.payTime){

                breakAdd=true
            }
        })
        return breakAdd;
    }
    /*支持期数*/

    $scope.supportList=[];
    $scope.addSupportDate=function (mySupport,supportVal) {
        var obj={
            paytimeUnit:mySupport,
            payTime:supportVal
        }
        if($scope.editModal){
            if(mySupport=='select'){
                $scope.editProForm.addSupprot.$pristine=false;
            }
            if(!supportVal){
                $scope.editProForm.addSupportVal.$pristine=false;
            }
            if(paichong( $scope.editSupportList,supportVal)){
                $scope.editSupportValPaichong=true
            }
            if(mySupport!='select'&&supportVal&&!paichong( $scope.editSupportList,supportVal)) {
                $scope.editSupportList.push(obj);
                $scope.editProForm.addSupportVal.$setPristine();
                $scope.editProForm.addSupprot.$setPristine();
                $scope.editSupportVal1=false;
                $scope.editSupportVal=''
            }
        }else {
            if(mySupport=='select'){
                $scope.addProForm.addSupprot.$pristine=false;
            }
            if(!supportVal){
                $scope.addProForm.addSupportVal.$pristine=false;
            }
            if(paichong( $scope.supportList,supportVal)){
                $scope.addSupportValPaichong=true
            }
            if(mySupport!='select'&&supportVal&&!paichong( $scope.supportList,supportVal)){
                $scope.supportList.push(obj);
                this.supportVal='';
                $scope.addSupportVal=false;
                $scope.addProForm.addSupportVal.$setPristine();
                $scope.addProForm.addSupprot.$setPristine();
            }
        }
    }
    $scope.removeSupport=function (index) {
        if($scope.editModal){
            $scope.editSupportList.splice(index,1);
            if($scope.editSupportList.length==0){
                $scope.mySupport='select';
            }
        }else {
            $scope.supportList.splice(index,1);
            if($scope.supportList.length==0){
                $scope.addSupport='select'
            }
        }
    }
    /*----添加产品接口----*/
    $scope.addProduct=function () {
        clearAddCommissionForm();
        $('#addTreeview').hide()
       var storeTree=[];
       angular.forEach($('#addTreeview').treeview('getSelected'),function (obj) {
           if(obj.state.checked){
               var objj={"storeCode":obj.id}
               storeTree.push(objj);
           }
       })

        if(storeTree.length==0){
           $scope.stroeTreeChange=true;
        }

        var typeWrong;
        if($scope.myToggle=='YES'){ //阶梯判断金额提成相加不大于1
            angular.forEach($scope.commissionTypeList,function (obj) {
                var sum=0
                angular.forEach(obj,function (subObj) {
                    if(subObj.commissionType=='CASH'){
                        sum+=subObj.commission;
                    }
                })
                if(sum>100){
                    $rootScope.alertPart("金额提成相加不能大于100%，请检查！");
                    typeWrong=false;
                    return;
                }else {
                    typeWrong=true;
                }
            })
        }else {//非阶梯判断金额提成相加不大于1
            var sum2=0
            angular.forEach($scope.commissionList,function (obj) {
                if(obj.commissionType=='CASH'){
                    sum2+=obj.commission;
                }
            });
            if(sum2>100){
                $rootScope.alertPart("金额提成相加不能大于100%，请检查！");
                typeWrong=false;
                return;
            }else {
                typeWrong=true;
            }
        }

        if($scope.supportList.length==0){
            $scope.addSupportVal=true;
        }
        if($scope.repaymentList.length==0){
            $scope.lilvListNull=true;
        }
        if ($scope.commissionList.length==0){
            $scope.commissionListNull=true;
        }

        if(!$scope.productName){
            $scope.proNameChange=true;

        }
        if($scope.addInterests=='select'){
            $scope.addInterestsTips=true

        }
        if($scope.addMoneyresources=='select'){
            $scope.addMoneyresourcesTips=true;

        }
        if($scope.addLoantypes=='select'){
            $scope.addLoantypesTips=true;
        }
        var reg1=storeTree.length>0&&$scope.supportList.length>0&&$scope.repaymentList.length>0&&$scope.commissionList.length>0&&$scope.productName&&$scope.addInterests!='select'&&$scope.addMoneyresources!='select'&&$scope.addLoantypes!='select'&&typeWrong;
        var reg2;
        if($scope.myToggle=='YES'){
            for(var i=0;i<$scope.commissionList.length;i++){
                if(($scope.commissionList[i].commission||$scope.commissionList[i].commission===0)&&$scope.commissionList[i].commissionType!='select'){
                    reg2=true;
                }else {
                    reg2=false;
                    return;
                }
            }
        }else {
            reg2=true;
        }

        if(reg1&&reg2) {
            var data={
                "commissionConfigInfos": $scope.commissionList,
                "productInfoDTO": {
                    "bizid": "string",
                    "interestType": $scope.addInterests,
                    "isEnabledLadder": $scope.myToggle,
                    "isSupportAssend": $scope.isSupportAssend,
                    "level1Code": $scope.addProlist.proTypes,
                    "level2Code": $scope.addProlist.proTypest,
                    "level3Code": $scope.addProlist.proTypesg,
                    "loanType": $scope.addLoantypes,
                    "moneyResource": $scope.addMoneyresources,
                    "productCode": "string",
                    "productName": $scope.productName,
                    "productType": "string",
                    "state": "NORMAL",
                    "supportPayTime": "string"
                },
                "repaymentConfigInfos": $scope.packageCode,
                "storeConfigInfoS":storeTree ,
                "supportTimeInfos": $scope.supportList
            };
            console.log(data)
            $http({
                method: 'POST',
                url: '/product/addproduct',
                data:data
            }).then(function (res) {
                console.log(res)
                if(res.data.success&&res.data.executed){
                $rootScope.alertPart("添加产品成功");
                $("#add-data").modal("hide");
                $scope.clearAddForm();
                list(1);
                }else {
                    $rootScope.alertPart("添加产品失败！");
                    console.log(res)
                }
            },function () {
                $rootScope.alertPart("添加产品失败！");
                console.log("添加产品失败");
            })
        }


    }
    /*添加产品三级联动*/

    $scope.addGetType1=function()
    {
        var Oran=$resource('/product/getpruducttypes');
        Oran.get(function (res) {
            $scope.addType1List=res.productEnumModels;
        },function (err) {
            console.log("查询失败！")
        });
    }
    $scope.addGetType1();
    $scope.addGetType2=function(addGetType2)
    {
        var Oran=$resource('/product/getpruducttypes?typeCode='+addGetType2);
        Oran.get(function (res) {
            $scope.addType2List=res.productEnumModels;
        },function (err) {
            console.log("查询失败！")
        });
    }
    $scope.addGetType3=function(addGetType3)
    {
        var Oran=$resource('/product/getpruducttypes?typeCode='+addGetType3);
        Oran.get(function (res) {
            $scope.addType3List=res.productEnumModels;
        },function (err) {
            console.log("查询失败！")
        });
    }


    /*新建完*/


    /*编辑*/
    // 遍历利率配置
    function eiditLilvList() {
        console.log($scope.repaymentList)
        console.log($scope.packageCode)
        angular.forEach($scope.repaymentList,function (obj) {
            pkgObj={packageCode:obj.packageCode};
            $scope.packageCode.push(pkgObj)
        })
    }

    /*遍历支持期数*/
    function editSupportListFn() {
        console.log($scope.supportList)
        angular.forEach($scope.supportList,function (obj) {
            var editObj={
                payTime:obj.payTime,
                paytimeUnit:obj.paytimeUnit.name
            };
            $scope.editSupportList.push(editObj)
        });
        $scope.mySupport=$scope.editSupportList[0].paytimeUnit;//给支持期数默认值
    }
    /*遍历提成单量*/
    function editComList() {
        angular.forEach($scope.commissionList,function (obj) {
            var editObj={
                commission:obj.commission,
                commissionType:obj.commissionType.name,
                position:obj.position.name,
                upperLimit:obj.upperLimit,
                lowerLimit:obj.lowerLimit
            };
            $scope.editCommissionList.push(editObj)
        });
        if($scope.lookres.productInfoDTO.isEnabledLadder.name=='YES'){
            for(var i=0,len=$scope.editCommissionList.length;i<len;i+=$scope.positionsList.length-1){
                $scope.commissionTypeList.push($scope.editCommissionList.slice(i,i+$scope.positionsList.length-1));
            }
        }

    }
    // 打开编辑模态窗
    $scope.editData=function (bizid,idx) {
        $scope.currentIdx=idx
        $('#edit-data').modal({backdrop: 'static', keyboard: false});
        $("#edit-data").modal("show");
        $('#editTreeview').hide();
        $scope.editModal=true;
        $scope.getQishu();
        $scope.shuju(bizid);
        var editTreeview_options={
            bootstrap2: false,
            levels: 5,
            showCheckbox: true,
            onNodeChecked:nodeChecked ,
            onNodeUnchecked:nodeUnchecked,
            checkedIcon: "glyphicon glyphicon-check",
            data: buildDomTree('editTreeview')
        };
        $('#editTreeview').treeview(editTreeview_options);
        $('#editTreeview').treeview('collapseAll', { silent: true });

    }

    /*----编辑产品接口----*/
    $scope.editProduct=function () {
        $('#editTreeview').hide()
        var storeTree=[];
        angular.forEach($('#editTreeview').treeview('getSelected'),function (obj) {
            if(obj.state.checked){
                var objj={"storeCode":obj.id}
                storeTree.push(objj);
            }
        })

        if(storeTree.length==0){
            $scope.editStroeTreeChange=true;
        }
        clearEditCommissionForm();
        //判断金额提成相加不大于1
        var editTypeWrong;
        if($scope.myToggle=='YES'){
            for(var i=0;i<$scope.commissionTypeList.length;i++){
                var sum=0;
                for(var j=0;j<$scope.commissionTypeList[i].length;j++){
                    if($scope.commissionTypeList[i][j].commissionType=='CASH'){
                        sum+=$scope.commissionTypeList[i][j].commission;
                    }
                }
                if(sum>100){
                    $rootScope.alertPart("金额提成相加不能大于100%，请检查！");
                    editTypeWrong=false;
                    return;
                }else {
                    editTypeWrong=true;
                }
            }
        }else {
            var sum2=0
            angular.forEach($scope.editCommissionList,function (obj) {
                if(obj.commissionType=='CASH'){
                    sum2+=obj.commission;
                }
            });
            if(sum2>100){
                $rootScope.alertPart("金额提成相加不能大于100%，请检查！");
                editTypeWrong=false;
                return;
            }else {
                editTypeWrong=true;
            }
        }

        if($scope.editSupportList.length==0){
            $scope.editSupportVal1=true;
        }
        if($scope.packageCode.length==0){
            $scope.editlilvListNull=true;
        }
        if ($scope.editCommissionList.length==0){
            $scope.editCommissionListNull=true;
        }
        if(!$scope.lookres.productInfoDTO.productName){
            $scope.proNameChange=true;
        }
        if($scope.lookres.productInfoDTO.interestType.name=='select'){
            $scope.editInterestsTips=true
        }
        if($scope.lookres.productInfoDTO.moneyResource.name=='select'){
            $scope.editMoneyresourcesTips=true;
        }
        if($scope.lookres.productInfoDTO.loanType.name=='select'){
            $scope.editLoantypesTips=true;
        }
        var reg1=storeTree.length>0&&$scope.lookres.productInfoDTO.productName&&$scope.packageCode.length>0&&$scope.editSupportList.length>0&&$scope.editCommissionList.length>0&&$scope.lookres.productInfoDTO.interestType.name!='select'&&$scope.lookres.productInfoDTO.moneyResource.name!='select'&&$scope.lookres.productInfoDTO.loanType.name!='select'&&editTypeWrong;
        var reg2;
        if($scope.myToggle=='YES'){
            for(var i=0;i<$scope.editCommissionList.length;i++){
                if(($scope.editCommissionList[i].commission||$scope.editCommissionList[i].commission===0)&&$scope.editCommissionList[i].commissionType!='select'){
                    reg2=true;
                }else {
                    reg2=false;
                    return;
                }
            }
        }else {
            reg2=true;
        }

        if (reg1&&reg2) {
            var data={
            "commissionConfigInfos": $scope.editCommissionList,
            "productInfoDTO": {
                "bizid": editBizid,
                "interestType": $scope.lookres.productInfoDTO.interestType.name,
                "isEnabledLadder": $scope.myToggle,
                "isSupportAssend": $scope.lookres.productInfoDTO.isSupportAssend.name,
                "level1Code": $scope.lookres.productInfoDTO.level1Code,
                "level2Code": $scope.lookres.productInfoDTO.level2Code,
                "level3Code": $scope.lookres.productInfoDTO.level3Code,
                "loanType": $scope.lookres.productInfoDTO.loanType.name,
                "moneyResource": $scope.lookres.productInfoDTO.moneyResource.name,
                "productCode": productCode,
                "productName": $scope.lookres.productInfoDTO.productName,
                "productType": "string",
                "state": "NORMAL",
                "supportPayTime": "string"
            },
            "repaymentConfigInfos": $scope.packageCode,
            "storeConfigInfoS":storeTree ,
            "supportTimeInfos": $scope.editSupportList
        }
        console.log(data)
        $http({
            method: 'PUT',
            url: '/product/updateproduct',
            data: data
        }).then(function (res) {
            if(res.data.success&&res.data.executed){
                $rootScope.alertPart("编辑产品成功！")
                $("#edit-data").modal("hide");
                $scope.editProForm.$setUntouched();
                $scope.clearEditForm();
                list($scope.page)
            }else {
                $rootScope.alertPart("修改产品异常")
                console.log(res.data.data)
            }
        },function () {
            $rootScope.alertPart("修改产品异常")
        })
        }
    }
    // 清除高亮
    $scope.removeHl=function () {
        for(var i=1;i<$("tr").length;i++){
            if($("tr")[i].getAttribute("class").indexOf("highLight")!=-1){
                $("tr").eq(i).removeClass("highLight")
            }
        }
        $scope.currentIdx=''
    }
    // 小数点后保留N位小数，v是数字，e是小数点后位数
    function round(v,e){
        var t=1;
        for(;e>0;t*=10,e--);
        for(;e<0;t/=10,e++);
        return Math.round(v*t)/t;
    }
}]);

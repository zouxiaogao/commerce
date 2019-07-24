$(function(){

    tabChange();
    // getTabContent1();
    /**
     * tab切换
     * @return {[type]} [description]
     */
    function tabChange(){
        $('.nav-tabs li').click(function(){
            $(this).addClass('active').siblings().removeClass('active');
            var _id = $(this).attr('data-id');
            $('.tabs-contents').find('#'+_id).addClass('active').siblings().removeClass('active');
            console.log(this)
            console.log("_id值："+_id)
            switch(_id){
                case "AwaitingPayment":
                    getTabContent1();
                    break;
                case "AwaitingShipment":
                    getTabContent2();
                    break;
                case "shipped":
                    getTabContent3();
                    break;
                case "complete":
                    getTabContent4();
                    break;
                case "canceled":
                    getTabContent5();
                    break;
                default:
                    getTabContent1();
                    break;
            }
        });
    }

    /**
     * 获取tab1的内容
     * @return {[type]} [description]
     */
    function getTabContent1(){
        $.get('../brand/orderlist',{status:1},function(response){
            console.log("response:====");
            console.log(response);
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                    '<tr>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td className="hidden-480" >'+order.orderNo+'</td>'+
                        '<td>'+order.orderCreatedTime+'</td>'+
                    '</tr>'   ;
                });
                $('#AwaitingPayment').find('tbody').html(tableList);
            }
        });
    }

    /**
     * 获取tab2的内容
     * @return {[type]} [description]
     */
    function getTabContent2(){
        $.get('../brand/orderlist',{status:2},function(response){
            console.log("response:====");
            console.log(response);
            console.log(status)
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                        '<tr>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td className="hidden-480" >'+order.orderNo+'</td>'+
                        '<td>'+order.orderCreatedTime+'</td>'+
                        '<td><button class="btn btn-minier btn-purple send-out")>发货</button> </td>'+
                        '</tr>'   ;
                });
                $('#AwaitingShipment').find('tbody').html(tableList);
            }
        });
    }


    function goShip(saoId) {
        alert(saoId)
        alert("ceshi")
        $.ajax({
            type: "GET",
            url: "/brand/goShip",
            data: {"id": saoId},
            success: function(data){//data就是 controller 中的 return 的 数据
                if(data.code==200){
                    //刷新数据
                    // alert(data.message)
                    bootbox.alert("已发货!");
                    window.location.reload();
                }else{
                    alert(data.message);
                }
            }
        });


    }

    /**
     * 获取tab3的内容
     * @return {[type]} [description]
     */
    function getTabContent3(){
        $.get('../brand/orderlist',{status:3},function(response){
            console.log(response);
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                        '<tr>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td className="hidden-480" >'+order.orderNo+'</td>'+
                        '<td>'+order.orderCreatedTime+'</td>'+
                        '<td><a href="brand-ordertracking">'+order.trackingNo+'</a></td>'+
                        '<td><button class="btn btn-minier btn-yellow cancel">取消</button> </td>'+
                        '</tr>';
                });
                $('#shipped').find('tbody').html(tableList);
            }
        });
    }


    /**
     * 获取tab4的内容
     * @return {[type]} [description]
     */
    function getTabContent4(){
        $.get('../brand/orderlist',{status:4},function(response){
            console.log(response);
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                        '<tr>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td className="hidden-480" >'+order.orderNo+'</td>'+
                        '<td>'+order.orderCreatedTime+'</td>'+
                        '<td><a href="brand-ordertracking">'+order.trackingNo+'</a></td>'+
                        '</tr>';
                });
                $('#complete').find('tbody').html(tableList);
            }
        });
    }

    /**
     * 获取tab3的内容
     * @return {[type]} [description]
     */
    function getTabContent5(){
        $.get('../brand/orderlist',{status:5},function(response){
            console.log(response);
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                        '<tr>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td className="hidden-480" >'+order.orderNo+'</td>'+
                        '<td>'+order.orderCreatedTime+'</td>'+
                        '</tr>';
                });
                $('#canceled').find('tbody').html(tableList);
            }
        });
    }
});
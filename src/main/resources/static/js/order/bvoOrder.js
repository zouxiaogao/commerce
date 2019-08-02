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
        $.get('/bvo/order/list',{status:1},function(response){
            console.log(response);
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                        '<tr>'+
                        '<th class="center"><label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label></th>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td className="hidden-480" >'+order.orderNo+'</td>'+
                        '<td>'+order.total+'</td>'+
                        '<td><a href="/bvo/order/paypage">付款</a></td>'+
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
        $.get('/bvo/order/list',{status:2},function(response){
            console.log("response:====");
            console.log(response);
            console.log(status)
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                        '<tr>'+
                        '<th class="center"><label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label></th>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td className="hidden-480" >'+order.orderNo+'</td>'+
                        '<td>'+order.total+'</td>'+
                        '</tr>' ;
                });
                $('#AwaitingShipment').find('tbody').html(tableList);
            }
        });
    }


    /**
     * 获取tab3的内容
     * @return {[type]} [description]
     */
    function getTabContent3(){
        $.get('/bvo/order/list',{status:3},function(response){
            console.log(response);
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                        '<tr>'+
                        '<th class="center"><label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label></th>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td>'+order.total+'</td>'+
                        '<td className="hidden-480" >'+order.orderNo+'</td>'+
                        '<td><a href="brand-ordertracking">'+order.trackingNo+'</a></td>'+
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
        $.get('/bvo/order/list',{status:4},function(response){
            console.log(response);
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                        '<tr>'+
                        '<th class="center"><label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label></th>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td>'+order.total+'</td>'+
                        '<td className="hidden-480" >'+order.orderNo+'</td>'+
                        '<td><a href="brand-ordertracking">'+order.trackingNo+'</a></td>'+
                        '</tr>';
                });
                $('#complete').find('tbody').html(tableList);
            }
        });
    }

    /**
     * 获取tab5的内容
     * @return {[type]} [description]
     */
    function getTabContent5(){
        $.get('/bvo/order/list',{status:5},function(response){
            console.log(response);
            if(response.code === 200){
                var data = response.data,
                    tableList = '';
                data.forEach(function(order){
                    tableList +=
                        '<tr>'+
                        '<th class="center"><label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label></th>'+
                        '<td><a href="bvo-goodsdetail" >'+order.title+'</a></td>'+
                        '<td>'+order.price+'</td>'+
                        '<td className="hidden-480">'+order.qty+'</td>'+
                        '<td className="">'+order.skuNo+'</td>'+
                        '<td>'+order.total+'</td>'+
                        '<td><a href="/bvo/order/paypage?orderId='+order.saoId+'">付款</a></td>'+
                        '</tr>';
                });
                $('#canceled').find('tbody').html(tableList);
            }
        });
    }
});
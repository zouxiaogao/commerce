$(function(){


    $("#btnsave").click(function(){

        var data={
            nameCn: $("#nameCn").val(),
            nameEn: $("#nameEn").val(),
            description:$("#editor").val(),
            gmcReportType:$("#confirm_type").val(),
            gmcReportUrl:$("#confirm_url").val()
        };

        console.log(data)
        $.ajax({
            url:"../saveBrand",
            type:"POST",
            contentType:"application/json",
            dataType:"json",
            data:  JSON.stringify(data),
            success : function (result) {
                if(result.code==200){
                    alert(result.message);
                    window.location.href="/brand-addbrand";
                }else if(result.code==-1){
                    // $("[data-toggle='tooltip']").tooltip();
                    alert(result.message);
                    window.location.href="/brand-addbrand";
                }else {
                    alert("系统繁忙")
                }
            }
        });

        return false;

    });

    //
    // $("form").submit(function(){
    //     $.ajax({
    //         url :  "../checklogin",
    //         type : "POST",
    //         data : {name: $("#username").val(),password: $("#password").val()},
    //         success : function(result){
    //             if(result.code==200){
    //                 window.location.href="/index";
    //             }else if(result.code==-1){
    //                 alert(result.message);
    //             }else {
    //                 alert("系统繁忙")
    //             }
    //         }
    //     });
    //     //阻止表单提交
    //     return false;
    // });
});
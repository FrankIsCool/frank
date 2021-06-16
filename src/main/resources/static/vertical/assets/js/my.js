function click(url, param,success) {
    if(null == param || "null" == param){
        param = {};
    }
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json;charset=utf-8",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
            'token':$.cookie('token')
        },
        data: JSON.stringify(param),
        dataType: "json",
        success: function (result) {
            if (result.code == "600") {
                Swal.fire({type:"error",title:result.text,text:JSON.stringify(result.data),confirmButtonClass:"btn btn-confirm mt-2"})
                return ;
            }
            if (result.code == "601") {
                Swal.fire({type:"error",title:"请重新登录",text:JSON.stringify(result.text),confirmButtonClass:"btn btn-confirm mt-2"})
                return ;
            }
            if (result.code != "200") {
                Swal.fire({type:"error",title:"系统异常",text:result.text,confirmButtonClass:"btn btn-confirm mt-2"})
                return ;
            }
            success(result.data)
        },
        error: function (result) {
            Swal.fire({title: result.text, confirmButtonClass: "btn btn-confirm mt-2"})
        }
    })
};


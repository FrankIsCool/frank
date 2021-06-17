function click(url, param, success) {
    if (null == param || "null" == param) {
        param = {};
    }
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json;charset=utf-8",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
            'token': $.cookie('token')
        },
        data: JSON.stringify(param),
        dataType: "json",
        success: function (result) {
            if (result.code == "600") {
                Swal.fire({
                    type: "error",
                    title: result.text,
                    text: JSON.stringify(result.data),
                    confirmButtonClass: "btn btn-confirm mt-2"
                })
                return;
            }
            if (result.code == "601") {
                Swal.fire({
                    type: "error",
                    title: "请重新登录",
                    text: JSON.stringify(result.text),
                    confirmButtonClass: "btn btn-confirm mt-2"
                })
                return;
            }
            if (result.code != "200") {
                Swal.fire({type: "error", title: "系统异常", text: result.text, confirmButtonClass: "btn btn-confirm mt-2"})
                return;
            }
            success(result.data)
        },
        error: function (result) {
            Swal.fire({title: result.text, confirmButtonClass: "btn btn-confirm mt-2"})
        }
    })
};

function clickList(url, param,columns,aoColumnDefs) {
    //提示信息
    var lang = {
        "sProcessing": "处理中...",
        "sLengthMenu": "每页 _MENU_ 项",
        "sZeroRecords": "没有匹配结果",
        "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
        "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
        "sInfoPostFix": "",
        "sSearch": "搜索:",
        "sUrl": "",
        "sEmptyTable": "表中数据为空",
        "sLoadingRecords": "载入中...",
        "sInfoThousands": ",",
        "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页",
            "sJump": "跳转"
        },
        "oAria": {
            "sSortAscending": ": 以升序排列此列",
            "sSortDescending": ": 以降序排列此列"
        }
    };
    $("#datatable-buttons").dataTable().fnDestroy();
    //初始化表格
    var table = $("#datatable-buttons").dataTable({
        language: lang,  //提示信息
        autoWidth: false,  //禁用自动调整列宽
        stripeClasses: ["odd", "even"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
        processing: true,  //隐藏加载提示,自行处理
        serverSide: true,  //启用服务器端分页
        searching: false,  //禁用原生搜索
        orderMulti: false,  //启用多列排序
        order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
        renderer: "bootstrap",  //渲染样式：Bootstrap和jquery-ui
        pagingType: "simple_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
        columnDefs: [{
            "targets": 'nosort',  //列的样式名
            "orderable": false    //包含上样式名‘nosort’的禁止排序
        }],
        aoColumnDefs: aoColumnDefs,
        ajax: function (data, callback, settings) {
            //封装请求参数
            param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.pageNum = (data.start / data.length) + 1;//当前页码
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json;charset=utf-8",
                headers: {
                    'Content-Type': 'application/json;charset=utf-8',
                    'token': $.cookie('token')
                },
                cache: false,  //禁用缓存
                data: JSON.stringify(param),  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    if (result.code == "600") {
                        Swal.fire({
                            type: "error",
                            title: result.text,
                            text: JSON.stringify(result.data),
                            confirmButtonClass: "btn btn-confirm mt-2"
                        })
                        return;
                    }
                    if (result.code == "601") {
                        Swal.fire({
                            type: "error",
                            title: "请重新登录",
                            text: JSON.stringify(result.text),
                            confirmButtonClass: "btn btn-confirm mt-2"
                        })
                        return;
                    }
                    if (result.code != "200") {
                        Swal.fire({
                            type: "error",
                            title: "系统异常",
                            text: result.text,
                            confirmButtonClass: "btn btn-confirm mt-2"
                        })
                        return;
                    }
                    var returnData = {};
                    returnData.draw = result.data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                    returnData.recordsTotal = result.data.recordsTotal;//返回数据全部记录
                    returnData.recordsFiltered = result.data.recordsFiltered;//后台不实现过滤功能，每次查询均视作全部结果
                    returnData.data = result.data.data;//返回的数据列表
                    //console.log(returnData);
                    //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                    //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                    callback(returnData);
                },
                error: function (result) {
                    Swal.fire({title: result.text, confirmButtonClass: "btn btn-confirm mt-2"})
                }
            });
        },
        //列表表头字段
        columns: columns
    }).api();
    $("body").delegate('#showrule_table .doshow', 'click', function () { });
    //此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象
};

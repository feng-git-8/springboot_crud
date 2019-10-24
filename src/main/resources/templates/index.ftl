<!DOCTYPE html>
<html>
<head>
    <title>nnn</title>
    <script src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/artDialog-master/dist/dialog-plus-min.js"></script>
    <link rel="stylesheet" href="js/artDialog-master/css/ui-dialog.css" />
    <style>
        table {
            width: 50%;
            font-size: .938em;
            border-collapse: collapse;/*边框合并*/
        }
        th {
            text-align: left;
            padding: .5em .5em;
            font-weight: bold;
            background: #66677c;color: #fff;
        }

        td {
            padding: .5em .5em;
            border-bottom: solid 1px #ccc;
        }

        table,table tr th, table tr td { border:1px solid #0094ff; }/*设置边框*/
    </style>
</head>
<body>
<div style="margin-left: 300px;margin-top: 40px">
    <#--<form action="/addCrud" method="post">
        <input name="cname">
        <input type="date"  pattern="yyyy-MM-dd" name="cdate">
        <input type="submit" value="添加">
    </form><br/><br/>-->
    <button onclick="adddialog()">添加</button>
    <#--数据输出-->
    <table class="layui-table" >
        <thead>
        <tr>
            <th>id</th>
            <th>名称</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#list li as it>
            <tr>
                <td>${it.cid}</td>
                <td>${it.cname}</td>
                <td>
                    <#if (it.cdate)??>
                        ${it.cdate?string('yyyy-MM-dd')}
                    <#else>
                        null
                    </#if>
                </td>
                <td>
                    <a href="javascript:deleteCrud(${it.cid})">删除</a>
                    <a href="javascript:updateCrud(${it.cid})">修改</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<script>

    /********************删除*********************/
    function deleteCrud(va){
        console.log(va);
        var d = dialog({
            title:'删除',
            content:"是否删除id为"+va+"的",
            okValue:'确认',
            ok:function(){
                $.ajax({
                    url:"/deleteCrud",
                    data:{cid:va},
                    dataType:"text",
                    type:"post",
                    success:function(data){
                        console.log(data);
                        window.location.reload();
                    }
                })
            },
            cancelValue:'取消',
            cancel:function(){
                this.title("正在取消...",1);
            }
        });
        d.showModal();
    }
    /***********************修改****************/
    function updateCrud(cid){
        $.ajax({
            url:"/updateCrud",
            data:{cid:cid},
            dataType:"text",
            type:"post",
            success:function(data){
                var d = dialog({
                    title:'修改',
                    content:data,
                    okValue:'确认',
                    ok:function(){
                        this.title("正在修改",1);
                        submi();
                    },
                    cancelValue:'取消',
                    cancel:function(){
                        this.title("正在取消",1);
                    }
                });
                d.showModal();
            }
        })

    }


    /*********************添加方法**********************/
    function adddialog(){
        $.ajax({
            url: "/toAdd",
            data:[],
            dataType: "text",
            type: "post",
            success: function (data) {
                var d = dialog({
                    title: '添加',
                    content: data,
                    okValue: '确认',
                    ok: function () {
                        add();

                    },
                    cancelValue: '取消',
                    cancel: function () {
                        this.title("正在取消...", 1);
                    }
                });
                d.showModal();
            }
        })
    }
</script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery-1.11.3.min.js"></script>
</head>
<body>
<#--<div style="margin-left: 300px;margin-top: 40px">-->
<h1>修改</h1>
    <form id="crudForm" method="post">
    <input type="hidden" name="cid" value=${cr.cid!}><br/>
    <input name="cname" value=${cr.cname!}><br/>
    <input type="date"  pattern="yyyy-MM-dd" name="cdate" value="${cr.cdate?string('yyyy-MM-dd')}"><br/>
    <input type="button" onclick="submi()" value="修改">
</form>
<#--</div>-->
<script>

    function submi(){
        $.ajax({
            url:"/updateCrudTrue",
            data:$("#crudForm").serialize(),
            dataType:"json",
            type:"post",
            success:function (data) {
                window.location.reload();
            }
        })
    }


</script>
</body>
</html>
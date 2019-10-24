
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery-1.11.3.min.js"></script>
</head>
<body>
<h1>添加</h1>
<form id="addCrudForm" method="post">
    <input name="cname" ><br/>
    <input type="date"  pattern="yyyy-MM-dd" name="cdate" ><br/>
    <input type="button" onclick="submi()" value="添加">
</form>
<script>

    function add(){
        $.ajax({
            url:"/addCrud",
            data:$("#addCrudForm").serialize(),
            dataType: "text",
            type: "post",
            success:function (data) {
                window.location.reload();
            }
        })
    }


</script>
</body>
</html>
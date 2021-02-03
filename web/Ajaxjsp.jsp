<%--
Created by IntelliJ IDEA.
User: 刘天宇
Date: 2020/12/18
Time: 14:42
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#id_btn").click(function () {
                $.ajax({
                    type: "POST",
                    url: "AJaxTestServlet",
                    //data: "name=John&location=Boston",
                    date:{"name":"John","location":"Boston"},
                    dataType:"json",
                    success: function(rs){
                        alert( "Data Saved: " + rs.msg );
                    },
                    error:function () {
                        alert("请求失败");
                    }
                });
            })
            $("#id_btn2").click(function () {
                /*$.get("AJaxTestServlet",{"stuName":"cxk","stuAge":18},function (rs) {
                    alert("re:"+rs);
                },"json");*/

                $.getJSON("AJaxTestServlet",{"stuName":"cxk","stuAge":18}),function (rs) {
                    alert("rs:"+rs)
                }

            })


        })

    </script>
</head>
<body>
<button id="id_btn">123</button>
<button id="id_btn2">223</button>
</body>
</html>

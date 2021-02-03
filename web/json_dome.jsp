<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-1.7.2.js"></script>
    <script type="text/javascript">
        var jsons = {
            "key1":"abc",
            "key2":123,
            "key3":[123,"21341","53"],
            "key4":{
                "key4_1":12,
                "key4_2":"kkk"
            },
            "key5":[{
                "key5_1_1":12,
                "key5_1_2":"abc"
            },
                {
                    "key5_2_1":41,
                    "key5_2_2":"bbj"
                }]

        };
        alert(jsons.key2);//123
        alert(jsons.key3[2]);//53
        alert(jsons.key4.key4_2);//kkk
        alert(jsons.key5[1].key5_2_2);//bbj

        //json对象:jsons
        //alert(jsons);
        //将json对象,转换为jsonString
        var jsonString = JSON.stringify(jsons);
        alert(jsonString);
        //将jsonString转换为jsonObj
        var jsonObj = JSON.parse(jsonString);
        alert(jsonObj);
    </script>
</head>
<body>
<h2>json</h2>
</body>
</html>

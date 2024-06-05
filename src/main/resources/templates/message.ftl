<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>全部学生信息</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<#include 'top.ftl'>

<div style="width: 800px;margin: 0 auto">
    <#include 'left.ftl'>

    <div style="width: 500px;margin: 0 auto;float: left">
        <table class="table table-striped table-sm">
            <caption>学生信息</caption>
            <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>联系电话</th>
                <th>操作</th>
            </tr>
            </thead>
        <tbody>
            <#if students??>
                <#list students as student >
                    <tr>
                        <td>${student.getCard()}</td>
                        <td>${student.getName()}</td>
                        <td>${student.getSex()}</td>
                        <td>${student.getPhone()}</td>
                        <td>
                            <#--TODO : 这里有个问题  ， 点删除学生后 再点左侧跳转时url前面都会加上一个student原本是http://localhost:12345/message  变成http://localhost:12345/student/Delete
                            --><a class="btn btn-sm btn-danger" href="/student/Delete/${student.getCard()}">删除</a>
                        </td>
                    </tr>
                </#list>
            </#if>
        </tbody>
        </table>

    </div>
</div>
</body>
</html>
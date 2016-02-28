<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="windows-1251">
    <title> ${titleAttribute} </title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="/resources/js/students.js">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script>
        $(function() {
            $("#startDate").datepicker();
        });

        function validateFields() {
            for(var i = 0; i < arguments.length; i++) {
                if(document.getElementById(arguments[i]).value == "") {
                    alert("One of fields is empty. Operation is not completed.");
                    event.preventDefault();
                    return false;
                }
            }
            $('#createStudentForm').submit();
        }

        function bulkOperation() {
            var items = $("input[type=checkbox]:checked");
            if (items.length == 0) {
                alert("No students are selected for operation.");
                return;
            }
//            var operationName = arguments[0];
            var controllerAddress = arguments[1];
            var ids = "";
            for ( var i = 0; i < items.length; i++) {
                ids += $(items[i]).attr("id");
                if (i < items.length - 1) {
                    ids += ",";
                }
            }

            console.log(ids);
            console.log("ids=" + ids);
            var form = '<form id="hiddenForm" action="'
                    + 'http://'
                    + document.location.host
                    + controllerAddress
                    + '" method="post"><input type="hidden" name="ids" id="ids">'
                    + '<input type="hidden" name="operation" id="operation">'
                    + '</form>';
            $("body").append(form);
            $('#ids').val(ids);
//            $('#operation').val(operationName);
            $('#hiddenForm').submit();
        }
    </script>
</head>

<style type="text/css">
    @import "/resources/css/style.css";
</style>

<body>
<div class="main">
    <div class="header">
        <div class="emptyTitle"></div>
        <div class="title"> The control system of students and their academic performance
        </div>
        <div class="logout"> <a href="https://google.com/"> Logout </a>
        </div>
    </div>
    <div class="pageElements">


<jsp:include page="${currentPage}"></jsp:include>

    </body>
</html>
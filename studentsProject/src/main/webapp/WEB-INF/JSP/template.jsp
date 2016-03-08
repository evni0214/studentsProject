<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="windows-1251">
    <title> ${titleAttribute} </title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <%--<link rel="stylesheet" href="/resources/js/students.js">--%>
    <link rel="stylesheet" href="/resources/css/style.css">
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
            var controllerAddress = arguments[1];
            if(items.length == 0) {
                alert("No objects are selected for operation.");
                location.href="";
                return;
            }
            var operationName = arguments[0];
            if(operationName == 'modify') {
                if(items.length > 1) {
                    alert("Too many objects are selected for operation.");
                    return;
                } else {
                    var ids = "";
                    ids += $(items[0]).attr("id");

                    console.log(ids);
                    console.log("ids=" + ids);
                    var form = '<form id="hiddenForm" action="'
                            + 'http://'
                            + document.location.host
                            + controllerAddress
                            + '" method="get"><input type="hidden" name="ids" id="ids">'
                            + '<input type="hidden" name="operation" id="operation">'
                            + '</form>';
                    $("body").append(form);
                    $('#ids').val(ids);
                    $('#hiddenForm').submit();
                }
            } else if(operationName == 'delete') {
                if (confirm('Are you sure you want to delete this object?')) {
                    var ids = "";
                    for (var i = 0; i < items.length; i++) {
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
                    $('#hiddenForm').submit();
                } else {
                    // Do nothing!
                }
            }
        }
    </script>
</head>

<body>
<div class="main">
    <div class="header">
        <div class="emptyTitle"></div>
        <div class="title"> The control system of students and their academic performance
        </div>
        <div class="logout"> <a href="/logout"> Logout </a>
        </div>
    </div>
    <div class="pageElements">


<jsp:include page="${currentPage}"></jsp:include>

    </body>
</html>
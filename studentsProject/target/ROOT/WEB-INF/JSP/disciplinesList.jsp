<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="windows-1251">
    <title>Disciplines' list</title>
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
                <div class="buttons">
                    <div style="float: left">
                        <a href="/home"> Go to main </a>
                    </div>
                    <div style="float: left; margin-left: 15px;">
                        <a href="https://google.com/"> Previous page </a>
                    </div>
                    <div class="content">
                        <div class="titleTextStyle">
                            <a> List of disciplines </a>
                        </div>
                        <br>
                        <br>
                        <table style="float: left;" width="400px" border="1">
                            <tr class="firstTableRow">
                                <td></td>
                                <td>Name of discipline</td>
                            </tr>
                            <c:forEach items="${disciplineList}" var="ds">
                                <tr class="tableTextStyle">
                                    <td class="checkBoxColumn">
                                        <input type="checkbox" name="1">
                                    </td>
                                    <td>${ds.disciplineName}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div class="discListForm">
                            <input class="wideButton" type="submit" value="Create new discipline" name="newDiscipline" onclick="location.href='/disc_create'">
                            <br>
                            <br>
                            <input class="wideButton" type="submit" value="Modify existing discipline" name="modifyDiscipline">
                            <br>
                            <br>
                            <input class="wideButton" type="submit" value="Delete discipline" name="deleteDiscipline">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
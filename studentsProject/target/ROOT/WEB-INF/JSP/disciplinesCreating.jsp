<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="windows-1251">
    <title>Discipline creating</title>
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
                            <a> Fill out the field and click "Create" to create new discipline. </a>
                        </div>
                        <br>
                        <br>
                        <form class="wideFormStyle" method="post">
                            <table width="350px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Name of new discipline </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <input type="text" name="disciplineName">
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <input class="smallButton" type="submit" value="Create" id="createDiscipline">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
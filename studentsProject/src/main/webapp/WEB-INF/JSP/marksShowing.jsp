<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="windows-1251">
    <title>Mark showing</title>
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
                    <div style="float: left; margin-left: 15px">
                        <a href="https://google.com/"> Previous page </a>
                    </div>
                    <div class="content">
                        <div class="titleTextStyle">
                            <a> Fill out fields and click "Show" to get the student's marks for selected semester. </a>
                        </div>
                        <br>
                        <br>
                        <form class="wideFormStyle">
                            <table width="600px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Select student: </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <select class="selectStyle" name="selectStudent">
                                            <c:forEach items="${studentList}" var="st">
                                                <option> ${st.firstName} &nbsp; ${st.lastName} &nbsp; ${st.groupId}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Select semester: </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <select class="selectStyle" name="selectSemester">
                                            <c:forEach items="${semesterList}" var="sem">
                                                <option> ${sem.semesterName} </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <input class="smallButton" type="submit" value="Show" name="showMarks">
                                    </td>
                                </tr>
                            </table>
                        </form>
                        <br>
                        <br>
                        <a class="textStyle"> Results for student "Петров" in semester "Семестр 1":</a>
                        <br>
                        <br>
                        <table width="500px" border="1">
                            <tr class="firstTableRow">
                                <td> Semester </td>
                                <td> Discipline </td>
                                <td> Mark </td>
                            </tr>
                            <tr>
                                <td> Семестр 1 </td>
                                <td> Информатика </td>
                                <td> 5 </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
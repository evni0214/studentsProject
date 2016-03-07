<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <div class="buttons">
            <div style="float: left">
                <a href="/${role}/home"> Go to main </a>
            </div>
            <div style="float: left; margin-left: 15px;">
                <a href="/${role}/stud_list"> Previous page </a>
            </div>
            <div class="content">
                <div class="titleTextStyle">
                    <a> Academic performance of selected student: </a>
                </div>
                <br>
                <table width="750px" border="1">
                    <tr class="firstTableRow">
                        <td> Last name </td>
                        <td> First name </td>
                        <td> Group </td>
                        <td> Entrance date </td>
                    </tr>
                    <tr class="tableTextStyle">
                        <td> ${lastName} </td>
                        <td> ${firstName} </td>
                        <td> ${groupId} </td>
                        <td> <fmt:formatDate value="${startDate}" pattern="dd/MM/YYYY"></fmt:formatDate> </td>
                    </tr>
                </table>
                <br>
                <br>
                <table width="300px" style="float: left;" border="1">
                    <tr class="firstTableRow">
                        <td hidden> </td>
                        <td> Discipline </td>
                        <td> Mark </td>
                    </tr>
                        <c:forEach items="${marks}" var="entry">
                            <tr class="tableTextStyle">
                                <td hidden> <input hidden type="checkbox" checked id="${entry.key.disciplineId}"> </td>
                                <td> ${entry.key.name} </td>
                                <td> ${entry.value} </td>
                            </tr>
                        </c:forEach>
                </table>
                <form class="studProgressForm" action="/${role}/stud_progress" method="get" name="studProgress" id="studProgress">
                    <table width="375px">
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Select semester: </a>
                            </td>
                            <td class="fieldLeftNameColStyle">
                                <select class="selectStyle" name="selectSemester" id="selectSemester">
                                    <c:forEach items="${semesterList}" var="sem">
                                        <option value="${sem.semesterId}"> ${sem.name} </option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td class="fieldRightNameColStyle">
                                <input class="smallButton" type="submit" value="Select" name="selSemester">
                            </td>
                        </tr>
                    </table>
                    <br>
                    <a class="textStyle"> Average mark for "${semName}": ${avgMark} points </a>
                    <input type="hidden" name="studentId" id="studentId" value="${studentId}">
                </form>
            </div>
        </div>
    </div>
</div>
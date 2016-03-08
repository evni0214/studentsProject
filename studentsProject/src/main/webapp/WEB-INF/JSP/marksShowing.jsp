<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <div class="buttons">
                    <div style="float: left">
                        <a href="/${role}/home"> Go to main </a>
                    </div>
                    <div style="float: left; margin-left: 15px">
                        <a href="/${role}/home"> Previous page </a>
                    </div>
                    <div class="content">
                        <div class="titleTextStyle">
                            <a> Fill out fields and click "Show" to get the student's marks for selected semester. </a>
                        </div>
                        <br>
                        <br>
                        <form class="wideFormStyle" action="/${role}/mark_list" method="get">
                            <table width="600px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Select student: </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <select class="selectStyle" name="selectStudent" id="selectStudent">
                                            <c:forEach items="${studentList}" var="st">
                                                <option value="${st.studentId}"> ${st.firstName} &nbsp; ${st.lastName} &nbsp; ${st.groupId}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Select semester: </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <select class="selectStyle" name="selectSemester" id="selectSemester">
                                            <c:forEach items="${semesterList}" var="sem">
                                                <option value="${sem.semesterId}"> ${sem.name} </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                            </table>
                            <table width="600px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <input class="smallButton" type="submit" value="Show marks" name="showMarks">
                                    </td>
                                    <td class="fieldRightNameColStyle">
                                        <input class="smallButton" type="submit" value="Set mark" name="setMarks">
                                    </td>
                                </tr>
                            </table>
                            <input type="hidden" name="studentId" id="studentId" value="${studentId}">
                            <input type="hidden" name="semesterId" id="semesterId" value="${semesterId}">
                        </form>
                        <br>
                        <br>
                        <a class="textStyle"> Results for student "Петров" in semester "Семестр 1":</a>
                        <br>
                        <br>
                        <table width="500px" border="1">
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
                    </div>
                </div>
            </div>
        </div>
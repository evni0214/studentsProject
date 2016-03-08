<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="buttons">
            <div style="float: left">
                <a href="/${role}/home"> Go to main </a>
            </div>
            <div style="float: left; margin-left: 15px">
                <a href="/${role}/marks_disp"> Previous page </a>
            </div>
            <div class="content">
                <div class="titleTextStyle">
                    <a> Fill out fields and click "Submit" to create or modify the mark for student. </a>
                </div>
                <br>
                <br>
                <form class="wideFormStyle" action="/${role}/marks_management" method="post">
                    <table width="600">
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Select student: </a>
                            </td>
                            <td class="fieldColStyle">
                                <select class="selectStyle" name="selectStudent">
                                    <c:forEach items="${studentList}" var="st">
                                        <c:choose>
                                            <c:when test="${st.studentId == currentStudent}">
                                                <option class="selectedOption" selected value="${st.studentId}"> ${st.firstName} &nbsp; ${st.lastName} &nbsp; ${st.groupId}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${st.studentId}"> ${st.firstName} &nbsp; ${st.lastName} &nbsp; ${st.groupId}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                            <td class="fieldLeftNameColStyle">
                                <a> Select semester: </a>
                            </td>
                            <td class="fieldLeftNameColStyle">
                                <select class="selectStyle" name="selectSemester">
                                    <c:forEach items="${semesterList}" var="sem">
                                        <c:choose>
                                            <c:when test="${sem.semesterId eq currentSemester}">
                                                <option class="selectedOption" selected value="${sem.semesterId}"> ${sem.name} </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${sem.semesterId}"> ${sem.name} </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr class="spaceRow"></tr>
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Select discipline: </a>
                            </td>
                            <td class="fieldColStyle">
                                <select class="selectStyle" name="selectDiscipline">
                                    <c:forEach items="${disciplineList}" var="disc">
                                        <c:choose>
                                            <c:when test="${disc.disciplineId eq currentDiscipline}">
                                                <option class="selectedOption" selected value="${disc.disciplineId}"> ${disc.name} </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${disc.disciplineId}"> ${disc.name} </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                            <td class="fieldLeftNameColStyle">
                                <a> Current mark: </a>
                            </td>
                            <td class="fieldLeftNameColStyle">
                                <a> Unknown </a>
                            </td>
                        </tr>
                        <tr class="spaceRow"></tr>
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Set the mark: </a>
                            </td>
                            <td class="fieldColStyle">
                                <select class="selectStyle" name="selectDiscipline" onChange="this.style.backgroundColor=this.options[this.selectedIndex].style.backgroundColor">
                                    <option style="background: white;"> Select the mark ... </option>
                                    <option style="background: green;" value="5"> A (Excellent) - 5 </option>
                                    <option style="background: yellow;" value="4"> B (Good) - 4 </option>
                                    <option style="background: orange;" value="3"> C (Satisfactorily) - 3 </option>
                                    <option style="background: red;" value="2"> D (Unsatisfactorily) - 2 </option>
                                </select>
                            </td>
                        </tr>
                        <tr class="spaceRow"></tr>
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <input class="smallButton" type="submit" value="Submit" name="SubmitMark">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
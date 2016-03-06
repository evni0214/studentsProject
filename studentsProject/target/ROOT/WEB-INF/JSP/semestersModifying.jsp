<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="pageElements">
        <div class="buttons">
            <div style="float: left">
                <a href="/${role}/home"> Go to main </a>
            </div>
            <div style="float: left; margin-left: 15px;">
                <a href="/${role}/sem_list"> Previous page </a>
            </div>
            <div class="content">
                <div class="titleTextStyle">
                    <a> Fill out the fields and click "Submit" to modify existing semester. </a>
                </div>
                <br>
                <br>
                <form class="wideFormStyle" method="post" action="/${role}/sem_modify" onsubmit="validateFields('semesterName', 'semesterDuration', 'disciplineList')">
                    <table width="350px">
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Semester name </a>
                            </td>
                            <td class="fieldColStyle">
                                <input type="text" name="semesterName" id="semesterName">
                            </td>
                        </tr>
                        <tr class="spaceRow"></tr>
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Duration (weeks) </a>
                            </td>
                            <td class="fieldColStyle">
                                <input type="text" name="semesterDuration" id="semesterDuration">
                            </td>
                        </tr>
                        <tr class="spaceRow"></tr>
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Included disciplines </a>
                            </td>
                            <td class="fieldColStyle">
                                <select class="multiSelectStyle" multiple name="disciplineList" id="disciplineList">
                                    <c:forEach items="${discList}" var="entry">
                                        <c:if test="${entry.value eq '1'}">
                                            <option class="existedDiscipline" value="${entry.key.disciplineId}"> ${entry.key.name} </option>
                                        </c:if>
                                        <c:if test="${entry.value eq '0'}">
                                            <option value="${entry.key.disciplineId}"> ${entry.key.name} </option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr class="spaceRow"></tr>
                        <tr>
                            <td class="fieldLeftNameColStyle">
                            </td>
                            <td class="fieldLeftNameColStyle">
                                <input class="smallButton" type="submit" value="Submit" name="modifySemester">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
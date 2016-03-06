<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <div class="buttons">
                    <div style="float: left">
                        <a href="/${role}/home"> Go to main </a>
                    </div>
                    <div style="float: left; margin-left: 15px;">
                        <a href="/${role}/sem_list"> Previous page </a>
                    </div>
                    <div class="content">
                        <div class="titleTextStyle">
                            <a> Fill out the fields and click "Create" to crete new semester. </a>
                        </div>
                        <br>
                        <br>
                        <form class="wideFormStyle" method="post" action="/${role}/sem_create" onsubmit="validateFields('semesterName', 'semesterDuration', 'disciplineList')">
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
                                            <c:forEach items="${discList}" var="currDisc">
                                                <option value="${currDisc.disciplineId}"> ${currDisc.name} </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <input class="mediumButton" type="submit" value="Create" name="createSemester">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
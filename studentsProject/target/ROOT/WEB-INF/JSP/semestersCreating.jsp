<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <div class="buttons">
                    <div style="float: left">
                        <a href="/home"> Go to main </a>
                    </div>
                    <div style="float: left; margin-left: 15px;">
                        <a href="https://google.com/"> Previous page </a>
                    </div>
                    <div class="content">
                        <div class="titleTextStyle">
                            <a> Fill out the fields and click "Create" to crete new semester. </a>
                        </div>
                        <br>
                        <br>
                        <form class="wideFormStyle" method="post">
                            <table width="350px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Semester name </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <input type="text" name="semesterName">
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Duration (weeks) </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <input type="text" name="semesterDuration">
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Included disciplines </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <select class="multiSelectStyle" multiple name="disciplineList">
                                            <c:forEach items="${discList}" var="currDisc">
                                                <option> ${currDisc.disciplineName} </option>
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
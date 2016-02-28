<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <div class="buttons">
                    <div style="float: left">
                        <a href="/home"> Go to main </a>
                    </div>
                    <div style="float: left; margin-left: 15px;">
                        <a href="https://google.com/"> Previous page </a>
                    </div>
                    <br>
                    <div class="content">
                        <form class="semesterListSelectForm">
                            <table width="400px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Select semester </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <select class="selectStyle" name="listOfSemesters">
                                            <c:forEach items="${semesterList}" var="sem">
                                                <option> ${sem.semesterName} </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <input class="smallButton" type="submit" value="Select" name="selectSemester">
                                    </td>
                                </tr>
                            </table>
                        </form>
                        <br>
                        <a class="textStyle" style="float: left;"> Duration of semester: "24 weeks" </a>
                        <br>
                        <br>
                        <br>
                        <br>
                        <div>
                            <a class="textStyle" style="float: left;"> List of semesters' disciplines: </a>
                        </div>
                        <br>
                        <br>
                        <table style="float: left;" width="285px" border="1">
                            <tr class="firstTableRow">
                                <td> Name of discipline </td>
                            </tr>
                            <tr class="tableTextStyle">
                                <td> Информатика </td>
                            </tr>
                        </table>
                        <div class="semesterListButtonForm">
                            <input class="wideButton" type="submit" value="Create new semester" name="newSemester" onclick="location.href='/sem_create'">
                            <br>
                            <br>
                            <input class="wideButton" type="submit" value="Modify existing semester" name="modifySemester">
                            <br>
                            <br>
                            <input class="wideButton" type="submit" value="Delete semester" name="deleteSemester">
                        </div>
                    </div>
                </div>
            </div>
        </div>
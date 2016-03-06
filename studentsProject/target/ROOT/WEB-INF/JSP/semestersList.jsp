<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <div class="buttons">
                    <div style="float: left">
                        <a href="/${role}/home"> Go to main </a>
                    </div>
                    <div style="float: left; margin-left: 15px;">
                        <a href="/${role}/home"> Previous page </a>
                    </div>
                    <br>
                    <div class="content">
                        <form class="semesterListSelectForm" action="/${role}/sem_list" method="get" name="selectSemester" id="selectSemester"">
                            <table width="400px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Select semester </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <select class="selectStyle" name="listOfSemesters" id="listOfSemesters">
                                            <c:forEach items="${semesterList}" var="sem">
                                                <option value="${sem.semesterId}"> ${sem.name} </option>
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
                        <a class="textStyle" style="float: left;"> Duration of semester: ${currSemDur} weeks. </a>
                        <br>
                        <br>
                        <br>
                        <br>
                        <div>
                            <a class="textStyle" style="float: left;"> List of "${currSemName}" disciplines: </a>
                        </div>
                        <br>
                        <br>
                        <table style="float: left;" width="285px" border="1">
                            <tr class="firstTableRow">
                                <td> Name of discipline </td>
                            </tr>
                            <c:forEach items="${currSemDisc}" var="currDisc">
                                <tr class="tableTextStyle">
                                    <td> ${currDisc.name} </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div class="semesterListButtonForm">
                            <input class="wideButton" type="submit" value="Create new semester" name="newSemester" onclick="location.href='/${role}/sem_create'">
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
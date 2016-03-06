<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
                <div class="buttons">
                    <div style="float: left">
                        <a href="/${role}/home"> Go to main </a>
                    </div>
                    <div class="content">
                        <table width="450px">
                            <tr>
                                <td class="fieldLeftNameColStyle">
                                    <input type="submit" class="veryWideButton" value="View performance of particular students" name="viewStudent">
                                </td>
                                <td class="fieldLeftNameColStyle">
                                    <input type="submit" class="mediumButton" value="Create new student" name="crStudent" onclick="location.href='/${role}/stud_create'">
                                </td>
                            </tr>
                            <tr class="spaceRow"></tr>
                            <tr>
                                <td class="fieldLeftNameColStyle">
                                    <input type="submit" class="veryWideButton" value="Modify existing student" name="modStudent" onclick="bulkOperation('modify', '/${role}/stud_modify')">
                                </td>
                                <td class="fieldLeftNameColStyle">
                                    <input type="submit" class="mediumButton" value="Delete student" name="delStudent" onclick="bulkOperation('delete', '/${role}/stud_list')">
                                </td>
                            </tr>
                        </table>
                        <br>
                        <p class="textStyle"> List of students </p>
                        <table width="750px" border="1">
                            <tr class="firstTableRow">
                                <td></td>
                                <td> Last name </td>
                                <td> First name </td>
                                <td> Group </td>
                                <td> Entrance date </td>
                            </tr>
                            <c:forEach items="${students}" var="st">
                                <tr>
                                    <td class="checkBoxColumn"> <input type="checkbox" name="1" id="${st.studentId}"> </td>
                                    <td> ${st.lastName} </td>
                                    <td> ${st.firstName} </td>
                                    <td> ${st.groupId} </td>
                                    <td>
                                        <fmt:formatDate value="${st.startDate}" pattern="dd/MM/YYYY"></fmt:formatDate>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
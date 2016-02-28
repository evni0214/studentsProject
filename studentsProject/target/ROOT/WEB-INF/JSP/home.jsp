<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <br>
                <div class="content">
                    <table width="750px">
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a href="/stud_list"> Students </a>
                            </td>
                            <td class="spaceColumn"></td>
                            <td class="fieldColStyle">
                                <a href="/disc_list"> Disciplines </a>
                            </td>
                            <td class="spaceColumn"></td>
                            <td class="fieldColStyle">
                                <a href="/sem_list"> Semesters </a>
                            </td>
                            <td class="spaceColumn"></td>
                            <c:if test="${role eq admin}">
                                <td class="fieldRightNameColStyle">
                                    <a href="/mark_list"> Marks </a>
                                </td>
                            </c:if>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
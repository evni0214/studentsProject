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
                            <a> Fill out all fields and click "Create" to create new student. </a>
                        </div>
                        <br>
                        <br>
                        <br>
                        <form class="wideFormStyle" action="/stud_create" method="post" name="createStudentForm" id="createStudentForm" onsubmit="validateFields('lastName', 'firstName', 'groupName', 'startDate')">
                            <table width="325">
                                <tr>
                                    <td class="fieldRightNameColStyle">
                                        <a> Last name </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <input type="text" name="lastName" id="lastName">
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldRightNameColStyle">
                                        <a> First name </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <input type="text" name="firstName" id="firstName">
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldRightNameColStyle">
                                        <a> Group </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <input type="text" name="groupName" id="groupName">
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldRightNameColStyle">
                                        <a> Entrance date </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <input type="text" name="startDate" id="startDate">
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldRightNameColStyle">
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <input class="smallButton" type="submit" value="Create" name="createStudent">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
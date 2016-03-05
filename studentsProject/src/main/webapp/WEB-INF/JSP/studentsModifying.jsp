<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="buttons">
    <div style="float: left">
        <a href="/${role}/home"> Go to main </a>
    </div>
    <div style="float: left; margin-left: 15px;">
        <a href="/${role}/stud_list"> Previous page </a>
    </div>
    <div class="content">
        <div class="titleTextStyle">
            <a> Fill out all fields and click "Submit" to modify existing student. </a>
        </div>
        <br>
        <br>
        <br>
        <form class="wideFormStyle" action="/${role}/stud_modify" method="post" onsubmit="validateFields('lastName', 'firstName', 'groupName', 'startDate')">
            <table width="325">
                <tr>
                    <td class="fieldRightNameColStyle">
                        <a> Last name </a>
                    </td>
                    <td class="fieldColStyle">
                        <input type="text" name="lastName" id="lastName" value="${stud_last_name}">
                    </td>
                </tr>
                <tr class="spaceRow"></tr>
                <tr>
                    <td class="fieldRightNameColStyle">
                        <a> First name </a>
                    </td>
                    <td class="fieldColStyle">
                        <input type="text" name="firstName" id="firstName" value="${stud_first_name}">
                    </td>
                </tr>
                <tr class="spaceRow"></tr>
                <tr>
                    <td class="fieldRightNameColStyle">
                        <a> Group </a>
                    </td>
                    <td class="fieldColStyle">
                        <input type="text" name="groupName" id="groupName" value="${stud_group_name}">
                    </td>
                </tr>
                <tr class="spaceRow"></tr>
                <tr>
                    <td class="fieldRightNameColStyle">
                        <a> Entrance date </a>
                    </td>
                    <td class="fieldColStyle">
                        <input type="text" name="startDate" id="startDate" value="${stud_start_date}">
                    </td>
                </tr>
                <tr class="spaceRow"></tr>
                <tr class="spaceRow"></tr>
                <tr>
                    <td class="fieldRightNameColStyle">
                    </td>
                    <td class="fieldLeftNameColStyle">
                        <input class="smallButton" type="submit" value="Submit" name="modifyStudent">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="studentId" id="studentId" value="${studentId}">
        </form>
    </div>
</div>
</div>
</div>
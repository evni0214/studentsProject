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
                    <a> Academic performance of selected student: </a>
                </div>
                <br>
                <br>
                <table width="750px" border="1">
                    <tr class="firstTableRow">
                        <td> Last name </td>
                        <td> First name </td>
                        <td> Group </td>
                        <td> Entrance date </td>
                    </tr>
                    <tr class="tableTextStyle">
                        <td> Петров </td>
                        <td> Пётр </td>
                        <td> КТ-21 </td>
                        <td> 1/09/2011 </td>
                    </tr>
                </table>
                <br>
                <br>
                <table width="300px" style="float: left;" border="1">
                    <tr class="firstTableRow">
                        <td> Discipline </td>
                        <td> Mark </td>
                    </tr>
                    <tr class="tableTextStyle">
                        <td> Информатика </td>
                        <td> 5 </td>
                    </tr>
                </table>
                <form class="studProgressForm">
                    <table width="375px">
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Select semester: </a>
                            </td>
                            <td class="fieldLeftNameColStyle">
                                <select class="selectStyle" name="selectSemester">
                                    <option> Семестр 1 </option>
                                </select>
                            </td>
                            <td class="fieldRightNameColStyle">
                                <input class="smallButton" type="submit" value="Select" name="selSemester">
                            </td>
                        </tr>
                    </table>
                    <br>
                    <a class="textStyle"> Average mark for semester: "4.8 points" </a>
                </form>
            </div>
        </div>
    </div>
</div>
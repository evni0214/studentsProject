<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <div class="buttons">
                    <div style="float: left">
                        <a href="/${role}/home"> Go to main </a>
                    </div>
                    <div style="float: left; margin-left: 15px;">
                        <a href="/${role}/home"> Previous page </a>
                    </div>
                    <div class="content">
                        <div class="titleTextStyle">
                            <a> List of disciplines </a>
                        </div>
                        <br>
                        <br>
                        <table style="float: left;" width="400px" border="1">
                            <tr class="firstTableRow">
                                <td></td>
                                <td>Name of discipline</td>
                            </tr>
                            <c:forEach items="${disciplineList}" var="ds">
                                <tr class="tableTextStyle">
                                    <td class="checkBoxColumn">
                                        <input type="checkbox" name="disciplineId" id="${ds.disciplineId}">
                                    </td>
                                    <td>${ds.name}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div class="discListForm">
                            <input class="wideButton" type="submit" value="Create new discipline" name="newDiscipline" onclick="location.href='/${role}/disc_create'">
                            <br>
                            <br>
                            <input class="wideButton" type="submit" value="Modify existing discipline" name="modifyDiscipline" onclick="bulkOperation('modify', '/${role}/disc_modify')">
                            <br>
                            <br>
                            <input class="wideButton" type="submit" value="Delete discipline" name="deleteDiscipline" onclick="bulkOperation('delete', '/${role}/disc_list')">
                        </div>
                    </div>
                </div>
            </div>
        </div>
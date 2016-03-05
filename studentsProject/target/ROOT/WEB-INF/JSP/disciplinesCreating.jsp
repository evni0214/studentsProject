<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <div class="buttons">
                    <div style="float: left">
                        <a href="/${role}/home"> Go to main </a>
                    </div>
                    <div style="float: left; margin-left: 15px;">
                        <a href="/${role}/disc_list"> Previous page </a>
                    </div>
                    <div class="content">
                        <div class="titleTextStyle">
                            <a> Fill out the field and click "Create" to create new discipline. </a>
                        </div>
                        <br>
                        <br>
                        <form class="wideFormStyle" method="post">
                            <table width="350px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Name of new discipline </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <input type="text" name="disciplineName" id="disciplineName">
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <input class="smallButton" type="submit" value="Create" id="createDiscipline" onclick="validateFields('disciplineName')">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
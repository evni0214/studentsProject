<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <div class="buttons">
            <div class="content">
                <br>
                <br>
                <br>
                <br>
                <br>
                <form class="loginForm" action="/login" method="post">
                    <table width="250px">
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Login </a>
                            </td>
                            <td class="fieldColStyle">
                                <input type="text" class="mediumInputBoxStyle" name="login" id="login">
                            </td>
                        </tr>
                        <tr class="spaceRow"></tr>
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Password </a>
                            </td>
                            <td class="fieldColStyle">
                                <input type="text" class="mediumInputBoxStyle" name="password" id="password">
                            </td>
                        </tr>
                        <tr class="spaceRow"></tr>
                        <tr>
                            <td class="fieldLeftNameColStyle">
                                <a> Role </a>
                            </td>
                            <td class="fieldColStyle">
                                <select class="selectStyle" name="selectRole" id="selectRole">
                                    <c:forEach items="${rolesList}" var="role">
                                        <option> ${role.name} </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr class="spaceRow"></tr>
                        <tr class="spaceRow"></tr>
                    </table>
                    <table width="250px">
                        <tr>
                            <td class="fieldColStyle">
                                <input class="smallButton" type="submit" name="enter" id="enter" value="Login">
                            </td>
                        </tr>
                        <c:if test="${validation eq 'failed'}">
                            <c:if test="${errorCase eq 'userNotFound'}">
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td>
                                        <a class="warningText"> Incorrect username or password. </a>
                                    </td>
                                </tr>
                            </c:if>
                            <c:if test="${errorCase eq 'roleNotFound'}">
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td>
                                        <a class="warningText"> User does not have enough permissions to login as ${role}. </a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:if>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
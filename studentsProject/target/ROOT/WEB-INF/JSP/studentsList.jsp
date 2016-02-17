<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta charset="windows-1251">
    <title>Students list</title>
</head>

<style type="text/css">
    @import "/resources/css/style.css";
</style>

    <body>
        <div class="main">
            <div class="header">
                <div class="emptyTitle"></div>
                <div class="title"> The control system of students and their academic performance
                </div>
                <div class="logout"> <a href="https://google.com/"> Logout </a>
                </div>
            </div>
            <div class="pageElements">
                <div class="buttons">
                    <div style="float: left">
                        <a href="https://google.com/"> Go to main </a>
                    </div>
                    <div class="content">
                        <form method="post">
                            <table width="450px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <input type="submit" class="veryWideButton" value="View performance of particular students" name="viewStudent">
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <input type="submit" class="mediumButton" value="Create new student" name="crStudent">
                                    </td>
                                </tr>
                                <tr class="spaceRow"></tr>
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <input type="submit" class="veryWideButton" value="Modify existing student" name="modStudent">
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <input type="submit" class="mediumButton" value="Delete student" name="delStudent">
                                    </td>
                                </tr>
                            </table>
                        </form>
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
                            <tr>
                                <td class="checkBoxColumn"> <input type="checkbox" name="1"> </td>
                                <td> Петров </td>
                                <td> Петр </td>
                                <td> ИТ-01 </td>
                                <td> 28/01/2016 </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
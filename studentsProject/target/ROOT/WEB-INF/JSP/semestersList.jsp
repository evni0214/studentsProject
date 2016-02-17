<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta charset="windows-1251">
    <title>Semesters' list</title>
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
                    <div style="float: left; margin-left: 15px;">
                        <a href="https://google.com/"> Previous page </a>
                    </div>
                    <br>
                    <div class="content">
                        <form class="semesterListSelectForm">
                            <table width="400px">
                                <tr>
                                    <td class="fieldLeftNameColStyle">
                                        <a> Select semester </a>
                                    </td>
                                    <td class="fieldColStyle">
                                        <select class="selectStyle" name="listOfSemesters">
                                            <option> Семестр 1 </option>
                                        </select>
                                    </td>
                                    <td class="fieldLeftNameColStyle">
                                        <input class="smallButton" type="submit" value="Select" name="selectSemester">
                                    </td>
                                </tr>
                            </table>
                        </form>
                        <br>
                        <a class="textStyle" style="float: left;"> Duration of semester: "24 weeks" </a>
                        <br>
                        <br>
                        <br>
                        <br>
                        <div>
                            <a class="textStyle" style="float: left;"> List of semesters' disciplines: </a>
                        </div>
                        <br>
                        <br>
                        <table style="float: left;" width="285px" border="1">
                            <tr class="firstTableRow">
                                <td> Name of discipline </td>
                            </tr>
                            <tr class="tableTextStyle">
                                <td> Информатика </td>
                            </tr>
                        </table>
                        <form class="semesterListButtonForm">
                            <input class="wideButton" type="submit" value="Create new semester" name="newSemester">
                            <br>
                            <br>
                            <input class="wideButton" type="submit" value="Modify existing semester" name="modifySemester">
                            <br>
                            <br>
                            <input class="wideButton" type="submit" value="Delete semester" name="deleteSemester">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
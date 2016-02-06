import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Evgeny on 06.02.2016.
 */
public interface QueryInt {
    ResultSet studListSelectAllStudents() throws ClassNotFoundException, SQLException;
    void studListDeleteStudents();
    void studModUpdateStudent(String pFirstName, String pLastName, String pGroupId, Date pStartDate);
    void studCrInsertStudent(String pFirstName, String pLastName, String pGroupId, Date pStartDate);
    ResultSet studProgSelectStudent(long pStudentId);
    ResultSet studProgSelectMarksForStudent(long pStudentId);
    ResultSet studProgGetAVGMark(long pStudentId, String pSemesterName);
    ResultSet discListSelectAllDisciplines();
    void discListDeleteDiscipline();
    void discModUpdateDiscipline(String pDisciplineName);
    void discCrInsertDiscipline(String pDisciplineName);
    void generalSelectAllSemesters();
    ResultSet semListSelectDisciplinesBySemester(String pSemesterName);
    void semListDeleteSemester();
    void semCrInsertSemester(long pDuration, long... pListOfDisciplines);
    void semModUpdateSemester(long pDuration, long... pListOfDisciplines);

}

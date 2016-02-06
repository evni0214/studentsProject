import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Evgeny on 06.02.2016.
 */
public interface QueryInt {
    ResultSet studListSelectAllStudents() throws ClassNotFoundException, SQLException;
    void studListDeleteStudents(long... pStudentIDs) throws ClassNotFoundException, SQLException;
    void studModUpdateStudent(long pStudentId, String pFirstName, String pLastName, String pGroupId, Date pStartDate) throws ClassNotFoundException, SQLException;
    void studCrInsertStudent(String pFirstName, String pLastName, String pGroupId, Date pStartDate) throws ClassNotFoundException, SQLException;
    ResultSet studProgSelectStudent(long pStudentId) throws ClassNotFoundException, SQLException;
    ResultSet studProgSelectMarksForStudent(long pStudentId) throws ClassNotFoundException, SQLException;
    ResultSet studProgGetAVGMark(long pStudentId, String pSemesterName) throws ClassNotFoundException, SQLException;
    ResultSet discListSelectAllDisciplines() throws ClassNotFoundException, SQLException;
    void discListDeleteDiscipline();
    void discModUpdateDiscipline(String pDisciplineName);
    void discCrInsertDiscipline(String pDisciplineName);
    void generalSelectAllSemesters();
    ResultSet semListSelectDisciplinesBySemester(String pSemesterName);
    void semListDeleteSemester();
    void semCrInsertSemester(long pDuration, long... pListOfDisciplines);
    void semModUpdateSemester(long pDuration, long... pListOfDisciplines);

}

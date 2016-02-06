import java.sql.*;
import java.sql.Statement;

/**
 * Created by Evgeny on 06.02.2016.
 */
public class QueryImpl implements QueryInt {

    private String connectionString = "jdbc:mysql://127.0.0.1:3306/students?user=root&password=root&characterEncoding=UTF-8";
    private String jdbcDriver = "com.mysql.jdbc.Driver";

    public ResultSet studListSelectAllStudents() throws ClassNotFoundException, SQLException {

            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement query = conn.createStatement();
            ResultSet result = query.executeQuery("select * from students");
            return result;
    }

    public static void main(String[] args) {
        try {
            QueryImpl q = new QueryImpl();
            ResultSet res = q.studListSelectAllStudents();

            while(res.next()) {
                System.out.println(res.getLong("student_id"));
                System.out.println(res.getString("first_name"));
                System.out.println(res.getString("last_name"));
                System.out.println(res.getString("group_id"));
                System.out.println(res.getInt("status"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    public void studListDeleteStudents() {

    }

    public void studModUpdateStudent(String pFirstName, String pLastName, String pGroupId, Date pStartDate) {

    }

    public void studCrInsertStudent(String pFirstName, String pLastName, String pGroupId, Date pStartDate) {

    }

    public ResultSet studProgSelectStudent(long pStudentId) {
        return null;
    }

    public ResultSet studProgSelectMarksForStudent(long pStudentId) {
        return null;
    }

    public ResultSet studProgGetAVGMark(long pStudentId, String pSemesterName) {
        return null;
    }

    public ResultSet discListSelectAllDisciplines() {
        return null;
    }

    public void discListDeleteDiscipline() {

    }

    public void discModUpdateDiscipline(String pDisciplineName) {

    }

    public void discCrInsertDiscipline(String pDisciplineName) {

    }

    public void generalSelectAllSemesters() {

    }

    public ResultSet semListSelectDisciplinesBySemester(String pSemesterName) {
        return null;
    }

    public void semListDeleteSemester() {

    }

    public void semCrInsertSemester(long pDuration, long... pListOfDisciplines) {

    }

    public void semModUpdateSemester(long pDuration, long... pListOfDisciplines) {

    }
}

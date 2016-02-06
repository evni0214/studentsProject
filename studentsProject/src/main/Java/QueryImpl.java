import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public void studListDeleteStudents(long... pStudentIDs) throws ClassNotFoundException, SQLException {
//        Class.forName(jdbcDriver);
//        Connection conn = DriverManager.getConnection(connectionString);
//        conn.setAutoCommit(false);
//
//
//
//        PreparedStatement query = conn.prepareStatement("delete " +
//                "from students " +
//                "where student_id IN (?);");
//
//
//        query.setArray(1, (Array)pStudentIDs);
//        query.executeUpdate();
//        conn.commit();
    }

    public void studModUpdateStudent(long pStudentId, String pFirstName, String pLastName, String pGroupId, Date pStartDate) throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);
        Connection conn = DriverManager.getConnection(connectionString);
        conn.setAutoCommit(false);
        PreparedStatement query = conn.prepareStatement("update students " +
                "set first_name = ?, last_name = ?, group_id = ?, start_date = ?" +
                "where student_id = ?;");

        query.setString(1, pFirstName);
        query.setString(2, pLastName);
        query.setString(3, pGroupId);
        query.setDate(4, pStartDate);
        query.setLong(5, pStudentId);

        query.executeUpdate();
        conn.commit();
    }

    public void studCrInsertStudent(String pFirstName, String pLastName, String pGroupId, Date pStartDate) throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);
        Connection conn = DriverManager.getConnection(connectionString);
        conn.setAutoCommit(false);

        PreparedStatement query = conn.prepareStatement("insert " +
                "into students(first_name, last_name, group_id, start_date, status)" +
                "values(?, ?, ?, ?, ?);");

        query.setString(1, pFirstName);
        query.setString(2, pLastName);
        query.setString(3, pGroupId);
        query.setDate(4, pStartDate);
        query.setInt(5, 1);

        query.executeUpdate();
        conn.commit();
    }

    public ResultSet studProgSelectStudent(long pStudentId) throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);
        Connection conn = DriverManager.getConnection(connectionString);
        PreparedStatement query = conn.prepareStatement("select * from students where student_id = ?");
        query.setLong(1, pStudentId);
        ResultSet result = query.executeQuery();

        return result;
    }

    public ResultSet studProgSelectMarksForStudent(long pStudentId) throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);
        Connection conn = DriverManager.getConnection(connectionString);
        PreparedStatement query = conn.prepareStatement("select dl.discipline_name,\n" +
                "mr.mark\n" +
                "from marks mr join discipline_list dl\n" +
                "on mr.pair_id = dl.pair_id\n" +
                "where mr.student_id = ?;");

        query.setLong(1, pStudentId);
        ResultSet result = query.executeQuery();

        return result;
    }

    public ResultSet studProgGetAVGMark(long pStudentId, String pSemesterName) throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);
        Connection conn = DriverManager.getConnection(connectionString);

//        byte[] b = new byte[0];
//        try {
//            b = pSemesterName.getBytes("windows-1251");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        PreparedStatement query = conn.prepareStatement("select ROUND(AVG(mr.mark), 2) AVG_MARK " +
                "from marks mr join discipline_list dl " +
                "on mr.pair_id = dl.pair_id " +
                "where mr.student_id = ? and dl.semester_name = ?;");

        query.setLong(1, pStudentId);
        query.setString(2, pSemesterName);
//        query.setBytes(2, b);
        ResultSet result = query.executeQuery();

        return result;
    }

    public ResultSet discListSelectAllDisciplines() throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);
        Connection conn = DriverManager.getConnection(connectionString);
        PreparedStatement query = conn.prepareStatement("select * from disciplines;");
        ResultSet result = query.executeQuery();

        return result;
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

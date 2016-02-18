package database;

import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny on 18.02.2016.
 */
public class DBConnection {

    private Connection conn;
    private ResultSet rs;
    private static PreparedStatement selectAllStudents;

    public DBConnection(String DB_URL) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL);
            loadPreparedStatements();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Student> selectAllStudents(){
        rs = null;
        List<Student> result = new ArrayList<Student>();

        try {
            rs = selectAllStudents.executeQuery();
            while(rs.next()) {
                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setGroupId(rs.getString("group_id"));
                student.setStartDate(rs.getDate("start_date"));
                if(rs.getInt("status") == 1)
                    student.setStatus(true);
                else
                    student.setStatus(false);

                result.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void loadPreparedStatements(){
        try {
            selectAllStudents = conn.prepareStatement("select * from students where status = 1;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

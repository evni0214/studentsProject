package database;

import entity.Discipline;
import entity.Semester;
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
    private static PreparedStatement selectAllDisciplines;
    private static PreparedStatement selectAllSemesters;
    private static PreparedStatement insertStudent;
    private static PreparedStatement insertDiscipline;
    private static PreparedStatement insertSemester;
    private static PreparedStatement insertSemesterDisciplines;
    private static PreparedStatement deleteStudents;

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

    public List<Discipline> selectAllDisciplines() {
        rs = null;
        List<Discipline> result = new ArrayList<Discipline>();

        try {
            rs = selectAllDisciplines.executeQuery();

            while(rs.next()) {
                Discipline discipline = new Discipline();

                discipline.setDisciplineName(rs.getString("discipline_name"));
                result.add(discipline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Semester> selectAllSemesters() {
        rs = null;
        List<Semester> result = new ArrayList<Semester>();

        try {
            rs = selectAllSemesters.executeQuery();
            while (rs.next()) {
                Semester semester = new Semester();

                semester.setSemesterName(rs.getString("semester_name"));
                result.add(semester);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void insertStudent(Student student) {
        try {
            insertStudent.setString(1, student.getFirstName());
            insertStudent.setString(2, student.getLastName());
            insertStudent.setString(3, student.getGroupId());
            insertStudent.setDate(4, student.getStartDate());
            insertStudent.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDiscipline(Discipline discipline) {
        try {
            insertDiscipline.setString(1, discipline.getDisciplineName());
            insertDiscipline.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSemester(Semester semester) {
        try {
            insertSemester.setString(1, semester.getSemesterName());
            insertSemester.setLong(2, semester.getDuration());
            insertSemester.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSemesterDisciplines(Semester semester) {
        StringBuffer query = new StringBuffer("insert into discipline_list(semester_name, discipline_name) values ");
        for(Discipline currSemDisc : semester.getDisciplineList()) {
            query.append("('" + semester.getSemesterName() + "', '" + currSemDisc.getDisciplineName() + "'), ");
        }
        query.delete(query.length() - 2, query.length());
        query.append(";");

        try {
            insertSemesterDisciplines = conn.prepareStatement(query.toString());
            insertSemesterDisciplines.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudents(String[] studentIDs) {
        StringBuffer query = new StringBuffer("update students set status = 0 where student_id IN (");
        for(String currID : studentIDs) {
            query.append("?,");
        }
        query.delete(query.length() - 1, query.length());
        query.append(");");
        System.out.println(query.toString());

//        try {
//            insertSemesterDisciplines = conn.prepareStatement(query.toString());
//            insertSemesterDisciplines.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private void loadPreparedStatements(){
        try {
            selectAllStudents = conn.prepareStatement("select * from students where status = 1;");
            selectAllDisciplines = conn.prepareStatement("select * from disciplines;");
            selectAllSemesters = conn.prepareStatement("select semester_name from semesters;");
            insertStudent = conn.prepareStatement("insert into students(first_name, last_name, group_id, start_date, status) values (?, ?, ?, ?, 1);");
            insertDiscipline = conn.prepareStatement("insert into disciplines(discipline_name) values(?);");
            insertSemester = conn.prepareStatement("insert into semesters(semester_name, duration) values(?, ?);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

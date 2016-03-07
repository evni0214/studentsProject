package database;

import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static PreparedStatement selectSemesterIdByName;
    private static PreparedStatement insertSemesterDisciplines;
    private static PreparedStatement deleteStudents;
    private static PreparedStatement selectAllRoles;
    private static PreparedStatement validateUser;
    private static PreparedStatement validateRole;
    private static PreparedStatement selectStudentById;
    private static PreparedStatement updateStudent;
    private static PreparedStatement selectDisciplineById;
    private static PreparedStatement updateDiscipline;
    private static PreparedStatement deleteDisciplines;
    private static PreparedStatement selectSemesterById;
    private static PreparedStatement deleteSemesterById;
    private static PreparedStatement deleteDisciplinesBySemesterId;
    private static PreparedStatement updateSemesterById;
    private static PreparedStatement selectStudentMarksBySemester;

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
//        select * from students where status = 1;
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
//        select * from disciplines;
        rs = null;
        List<Discipline> result = new ArrayList<Discipline>();

        try {
            rs = selectAllDisciplines.executeQuery();

            while(rs.next()) {
                Discipline discipline = new Discipline();

                discipline.setDisciplineId(rs.getLong("discipline_id"));
                discipline.setName(rs.getString("name"));
                result.add(discipline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Semester> selectAllSemesters() {
//        select * from semesters;
        rs = null;
        List<Semester> result = new ArrayList<Semester>();

        try {
            rs = selectAllSemesters.executeQuery();
            while (rs.next()) {
                Semester semester = new Semester();
                semester.setSemesterId(rs.getLong("semester_id"));
                semester.setName(rs.getString("name"));
                result.add(semester);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void insertStudent(Student student) {
//        insert into students(first_name, last_name, group_id, start_date, status) values (?, ?, ?, ?, 1);
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
//        insert into disciplines(discipline_name) values(?);
        try {
            insertDiscipline.setString(1, discipline.getName());
            insertDiscipline.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long insertSemester(Semester semester) {
//        insert into semesters(name, duration) values(?, ?);
//        select semester_id from semesters where name = ?;
        rs = null;
        long result = 0;

        try {
            insertSemester.setString(1, semester.getName());
            insertSemester.setLong(2, semester.getDuration());
            insertSemester.executeUpdate();

            selectSemesterIdByName.setString(1, semester.getName());
            rs = selectSemesterIdByName.executeQuery();
            rs.next();
            result = rs.getLong("semester_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void insertSemesterDisciplines(Semester semester) {
        StringBuffer query = new StringBuffer("insert into discipline_list(semester_id, discipline_id) values ");
        for(Discipline currSemDisc : semester.getDisciplineList()) {
            query.append("('" + semester.getSemesterId() + "', '" + currSemDisc.getDisciplineId() + "'), ");
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
        int idCount = studentIDs.length;

        for(int i = 1; i <= idCount; i++) {
            query.append("?,");
        }

        query.delete(query.length() - 1, query.length());
        query.append(");");
        try {
            deleteStudents = conn.prepareStatement(query.toString());
            idCount = 1;
            for(String currID : studentIDs) {
                deleteStudents.setString(idCount, currID);
                idCount++;
            }
            deleteStudents.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Role> selectAllRoles() {
//        select * from roles;
        rs = null;
        List<Role> roles = new ArrayList<Role>();

        try {
            rs = selectAllRoles.executeQuery();
            while (rs.next()) {
                Role currentRole = new Role();

                currentRole.setName(rs.getString("name"));
                roles.add(currentRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    public Boolean validateUser(String username, String password) {
//        select * from users where username = ? and password = ?;
        rs = null;
        Boolean result = false;
        try {
            validateUser.setString(1, username);
            validateUser.setString(2, password);
            rs = validateUser.executeQuery();
            if(rs.next())
                result = true;
        } catch (SQLException e) {
            return result;
        }

        return result;
    }

    public Boolean validateRole(String username, String role) {
//        select * from user_roles where username = ? and role_id = (select role_id from roles where name = ?);
        rs = null;
        Boolean result = false;
        try {
            validateRole.setString(1, username);
            validateRole.setString(2, role);
            rs = validateRole.executeQuery();
            if(rs.next())
                result = true;
        } catch (SQLException e) {
            return result;
        }

        return result;
    }

    public Student selectStudentById(String student_id) {
//        select * from students where student_id = ?;
        rs = null;
        Student student = new Student();

        try {
            selectStudentById.setString(1, student_id);
            rs = selectStudentById.executeQuery();
            while(rs.next()) {
                student.setStudentId(rs.getLong("student_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setGroupId(rs.getString("group_id"));
                student.setStartDate(rs.getDate("start_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public void updateStudent(Student student) {
//        update students set first_name = ?, last_name = ?, group_id = ?, start_date = ? where student_id = ?;
        try {
            updateStudent.setString(1, student.getFirstName());
            updateStudent.setString(2, student.getLastName());
            updateStudent.setString(3, student.getGroupId());
            updateStudent.setDate(4, student.getStartDate());
            updateStudent.setLong(5, student.getStudentId());
            updateStudent.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Discipline selectDisciplineById(long disciplineId) {
//        select * from disciplines where discipline_id = ?;
        rs = null;
        Discipline result = new Discipline();
        try {
            selectDisciplineById.setLong(1, disciplineId);
            rs = selectDisciplineById.executeQuery();
            while (rs.next()) {
                result.setDisciplineId(rs.getLong("discipline_id"));
                result.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void updateDiscipline(Discipline oldName, Discipline newName) {
//        update disciplines set discipline_name = ? where discipline_name = ?;
        try {
            updateDiscipline.setString(1, newName.getName());
            updateDiscipline.setString(2, oldName.getName());
            updateDiscipline.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDisciplines(String[] disciplineIDs) {
//        delete from disciplines where discipline_id IN (?, ?, ... , ?);
        StringBuffer query = new StringBuffer("delete from disciplines where discipline_id IN (");
        int idCount = disciplineIDs.length;

        for(int i = 1; i <= idCount; i++) {
            query.append("?,");
        }

        query.delete(query.length() - 1, query.length());
        query.append(");");
        try {
            deleteDisciplines = conn.prepareStatement(query.toString());
            idCount = 1;
            for(String currID : disciplineIDs) {
                deleteDisciplines.setString(idCount, currID);
                idCount++;
            }
            deleteDisciplines.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Semester selectSemesterById(long semesterId) {
//        select s.semester_id,
//                s.name semester_name,
//                s.duration,
//                d.discipline_id,
//                d.name discipline_name
//        from discipline_list dl join semesters s
//        on dl.semester_id = s.semester_id
//        join disciplines d
//        on dl.discipline_id = d.discipline_id
//        where s.semester_id = ?;
        rs = null;
        Semester result = new Semester();
        List<Discipline> disciplineList = new ArrayList<Discipline>();

        try {
            selectSemesterById.setLong(1, semesterId);
            rs = selectSemesterById.executeQuery();
            while (rs.next()) {
                if(result.getSemesterId() == 0 || result.getName() == null || result.getDuration() == 0) {
                    result.setSemesterId(rs.getLong("semester_id"));
                    result.setName(rs.getString("semester_name"));
                    result.setDuration(rs.getLong("duration"));
                }
                Discipline discipline = new Discipline(rs.getLong("discipline_id"), rs.getString("discipline_name"));
                disciplineList.add(discipline);
            }
            result.setDisciplineList(disciplineList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void deleteSemesterById(Long semesterId) {
//        delete from semesters where semester_id = ?;
        try {
            deleteSemesterById.setLong(1, semesterId);
            deleteSemesterById.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDisciplinesBySemesterId(Long semesterId) {
//        delete from discipline_list where semester_id = ?;
        try {
            deleteDisciplinesBySemesterId.setLong(1, semesterId);
            deleteDisciplinesBySemesterId.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSemesterById(Semester semester) {
//        update semesters set name = ?, duration = ? where semester_id = ?;
        try {
            updateSemesterById.setString(1, semester.getName());
            updateSemesterById.setLong(2, semester.getDuration());
            updateSemesterById.setLong(3, semester.getSemesterId());
            updateSemesterById.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Discipline, Integer> selectStudentMarksBySemester(Student student, Long semesterId) {
//        select d.discipline_id, d.name, m.mark
//        from marks m join discipline_list dl
//        on m.pair_id = dl.pair_id
//        join disciplines d
//        on dl.discipline_id = d.discipline_id
//        where m.student_id = ? and dl.semester_id = ?;
        rs = null;
        Map<Discipline, Integer> studentsMarks = new HashMap<Discipline, Integer>();
        try {
            selectStudentMarksBySemester.setLong(1, student.getStudentId());
            selectStudentMarksBySemester.setLong(2, semesterId);
            rs = selectStudentMarksBySemester.executeQuery();
            while (rs.next()) {
                Discipline discipline = new Discipline(rs.getLong("discipline_id"), rs.getString("name"));
                studentsMarks.put(discipline, rs.getInt("mark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentsMarks;
    }

    private void loadPreparedStatements(){
        try {
            selectAllStudents = conn.prepareStatement("select * from students where status = 1;");
            selectAllDisciplines = conn.prepareStatement("select * from disciplines;");
            selectAllSemesters = conn.prepareStatement("select * from semesters;");
            insertStudent = conn.prepareStatement("insert into students(first_name, last_name, group_id, start_date, status) values (?, ?, ?, ?, 1);");
            insertDiscipline = conn.prepareStatement("insert into disciplines(name) values(?);");
            insertSemester = conn.prepareStatement("insert into semesters(name, duration) values(?, ?);");
            selectSemesterIdByName = conn.prepareStatement("select semester_id from semesters where name = ?;");
            selectAllRoles = conn.prepareStatement("select * from roles;");
            validateUser = conn.prepareStatement("select * from users where username = ? and password = ?;");
            validateRole = conn.prepareStatement("select * from user_roles where username = ? and role_id = (select role_id from roles where name = ?);");
            selectStudentById = conn.prepareStatement("select * from students where student_id = ?;");
            updateStudent = conn.prepareStatement("update students set first_name = ?, last_name = ?, group_id = ?, start_date = ? where student_id = ?;");
            selectDisciplineById = conn.prepareStatement("select * from disciplines where discipline_id = ?;");
            updateDiscipline = conn.prepareStatement("update disciplines set name = ? where name = ?;");
            selectSemesterById = conn.prepareStatement("SELECT s.semester_id,\n" +
                    "       s.name semester_name,\n" +
                    "       s.duration,\n" +
                    "       d.discipline_id,\n" +
                    "       d.name discipline_name\n" +
                    "FROM discipline_list dl JOIN semesters s\n" +
                    "ON dl.semester_id = s.semester_id\n" +
                    "JOIN disciplines d\n" +
                    "ON dl.discipline_id = d.discipline_id\n" +
                    "WHERE s.semester_id = ?;");
            deleteSemesterById = conn.prepareStatement("delete from semesters where semester_id = ?;");
            deleteDisciplinesBySemesterId = conn.prepareStatement("delete from discipline_list where semester_id = ?;");
            updateSemesterById = conn.prepareStatement("update semesters set name = ?, duration = ? where semester_id = ?;");
            selectStudentMarksBySemester = conn.prepareStatement("SELECT d.discipline_id, d.name, m.mark\n" +
                    "FROM marks m JOIN discipline_list dl\n" +
                    "ON m.pair_id = dl.pair_id\n" +
                    "JOIN disciplines d\n" +
                    "ON dl.discipline_id = d.discipline_id\n" +
                    "WHERE student_id = ? AND dl.semester_id = ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

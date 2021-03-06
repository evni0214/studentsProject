package database;

import constants.Constants;
import entity.Discipline;
import entity.Role;
import entity.Semester;
import entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny on 18.02.2016.
 */
public class DataService {
    private static List<DBConnection> connectionPool = new ArrayList<DBConnection>();

    public void init(){
        for(int i = 0; i < Constants.CONNECTION_POOL_SIZE; i++) {
            newConnection();
        }
    }

    private void newConnection(){
        DBConnection conn = new DBConnection(Constants.URL_TO_DATABASE);

        connectionPool.add(conn);
    }

    public List<Student> selectAllStudents(){
        DBConnection conn = connectionPool.remove(0);
        List<Student> result = conn.selectAllStudents();
        connectionPool.add(conn);

        return result;
    }

    public List<Discipline> selectAllDisciplines() {
        DBConnection conn = connectionPool.remove(0);
        List<Discipline> result = conn.selectAllDisciplines();
        connectionPool.add(conn);

        return result;
    }

    public List<Semester> selectAllSemesters() {
        DBConnection conn = connectionPool.remove(0);
        List<Semester> result = conn.selectAllSemesters();
        connectionPool.add(conn);

        return result;
    }

    public void insertStudent(Student student) {
        DBConnection conn = connectionPool.remove(0);
        conn.insertStudent(student);
        connectionPool.add(conn);
    }

    public void insertDiscipline(Discipline discipline) {
        DBConnection conn = connectionPool.remove(0);
        conn.insertDiscipline(discipline);
        connectionPool.add(conn);
    }

    public long insertSemester(Semester semester) {
        DBConnection conn = connectionPool.remove(0);
        long result = conn.insertSemester(semester);
        connectionPool.add(conn);

        return result;
    }

    public void insertSemesterDisciplines(Semester semester) {
        DBConnection conn = connectionPool.remove(0);
        conn.insertSemesterDisciplines(semester);
        connectionPool.add(conn);
    }

    public void deleteStudents(String[] studentIDs)     {
        DBConnection conn = connectionPool.remove(0);
        conn.deleteStudents(studentIDs);
        connectionPool.add(conn);
    }

    public List<Role> selectAllRoles() {
        DBConnection conn = connectionPool.remove(0);
        List<Role> result = conn.selectAllRoles();
        connectionPool.add(conn);

        return result;
    }

    public Boolean validateUser(String username, String password) {
        DBConnection conn = connectionPool.remove(0);
        Boolean result = conn.validateUser(username, password);
        connectionPool.add(conn);

        return result;
    }

    public Boolean validateRole(String username, String role) {
        DBConnection conn = connectionPool.remove(0);
        Boolean result = conn.validateRole(username, role);
        connectionPool.add(conn);

        return result;
    }

    public Student selectStudentById(Long student_id) {
        DBConnection conn = connectionPool.remove(0);
        Student result = conn.selectStudentById(student_id);
        connectionPool.add(conn);

        return result;
    }

    public void updateStudent(Student student) {
        DBConnection conn = connectionPool.remove(0);
        conn.updateStudent(student);
        connectionPool.add(conn);
    }

    public Discipline selectDisciplineById(long disciplineId) {
        DBConnection conn = connectionPool.remove(0);
        Discipline result = conn.selectDisciplineById(disciplineId);
        connectionPool.add(conn);

        return result;
    }

    public void updateDiscipline(Discipline oldName, Discipline newName) {
        DBConnection conn = connectionPool.remove(0);
        conn.updateDiscipline(oldName, newName);
        connectionPool.add(conn);
    }

    public void deleteDisciplines(String[] disciplineIDs) {
        DBConnection conn = connectionPool.remove(0);
        conn.deleteDisciplines(disciplineIDs);
        connectionPool.add(conn);
    }

    public Semester selectSemesterById(long semesterId) {
        DBConnection conn = connectionPool.remove(0);
        Semester result = conn.selectSemesterById(semesterId);
        connectionPool.add(conn);

        return result;
    }

    public void deleteSemesterById(Long semesterId) {
        DBConnection conn = connectionPool.remove(0);
        conn.deleteSemesterById(semesterId);
        connectionPool.add(conn);
    }

    public void deleteDisciplinesBySemesterId(Long semesterId) {
        DBConnection conn = connectionPool.remove(0);
        conn.deleteDisciplinesBySemesterId(semesterId);
        connectionPool.add(conn);
    }

    public void updateSemesterById(Semester semester) {
        DBConnection conn = connectionPool.remove(0);
        conn.updateSemesterById(semester);
        connectionPool.add(conn);
    }

    public Map<Discipline, Integer> selectStudentMarksBySemester(Student student, Long semesterId) {
        DBConnection conn = connectionPool.remove(0);
        Map<Discipline, Integer> result = conn.selectStudentMarksBySemester(student, semesterId);
        connectionPool.add(conn);

        return result;
    }

    public Map<Discipline, Integer> selectAllStudentMarksBySemester(Student student, Long semesterId) {
        DBConnection conn = connectionPool.remove(0);
        Map<Discipline, Integer> result = conn.selectAllStudentMarksBySemester(student, semesterId);
        connectionPool.add(conn);

        return result;
    }

    public Integer selectParticularMark(Long studentId, Long disciplineId, Long semesterId) {
        DBConnection conn = connectionPool.remove(0);
        Integer result = conn.selectParticularMark(studentId, disciplineId, semesterId);
        connectionPool.add(conn);

        return result;
    }

    public void updateParticularMark(Long studentId, Long pairId, Integer mark) {
        DBConnection conn = connectionPool.remove(0);
        conn.updateParticularMark(studentId, pairId, mark);
        connectionPool.add(conn);
    }

}

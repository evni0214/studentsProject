package database;

import constants.Constants;
import entity.Discipline;
import entity.Semester;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

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

    public void insertSemester(Semester semester) {
        DBConnection conn = connectionPool.remove(0);
        conn.insertSemester(semester);
        connectionPool.add(conn);
    }

    public void insertSemesterDisciplines(Semester semester) {
        DBConnection conn = connectionPool.remove(0);
        conn.insertSemesterDisciplines(semester);
        connectionPool.add(conn);
    }

}
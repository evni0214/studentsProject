package database;

import constants.Constants;
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

}

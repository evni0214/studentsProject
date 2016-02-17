package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Evgeny on 06.02.2016.
 */
public class QueryTest {
    public static void main(String[] args) {
        try {
            QueryImpl q = new QueryImpl();
            ResultSet res = q.studListSelectAllStudents();
            while(res.next()) {
                System.out.print(res.getLong("student_id") + ", ");
                System.out.print(res.getString("first_name") + ", ");
                System.out.print(res.getString("last_name") + ", ");
                System.out.print(res.getString("group_id") + ", ");
                System.out.print(res.getInt("status") + ";");
                System.out.println("");
            }

//            q.studCrInsertStudent("Kolya", "Dolzhanski", "QQ-01", currDate);

//            java.sql.Date currDate = new Date(Calendar.getInstance().getTimeInMillis());
//            q.studModUpdateStudent(13, "Nikolay", "GG", "QW-01", currDate);

            res = q.studProgSelectStudent(13);
            while(res.next()) {
                System.out.print(res.getLong("student_id") + ", ");
                System.out.print(res.getString("first_name") + ", ");
                System.out.print(res.getString("last_name") + ", ");
                System.out.print(res.getString("group_id") + ", ");
                System.out.print(res.getInt("status") + ";");
                System.out.println("");
            }

            res = q.studProgSelectMarksForStudent(5);
            while(res.next()) {
                System.out.print(res.getString("dl.discipline_name") + ", ");
                System.out.print(res.getInt("mr.mark") + ";");
                System.out.println("");
            }

            res = q.studProgGetAVGMark(5, "Семестр 1");
            while(res.next()) {
                System.out.print(res.getString("AVG_MARK") + ";");
                System.out.println("");
            }

            res = q.discListSelectAllDisciplines();
            while(res.next()) {
                System.out.print(res.getString("discipline_name") + ";");
                System.out.println("");
            }

            q.studListDeleteStudents(2, 3, 5, 6);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

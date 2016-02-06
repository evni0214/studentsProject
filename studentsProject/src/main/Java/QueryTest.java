import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by Evgeny on 06.02.2016.
 */
public class QueryTest {
    public static void main(String[] args) {
        try {
            QueryImpl q = new QueryImpl();
            ResultSet res = q.studListSelectAllStudents();
//            while(res.next()) {
//                System.out.print(res.getLong("student_id") + ", ");
//                System.out.print(res.getString("first_name") + ", ");
//                System.out.print(res.getString("last_name") + ", ");
//                System.out.print(res.getString("group_id") + ", ");
//                System.out.print(res.getInt("status") + ";");
//                System.out.println("");
//            }

//            q.studCrInsertStudent("Kolya", "Dolzhanski", "QQ-01", currDate);

//            java.sql.Date currDate = new Date(Calendar.getInstance().getTimeInMillis());
//            q.studModUpdateStudent(13, "Nikolay", "GG", "QW-01", currDate);

//            res = q.studProgSelectStudent(13);
//            while(res.next()) {
//                System.out.print(res.getLong("student_id") + ", ");
//                System.out.print(res.getString("first_name") + ", ");
//                System.out.print(res.getString("last_name") + ", ");
//                System.out.print(res.getString("group_id") + ", ");
//                System.out.print(res.getInt("status") + ";");
//                System.out.println("");
//            }

//            res = q.studProgSelectMarksForStudent(5);
//            while(res.next()) {
//                System.out.print(res.getString("dl.discipline_name") + ", ");
//                System.out.print(res.getInt("mr.mark") + ";");
//                System.out.println("");
//            }

//            res = q.studProgGetAVGMark(5, "Семестр 1");
//            while(res.next()) {
//                System.out.print(res.getInt("AVG_MARK") + ";");
//                System.out.println("");
//            }

//            res = q.discListSelectAllDisciplines();
//            while(res.next()) {
//                System.out.print(res.getString("discipline_name") + ";");
//                System.out.println("");
//            }



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

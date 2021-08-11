import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery("SELECT name, " +
                    "COUNT(sub_s.subscription_date)/(TIMESTAMPDIFF(MONTH, " +
                    "MIN(sub_s.subscription_date)," +
                    "MAX(sub_s.subscription_date))) AS averageNumberOfPurchases " +
                    "FROM Subscriptions sub_s LEFT JOIN Courses course ON course.id = sub_s.course_id GROUP BY course.name;")) {

                while (resultSet.next()) {
                    String courseName = resultSet.getString("name");
                    String averageNumberOfPurchases = resultSet.getString("averageNumberOfPurchases");
                    System.out.println(courseName + " : " + averageNumberOfPurchases);
                }
            } catch (SQLSyntaxErrorException exception) {
                exception.printStackTrace();
            }
            statement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

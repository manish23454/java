import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaDataBaseTest {
    public static void main(String[] args) {
        //crteating the prerequres of the connection of the database
        String link = "jdbc:mysql://localhost:3306/university";
        String user = "root";
        String password = "manish#9819684318";
        String query  = "select * from college";


        //creating the connection
        try{
            Connection connection =  DriverManager.getConnection(link,user,password);
            System.out.println("Connection Established");
            Statement statement = connection.createStatement();
            System.out.println("statement created");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Executing the query ResultSet created");
            System.out.println("here is the data......");
            while (resultSet.next()){
                String universityData = "";
                for(int i = 1; i<=resultSet.getMetaData().getColumnCount();i++){
                    universityData += resultSet.getString(i) + ":";
                }
                System.out.println(universityData);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

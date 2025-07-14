import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDataBase {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        }catch (Exception e){
            e.printStackTrace();
        }

        //the main code for the connection for the database
        try{
            Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/university","manish","manish#9819684318");
            System.out.println("Connection Established");
            Statement statement = connection.createStatement();
            System.out.println("statement created");
            statement.executeUpdate("insert into student(name,age,marks) values('biru','20','99')");
            System.out.println("Data inserted");
            System.out.println("the data is.......");
            ResultSet resultSet= statement.executeQuery("select * from student");
            for(int i = 1; i<=resultSet.getMetaData().getColumnCount();i++){
                System.out.print(resultSet.getMetaData().getColumnName(i));}
            System.out.println();
            while (resultSet.next()){

                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)+" "+resultSet.getString(4));
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

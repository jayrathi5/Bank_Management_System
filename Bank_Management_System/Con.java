package Bank_Management_System;
import java.sql.*;
public class Con {
    Connection connection;
    Statement statement;
    Con()
    {
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_System","jay","9016335246");
            statement=connection.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

package bank.management.system;

import java.sql.*;

public class Conn {


    Connection c ;
    Statement s;

    public Conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//Register Driver //no need to register the driver java will do it own since to add jar file
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Sql@2025$");//create connection
            s = c.createStatement();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

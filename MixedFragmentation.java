import java.util.*;
import java.sql.*;
class MixedFragmentation {
public static void main(String args[]) {

    

    Scanner sc=new Scanner(System.in);
    System.out.println("Enter table name as fbuser:");
    String tname=sc.nextLine();

    System.out.println("Enter user_id from one of the 1,2,3,14,15:");
       int a=sc.nextInt();
    

    try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@DESKTOP-QSNCN8S:1521:orcl","system","a1234");  
  

    Statement stmt=con.createStatement();
    ResultSet rs110=stmt.executeQuery("drop table fbuser21");
    ResultSet rs20=stmt.executeQuery("create table fbuser21 as SELECT  * FROM " +tname+ " WHERE user_id <="+a );
    ResultSet rs30=stmt.executeQuery("select * from fbuser21");
System.out.println("table1 is:");
    System.out.println("user_id"+" "+" name"+"   "+" phone"+"      "+"address");

System.out.println("___________________________________");

    while(rs30.next())
    System.out.println(rs30.getInt(1)+"	"+rs30.getString(2)+" 	"+rs30.getInt(3)+"	"+rs30.getString(4));

    ResultSet rs111=stmt.executeQuery("drop table fbuser1");
    ResultSet rs222=stmt.executeQuery(" create table fbuser1 as SELECT user_id,name FROM "+tname + " WHERE user_id <="+a);
    ResultSet rs333=stmt.executeQuery("select * from fbuser1");
System.out.println("table2 is:");
       System.out.println("user_id"+" "+"name");
System.out.println("______________________");
    while(rs333.next())
    System.out.println(rs333.getInt(1)+"	"+rs333.getString(2));
    con.close();    
    }
    catch(Exception e){System.out.println(e);}
}
}

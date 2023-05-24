import java.util.*;
import java.sql.*;
class HorFragment{
public static void main(String args[]) {

    Scanner sc=new Scanner(System.in);
    System.out.println("Enter table name as age_group1 :");
    String tname=sc.nextLine();

    System.out.println("Enter active hours from 2,3,6:");
    String a=sc.nextLine();
   try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@DESKTOP-QSNCN8S:1521:orcl","system","a1234");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  
    ResultSet rs2=stmt.executeQuery("drop table age_group01");
    ResultSet rs=stmt.executeQuery(" create table age_group01 as select * from "+tname+" where active_hrs>="+a);
    ResultSet rs1=stmt.executeQuery("select * from age_group01 ");
System.out.println("age_group01  table as below:");
System.out.println("user_id"+" |"+" avg_no_of_friends"+"  |"+"active_hrs ");
System.out.println("------------------------------------");

       
    while(rs1.next())
    System.out.println(rs1.getInt(1)+" 		"+rs1.getInt(2)+" 		"+rs1.getInt(3));

ResultSet rs11=stmt.executeQuery("drop table age_group22");
    ResultSet rs22=stmt.executeQuery(" create table age_group22 as SELECT * FROM "+tname+" WHERE active_hrs<"+a);
    ResultSet rs33=stmt.executeQuery("select * from age_group22");
    System.out.println("remaining records are as age_group22  table as below:");
System.out.println("user_id"+" |"+" avg_no_of_friends"+"  |"+"active_hrs ");
System.out.println("------------------------------------");
           while(rs33.next())
    System.out.println(rs33.getInt(1)+" 		"+rs33.getInt(2)+"		 "+rs33.getInt(3));
    con.close(); 

  

      
    }
    catch(Exception e){System.out.println(e);}
}
}

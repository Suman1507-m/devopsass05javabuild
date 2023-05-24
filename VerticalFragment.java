import java.sql.*;
import java.util.*;
class VerticalFragment{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
System.out.println("Enter table name page2 :\n");
String tname=sc.nextLine();

try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@DESKTOP-QSNCN8S:1521:orcl","system","a1234");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  

//ResultSet rs3=stmt.executeQuery("drop table page21");
ResultSet rs1=stmt.executeQuery("create table page21 as select user_id,company_count,month_of_creation  from "+tname);
ResultSet rs4=stmt.executeQuery("select * from page21");
System.out.println("page21 is as follows");
System.out.println("user_id"+"|"+"company_count"+" |"+" month_of_creation");
System.out.println("------------------------------------");

while(rs4.next())
System.out.println(rs4.getInt(1)+"		"+rs4.getInt(2)+"		"+rs4.getInt(3));

 //ResultSet rs11=stmt.executeQuery("drop table page23");
    ResultSet rs22=stmt.executeQuery(" create table page23 as SELECT user_id,createdBy FROM "+tname );
    ResultSet rs33=stmt.executeQuery("select * from page23");
       System.out.println("page23 is as follows");
System.out.println("user_id"+"    "+"createdBy");
System.out.println("------------------------------------");

    while(rs33.next())
    System.out.println(rs33.getInt(1)+"	"+rs33.getString(2));

con.close();
}catch(Exception e){System.out.println(e);
}
}
}

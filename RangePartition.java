import java.util.*;
import java.sql.*;
class RangePartition {
public static void main(String args[]) {

	Scanner sc=new Scanner(System.in);
	System.out.println("Enter table name as age_group1:");
	String tname=sc.nextLine();

	System.out.println("Enter age range from 18,20,30,40,50,60:");
	int s1=sc.nextInt();
	int s2=sc.nextInt();
	try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@DESKTOP-QSNCN8S:1521:orcl","system","a1234");  
  
//step3 create the statement object  
Statement stmt=con.createStatement(); 
	ResultSet rs1=stmt.executeQuery("drop table R1");
	ResultSet rs2=stmt.executeQuery(" create table R1 as SELECT * FROM "+tname+" WHERE user_id<"+s1);
	ResultSet rs3=stmt.executeQuery("select * from R1");
        System.out.println("\nR1 table at Disk0:\n");
System.out.println("user_id"+"     "+"avg_no_of_friends"+" "+"active_hrs");
System.out.println("---------------------------------");
	
       	while(rs3.next())
	System.out.println(rs3.getInt(1)+" "+rs3.getInt(2)+"			 "+rs3.getInt(3));

 	ResultSet rs11=stmt.executeQuery("drop table R2");
	ResultSet rs22=stmt.executeQuery(" create table R2 as SELECT * FROM "+tname+" WHERE user_id>="+s1+"and user_id<"+s2);
	ResultSet rs33=stmt.executeQuery("select * from R2");
	System.out.println("\nR2 table at Disk1:\n");
	System.out.println("user_id"+"      "+"avg_no_of_friends"+" "+"active_hrs");
System.out.println("---------------------------------");
       	while(rs33.next())
	System.out.println(rs33.getInt(1)+"   "+rs33.getInt(2)+"  		 "+rs33.getInt(3));
	ResultSet rs111=stmt.executeQuery("drop table R3");
	ResultSet rs222=stmt.executeQuery(" create table R3 as SELECT * FROM "+tname+" WHERE user_id>="+s2);
	ResultSet rs333=stmt.executeQuery("select * from R3");
	System.out.println("\nR3 table at Disk2:\n");
	System.out.println("user_id"+"     "+"avg_no_of_friends"+"   "+"active_hrs");
System.out.println("---------------------------------");
       	while(rs333.next())
	System.out.println(rs333.getInt(1)+"   "+rs333.getInt(2)+" 			 "+rs333.getInt(3));

	con.close();	

	}
	catch(Exception e){System.out.println(e);}
}
}


 


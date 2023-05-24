import java.sql.*;  
import java.util.*;
class ExternalMergeSort{  
public static void main(String args[]){ 
	Scanner sc= new Scanner(System.in) ;
	System.out.println("Parallel External Merge Sort of age_group1   Table");
	System.out.println("****************");
	System.out.println("Enter avg_no_of_friends in range(2 range) from these values:100,500,1000");
	int s1=sc.nextInt();
	int s2=sc.nextInt();
	
	
try{  
 
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@DESKTOP-QSNCN8S:1521:orcl","system","a1234");  
  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("drop table range_table1");
ResultSet rs2=stmt.executeQuery("create table range_table1 as select * from age_group1 where avg_no_of_friends< "+s1); 
ResultSet rs1=stmt.executeQuery("select * from range_table1"); 
System.out.println("Fragment 1 contains avg_no_of_friends less than "+s1);
System.out.println("****************************");
while(rs1.next())  
System.out.println(rs1.getInt(1)+"  "+rs1.getInt(2)+"  "+rs1.getInt(3));  

ResultSet rs11=stmt.executeQuery("drop table range_table2");
ResultSet rs22=stmt.executeQuery("create table range_table2 as select * from age_group1 where avg_no_of_friends>="+s1+" and avg_no_of_friends<"+s2); 
ResultSet rs33=stmt.executeQuery("select * from range_table2"); 

System.out.println("\nFragment 2 contains avg_no_of_friends greater than equals to:"+s1+" and avg_no_of_friends less than "+s2);
System.out.println("****************************");
while(rs33.next())  
System.out.println(rs33.getInt(1)+"  "+rs33.getInt(2)+"  "+rs33.getInt(3));

ResultSet rs111=stmt.executeQuery("drop table range_table3");
ResultSet rs222=stmt.executeQuery("create table range_table3 as select * from age_group1 where avg_no_of_friends>="+s2); 
ResultSet rs333=stmt.executeQuery("select * from range_table3"); 

System.out.println("\nFragment 3 contains avg_no_of_friends greater than equals to "+s2);
System.out.println("****************************");
while(rs333.next())  
System.out.println(rs333.getInt(1)+"  "+rs333.getInt(2)+"  "+rs333.getInt(3));


ResultSet rs4=stmt.executeQuery("drop table merge1");
ResultSet rs5=stmt.executeQuery("create table merge1 as select user_id ,avg_no_of_friends , active_hrs  from range_table1 union all select user_id ,avg_no_of_friends , active_hrs from range_table2 order by avg_no_of_friends"); 
ResultSet rs6=stmt.executeQuery("select * from merge1"); 

System.out.println("\nMerge the records of disk1 and disk2:");
System.out.println("****************************");
while(rs6.next())  
System.out.println(rs6.getInt(1)+"  "+rs6.getInt(2)+"  "+rs6.getInt(3));

//ResultSet rs7=stmt.executeQuery("drop table merge2");
ResultSet rs8=stmt.executeQuery("create table merge2 as select user_id ,avg_no_of_friends , active_hrs from merge1 union all select user_id ,avg_no_of_friends , active_hrs from range_emp3 order by avg_no_of_friends"); 
ResultSet rs9=stmt.executeQuery("select * from merge2"); 

System.out.println("\nMerge the records merge1 and disk3:");
System.out.println("****************************");
while(rs9.next())  
System.out.println(rs9.getInt(1)+"  "+rs9.getInt(2)+"  "+rs9.getInt(3));
 con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}
import java.sql.*;

import java.util.*;

class SemiJoin{

public static void main(String[]args){ 
Scanner sc= new Scanner(System.in);

System.out.println("we are performing semi join on tables : fbuser and page2:\n");
// String tname=sc.nextLine();

//System.out.println("Enter user_id from 1,2,3,14,15 :\n");
// int id=sc.nextInt();

try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@DESKTOP-QSNCN8S:1521:orcl","system","a1234");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  


ResultSet rs1=stmt.executeQuery("drop table temp1");

ResultSet rs2=stmt.executeQuery("Create table temp1 as select s.user_id from page2 s,fbuser c where s.user_id=c.user_id"); 
ResultSet rs3=stmt.executeQuery("select * from temp1");

System.out.println("temp1 table as below:");
System.out.println("user_id");
System.out.println("----------");

while(rs3.next())
{
System.out.println(rs3.getInt(1));

}
ResultSet rs11=stmt.executeQuery("drop table temp2");

ResultSet rs22=stmt.executeQuery("Create table temp2 as select t.company_count, t.month_of_creation,t.createdBy,c.user_id from page2 t, fbuser c where t.user_id=c.user_id");




ResultSet rs33=stmt.executeQuery("select * from temp2");
 System.out.println("temp2 table as below:");
System.out.println("company_count"+" |"+" month_of_creation"+"|        "+"createdBy"+"       |"+"user_id");
System.out.println("------------------------------------");
while(rs33.next())
{
System.out.println(rs33.getInt(1)+"			"+rs33.getInt(2)+"			"+rs33.getString(3)+"		"+rs33.getInt(4));
}
ResultSet rs111=stmt.executeQuery("drop table output");

ResultSet rs222=stmt.executeQuery("create table output as select tt.user_id,tt.name,tt.phone,tt.address,s.company_count,s.month_of_creation,s.createdBy from fbuser tt,page2 s where tt.user_id=s.user_id");
 ResultSet rs333=stmt.executeQuery("select * from output");

System.out.println("output table as below:");
System.out.println("user_id"+"| "+"name"+"    |"+"phone"+" |" +"address"+"| "+"company_count"+"		"+" month_of_creation"+"		"+"createdBy"+" ");
System.out.println("-----------------------------------------------------");


while(rs333.next())
{
System.out.println(rs333.getInt(1)+"|    "+rs333.getString(2)+"|  "+rs333.getInt(3)+"| "+rs333.getString(4)+"|    "+rs333.getInt(5)+" |                 "+rs333.getInt(6)+"                 | "+rs333.getString(7));
}
con.close();
}
catch(Exception e){System.out.println(e);
}
}
}

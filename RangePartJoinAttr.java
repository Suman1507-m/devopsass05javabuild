import java.util.*;
import java.sql.*;
class RangePartJoinAttr {
public static void main(String args[]) {

Scanner sc=new Scanner(System.in);
System.out.println("Enter table name as page4:");
String tname=sc.nextLine();

System.out.println("Enter user id range from 1,2,3,14,15:");
int s1=sc.nextInt();
int s2=sc.nextInt();

try{
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
 
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@DESKTOP-QSNCN8S:1521:orcl","system","a1234");  
  
Statement stmt=con.createStatement(); 
ResultSet rs1=stmt.executeQuery("drop table R1");
ResultSet rs2=stmt.executeQuery(" create table R1 as SELECT * FROM "+tname+" WHERE user_id<"+s1);
ResultSet rs3=stmt.executeQuery("select * from R1");
System.out.println("\nR1 table at Disk0:\n");
System.out.println("user_id"+"		"+"county ");
System.out.println("---------------------------------");

while(rs3.next())
System.out.println(rs3.getInt(1)+"		"+rs3.getInt(2));

ResultSet rs7=stmt.executeQuery("drop table R2");
ResultSet rs8=stmt.executeQuery(" create table R2 as SELECT * FROM "+tname+" WHERE user_id>="+s2);
ResultSet rs9=stmt.executeQuery("select * from R2");
System.out.println("\nR2 table at Disk1:\n");
System.out.println("user_id"+"		"+"county ");
System.out.println("---------------------------------");
 while(rs9.next())
System.out.println(rs9.getInt(1)+"		"+rs9.getInt(2));

Scanner sc1=new Scanner(System.in);
System.out.println("\nEnter table name as page5:");
String tname1=sc1.nextLine();

System.out.println("Enter user id range from 1,2,3,14,15:");
int s3=sc1.nextInt();
int s4=sc1.nextInt();

ResultSet rs11=stmt.executeQuery("drop table C1");
ResultSet rs22=stmt.executeQuery(" create table C1 as SELECT * FROM "+tname1+" WHERE person_id<"+s3);
ResultSet rs33=stmt.executeQuery("select * from C1");
        System.out.println("\nC1 table at Disk0:\n");
System.out.println("person_id"+"  	    "+"no_of_likes ");
System.out.println("---------------------------------");

        

while(rs33.next())
System.out.println(rs33.getInt(1)+"   	        "+rs33.getInt(2));

ResultSet rs77=stmt.executeQuery("drop table C2");
ResultSet rs88=stmt.executeQuery(" create table C2 as SELECT * FROM "+tname1+" WHERE person_id>="+s4);
ResultSet rs99=stmt.executeQuery("select * from C2");
System.out.println("\nC2 table at Disk1:\n");
System.out.println("person_id"+"      "+"no_of_likes ");
System.out.println("---------------------------------");
while(rs99.next())
System.out.println(rs99.getInt(1)+"   	        "+rs99.getInt(2));

ResultSet res12=stmt.executeQuery("drop table DC1");
	ResultSet rs13=stmt.executeQuery("create table DC1 as select d.user_id,d.county,c.person_id,c.no_of_likes from R1 d,C1 c where d.user_id=c.person_id");
	ResultSet rs14=stmt.executeQuery("select * from DC1");
        System.out.println("\nR1 join C1:\n");
	System.out.println("user_id		country		person_id			no_of_likes");
	while(rs14.next()){
	System.out.println(rs14.getInt(1)+"		"+rs14.getInt(2)+"		"+rs14.getInt(3)+"		"+rs14.getInt(4));
	}
	ResultSet res15=stmt.executeQuery("drop table DC2");
	ResultSet rs16=stmt.executeQuery("create table DC2 as select d.user_id,d.county,c.person_id,c.no_of_likes from R2 d,C2 c where d.user_id=c.person_id");
	ResultSet rs17=stmt.executeQuery("select * from DC2");
        System.out.println("\nR2 join C2:\n");
	System.out.println("user_id        country            person_id          no_of_likes");
	while(rs17.next()){
	System.out.println(rs17.getInt(1)+"  	        "+rs17.getInt(2)+"       	   "+rs17.getInt(3)+"       	   "+rs17.getInt(4));
	}
	ResultSet res18=stmt.executeQuery("drop table Output1");
	ResultSet rs19=stmt.executeQuery("create table Output1 as select * from DC1 union all select * from DC2");
	ResultSet rs20=stmt.executeQuery("select * from Output1");
        System.out.println("\nFinal Output1 as below (joining the ouputs of above :\n");
	System.out.println("user_id		country		person_id		no_of_likes");
	while(rs20.next()){
	System.out.println(rs20.getInt(1)+"		"+rs20.getInt(2)+"		"+rs20.getInt(3)+"		"+rs20.getInt(4));
	}
	con.close();	

	}
	catch(Exception e)
	{System.out.println(e);}
}
}



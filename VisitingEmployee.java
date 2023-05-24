import p1.*;
class VisitingEmployee extends Employee{
	int hours;
	VisitingEmployee(int i,String x,int s,int h)
	{
		super(i,x,s);
		hours=h;
	}
	protected void display()
	{
		System.out.println("id is:"+id+"name is :"+name+"salary is :"+salary+"hours is :"+hours);
	}

public static void main(String args[])
{
	VisitingEmployee v=new VisitingEmployee(1,"abc",3000000,8);
	v.display();
}
}
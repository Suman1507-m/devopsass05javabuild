package p1;
public class Employee{
	public int id;
	public String name;
	protected int salary;
	public Employee(int i,String x,int s)
	{
		id=i;
		name=x;
		salary=s;
	}
	protected void display()
	{
		System.out.println("id is:"+id+"name is :"+name+"salary is :"+salary);
	}
}

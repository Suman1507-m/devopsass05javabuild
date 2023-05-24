import java.util.*;
class ArrayListDemo{
	public static void main(String args[]){
		ArrayList<Integer> al=new ArrayList<Integer>();
		int i;
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		System.out.println("ArrayList elements:"+al);

		al.add(3,50);
		Iterator<Integer> it=al.iterator();
		System.out.println("ArrayList elements:");

		while(it.hasNext()){
			System.out.println(it.next());
		}

		System.out.println("Elements in the arraylist are:"+al.size());
		
		System.out.println("Index of 10: "+al.indexOf(10));
  		System.out.println("Index of 20: "+al.indexOf(20));
  		System.out.println("Index of 30: "+al.indexOf(30));
  		System.out.println("Index of 40: "+al.indexOf(40));
  		System.out.println("Index of 40: "+al.indexOf(50));
		
		System.out.println("40 is present or not: "+al.contains(40));
		System.out.println("60 is present or not : "+al.contains(60));
		//al.remove(new Integer(30));
		al.remove(2);
		System.out.println("ArrayList after removing 30 and an element from position 2:");
		for(Integer e:al){
			System.out.println(e);
		}
	}
}

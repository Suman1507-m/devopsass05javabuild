import java.io.*;

class WriteBytesFile
{
  	public static void main(String args[]){
		
		FileInputStream ins = null;  
		FileOutputStream outs = null;
		try{
			ins = new FileInputStream("input.txt");
			outs = new FileOutputStream("output.txt");
			int b;
			while((b = ins.read()) != -1)
			{
				outs.write(b);
			}
			ins.close();
			outs.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
  	}  
}
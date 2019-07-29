import java.util.*;
import java.io.*;

public class copy
{
	public static void main(String a[]) throws Exception{

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			Scanner s = new Scanner(System.in);

			System.out.println("Enter Source File Name:");
			String source = s.nextLine();
			File inFile = new File(source);

				System.out.println("Enter Destination File Name");
				String dest = s.nextLine();
				File outFile = new File(dest);
			
				fis = new FileInputStream(inFile);
				fos = new FileOutputStream(outFile);
				
				byte[] buffer = new byte[1024];
				int len;

		while((len = fis.read(buffer)) > 0)
		{
			fos.write(buffer,0,len);
		}	
		fis.close();
		fos.close();
		System.out.println("sucessfully done!!!s");
		}		
		catch(FileNotFoundException fnfe){
		fnfe.printStackTrace();
		}
		catch(IOException i){
			i.printStackTrace();
		}
	}
}
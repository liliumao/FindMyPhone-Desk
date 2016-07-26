package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.Scanner;

public class IOUtils {
	public static void readIMEIList(Vector<String> names, Vector<String> IMEIs){
		File IMEIFile = new File("IMEIList.txt");
		try (Scanner input= new Scanner(IMEIFile)) {
			
			String[] line = null;
			while(input.hasNext()){
				line = input.nextLine().split(": ");
				names.add(line[0]);
				IMEIs.add(line[1]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("wrong file");
			System.exit(0);
		}
	}
	
	public static void writeIMEIList(Vector<String> names, Vector<String> IMEIs){
		File IMEIFile = new File("IMEIList.txt");
		try (PrintWriter out = new PrintWriter(IMEIFile)){
			for (int i = 0; i < names.size(); i++) {
				out.write(names.get(i) + ": " + IMEIs.get(i));
			}
			
			out.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("wrong file");
			System.exit(0);
		}
	}
}

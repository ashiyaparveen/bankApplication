package user;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
public class FileExample {
	public static void main(String[] args) {
     try(FileWriter fw=new FileWriter("Trand.txt",true))
     {
    	 Scanner sc=new Scanner(System.in);
    	 BufferedWriter bf=new BufferedWriter(fw);
    	 String test=sc.next();
    	 bf.write(test=" ");
    	 bf.append(test);
    	 bf.close();
     }
     catch(Exception e) {
    	 System.out.println("Eroor Occured");
     }
}
}
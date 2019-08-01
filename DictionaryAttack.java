import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class DictionaryAttack
{
	private static String ciphText;
	char letter;
	private static StringBuilder sb;
	private static String foundString;
	private static int i;
	private static int h = 0;
	private static BufferedWriter bw = null;
	private static char[] juu;
	private static char[][] array;
	@SuppressWarnings("unlikely-arg-type")
public static void main(String[] args)
{
	String a1 = "database.txt"; //Initializing the dictionary
	File fi = new File(a1);
	try{
		bw = new BufferedWriter(new FileWriter(fi));
		bw.write("HELLO " + "TODAY " +"SUN "+"HOUSE ");  //Writing the words into the dictionary
		bw.close();
	}
	catch(IOException e){
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	Scanner sc = new Scanner(System.in);
	sb = new StringBuilder();
	System.out.println("Give text:");	//Asking for the text for decryption
	ciphText = sc.nextLine();
	char[] Array = ciphText.toCharArray(); //Initializing a char array to hold ciphertext
	FileInputStream fileIn = null;
	try{
		fileIn = new FileInputStream("database.txt");
	}
	catch (FileNotFoundException e){
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	Scanner scan = new Scanner(fileIn);
	for(i = 0; i<26; i++){
		do{
			int c = (((int) (Array[h]-65))); //Converting the char array's h.th char into int
			foundString = DeCipher(c,i);	//Method call for deciphering (returns the deciphered char)
			sb.append(foundString);			//Appending the StringBuilder with the char
			h++;							//Increasing the h by 1
		}while(h<Array.length);				//Do-While loop is executed as long as there is letters in the UserInput (the length of the ciphText variable)
		h=0;								
	}
	String jou = sb.toString();				//Storing the string
	while(scan.hasNext()){					
		String shape = scan.next();			
		System.out.println(jou);
			if(jou.contains(shape)){		//if our deciphered string is contained in the fileIn
				System.out.println("Deciphered word:"+shape); //print the word
			}
	}
}


private static String DeCipher(int c, int key)
{
	int modulo = ((c-key)%26+26)%26;
	String j = String.valueOf((char)((modulo)+65)); //Doing the necessary calculations (ASCII table)
	return j;
}
}
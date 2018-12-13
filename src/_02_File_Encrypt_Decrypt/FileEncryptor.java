package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter a message");
		char[] chars = input.toCharArray();
		
		
		for(int i = 0; i < chars.length; i++) {
			chars[i]++;
		}
		
		String encrypted = new String(chars);
		System.out.println(encrypted);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/message.txt");
			fw.write(encrypted);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
}

package _03_To_Do_List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
		JFrame window;
		JPanel panel;
		JButton[] buttons;
		ArrayList<String> tasks = new ArrayList<String>();

		public static void main(String[] args) {
			new ToDoList().start();
		}

		public void start() {
			window = new JFrame("To Do List");
			panel = new JPanel();
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			buttons = new JButton[5];

			for (int i = 0; i < buttons.length; i++) {

				buttons[i] = new JButton();
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			}

			window.add(panel);
			window.setExtendedState(JFrame.MAXIMIZED_BOTH);

			window.setVisible(true);

			buttons[0].setText("Add Task");
			buttons[1].setText("View Task");
			buttons[2].setText("Remove Task");
			buttons[3].setText("Save List");
			buttons[4].setText("Load List");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton buttonClicked = (JButton) e.getSource();

			if (buttonClicked == buttons[0]) {
				String input = JOptionPane.showInputDialog("Enter a task");
				tasks.add(input);
			} else if (buttonClicked == buttons[1]){
				String output = "";
				for(String s : tasks) {
					output += s + "\n";
				}
				JOptionPane.showMessageDialog(null, output);
			} else if (buttonClicked == buttons[2]){
				String output = "";
				for(String s : tasks) {
					output += s + "\n";
				}
				String input = JOptionPane.showInputDialog("Current tasks: " + output + "\nEnter the task to be removed");
				for(int i = 0; i < tasks.size(); i++) {
					if(input.toLowerCase().equals(tasks.get(i).toLowerCase())) {
						tasks.remove(i);
					}
				}
				
			} else if (buttonClicked == buttons[3]){
				String output = "";
				for(String s : tasks) {
					output += s + "\n";
				}
				try {
					FileWriter fw = new FileWriter("src/_03_To_Do_List/list.txt");
					fw.write(output);
					fw.close();
				} catch (IOException ie) {
					ie.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Filed Saved");
			} else if (buttonClicked == buttons[4]){
				String input = JOptionPane.showInputDialog("Enter the file name");
				String taskList = "";
				try {
					BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/" + input+ ".txt"));
					
					
					String line = br.readLine();
					while(line != null){
						System.out.println(line);
						taskList += line +"\n";
						line = br.readLine();
						
					}
					
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException ie) {
					// TODO Auto-generated catch block
					ie.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Task List: " + taskList);
			}
			
		}
	
}

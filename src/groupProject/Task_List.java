package groupProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;

public class Task_List {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task_List window = new Task_List();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Task_List() {
		initialize();
		goBackButton();
		usernameLabel();
		createNewTaskButton();
		TaskList();
		dueDateList();
		//create check box for task when complete
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	private void goBackButton()
	{
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGoBack.setBounds(0, 0, 134, 40);
		frame.getContentPane().add(btnGoBack);
			
	}
	private void usernameLabel()
	{
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(134, 0, 134, 40);
		frame.getContentPane().add(lblUserName);
	}
	private void createNewTaskButton()
	{
		JButton btnCreateNewTask = new JButton("Create New Task");
		btnCreateNewTask.setBounds(423, 0, 134, 33);
		frame.getContentPane().add(btnCreateNewTask);
	}
	
	private void TaskList()
	{
		//or create a for loop that creates labels. 
		JList taskList = new JList();
		taskList.setBounds(12, 194, 281, -126);
		frame.getContentPane().add(taskList);
	}
	
	private void dueDateList()
	{
		//or create a for loop that creates the date on labels
		JList dateList = new JList();
		dateList.setBounds(292, 334, 134, -273);
		frame.getContentPane().add(dateList);
	}
	
	//create check boxes for each loop
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI extends JFrame implements ListSelectionListener,ActionListener {

	private ArrayList<Student> studentList;
	private JList myList;
	private JButton add;
	private JButton remove;
	private JButton pause;
	private JButton unpause;
	private JPanel contentPane;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
		JTextField username=new JTextField();
		JTextField password=new JTextField();
		JTextField email=new JTextField();
		
		// You selected the button, lets ask a question and go from there!
		Object[] message = {
			    "Username:", username,
			    "Email:", email,
			    "Session Password:", password
			};
		int value = JOptionPane.showConfirmDialog(null, message, "Please enter credentials", JOptionPane.OK_CANCEL_OPTION);
		System.out.println(studentList);
		
		if (value == JOptionPane.OK_OPTION) {
			((StudentQueue) myList.getModel()).addData(username.getText());
			Student student=new Student(username.getText(),password.getText(),email.getText());
			studentList.add(student);
		} 
		}
		else if(e.getSource()==remove) {
			int index;
			JTextField password=new JTextField();
			Object[] message= {"password", password};
			String selection = ((String) myList.getSelectedValue());
			int value;
			if(selection!=null) {
			value = JOptionPane.showConfirmDialog(null, message, "Enter session Password", JOptionPane.OK_CANCEL_OPTION);
			if(value==JOptionPane.OK_OPTION) {
				if(!password.getText().equals("")) {
					index=myList.getSelectedIndex();
					((StudentQueue)myList.getModel()).removeData(index);
					for(Student s:studentList) {
						if(s.userName.equals(selection)) {
							studentList.remove(s);
							break;
						}
					}
					System.out.println(studentList);
				}
				else {
					JOptionPane.showMessageDialog(null,  "Please enter password");
				}
			}
			}else
				JOptionPane.showMessageDialog(null,  "Please select a student to remove");
		}
		
	}
	
	public GUI() {
	/*	contentPane=new JPanel();
		this.setBounds(255, 100, 450, 300);
		contentPane.setBorder( BorderFactory.createEmptyBorder(11,11,11,11));
	
		this.studentList=new ArrayList<Student>();
		studentList.add(new Student("gerrard","Ger@c.com","12345"));
		studentList.add(new Student("Torres","tor@c.com","12345"));
		JLabel desc=new JLabel("Current Student Queue");
		StudentQueue queue=new StudentQueue();	
		myList=new JList(queue);
		myList.setBounds(18,16,125,237);
		myList.setVisible(true);
		myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myList.addListSelectionListener(this);
		
		contentPane.setLocale(null);
		contentPane.add(myList);
		//add(BorderLayout.CENTER, myList);
		add=new JButton("add");
		add.setBounds(195, 115, 117, 29);
		add.addActionListener(this);
		contentPane.add(add);
		remove=new JButton("remove");
		remove.setBounds(324, 115, 117, 29);
		remove.addActionListener(this);
		contentPane.add(remove);
		pause=new JButton("pasue");
		pause.setBounds(195, 156, 117, 29);
		pause.addActionListener(this);
		contentPane.add(pause);
		unpause=new JButton("unpause");
		unpause.setBounds(324, 156, 117, 29);
		add.addActionListener(this);
		contentPane.add(add);
		this.setContentPane(contentPane);
	*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] try1 = {"ABC","BCA"};
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JButton btnAdd = new JButton("Add");
		add=new JButton("add");
		add.setBounds(195, 115, 117, 29);
		add.addActionListener(this);
		contentPane.add(add);
		
		
		
		
		 remove = new JButton("Remove");
		remove.setBounds(324, 115, 117, 29);
		remove.addActionListener(this);
		contentPane.add(remove);
		
		
		
		 pause = new JButton("Pause");
		pause.setBounds(195, 156, 117, 29);
		pause.addActionListener(this);
		contentPane.add(pause);
		
		
		
		 unpause = new JButton("Unpause");
		unpause.setBounds(324, 156, 117, 29);
		unpause.addActionListener(this);
		contentPane.add(unpause);
		
		
		this.studentList=new ArrayList<Student>();
		studentList.add(new Student("gerrard","Ger@c.com","12345"));
		studentList.add(new Student("Torres","tor@c.com","12345"));
		
		myList=new JList(new StudentQueue());
		myList.setBounds(18, 16, 125, 237);
		myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myList.addListSelectionListener(this);
		contentPane.add(myList);
		

	}
	
	 
	public static void main(String[] args) {
		//adjustFontSize(30); // Only needed to scale the font for lectures

		GUI window = new GUI();
		
		// Finish setting up this window.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Student Queue");
		window.setSize(700, 500);
		window.setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		// Get the selected value
		String selection = ((String) myList.getSelectedValue());
		// Ask them what they think
	//	JOptionPane.showMessageDialog(null, selection + ", what do you think?");
		
	}

}

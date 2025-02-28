package Demo;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Main implements ActionListener{
	JFrame frame;
	JFrame frame2;
	JLabel l;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JLabel lb;
	JTable table;
	
	public Main(){
		frame = new JFrame("Grading application");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.lightGray);
		Border b = BorderFactory.createLineBorder(Color.white,3);
		
		lb = new JLabel("( Just enter the Roll No for Deleting )");
		lb.setBounds(950,500,400,50);
		lb.setForeground(Color.red);
		lb.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		l = new JLabel("STUDENT GRADING SYSTEM");
		l.setBounds(400, 40, 700, 50);
		l.setFont(new Font("Times New Roman",Font.BOLD,35));
		l.setForeground(Color.black);
		
		l1 = new JLabel("Name of the Student: ");
		l1.setBounds(230, 140, 250, 50);
		l1.setFont(new Font("Times New Roman",Font.BOLD,25));
		l1.setForeground(Color.black);
		
		l2 = new JLabel("Roll No: ");
		l2.setBounds(230, 210, 200, 50);
		l2.setFont(new Font("Times New Roman",Font.BOLD,25));
		l2.setForeground(Color.black);
		
		l3 = new JLabel("Maths Marks: ");
		l3.setBounds(230, 280, 200, 50);
		l3.setFont(new Font("Times New Roman",Font.BOLD,25));
		l3.setForeground(Color.black);
		
		l4 = new JLabel("Physics Marks: ");
		l4.setBounds(230, 350, 200, 50);
		l4.setFont(new Font("Times New Roman",Font.BOLD,25));
		l4.setForeground(Color.black);
		
		l5 = new JLabel("Chemistry Marks: ");
		l5.setBounds(230, 420, 250, 50);
		l5.setFont(new Font("Times New Roman",Font.BOLD,25));
		l5.setForeground(Color.black);
		
		tf1 = new JTextField(20);
		tf1.setBounds(500, 150, 400, 40);
		tf1.setFont(new Font("Times New Roman",Font.BOLD,20));
		tf1.setForeground(Color.red);
		
		tf2 = new JTextField(20);
		tf2.setBounds(500, 215, 300, 40);
		tf2.setFont(new Font("Times New Roman",Font.BOLD,20));
		tf2.setForeground(Color.red);
		
		tf3 = new JTextField(20);
		tf3.setBounds(500, 285, 300, 40);
		tf3.setFont(new Font("Times New Roman",Font.BOLD,20));
		tf3.setForeground(Color.red);
		
		tf4 = new JTextField(20);
		tf4.setBounds(500, 355, 300, 40);
		tf4.setFont(new Font("Times New Roman",Font.BOLD,20));
		tf4.setForeground(Color.red);
		
		tf5 = new JTextField(20);
		tf5.setBounds(500, 425, 300, 40);
		tf5.setFont(new Font("Times New Roman",Font.BOLD,20));
		tf5.setForeground(Color.red);
		
		b1 = new JButton("ADD STUDENT");
		b1.addActionListener(this);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		b1.setBounds(300, 500, 200, 50);
		b1.setBorder(b);
		b1.setFocusable(false);
		b1.setBackground(Color.orange);
		
		b2 = new JButton("UPDATE");
		b2.addActionListener(this);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		b2.setBounds(630, 500, 100, 50);
		b2.setBorder(b);
		b2.setFocusable(false);
		b2.setBackground(Color.green);
		
		b3 = new JButton("DELETE");
		b3.addActionListener(this);
		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		b3.setBounds(840, 500, 100, 50);
		b3.setBorder(b);
		b3.setFocusable(false);
		b3.setBackground(Color.red);
	
		b4 = new JButton("VIEW GRADES");
		b4.addActionListener(this);
		b4.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
		b4.setBounds(550, 585, 200, 50);
		b4.setBorder(b);
		b4.setFocusable(false);
		b4.setBackground(Color.cyan);
		
		
		frame.add(l);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(tf1);
		frame.add(tf2);
		frame.add(tf3);
		frame.add(tf4);
		frame.add(tf5);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(lb);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String op = e.getActionCommand();
		String name="";
		int id=0;
		double m=0;
		double p=0;
		double c=0;
		
		if(op.equals("ADD STUDENT")) {
			try {
				name = tf1.getText();
				id = Integer.parseInt(tf2.getText());
				m = Double.parseDouble(tf3.getText());
				p = Double.parseDouble(tf4.getText());
				c = Double.parseDouble(tf5.getText());
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "your-mysql-url";
                String user = "your-root-name";
                String password = "Your-pwd";
                
                Connection con = DriverManager.getConnection(url, user, password);
                
               
                String query = "INSERT INTO tb (name, id, m, p, c) VALUES (?, ?, ?, ?, ?)";
                
               
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setInt(2, id);
                pstmt.setDouble(3,m);
                pstmt.setDouble(4,p);
                pstmt.setDouble(5, c);
                
                
                int rowsInserted = pstmt.executeUpdate();
                
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, " New Student added successfully!");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                    tf5.setText("");
                }
                
                
                pstmt.close();
                con.close();
                
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
		
		id=0;
		
		if(op.equals("UPDATE")) {
			try {
				name = tf1.getText();
				id = Integer.parseInt(tf2.getText());
				m = Double.parseDouble(tf3.getText());
				p = Double.parseDouble(tf4.getText());
				c = Double.parseDouble(tf5.getText());
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "your-mysql-url";
                String user = "your-root-name";
                String password = "Your-pwd";
                
                
                Connection con = DriverManager.getConnection(url, user, password);
                
               
                String query = "UPDATE tb SET name=?, m=?, p=?, c=? WHERE id=?";
                
               
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setDouble(2, m);
                pstmt.setDouble(3,p);
                pstmt.setDouble(4,c);
                pstmt.setInt(5, id);
                
                
                int rowsInserted = pstmt.executeUpdate();
                
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Student Details updated successfully!");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                    tf5.setText("");
                }
                
                
                pstmt.close();
                con.close();
                
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
		
		id = 0;
		if(op.equals("DELETE")) {
			JLabel lb = new JLabel("Just enter the Roll No:");
			lb.setBounds(700,0,200,50);
			lb.setForeground(Color.MAGENTA);
			frame.add(lb);
			
			try {
				id = Integer.parseInt(tf2.getText());
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "your-mysql-url";
                String user = "your-root-name";
                String password = "Your-pwd";
                
                
                Connection con = DriverManager.getConnection(url, user, password);
                
               
                String query = "DELETE FROM tb WHERE id=?";
                
               
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setInt(1, id);
                
                
                int rowsInserted = pstmt.executeUpdate();
                
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Student Details deleted successfully!");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                    tf5.setText("");
                }
                else {
                	JOptionPane.showMessageDialog(null, "Warning: ","No student found with this Roll Number",JOptionPane.WARNING_MESSAGE);
                }
                
                
                pstmt.close();
                con.close();
                
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
		if(op.equals("VIEW GRADES")) {
			frame.dispose();
			new Main2();
        }
		
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}

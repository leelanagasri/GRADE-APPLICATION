package Demo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;

public class sixth{
	JFrame frame;
    JTable bookingTable;

    public sixth() {
    	frame = new JFrame("View Student Records");
    	frame.setSize(600, 400);
    	frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        
        DefaultTableModel model = new DefaultTableModel();
        bookingTable = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(bookingTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        
        frame.add(panel);

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/db";
            String user = "root";
            String password = "Leela@123";
            
            
            Connection con = DriverManager.getConnection(url, user, password);
            
           
			String query = "select * from tb";
			PreparedStatement prs = con.prepareStatement(query);
			ResultSet rs = prs.executeQuery();
			
			ResultSetMetaData mg = rs.getMetaData();
			int colCount = mg.getColumnCount();
			
			for(int i=1;i<=colCount;i++) {
				model.addColumn(mg.getColumnName(i));
			}
			while(rs.next()) {
				Object[] rowData = new Object[colCount];
                for (int i = 1; i <=colCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
			}
            
        } catch (Exception e2) {
        	JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new sixth());
    }

}


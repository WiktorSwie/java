import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame{
	public JButton create_account;
	public JButton log_in;
	public JButton exit;
	
	MyFrame(){
		create_account = new JButton("stworz konto");
		log_in = new JButton("zaloguj");
		exit = new JButton("wyjdz");
		
		JPanel panel = new JPanel();
		panel.add(create_account);
		panel.add(log_in);
		panel.add(exit);
		
		this.add(panel);
		this.setTitle("aplikacja biblioteki");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(500,500);
		this.setVisible(true);
	}

}
   

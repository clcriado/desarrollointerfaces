package com.carlos.me;

import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Ejercicio {

	private JFrame frame;
	private JTextField tfUsuario;
	private JTextField tfContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio window = new Ejercicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Ejercicio() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		
		Connection connection;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(
					  "jdbc:mysql://localhost:3306/evaini?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					  "root",
					  "123asd!"); 
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel labelResultado = new JLabel("");

		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		
		JLabel labelUsuario = new JLabel("Usuario");
		panel.add(labelUsuario);
		
		tfUsuario = new JTextField();
		panel.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel labelContrasena = new JLabel("Contrase\u00F1a");
		panel.add(labelContrasena);
		
		tfContrasena = new JTextField();
		panel.add(tfContrasena);
		tfContrasena.setColumns(10);
		panel.add(labelResultado);
		
		JButton buttonAcceder = new JButton("Acceder");
		buttonAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
		           if( ae.getSource() instanceof JButton) {
		        	   Statement s;
					try {
						s = connection.createStatement();
						ResultSet rs = s.executeQuery ("select * from usuario");
						while(rs.next()) {
							if(rs.getString("nombre").equals(tfUsuario.getText())  && rs.getString("contrasena").equals(tfContrasena.getText())) {
								labelResultado.setText("Usuario correcto.");
								break;
							} else {
								labelResultado.setText("El usuario o la contraseña son incorrectos.");
							}
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
		JButton buttonRegistrarse = new JButton("Registrarse");
		buttonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				  if( ae.getSource() instanceof JButton) {
					  
				  }
			}
		});
		panel.add(buttonRegistrarse);
	;
					}
		        	
		           }
			}
		});
		panel.add(buttonAcceder);

	}
}

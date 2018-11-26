package com.presentation.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.logic.management.ClientManagement;
import com.logic.objects.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtPhone;
	private JTextField txtBirth;
	private ClientManagement manage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterWindow(ClientManagement pManage) {
		setTitle("Sing in window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		manage = pManage;
		
		JLabel lblRegistro = new JLabel("SIGN IN");
		lblRegistro.setFont(new Font("OCR A Extended", Font.PLAIN, 38));
		lblRegistro.setBounds(155, 10, 174, 56);
		contentPane.add(lblRegistro);
		
		txtName = new JTextField();
		txtName.setBounds(233, 79, 229, 30);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(233, 143, 229, 30);
		contentPane.add(txtId);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(233, 204, 229, 30);
		contentPane.add(txtPhone);
		
		txtBirth = new JTextField();
		txtBirth.setColumns(10);
		txtBirth.setBounds(233, 267, 229, 30);
		contentPane.add(txtBirth);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				registrar(event);
			}
		});
		btnNewButton.setBounds(199, 344, 111, 56);
		contentPane.add(btnNewButton);
		
		JLabel lblNombre = new JLabel("NAME");
		lblNombre.setFont(new Font("Sitka Text", Font.PLAIN, 22));
		lblNombre.setBounds(39, 82, 103, 23);
		contentPane.add(lblNombre);
		
		JLabel lblId = new JLabel("IDENTIFICATION");
		lblId.setFont(new Font("Sitka Text", Font.PLAIN, 22));
		lblId.setBounds(39, 146, 206, 23);
		contentPane.add(lblId);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Sitka Text", Font.PLAIN, 22));
		lblPhone.setBounds(39, 207, 103, 23);
		contentPane.add(lblPhone);
		
		JLabel lblBirthdate = new JLabel("BIRTHDATE");
		lblBirthdate.setFont(new Font("Sitka Text", Font.PLAIN, 22));
		lblBirthdate.setBounds(39, 270, 137, 23);
		contentPane.add(lblBirthdate);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(RegisterWindow.class.getResource("/com/images/white background.jpg")));
		lblBackground.setBounds(-47, -39, 617, 517);
		contentPane.add(lblBackground);
	}
	public void registrar(java.awt.event.ActionEvent event) {
		if(txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "THE NAME FIELD IS OBLIGATORY");
		}else if(txtId.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "THE ID FIELD IS OBLIGATORY");
		}else if(txtPhone.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "THE PHONE FIELD IS OBLIGATORY");
		}else if(txtBirth.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "THE BIRTHDATE FIELD IS OBLIGATORY");
		}else {
			Client client = new Client(txtName.getText(), txtBirth.getText() ,Integer.valueOf(txtId.getText()), txtPhone.getText());
			manage.addclients(client);
			JOptionPane.showMessageDialog(null, "Succesfull Registration");
		}
	}
}

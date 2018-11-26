package com.presentation.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.logic.management.ClientManagement;
import com.logic.management.GraphManagement;
import com.logic.objects.Client;
import com.logic.objects.Place;
import com.structures.tree.BinarySearchTree;
import com.structures.tree.BinarySearchTree.*;

import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import  javax.swing.JPanel;
import javax.swing.JOptionPane;

//Ventana inicial para acceder al programa

public class EntryWindow extends JFrame {
	private static String password = "TRIPTEC"; //Contrasenna que se utiliza para utilizar las funciones de administrador
	private ClientManagement clientManage = new ClientManagement();
	private GraphManagement management = new GraphManagement();
	JPanel panel = new JPanel();
	private JPanel contentPane;
	final TextField txtID = new TextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryWindow frame = new EntryWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EntryWindow() {
		setTitle("Entry Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 322);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblIngreseSuId = new JLabel("ENTER YOUR ID, OR THE ADMIN PASSWORD TO RUN");
		lblIngreseSuId.setForeground(Color.BLACK);
		lblIngreseSuId.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblIngreseSuId.setBounds(64, 72, 486, 31);
		contentPane.setLayout(null);

		JLabel lblBienvenidoATriptec = new JLabel("WELCOME TO TRIPTEC");
		lblBienvenidoATriptec.setBackground(Color.WHITE);
		lblBienvenidoATriptec.setForeground(Color.BLACK);
		lblBienvenidoATriptec.setBounds(85, 13, 440, 60);
		lblBienvenidoATriptec.setFont(new Font("OCR A Extended", Font.PLAIN, 38));
		contentPane.add(lblBienvenidoATriptec);

		JLabel lblParaEjecutarLas = new JLabel("THE ADMNISTRATOR FUNCTIONS");
		lblParaEjecutarLas.setForeground(Color.BLACK);
		lblParaEjecutarLas.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblParaEjecutarLas.setBounds(134, 103, 331, 16);
		contentPane.add(lblParaEjecutarLas);
		contentPane.add(lblIngreseSuId);

		
		txtID.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtID.setBounds(133, 139, 315, 40);
		contentPane.add(txtID);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtID.getText().equals(password)) {
					GeneralGraphWindow window = new GeneralGraphWindow(management);
					window.getmodel().setRowCount(0);
					window.getmodel().setColumnCount(2);
					window.getmodel2().setRowCount(0);
					window.getmodel2().setColumnCount(1);
					for(int i = 0; i < management.getGraph().getVertices().size();i++) {
						window.getmodel().addRow(new Object[] {management.getGraph().getVertices().get(i),String.valueOf(i)});
						window.getCmbDestinity().addItem((Place) management.getGraph().getVertices().get(i).getElement());
						window.getCmbStart().addItem((Place) management.getGraph().getVertices().get(i).getElement());
					}
					window.setVisible(true);
				}
				else {
					try {
						int id = Integer.parseInt(txtID.getText());
						BinarySearchTree<Client>.Node<Client> NodeClient = clientManage.getclients().searchClient(id);
						if (NodeClient != null) {
							GeneralGraphWindow window2 = new GeneralGraphWindow(management);
							MainWindowClient window = new MainWindowClient(clientManage,txtID.getText());
							window.setmodel2(window2.getmodel());
							window.getmodel().setRowCount(0);
							window.getmodel().setColumnCount(2);
							window.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(panel, "This client doesn't exist", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(panel, "Invalid Id/password", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnLogin.setBounds(238, 196, 108, 53);
		contentPane.add(btnLogin);

		JButton btnSingIn = new JButton("Sign in");
		btnSingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new RegisterWindow(clientManage).setVisible(true);
			}
		});
		btnSingIn.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnSingIn.setBounds(468, 196, 108, 53);
		contentPane.add(btnSingIn);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(new Color(240, 240, 240));
		lblBackground.setIcon(new ImageIcon(EntryWindow.class.getResource("/com/images/white background.jpg")));
		lblBackground.setBounds(-21, -11, 638, 303);
		contentPane.add(lblBackground);
	}
}

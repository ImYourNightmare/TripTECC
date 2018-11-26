package com.presentation.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.logic.management.ClientManagement;
import com.logic.management.GraphManagement;
import com.logic.objects.Client;
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

public class EntryWindow extends JFrame {
	private static String password = "TRIPTEC";
	private ClientManagement clientManage = new ClientManagement();
	private GraphManagement graphmanagement= new GraphManagement();
	JPanel panel = new JPanel();
	private JPanel contentPane;

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

		final TextField txtID = new TextField();
		txtID.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtID.setBounds(133, 139, 315, 40);
		contentPane.add(txtID);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtID.getText().equals(password)) {
					new GeneralGraphWindow(clientManage).setVisible(true);;
				}
				else {
					try {
						int id = Integer.parseInt(txtID.getText());
						BinarySearchTree<Client>.Node<Client> NodeClient = clientManage.getclients().searchClient(id);
						if (NodeClient != null) {
							new MainWindowClient(clientManage.getclients().searchClient(Integer.parseInt(txtID.getText())).getElement()).setVisible(true);
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

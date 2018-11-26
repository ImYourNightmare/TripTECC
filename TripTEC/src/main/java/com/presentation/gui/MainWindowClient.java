package com.presentation.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

import com.logic.management.ClientManagement;
import com.logic.objects.Client;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class MainWindowClient extends JFrame {

	private JPanel contentPane;
	private JTable tblRoute;
	private JTable tblClientRoute;
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
	public MainWindowClient(ClientManagement pClientManage) {
		setTitle("Main Window - Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		manage = pClientManage;
		
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnSignOut.setBounds(757, 320, 97, 49);
		contentPane.add(btnSignOut);
		
		tblClientRoute = new JTable();
		tblClientRoute.setModel(new DefaultTableModel(
			new Object[][] {
				{"Tecnologico de Costa Rica", "university", "Cartago, Costa Rica"},
				{"basilica de los angeles", "church", "Cartago, Costa Rica"},
				{"Estadio Nacional", "Stadium", "San Jose, Costa Rica"},
				{"Parque la sabana", "park", ""},
				{"El manantial", "pool", null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tblClientRoute.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		tblClientRoute.setColumnSelectionAllowed(true);
		tblClientRoute.setCellSelectionEnabled(true);
		tblClientRoute.setBounds(12, 81, 388, 144);
		contentPane.add(tblClientRoute);
		
		JLabel lblYourRoute = new JLabel("YOUR ROUTE");
		lblYourRoute.setForeground(Color.WHITE);
		lblYourRoute.setFont(new Font("OCR A Extended", Font.PLAIN, 27));
		lblYourRoute.setBounds(124, 13, 166, 75);
		contentPane.add(lblYourRoute);
		
		JButton btnMoreInformation = new JButton("INFORMATION");
		btnMoreInformation.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		btnMoreInformation.setBounds(688, 238, 166, 49);
		contentPane.add(btnMoreInformation);
		
		JLabel lblRoute = new JLabel("OFFICIAL ROUTE");
		lblRoute.setForeground(Color.WHITE);
		lblRoute.setFont(new Font("OCR A Extended", Font.PLAIN, 27));
		lblRoute.setBounds(562, 13, 224, 75);
		contentPane.add(lblRoute);
		
		tblRoute = new JTable();
		tblRoute.setModel(new DefaultTableModel(
			new Object[][] {
				{"0", "basililca de los angeles", "0.0km"},
				{"1", "Tecnologico de Costa Rica", "0.8km"},
				{"2", "Estadio NacionalC", "27.5km"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Index", "Name", "Lenght"
			}
		));
		tblRoute.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblRoute.getColumnModel().getColumn(1).setPreferredWidth(97);
		tblRoute.setColumnSelectionAllowed(true);
		tblRoute.setCellSelectionEnabled(true);
		tblRoute.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		tblRoute.setBounds(481, 81, 388, 144);
		contentPane.add(tblRoute);
		
		JButton btnAdd = new JButton("ADD TO \r\nMY ROUTE");
		btnAdd.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		btnAdd.setBounds(491, 238, 166, 49);
		contentPane.add(btnAdd);
		
		JTextPane txtInformation = new JTextPane();
		txtInformation.setBounds(63, 309, 258, 260);
		contentPane.add(txtInformation);
		
		JLabel lblInformation = new JLabel("ROUTE INFORMATION");
		lblInformation.setForeground(Color.WHITE);
		lblInformation.setFont(new Font("OCR A Extended", Font.PLAIN, 27));
		lblInformation.setBounds(54, 254, 288, 75);
		contentPane.add(lblInformation);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainWindowClient.class.getResource("/com/images/live_to_travel_detail.jpg")));
		lblNewLabel.setBounds(-15, -77, 896, 712);
		contentPane.add(lblNewLabel);
	}
}

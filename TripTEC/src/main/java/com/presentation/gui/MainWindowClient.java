package com.presentation.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import com.structures.graph.Vertex;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindowClient extends JFrame {

	private JPanel contentPane;
	private JTable tblRoute;
	private JTable tblClientRoute;
	private ClientManagement manage;
	private static DefaultTableModel model = new DefaultTableModel();
	private static DefaultTableModel model2 = new DefaultTableModel();
	private int ID;
	private int ID2=0;
	private Client client;
	
	public DefaultTableModel getmodel() {
		return this.model;
	}
	public DefaultTableModel getmodel2() {
		return this.model2;
	}
	public void setmodel2(DefaultTableModel model2) {
		this.model2 = model2;
	}
	/**
	 * Create the frame.
	 */
	public MainWindowClient(ClientManagement pClientManage, String ID) {
		setTitle("Main Window - Client");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		manage = pClientManage;
		this.ID = Integer.parseInt(ID);
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindowClient.this.dispose();
			}
		});
		btnSignOut.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnSignOut.setBounds(757, 320, 97, 49);
		contentPane.add(btnSignOut);
		client = manage.getclients().searchClient(Integer.parseInt(ID)).getElement();
		tblClientRoute = new JTable();
		tblClientRoute.setModel(model);
		tblClientRoute.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		tblClientRoute.setColumnSelectionAllowed(true);
		tblClientRoute.setCellSelectionEnabled(true);
		JScrollPane scrollpane2 = new JScrollPane(tblClientRoute);
		scrollpane2.setBounds(12, 81, 388, 144);
		contentPane.add(scrollpane2);
		
		
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
		tblRoute.setColumnSelectionAllowed(true);
		tblRoute.setCellSelectionEnabled(true);
		tblRoute.setShowVerticalLines(false);
		tblRoute.setShowHorizontalLines(false);
		tblRoute.setShowGrid(false);
		tblRoute.setModel(model2);
		tblRoute.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		JScrollPane scrollpane = new JScrollPane(tblRoute);
		scrollpane.setBounds(481, 81, 388, 144);
		contentPane.add(scrollpane);
		
		JButton btnAdd = new JButton("ADD TO \r\nMY ROUTE");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				addplace(event);
			}
		});
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
	public void addplace(java.awt.event.ActionEvent event) {
		
		int row = tblRoute.getSelectedRow();
		int column = tblRoute.getSelectedColumn();
		Vertex vertex = new Vertex(String.valueOf(ID),tblRoute.getValueAt(row, column));
		client.getGraph().getVertices().add(vertex);
		model.addRow(new Object[] {tblRoute.getValueAt(row, column), ID});
		ID++;
	}
}

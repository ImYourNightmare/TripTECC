package com.presentation.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class GeneralGraphWindow extends JFrame {

	private JPanel contentPane;
	private JTable tblMainRoute;
	private JTable tblSearcher;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralGraphWindow frame = new GeneralGraphWindow();
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
	public GeneralGraphWindow() {
		setTitle("Administration Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbltittle = new JLabel("Main Route");
		lbltittle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltittle.setBackground(Color.BLACK);
		lbltittle.setForeground(Color.WHITE);
		lbltittle.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		lbltittle.setBounds(179, 13, 250, 68);
		contentPane.add(lbltittle);
		

		
		tblMainRoute = new JTable();
		tblMainRoute.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tblMainRoute.setCellSelectionEnabled(true);
		tblMainRoute.setColumnSelectionAllowed(true);
		tblMainRoute.setModel(new DefaultTableModel(
			new Object[][] {
				{"El manantial", "Muy lindo", "Nadar ", "2,5$", "Piscinas"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		tblMainRoute.setBounds(34, 82, 542, 139);
		contentPane.add(tblMainRoute);
		

		
		JLabel lblsearch = new JLabel("Searcher");
		lblsearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblsearch.setForeground(Color.WHITE);
		lblsearch.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		lblsearch.setBackground(Color.BLACK);
		lblsearch.setBounds(179, 284, 250, 37);
		contentPane.add(lblsearch);
		
		tblSearcher = new JTable();
		tblSearcher.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tblSearcher.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		tblSearcher.setBounds(34, 380, 542, 139);
		contentPane.add(tblSearcher);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtSearch.setBounds(34, 334, 441, 33);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnSearch.setBounds(487, 328, 89, 39);
		contentPane.add(btnSearch);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnRemove.setBounds(253, 234, 101, 37);
		contentPane.add(btnRemove);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnAdd.setBounds(253, 532, 101, 37);
		contentPane.add(btnAdd);
		
		JComboBox cmbStart = new JComboBox();
		cmbStart.setBounds(658, 114, 154, 27);
		contentPane.add(cmbStart);
		
		JComboBox cmbDestinity = new JComboBox();
		cmbDestinity.setBounds(658, 194, 154, 27);
		contentPane.add(cmbDestinity);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(RegisterWindow.class.getResource("/com/images/live_to_travel_detail.jpg")));
		lblBackground.setBounds(-127, -30, 1058, 666);
		contentPane.add(lblBackground);
		
		JLabel lblAddRoute = new JLabel("New label");
		lblAddRoute.setBounds(658, 43, 56, 16);
		contentPane.add(lblAddRoute);
		

	}
}

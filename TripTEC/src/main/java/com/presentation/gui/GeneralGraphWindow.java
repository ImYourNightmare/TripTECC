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

public class GeneralGraphWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;

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
		setTitle("Administration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbltittle = new JLabel("Main Route");
		lbltittle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltittle.setBackground(Color.BLACK);
		lbltittle.setForeground(Color.WHITE);
		lbltittle.setFont(new Font("Arial", Font.BOLD, 20));
		lbltittle.setBounds(116, -14, 250, 68);
		contentPane.add(lbltittle);
		

		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
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
		table.setBounds(34, 40, 415, 139);
		contentPane.add(table);
		

		
		JLabel lblsearch = new JLabel("Searcher");
		lblsearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblsearch.setForeground(Color.WHITE);
		lblsearch.setFont(new Font("Arial", Font.BOLD, 20));
		lblsearch.setBackground(Color.BLACK);
		lblsearch.setBounds(116, 206, 250, 37);
		contentPane.add(lblsearch);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
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
		table_1.setBounds(34, 289, 415, 139);
		contentPane.add(table_1);
		
		textField = new JTextField();
		textField.setBounds(34, 245, 332, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(376, 242, 89, 39);
		contentPane.add(btnSearch);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(182, 190, 29, 20);
		contentPane.add(spinner);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(221, 190, 65, 23);
		contentPane.add(btnAdd);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(182, 433, 29, 20);
		contentPane.add(spinner_1);
		
		JButton button = new JButton("ADD");
		button.setBounds(221, 432, 65, 23);
		contentPane.add(button);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(RegisterWindow.class.getResource("/com/images/live_to_travel_detail.jpg")));
		lblBackground.setBounds(-47, -39, 617, 517);
		contentPane.add(lblBackground);
		

	}
}

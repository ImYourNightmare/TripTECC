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

import com.logic.management.ClientManagement;
import com.logic.management.GraphManagement;
import com.logic.objects.Place;
import com.logic.placesmanagement.API;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneralGraphWindow extends JFrame {

	private JPanel contentPane;
	private JTable tblMainRoute;
	private JTable tblSearcher;
	private JTextField txtSearch;
	private GraphManagement management;
	private JTextField txtID;
	private static DefaultTableModel model = new DefaultTableModel();
	private static DefaultTableModel model2 = new DefaultTableModel();

	/**
	 * Create the frame.
	 */
	public GeneralGraphWindow(GraphManagement management) {
		setTitle("Administration Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbltittle = new JLabel("MAIN TOUR");
		lbltittle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltittle.setBackground(Color.BLACK);
		lbltittle.setForeground(Color.WHITE);
		lbltittle.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		lbltittle.setBounds(179, 13, 250, 68);
		contentPane.add(lbltittle);
		this.management = management;



		tblMainRoute = new JTable();
		tblMainRoute.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tblMainRoute.setCellSelectionEnabled(true);
		tblMainRoute.setColumnSelectionAllowed(true);
		tblMainRoute.setModel(model);
		tblMainRoute.setBounds(34, 82, 542, 139);
		contentPane.add(tblMainRoute);



		JLabel lblsearch = new JLabel("SEARCHER");
		lblsearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblsearch.setForeground(Color.WHITE);
		lblsearch.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		lblsearch.setBackground(Color.BLACK);
		lblsearch.setBounds(179, 284, 250, 37);
		contentPane.add(lblsearch);

		tblSearcher = new JTable();
		tblSearcher.setModel(model2);
		tblSearcher.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tblSearcher.setBounds(34, 380, 542, 139);
		contentPane.add(tblSearcher);

		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtSearch.setBounds(34, 334, 441, 33);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent event) {
				search(event);
			}
		});
		btnSearch.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnSearch.setBounds(487, 328, 89, 39);
		contentPane.add(btnSearch);

		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				remove(event);
			}
		});
		btnRemove.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnRemove.setBounds(253, 234, 101, 37);
		contentPane.add(btnRemove);

		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				add(event);
			}
		});
		btnAdd.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnAdd.setBounds(194, 530, 101, 37);
		contentPane.add(btnAdd);

		JComboBox<Place> cmbStart = new JComboBox<Place>();
		cmbStart.setBounds(644, 114, 168, 27);
		contentPane.add(cmbStart);

		JComboBox<Place> cmbDestinity = new JComboBox<Place>();
		cmbDestinity.setBounds(644, 194, 168, 27);
		contentPane.add(cmbDestinity);

		JLabel lblAddRoute = new JLabel("ADD ROUTE");
		lblAddRoute.setForeground(Color.WHITE);
		lblAddRoute.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		lblAddRoute.setBounds(649, 28, 145, 38);
		contentPane.add(lblAddRoute);

		JLabel lblStart = new JLabel("START");
		lblStart.setForeground(Color.WHITE);
		lblStart.setFont(new Font("Sitka Text", Font.PLAIN, 22));
		lblStart.setBounds(685, 80, 77, 38);
		contentPane.add(lblStart);

		JLabel lblDestinity = new JLabel("DESTINITY");
		lblDestinity.setForeground(Color.WHITE);
		lblDestinity.setFont(new Font("Sitka Text", Font.PLAIN, 22));
		lblDestinity.setBounds(668, 155, 126, 38);
		contentPane.add(lblDestinity);

		JButton btnAddRoute = new JButton("ADD ROUTE");
		btnAddRoute.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnAddRoute.setBounds(666, 234, 128, 37);
		contentPane.add(btnAddRoute);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtID.setColumns(10);
		txtID.setBounds(365, 530, 211, 33);
		contentPane.add(txtID);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		lblID.setBackground(Color.BLACK);
		lblID.setBounds(305, 527, 63, 37);
		contentPane.add(lblID);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(RegisterWindow.class.getResource("/com/images/live_to_travel_detail.jpg")));
		lblBackground.setBounds(-127, -30, 1058, 666);
		contentPane.add(lblBackground);
		

	}
	public void remove(java.awt.event.ActionEvent event){
		
	}
	public void search(java.awt.event.ActionEvent event) {
		API api = new API();
		api.
	}
	public void add(java.awt.event.ActionEvent event) {
		int x = tblSearcher.getSelectedColumn();
		int y = tblSearcher.getSelectedRow();
		Place place = (Place) tblSearcher.getValueAt(y, x);
		management.addplace(place,txtID.getText());
		model.addRow(new Place[] {place});
	}
}

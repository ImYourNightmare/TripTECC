package com.presentation.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.maps.errors.ApiException;
import com.logic.management.ClientManagement;
import com.logic.management.GraphManagement;
import com.logic.objects.Place;
import com.logic.placesmanagement.API;
import com.structures.graph.Vertex;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GeneralGraphWindow extends JFrame {

	private JPanel contentPane;
	private JTable tblMainRoute;
	private JTable tblSearcher;
	private JTextField txtSearch;
	private GraphManagement management;
	private static DefaultTableModel model = new DefaultTableModel();
	private static DefaultTableModel model2 = new DefaultTableModel();
	private JComboBox<Place> cmbStart = new JComboBox<Place>();
	private JComboBox<Place> cmbDestinity = new JComboBox<Place>();
	private int ID1=0;
	private int ID2=0;

	/**
	 * Create the frame.
	 */
	public DefaultTableModel getmodel() {
		return this.model;
	}
	public DefaultTableModel getmodel2() {
		return this.model2;
	}

	public JComboBox<Place> getCmbStart() {
		return cmbStart;
	}
	public void setCmbStart(JComboBox<Place> cmbStart) {
		this.cmbStart = cmbStart;
	}
	public JComboBox<Place> getCmbDestinity() {
		return cmbDestinity;
	}
	public void setCmbDestinity(JComboBox<Place> cmbDestinity) {
		this.cmbDestinity = cmbDestinity;
	}
	public GeneralGraphWindow(GraphManagement management) {
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
		this.management = management;


		tblMainRoute = new JTable();
		tblMainRoute.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tblMainRoute.setCellSelectionEnabled(true);
		tblMainRoute.setColumnSelectionAllowed(true);
		tblMainRoute.setModel(model);
		JScrollPane scrollpane2 = new JScrollPane(tblMainRoute);
		scrollpane2.setBounds(34, 82, 542, 139);
		contentPane.add(scrollpane2);




		JLabel lblsearch = new JLabel("Searcher");
		lblsearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblsearch.setForeground(Color.WHITE);
		lblsearch.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		lblsearch.setBackground(Color.BLACK);
		lblsearch.setBounds(179, 284, 250, 37);
		contentPane.add(lblsearch);

		tblSearcher = new JTable();
		tblSearcher.setColumnSelectionAllowed(true);
		tblSearcher.setCellSelectionEnabled(true);
		tblSearcher.setModel(model2);
		tblSearcher.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		JScrollPane scrollpane = new JScrollPane(tblSearcher);
		scrollpane.setBounds(34, 380, 542, 139);
		contentPane.add(scrollpane);

		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtSearch.setBounds(34, 334, 441, 33);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent event) {
				try {
					search(event);
				} catch (ApiException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
				addplace(event);
			}
		});
		btnAdd.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnAdd.setBounds(194, 530, 101, 37);
		contentPane.add(btnAdd);

		
		cmbStart.setBounds(644, 114, 168, 27);
		contentPane.add(cmbStart);
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
		btnAddRoute.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				try {
					addroad(event);
				} catch (ApiException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnAddRoute.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnAddRoute.setBounds(644, 234, 128, 37);
		contentPane.add(btnAddRoute);
				
				JButton btnExit = new JButton("Return");
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GeneralGraphWindow.this.dispose();
					}
				});
				btnExit.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
				btnExit.setBounds(305, 530, 101, 37);
				contentPane.add(btnExit);
				
						JLabel lblBackground = new JLabel("");
						lblBackground.setIcon(new ImageIcon(RegisterWindow.class.getResource("/com/images/live_to_travel_detail.jpg")));
						lblBackground.setBounds(-127, -30, 1058, 666);
						contentPane.add(lblBackground);


	}
	public void remove(java.awt.event.ActionEvent event){
		int x = tblMainRoute.getSelectedColumn();
		int y = tblMainRoute.getSelectedRow();
		cmbStart.removeItem(management.getGraph().getVertices().get(y).getElement());
		cmbDestinity.removeItem(management.getGraph().getVertices().get(y).getElement());
		management.getGraph().getVertices().remove(y);
		model.removeRow(y);	
	}
	public void search(java.awt.event.ActionEvent event) throws ApiException, InterruptedException, IOException {
		API api = new API();
		api.createPlaceName(txtSearch.getText());
		api.ConexionPlace();
		api.placeDetails(api.getContext(), api.getPlace().getPlaceId());
		api.Parse(api.getData());
		model2.addRow(new Place[] {api.getPlace()});
	}
	public void addplace(java.awt.event.ActionEvent event) {
		int x = tblSearcher.getSelectedColumn();
		int y = tblSearcher.getSelectedRow();
		Place place = (Place) tblSearcher.getValueAt(y, x);
		cmbStart.addItem(place);
		cmbDestinity.addItem(place);
		management.addplace(place,String.valueOf(ID1));
		model.addRow(new Object[] {place,String.valueOf(ID1)});
		ID1++;
	}
	public void addroad(java.awt.event.ActionEvent event) throws ApiException, InterruptedException, IOException {
		Vertex vertexO=null;
		Vertex vertexD=null;
		API distance = new API();
		distance.getDriveDist(cmbStart.getSelectedItem().toString(), cmbDestinity.getSelectedItem().toString());
		for(int i = 0; i < management.getGraph().getVertices().size(); i++) {
			if(management.getGraph().getVertices().get(i).getElement().equals(cmbStart.getSelectedItem())) {
				vertexO = management.getGraph().getVertices().get(i); 
			}
			if(management.getGraph().getVertices().get(i).getElement().equals(cmbDestinity.getSelectedItem())) {
				vertexD = management.getGraph().getVertices().get(i); 
			}
		}
		management.addroad(String.valueOf(ID2), vertexO, vertexD, distance.getDistance());
		ID2++;
	}
}

package com.presentation.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.logic.objects.Service;

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
	Service tempService = new Service();
	String password = tempService.getPassword();
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
		setBounds(100, 100, 607, 339);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblIngreseSuId = new JLabel("INGRESE SU ID O BIEN, LA CONTRASEÑA ESTABLECIDA");
		lblIngreseSuId.setForeground(Color.BLACK);
		lblIngreseSuId.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblIngreseSuId.setBounds(47, 72, 486, 31);
		contentPane.setLayout(null);

		JLabel lblBienvenidoATriptec = new JLabel("BIENVENIDO A TRIPTEC");
		lblBienvenidoATriptec.setBackground(Color.WHITE);
		lblBienvenidoATriptec.setForeground(Color.BLACK);
		lblBienvenidoATriptec.setBounds(53, 13, 493, 60);
		lblBienvenidoATriptec.setFont(new Font("OCR A Extended", Font.PLAIN, 38));
		contentPane.add(lblBienvenidoATriptec);

		JLabel lblParaEjecutarLas = new JLabel("PARA EJECUTAR LAS FUNCIONES DE ADMINISTRADOR");
		lblParaEjecutarLas.setForeground(Color.BLACK);
		lblParaEjecutarLas.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblParaEjecutarLas.setBounds(47, 102, 486, 16);
		contentPane.add(lblParaEjecutarLas);
		contentPane.add(lblIngreseSuId);

		final TextField txtID = new TextField();
		txtID.setBounds(133, 139, 315, 40);
		contentPane.add(txtID);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtID.getText().toUpperCase().equals(password)) {
					JOptionPane.showMessageDialog(panel, "Entra un administrador", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				}
			}
		});
		btnIngresar.setBounds(238, 207, 108, 53);
		contentPane.add(btnIngresar);

		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistro.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnRegistro.setBounds(469, 207, 108, 53);
		contentPane.add(btnRegistro);

		JLabel lblBackground = new JLabel("New label");
		lblBackground.setBackground(new Color(240, 240, 240));
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Melina\\Documents\\GitHub\\TripTECC\\TripTEC\\src\\main\\java\\com\\images\\white background.jpg"));
		lblBackground.setBounds(-21, -11, 638, 303);
		contentPane.add(lblBackground);
	}
}

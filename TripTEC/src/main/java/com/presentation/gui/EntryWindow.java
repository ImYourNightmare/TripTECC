package com.presentation.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class EntryWindow extends JFrame {

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
		setBounds(100, 100, 637, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIngreseSuId = new JLabel("INGRESE SU ID O BIEN, LA CONTRASEÑA ESTABLECIDA");
		lblIngreseSuId.setForeground(Color.BLACK);
		lblIngreseSuId.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblIngreseSuId.setBounds(60, 72, 486, 31);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoATriptec = new JLabel("BIENVENIDO A TRIPTEC");
		lblBienvenidoATriptec.setBounds(99, 13, 436, 60);
		lblBienvenidoATriptec.setFont(new Font("Gill Sans MT", Font.PLAIN, 38));
		contentPane.add(lblBienvenidoATriptec);
		
		JLabel lblParaEjecutarLas = new JLabel("PARA EJECUTAR LAS FUNCIONES DE ADMINISTRADOR");
		lblParaEjecutarLas.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblParaEjecutarLas.setBounds(60, 102, 486, 16);
		contentPane.add(lblParaEjecutarLas);
		contentPane.add(lblIngreseSuId);
		
		TextField txtID = new TextField();
		txtID.setFont(new Font("Arial", Font.PLAIN, 24));
		txtID.setBounds(152, 139, 295, 42);
		contentPane.add(txtID);
	}
}

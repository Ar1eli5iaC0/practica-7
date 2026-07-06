package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.controller;

public class view_genero extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public JTextField txt_nombre;
	public JButton btn_guardar;

	public view_genero() {

		setTitle("Nuevo Género");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 220);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("REGISTRAR GÉNERO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(50, 10, 300, 30);
		contentPane.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre");

		lblNombre.setBounds(35,60,100,20);

		contentPane.add(lblNombre);

		txt_nombre = new JTextField();

		txt_nombre.setBounds(35,85,330,30);

		contentPane.add(txt_nombre);

		btn_guardar = new JButton("Guardar");

		btn_guardar.setBounds(120,135,150,30);

		contentPane.add(btn_guardar);

		controller.logic_view_genero(this);

	}

}
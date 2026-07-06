package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.controller;

public class view_pelicula extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public JTextField txt_titulo;
	public JTextArea txt_resumen;
	public JTextField txt_anio;
	public JTextField txt_duracion;

	public JComboBox<String> cb_genero;

	public JButton btn_guardar;

	private JScrollPane scrollPane;

	public view_pelicula() {

		setTitle("Nueva Película");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,520,560);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblTituloVentana = new JLabel("REGISTRAR PELÍCULA");
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloVentana.setBounds(70,10,350,30);
		contentPane.add(lblTituloVentana);

		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(30,60,100,20);
		contentPane.add(lblTitulo);

		txt_titulo = new JTextField();
		txt_titulo.setBounds(30,85,440,30);
		contentPane.add(txt_titulo);

		JLabel lblResumen = new JLabel("Resumen");
		lblResumen.setBounds(30,130,100,20);
		contentPane.add(lblResumen);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30,155,440,150);
		contentPane.add(scrollPane);

		txt_resumen = new JTextArea();
		txt_resumen.setLineWrap(true);
		txt_resumen.setWrapStyleWord(true);

		scrollPane.setViewportView(txt_resumen);

		JLabel lblAnio = new JLabel("Año");
		lblAnio.setBounds(30,325,100,20);
		contentPane.add(lblAnio);

		txt_anio = new JTextField();
		txt_anio.setBounds(30,350,150,30);
		contentPane.add(txt_anio);

		JLabel lblDuracion = new JLabel("Duración");
		lblDuracion.setBounds(240,325,100,20);
		contentPane.add(lblDuracion);

		txt_duracion = new JTextField();
		txt_duracion.setBounds(240,350,150,30);
		contentPane.add(txt_duracion);

		JLabel lblGenero = new JLabel("Género");
		lblGenero.setBounds(30,400,100,20);
		contentPane.add(lblGenero);

		cb_genero = new JComboBox<String>();
		cb_genero.setBounds(30,425,250,30);
		contentPane.add(cb_genero);

		btn_guardar = new JButton("Guardar");
		btn_guardar.setBounds(170,475,150,35);
		contentPane.add(btn_guardar);

		controller.logic_view_pelicula(this);

	}

}

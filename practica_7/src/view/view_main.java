package view;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.controller;

public class view_main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public JTable tb_movie;
	public JComboBox<String> cb_genero;
	public JTextField txt_buscar;

	public JButton btn_buscar;
	public JButton btn_mostrar;
	public JButton btn_genero;
	public JButton btn_pelicula;

	public JRadioButton rb_genero;
	public JRadioButton rb_titulo;

	public ButtonGroup grupo;

	private JScrollPane scrollPane;

	public view_main() {

		setTitle("Sistema Movie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("SISTEMA MOVIE");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(250, 10, 420, 35);
		contentPane.add(lblTitulo);

		rb_genero = new JRadioButton("Buscar por Género");
		rb_genero.setBounds(30, 70, 170, 25);
		contentPane.add(rb_genero);

		rb_titulo = new JRadioButton("Buscar por Título");
		rb_titulo.setBounds(220, 70, 170, 25);
		contentPane.add(rb_titulo);

		grupo = new ButtonGroup();
		grupo.add(rb_genero);
		grupo.add(rb_titulo);

		rb_genero.setSelected(true);

		JLabel lblGenero = new JLabel("Género");
		lblGenero.setBounds(30, 110, 100, 20);
		contentPane.add(lblGenero);

		cb_genero = new JComboBox<String>();
		cb_genero.setBounds(30, 135, 220, 30);
		contentPane.add(cb_genero);

		JLabel lblBuscar = new JLabel("Título");
		lblBuscar.setBounds(300, 110, 100, 20);
		contentPane.add(lblBuscar);

		txt_buscar = new JTextField();
		txt_buscar.setBounds(300, 135, 250, 30);
		contentPane.add(txt_buscar);

		btn_buscar = new JButton("Buscar");
		btn_buscar.setBounds(580, 135, 120, 30);
		contentPane.add(btn_buscar);

		btn_mostrar = new JButton("Mostrar Todo");
		btn_mostrar.setBounds(720, 135, 160, 30);
		contentPane.add(btn_mostrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 190, 850, 280);
		contentPane.add(scrollPane);

		tb_movie = new JTable();

		tb_movie.setModel(new DefaultTableModel(

			new Object[][] {},

			new String[] {

					"Título",
					"Género",
					"Año",
					"Duración"

			}

		) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {

				return false;

			}

		});

		tb_movie.getTableHeader().setReorderingAllowed(false);
		tb_movie.setRowHeight(24);

		scrollPane.setViewportView(tb_movie);

		btn_genero = new JButton("Nuevo Género");
		btn_genero.setBounds(220, 500, 180, 35);
		contentPane.add(btn_genero);

		btn_pelicula = new JButton("Nueva Película");
		btn_pelicula.setBounds(500, 500, 180, 35);
		contentPane.add(btn_pelicula);

		txt_buscar.setEnabled(false);

		controller.logic_view_main(this);

	}

}
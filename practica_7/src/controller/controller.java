package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.genero;
import model.generoDAO;
import model.pelicula;
import model.peliculaDAO;
import view.view_genero;
import view.view_main;
import view.view_pelicula;

public class controller {

    static ArrayList<genero> listaGeneros = new ArrayList<>();

    public static void logic_view_main(view_main v) {

        generoDAO gdao = new generoDAO();
        peliculaDAO pdao = new peliculaDAO();

        cargarGeneros(v, gdao);
        cargarTabla(v, pdao.listar());

        v.btn_buscar.addActionListener(e -> {

            if (v.rb_genero.isSelected()) {

                int idGenero = listaGeneros.get(v.cb_genero.getSelectedIndex()).getId_geenro();
                cargarTabla(v, pdao.buscarGenero(idGenero));

            } else {

                cargarTabla(v, pdao.buscarTitulo(v.txt_buscar.getText()));

            }

        });

        v.btn_mostrar.addActionListener(e -> {

            cargarTabla(v, pdao.listar());

        });

        v.rb_genero.addActionListener(e -> {

            v.cb_genero.setEnabled(true);
            v.txt_buscar.setEnabled(false);

        });

        v.rb_titulo.addActionListener(e -> {

            v.cb_genero.setEnabled(false);
            v.txt_buscar.setEnabled(true);

        });

        v.btn_genero.addActionListener(e -> {

            new view_genero().setVisible(true);

        });

        v.btn_pelicula.addActionListener(e -> {

            new view_pelicula().setVisible(true);

        });
    }

    public static void logic_view_genero(view_genero v) {

        generoDAO dao = new generoDAO();

        v.btn_guardar.addActionListener(e -> {

            if (dao.insertar(new genero(0, v.txt_nombre.getText()))) {

                JOptionPane.showMessageDialog(v, "OK");
                v.dispose();

            } else {

                JOptionPane.showMessageDialog(v, "ERROR");

            }

        });
    }

    public static void logic_view_pelicula(view_pelicula v) {

        generoDAO gdao = new generoDAO();
        peliculaDAO pdao = new peliculaDAO();

        cargarCombo(v, gdao);

        v.btn_guardar.addActionListener(e -> {

            try {

                int idGenero = listaGeneros.get(v.cb_genero.getSelectedIndex()).getId_geenro();

                pelicula p = new pelicula(
                        0,
                        idGenero,
                        v.txt_titulo.getText(),
                        v.txt_resumen.getText(),
                        Integer.parseInt(v.txt_anio.getText()),
                        Integer.parseInt(v.txt_duracion.getText())
                );

                if (pdao.insertar(p)) {

                    JOptionPane.showMessageDialog(v, "OK");
                    v.dispose();

                } else {

                    JOptionPane.showMessageDialog(v, "ERROR");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(v, "ERROR");

            }

        });
    }

    private static void cargarGeneros(view_main v, generoDAO dao) {

        v.cb_genero.removeAllItems();
        listaGeneros = dao.listar();

        for (genero g : listaGeneros) {

            v.cb_genero.addItem(g.getNombre());

        }
    }

    private static void cargarCombo(view_pelicula v, generoDAO dao) {

        v.cb_genero.removeAllItems();
        listaGeneros = dao.listar();

        for (genero g : listaGeneros) {

            v.cb_genero.addItem(g.getNombre());

        }
    }

    private static void cargarTabla(view_main v, java.sql.ResultSet rs) {

        try {

            DefaultTableModel model = (DefaultTableModel) v.tb_movie.getModel();
            model.setRowCount(0);

            while (rs.next()) {

                model.addRow(new Object[] {
                        rs.getString("title"),
                        rs.getString("nombre"),
                        rs.getInt("anio"),
                        rs.getInt("duration")
                });

            }

        } catch (Exception e) {

        }
    }
}
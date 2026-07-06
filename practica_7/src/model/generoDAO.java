package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion_bbdd.query;

public class generoDAO {

    private query q = new query();

    // Registrar un nuevo género
    public boolean insertar(genero g) {

        String sql = "INSERT INTO genre VALUES (NULL,'"
                + g.getNombre()
                + "')";

        return q.setQuerry(sql);

    }

    // Obtener todos los géneros
    public ArrayList<genero> listar() {

        ArrayList<genero> lista = new ArrayList<>();

        String sql = "SELECT * FROM genre ORDER BY nombre";

        ResultSet rs = q.getQuerty(sql);

        try {

            while (rs.next()) {

                lista.add(

                        new genero(

                                rs.getInt("id_genre"),
                                rs.getString("nombre")

                        )

                );

            }

            q.cerrar();

        } catch (SQLException e) {

            System.err.println(e);

        }

        return lista;

    }

}

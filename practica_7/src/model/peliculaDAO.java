package model;

import java.sql.ResultSet;

import conexion_bbdd.query;

public class peliculaDAO {

    private query q = new query();

    // Registrar película
    public boolean insertar(pelicula p) {

    	String sql =
    	        "INSERT INTO movie (id_genre, title, summary, anio, duration) VALUES ("
    	        + p.getId_genero() + ", '"
    	        + p.getTitulo() + "', '"
    	        + p.getResume() + "', "
    	        + p.getAnio() + ", "
    	        + p.getDuracion() + ")";

        return q.setQuerry(sql);

    }

    // Mostrar todas las películas
    public ResultSet listar() {

        String sql =
                "SELECT "
                + "m.title,"
                + "g.nombre,"
                + "m.anio,"
                + "m.duration "
                + "FROM movie m "
                + "INNER JOIN genre g "
                + "ON m.id_genre=g.id_genre "
                + "ORDER BY m.title";

        return q.getQuerty(sql);

    }

    // Buscar por género
    public ResultSet buscarGenero(int idGenero) {

        String sql =
                "SELECT "
                + "m.title,"
                + "g.nombre,"
                + "m.anio,"
                + "m.duration "
                + "FROM movie m "
                + "INNER JOIN genre g "
                + "ON m.id_genre=g.id_genre "
                + "WHERE m.id_genre="
                + idGenero
                + " ORDER BY m.title";

        return q.getQuerty(sql);

    }

    // Buscar por título
    public ResultSet buscarTitulo(String titulo) {

        String sql =
                "SELECT "
                + "m.title,"
                + "g.nombre,"
                + "m.anio,"
                + "m.duration "
                + "FROM movie m "
                + "INNER JOIN genre g "
                + "ON m.id_genre=g.id_genre "
                + "WHERE m.title LIKE '%"
                + titulo
                + "%' "
                + "ORDER BY m.title";

        return q.getQuerty(sql);

    }

}
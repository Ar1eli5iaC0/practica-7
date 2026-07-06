package model;

import libreria_generica.generic;

public class pelicula {
	generic<Integer,Integer> gen2;
	generic<String,?> gen3;
	public pelicula(int id_pelicula, int id_genero, String titulo, String resume, int anio, int duracion) {
		super();
		this.gen2 = new generic(id_pelicula,id_genero,anio,duracion);
		this.gen3 = new generic(titulo,resume);
	}
	public int getId_pelicula() {
		return gen2.getAttribute1();
	}
	public void setId_pelicula(int id_pelicula) {
		this.gen2.setAttribute1(Integer.valueOf(id_pelicula));
	}
	public int getId_genero() {
		return gen2.getAttribute2();
	}
	public void setId_genero(int id_genero) {
		this.gen2.setAttribute2(Integer.valueOf(id_genero));
	}
	public String getTitulo() {
		return gen3.getAttribute1();
	}
	public void setTitulo(String titulo) {
		this.gen3.setAttribute1(titulo);
	}
	public String getResume() {
		return gen3.getAttribute2();
	}
	public void setResume(String resume) {
		this.gen3.setAttribute2(resume);
	}
	public int getAnio() {
		return gen2.getAttribute3();
	}
	public void setAnio(int anio) {
		this.gen2.setAttribute3(Integer.valueOf(anio));
	}
	public int getDuracion() {
		return gen2.getAttribute4();
	}
	public void setDuracion(int duracion) {
		this.gen2.setAttribute4(Integer.valueOf(duracion));
	}
	
}

package model;

import libreria_generica.generic;

public class genero {
	generic<Integer,String> gen1;
	public genero(int id_genero, String nombre) {
		super();
		this.gen1= new generic(id_genero,nombre);
	}
	public int getId_geenro() {
		return gen1.getAttribute1();
	}
	public void setId_geenro(int id_geenro) {
		this.gen1.setAttribute1(Integer.valueOf(id_geenro));
	}
	public String getNombre() {
		return gen1.getAttribute3();
	}
	public void setNombre(String nombre) {
		this.gen1.setAttribute3(nombre);
	}
	@Override
	public String toString() {

		return getNombre();

	}

}

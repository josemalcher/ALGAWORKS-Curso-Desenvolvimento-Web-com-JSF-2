package com.cursojsf2;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PerfilUsuarioBean {
	private String sexo;
	private boolean receverNovidades;
	private String[] linguagensFavoritas;
	
	public String enviar() {
		return "Confirmacao";// página
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public boolean isReceverNovidades() {
		return receverNovidades;
	}
	public void setReceverNovidades(boolean receverNovidades) {
		this.receverNovidades = receverNovidades;
	}
	public String[] getLinguagensFavoritas() {
		return linguagensFavoritas;
	}
	public void setLinguagensFavoritas(String[] linguagensFavoritas) {
		this.linguagensFavoritas = linguagensFavoritas;
	}
	
	
}

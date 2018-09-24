package com.cursojsf2;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CadastroCVBean {
	private String vaga = "A0382D";
	private String cargo = "Programador Java Senior";
	
	public String getVaga() {
		return vaga;
	}
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}

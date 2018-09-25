package com.cursojsf2;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConsultaClienteBean {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public List<Cliente> getClientes(){
		return this.clientes;
	}

	public void consultar() {
		this.getClientes().add(new Cliente(1, "Jose Malcher", "Belém"));
		this.getClientes().add(new Cliente(2, "Jose Silva", "Cametá"));
		this.getClientes().add(new Cliente(3, "Jose Parente", "SP"));
		this.getClientes().add(new Cliente(4, "Jose Stelio", "RIO"));
		this.getClientes().add(new Cliente(5, "Jose Junior", "Floripa"));
		this.getClientes().add(new Cliente(6, "Jose Maria", "SP"));
		this.getClientes().add(new Cliente(7, "Jose Carlos", "EUA"));
	}
	
}

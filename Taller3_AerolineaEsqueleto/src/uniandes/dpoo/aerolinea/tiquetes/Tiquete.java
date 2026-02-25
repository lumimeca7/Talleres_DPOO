package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
	private Cliente cliente;
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		super();
		this.codigo = codigo;
		this.cliente = clienteComprador;
		this.tarifa = tarifa;
		this.vuelo = vuelo;
		this.usado = false;
		
		clienteComprador.agregarTiquete(this);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getTarifa() {
		return tarifa;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}
	
	public boolean esUsado() {
		return usado;
	}
	
	public void marcarComoUsado() {
		usado = true;
	}
	
	
	
	

}

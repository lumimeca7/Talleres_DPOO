package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;

public class Vuelo {
	
	private Avion avion;
	private String fecha;
	private Ruta ruta;
	private Map<String,Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		super();
		this.avion = avion;
		this.fecha = fecha;
		this.ruta = ruta;
		this.tiquetes = new HashMap<String, Tiquete>();
		
	}

	public Avion getAvion() {
		return avion;
	}

	public String getFecha() {
		return fecha;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public Collection<Tiquete> getTiquetes() {
		return tiquetes.values();
	}
	
	public int venderTiquetes (Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
		
		int vendidos = tiquetes.size();
		int capacidad = avion.getCapacidad();
		
		if(vendidos + cantidad > capacidad) {
			throw new VueloSobrevendidoException(this);
		}
		
		int total = 0;
		
		for (int i = 0; i < cantidad; i++) {
			
			int tarifa = calculadora.calcularTarifa(this, cliente);
			
			Tiquete tiq =  GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
			
			tiquetes.put(tiq.getCodigo(),tiq);
			total += tarifa;
			
		}
		return total;
		
	}
	
	
	
	
	
	

}

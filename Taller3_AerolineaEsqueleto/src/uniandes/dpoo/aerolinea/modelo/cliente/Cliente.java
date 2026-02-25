package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;

public abstract class Cliente {

	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	public Cliente() {
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();
		
	}
	
	public void agregarTiquete( Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int total = 0;
		
		for (Tiquete tiquete : tiquetesSinUsar) {
			
			total += tiquete.getTarifa();
		}
		
		for (Tiquete tiquete : tiquetesUsados) {
			total += tiquete.getTarifa();
		}
		
		return total;
	}
	public void usarTiquetes (Vuelo vuelo) {
		List<Tiquete> usadosEnEsteVuelo = new ArrayList<Tiquete>();

		for (Tiquete tiquete : tiquetesSinUsar) {

			if (tiquete.getVuelo().equals(vuelo)) {
				tiquete.marcarComoUsado();
				usadosEnEsteVuelo.add(tiquete);}

		}
		tiquetesSinUsar.removeAll(usadosEnEsteVuelo);
		tiquetesUsados.addAll(usadosEnEsteVuelo);
		
	}
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
}

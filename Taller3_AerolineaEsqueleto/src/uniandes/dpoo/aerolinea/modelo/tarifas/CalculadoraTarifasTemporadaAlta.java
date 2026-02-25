package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	
	protected final int COSTO_POR_KM = 1000;

	public CalculadoraTarifasTemporadaAlta() {
		super();
	}

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		Ruta camino = vuelo.getRuta();
		int distancia = calcularDistanciaVuelo(camino);
		
		return distancia * COSTO_POR_KM;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}

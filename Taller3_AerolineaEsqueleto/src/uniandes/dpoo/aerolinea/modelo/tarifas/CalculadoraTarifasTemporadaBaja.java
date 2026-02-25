package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	
	protected final int COSTO_POR_KM_COPORATIVO = 600;
	protected final int COSTO_POR_KM_NATURAL = 900;
	protected final double DESCUENTOS_GRANDES = 0.02;
	protected final double DESCUENTOS_MEDIANAS = 0.01;
	protected final double DESCUENTOS_PEQ = 0.2;
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		Ruta camino = vuelo.getRuta();
		int distancia = calcularDistanciaVuelo(camino);
		
		if (cliente instanceof ClienteNatural) {
			return distancia * COSTO_POR_KM_NATURAL;
		}
		else {
			return distancia * COSTO_POR_KM_COPORATIVO;
		}
		
	}
	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		
		if (cliente instanceof ClienteCorporativo) {
			ClienteCorporativo clientcorp = (ClienteCorporativo) cliente;
			int tamano = clientcorp.getTamanoEmpresa();
			
			if (tamano == ClienteCorporativo.PEQUENA) 
				return DESCUENTOS_PEQ;
			
			else if (tamano == ClienteCorporativo.MEDIANA) 
				return DESCUENTOS_MEDIANAS;
			
			else
				return DESCUENTOS_GRANDES;
		}
		return 0;
	}
	
	

}

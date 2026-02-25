package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas {
	
	public static final double IMPUESTO = 0.28;

	public CalculadoraTarifas() {
		super();
	}
	
	protected abstract int calcularCostoBase (Vuelo vuelo,Cliente cliente);
	
	protected int calcularDistanciaVuelo (Ruta ruta) {
		
		Aeropuerto destin = ruta.getDestino();
		Aeropuerto orig = ruta.getOrigen();
		
		return Aeropuerto.calcularDistancia(destin,orig);
	}
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	protected int calcularValorImpuestos (int costoBase) {
		return (int) (costoBase / IMPUESTO);
	}
	
	public int calcularTarifa (Vuelo vuelo, Cliente cliente) {
		
		int costoBase = calcularCostoBase(vuelo, cliente);
		double descuento = calcularPorcentajeDescuento(cliente);
		
		int costoConDescuento = (int) (costoBase *(1-descuento));
		int impuestos = calcularValorImpuestos(costoConDescuento);
		
		return costoConDescuento + impuestos;
		
		
		
	}
	
	

}

package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.ClienteRepetidoException;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteTiqueteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class PersistenciaAerolineaJson  implements IPersistenciaAerolinea{

	@Override
	public void cargarAerolinea​(String archivo, Aerolinea aerolinea) throws InformacionInconsistenteException {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void salvarAerolinea​(String archivo, Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub

	}
	//
	// No se encontró un archivo JSON sobre el cual se pudiera basar esta persistencia. En las carpertas de docs solo se encuentra el JSON de tiquetes.
	//
}

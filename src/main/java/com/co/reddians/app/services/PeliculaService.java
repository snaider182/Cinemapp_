package com.co.reddians.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.co.reddians.app.model.Pelicula;

@Service
public class PeliculaService implements PeliculaServiceImpl{

	private List<Pelicula> lista = null;
	public PeliculaService() {
		System.out.println("Creando Instancia de la clase Pelicula Service");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			lista = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Titanic");
			pelicula1.setDuracion(130);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Emocion");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Dead Pool");
			pelicula2.setDuracion(140);
			pelicula2.setClasificacion("D");
			pelicula2.setGenero("Accion");
			pelicula2.setFechaEstreno(formatter.parse("12-04-2018"));
			pelicula2.setImagen("Dead.png");
			
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Titanes");
			pelicula3.setDuracion(150);
			pelicula3.setClasificacion("T");
			pelicula3.setGenero("Accion");
			pelicula3.setFechaEstreno(formatter.parse("14-06-2016"));
			pelicula3.setImagen("Titanes.png");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Koon");
			pelicula4.setDuracion(110);
			pelicula4.setClasificacion("K");
			pelicula4.setGenero("Misterio");
			pelicula4.setFechaEstreno(formatter.parse("25-03-2015"));
			pelicula4.setImagen("Kong.png");
			pelicula4.setEstatus("Inactiva");

			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());	
		}
	}
	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}


}

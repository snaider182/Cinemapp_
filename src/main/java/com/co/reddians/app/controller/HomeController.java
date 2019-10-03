package com.co.reddians.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.reddians.app.model.Pelicula;
import com.co.reddians.app.util.Utileria;

@Controller
public class HomeController {
	
	private SimpleDateFormat datFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String buscarPorFecha(@RequestParam("selFecha") String fecha, Model model) {
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = getLista();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		System.out.print("Buscando peliculas para la fecha"+fecha);
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = getLista();
		// peliculas.add("Rapido y Furios");
		// peliculas.add("El aro");
		// peliculas.add("Aliens");
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", datFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);

		return "home";
	}

	//@RequestMapping(value = "/detail/{id}/{fecha}", method=RequestMethod.GET)
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam ("fecha") String fechaBusqueda) {
	//public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable ("fecha") String fechaBusqueda) {
		
		System.out.println("idPelicula: "+idPelicula);
		System.out.println("Fecha Busqueda: "+fechaBusqueda);
		
		return "detalle";
	}

	// Metodo para generar una lista de tipo pelicula
	private List<Pelicula> getLista() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;
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

			return lista;
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
}

package com.co.reddians.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.co.reddians.app.model.Pelicula;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<Pelicula> peliculas = getLista();
		// peliculas.add("Rapido y Furios");
		// peliculas.add("El aro");
		// peliculas.add("Aliens");
		model.addAttribute("peliculas", peliculas);

		return "home";
	}

	@RequestMapping(value = "/detail")
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rapido y Furioso 8";
		int duracion = 139;
		double precioEntrada = 50;
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
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
			pelicula2.setDuracion(130);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Accion");
			pelicula2.setFechaEstreno(formatter.parse("12-04-2018"));

			lista.add(pelicula1);
			lista.add(pelicula2);

			return lista;
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
}

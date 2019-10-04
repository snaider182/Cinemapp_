package com.co.reddians.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.reddians.app.model.Pelicula;
import com.co.reddians.app.services.PeliculaServiceImpl;
import com.co.reddians.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private PeliculaServiceImpl servicePelicula;
	
	private SimpleDateFormat datFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String buscarPorFecha(@RequestParam("selFecha") String fecha, Model model) {
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = servicePelicula.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		System.out.print("Buscando peliculas para la fecha"+fecha);
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = servicePelicula.buscarTodas();
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

	
}

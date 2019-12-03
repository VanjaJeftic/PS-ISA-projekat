package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rs.ac.uns.ftn.informatika.jpa.service.PregledService;

@Controller
public class PreglediController {

	@Autowired
	private  PregledService pServis;
	

	@RequestMapping("/preglediIoperacijePrikaz")
	public String prikazStraniceListaPregledaIOperacija(HttpServletRequest request) {
		return "listaPregledaIOperacija";
	}
	
	
	@RequestMapping("/prikaziListuPregleda")
	public String idiNaPrikazListePregelda(HttpServletRequest request) {
		request.setAttribute("pregledi", pServis.pokaziSvePreglede());
		request.setAttribute("mode", "ALL_PREGLEDI");
		return "listaPregledaIOperacija";
	}
	
	@RequestMapping("/naLogin")
	public String koranUnazad(HttpServletRequest request) {
		return "loginBezDobrodosli";
	}
	
	
	
	
}

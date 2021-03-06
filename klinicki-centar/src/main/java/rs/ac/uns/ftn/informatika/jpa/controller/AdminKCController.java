package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import rs.ac.uns.ftn.informatika.jpa.dto.DijagnozaDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.InformacijeOpregleduDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.KlinikaDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.LekDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.Response;
import rs.ac.uns.ftn.informatika.jpa.model.Dijagnoza;
import rs.ac.uns.ftn.informatika.jpa.model.InformacijeOpregledu;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;
import rs.ac.uns.ftn.informatika.jpa.model.Role;
import rs.ac.uns.ftn.informatika.jpa.service.DijagnozaServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekServiceImpl;
import rs.uns.ac.ftn.informatika.jpa.constatns.AppConstant;

@Controller
public class AdminKCController {
	

	private Logger logger = LoggerFactory.getLogger(AdminKCController.class);
	
	@Autowired
	private EmailService emailService;
	
	 @Autowired
	    private KorisnikService korisnikService;
	 
	 @Autowired
	 private KlinikaService klinikaService;
	
	 
	 @Autowired
	 private LekServiceImpl lekService;
	 
	 @Autowired
	 private DijagnozaServiceImpl dijagnozaService;

	 	@Value("${max.result.per.page}")
	    private int maxResults;

	    @Value("${max.card.display.on.pagination.tray}")
	    private int maxPaginationTraySize;

	    
	    
	    

	   /* @GetMapping("/zahteviRegistrovanje")
	    public ModelAndView home(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
	                             @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
	                             HttpServletRequest request, HttpServletResponse response) {

	        ModelAndView modelAndView = new ModelAndView();
	     
	            modelAndView.setViewName("home");
	            Page<Korisnik> allUsers = korisnikService.listUsers(PageRequest.of(page, size, Sort.by("firstName")));
	            modelAndView.addObject("allUsers", allUsers);
	            modelAndView.addObject("maxTraySize", size);
	            modelAndView.addObject("currentPage", page);

	        return modelAndView;
	    }*/



	   /* @GetMapping("/searchBox")
	    public ModelAndView searchByTerm(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
	                                     @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
	                                     @RequestParam(value = "searchTerm", required = false) String searchTerm) {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("home");
	        Page<Korisnik> allUsers = korisnikService.searchByTerm(searchTerm.trim(), PageRequest.of(page, size, Sort.by("firstName")));
	        modelAndView.addObject("allUsers", allUsers);
	        modelAndView.addObject("maxTraySize", size);
	        modelAndView.addObject("currentPage", page);
	        return modelAndView;
	    }*/



	    @GetMapping("/search")
	    public ModelAndView search() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("search");
	        return modelAndView;
	    }

	 /*   @GetMapping("/lekovi")
	    public ModelAndView lekovi(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
                HttpServletRequest request, HttpServletResponse response) {
	    	 ModelAndView modelAndView = new ModelAndView();
	    	 modelAndView.setViewName("lekovi");
	         Page<Lek> allLekovi = lekService.listUsers(PageRequest.of(page, size, Sort.by("sifra")));
	         modelAndView.addObject("allLekovi", allLekovi);
	         modelAndView.addObject("maxTraySize", size);
	         modelAndView.addObject("currentPage", page);
	    	return null;
	    	
	    }

	  /*  @PostMapping("/searchSubmit")
	    public ModelAndView searchSubmit(@ModelAttribute SearchDTO searchDto) {
	        List<Korisnik> result = korisnikService.searchBy(searchDto.getSearchKeyword(), searchDto.getCriteria());
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("search");
	        modelAndView.addObject("result", result);
	        return modelAndView;
	    }*/



	    @GetMapping("/addNewAdminKC")
	    public ModelAndView addNewAdminKC() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-admin-kc");
	        return modelAndView;
	    }
	    
	    @GetMapping("/addNewAdminKlinike")
	    public ModelAndView addNewAdminKlinike() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-admin-klinike");
	        return modelAndView;
	    }

	    @GetMapping("/admin")
	    public ModelAndView addmin() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("admin");
	        return modelAndView;
	    }
	    
	    @GetMapping("/addNewDijagnoza")
	    public ModelAndView addNewDijagnoza() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-dijagnoza");
	        return modelAndView;
	    }

	    @GetMapping("/addNewKlinika")
	    public ModelAndView addNewKlinika() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-klinika");
	        return modelAndView;
	    }
	    
	    @GetMapping("/addNewLek")
	    public ModelAndView addNewLek() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-lek");
	        return modelAndView;
	    }
	    
	    @PostMapping("/noviLek")
	    public String noviLek(@ModelAttribute LekDTO lek) {
	        String result = "redirect:/";
	        Lek dbLek=lekService.findBySifra(lek.getSifra());
	        Lek lekic=new Lek();
	        lekic.setNaziv(lek.getNaziv());
	        lekic.setDodatno(lek.getDodatno());
	        lekic.setSifra(lek.getSifra());
	        if(lek.getNaziv()==null || lek.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewLek?error=Unesite naziv";
	        }
	        if (lek.getSifra() == null || lek.getSifra().trim().isEmpty()) {
	            result = "redirect:/addNewLek?error=Unesite sifru";
	        } else if (lek.getDodatno() == null || lek.getDodatno().trim().isEmpty()) {
	            result = "redirect:/addNewLek?error=Enter valid last name";
	        } 
	        if (dbLek == null) {
	            lekService.sacuvajLek(lekic);
	            result="redirect:/lekovi";
	        } else {
	            result = "redirect:/addNewLek?error=Lek vec postoji!";
	        }

	        return result;
	    }
	    
	    @PostMapping("/noviAdminKC")
	    public String noviAdminKC(@ModelAttribute KorisnikDTO korisnik) {
	        String result = "redirect:/";
	        Korisnik dbKorisnik=korisnikService.findByUsername(korisnik.getUsername());
	        Korisnik novi=new Korisnik();
	        novi.setUsername(korisnik.getUsername());
	        novi.setIme(korisnik.getIme());
	        System.out.println(novi.getIme());
	        novi.setPrezime(korisnik.getPrezime());
	        novi.setEmail(korisnik.getEmail());
	        novi.setPassword(korisnik.getPassword());
	        novi.setDrzava(korisnik.getDrzava());
	        novi.setGrad(korisnik.getGrad());
	        novi.setAdresa(korisnik.getAdresa());
	        novi.setTelefon(korisnik.getTelefon());
	        novi.setJedBrOsig(korisnik.getJedBrOsig());
	        novi.setFirst_Login(true);
	        novi.setIsActive(false);
	        novi.setRoleName(Role.ADMIN.name());
	        
	    
	        if(korisnik.getUsername()==null || korisnik.getUsername().trim().isEmpty()) {
	        	result = "redirect:/addNewAdminKC?error=Unesite naziv";
	        }
	        if (korisnik.getPassword() == null || korisnik.getPassword().trim().isEmpty()) {
	            result = "redirect:/addNewAdminKC?error=Unesite sifru";
	        } else if (korisnik.getEmail() == null || korisnik.getEmail().trim().isEmpty()) {
	            result = "redirect:/addNewAdminKC?error=Enter valid last name";
	        } 
	        if (dbKorisnik == null) {
	            korisnikService.saveMogKorisnika(novi); 
	            result="redirect:/pregledSvihAdmina";
	        } else {
	            result = "redirect:/addNewAdminKC?error=Lek vec postoji!";
	        }

	        try {
				emailService.sendNotificaitionZaAdminaKC(novi);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return result;
	    }
	    
	    @PostMapping("/noviAdminKlinike")
	    public String noviAdminKlinike(@ModelAttribute KorisnikDTO korisnik,HttpServletRequest request) {
	        String result = "redirect:/";
	        
	        Korisnik dbKorisnik=korisnikService.findByUsername(korisnik.getUsername());
	        Korisnik novi=new Korisnik();
	        novi.setUsername(korisnik.getUsername());
	        novi.setIme(korisnik.getIme());
	        System.out.println(novi.getIme());
	        novi.setPrezime(korisnik.getPrezime());
	        novi.setEmail(korisnik.getEmail());
	        novi.setPassword(korisnik.getPassword());
	        novi.setDrzava(korisnik.getDrzava());
	        novi.setGrad(korisnik.getGrad());
	        novi.setAdresa(korisnik.getAdresa());
	        novi.setTelefon(korisnik.getTelefon());
	        novi.setJedBrOsig(korisnik.getJedBrOsig());
	        novi.setFirst_Login(true);
	        novi.setIsActive(false);
	        novi.setRoleName(Role.ADMIN_KLINIKE.name());
	        String naziv=request.getParameter("odabrana");
	        
	        Klinika clinic=klinikaService.findByNaziv(naziv);
	        System.out.println("KLINIKA "+ clinic.getNaziv());
	        //Klinika nova=new Klinika();
	        novi.setKlinika(clinic);
	        
	    
	        if(korisnik.getUsername()==null || korisnik.getUsername().trim().isEmpty()) {
	        	result = "redirect:/addNewAdminKlinike?error=Unesite naziv";
	        }
	        if (korisnik.getPassword() == null || korisnik.getPassword().trim().isEmpty()) {
	            result = "redirect:/addNewAdminKlinike?error=Unesite sifru";
	        } else if (korisnik.getEmail() == null || korisnik.getEmail().trim().isEmpty()) {
	            result = "redirect:/addNewAdminKlinike?error=Enter valid last name";
	        } 
	        if (dbKorisnik == null) {
	            korisnikService.saveMogKorisnika(novi); 
	            result="redirect:/pregledSvihAdminaKlinike";
	        } else {
	            result = "redirect:/addNewAdminKlinike?error=Admin vec postoji!";
	        }

	        try {
				emailService.sendNotificaitionZaAdminaKlinike(novi);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return result;
	    }
	    
	  /*  @PostMapping("/noviAdminKC")
	    public String noviAdminKC(@ModelAttribute Korisnik lek) {
	        String result = "redirect:/";
	        Lek dbLek=lekService.findBySifra(lek.getSifra());
	        if(lek.getNaziv()==null || lek.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewLek?error=Unesite naziv";
	        }
	        if (lek.getSifra() == null || lek.getSifra().trim().isEmpty()) {
	            result = "redirect:/addNewLek?error=Unesite sifru";
	        } else if (lek.getDodatno() == null || lek.getDodatno().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid last name";
	        } 
	        if (dbLek == null) {
	            lekService.sacuvajLek(lek);
	            result="redirect:/lekovi";
	        } else {
	            result = "redirect:/addNewUser?error=Lek vec postoji!";
	        }

	        return result;
	    }
	    */
	    @PostMapping("/novaDijagnoza")
	    public String novaDijagnoza(@ModelAttribute DijagnozaDTO dijagnoza) {
	        String result = "redirect:/";
	        Dijagnoza dbDijagnoza=dijagnozaService.findBySifra(dijagnoza.getSifra());
	        Dijagnoza dijagnozaN=new Dijagnoza();
	        dijagnozaN.setNaziv(dijagnoza.getNaziv());
	        dijagnozaN.setDodatno(dijagnoza.getDodatno());
	        dijagnozaN.setSifra(dijagnoza.getSifra());
	        if(dijagnoza.getNaziv()==null || dijagnoza.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewDijagnoza?error=Unesite naziv";
	        }
	        if (dijagnoza.getSifra() == null || dijagnoza.getSifra().trim().isEmpty()) {
	            result = "redirect:/addNewDijagnoza?error=Unesite sifru";
	        } else if (dijagnoza.getDodatno() == null || dijagnoza.getDodatno().trim().isEmpty()) {
	            result = "redirect:/addNewDijagnoza?error=Enter valid last name";
	        } 
	        if (dbDijagnoza == null) {
	            dijagnozaService.sacuvajDijagnozu(dijagnozaN);
	            result="redirect:/dijagnoze";
	        } else {
	            result = "redirect:/addNewDijagnoza?error=Dijagnoza vec postoji!";
	        }

	        return result;
	    }
	    
	    @PostMapping("/novaKlinika")
	    public String novaKlinika(@ModelAttribute KlinikaDTO klinika) {
	        String result = "redirect:/";
	        Klinika dbKlinika=klinikaService.findByNaziv(klinika.getNaziv());
	        Klinika klinikaN=new Klinika();
	        klinikaN.setNaziv(klinika.getNaziv());
	        klinikaN.setGrad(klinika.getGrad());
	        klinikaN.setDrzava(klinika.getDrzava());
	        klinikaN.setAdresa(klinika.getAdresa());
	        klinikaN.setTip(klinika.getTip());
	        if(klinika.getNaziv()==null || klinika.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewKlinika?error=Unesite naziv";
	        }
	        if (dbKlinika == null) {
	            klinikaService.sacuvajKliniku(klinikaN);
	            result="redirect:/klinike";
	        } else {
	            result = "redirect:/addNewKlinika?error=Klinika vec postoji!";
	        }

	        return result;
	    }
	    
	    
	    @GetMapping("/addNewZK")
	    public ModelAndView addNewZK(HttpServletRequest request) {
	    	List<Korisnik> k=korisnikService.pokaziBezKartona();
	    	List<KorisnikDTO> kDTO=new ArrayList<KorisnikDTO>();
	    	for(int i=0; i<k.size(); i++) {
	    		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    		korisnikDTO.setAdresa(k.get(i).getAdresa());
	    		korisnikDTO.setAlergije(k.get(i).getAlergije());
	    		korisnikDTO.setAnamneza(k.get(i).getAnamneza());
	    		korisnikDTO.setBolesti(k.get(i).getBolesti());
	    		korisnikDTO.setDatum(k.get(i).getDatum());
	    		korisnikDTO.setDioptrija(k.get(i).getDioptrija());
	    		korisnikDTO.setDrzava(k.get(i).getDrzava());
	    		korisnikDTO.setEmail(k.get(i).getEmail());
	    		korisnikDTO.setFirstLogin(k.get(i).getFirst_Login());
	    		korisnikDTO.setGrad(k.get(i).getGrad());
	    		korisnikDTO.setId(k.get(i).getId());
	    		korisnikDTO.setIme(k.get(i).getIme());
	    		korisnikDTO.setIsActive(k.get(i).getIsActive());
	    		korisnikDTO.setJedBrOsig(k.get(i).getJedBrOsig());
	    		korisnikDTO.setKgrupa(k.get(i).getKgrupa());
	    		korisnikDTO.setPassword(k.get(i).getPassword());
	    		korisnikDTO.setPol(k.get(i).getPol());
	    		korisnikDTO.setPrezime(k.get(i).getPrezime());
	    		korisnikDTO.setRole(k.get(i).getRoleName());
	    		korisnikDTO.setTelefon(k.get(i).getTelefon());
	    		korisnikDTO.setTezina(k.get(i).getTezina());
	    		korisnikDTO.setUsername(k.get(i).getUsername());
	    		korisnikDTO.setVisina(k.get(i).getVisina());
	    		
	    		kDTO.add(korisnikDTO);
	    	}
	    	
	    	request.setAttribute("korisnici", kDTO);
			request.setAttribute("mode", "ALL_USERS");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("addNewZK");
	        return modelAndView;
	    }
	    
	    @RequestMapping("/kreirajKarton/{korisnikId}")
	    public String enable(@PathVariable Long korisnikId,HttpServletRequest request) {
			 request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
				Korisnik k=korisnikService.findOne(korisnikId);

		   		KorisnikDTO korisnikDTO=new KorisnikDTO();
		    	korisnikDTO.setAdresa(k.getAdresa());
		    	korisnikDTO.setAlergije(k.getAlergije());
		    	korisnikDTO.setAnamneza(k.getAnamneza());
		    	korisnikDTO.setBolesti(k.getBolesti());
		    	korisnikDTO.setDatum(k.getDatum());
		    	korisnikDTO.setDioptrija(k.getDioptrija());
		    	korisnikDTO.setDrzava(k.getDrzava());
		    	korisnikDTO.setEmail(k.getEmail());
		    	korisnikDTO.setFirstLogin(k.getFirst_Login());
		    	korisnikDTO.setGrad(k.getGrad());
		    	korisnikDTO.setId(k.getId());
		    	korisnikDTO.setIme(k.getIme());
		    	korisnikDTO.setIsActive(k.getIsActive());
		    	korisnikDTO.setJedBrOsig(k.getJedBrOsig());
		    	korisnikDTO.setKgrupa(k.getKgrupa());
		    	korisnikDTO.setPassword(k.getPassword());
		    	korisnikDTO.setPol(k.getPol());
		    	korisnikDTO.setPrezime(k.getPrezime());
		    	korisnikDTO.setRole(k.getRoleName());
		    	korisnikDTO.setTelefon(k.getTelefon());
		    	korisnikDTO.setTezina(k.getTezina());
		    	korisnikDTO.setUsername(k.getUsername());
		    	korisnikDTO.setVisina(k.getVisina());
		    	request.setAttribute("korisnik", korisnikDTO);
				request.setAttribute("mode", "MODE_PREGLED");
				return "create-zk";   
		}
	    
	    @RequestMapping(value="/nov", method = { RequestMethod.GET, RequestMethod.POST }) 
		public String sacuvajZK(@ModelAttribute KorisnikDTO korisnikd, HttpServletRequest request) {
			
	    	HttpSession session = request.getSession();
	    	Object id2 = session.getAttribute("id");
	    	System.out.println(id2);
	    	Korisnik izBaze=korisnikService.findOne(korisnikd.getId());
			System.out.println("ISPISISI "+ izBaze.getId());
			Korisnik k = new Korisnik();
			k.setId(izBaze.getId());
			System.out.println("ONO STO JE ID SAD : "+k.getId());
			k.setId(izBaze.getId());
			k.setIme(izBaze.getIme());
			k.setPrezime(izBaze.getPrezime());
			k.setJedBrOsig(izBaze.getJedBrOsig());
			k.setEmail(izBaze.getEmail());
			k.setAdresa(izBaze.getAdresa());
			k.setDrzava(izBaze.getDrzava());
			k.setGrad(izBaze.getGrad());
			k.setTelefon(izBaze.getTelefon());
			k.setUsername(izBaze.getUsername());
			k.setPassword(izBaze.getPassword());
			k.setIsActive(izBaze.getIsActive());
			k.setFirst_Login(true);
			k.setRoleName(Role.PACIJENT.name());
			k.setDatum(korisnikd.getDatum());
			k.setPol(korisnikd.getPol());
			k.setVisina(korisnikd.getVisina());
			k.setTezina(korisnikd.getTezina());
			k.setKgrupa(korisnikd.getKgrupa());
			k.setDioptrija(korisnikd.getDioptrija());
			k.setAlergije(korisnikd.getAlergije());
			k.setBolesti(korisnikd.getBolesti());
			k.setAnamneza(korisnikd.getAnamneza());
			korisnikService.saveMogKorisnika(k);
			return "uspesanZK";

		}
	    
	    
	    @GetMapping("/zahteviRegistrovanje")
	    public ModelAndView zahtevi(HttpServletRequest request) {
	    	
	    	List<Korisnik> k=korisnikService.pokaziSveZahteve();
	    	List<KorisnikDTO> kDTO=new ArrayList<KorisnikDTO>();
	    	for(int i=0; i<k.size(); i++) {
	    		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    		korisnikDTO.setAdresa(k.get(i).getAdresa());
	    		korisnikDTO.setAlergije(k.get(i).getAlergije());
	    		korisnikDTO.setAnamneza(k.get(i).getAnamneza());
	    		korisnikDTO.setBolesti(k.get(i).getBolesti());
	    		korisnikDTO.setDatum(k.get(i).getDatum());
	    		korisnikDTO.setDioptrija(k.get(i).getDioptrija());
	    		korisnikDTO.setDrzava(k.get(i).getDrzava());
	    		korisnikDTO.setEmail(k.get(i).getEmail());
	    		korisnikDTO.setFirstLogin(k.get(i).getFirst_Login());
	    		korisnikDTO.setGrad(k.get(i).getGrad());
	    		korisnikDTO.setId(k.get(i).getId());
	    		korisnikDTO.setIme(k.get(i).getIme());
	    		korisnikDTO.setIsActive(k.get(i).getIsActive());
	    		korisnikDTO.setJedBrOsig(k.get(i).getJedBrOsig());
	    		korisnikDTO.setKgrupa(k.get(i).getKgrupa());
	    		korisnikDTO.setPassword(k.get(i).getPassword());
	    		korisnikDTO.setPol(k.get(i).getPol());
	    		korisnikDTO.setPrezime(k.get(i).getPrezime());
	    		korisnikDTO.setRole(k.get(i).getRoleName());
	    		korisnikDTO.setTelefon(k.get(i).getTelefon());
	    		korisnikDTO.setTezina(k.get(i).getTezina());
	    		korisnikDTO.setUsername(k.get(i).getUsername());
	    		korisnikDTO.setVisina(k.get(i).getVisina());
	    		
	    		kDTO.add(korisnikDTO);
	    	}
	    	request.setAttribute("korisnici", kDTO);
			request.setAttribute("mode", "ALL_USERS");
	        ModelAndView modelAndView = new ModelAndView();
	        if(korisnikService.pokaziSveZahteve()==null) {
	        	modelAndView.setViewName("nemaZahteva");
	        }
	        modelAndView.setViewName("pregledZahteva");
	        return modelAndView;
	    }

	    @GetMapping("/sviIzBaze")
	    public ModelAndView svi(HttpServletRequest request) {
	    	List<Korisnik> k=korisnikService.pokaziSvePacijente();
	    	List<KorisnikDTO> kDTO=new ArrayList<KorisnikDTO>();
	    	for(int i=0; i<k.size(); i++) {
	    		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    		korisnikDTO.setAdresa(k.get(i).getAdresa());
	    		korisnikDTO.setAlergije(k.get(i).getAlergije());
	    		korisnikDTO.setAnamneza(k.get(i).getAnamneza());
	    		korisnikDTO.setBolesti(k.get(i).getBolesti());
	    		korisnikDTO.setDatum(k.get(i).getDatum());
	    		korisnikDTO.setDioptrija(k.get(i).getDioptrija());
	    		korisnikDTO.setDrzava(k.get(i).getDrzava());
	    		korisnikDTO.setEmail(k.get(i).getEmail());
	    		korisnikDTO.setFirstLogin(k.get(i).getFirst_Login());
	    		korisnikDTO.setGrad(k.get(i).getGrad());
	    		korisnikDTO.setId(k.get(i).getId());
	    		korisnikDTO.setIme(k.get(i).getIme());
	    		korisnikDTO.setIsActive(k.get(i).getIsActive());
	    		korisnikDTO.setJedBrOsig(k.get(i).getJedBrOsig());
	    		korisnikDTO.setKgrupa(k.get(i).getKgrupa());
	    		korisnikDTO.setPassword(k.get(i).getPassword());
	    		korisnikDTO.setPol(k.get(i).getPol());
	    		korisnikDTO.setPrezime(k.get(i).getPrezime());
	    		korisnikDTO.setRole(k.get(i).getRoleName());
	    		korisnikDTO.setTelefon(k.get(i).getTelefon());
	    		korisnikDTO.setTezina(k.get(i).getTezina());
	    		korisnikDTO.setUsername(k.get(i).getUsername());
	    		korisnikDTO.setVisina(k.get(i).getVisina());
	    		
	    		kDTO.add(korisnikDTO);
	    	}
	    	request.setAttribute("korisnici", kDTO);
			request.setAttribute("mode", "ALL_USERS");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("sviIzBaze");
	        return modelAndView;
	    }
	    
	    @GetMapping("/klinike")
	    public ModelAndView klinike(HttpServletRequest request) {
	    	List<Klinika> k=klinikaService.pokaziSveKlinike();
	    	List<KlinikaDTO> kDTO=new ArrayList<KlinikaDTO>();
	    	for(int i=0; i<k.size(); i++) {
	    		KlinikaDTO klinikaDTO=new KlinikaDTO();
	    		klinikaDTO.setAdresa(k.get(i).getAdresa());
	    		klinikaDTO.setDrzava(k.get(i).getDrzava());
	    		klinikaDTO.setGrad(k.get(i).getGrad());
	    		klinikaDTO.setId(k.get(i).getId());
	    		klinikaDTO.setNaziv(k.get(i).getNaziv());
	    		klinikaDTO.setOcena(k.get(i).getOcena());
	    		klinikaDTO.setTip(k.get(i).getTip());
	    		
	    		kDTO.add(klinikaDTO);
	    	}
	    	request.setAttribute("klinike", kDTO);
			request.setAttribute("mode", "ALL_KLINIKE");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("klinike");
	        return modelAndView;
	    }
	    
	    @GetMapping("/pregledSvihAdmina")
		public ModelAndView pokaziAdmineKC(HttpServletRequest request) {
	    	HttpSession session = request.getSession();
	    	Object id2 = session.getAttribute("id");
	    	System.out.println(id2);
	    	request.setAttribute("admin", id2);
	    	List<Korisnik> k=korisnikService.pokaziAdmine();
	    	List<KorisnikDTO> kDTO=new ArrayList<KorisnikDTO>();
	    	for(int i=0; i<k.size(); i++) {
	    		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    		korisnikDTO.setAdresa(k.get(i).getAdresa());
	    		korisnikDTO.setAlergije(k.get(i).getAlergije());
	    		korisnikDTO.setAnamneza(k.get(i).getAnamneza());
	    		korisnikDTO.setBolesti(k.get(i).getBolesti());
	    		korisnikDTO.setDatum(k.get(i).getDatum());
	    		korisnikDTO.setDioptrija(k.get(i).getDioptrija());
	    		korisnikDTO.setDrzava(k.get(i).getDrzava());
	    		korisnikDTO.setEmail(k.get(i).getEmail());
	    		korisnikDTO.setFirstLogin(k.get(i).getFirst_Login());
	    		korisnikDTO.setGrad(k.get(i).getGrad());
	    		korisnikDTO.setId(k.get(i).getId());
	    		korisnikDTO.setIme(k.get(i).getIme());
	    		korisnikDTO.setIsActive(k.get(i).getIsActive());
	    		korisnikDTO.setJedBrOsig(k.get(i).getJedBrOsig());
	    		korisnikDTO.setKgrupa(k.get(i).getKgrupa());
	    		korisnikDTO.setPassword(k.get(i).getPassword());
	    		korisnikDTO.setPol(k.get(i).getPol());
	    		korisnikDTO.setPrezime(k.get(i).getPrezime());
	    		korisnikDTO.setRole(k.get(i).getRoleName());
	    		korisnikDTO.setTelefon(k.get(i).getTelefon());
	    		korisnikDTO.setTezina(k.get(i).getTezina());
	    		korisnikDTO.setUsername(k.get(i).getUsername());
	    		korisnikDTO.setVisina(k.get(i).getVisina());
	    		
	    		kDTO.add(korisnikDTO);
	    	}
			request.setAttribute("korisnici", kDTO);
			request.setAttribute("mode", "ALL_ADMINI");
			ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("adminiKC");
		    return modelAndView;
		
		}
	    
	    @GetMapping("/pregledSvihAdminaKlinike")
		public ModelAndView pokaziAdmineKlinike(HttpServletRequest request) {
	    	List<Korisnik> k=korisnikService.pokaziAdmineKlinike();
	    	List<KorisnikDTO> kDTO=new ArrayList<KorisnikDTO>();
	    	List<KlinikaDTO> klDTO=new ArrayList<KlinikaDTO>();
	    	for(int i=0; i<k.size(); i++) {
	    		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    		korisnikDTO.setAdresa(k.get(i).getAdresa());
	    		korisnikDTO.setAlergije(k.get(i).getAlergije());
	    		korisnikDTO.setAnamneza(k.get(i).getAnamneza());
	    		korisnikDTO.setBolesti(k.get(i).getBolesti());
	    		korisnikDTO.setDatum(k.get(i).getDatum());
	    		korisnikDTO.setDioptrija(k.get(i).getDioptrija());
	    		korisnikDTO.setDrzava(k.get(i).getDrzava());
	    		korisnikDTO.setEmail(k.get(i).getEmail());
	    		korisnikDTO.setFirstLogin(k.get(i).getFirst_Login());
	    		korisnikDTO.setGrad(k.get(i).getGrad());
	    		korisnikDTO.setId(k.get(i).getId());
	    		korisnikDTO.setIme(k.get(i).getIme());
	    		korisnikDTO.setIsActive(k.get(i).getIsActive());
	    		korisnikDTO.setJedBrOsig(k.get(i).getJedBrOsig());
	    		korisnikDTO.setKgrupa(k.get(i).getKgrupa());
	    		korisnikDTO.setPassword(k.get(i).getPassword());
	    		korisnikDTO.setPol(k.get(i).getPol());
	    		korisnikDTO.setPrezime(k.get(i).getPrezime());
	    		korisnikDTO.setRole(k.get(i).getRoleName());
	    		korisnikDTO.setTelefon(k.get(i).getTelefon());
	    		korisnikDTO.setTezina(k.get(i).getTezina());
	    		korisnikDTO.setUsername(k.get(i).getUsername());
	    		korisnikDTO.setVisina(k.get(i).getVisina());
	    		
	    		kDTO.add(korisnikDTO);
	    		
	    	}
			request.setAttribute("korisnici", kDTO);
			request.setAttribute("klinike", klDTO);
			request.setAttribute("mode", "ALL_ADMINI_KLINIKE");
			ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("adminiKlinike");
		    return modelAndView;
		
		}
	    
	    @GetMapping("/lekovi")
	    public ModelAndView lekovi(HttpServletRequest request) {
	    	List<Lek> lekovi=lekService.showAll();
	    	List<LekDTO> lekoviDTO=new ArrayList<LekDTO>();
	    	for(int i=0; i<lekovi.size();i++) {
	    		LekDTO lekDTO=new LekDTO();
	    		lekDTO.setId(lekovi.get(i).getId());
	    		lekDTO.setDodatno(lekovi.get(i).getDodatno());
	    		lekDTO.setNaziv(lekovi.get(i).getNaziv());
	    		lekDTO.setSifra(lekovi.get(i).getSifra());
	    		
	    		lekoviDTO.add(lekDTO);
	    	}
	    	request.setAttribute("lekovi", lekoviDTO);
			request.setAttribute("mode", "ALL_LEKOVI");
	        ModelAndView modelAndView = new ModelAndView();
	        return modelAndView;
	    }

	    @GetMapping("/dijagnoze")
	    public ModelAndView dijagnoze(HttpServletRequest request) {
	    	List<Dijagnoza> dijagnoze=dijagnozaService.showAll();
	    	List<DijagnozaDTO> dDTO=new ArrayList<DijagnozaDTO>();
	    	for(int i=0; i<dijagnoze.size();i++) {
	    		DijagnozaDTO lekDTO=new DijagnozaDTO();
	    		lekDTO.setId(dijagnoze.get(i).getId());
	    		lekDTO.setDodatno(dijagnoze.get(i).getDodatno());
	    		lekDTO.setNaziv(dijagnoze.get(i).getNaziv());
	    		lekDTO.setSifra(dijagnoze.get(i).getSifra());
	    		
	    		dDTO.add(lekDTO);
	    	}
	    	request.setAttribute("dijagnoze", dDTO);
			request.setAttribute("mode", "ALL_DIJAGNOZE");
	        ModelAndView modelAndView = new ModelAndView();
	        return modelAndView;
	    }
	    
	    @GetMapping("/adminKlinike")
	    public ModelAndView adminiKlinike(HttpServletRequest request) {
	    	request.setAttribute("adminiKlinike", korisnikService.pokaziAdmineKlinike());
	    	System.out.println("atribut klinikea");
			request.setAttribute("mode", "ALL_ADMINI_KLINIKE");
			System.out.println("mode klinikea");
	        ModelAndView modelAndView = new ModelAndView();
	        System.out.println("modelbidjbkjdf");
	        return modelAndView;
	    }
	    
	    @ResponseBody
	    @PostMapping("/saveLek")
	    public Response update(@RequestBody LekDTO lek) {
	        Lek dbLek = lekService.findLekById(lek.getId());
	        dbLek.setNaziv(lek.getNaziv()); 
	        dbLek.setDodatno(lek.getDodatno());
	        lekService.sacuvajLek(dbLek);
	        return new Response(302, AppConstant.SUCCESS, "redirect:/lekovi");
	    }
	    
	    @GetMapping("/delete/{lekId}")
	    public String delete(@PathVariable Long lekId) {
	        lekService.obrisiLek(lekId); 
	        return "redirect:/lekovi";
	    }
	    
	    @ResponseBody
	    @PostMapping("/saveDijagnoza")
	    public Response updateDijagnoza(@RequestBody Dijagnoza dijagnoza) {
	        Dijagnoza dbDijagnoza = dijagnozaService.findDijagnozaById(dijagnoza.getId());
	        dbDijagnoza.setNaziv(dijagnoza.getNaziv()); 
	        dbDijagnoza.setDodatno(dijagnoza.getDodatno());
	        dijagnozaService.sacuvajDijagnozu(dbDijagnoza); 
	        return new Response(302, AppConstant.SUCCESS, "redirect:/lekovi");
	    }
	    
	    @GetMapping("/deleteDijagnoza/{dijagnozaId}")
	    public String deleteDijagnoza(@PathVariable Long dijagnozaId) {
	        dijagnozaService.obrisiDijagnozu(dijagnozaId);  
	        return "redirect:/dijagnoze";
	    }
	    
	    @GetMapping("/disable/{korisnikId}")
	    public ModelAndView disable(@PathVariable Long korisnikId,HttpServletRequest request) {
	        Korisnik k=korisnikService.findOne(korisnikId);
	        k.setIsActive(true);
	        k.setFirst_Login(false);
	        korisnikService.saveMogKorisnika(k);
	        
	      /*  try {
				emailService.sendNotificaitionOdbijenaRegistracija(k);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return "redirect:/zahteviRegistrovanje";*/
	        request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
			request.setAttribute("mode", "ODBIJANJE");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("razlogOdbijanja");
	        return modelAndView;
	    }
	    
	  
	    
	    
	    @GetMapping("/reject/{korisnikId}")
	    public String reject(@PathVariable Long korisnikId) {
	        Korisnik k=korisnikService.findOne(korisnikId);
	        k.setIsActive(true);
	        k.setFirst_Login(false);
	        korisnikService.saveMogKorisnika(k);
	        
	        try {
				emailService.sendNotificaitionOdbijenaRegistracija(k);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return "redirect:/zahteviRegistrovanje";
	    }
	    
	    @GetMapping("/enable/{korisnikId}")
	    public String enable(@PathVariable Long korisnikId) {
	        Korisnik k=korisnikService.findOne(korisnikId);
	        k.setIsActive(true);
	        k.setFirst_Login(true);
	        korisnikService.saveMogKorisnika(k);
	        
	        try {
				emailService.sendNotificaitionOdobrenaRegistracija(k);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return "redirect:/zahteviRegistrovanje";
	    }
	    
	    
	  /*  @ResponseBody
	    @PostMapping("/save")
	    public Response update(@RequestBody Korisnik user) {
	        Korisnik dbUser = userService.findById(user.getId());
	        dbUser.setFirstName(user.getFirstName());
	        dbUser.setLastName(user.getLastName());
	        userService.saveUser(dbUser);
	        return new Response(302, AppConstant.SUCCESS, "/");
	    }*/



	/*    @PostMapping("/registerAK")
	    public String registerAK(@ModelAttribute Korisnik user) {
	        String result = "redirect:/";
	        Korisnik dbUser = userService.findUserByEmail(user.getEmail());
	        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid fist name";
	        } else if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid last name";
	        } else if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid email";
	        } else if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid password";
	        } else if (StringUtils.isEmpty(user.getRoleName())) {
	            result = "redirect:/addNewUser?error=Select a valid Role";
	        }
	        if (dbUser == null) {
	            userService.saveUser(user);
	        } else {
	            result = "redirect:/addNewUser?error=User Already Exists!";
	        }

	        return result;
	    }



	    @GetMapping("/delete/{userId}")
	    public String delete(@PathVariable Long userId) {
	        korisnikService.deleteMyUser(userId);
	        return "redirect:/";
	    }



	/*    @ResponseBody
	    @GetMapping("/removeAll")
	    public Boolean removeAll() {
	        return korisnikService.removeAll();
	    }*/



	    @GetMapping("/403")
	    public ModelAndView accessDenied() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("403");
	        return modelAndView;
	    }



	    @GetMapping("/error")
	    public ModelAndView error() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("error");
	        return modelAndView;
	    }
	    

		@PostMapping("/editpassword")
		public String putEditPassword(@RequestParam Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,HttpServletRequest request) {
		
			request.setAttribute("korisnik", korisnikService.findOne(id));
			Korisnik korisnik=korisnikService.findOne(id);
			//Korisnik k=new Korisnik();
			Long Idx=korisnikd.getId();
			System.out.println("Pokupljen id iz fronta "+korisnikd.getId());
			korisnik.setPassword(korisnikd.getPassword());
			korisnik.setFirst_Login(false);
			korisnikService.saveMogKorisnika(korisnik);
			System.out.println(korisnik.getPassword());
				//map.put("logged", korisnik);
			
			return "admin";
		}
	    
		@PostMapping("/sacuvajNovaLozinka") // korisnik povezan sa valuom iz js
		public String UpdateKorisnik2(@RequestParam Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,
				HttpServletRequest request) {
		
			Korisnik izBaze=korisnikService.findOne(id);
			
			Korisnik k = new Korisnik();
			Long Idx = korisnikd.getId();
			k.setPassword(korisnikd.getPassword());
			korisnikService.saveMogKorisnika(k);

			try {
				emailService.sendNotificaitionSync(k);
			} catch (Exception e) {
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}

			return "uspesnaIzmenaInfo";

		}

		 @PostMapping("/razlogOdbijanja/{korisnikId}")
		    public String mejlOdbijanja(@PathVariable Long korisnikId,
					HttpServletRequest request) {
		        Korisnik k=korisnikService.findOne(korisnikId);
		       /* k.setId(korisnikd.getId());
		        k.setIme(korisnikd.getIme());
		        k.setPrezime(korisnikd.getPrezime());
		        k.setAdresa(korisnikd.getAdresa());
		        k.setDrzava(korisnikd.getDrzava());
		        k.setEmail(korisnikd.getEmail());
		        k.setGrad(korisnikd.getGrad());
		        k.setJedBrOsig(korisnikd.getJedBrOsig());
		        k.setUsername(korisnikd.getUsername());*/
		        String s=request.getParameter("razlog");
		       // String ss=request.getParameter("mail");
		      ///  System.out.println(ss);
		        try {
					emailService.sendNotificaitionRazlogOdbijanja(k,s);
				}catch( Exception e ){
					logger.info("Greska prilikom slanja emaila: " + e.getMessage());
				}
		        
		        return "redirect:/zahteviRegistrovanje";
		        
		    }
		 
		
}

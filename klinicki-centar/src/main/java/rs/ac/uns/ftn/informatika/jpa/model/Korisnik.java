package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="korisnik3")
public class Korisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "jedBrOsig", unique = true, nullable = false)
	String jedBrOsig;

	@Column(name = "username", unique = true, nullable = false)
	String username;
	
	@Column(name = "ime", nullable = false)
	private String ime;

	@Column(name = "prezime", nullable = false)
	private String prezime;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "adresa", nullable = false)
	private String adresa;
	
	@Column(name = "grad", nullable = false)
	private String grad;
	
	@Column(name = "drzava", nullable = false)
	private String drzava;
	
	@Column(name = "telefon", nullable = false)
	private String telefon;
	
	@Column(name = "password", nullable = false)
	private String password;

	
	public Korisnik() {
	}

	public Korisnik(String jedBrOsig, String korIme, String ime, String prezime, String email, String adresa,
			String grad, String drzava, String telefon, String sifra) {
		super();
		this.jedBrOsig = jedBrOsig;
		this.username = korIme;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.password = sifra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJedBrOsig() {
		return jedBrOsig;
	}

	public void setJedBrOsig(String jedBrOsig) {
		this.jedBrOsig = jedBrOsig;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String korIme) {
		this.username = korIme;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String sifra) {
		this.password = sifra;
	}

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", jedBrOsig=" + jedBrOsig + ", korIme=" + username + ", ime=" + ime + ", prezime="
				+ prezime + ", email=" + email + ", adresa=" + adresa + ", grad=" + grad + ", drzava=" + drzava
				+ ", telefon=" + telefon + ", sifra=" + password + "]";
	}
	
	

	
	
}

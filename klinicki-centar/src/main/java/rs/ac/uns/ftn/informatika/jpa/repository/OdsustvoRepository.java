package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Odsustvo;

public interface OdsustvoRepository extends JpaRepository<Odsustvo,Long>{
	
	public Odsustvo findByPocetak(String pocetak);
	public Odsustvo findByKraj(String kraj);
	public Odsustvo findByIdkorisnika(String id);
	
}

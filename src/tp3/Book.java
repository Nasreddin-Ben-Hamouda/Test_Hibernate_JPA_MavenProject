package tp3;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book  implements Serializable {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="title")
	private String title;
	@Column(name="nbrpages")
	private int nbrpages;
	@ManyToOne
    @JoinColumn(name="personne_id")
	private Personne personne;
	
	public Book() {
		super();
	}
	public Book(long id, String title, int nbrpages) {
		super();
		this.id = id;
		this.title = title;
		this.nbrpages = nbrpages;
	}
	public Book( String title, int nbrpages) {
		super();
		this.title = title;
		this.nbrpages = nbrpages;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNbrpages() {
		return nbrpages;
	}
	public void setNbrpages(int nbrpages) {
		this.nbrpages = nbrpages;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	


}

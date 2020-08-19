package tp3;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="personnes")
public class Personne implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
 @Column(name="prenom")
  private String prenom;
@Column(name="nom")
  private String nom;
@OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
  private List<Book> books; 

  private static final long serialVersionUID = 1L;

  public Personne() {
    super();
  }
  public Personne(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

  public List<Book> getBooks() {
	return books;
}


public void setBooks(List<Book> books) {
	this.books = books;
}





public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
}

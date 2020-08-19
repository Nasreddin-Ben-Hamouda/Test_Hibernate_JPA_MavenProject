package tp3;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class testjpa {
	public static void main(String[]argv) {    
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp3");  
	    EntityManager em = emf.createEntityManager(); 
	    bookRepository bookRep = new bookRepository(em);
        personneRepository personneRep = new personneRepository(em);
	    
	   /* EntityTransaction transac = em.getTransaction();
	    transac.begin();
	    Personne nouvellePersonne = new Personne();
	    nouvellePersonne.setNom("hamza");
	    nouvellePersonne.setPrenom("ben hamouda");
	    em.persist(nouvellePersonne);
	    transac.commit();*/
        Personne p=new Personne("hamza","ben hamouda");
        Optional<Personne> saverPersonne=personneRep.save(p);

        Book B1=new Book("ALGO",20);
        Book B2=new Book("ALGO2",30);
        B1.setPersonne(saverPersonne.get());
        B2.setPersonne(saverPersonne.get());
       Optional<Book> savedbook1=bookRep.save(B1);
        Optional<Book> savedbook2=bookRep.save(B2);
        B1=savedbook1.get();
        B2=savedbook2.get();
        Optional<Personne> saverPersonne1=personneRep.findById(1);
        List<Book> l=saverPersonne1.get().getBooks();
        System.out.println(l);
	    em.close();  
	    emf.close();
	  }    

}

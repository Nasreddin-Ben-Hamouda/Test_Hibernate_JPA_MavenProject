package tp3;

import java.util.Optional;

import javax.persistence.EntityManager;

public class personneRepository {

	private EntityManager entityManager;
	 public personneRepository(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }
	 public Optional<Personne> findById(Integer id) {
	        Personne personne = entityManager.find(Personne.class, id);
	        return personne != null ? Optional.of(personne) : Optional.empty();
	    }
	  public Optional<Personne> save(Personne personne) {
	        try {
	            entityManager.getTransaction().begin();
	            entityManager.persist(personne);
	            entityManager.getTransaction().commit();
	            return Optional.of(personne);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return Optional.empty();
	    }
}

package br.com.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-teste4");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}
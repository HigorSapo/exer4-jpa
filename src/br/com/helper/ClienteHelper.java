package br.com.helper;

import javax.persistence.EntityManager;

import br.com.entity.Cliente;

public class ClienteHelper {
	
	private EntityManager em;
	
	public ClienteHelper(EntityManager em) {
		this.em = em;
	}
	
	public String salvar(Cliente c) {
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			return "Cliente salvo!!!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}

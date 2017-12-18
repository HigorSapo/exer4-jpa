package br.com.programa;

import br.com.dao.GenericDao;
import br.com.entity.Cliente;


public class TesteCliente {

	public static void main(String[] args) {
		
		GenericDao<Cliente> clienteDao = new GenericDao<Cliente>(Cliente.class);
		
		Cliente c1 = new Cliente();
		c1.setNome("Higão GenericDao");
		c1.setIdade(26);
		
		clienteDao.adicionar(c1);

	}

}

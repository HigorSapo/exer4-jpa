package br.com.programa;

import java.util.Date;
import java.util.List;

import br.com.dao.GenericDao;
import br.com.entity.Agenda;
import br.com.entity.Cliente;
import br.com.entity.MatMed;
import br.com.entity.Paciente;
import br.com.entity.Procedimento;

public class TesteManyToMany {

	public static void main(String[] args) {
		
		GenericDao<Cliente> clienteDao = new GenericDao<Cliente>(Cliente.class);
		GenericDao<Agenda> agendaDao = new GenericDao<Agenda>(Agenda.class);
		GenericDao<Paciente> pacienteDao = new GenericDao<Paciente>(Paciente.class);
		GenericDao<Procedimento> procedimentoDao = new GenericDao<Procedimento>(Procedimento.class);
		GenericDao<MatMed> matMedDado = new GenericDao<MatMed>(MatMed.class);
		
		Agenda a1 = new Agenda();
		a1.setDescricao("Agenda 1");
		a1.setData(new Date());
		a1.setHora(new Date());
		
		Paciente p1 = new Paciente();
		p1.setNome("Higão");
		p1.setCpf("41500713813");
		p1.setTelefone("44517439");
		p1.setDataNascimento(new Date());
		p1.getAgendas().add(a1);
		a1.getPacientes().add(p1);
		
		Procedimento pro1 = new Procedimento();
		pro1.setDescricao("PROCEDIMENTO 1");
		pro1.setPreco(10.10);
		pro1.setPaciente(p1);
		
		MatMed m1 = new MatMed();
		m1.setDescricao("DESCRICAO MATMED");
		m1.setPreco(10.20);
		m1.setFabricante("FABRICANTE 1");
		m1.setPaciente(p1);
		
		agendaDao.adicionar(a1);
		procedimentoDao.adicionar(pro1);
		matMedDado.adicionar(m1);
		
		List<Paciente> listaPaciente = pacienteDao.listar();
		
		for(Paciente pacienteLista : listaPaciente) {
			List<Procedimento> procedimentos = pacienteLista.getProcedimentos();
			System.out.println("==========================================================================");
			System.out.println("Paciente");
			System.out.println(pacienteLista.getNome());
			System.out.println("Procedimento");
			System.out.println(procedimentos.toString());
			System.out.println("==========================================================================");
		}
		
	}

}

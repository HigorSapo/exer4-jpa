package br.com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="paciente")
public class Paciente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DATANASC")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "pacientes")
	private Set<Agenda> agendas = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente", orphanRemoval = true)
	@Column(name = "CPFPAC")
	private List<Procedimento> procedimentos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente", orphanRemoval = true)
	@Column(name = "CPFPAC")
	private List<MatMed> matMeds;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(Set<Agenda> agendas) {
		this.agendas = agendas;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public List<MatMed> getMatMeds() {
		return matMeds;
	}

	public void setMatMeds(List<MatMed> matMeds) {
		this.matMeds = matMeds;
	}

}

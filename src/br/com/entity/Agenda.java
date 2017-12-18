package br.com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="agenda")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDAGENDA")
	private int id;
	
	@Column(name="DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(name="HORA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hora;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="AGENDA_PACIENTE", catalog="jpateste4",
			joinColumns = {
					@JoinColumn(name = "IDAGENDA", nullable = false)}, inverseJoinColumns = {
							@JoinColumn(name = "CPF", nullable = false, updatable = false)
					})
	private Set<Paciente> pacientes = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}

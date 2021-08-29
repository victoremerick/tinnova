package br.tinnova.execicio5.application.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "VEICULO")
@DynamicUpdate
public class Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column(name="VEICULO")
	private String veiculo;
	
	@Column(name="MARCA")
	private String marca;
	
	@Column(name="ANO")
	private Integer ano;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="VENDIDO")
	private boolean vendido;
	
	@Column(name="CREATED")
	private ZonedDateTime created;
	
	@Column(name="UPDATED")
	private ZonedDateTime updated;
}

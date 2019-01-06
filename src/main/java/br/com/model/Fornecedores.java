package br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@Data
@Entity
@Table(name="fornecedores")
public class Fornecedores implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
	
	@NotEmpty(message="Razão ocial é obrigatório")
	private String razaoSocial;
	
	
	@NotEmpty(message="CNPJ é obrigatório")
	@CNPJ
	private Long cnpj;
	
	@NotEmpty(message="Email é obrigatório")
	@Email
	private String email;
	
	private boolean ativo = true;

	
}
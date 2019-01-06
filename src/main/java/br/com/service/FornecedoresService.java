package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Fornecedores;
import br.com.model.dto.FornecedoresPesquisaDTO;
import br.com.repository.FornecedoresRepository;

@Service
public class FornecedoresService {

	@Autowired
	private FornecedoresRepository fornecy;
	
	@Transactional(readOnly=true)
	public List<Fornecedores> list(){
		return this.fornecy.findAll();
	}
	
	@Transactional
	public void save(Fornecedores fornecedores) {
		this.fornecy.save(fornecedores);
	}
	
	@Transactional
	public void remove(Long id) {
		this.fornecy.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Fornecedores getById(Long id) {
		return this.fornecy.findOne(id);
	}
	
	public List<Fornecedores> filtrar(FornecedoresPesquisaDTO fornecedores) {
		String nome = fornecedores.getNome() == null ? "%" : fornecedores.getNome()+"%";
		return fornecy.findByNomeContaining(nome);
	}


	@Transactional
	public boolean ativarDesativar(Long id) {
		
		
		boolean ativou = false;
		
		Fornecedores fornecedores = this.fornecy.getOne(id);
		if(fornecedores.isAtivo()) {
			fornecedores.setAtivo(false);
			return ativou;
		}else {
			fornecedores.setAtivo(true);
			ativou = true;
		}
		return ativou;
	}
	
	public boolean ativaDesativarContato(Fornecedores fornecedores) {
		if (fornecedores.isAtivo()) {
			ativaDesativaUsuario(fornecedores);
		} else {
			ativaDesativaUsuario(fornecedores);
		}
		return false;
	}


	
	private void ativaDesativaUsuario(Fornecedores fornecedores) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	private void ativaDesativaUsuario1(Fornecedores fornecedores) {

		if (fornecedores.isAtivo()) {
			fornecedores.setAtivo(false);
		} else {
			fornecedores.setAtivo(true);
		}

		this.fornecy.saveAndFlush(fornecedores);
	}

}
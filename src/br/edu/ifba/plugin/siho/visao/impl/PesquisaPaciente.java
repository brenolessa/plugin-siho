package br.edu.ifba.plugin.siho.visao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.ifba.plugin.siho.controle.ControlePaciente;
import br.edu.ifba.plugin.siho.modelo.ModeloPaciente;
import br.edu.ifba.plugin.siho.modelo.bd.estatico.Paciente;
import br.edu.ifba.plugin.siho.visao.IPesquisaPaciente;

@ManagedBean(name = "ppaciente")
@ViewScoped
public class PesquisaPaciente implements IPesquisaPaciente {

	private String erro;
	private String sucesso;
	
	private String id = "";
	private String cpf = "";
	private String nome = "";
	private String sus = "";
	private String dataNascimento = "";
	private String email = "";
	private String telefone = "";
	

	private List<Paciente> pacientesEncontrados = new ArrayList<Paciente>();

	@Override
	public String getId() {
		return id;
	}


	@Override
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getSus() {
		return sus;
	}


	public void setSus(String sus) {
		this.sus = sus;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public List<Paciente> getPacientesEncontrados() {
		return pacientesEncontrados;
	}


	public void setPacientesEncontrados(List<Paciente> pacientesEncontrados) {
		this.pacientesEncontrados = pacientesEncontrados;
	}


	public void pesquisar() {
		erro = null;
		
		System.out.println("pesquisar");

		ModeloPaciente modelo = new ModeloPaciente();
		ControlePaciente controle = new ControlePaciente();

		controle.setModeloPaciente(modelo);
		controle.setPesquisaPaciente(this);

		controle.pesquisar();
	}

	@Override
	public void atualizarPacientesEncontrados(List<Paciente> pacientes) {
		this.pacientesEncontrados = pacientes;
	}

	public List<Paciente> getPacientes() {
		return this.pacientesEncontrados;
	}

	private void exibirCadastro(String id) {
		ExternalContext context = FacesContext.
				getCurrentInstance()
				.getExternalContext();
		context.getSessionMap().put("idPaciente", id);
		try {
			context.redirect("cadastro_paciente.ifba");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ver(String id) {
		exibirCadastro(id);
	}

	public void adicionar() {
		exibirCadastro("");
	}

	public void remover(String id) {
		sucesso = null;
		erro = null;
		
		this.id = id;

		ModeloPaciente modelo = new ModeloPaciente();
		ControlePaciente controle = new ControlePaciente();

		controle.setModeloPaciente(modelo);
		controle.setPesquisaPaciente(this);

		controle.remover();
	}

	public String getErro() {
		return erro;
	}

	public String getSucesso() {
		return sucesso;
	}
	
	@Override
	public void notificarPacientesNaoEncontrados() {
		erro = "Nenhum registro encontrado!";
	}

	@Override
	public void notificarPacienteRemovido() {
		sucesso = "Paciente excluído com sucesso!";
	}

	@Override
	public void notificarErroRemocao() {
		erro = "Não foi possível remover o paciente";
	}

}

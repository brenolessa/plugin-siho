package br.edu.ifba.plugin.siho.visao.impl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.ifba.plugin.siho.controle.ControlePaciente;
import br.edu.ifba.plugin.siho.modelo.ModeloPaciente;
import br.edu.ifba.plugin.siho.modelo.bd.estatico.Paciente;
import br.edu.ifba.plugin.siho.visao.ICadastroPaciente;

@ManagedBean(name = "cadpaciente")
@ViewScoped
public class CadastroPaciente implements ICadastroPaciente {

	private static final String ERRO_CPF_NAO_INFORMADO = "CPF deve ser informado!";
	private static final String ERRO_CPF_INVALIDO = "CPF inválido!";
	
	private static final String ERRO_NOME_NAO_INFORMADO = "Preenchimento do campo nome é obrigatório";
	private static final String ERRO_RG_NAO_INFORMADO = "Preenchimento do campo RG é obrigatório";
	private static final String ERRO_SUS_NAO_INFORMADO = "Preenchimento do campo Nº SUS é obrigatório";
	
	private static final String ERRO_DATA_NAO_INFORMADA = "Preenchimento do campo Data de Nascimento é obrigatório";
	private static final String ERRO_DATA_INVALIDA = "Data de Nascimento futura ou inválida";
	
	private static final String ERRO_EMAIL_NAO_INFORMADO = "Preenchimento do campo E-mail é obrigatório";
	private static final String ERRO_EMAIL_INVALIDO = "E-mail inválido";
	
	private static final String ERRO_TELEFONE_NAO_INFORMADO = "Preenchimento do campo Telefone é obrigatório";
	private static final String ERRO_RUA_NAO_INFORMADO = "Preenchimento do campo Rua é obrigatório";
	private static final String ERRO_NUMERO_NAO_INFORMADO = "Preenchimento do campo Número é obrigatório";
	private static final String ERRO_BAIRRO_NAO_INFORMADO = "Preenchimento do campo Bairro é obrigatório";
	private static final String ERRO_CEP_NAO_INFORMADO = "Preenchimento do campo CEP é obrigatório";
	private static final String ERRO_CIDADE_NAO_INFORMADO = "Preenchimento do campo Cidade é obrigatório";
	private static final String ERRO_ESTADO_NAO_INFORMADO = "Preenchimento do campo Estado é obrigatório";
	private static final String ERRO_FILIACAO_NAO_INFORMADO = "Preenchimento do campo Filiação é obrigatório";
	
	private static final String ERRO_SEXO_NAO_INFORMADO = "Campo Sexo é obrigatório ser selecionado";
	
	
	

	public boolean gravado = false;

	private String id = "";
	private Paciente paciente = new Paciente();

	public CadastroPaciente() {
		ExternalContext contexto = FacesContext.getCurrentInstance()
				.getExternalContext();
		id = (String) contexto.getSessionMap().get("idPaciente");

		if ((id != null) && (!id.isEmpty())) {
			recuperarPaciente();
		}
	}

	private void recuperarPaciente() {
		ModeloPaciente modelo = new ModeloPaciente();
		ControlePaciente controle = new ControlePaciente();

		controle.setCadastroPaciente(this);
		controle.setModeloPaciente(modelo);

		controle.pesquisarParaCadastro();
	}

	@Override
	public int getId() {
		int iid = 0;

		if ((id != null) && (!id.isEmpty())) {
			iid = Integer.parseInt(id);
		}

		return iid;
	}

	@Override
	public Paciente getPaciente() {
		return paciente;
	}

	@Override
	public void atualizarPacienteEncontrado(Paciente paciente) {
		this.paciente = paciente;
	}

	public void gravar() {
		gravado = false;

		if ((paciente.getCpf() == null) || (paciente.getCpf().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:cpf",
					new FacesMessage(ERRO_CPF_NAO_INFORMADO,
							ERRO_CPF_NAO_INFORMADO));
			
		} else if ((paciente.getRg() == null) || (paciente.getRg().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:rg",
					new FacesMessage(ERRO_RG_NAO_INFORMADO,
							ERRO_RG_NAO_INFORMADO));
		} else if ((paciente.getNome() == null) || (paciente.getNome().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:nome",
					new FacesMessage(ERRO_NOME_NAO_INFORMADO,
							ERRO_NOME_NAO_INFORMADO));
		} else if ((paciente.getSus() == null) || (paciente.getSus().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:sus",
					new FacesMessage(ERRO_SUS_NAO_INFORMADO,
							ERRO_SUS_NAO_INFORMADO));
		} else if ((paciente.getDataNascimento() == null) || (paciente.getDataNascimento().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:dataNascimento",
					new FacesMessage(ERRO_DATA_NAO_INFORMADA,
							ERRO_DATA_NAO_INFORMADA));
		} else if ((paciente.getEmail() == null) || (paciente.getEmail().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:email",
					new FacesMessage(ERRO_EMAIL_NAO_INFORMADO,
							ERRO_EMAIL_NAO_INFORMADO));
		} else if ((paciente.getTelefone() == null) || (paciente.getTelefone().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:telefone",
					new FacesMessage(ERRO_TELEFONE_NAO_INFORMADO,
							ERRO_TELEFONE_NAO_INFORMADO));
		} else if ((paciente.getRua() == null) || (paciente.getRua().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:rua",
					new FacesMessage(ERRO_RUA_NAO_INFORMADO,
							ERRO_RUA_NAO_INFORMADO));
		} else if ((paciente.getNumero() == null) || (paciente.getNumero().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:numero",
					new FacesMessage(ERRO_NUMERO_NAO_INFORMADO,
							ERRO_NUMERO_NAO_INFORMADO));
		} else if ((paciente.getBairro() == null) || (paciente.getBairro().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:bairro",
					new FacesMessage(ERRO_BAIRRO_NAO_INFORMADO,
							ERRO_BAIRRO_NAO_INFORMADO));
		} else if ((paciente.getCep() == null) || (paciente.getCep().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:cep",
					new FacesMessage(ERRO_CEP_NAO_INFORMADO,
							ERRO_CEP_NAO_INFORMADO));
		} else if ((paciente.getCidade() == null) || (paciente.getCidade().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:cidade",
					new FacesMessage(ERRO_CIDADE_NAO_INFORMADO,
							ERRO_CIDADE_NAO_INFORMADO));
		} else if ((paciente.getEstado() == null) || (paciente.getEstado().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:estado",
					new FacesMessage(ERRO_ESTADO_NAO_INFORMADO,
							ERRO_ESTADO_NAO_INFORMADO));
		} else if ((paciente.getFiliacao() == null) || (paciente.getFiliacao().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:filiacao",
					new FacesMessage(ERRO_FILIACAO_NAO_INFORMADO,
							ERRO_FILIACAO_NAO_INFORMADO));
		} else if ((paciente.getSexo() == null) || (paciente.getSexo().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:sexo",
					new FacesMessage(ERRO_SEXO_NAO_INFORMADO,
							ERRO_SEXO_NAO_INFORMADO));
		} else {
			gravarPaciente();
		}
				
	}

	private void gravarPaciente() {
		ModeloPaciente modelo = new ModeloPaciente();
		ControlePaciente controle = new ControlePaciente();

		controle.setCadastroPaciente(this);
		controle.setModeloPaciente(modelo);

		controle.gravar();
	}

	@Override
	public void notificarPacienteNaoEncontrado() {
		// TODO Auto-generated method stub
	}

	@Override
	public void notificarPacienteGravado(Paciente paciente) {
		gravado = true;
	}

	public boolean getGravado() {
		return gravado;
	}

	@Override
	public void notificarErroGravacao() {
		// TODO Auto-generated method stub

	}

}

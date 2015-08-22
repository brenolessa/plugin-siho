package br.edu.ifba.plugin.siho.controle;

import br.edu.ifba.plugin.siho.modelo.ModeloPaciente;
import br.edu.ifba.plugin.siho.visao.ICadastroPaciente;
import br.edu.ifba.plugin.siho.visao.IPesquisaPaciente;

public class ControlePaciente {

	private IPesquisaPaciente pesquisaPaciente;
	private ICadastroPaciente cadastroPaciente;
	private ModeloPaciente modeloPaciente;

	public void setPesquisaPaciente(IPesquisaPaciente pesquisa) {
		this.pesquisaPaciente = pesquisa;
	}

	public void setCadastroPaciente(ICadastroPaciente cadastro) {
		this.cadastroPaciente = cadastro;
	}

	public void setModeloPaciente(ModeloPaciente modelo) {
		this.modeloPaciente = modelo;
	}

	public void pesquisar() {
		modeloPaciente.setPesquisaPaciente(pesquisaPaciente);
		modeloPaciente.pesquisar();
	}

	public void pesquisarParaCadastro() {
		modeloPaciente.setCadastroPaciente(cadastroPaciente);
		modeloPaciente.pesquisarParaCadastro();
	}

	public void remover() {
		modeloPaciente.setPesquisaPaciente(pesquisaPaciente);
		modeloPaciente.remover();
	}

	public void gravar() {
		modeloPaciente.setCadastroPaciente(cadastroPaciente);
		
		if (cadastroPaciente.getId() == -1) {
			modeloPaciente.adicionar();
		} else {
			modeloPaciente.atualizar();
		}
	}

}

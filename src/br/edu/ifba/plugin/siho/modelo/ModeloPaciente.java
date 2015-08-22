package br.edu.ifba.plugin.siho.modelo;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.plugin.siho.modelo.bd.estatico.Paciente;
import br.edu.ifba.plugin.siho.modelo.bd.estatico.PacienteDAO;
import br.edu.ifba.plugin.siho.visao.ICadastroPaciente;
import br.edu.ifba.plugin.siho.visao.IPesquisaPaciente;

/**
 * Classe de Modelo especializada em manipular informacoes relacionadas aa
 * 
 * Os modelos sao ativos, i.e. acionam automaticamente acoes na interface.
 * 
 * @author PLUGIN
 */
public class ModeloPaciente {

	private IPesquisaPaciente pesquisaPaciente = null;
	private ICadastroPaciente cadastroPaciente = null;

	
	public void setPesquisaPaciente(IPesquisaPaciente pesquisa) {
		this.pesquisaPaciente = pesquisa;
	}

	public void setCadastroPaciente(ICadastroPaciente cadastro) {
		this.cadastroPaciente = cadastro;
	}
	
	public void pesquisar() {
		List<Paciente> pacientes = new ArrayList<Paciente>();

		String criterio = pesquisaPaciente.getCpf();
		if (!criterio.equals("")) {
			pacientes = PacienteDAO.getPacientesPorCPF(criterio);
		} else {
			criterio = pesquisaPaciente.getSus();
			if (!criterio.equals("")) {
				pacientes = PacienteDAO.getPacientesPorSus(criterio);
			} else {
				criterio = pesquisaPaciente.getNome();
				if (!criterio.equals("")) {
					pacientes = PacienteDAO.getPacientesPorNome(criterio);
				}
			}
		}

		pesquisaPaciente.atualizarPacientesEncontrados(pacientes);

		if (pacientes.isEmpty()) {
			pesquisaPaciente.notificarPacientesNaoEncontrados();
		}
	}

	public void pesquisarParaCadastro() {
		Paciente paciente = PacienteDAO.getPaciente(cadastroPaciente.getId());

		if (paciente == null) {
			cadastroPaciente.notificarPacienteNaoEncontrado();
		} else {
			cadastroPaciente.atualizarPacienteEncontrado(paciente);
		}
	}

	public void remover() {
		PacienteDAO.remover(Integer.parseInt(pesquisaPaciente.getId()));

		pesquisar();
		
		pesquisaPaciente.notificarPacienteRemovido();
	}

	public void adicionar() {
		Paciente paciente = cadastroPaciente.getPaciente();

		paciente.setId(-1);
		if (PacienteDAO.gravar(paciente) > 0) {
			cadastroPaciente.notificarErroGravacao();
		} else {
			cadastroPaciente.notificarPacienteGravado(paciente);
		}
	}

	public void atualizar() {
		Paciente paciente = cadastroPaciente.getPaciente();

		if (PacienteDAO.gravar(paciente) > 0) {
			cadastroPaciente.notificarErroGravacao();
		} else {
			cadastroPaciente.notificarPacienteGravado(paciente);
		}
	}

}

package br.edu.ifba.plugin.siho.visao;

import br.edu.ifba.plugin.siho.modelo.bd.estatico.Paciente;

public interface ICadastroPaciente {

	public int getId();

	public Paciente getPaciente();

	// /////////////////////

	public void atualizarPacienteEncontrado(Paciente paciente);

	public void notificarPacienteNaoEncontrado();

	public void notificarPacienteGravado(Paciente paciente);

	public void notificarErroGravacao();

}

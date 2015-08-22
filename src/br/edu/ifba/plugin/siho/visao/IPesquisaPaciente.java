package br.edu.ifba.plugin.siho.visao;

import java.util.List;

import br.edu.ifba.plugin.siho.modelo.bd.estatico.Paciente;

public interface IPesquisaPaciente {

	public String getId();
	
	public String getSus();

	public String getCpf();

	public String getNome();

	public String getDataNascimento();
	
	public String getEmail();
	
	public String getTelefone();
	
	
	///////////////////////
	

	public void atualizarPacientesEncontrados(List<Paciente> pacientes);

	public void notificarPacientesNaoEncontrados();
	
	public void notificarPacienteRemovido();
	
	public void notificarErroRemocao();

}

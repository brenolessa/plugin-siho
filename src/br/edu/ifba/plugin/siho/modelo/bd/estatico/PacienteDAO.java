package br.edu.ifba.plugin.siho.modelo.bd.estatico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Mock de acesso a banco de dados. Utiliza colecoes estaticas para
 * simular manipulacao de banco.
 * 
 * OBS.: deve ser substituido por fachada(s) real(is).
 * 
 * @author PLUGIN
 */
public class PacienteDAO {

	private static Map<Integer, Paciente> pacientes = 
			new TreeMap<Integer, Paciente>();
	
	static {
				
		Paciente u1 = new Paciente();
		u1.setId(1);
		u1.setCpf("01234");
		u1.setRg("0078");
		u1.setNome("Ribas Cunha");
		u1.setSus("2222");
		u1.setDataNascimento("31/01/1983");
		u1.setEmail("ribinha@email");
		u1.setTelefone("(77)9999-9999");
		u1.setRua("Av. Pará");
		u1.setNumero("1210");
		u1.setBairro("Ibirapuera");
		u1.setCep("45-075.399");
		u1.setCidade("Vitória da Conquista");
		u1.setEstado("Bahia");
		u1.setFiliacao("Jandira Cunha");
		u1.setSexo("M");
		
		pacientes.put(u1.getId(), u1);
		
		Paciente u2 = new Paciente();
		u2.setId(2);
		u2.setCpf("9876");
		u2.setRg("1232");
		u2.setNome("Maria Prates");
		u2.setSus("1111");
		u2.setDataNascimento("12/02/1980");
		u2.setEmail("maria@email");
		u2.setTelefone("(77)2222-3333");
		u2.setRua("Av. Maceió");
		u2.setNumero("12");
		u2.setBairro("Brasil");
		u2.setCep("43-343.111");
		u2.setCidade("Cândido Sales");
		u2.setEstado("Bahia");
		u2.setFiliacao("Fernando Prates");
		u2.setSexo("F");
		
		pacientes.put(u2.getId(), u2);
	}
	
	
	public static List<Paciente> getPacientesPorCPF(String cpf)
	{
		List<Paciente> encontrados = new ArrayList<Paciente>();
		
		for (Paciente u : pacientes.values()) {
			if (u.getCpf().equals(cpf)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}

	public static List<Paciente> getPacientesPorSus(String sus)
	{
		List<Paciente> encontrados = new ArrayList<Paciente>();
		
		for (Paciente u : pacientes.values()) {
			if (u.getSus().equals(sus)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Paciente> getPacientesPorNome(
			String nome)
	{
		List<Paciente> encontrados = new ArrayList<Paciente>();
		
		for (Paciente u : pacientes.values()) {
			if (u.getNome().toLowerCase().
					contains(nome.toLowerCase())) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static Paciente getPaciente(int id) {
		return pacientes.get(id);
	}
	
	public static void remover(int id) {
		pacientes.remove(id);
	}
	
	public static int gravar(Paciente paciente) {
		if (paciente.getId() != -1) {
			remover(paciente.getId());
			pacientes.put(paciente.getId(), paciente);
		} else {
			int ultimoId = 0;
			for (int id : pacientes.keySet()) {
				ultimoId = id;
			}
			paciente.setId(ultimoId + 1);
			pacientes.put(ultimoId + 1, paciente);
		}
		
		return 0;
	}
}












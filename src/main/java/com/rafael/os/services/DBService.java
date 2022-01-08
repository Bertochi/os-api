package com.rafael.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.os.domain.Cliente;
import com.rafael.os.domain.OS;
import com.rafael.os.domain.Tecnico;
import com.rafael.os.domain.enums.Prioridade;
import com.rafael.os.domain.enums.Status;
import com.rafael.os.repositories.ClienteRepository;
import com.rafael.os.repositories.OSRepository;
import com.rafael.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Valdir Cezar", "144.785.300-84", "(88) 98888-8888");
		Tecnico t2 = new Tecnico(null, "Pedro Lucas", "885.537.797-34", "(55) 98888-5555");
		Cliente c1 = new Cliente(null, "Betina Campos", "598.508.200-80", "(88) 98888-7777");

		OS os1 = new OS(null, Prioridade.ALTA, "Trocar fonte do notebook", Status.ANDAMENTO, t1, c1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
}

package com.victorpimenta.cursonelioped.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorpimenta.cursonelioped.domain.Cliente;
import com.victorpimenta.cursonelioped.repositories.ClienteRepository;
import com.victorpimenta.cursonelioped.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		  "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}

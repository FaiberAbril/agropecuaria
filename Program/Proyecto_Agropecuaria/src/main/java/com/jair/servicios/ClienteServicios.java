package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Cliente;
import com.jair.repositorios.clienteRepository;

@Service
public class ClienteServicios {

	@Autowired
	private clienteRepository clienteRepository;
	
	public void CrearCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void ActualizarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void EliminarCliente(Long idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
	public Cliente BuscarCliente(Long idCliente) {
		return clienteRepository.findById(idCliente).get();
	}
	
	public List<Cliente> ListarClientes(){
		return clienteRepository.findAll();
	}
	
}

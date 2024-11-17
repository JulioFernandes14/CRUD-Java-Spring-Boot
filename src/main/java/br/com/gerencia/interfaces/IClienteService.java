package br.com.gerencia.interfaces;

import java.util.List;

import br.com.gerencia.dto.ClienteDTO;
import br.com.gerencia.entity.Cliente;

public interface IClienteService {

	public Object saveService(ClienteDTO clienteDto) throws Exception;
	
	public Cliente findByIdService(Long id) throws Exception;
	
	public List<Cliente> findAllService() throws Exception;
	
	public Cliente updateByIdService(ClienteDTO clienteDto) throws Exception;
	
	public void deleteByIdService(Long id) throws Exception;
	
}

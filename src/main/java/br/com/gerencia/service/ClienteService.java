package br.com.gerencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.dto.ClienteDTO;
import br.com.gerencia.entity.Cliente;
import br.com.gerencia.interfaces.IClienteService;
import br.com.gerencia.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Object saveService(ClienteDTO clienteDto) throws Exception{
		
		try {
			
			Cliente cliente = clienteDto.toEntity();
			
			Cliente resp = clienteRepository.save(cliente);
			
			return resp;
			
		}catch(Exception ex) {
			throw new Exception("Erro: Email ja cadastrado no sistema");
		}
		
	}
	
	@Override
	public Cliente findByIdService(Long id) throws Exception{
		
		try {
			
			Optional<Cliente> resp = clienteRepository.findById(id);
			
			if (resp.isEmpty()) {
				throw new Exception("Id não encontrado na base de dados");
			}
			
			return resp.get();
			
		}catch(Exception ex) {
			
			throw new Exception("Erro 404: Dados do cliente não encontrados");
			
		}
		
	}
	
	@Override
	public List<Cliente> findAllService() throws Exception{
		
		try {
			return clienteRepository.findAll();
		}catch (Exception ex) {
			throw new Exception ("Erro: " + ex);
		}
		
	}
	
	@Override
	public Cliente updateByIdService(ClienteDTO clienteDto) throws Exception {
		
		try {
			Cliente cliente = clienteDto.ToEntityId();
			Optional<Cliente> resp = clienteRepository.findById(cliente.getId());
			
			if (resp.isPresent()) {
				return clienteRepository.save(cliente);
			}
			
			throw new Exception("Id não encontrado");
		}catch(Exception ex) {
			throw new Exception("Erro 404: Dados do cliente não encontrados");
		}
		
	}
	
	@Override
	public void deleteByIdService(Long id) throws Exception {
		
			try {
			
				Optional<Cliente> resp = clienteRepository.findById(id);
			
				if (resp.isEmpty()) {
					throw new Exception("Id não encontrado na base de dados");
				}
			
				clienteRepository.deleteById(id);
			
			}catch(Exception ex) {
			
				throw new Exception("Erro 404: Cliente não encontrado");
			
			}
		
	}
	
}

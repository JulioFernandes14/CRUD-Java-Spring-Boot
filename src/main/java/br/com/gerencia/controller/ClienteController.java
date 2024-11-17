package br.com.gerencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerencia.dto.ClienteDTO;
import br.com.gerencia.entity.Cliente;
import br.com.gerencia.service.ClienteService;

@ResponseBody
@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> saveController(@RequestBody ClienteDTO clienteDto) {
		try {
			return ResponseEntity.status(200).body(clienteService.saveService(clienteDto));
		}catch(Exception ex){
			return ResponseEntity.status(500).body(ex.getMessage());
		}
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> findIdByController(@PathVariable Long id) {
		try {
			return ResponseEntity.status(200).body(clienteService.findByIdService(id));
		}catch(Exception ex){
			return ResponseEntity.status(404).body(ex.getMessage());
		}
	}
	
	@GetMapping("/listar")
	public List<Cliente> findAllController() throws Exception {
		return clienteService.findAllService();
	}
	
	@PostMapping("/atualizar")
	public ResponseEntity<?> updateByIdController(@RequestBody ClienteDTO clienteDto) {
		try {
			return ResponseEntity.status(200).body(clienteService.updateByIdService(clienteDto));
		}catch(Exception ex){
			return ResponseEntity.status(500).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deleteByIdController(@PathVariable Long id) {
		try {
			clienteService.deleteByIdService(id);
			return ResponseEntity.status(200).build();
		}catch(Exception ex){
			return ResponseEntity.status(404).body(ex.getMessage());
		}
	}
	
}

package br.com.gerencia.dto;

import br.com.gerencia.entity.Cliente;

public class ClienteDTO {

	private Long id;
	private String nome;
	private String email;
	private String status;
	
	public Cliente toEntity() {
		
		Cliente cliente = new Cliente();
		cliente.setNome(this.getNome());
		cliente.setEmail(this.getEmail());
		cliente.setStatus("Created");
		
		return cliente;
		
	}
	
	public Cliente ToEntityId() {
		
		Cliente cliente = new Cliente();
		cliente.setId(this.getId());
		cliente.setNome(this.getNome());
		cliente.setEmail(this.getEmail());
		cliente.setStatus("Updated");
		
		return cliente;
		
	}
	
	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClienteDTO(Long id, String nome, String email, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", status=" + status + "]";
	}
	
	
	
}

package cliente;

public class Cliente {

	private String nome;
	private String cpf;
	private String email;

	public Cliente(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		if (cpf == null || cpf.length() != 11) {
			System.out.println("CPF inválido.");
			return;
		}

		this.cpf = cpf;
	}

	public void setEmail(String email) {
		if (email == null || !email.contains("@")) {
			System.out.println("E-mail inválido.");
			return;
		}

		this.email = email;
	}
}
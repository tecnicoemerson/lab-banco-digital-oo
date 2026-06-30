package conta;

import cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	protected List<HistoricoTransacao> historico = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if (valor <= 0) {
			System.out.println("Valor inválido para saque.");
			return;
		}

		if (valor > saldo) {
			System.out.println("Saldo insuficiente.");
			return;
		}

		saldo -= valor;
		historico.add(new HistoricoTransacao("Saque", valor));
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			System.out.println("Valor inválido para depósito.");
			return;
		}

		saldo += valor;
		historico.add(new HistoricoTransacao("Depósito", valor));
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (valor <= 0) {
			System.out.println("Valor inválido para transferência.");
			return;
		}

		if (valor > saldo) {
			System.out.println("Saldo insuficiente para transferência.");
			return;
		}

		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public void imprimirHistorico() {
		System.out.println("=== Histórico da Conta ===");

		for (HistoricoTransacao transacao : historico) {
			System.out.println(transacao);
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
import cliente.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class Main {

	public static void main(String[] args) {

		Cliente venilton = new Cliente("Venilton", "12345678912", "venilton@gmail.com");
		Cliente maria = new Cliente("Maria", "98765432100", "maria@gmail.com");

		Conta contaVenilton = new ContaCorrente(venilton);
		Conta contaMaria = new ContaPoupanca(maria);

		contaVenilton.depositar(200);
		contaVenilton.sacar(50);
		contaVenilton.transferir(100, contaMaria);

		contaVenilton.imprimirExtrato();
		contaVenilton.imprimirHistorico();

		System.out.println();

		contaMaria.imprimirExtrato();
		contaMaria.imprimirHistorico();
	}
}
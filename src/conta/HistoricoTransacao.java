package conta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricoTransacao {

    private String tipo;
    private double valor;
    private LocalDateTime dataHora;

    public HistoricoTransacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return dataHora.format(formato) + " - " + tipo + " de R$ " + String.format("%.2f", valor);
    }
}
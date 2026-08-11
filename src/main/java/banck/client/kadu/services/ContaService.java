package banck.client.kadu.services;

import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private double saldo = 0;

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}

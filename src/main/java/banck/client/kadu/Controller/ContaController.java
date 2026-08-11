package banck.client.kadu.Controller;

import banck.client.kadu.Request.ValorRequest;
import banck.client.kadu.services.ContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

    private final ContaService conta;

    public ContaController(ContaService conta) {
        this.conta = conta;
    }

    @GetMapping("/saldo")
    public double consultarSaldo() {
        return conta.getSaldo();
    }

    @PostMapping("/depositar")
    public double depositar(@RequestBody ValorRequest body) {
        conta.depositar(body.valor);
        return conta.getSaldo();
    }

    @PostMapping("/sacar")
    public ResponseEntity<?> sacar(@RequestBody ValorRequest body) {
        boolean ok = conta.sacar(body.valor);
        if (!ok) {
            return ResponseEntity.badRequest().body("Saldo insuficiente");
        }
        return ResponseEntity.ok(conta.getSaldo());
    }
}

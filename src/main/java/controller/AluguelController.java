package controller;



import model.Aluguel;
import org.springframework.web.bind.annotation.*;
import service.AluguelService;

import java.util.List;

@RestController
@RequestMapping
public class AluguelController {
    private AluguelService aluguelService = new AluguelService();

    @GetMapping("/aluguel")
    public List<Aluguel> getAlugueis() {
        return aluguelService.listarAlugueis();
    }

    @PostMapping("/aluguel")
    public void postAlugueis(@RequestBody Aluguel aluguel) {
        aluguelService.cadastrarAluguel(aluguel.getVeiculoAlugado(), aluguel.getDataEmprestimo(),aluguel.getDataDevolucao());
    }
}
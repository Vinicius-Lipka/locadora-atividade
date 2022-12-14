package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {
    private model.Veiculo veiculoAlugado;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}
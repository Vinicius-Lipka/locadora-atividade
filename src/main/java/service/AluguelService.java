package service;

import db.AluguelDB;
import model.Aluguel;
import model.Veiculo;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AluguelService {
    private AluguelDB aluguelDB = new AluguelDB();

    public Aluguel cadastrarAluguel(Veiculo veiculo, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        if (veiculo == null || !veiculo.isDisponivel())
            return null;
        if (dataEmprestimo.isAfter(dataDevolucao))
            return null;
        if (dataDevolucao.isBefore(dataEmprestimo))
            return null;

        dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusDays(7);

        Aluguel aluguel = new Aluguel(veiculo, dataEmprestimo, dataDevolucao);
        aluguelDB.adicionarAluguel(aluguel);
        return aluguel;

    }

    public List<Aluguel> listarAlugueis() {
        return aluguelDB.listarAlugueis();
    }

    public boolean devolverVeiculoAlugado(String placa) {
        return aluguelDB.finalizarAluguel(placa);
    }
}
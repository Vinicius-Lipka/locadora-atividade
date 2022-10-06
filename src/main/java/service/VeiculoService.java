package service;

import db.VeiculoDB;


import model.Veiculo;

import java.util.List;

public class VeiculoService {
    private VeiculoDB veiculoDB = new VeiculoDB();

    public Veiculo cadastrarVeiculo(String modelo, String placa, boolean disponivel) {
        if (modelo == null || modelo.isEmpty()) {
            return null;
        }
        if (placa == null || placa.isEmpty()) {
            return null;
        }
        if (!disponivel) {
            return null;
        }
        Veiculo veiculo = new Veiculo(modelo, placa, true);
        return veiculoDB.adicionarVeiculo(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoDB.listarVeiculos();
    }

    public Veiculo buscarVeiculo(String placa){
        return veiculoDB.buscarVeiculo(placa);
    }

}
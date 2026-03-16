package br.com.sipna.service;

import br.com.sipna.dao.BoletimDAO;
import br.com.sipna.model.Boletim;

public class BoletimService {

    private BoletimDAO boletimDAO = new BoletimDAO();

    public Boletim gerarBoletim(String nomeAluno){

        return boletimDAO.getBoletimPorNome(nomeAluno);
    }
}
package br.com.sipna.dao;

import br.com.sipna.model.Boletim;

public class BoletimDAO {

    
    public Boletim getBoletimPorNome(String nomeAluno) {

        // Simulação de dados (como se viesse do banco)

        Boletim boletim = new Boletim(nomeAluno);

        boletim.adicionarFrequencia("Matemática", 85.0);
        boletim.adicionarFrequencia("Português", 90.0);
        boletim.adicionarFrequencia("História", 78.0);

        return boletim;
    }
}
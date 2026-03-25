package br.com.sipna.service;

import br.com.sipna.model.Boletim;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoletimServiceTest {

    @Test
    public void deveGerarBoletimCorretamente() {

        BoletimService service = new BoletimService();

        Boletim boletim = service.gerarBoletim("João");

        assertEquals("João", boletim.getAluno());
        assertFalse(boletim.getFrequenciaPorMateria().isEmpty());

        assertEquals(85.0, boletim.getFrequenciaPorMateria().get("Matemática"), 0.01);
        assertEquals(90.0, boletim.getFrequenciaPorMateria().get("Português"), 0.01);
        assertEquals(78.0, boletim.getFrequenciaPorMateria().get("História"), 0.01);
    }
}
package me.dio.mockito.exemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ApiDosCorreiosTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @Test
    void retornaObjetoQuandoEspecificoValorEhPassado() {
        when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(null);

        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosComBaseNoCep("161761");

        assertNull(dadosLocalizacao);
    }

    @Test
    void retornaObjetoQuandoEspecificoValorEhPassado2() {
        when(apiDosCorreios.buscaDadosComBaseNoCep("14406052")).thenReturn(new DadosLocalizacao("SP", "Franca", "Ave. Wilson S. de Melo", "Complexo", "Distrito"));

        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosComBaseNoCep("14406052");

        assertEquals("SP", dadosLocalizacao.getUf());
    }
}

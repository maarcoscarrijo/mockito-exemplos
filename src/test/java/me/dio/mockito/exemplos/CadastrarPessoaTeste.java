package me.dio.mockito.exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyString;


@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void cadastrarPessoa() {

        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("SP", "Franca", "Ave. Brasil", "Casa", "Vila Aparecida");

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);

        Pessoa altamiro = cadastrarPessoa.cadastrarPessoa("Altamiro", "28578527976", LocalDate.of(1955, 9, 2), "14403000");

        DadosLocalizacao enderecoAltamiro = altamiro.getEndereco();
        assertEquals(dadosLocalizacao.getBairro(), enderecoAltamiro.getBairro());
        assertEquals(dadosLocalizacao.getCidade(), enderecoAltamiro.getCidade());
        assertEquals(dadosLocalizacao.getUf(), enderecoAltamiro.getUf());
    }

    @Test
    void tentaCadastrarPessoaMasSistemaDosCorreiosFalha() {

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> cadastrarPessoa.cadastrarPessoa("Altamiro", "28578527976", LocalDate.of(1955, 9, 2), "14403000"));
    }

}

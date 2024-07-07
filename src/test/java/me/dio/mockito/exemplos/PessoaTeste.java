package me.dio.mockito.exemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PessoaTeste {

    @Mock
    private Pessoa pessoa;

    @Test
    void escolheRetorno() {
        when(pessoa.getNome()).thenReturn("Joao");
        assertEquals("Joao", pessoa.getNome());
    }

    @Test
    void outraFormaDeEscolherRetorno() {
        doReturn("Joao").when(pessoa).getNome();
        assertEquals("Joao", pessoa.getNome());
    }

    @Test
    void retornaQueEhMaiorDeIdade() {
        when(pessoa.ehMaiorDeIdade()).thenReturn(true);
        assertTrue(pessoa.ehMaiorDeIdade());
    }

    @Test
    void retornaQueEhMaiorDeIdadeDeUmaOutraForma() {
        doAnswer(invocation -> true).when(pessoa).ehMaiorDeIdade();
        assertTrue(pessoa.ehMaiorDeIdade());
   }
}

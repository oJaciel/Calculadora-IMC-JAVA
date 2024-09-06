import dominio.Imc;
import telas.TelaImc;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Imc_TelaImcTest {

    private TelaImc telaImc;

    @Before
    public void setUp() {
        telaImc = new TelaImc();
    }

    @Test
    public void testCalcularIMC() {
        // Setando valores nos campos de texto usando os setters
        telaImc.setTxtCPF("12345678901");
        telaImc.setTxtNome("Teste");
        telaImc.setTxtPeso("70");
        telaImc.setTxtAltura("1.75");

        // Simula o clique no botão Calcular
        telaImc.getBtnCalcular().doClick();

        // Verifica se os dados foram adicionados à lista
        assertEquals(1, telaImc.getLista().size());
        Imc imc = telaImc.getLista().get(0);
        assertEquals(Long.valueOf("12345678901"), imc.getCpf());
        assertEquals("Teste", imc.getNome());
        assertEquals(Float.valueOf(70), imc.getPeso());
        assertEquals(Float.valueOf(1.75f), imc.getAltura());
    }

    @Test
    public void testAlterarIMC() {
        // Adiciona um item à lista
        Imc imc = new Imc();
        imc.setCpf(12345678901L);
        imc.setNome("Teste");
        imc.setPeso(70f);
        imc.setAltura(1.75f);
        telaImc.getLista().add(imc);

        // Seleciona o item na tabela
        telaImc.getTableIMC().setRowSelectionInterval(0, 0);

        // Setando novos valores nos campos de texto usando os setters
        telaImc.setTxtNome("Teste Alterado");
        telaImc.setTxtPeso("75");
        telaImc.setTxtAltura("1.80");

        // Simula o clique no botão Alterar
        telaImc.getBtnAlterar().doClick();

        // Verifica se os dados foram alterados na lista
        assertEquals(1, telaImc.getLista().size());
        Imc imcAlterado = telaImc.getLista().get(0);
        assertEquals("Teste Alterado", imcAlterado.getNome());
        assertEquals(Float.valueOf(75), imcAlterado.getPeso());
        assertEquals(Float.valueOf(1.80f), imcAlterado.getAltura());
    }

    @Test
    public void testExcluirIMC() {
        // Adiciona um item à lista
        Imc imc = new Imc();
        imc.setCpf(12345678901L);
        imc.setNome("Teste");
        imc.setPeso(70f);
        imc.setAltura(1.75f);
        telaImc.getLista().add(imc);

        // Seleciona o item na tabela
        telaImc.getTableIMC().setRowSelectionInterval(0, 0);

        // Simula o clique no botão Excluir
        telaImc.getBtnExcluir().doClick();

        // Verifica se os dados foram removidos da lista
        assertEquals(0, telaImc.getLista().size());
    }
}

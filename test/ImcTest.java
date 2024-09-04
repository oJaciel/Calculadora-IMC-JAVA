
import dominio.Imc;
import java.io.Console;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImcTest {

    private Imc imcTest;

    public ImcTest() {
    }

    @Before
    public void setUp() {
        imcTest = new Imc();
    }

    //Testes de Getters e Setters
    @Test
    public void testValidaNome() {
        imcTest.setNome("Teste");
        String nomeExpected = "Teste";

        assertEquals(nomeExpected, imcTest.getNome());
    }

    @Test
    public void testValidaCpf() {
        imcTest.setCpf(41245689023L);
        Long cpfExpected = 41245689023L;

        assertEquals(cpfExpected, imcTest.getCpf());
    }

    @Test
    public void testValidaPeso() {
        imcTest.setPeso(85.2f);
        Float pesoExpected = 85.2f;

        assertEquals(pesoExpected, imcTest.getPeso());
    }

    @Test
    public void testValidaAltura() {
        imcTest.setAltura(1.86f);
        Float alturaExpected = 1.86f;

        assertEquals(alturaExpected, imcTest.getAltura());
    }

    @Test
    public void testValoresNulos() {
        imcTest.setNome(null);
        imcTest.setCpf(null);
        imcTest.setPeso(null);
        imcTest.setAltura(null);

        assertNull(imcTest.getNome());
        assertNull(imcTest.getCpf());
        assertNull(imcTest.getPeso());
        assertNull(imcTest.getAltura());
    }

    //Testes de cálculo
    @Test
    public void testCalcularImc() {
        imcTest.setPeso(80f);
        imcTest.setAltura(1.80f);
        double imc = imcTest.CalculaImc();

        double imcExpected = 24.69;

        assertEquals(imcExpected, imc, 0.01);
    }

    @Test
    public void testVerificaImcMagreza() {
        imcTest.setPeso(55f);
        imcTest.setAltura(1.90f);
        //O IMC é 15.23 (magreza)
        String resultExpected = "Magreza";

        assertEquals(resultExpected, imcTest.VerificaImc());
    }

    @Test
    public void testVerificaImcNormal() {
        imcTest.setPeso(60f);
        imcTest.setAltura(1.65f);
        //O IMC é 22.03 (normal)
        String resultExpected = "Normal";

        assertEquals(resultExpected, imcTest.VerificaImc());
    }

    @Test
    public void testVerificaImcSobrepeso() {
        imcTest.setPeso(82f);
        imcTest.setAltura(1.70f);
        //O IMC é 28.37 (sobrepeso)
        String resultExpected = "Sobrepeso";

        assertEquals(resultExpected, imcTest.VerificaImc());
    }

    @Test
    public void testVerificaImcObesidade() {
        imcTest.setPeso(97f);
        imcTest.setAltura(1.75f);
        //O IMC é 31.67 (obesidade)
        String resultExpected = "Obesidade";

        assertEquals(resultExpected, imcTest.VerificaImc());
    }

    @Test
    public void testVerificaImcObesidadeGrave() {
        imcTest.setPeso(135f);
        imcTest.setAltura(1.80f);
        //O IMC é 41.66 (obesidade grave)
        String resultExpected = "Obesidade Grave";

        assertEquals(resultExpected, imcTest.VerificaImc());
    }

    @Test
    public void testCalcularImcComValoresNulos() {
        imcTest.setPeso(null);
        imcTest.setAltura(null);

        try {
            imcTest.CalculaImc();
            fail("Deveria ter lançado uma exceção ao calcular IMC com valores nulos.");
        } catch (NullPointerException e) {
            // Exceção esperada
        }
    }

}

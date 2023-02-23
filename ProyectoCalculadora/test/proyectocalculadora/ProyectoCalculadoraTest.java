/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectocalculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas de metodos principales
 * @author Eduardo Garcia, Regina Sanz, Emilia Hernandez, Manuel McCadden
 */
public class ProyectoCalculadoraTest {
    
    public ProyectoCalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of revisaParentesis method, of class ProyectoCalculadora.
     */
    @Test
    public void testRevisaParentesis() {
        System.out.println("revisaParentesis");
        String cadena = "";
        boolean expResult = false;
        boolean result = ProyectoCalculadora.revisaParentesis(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisaContenidoParentesis method, of class ProyectoCalculadora.
     */
    @Test
    public void testRevisaContenidoParentesis() {
        System.out.println("revisaContenidoParentesis");
        String cadena = "";
        boolean expResult = false;
        boolean result = ProyectoCalculadora.revisaContenidoParentesis(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisaOperandosOperadores method, of class ProyectoCalculadora.
     */
    @Test
    public void testRevisaOperandosOperadores() {
        System.out.println("revisaOperandosOperadores");
        String cadena = "";
        boolean expResult = false;
        boolean result = ProyectoCalculadora.revisaOperandosOperadores(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisaSintaxisInfija method, of class ProyectoCalculadora.
     */
    @Test
    public void testRevisaSintaxisInfija() {
        System.out.println("revisaSintaxisInfija");
        String dato = "134+.45*(4+3)^3*~32";
        boolean expResult = true;
        boolean result = ProyectoCalculadora.revisaSintaxisInfija(dato);
        assertEquals(expResult, result);
    }

    /**
     * Test of dividirCadena method, of class ProyectoCalculadora.
     */
    @Test
    public void testDividirCadena() {
        System.out.println("dividirCadena");
        
        String cadena =  "~6.21*2+10";
        String[] arr = new String[cadena.length()+1]; 
        arr[1]= "~";
        arr[2]= "6.21"; 
        arr[3]= "*";
        arr[4]= "2"; 
        arr[5]= "+";
        arr[6]= "10"; 
        arr[0] = "7"; 
        String[] expResult = arr;
        String[] result = ProyectoCalculadora.dividirCadena(cadena);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of conviertePostfija method, of class ProyectoCalculadora.
     */
    @Test
    public void testConviertePostfija() {
        System.out.println("conviertePostfija");
        String cadena = "~(6*(2+6))^2+10-5";
        String expResult = "-6.0 2.0 6.0 - * 2.0 ^ 10.0 + 5.0 - ";
        String result = ProyectoCalculadora.conviertePostfija(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenPrioridad method, of class ProyectoCalculadora.
     */
    @Test
    public void testObtenPrioridad() {
        System.out.println("obtenPrioridad");
        String oper = "+";
        int expResult = 1;
        int result = ProyectoCalculadora.obtenPrioridad(oper);
        assertEquals(expResult, result);
    }

    /**
     * Test of evalua method, of class ProyectoCalculadora.
     */
    @Test
    public void testEvalua() {
        System.out.println("evalua");
        String cadena = "-12.0 3.0 2.0 ^ - 8.0 * 2.0 / 4.0 -";
        String expResult = "-88.0";
        String result = ProyectoCalculadora.evalua(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of metodoFinal method, of class ProyectoCalculadora.
     */
    @Test
    public void testMetodoFinal() {
        System.out.println("metodoFinal");
        String cadena = "~(12+3^2)*8/2-4";
        String expResult = "-88.0";
        String result = ProyectoCalculadora.metodoFinal(cadena);
        assertEquals(expResult, result);
    }
    
}

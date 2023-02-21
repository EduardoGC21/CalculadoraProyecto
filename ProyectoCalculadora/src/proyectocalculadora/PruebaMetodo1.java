/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocalculadora;

/**
 *
 * @author eduar
 */
public class PruebaMetodo1 {
    public static void main(String[] args) {
        System.out.println("Prueba");
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("(3+)"));
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija(""));
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija(")("));
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("(3)+3"));
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("(3+2)"));
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("(1.2/5)*100.1"));
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("0.1"));
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija(".1")); 
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("~2/.1")); 
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("()1+2")); 
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("(+)1+2")); 
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("1345+~123"));
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("~"));
        System.out.println(ProyectoCalculadora.revisaSintaxisInfija("(~)"));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocalculadora;
import java.util.ArrayList;
/**
 * Clase que contiene todos los metodos para la calculadora.
 * @author Eduardo Garcia, Regina Sanz, Emilia Hernandez, Manuel McCadden
 */
public class ProyectoCalculadora {
    
    /**
     * 
     * Revisa el balance de parentesis de la expresion que nos da el usuario.
     * @param String cadena que recibe
     * @return 
     * <ul>
     * <li> True si el dato tiene parentesis balanceados </li>
     * <li> False si el dato no tiene parentesis balanceados </li>
     * </ul>
     * 
     */
    public static boolean revisaParentesis(String cadena){
        PilaA<Character> pila = new PilaA();
        boolean resp = true;
        int i=0; 
        while(resp && i<cadena.length()){
            if(cadena.charAt(i)=='('){
                pila.push('(');
            }else{
                if(cadena.charAt(i)==')'){
                    if(pila.isEmpty()){
                        resp=false;
                    }else{
                        pila.pop();
                    }
                }
            }
            i++;
        }
        if(!pila.isEmpty()){
            resp=false;
        }
        return resp;
    }
    
    /**
     * 
     * Revisa que parentesis tengan datos adentro.
     * @param String cadena que recibe
     * @return <ul>
     * <li> True si el String tiene parentesis con datos contenidos </li>
     * <li> False si el String tiene parentesis sin datos contenidos </li>
     * </ul>
     * 
     */
    public static boolean revisaContenidoParentesis(String cadena){
        PilaADT<Character> pila = new PilaA();
        boolean resp = true;
        int i=0; //esta mal
        while(resp && i<cadena.length()){
            if(cadena.charAt(i)=='('){
                pila.push('(');
            }else{
                if(cadena.charAt(i)!=')'){
                    pila.push(cadena.charAt(i));
                }else{
                    if(!pila.isEmpty()){
                        if(pila.peek()=='('){
                            resp=false;
                        }
                    }
                }
            }
            i++;
        }
        return resp;
    }
    
    /**
     * 
     * Revisa que la parte de operadores y operandos de la expresion sea correcta
     * @param String cadena que recibe
     * @return <ul>
     * <li> True si el dato tiene operadores y operandos escritos correctamente </li>
     * <li> False si el dato no tiene operadores y operandos escritos correctamente </li>
     * </ul>
     * 
     */
    public static boolean revisaOperandosOperadores(String cadena){
        PilaADT<Character> pila = new PilaA();
        boolean resp = true;
        int i=0;
        Character chr;
        while(resp && i<cadena.length()){
            chr=cadena.charAt(i);
            if(chr=='0'|| chr=='1' || chr=='2' || chr=='3' || chr=='4' || chr=='5' || chr=='6' || chr=='7' || chr=='8' || chr=='9'){
                pila.push(chr);
            }else{
                if(chr=='.' || chr=='~'){
                    if(!pila.isEmpty()){
                        if(pila.peek()=='.'){
                            resp=false;
                        }
                    }
                    pila.push(chr);
                }else{
                    if(chr=='+' ||chr=='-'||chr=='/'||chr=='*'||chr=='^'){
                        if(pila.isEmpty()){
                            resp=false;
                        }else{
                            
                            Character chr2 = pila.peek();
                            if(chr2=='+'||chr2=='-'||chr2=='/'||chr2=='*'||chr2=='^'){
                                resp=false;
                            }else{
                                   pila.push(chr);
                            }
                        }
                    }
                }
            }
            i++;
        }
        if(!pila.isEmpty()){
            Character chr3 = pila.peek();
            if(chr3=='+'||chr3=='-'||chr3=='/'||chr3=='*'||chr3=='^'||chr3=='~'){
                resp=false;
            }
        }
        return resp;
    }
    
    /**
     * 
     * Revisa que la sintaxis infija de la expresion sea correcta
     * @param String cadena que recibe en forma infija
     * @return <ul>
     * <li> True si el dato tiene correcta sintaxis </li>
     * <li> False si el dato no tiene correcta sintaxis </li>
     * </ul>
     * @see revisaParentesis, revisaContenidoParentesis, revisaNumerosOperandos
     * 
     */
    public static boolean revisaSintaxisInfija(String cadena){
        boolean resp=true;
        PilaA<Character> pila = new PilaA();
        int i=0;
        if(cadena.equals("")){
            resp=false;
        }else{
            if(revisaParentesis(cadena)){
                if(revisaContenidoParentesis(cadena)){
                    if(revisaOperandosOperadores(cadena)==false){ 
                        resp=false;
                    }
                }else{
                    resp=false;
                }
            }else{
                resp=false;
            }
        }
        return resp;
    }
    
    /**
     * 
     * Convierte una cadena (expresión de forma infija) a un arreglo 
     * @param String cadena que recibe en forma infija
     * @return 
     * <pre>
     * Regresa un arreglo de tipo String.
     * En el que la primera entrada contiene a la “n” del arreglo (número de casillas que no están vacías) 
     * Y en el resto de las casillas hay o un símbolo matemático o un número (decimal o entero)
     * </pre>
     * 
     */
    public static String[] dividirCadena(String cadena){
        StringBuilder num = new StringBuilder();  
        int length = cadena.length(); 
        String[] res= new String[length+1]; 
        ArrayList<Character> op = new ArrayList<Character>();
        op.add('+');
        op.add('-');
        op.add('*');
        op.add('~');
        op.add('/');
        op.add('^');
        op.add(')');
        op.add('(');
        int i = 1; 
        char valor;
        
        for(int j=0; j<length; j++){
            valor=cadena.charAt(j);
            if(op.contains(valor)){
                res[i] = String.valueOf(valor);
                i++;
            }
            else{
                num.append(valor);
                if(j<length-1 && op.contains(cadena.charAt(j+1))){
                    res[i] =num.toString();
                    i++; 
                    num.setLength(0);
                }
                else if(j==length-1){
                    res[i] = num.toString();
                    num.setLength(0);
                    i++;
                }
            }
        }
        res[0]= i+""; 
        return res; 
    }
    
    /**
     * 
     * Convierte una expresion de forma infija a forma postfija
     * @param String cadena que recibe en forma infija
     * @return <ul>
     * <li> Regresa un String, que es la expresion ya convertida a postfija, dividida por espacios </li>
     * </ul>
     * @see obtenPrioridad, dividirCadena
     * 
     */
    public static String conviertePostfija(String cadena){
        String [] dato= dividirCadena(cadena);
        StringBuilder postfija= new StringBuilder(); 
        PilaADT <String> operadores= new PilaA();
        int i=1;
        boolean menosParentesis=false;
        boolean menos=false;
        double numero;
        String operador;
     
        while(i<Integer.parseInt(dato[0])){
            if(obtenPrioridad(dato[i])>0){
                while(!operadores.isEmpty() && obtenPrioridad(dato[i])<=obtenPrioridad(operadores.peek())){
                    postfija.append(operadores.pop());
                    postfija.append(" ");
                }
                operadores.push(dato[i]);
            }
            else{
                switch(dato[i].charAt(0)){
                    case '(':
                        operadores.push(dato[i]);
                        break; 
                    case ')':
                        while(!operadores.peek().equals("(")){
                            operador=operadores.pop();
                            if(menosParentesis){
                                switch(operador.charAt(0)){
                                    case'+':
                                        operador="-";
                                        break;
                                    case '-':
                                        operador="+";
                                        break;
                                    default:
                                        break;
                                }
                            }
                            postfija.append(operador);
                            postfija.append(" ");
                        }   
                        operadores.pop();
                        menosParentesis=false;
                        break;
                    case '~':
                        if(dato[i+1].charAt(0)=='('){
                            menosParentesis=true;
                            menos=true;
                        }
                        else{
                            postfija.append(dato[i]);
                            postfija.append(" ");
                        }  
                        break;
                    default: 
                        numero=Double.parseDouble(dato[i]);
                        if(menos){
                            numero*=-(1);
                            menos=false;
                        }
                        postfija.append(numero+" ");
                        break;
                }
            }
            i++;
        }
        while(!operadores.isEmpty()){
            postfija.append(operadores.pop());
            postfija.append(" ");
        }
        return postfija.toString();
    }
    
    /**
     * 
     * Asigna un valor de prioridad a distintos operadores matemáticos
     * @param String oper que es el operador al que se le quiere asignar un valor
     * @return <ul>
     * <li> 3 si la prioridad es de una potencia </li>
     * <li> 2 si la prioridad es de una multiplicacion o division </li>
     * <li> 1 si la prioridad es de una suma o resta </li>
     * <li> -1 en cualquier otro caso </li>
     * </ul>
     * 
     */
    public static int obtenPrioridad(String oper){
        int prioridad; 
        
        switch(oper.charAt(0)){
            case '^':
                prioridad=3; 
                break; 
            case '/':
                prioridad=2; 
                break; 
            case '*':
                prioridad=2; 
                break; 
            case '+':
                prioridad=1; 
                break;
            case '-':
                prioridad=1;
                break;
            default:
                prioridad=-1; 
        }
        return prioridad;    
    }

    /**
     * 
     * Evalúa una expresion escrita en forma postfija dividida por espacios
     * @param String cadena que recibe en forma de String
     * @return <ul>
     * <li> El resultado de la expresión </li>
     * </ul>
     * 
     */
    public static String evalua(String cadena){
        String []a=cadena.split(" ");
        PilaA<Double> pila=new PilaA();
        double num1;
        double num2;
        double operacion;
        int i=0;
        boolean menos=false;
        
        while(i<a.length){
           try{
               num1=Double.parseDouble(a[i]);
               pila.push(num1);
           } 
           catch(Exception e){
               if(a[i].charAt(0)=='~'){
                    i++;
                    num1=-Double.parseDouble(a[i]);
                    pila.push(num1);
               }
               else{
                    num2=pila.pop();
                    num1=pila.pop();
                    switch(a[i].charAt(0)){
                        case '+':
                            operacion=num1+num2;
                            break;
                        case '-':
                            operacion=num1-num2;
                            break;
                        case '*':
                            operacion=num1*num2;
                            break;
                        case '/':
                            operacion=num1/num2;
                            break;
                        case '^':
                            operacion=Math.pow(num1, num2);
                            break;
                        default:
                            operacion=0;
                            break;
                    }
                    pila.push(operacion);
               }
            }
           i++;
        }
        return pila.pop()+"";
    }
     
    /**
     * 
     * Recibe una operacion matematica de forma infija, revisa la sintaxis, la convierte a postfija, y la evalua
     * @param String cadena que recibe en forma de String infija
     * @return <ul>
     * <li> El resultado de la expresión </li>
     * </ul>
     * @see revisaSintaxisInfija, conviertePostfija, evalua
     * 
     */
    public static String metodoFinal(String cadena){
        String resp="Syntax Error";
        
        if(revisaSintaxisInfija(cadena)){
            resp = evalua(conviertePostfija(cadena));
        }
        return resp;
    }

    
}
package Client;

import Server.BeanCalcu;
import Server.DaoCalcu;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ClientRPC {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {

        DaoCalcu daoCalcu = new DaoCalcu();
        BeanCalcu beanCalcu = new BeanCalcu();

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        XmlRpcClient client = new XmlRpcClient();
        config.setServerURL(new URL("http://localhost:1200"));
        client.setConfig(config);

        String option = "", firstNumber ="", secondNumber = "";
        Object [] data;
        String response;

        do {
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Exponente");
            System.out.println("6. Raiz");
            System.out.println("7. Consultar Historial");
            System.out.println("8. Salir");
            System.out.println("Seleccione una opcion...");
            option = sc.next();
            if(isNumber(option)){
                switch(Integer.parseInt(option)){
                    case 1:
                        System.out.println("SUMA");
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = sc.next();
                            if (!isDouble(firstNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(firstNumber));
                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(secondNumber));
                        // Ejecucion del metodo en el servidor ...

                        data = new Object[]{firstNumber, secondNumber};
                        response = (String) client.execute("Methods.sum", data);
                        System.out.println(response);
                        break;
                    case 2:
                        System.out.println("RESTA");
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = sc.next();
                            if (!isDouble(firstNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(firstNumber));
                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(secondNumber));
                        // Ejecucion del metodo en el servidor ...

                        data = new Object[]{firstNumber, secondNumber};
                        response = (String) client.execute("Methods.rest", data);
                        System.out.println(response);
                        break;
                    case 3:
                        System.out.println("MULTIPLICACION");
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = sc.next();
                            if (!isDouble(firstNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(firstNumber));
                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(secondNumber));
                        // Ejecucion del metodo en el servidor ...

                        data = new Object[]{firstNumber, secondNumber};
                        response = (String) client.execute("Methods.multi", data);
                        System.out.println(response);
                        break;
                    case 4:
                        System.out.println("DIVISION");
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = sc.next();
                            if (!isDouble(firstNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(firstNumber));
                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(secondNumber));
                        // Ejecucion del metodo en el servidor ...

                        data = new Object[]{firstNumber, secondNumber};
                        response = (String) client.execute("Methods.div", data);
                        System.out.println(response);
                        break;
                    case 5:
                        System.out.println("EXPONENTE");
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = sc.next();
                            if (!isDouble(firstNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(firstNumber));
                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(secondNumber));
                        // Ejecucion del metodo en el servidor ...

                        data = new Object[]{firstNumber, secondNumber};
                        response = (String) client.execute("Methods.exp", data);
                        System.out.println(response);
                        break;
                    case 6:
                        System.out.println("RAIZ");
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = sc.next();
                            if (!isDouble(firstNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(firstNumber));
                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Ingrese un numero valido");
                        }while(!isDouble(secondNumber));
                        // Ejecucion del metodo en el servidor ...

                        data = new Object[]{firstNumber, secondNumber};
                        response = (String) client.execute("Methods.raiz", data);
                        System.out.println(response);
                        break;
                    case 7:
                        daoCalcu.history();
                        break;
                    case 8:
                        System.out.println("Hasta lUEGO");
                        break;
                    default:
                        System.out.println("No existe esta opcion");
                }
            }else{
                System.out.println("La opcion es incorrecta. Intente nuevamente");
            }
        }while (option.equals("8"));
    }

    public static boolean isNumber (String number){
        try{
            Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isDouble (String number){
        try{
            Double.parseDouble(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}

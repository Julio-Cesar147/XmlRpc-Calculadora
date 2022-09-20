package Server;

public class Methods {

    private String f_num, s_num;

    public String sum (String f_num, String s_num) {
        double n1 = Double.parseDouble(f_num);
        double n2 = Double.parseDouble(s_num);
        double rs;

        return "El resultado de la suma es: " + (rs = n1 + n2);
    }

    public String rest (String f_num, String s_num) {
        double n1 = Double.parseDouble(f_num);
        double n2 = Double.parseDouble(s_num);
        double rs = n1 - n2;

        return "El resultado de la resta es : " + (rs = n1 - n2);
    }

    public String multi (String f_num, String s_num) {
        double n1 = Double.parseDouble(f_num);
        double n2 = Double.parseDouble(s_num);
        double rs;

        return "El resultado de la multiplicacion es : " + (rs = n1 * n2);
    }

    public String div (String f_num, String s_num) {
        double n1 = Double.parseDouble(f_num);
        double n2 = Double.parseDouble(s_num);
        double rs;

        return "El resultado de la division es : " + (rs = n1 / n2);
    }

    public String exp (String f_num, String s_num) {
        double n1 = Double.parseDouble(f_num);
        double n2 = Double.parseDouble(s_num);
        double rs;

        return "El resultado del exponente es : " + (rs = Math.pow(n1, n2));
    }

    public String raiz (String f_num, String s_num) {
        double n1 = Double.parseDouble(f_num);
        double n2 = Double.parseDouble(s_num);
        double rs;
        double rs2;

        return "El resultado de la raiz es para numero 1: " + (rs = Math.sqrt(n1)) + " Y para el numero 2: " + (rs2 = Math.sqrt(n2));
    }
}

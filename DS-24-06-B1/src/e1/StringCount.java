package e1;

public class StringCount {

    public static int countWords(String text) {
        int contador;

        if (text == null){
            return 0;
        } else {
            String string1 = text.strip();
            String[] string2 = string1.split("\\s+");
            contador = string2.length;
            return contador;
        }

    }

    public static int countChar(String text, char c) {
        int contador = 0, pos;
        if (text == null) {//string vacio
            return contador;
        } else {
            pos = text.indexOf(c);
            while (pos != -1) {//recorro array y aumento contador cuando encuentro la letra
                contador++;
                pos = text.indexOf((c), pos + 1);
            }
        }
        return contador;
    }

    public static int countCharIgnoringCase(String text, char c) {
        int total;
        total = countChar(text, c) + countChar(text, Character.toUpperCase(c));
        return total;
    }

    public static boolean isPasswordSafe(String password) {
        int contador = 0, contadorNum = 0, contadorMay = 0, contadorMin = 0, contadorEsp = 0;
        System.out.println("" + password);
        for (int j = 0; j < password.length(); j++) {
            char c = password.charAt(j);
            String valor = String.valueOf(c);
            if (valor.matches("[A-Z]")) {
                contadorMay++;
            } else if (valor.matches("[a-z]")) {
                contadorMin++;
            } else if (valor.matches("[0-9]")) {
                contadorNum++;
            } else if (valor.matches("[?@.,#$]")) {
                contadorEsp++;
            }
            contador++;
        }
        return (contador >= 8) && (contadorMin > 0) && (contadorMay > 0) && (contadorNum > 0) && (contadorEsp > 0);
    }

}

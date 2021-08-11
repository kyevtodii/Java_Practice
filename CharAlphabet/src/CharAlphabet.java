public class CharAlphabet {
    public static void main(String[] args) {

        char ch = 'a';
        for(; ch <= 'z'; ++ch){
            System.out.println("char = " + ch + " code = " + (int) ch);
        }
        ch = 'A';
        for(; ch <= 'Z'; ++ch) {
            System.out.println("char = " + ch + " code = " + (int) ch);
        }
        ch = 'а';
        for(; ch <= 'я'; ++ch) {
            System.out.println("char = " + ch + " code = " + (int) ch);
        }
        ch = 'А';
        for(; ch <= 'Я'; ++ch) {
            System.out.println("char = " + ch + " code = " + (int) ch);
        }
    }
}

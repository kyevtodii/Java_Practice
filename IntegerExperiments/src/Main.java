public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        container.count += 9843;
        System.out.println("ConteinerCount: " + container.count);
        System.out.println("SumDigits: " + sumDigits(container.count));
    }

    public static Integer sumDigits(Integer number) {
        String stringNumber = number.toString();
        int sum = 0;
        for(int i = 0; i < stringNumber.length(); i++) {
            System.out.println(stringNumber.charAt(i));
            int x = Integer.parseInt(String.valueOf(stringNumber.charAt(i)));
            sum += x;
        }
        return sum;
    }
}

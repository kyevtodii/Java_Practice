import java.util.Scanner;
public class GeometryCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        double radius;
        double area;
        double circumference;
        double base;
        double height;
        double areaTriangle;
        double sphereDiam;
        double sphereRadius;
        double sphereVolume;
        double a, b, c;

        for(;;) {
            System.out.println("Для подсчета площади круга введите: 1 ");
            System.out.println("Для подсчета площали треугольника введите: 2");
            System.out.println("Для подсчета объема сферы введите: 3");
            System.out.println("Для проверки возможности построения треугольника введите: 4");
            int i = scanner.nextInt();
            if (i == 1) {
                System.out.println("Введите радиус круга: ");
                radius = scanner.nextDouble();
                area = Math.PI * (radius * radius);
                circumference = Math.PI * 2 * radius;
                System.out.println("Площадь круга равна: " + area);
                System.out.println("Длинна окружности равна: " + circumference);
                System.out.println("=================================");
            } else if (i == 2) {
                System.out.println("Введите ширину треугольника: ");
                base = scanner.nextDouble();
                System.out.println("Введите высоту треугольника: ");
                height = scanner.nextDouble();
                areaTriangle = (base * height) / 2;
                System.out.println("Площадь треугольника равна: " + areaTriangle);
                System.out.println("=================================");
            } else if (i == 3) {
                System.out.println("Введите диаметр сферы: ");
                sphereDiam = scanner.nextDouble();
                sphereRadius = sphereDiam / 2.0;
                sphereVolume = (4.0 / 3.0) * Math.PI * Math.pow(sphereRadius, 3);
                System.out.println("Радиус сферы равен: " + sphereVolume);
                System.out.println("=================================");
            } else if (i == 4) {
                System.out.println("Введите первое число: ");
                a = scanner.nextDouble();
                System.out.println("Введите второе число: ");
                b = scanner.nextDouble();
                System.out.println("Введите третье число: ");
                c = scanner.nextDouble();

                if (a + b > c && a + c > b && b + c > a) {
                    System.out.println("Треугольник возможен!");
                } else {
                    System.out.println("Треугольник не возможен!");
                }
                System.out.println("=================================");
            } else {
                System.out.println("Вы ввели некоректные данные: ");
                scanner.nextLine();
                System.out.println("=================================");
            }
        }
    }
}

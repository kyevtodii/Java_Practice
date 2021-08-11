package core;

public class Camera
{
    public static Car getNextCar()
    {
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        int randomHeight = (int) (1000 + 3500. * Math.random());
        double randomWeight = 600 + 10000 * Math.random();

        Car car = new Car();
        car.setNumber(randomNumber = Double.toString(Math.random()).substring(2, 5));
        car.setHeight(randomHeight = (int) (1000 + 3500. * Math.random()));
        car.setWeight(randomWeight = 600 + 10000 * Math.random());
        car.setHasVehicle(Math.random() > 0.5);
        car.setIsSpecial(Math.random() < 0.15);

        return car;
    }
}
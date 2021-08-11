
public class Cat {
    public static final int LEGS_COUNT = 4;
    public static final int EYE_COUNT = 2;
    public static final byte TAIL_COUNT = 1;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    private String name;
    private double originWeight;
    private double weight;
    private double minWeight;
    private double maxWeight;
    private double foodCount;
    private static int catCount;
    private CatColor color;

    public void setCatColor(CatColor color) {
        this.color = color;
    }
    public CatColor getColor() {
        return color;
    }

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        foodCount = 0;
        catCount++;
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
    }
    public Cat(Cat copyCat) {
        this.name = copyCat.name;
        this.weight = copyCat.weight;
        this.originWeight = copyCat.weight;
        this.minWeight = 1000.0;
        this.maxWeight = 9000.0;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void meow() {
        weight = weight - 1000;
        System.out.println("Meow");
        if(weight < minWeight) {
            catCount--;
        }
        else if(weight > maxWeight) {
            catCount--;
        }
    }

    public void feed(Double amount) {
        foodCount += amount;
        weight = weight + amount;
        System.out.println("Yum,yum,yum");
        if(weight < minWeight) {
            catCount--;
        }
        else if(weight > maxWeight) {
            catCount--;
        }
    }

    public Double getFoodCount() {
        return foodCount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
        System.out.println("purrrr");
        if(weight < minWeight) {
            catCount--;
        }
        else if(weight > maxWeight) {
            catCount--;
        }
    }

    public void pee() {
        weight = weight - 20;
        System.out.println("Ouhhh");
        if(weight < minWeight) {
            catCount--;
        }
        else if(weight > maxWeight) {
            catCount--;
        }
    }

    public String getStatus() {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
    public static int getCatCount() {
        return catCount;
    }
}
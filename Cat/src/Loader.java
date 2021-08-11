public class Loader {

    public static void main(String[] args) {

        Cat furfur = new Cat();
        furfur.setName("furfur");
        furfur.setCatColor(CatColor.WHITE);
        System.out.println("name: " + furfur.getName() + "\n"
                + "color: " + furfur.getColor() + "\n" + "weight: " + furfur.getWeight());
        furfur.meow();
        System.out.println("weight: " + furfur.getWeight() + "\n" + "status: " + furfur.getStatus());
        System.out.println("Cat count is: " + Cat.getCatCount());
        System.out.println("----------------------------------");

        Cat murmur = new Cat();
        murmur.setName("murmur");
        murmur.setCatColor(CatColor.BLACK);
        System.out.println("name: " + murmur.getName() + "\n"
                + "color: " + murmur.getColor() + "\n" + "weight: " + murmur.getWeight());
        murmur.feed(murmur.getWeight() / 200);
        System.out.println("weight: " + murmur.getWeight() + "\n" + "status: " + murmur.getStatus());
        System.out.println("Cat count is: " + Cat.getCatCount());
        System.out.println("----------------------------------");

        Cat buba = new Cat();
        buba.setName("buba");
        buba.setCatColor(CatColor.GREY);
        System.out.println("name: " + buba.getName() + "\n"
                + "color: " + buba.getColor() + "\n" + "weight: " + buba.getWeight());
        while(buba.getWeight() <= 9000) {
            buba.drink(buba.getWeight() / 5);
            System.out.println("weight: " + buba.getWeight() + "\n" + "status: " + buba.getStatus());
        }
        System.out.println("Cat count is: " + Cat.getCatCount());
        System.out.println("----------------------------------");

        Cat toby = new Cat();
        toby.setName("toby");
        toby.setCatColor(CatColor.TRICOLOR);
        System.out.println("name: " + toby.getName() + "\n"
                + "color: " + toby.getColor() + "\n" + "weight: " + toby.getWeight());
        while(toby.getWeight() >= 1000) {
            toby.meow();
            System.out.println("weight: " + toby.getWeight() + "\n" + "status: " + toby.getStatus());
        }
        System.out.println("Cat count is: " + Cat.getCatCount());
        System.out.println("----------------------------------");

        Cat bobby = new Cat();
        bobby.setName("bobby");
        bobby.setCatColor(CatColor.SMOKY);
        System.out.println("name: " + bobby.getName() + "\n"
                + "color: " + bobby.getColor() + "\n" + "weight: " + bobby.getWeight());
        bobby.feed(bobby.getWeight() / 20);
        System.out.println("weight: " + bobby.getWeight() + "\n" + "eat: " + bobby.getFoodCount());
        bobby.pee();
        System.out.println("weight: " + bobby.getWeight());
        System.out.println("Cat count is: " + Cat.getCatCount());
        System.out.println("----------------------------------");

        Cat toto = new Cat();
        toto.setName("toto");
        toto.setCatColor(CatColor.GREY);
        System.out.println("name: " + toto.getName() + "\n"
                + "color: " + toto.getColor() + "\n" + "weight: " + toto.getWeight());
        System.out.println("Cat count is: " + Cat.getCatCount());
        System.out.println("----------------------------------");

        Cat lolo = new Cat();
        lolo.setName("lolo");
        lolo.setCatColor(CatColor.WHITE);
        System.out.println("name: " + lolo.getName() + "\n"
                + "color: " + lolo.getColor() + "\n" + "weight: " + lolo.getWeight());
        lolo.drink(100.10);
        lolo.pee();
        System.out.println("weight: " + lolo.getWeight());
        lolo.feed(150.0);
        lolo.drink(250.0);
        System.out.println("weight: " + lolo.getWeight());
        lolo.feed(155.0);
        lolo.pee();
        System.out.println("status: " + lolo.getStatus());
        System.out.println("food count: " + lolo.getFoodCount());
        System.out.println("Cat count is: " + Cat.getCatCount());
        System.out.println("----------------------------------");

        Cat tom = getKitten();
        tom.setName("tom");
        tom.setCatColor(CatColor.GINGER);
        System.out.println("name: " + tom.getName() + "\n"
                + "color: " + tom.getColor() + "\n" + "weight: " + tom.getWeight());
        lolo.feed(20.0);
        lolo.drink(60.0);
        System.out.println("weight: " + tom.getWeight() + "\n" + "status: " + tom.getStatus());
        System.out.println("Cat count is: " + Cat.getCatCount());
        System.out.println("----------------------------------");

        Cat borya = new Cat(3232.90);
        borya.setName("borya");
        borya.setCatColor(CatColor.BLACK);

        Cat murka = new Cat(borya);
        murka.setName("murka");
        murka.setCatColor(CatColor.WHITE);
        murka.setWeight(2903.904);


        System.out.println(borya.getName() + "\n" + borya.getStatus()
                + "\n" + borya.getWeight() + "\n" + "color : " + borya.getColor());
        System.out.println("Cat count is: " + Cat.getCatCount() );
        System.out.println("----------------------------------");
        System.out.println(murka.getName() + "\n" + murka.getStatus()
                + "\n" + murka.getWeight() + "\n" + "color : " + murka.getColor());
        System.out.println("Cat count is: " + Cat.getCatCount());
        System.out.println("----------------------------------");
    }

    public static Cat getKitten() {
        return new Cat(1100.890);
    }
}


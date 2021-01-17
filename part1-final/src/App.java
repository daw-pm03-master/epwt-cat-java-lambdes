public class App {

    public static void main(String[] args) {

        Apple apples[] = init();

        //Calcul del numero de pomes verdes
        int numberOfGreenApples =
                countApples(apples,
                        new AppleGreenPredicate());

        System.out.println(
                "The total number of green apples is: "
                        + numberOfGreenApples
        );


        //Calcul del numero de pomes vermelles
        int numberOfRedApples =
                countApples(apples,
                        new AppleRedPredicate());

        System.out.println(
                "The total number of red apples is: "
                + numberOfRedApples
        );

        //Calcul de numero de pomes pesades
        //(150 grams o més)
        int numberOfHeavyApples =
                countApples(apples,
                        new AppleHeavyPredicate());

        System.out.println(
                "The total number of heavy apples is: "
                        + numberOfHeavyApples
        );

        //Calcul de numero de pomes lleugeres
        //(115 grams o menys)
        int numberOfLightApples =
                countApples(apples,
                        new AppleLightPredicate());

        System.out.println(
                "The total number of light apples is: "
                        + numberOfLightApples
        );

        //Calcul i impresió del numero de pomes verdes
        //i que també són pesades (150 grams o més)
        int numberOfGreenAndHeavyApples =
                countApples(apples,
                        new AppleGreenAndHeavyPredicate());

        System.out.println(
                "The total number of green and heavy apples is: "
                        + numberOfGreenAndHeavyApples
        );


    }

    static int countApples(Apple [] apples, ApplePredicate predicate) {
        int amount = 0;
        for(Apple a : apples) {
            if(predicate.test(a))
                amount++;
        }
        return amount;
    }




    static Apple[] init(){
        Apple apple1 = new Apple();
        apple1.color = "green";
        apple1.weight = 165;

        Apple apple2 = new Apple();
        apple2.color = "red";
        apple2.weight = 115;

        Apple apple3 = new Apple();
        apple3.color = "green";
        apple3.weight = 145;

        Apple apple4 = new Apple();
        apple4.color = "yellow";
        apple4.weight = 205;

        Apple apple5 = new Apple();
        apple5.color = "yellow";
        apple5.weight = 185;

        Apple apple6 = new Apple();
        apple6.color = "red";
        apple6.weight = 130;

        Apple apple7 = new Apple();
        apple7.color = "green";
        apple7.weight = 155;

        Apple apple8 = new Apple();
        apple8.color = "red";
        apple8.weight = 152;

        Apple apple9 = new Apple();
        apple9.color = "green";
        apple9.weight = 150;

        Apple apple10 = new Apple();
        apple10.color = "yellow";
        apple10.weight = 170;

        Apple apple11 = new Apple();
        apple11.color = "green";
        apple11.weight = 140;

        Apple apple12 = new Apple();
        apple12.color = "red";
        apple12.weight = 120;

        Apple[] apples = new Apple[]{
                apple1, apple2, apple3, apple4,
                apple5, apple6, apple7, apple8,
                apple9, apple10, apple11, apple12
        };

        return apples;
    }
}

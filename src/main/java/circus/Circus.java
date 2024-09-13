package circus;

import circus.animal.*;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;
import static circus.animal.Animal.AnimalNameComparator;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            printArrayListSize(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }
    private static void printAllAnimals(ArrayList<Animal> animalsArrayList) {
        for (Animal a: animalsArrayList) {
            System.out.println(a);
        }
    }
    private static void printArrayListSize(String animalsArrayList) {
        System.out.println(animalsArrayList);
    }


    public static void main(String[] args) {
        System.out.println("Number of animals in the array are: " + animals.length);
        // This does not work as arrays cannot change size
        // animals[3] = new Elephant("Eli");
        ArrayList<Animal> animalsArrayList = new ArrayList<>(Arrays.asList(animals));
        printAllAnimals(animalsArrayList);
        Elephant strongOne = new Elephant("Strong One");
        animalsArrayList.add(strongOne);
        Duck andy = new Duck("Andy");
        animalsArrayList.add(andy);
        printAllAnimals(animalsArrayList);
        printArrayListSize("Size of our animal array list: " + animalsArrayList.size());
        System.out.println("Strong One is in position: " + (animalsArrayList.indexOf(strongOne) + 1));
        System.out.println("Before sorting: ");
        printAllAnimals(animalsArrayList);
        animalsArrayList.sort(AnimalNameComparator);
        System.out.println("After sorting: ");
        printAllAnimals(animalsArrayList);

        // makeAnimalsTalk();
        // System.out.println("Total value of animals " + calculateAssetValue(animals));
        // System.out.println("Total value of equipments " + calculateAssetValue(equipments));

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        animalArrayList.add(new Tiger("Sherkhan"));
        System.out.println("Number of animals: " + animalArrayList.size());

        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);
        animalArrayList.add(strongOne);

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Henry");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Peter");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);
        Cage<Elephant> elephantCage = new Cage<>();
        elephantCage.lockUp(strongOne);
        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }


}

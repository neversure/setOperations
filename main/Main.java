package main;


import carModels.MySet;


public class Main {
    public static void main(String[] args){
        MySet setA = new MySet();
        MySet setB = new MySet();

        setA.setMySetFromFile("C:\\Users\\m video\\Desktop\\1.txt", 0.6);
        setB.setMySetFromFile("C:\\Users\\m video\\Desktop\\1.txt", 0.7);

        System.out.println("множество A:");
        setA.printSet();
        System.out.println("множество B:");
        setB.printSet();

        System.out.println("");

        System.out.println("combination:");
        (setA.combiningSets(setB)).printSet();
        System.out.println("intersection:");
        (setA.intersectionOfSets(setB)).printSet();
        System.out.println("difference A - B:");
        (setA.differenceOfSets(setB)).printSet();
        System.out.println("difference B - A:");
        (setB.differenceOfSets(setA)).printSet();
        System.out.println("symmetric difference:");
        (setA.symmetricDifferenceOfSets(setB)).printSet();

    }
}

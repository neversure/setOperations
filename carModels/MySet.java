package carModels;

import java.util.HashSet;
import java.io.*;

public class MySet {
    private final HashSet<String> car_models = new HashSet<>();

    public void setMySetFromFile(String file_path, double probability) {

        try {
            //готовимся читать файл строчками

            File file = new File(file_path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            //читаем
            String line = reader.readLine();
            while (line != null) {
                double p  = Math.random();
                //заполняем по вероятности
                if((probability - p) > 0) car_models.add(line);
                line = reader.readLine();
            }
            System.out.println("Добавленно элементов: " + car_models.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //вывод множеств
    public void printSet(){
        StringBuilder result = new StringBuilder();
        for(String model: this.car_models){
            result.append(model);
            result.append(" ");
        }
        System.out.println(result);
    }
    //объединение множеств
    public MySet combiningSets(MySet B){
        MySet result = this;
        result.car_models.addAll(B.car_models);
        return result;
    }
    //пересечение множеств
    public MySet intersectionOfSets(MySet B){
        MySet result = new MySet();
        if(this.car_models.size() < B.car_models.size()){
            for(String model: this.car_models){
                if(B.car_models.contains(model)){
                    result.car_models.add(model);
                }
            }
        } else{
            for(String model: B.car_models){
                if(this.car_models.contains(model)){
                    result.car_models.add(model);
                }
            }
        }
        if(result.car_models.size() == 0){
            result.car_models.add("*empty*");
        }
        return result;
    }
    //разность
    public MySet differenceOfSets(MySet B){
        MySet result = new MySet();
        for(String model: this.car_models){
            if(!B.car_models.contains(model)) result.car_models.add(model);
        }
        if(result.car_models.size() == 0){
            result.car_models.add("*empty*");
        }
        return result;
    }
    //симметрическая разность
    public MySet symmetricDifferenceOfSets(MySet B){
        MySet combination = this.combiningSets(B);
        MySet intersection = this.intersectionOfSets(B);
        MySet result = combination.differenceOfSets(intersection);
        if(result.car_models.size() == 0){
            result.car_models.add("*empty*");
        }
        return result;
    }


}

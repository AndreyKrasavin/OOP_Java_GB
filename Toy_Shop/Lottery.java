package org.example;

import java.util.*;

public class Lottery {
    private ArrayList<Toy> toys;
    private Map<String, Integer> toysFrequency;
    private PriorityQueue<Toy> toysWithTrueRate;

    public Lottery() {
        this.toys =new ArrayList<>();
    }

    public void addToy(Toy toy) {
        for (int i = 0; i < toy.getRate(); i++) {
            this.toys.add(toy);
        }
        initFrequencyMap();
    }
private void updateMapWithFrequency(){
        initFrequencyMap();
        computeFrequency();
}
    private void initFrequencyMap() {

        this.toysFrequency = new HashMap<>();
        for (Toy toy: this.toys){
            this.toysFrequency.putIfAbsent(toy.getName(),0);
        }

        computeFrequency();
    }

    private void computeFrequency(){

        for (Toy toy: this.toys){
            this.toysFrequency.put(toy.getName(),this.toysFrequency.get(toy.getName()) + 1);
        }

        updateRateAndQueue();
    }

    private void updateRateAndQueue(){
        this.toysWithTrueRate = new PriorityQueue<>();
        for (Toy toy:this.toys){
            toy.setRate((float)this.toysFrequency.get(toy.getName())/toys.size());
            toysWithTrueRate.offer(toy);
        }
    }

    public Toy getToy(){
        Set<Toy> tempToys = new HashSet<Toy>();
        PriorityQueue<Toy> tempQueue = new PriorityQueue<>(this.toysWithTrueRate);
        Toy returnToy;
        double rollRate = roll();
        while (!tempQueue.isEmpty()){
            Toy tempToy = tempQueue.poll();
            if (tempToy.getRate() >= rollRate){
                tempToys.add(tempToy);
            }
        }
        if (tempToys.size() > 1){
            returnToy = (Toy) tempToys.toArray()[new Random().nextInt(0,tempToys.size())];
        }else returnToy =  (Toy)tempToys.toArray()[0];
        //TODO нужно проверить исключение outOfBounds
        removeToyFromDatabase(returnToy);
        return returnToy;
    }

    private void removeToyFromDatabase(Toy toyToRemove){
        this.toys.remove(toyToRemove);
        updateMapWithFrequency();
    }

    public double roll(){
        Random random = new Random();

        return random.nextDouble();
    }

    public PriorityQueue<Toy> getToysWithTrueRate() {
        return toysWithTrueRate;
    }
}

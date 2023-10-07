/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gemina_exam3;

import java.util.PriorityQueue;
import java.util.Scanner;
import javafx.scene.Node;

class Exam implements Comparable<Exam>{
    String name;
    int priority;
    
    public Exam (String name , int priority){
        this.name = name;
        this.priority = priority;
    }
    public int compareTo(Exam other){
        return Integer.compare(other.priority, this.priority);
    }
    public String toString(){
        return("pages"+name + ", priority" + priority +"}");
    }

}
public class Exam_number1 {
    private PriorityQueue<Exam> queue;
    private Node front;
    private int printCount;
    
    public Exam_number1(){
        queue = new PriorityQueue<>(5);
        front = null;
        printCount = 5;
    }
    public void insertion(Exam item){
        if(queue.size() < 5){
            queue.add(item);
        }else{
            Exam highPrio = queue.poll();
            System.out.println("The highest is REMOVEDD!!!"+ highPrio);
            queue.add(item);
        }
        printCount++;
        if(printCount > 10){
            delete();
            
        }
    }
    public void delete(){
        if (queue.isEmpty()){
            queue.poll();
            printCount--;
        }
    }
    public void display(){
        if(queue.isEmpty()){
            System.out.println("Empty Queue");
        }else{
            System.out.println("This are the Queue" + queue);
        }
    }
    public static void main(String[] args){
        Exam_number1 queue = new Exam_number1();
        Scanner scn = new Scanner(System.in);
        
        while(true){
            System.out.println("|=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=|");
            System.out.println("          *M-E-N-U*              ");
            System.out.println("     1. Insert to Print          ");
            System.out.println("     2. Display Print            ");
            System.out.println("|=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=|");
            int choice = scn.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("How many Pages?: ");
                    String name = scn.next();
                    
                    System.out.println("Enter Priority Number: ");
                    int prior = scn.nextInt();
                    
                    Exam newItem = new Exam(name,prior);
                    queue.insertion(newItem);
                    break;
                case 2:
                    queue.display();
                    break;
                default:
                    throw new AssertionError();
            }
    }
    
}
}
    


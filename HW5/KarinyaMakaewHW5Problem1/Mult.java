/*
 * Filename: Mult.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 5 Question 1
 * Deadline: 07/17/2012
 * Description: Given in Blackboard (no modification)
 * 		
 */

/* Generated by Together */

public class Mult extends Binop {
    public Mult() {}
    public Mult(Node l, Node r) {
        super(l, r);
    }
    public double eval(double[] data) {
        return lChild.eval(data) * rChild.eval(data);
    }
    public String toString() {
        String s = new String();
        s += "(" + lChild.toString() + " * " + rChild.toString() + ")";
        return s;
    }
}

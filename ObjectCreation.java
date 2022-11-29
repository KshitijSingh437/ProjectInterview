package interviewQues;

class Fruit {

    public Fruit() {
        System.out.println("PARENT class constructor");
        System.out.println("PARENT class object HASHCODE : " + this.hashCode());
        System.out.println(this.getClass().getName());
    }

    protected void taste() {

    }

    public Object color() {
        System.out.println("color of fruit");
        return null;
    }

    @Override
    public String toString() {
        return "Fruit{}";
    }
}

class Apple extends Fruit {

    public Apple() {
        System.out.println("CHILD constructor invoked");
        System.out.println("CHILD object HASHCODE : " + this.hashCode());
        System.out.println(this.hashCode() + " : " + super.hashCode());
        System.out.println(this.getClass().getName() + " : " +
                super.getClass().getName());
    }

    @Override
    public void taste() {

    }

    @Override
    public Object color() {
        System.out.println("color of fruit");
        return "woah";
    }

    @Override
    public String toString() {
        return "Apple{}";
    }
}

public class ObjectCreation {

    public static void main(String[] args) {
        Apple apple = new Apple();
    }
}

package interviewQues;

public class Laptop implements Comparable<Laptop> {

    private String name;

    private int ram;

    private int price;

    public Laptop(String name, int ram, int price) {
        this.name = name;
        this.ram = ram;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Laptop o) {
        if (o.getPrice() > this.price) {
            return 1;
        } else if (o.price < this.price) {
            return -1;
        } else {
            return 0;
        }
    }
}

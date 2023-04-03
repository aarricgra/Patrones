abstract class Product {
    protected String title;
    protected double price;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public abstract void display();
}

class Book extends Product {
    protected String author;

    public Book(String title, double price, String author) {
        super(title, price);
        this.author = author;
    }

    @Override
    public void display() {
        System.out.println("Book - Title: " + title + ", Author: " + author + ", Price: " + price);
    }
}

class Electronic extends Product {
    protected String manufacturer;

    public Electronic(String title, double price, String manufacturer) {
        super(title, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public void display() {
        System.out.println("Electronic - Title: " + title + ", Manufacturer: " + manufacturer + ", Price: " + price);
    }
}

class Clothing extends Product {
    protected String size;

    public Clothing(String title, double price, String size) {
        super(title, price);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Clothing - Title: " + title + ", Size: " + size + ", Price: " + price);
    }
}

class ProductFactory {
    public static Book createBook(String title, double price, String author) {
        return new Book(title, price, author);
    }

    public static Electronic createElectronic(String title, double price, String manufacturer) {
        return new Electronic(title, price, manufacturer);
    }

    public static Clothing createClothing(String title, double price, String size) {
        return new Clothing(title, price, size);
    }
}

public class Main {
    public static void main(String[] args) {
        Product book = ProductFactory.createBook("Harry Potter and the Philosopher's Stone", 9.99, "J.K. Rowling");
        book.display();

        Product electronic = ProductFactory.createElectronic("iPhone 12 Pro", 999.99, "Apple");

        electronic.display();

        Product clothing = ProductFactory.createClothing("Maxi Dress", 38, "ASOS");
        clothing.display();
    }
}

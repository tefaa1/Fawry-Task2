package model;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int publishedYear, double price, int stock) {

        super(isbn, title, publishedYear, price);

        if (stock < 0) {
            throw new IllegalArgumentException("Stock should be positive");
        }
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (quantity > stock) {
            throw new IllegalArgumentException("Not enough stock available");
        }
        stock -= quantity;
    }

    @Override
    public String toString() {
        return "PaperBook{" +
                "stock=" + stock +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publishedYear=" + publishedYear +
                ", price=" + price +
                "}\n";
    }
}

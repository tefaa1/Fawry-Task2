package model;

import java.time.LocalDate;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected int publishedYear;
    protected double price;

    public Book(String isbn, String title, int publishedYear, double price) {

        this.isbn = isbn;
        this.title = title;
        this.publishedYear = publishedYear;
        this.price = price;
        validate();
    }

    private void validate(){
        if(isbn == null || isbn.trim().isEmpty()){
            throw new IllegalArgumentException("ISBN should not be empty");
        }
        if(title.trim().isEmpty()){
            throw new IllegalArgumentException("Title should not be empty");
        }
        if (publishedYear < 1200 || publishedYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("There is no book with this publish year");
        }
        if(price < 0){
            throw new IllegalArgumentException("Price should be positive");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public double getPrice() {
        return price;
    }
}

package service;

import dto.EBookPurchaseDTO;
import dto.PaperBookPurchaseDTO;
import dto.PurchaseDTO;
import model.Book;
import model.EBook;
import model.PaperBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {

    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book){

        if(books.containsKey(book.getIsbn())){
            throw new IllegalArgumentException("This book with this ISBN " + book.getIsbn() +" is already exist");
        }

        books.put(book.getIsbn(),book);
    }

    public List<Book> removeOutDatedBooks(int years){

        List<String> isbnForRemove = new ArrayList<>();
        List<Book> removedBooks = new ArrayList<>();

        for(Book book: books.values()){
            int gap = LocalDate.now().getYear() - book.getPublishedYear();
            if(gap>years){
                isbnForRemove.add(book.getIsbn());
                removedBooks.add(book);
            }
        }

        for (String isbn: isbnForRemove){
            books.remove(isbn);
        }

        return removedBooks;
    }

    public void buyBook(PurchaseDTO purchaseDTO){

        String isbn = purchaseDTO.getIsbn();
        if(!books.containsKey(isbn)){
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found");
        }

        Book book = books.get(isbn);
        if(book instanceof PaperBook paperBook){

            if (!(purchaseDTO instanceof PaperBookPurchaseDTO)) {
                throw new IllegalArgumentException("Invalid purchase info for paper book");
            }

            PaperBookPurchaseDTO dto = (PaperBookPurchaseDTO)purchaseDTO;
            paperBook.reduceStock(dto.getQuantity());
            double totalPrice = book.getPrice() * dto.getQuantity();
            ShippingService.deliver(dto);

            System.out.println("===== The total price is " + totalPrice+" =====");
        }
        else if (book instanceof EBook eBook) {
            if (!(purchaseDTO instanceof EBookPurchaseDTO)) {
                throw new IllegalArgumentException("Invalid purchase info for ebook");
            }

            EBookPurchaseDTO dto = (EBookPurchaseDTO)purchaseDTO;
            MailService.send(dto);

            System.out.println("===== The total price is " + eBook.getPrice() +" =====");
        }
        else{
            throw new IllegalArgumentException("This demo book is not for sale");
        }
    }
}

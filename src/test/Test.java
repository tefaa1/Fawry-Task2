package test;

import dto.EBookPurchaseDTO;
import dto.PaperBookPurchaseDTO;
import model.Book;
import model.DemoBook;
import model.EBook;
import model.PaperBook;
import service.BookService;

import java.util.List;

public class Test {
    public static void testAddBooks(BookService service) {
        System.out.println("\n=== Test 1 : testAddBooks ===");
        service.addBook(new PaperBook("1", "java", 2024, 120, 10));
        service.addBook(new EBook("2", "oop", 2023, 90, "pdf"));
        service.addBook(new DemoBook("3", "data structure", 2022, 0));
        System.out.println("Done successfully :)");
    }

    public static void testBuyPaperBook(BookService service) {
        System.out.println("\n=== Test 2 : testBuyPaperBook ===");
        service.buyBook(new PaperBookPurchaseDTO("1", 2, "Cairo"));
    }

    public static void testBuyEBook(BookService service) {
        System.out.println("\n=== Test 3 : testBuyEBook ===");
        service.buyBook(new EBookPurchaseDTO("2", "mh8369629@gmail.com"));
    }

    public static void testBuyNonExistentBook(BookService service) {
        System.out.println("\n=== Test 4 : testBuyNonExistentBook ===");
        try {
            service.buyBook(new PaperBookPurchaseDTO("50", 1, "Cairo"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testRemoveOutdatedBooks(BookService service) {
        System.out.println("\n=== Test 5 : testRemoveOutdatedBooks ===");
        service.addBook(new PaperBook("4", "old book", 2012, 60, 10));
        service.addBook(new PaperBook("5", "pyramids", 1300, 200, 9));
        service.addBook(new PaperBook("6", "very old book", 1500, 150, 5));
        List<Book> removed = service.removeOutDatedBooks(10);
        System.out.println(removed);
    }

    public static void testBuyDemoBook(BookService service) {
        System.out.println("\n=== Test 6 : testBuyDemoBook ===");
        try {
            service.buyBook(new PaperBookPurchaseDTO("3", 1, "Cairo"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testInvalidBookData() {
        System.out.println("\n=== Test 7 : testInvalidBookData ===");
        try {
            new PaperBook("", "No ISBN", 2020, 100, 5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            new PaperBook("2", "Invalid Year", 500, 100, 5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            new PaperBook("3", "Invalid Price", 2020, -5, 5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testDuplicateISBN(BookService service) {
        System.out.println("\n=== Test 8 : testDuplicateISBN ===");
        try {
            service.addBook(new PaperBook("1", "it is not me :)", 2021, 100, 5));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testEBookEmptyEmail(BookService service) {
        System.out.println("\n=== Test 9 : testEBookMissingEmail ===");
        try {
            service.buyBook(new EBookPurchaseDTO("2", " "));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testOrderQuantityMoreThanStock(BookService service) {
        System.out.println("\n=== Test 10 : testOrderQuantityMoreThanStock ===");
        try {
            service.buyBook(new PaperBookPurchaseDTO("1", 50, "Cairo"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

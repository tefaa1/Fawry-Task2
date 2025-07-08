import service.BookService;
import test.Test;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n===== Welcome to the Library ;) =====");

        BookService service = new BookService();

        Test.testAddBooks(service);
        Test.testBuyPaperBook(service);
        Test.testBuyEBook(service);
        Test.testBuyNonExistentBook(service);
        Test.testRemoveOutdatedBooks(service);
        Test.testBuyDemoBook(service);
        Test.testInvalidBookData();
        Test.testDuplicateISBN(service);
        Test.testEBookEmptyEmail(service);
        Test.testOrderQuantityMoreThanStock(service);
    }
}
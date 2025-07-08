package dto;

public class PaperBookPurchaseDTO implements PurchaseDTO{

    private String isbn;
    private int quantity;
    private String address;

    public PaperBookPurchaseDTO(String isbn, int quantity, String address) {
        this.isbn = isbn;
        this.quantity = quantity;
        this.address = address;
        validate();
    }
    @Override
    public void validate() {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN must not be empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address must not be empty for paper book");
        }
    }
    @Override
    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAddress() {
        return address;
    }
}

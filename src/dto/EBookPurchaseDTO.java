package dto;

public class EBookPurchaseDTO implements PurchaseDTO{
    private String isbn;
    private String email;

    public EBookPurchaseDTO(String isbn, String email) {
        this.isbn = isbn;
        this.email = email;
        validate();
    }

    @Override
    public void validate() {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN must not be empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be empty for eBook");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email is not valid");
        }
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    public String getEmail() {
        return email;
    }
}

package model;

public class EBook extends Book{
    private String fileType;

    public EBook(String isbn, String title, int publishedYear, double price, String fileType) {

        super(isbn, title, publishedYear, price);

        if (fileType == null || fileType.trim().isEmpty()) {
            throw new IllegalArgumentException("File type must not be empty");
        }
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}

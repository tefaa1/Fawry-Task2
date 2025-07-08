# Quantum Book Store

Quantum Book Store is a Java console-based project that simulates a basic online bookstore. It is structured to be modular and easily extensible.

## Book Types

The system supports three book types:
- **PaperBook**: Has stock and can be shipped.
- **EBook**: Has a file type and is delivered via email.
- **DemoBook**: Demo books not for sale.

## Features

- Add books to inventory (ISBN, title, year, price).
- Remove books that are outdated based on a given number of years.
- Buy a book using its ISBN and appropriate info:
  - PaperBook: needs quantity and address.
  - EBook: needs email.
- Designed for extensibility without changing existing classes.

## Structure

The system uses a layered structure with packages for:
- **model**: Book base class and its subclasses.
- **dto**: Data Transfer Objects for handling input data like `PurchaseDTO`, `PaperBookPurchaseDTO`, `EBookPurchaseDTO`.
- **service**: Business logic handled by `BookstoreService`.
- **Test**: Contains methods for testing different functionalities.

## Project Files

```
src/
├── model/
│   ├── Book.java
│   ├── PaperBook.java
│   ├── EBook.java
│   └── DemoBook.java
├── dto/
│   ├── PurchaseDTO.java
│   ├── PaperBookPurchaseDTO.java
│   └── EBookPurchaseDTO.java
├── service/
│   └── BookService.java
├── Test.java
└── Main.java
```

## Testing

The `Test` class provides separate methods for:
- Adding books
- Buying paper and eBooks
- Handling invalid data
- Removing outdated books
- Ensuring business rules (e.g., can't buy demo books, not enough stock)
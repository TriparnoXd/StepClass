class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class LibraryBookList {
    public static void printBooksByAuthor(Book[] books, String authorName) {
        System.out.println("Books by " + authorName + ":");
        for (Book book : books) {
            if (book.author.equals(authorName)) {
                System.out.println("- " + book.title);
            }
        }
    }

    public static void main(String[] args) {
        Book[] library = new Book[5];
        library[0] = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        library[1] = new Book("The Hobbit", "J.R.R. Tolkien");
        library[2] = new Book("Pride and Prejudice", "Jane Austen");
        library[3] = new Book("1984", "George Orwell");
        library[4] = new Book("Animal Farm", "George Orwell");

        printBooksByAuthor(library, "J.R.R. Tolkien");
        System.out.println();
        printBooksByAuthor(library, "George Orwell");
    }
}
class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean availability;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookID, boolean availability) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.availability = availability;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head;
    Book tail;

    // Add a book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookID, boolean availability) {
        Book newBook = new Book(title, author, genre, bookID, availability);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a book at the end
    public void addAtEnd(String title, String author, String genre, int bookID, boolean availability) {
        Book newBook = new Book(title, author, genre, bookID, availability);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Remove a book by Book ID
    public void removeByBookID(int bookID) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }
                System.out.println("Book with ID " + bookID + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    // Display all books in forward order
    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookID + ", Title: " + temp.title + ", Author: " + temp.author);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookID + ", Title: " + temp.title + ", Author: " + temp.author);
            temp = temp.prev;
        }
    }

    // Search for a book by Title or Author
    public void searchBook(String searchQuery) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(searchQuery) || temp.author.equalsIgnoreCase(searchQuery)) {
                System.out.println("Book found! ID: " + temp.bookID + ", Title: " + temp.title + ", Author: " + temp.author);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    // Update a book's availability status
    public void updateAvailability(int bookID, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.availability = newStatus;
                System.out.println("Book availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    // Count the total number of books
    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addAtBeginning("The thesis", "Pablo escobar", "Fiction", 101, true);
        library.addAtEnd("1984", "big pablo escobar", "unknown", 102, true);
        library.addAtEnd("book3", "small pablo escobar", "Fiction", 103, false);

        System.out.println("Books in forward order:");
        library.displayForward();

        System.out.println("Books in reverse order:");
        library.displayReverse();

        System.out.println("Search for '1984':");
        library.searchBook("1984");

        System.out.println("Update availability of Book ID 103:");
        library.updateAvailability(103, true);

        System.out.println("Total books: " + library.countBooks());

        System.out.println("Removing Book ID 101:");
        library.removeByBookID(101);

        System.out.println("Books in forward order after removal:");
        library.displayForward();
    }
}

package models;

public class Book {
    private String bookname;
    private String author;

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Book(String bookname, String author) {
        this.bookname = bookname;
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

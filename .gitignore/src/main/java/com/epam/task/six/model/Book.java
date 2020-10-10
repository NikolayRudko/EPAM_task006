package com.epam.task.six.model;

public class Book {
    private int id;
    private int year;
    private int pages;
    private String title;
    private String author;

    public Book(int id, int year, int pages, String title, String author) {
        this.id = id;
        this.year = year;
        this.pages = pages;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;
        return year == book.year &&
                id == book.id &&
                pages == book.pages &&
                (title == book.title || (title != null && title.equals(book.getTitle()))) &&
                (author == book.author || (author != null && author.equals(book.getAuthor())));

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + year;
        result = prime * result + pages;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s [id = %d, year = %d, pages = %d, title = '%s', author='%s']",
                Book.class.getSimpleName(), id, year, pages, title, author);
    }
}

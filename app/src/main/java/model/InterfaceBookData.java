package model;

import java.util.List;

public interface InterfaceBookData {
    List<Book> getBooks(String ctg);

    String [] getCategories();
}

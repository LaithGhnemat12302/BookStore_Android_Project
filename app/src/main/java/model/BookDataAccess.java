// This class to get data from Web Service or Local Database(Model)
package model;

import java.util.ArrayList;
import java.util.List;

 class BookDataAccess implements InterfaceBookData {    //implements the interface
    private ArrayList<Book> books = new ArrayList<>();  //private to ensure that no one can edit on books whether intentionally or unintentionally

     //__________________________________________________________ Constructor _______________________________________________________//
    public BookDataAccess() {   // add initial objects of Book to the ArrayList
       books.add( new Book(300, "Thinking in Java", "Java"));
       books.add( new Book(450, "Professional Java", "Java"));
       books.add(new Book(500, "Beginning C# Development", "C#"));
       books.add( new Book(420, "Programming With Python", "Python"));
       books.add(new Book(348, "C Development", "C"));
       books.add(new Book(280, "Programming With PHP", "PHP"));
       books.add(new Book(750, "Programming With JS", "JS"));
       books.add(new Book(630, "Professional JS", "JS"));
       books.add(new Book(240, "Programming With C#", "C#"));
       books.add(new Book(190, "Professional In PHP", "PHP"));
    }

     //__________________________________________________ Methods(Overrided for interface) _________________________________________________//
    public List<Book> getBooks(String ctg){
        ArrayList<Book> resultDataList = new ArrayList<>();

        for (Book b : books) {
            if (b.getCategory().equals(ctg))
                resultDataList.add(b);
        }

        return resultDataList;
    }

     @Override
     public String [] getCategories() {
        String [] categories = {"Java", "JS", "Python", "C#", "PHP", "C"};

        return categories;
     }
 }

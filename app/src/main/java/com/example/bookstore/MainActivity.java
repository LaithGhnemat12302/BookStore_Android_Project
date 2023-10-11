package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import model.Book;
//import model.BookDataAccess;
import model.BookFactory;
import model.InterfaceBookData;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText editTextShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);   //To catch the spinner using it's id
        populateSpinner();
        editTextShow = findViewById(R.id.editTextShow);
    }

    //_____________________________________________________ Add items to the spinner __________________________________________________//
    private void populateSpinner() {
        BookFactory factory = new BookFactory();
        InterfaceBookData objBook = factory.getModel();

        String [] categories = objBook.getCategories();

        // ArrayAdapter is a connection between spinner & arrayOfString to fill data at the running time
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        spinner.setAdapter(adapter);
    }

    //_____________________________________________________ Button Event __________________________________________________//
    public void btnGetBooksOnClick(View view) {
        // BookDataAccess objBook = new BookDataAccess();

        BookFactory factory = new BookFactory();
        InterfaceBookData objBook = factory.getModel();

        String item = spinner.getSelectedItem().toString();

        List<Book> books = objBook.getBooks(item); // Method getBooks returns a list of books with category Java

        String str = "";

        for(Book b : books){
            str += b.getTitle() + "\n";
        }

//        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

        editTextShow.setText(str);
    }
}
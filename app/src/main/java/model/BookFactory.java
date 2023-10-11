package model;

public class BookFactory {

    public InterfaceBookData getModel(){    //  لما أعرّف reference من نوع ال interface بقدر أمسك ال classes اللي بتعمل implement لهذا ال interface
        // if statement to check the internet connection
        return new BookDataAccess();
    }
}

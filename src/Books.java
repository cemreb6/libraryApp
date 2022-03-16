
import java.util.ArrayList;
import java.util.Collections;


public class Books implements Comparable<Books> {
    //I decleare all attrübutes of book as a class member of book.
    Integer bookID;
    String title;
    String category;
    String authorFullName;
    String awardWinner;
    Integer rating;
    Integer year;
    Integer pages;
    String description;

    public Books(Integer bookID,String title, String category, String authorFullName, String awardWinner, Integer rating, Integer year, Integer pages, String description) {
        this.bookID=bookID;
        this.title = title;
        this.category = category;
        this.authorFullName = authorFullName;
        this.awardWinner = awardWinner;
        this.rating = rating;
        this.year = year;
        this.pages = pages;
        this.description = description;
    }

    Books(){// In listbyratings class I use the following compareTo function,so I have to create an instance of book to use that function.In order to do that I make an empty constructor.
        
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book ID=" + bookID + "\nTitle=" + title + "\nCategory=" + category + "\nAuthor Full Name=" + authorFullName + "\nAward Winner=" + awardWinner + "\nRating=" + rating + "\nYear=" + year + "\nPages=" + pages + "\nDescription=" + description ;
    }

    @Override
    public int compareTo(Books o) {//This function compares the ratings of given books.
        if(getRating()==null ||o.getRating()==null){
            return 0;
        }
        return getRating().compareTo(o.rating);
    }

    public static ArrayList<Books> sortBooks(ArrayList<Books> books){//Sorts the given books ratings in ascending order
        Collections.sort(books);
        return books;
    }
   
}

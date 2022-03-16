
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FILEIO {
    ArrayList<Books> bookList;
    String filepath;
    
    public FILEIO() {
        this.bookList = new ArrayList<Books>();
        filepath="books.txt";
    }

    public ArrayList<Books> getBookList() {
        return bookList;
    }
    
    
     public ArrayList<Books> createBookList(){//read the txt file and convert them to book objects,finally add all books into a list.
       
       Scanner scanner=null;
        try{
            scanner=new Scanner(new FileInputStream(filepath));//try to find the file
        }
        catch (IOException ioException){
            ioException.printStackTrace();
            return null;
        }
        int idCounter=0;
        while(scanner.hasNextLine()){
            idCounter++;
            String line=scanner.nextLine();
            String[] fields=line.split(",");

            if(fields.length==8){// we should check if there is 8 fields if not it may missing parts of books or there are too many things which we do not want to.
                                             //String title, String category, String authorFullName, String awardWinner, int rating, int year, int pages, String description
                Books book =new Books(idCounter,fields[0],fields[1],fields[2],fields[3],Integer.parseInt(fields[4]),Integer.parseInt(fields[5]),Integer.parseInt(fields[6]),fields[7]);
               bookList.add(book);
            }
            
        }
        
        return bookList;
    }
     
     public void addBook(Books newBook) throws IOException{//adds a book in txt file.
         String bookStr=convertBookToString(newBook)+"\n";//convert book to string which we will write to txt file ,also add the commas.
         File BookFile=new File("books.txt");
         if(!BookFile.exists()){
             BookFile.createNewFile();
         }
         FileWriter fileWriter=new FileWriter(BookFile,true);//this true value provide us to write new book to next line without delete old books.Otherwise ,when it is false,it deletes all elements and add just the given value.
         BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
         bufferedWriter.write(bookStr);
         bufferedWriter.close();
     }
     
     public void deleteBook(ArrayList<Books>bookList) throws IOException{//deletes a book from the txt file.
         //In order to do deletion operation, firstly,I delete it from bookList in deletebook class.Then I send the bookList in this function.
         //This function writes the bookList elements into the txt file from the beginning.Before it writes to txt,it deletes the old content of txt.
         //We will do that operation in the 75th line which "FileWriter fileWriter=new FileWriter(BookFile,false);" where this boolean false value provide us to write the new content without care about the old content,because it deletes them.
         String books="";
         for(int i=0;i<bookList.size();i++){
             books+=convertBookToString(bookList.get(i))+"\n";
         }
         File BookFile=new File("books.txt");
         if(!BookFile.exists()){
             BookFile.createNewFile();
         }
         FileWriter fileWriter=new FileWriter(BookFile,false);
         BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
         bufferedWriter.write(books);
         bufferedWriter.close();
     }
     public String convertBookToString(Books newBook){//converts the book object into string form which we add it to txt file. 
         return newBook.title+","+newBook.category+","+newBook.authorFullName+","+newBook.awardWinner+","+newBook.rating+","+newBook.year+","+newBook.pages+","+newBook.description;
     }
     
}

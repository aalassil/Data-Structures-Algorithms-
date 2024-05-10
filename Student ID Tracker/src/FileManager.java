import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileManager {

    private Scanner sc;
    private int counter;
    String path;
    public FileManager(String path) {
        this.path = path;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("File not found or corrupted");
        }
    }


    public  LinkyListy FileReader(int size){
        System.out.println("creating the list");
        LinkyListy l = new LinkyListy();
         counter = 0;

//        while(sc.hasNextLine()){
            for(int i =0;i< size;i++){
                if(!sc.hasNextLine()){
                    return l;
                }
                else {
                    String studentIdString = sc.nextLine();

                    //*********parsing the string here will delete the zero on the left of the id be careful if that creates an issue***********
                    long studentId = 0;
                    try {
                        studentId = Long.parseLong(studentIdString); //--> this might throw number NumberFormatException be carefull
                    } catch (NumberFormatException n) {
                        System.out.println("exception on line " + counter);
                    }

                    l.add((int) studentId);
                    counter++;
                }
        }
        System.out.println("total IDs read = " + counter);
        sc.close(); //*************************** be careful scanner is closed here
        return l;
    }

    public int getSize(){
        return counter;
    }

}

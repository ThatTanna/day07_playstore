import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Playstore {
    public static void main(String[] args) {

        String filePath = "src/googleplaystore.csv";
        ReadFile(filePath);

        String name = line[0];
        String cat = [1];
        double rating = [2];



    }

    public static void ReadFile(String fname) {

        File fobj = Paths.get(fname).toFile();
        try {
            FileReader fr = new FileReader(fname);
            BufferedReader bfr = new BufferedReader(fr);
            String line;
            List<String> arrayList = new LinkedList<>();

            while ((line = bfr.readLine()) != null) {
                arrayList.add(line);
            }

            System.out.println(arrayList);

            bfr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void Map(List<String> ArrayList) {

        List<String> resultList = new LinkedList<>();
        for (String n : ArrayList) {
            resultList.add(n[]);
        }
    }

    // public static void map(List<String> arrayList) {
    //     System.out.println("===== MAP =====");
    //     List<String> resultList = new LinkedList<>();
    //     for (String n : arrayList) {
    //         resultList.add(null)
    //     }
    // }
}
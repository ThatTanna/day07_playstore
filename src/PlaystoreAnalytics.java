import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlaystoreAnalytics {
    public static final void main(String[] args) throws Exception{

        Reader r = new FileReader("src/googleplaystore.csv");
        BufferedReader br = new BufferedReader(r);

        List<App> apps = br.lines()
            // Skip the header line
            .skip(1)
            // String -> String
            .map(l -> l.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))
            // .filter(cols -> cols.length <= 14)
            .filter(cols -> !cols[2].trim().toLowerCase().equals("nan"))
            // String [] -> App
            .map(cols -> {
                App app = new App();
                app.setName(cols[0]);
                app.setCategory(cols[1]);
                app.setRating(Float.parseFloat(cols[2]));
                return app;
            }).toList();
            
        Map<String, List<App>> groupByCategory = apps.stream()
            .collect(
                Collectors.groupingBy(app -> app.getCategory())
            );

        for (String c: groupByCategory.keySet()) {
            List<App> listOfApps = groupByCategory.get(c);
            System.out.printf("Categories: %s - %d\n"
                , c, listOfApps.size());
        }
        
    }
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        for (int i = 0; i < 5; i++) {
            List<Actor> visitors = generateRandomActors(10);
            Market market = new Market(visitors);
            market.update();
        }
    }
    public static String randomName() throws FileNotFoundException {
        String path = "seminars/seminar2/src/names.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> names = new ArrayList<>();
        try{
            String line;
            while((line = br.readLine()) != null){
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names.get(new Random().nextInt(names.size()));
    }

    public static List<Actor> generateRandomActors(int actorsCount) throws FileNotFoundException {
        List<Actor> actorList = new ArrayList<>();
        for (int i = 0; i < actorsCount; i++) {
            actorList.add(new Human(randomName()));
        }
        return actorList;
    }
}

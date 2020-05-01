import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, InterruptedException, IOException {
        UIManager ui = new UIManager();
        Path path = ui.getPath();
        ArrayList<String> keyLabels= new ArrayList<>();
        String startingTag;

        startingTag = ui.getAsString("Podaj tag oddzielający artykuły (np. dla reuters jest to 'REUTERS'):");
        keyLabels = ui.getAsStringArrayList("Podaj etykiety oddzielone spacją:");
        String labelTag = ui.getAsString("Podaj tag etykiety:");

        DataManager dataManager = new DataManager(path, keyLabels, labelTag, startingTag);
        System.exit(0);
    }
}

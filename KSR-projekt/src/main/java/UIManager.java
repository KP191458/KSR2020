import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class UIManager {

    public Path getPath() throws InvocationTargetException, InterruptedException {
        final Path[] path = new Path[1];
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }

        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                Window w =new Window("dir");
                path[0] = w.getPath();
            }
        });
        return path[0];
    }

    public String getAsString(String label){
        System.out.println(label);
        Scanner scanner = new Scanner(System. in).useDelimiter("\\n");
        String s = scanner.next();
        return s;
    }

    public ArrayList<String> getAsStringArrayList(String label){
        System.out.println(label);
        Scanner scanner2 = new Scanner(System. in).useDelimiter("\\n");
        String[] keyLabelsTmp = scanner2.nextLine().split(" ");
        ArrayList<String> stringList = new ArrayList<>();
        for(String s: keyLabelsTmp){
            stringList.add(s);
        }
        return stringList;
    }
}

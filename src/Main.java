import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static String createFolder(String url) {
        String folder = "";
        File file = new File(url);
        if (file.exists()) folder = file.getName();
        else if (file.mkdirs()) {
            folder = file.getName();
        }
        return folder;
    }

    public static String createFile(List<String> list) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (String fileName : list) {
            File cFile = new File(fileName);
            if (cFile.exists()) builder.append(cFile.getName()).append(",");
            else if (cFile.createNewFile()) {
                builder.append(cFile.getName()).append(",");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String url = "/Users/mustafatumgoev/Games";

        StringBuilder builder = new StringBuilder();
        builder.append(createFolder(url)).append(",");
        builder.append(createFolder(url + "/src")).append(",");
        builder.append(createFolder(url + "/src/res")).append(",");
        builder.append(createFolder(url + "/src/res/savegame")).append(",");
        builder.append(createFolder(url + "/src/res/savegame/temp")).append(",");
        builder.append(createFolder(url + "/src/main")).append(",");
        builder.append(createFolder(url + "/src/test")).append(",");

        builder.append(createFolder(url + "/src/res/drawables")).append(",");
        builder.append(createFolder(url + "/src/res/vectors")).append(",");
        builder.append(createFolder(url + "/src/res/icons")).append(",");

        List<String> list = Arrays.asList(
                url + "/src/main/Main.java",
                url + "/src/main/Utils.java",
                url + "/src/res/savegame/temp/temp.txt");
        try {
            builder.append(createFile(list)).append(",");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileWriter writer = new FileWriter(url + "/src/res/savegame/temp/temp.txt")) {
            writer.write(builder.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(builder.toString());
    }
}
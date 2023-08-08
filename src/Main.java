import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        File directory = new File("/Users/mustafatumgoev/Games");
        if (directory.exists()) builder.append(directory.getName()).append(",");
        else if (directory.mkdirs()) builder.append(directory.getName()).append(",");

        File srcFolder = new File(directory, "src/res/savegame/temp");
        if (srcFolder.exists()) builder.append("src,res,savegame,").append(srcFolder.getName()).append(",");
        else if (srcFolder.mkdirs()) builder.append("src,res,savegame,").append(srcFolder.getName()).append(",");

        File mainFolder = new File(directory, "src/main");
        if (mainFolder.exists()) builder.append(mainFolder.getName()).append(",");
        else if (mainFolder.mkdirs()) builder.append(mainFolder.getName()).append(",");

        File testFolder = new File(directory, "src/test");
        if (testFolder.exists()) builder.append(testFolder.getName()).append(",");
        else if (testFolder.mkdirs()) builder.append(testFolder.getName()).append(",");
        try {
            File file = new File(mainFolder, "Main.java");
            if (file.exists()) builder.append(file.getName()).append(",");
            else if (file.createNewFile()) builder.append(file.getName()).append(",");

            File fileTwo = new File(mainFolder, "Utils.java");
            if (fileTwo.exists()) builder.append(fileTwo.getName()).append(",");
            else if (fileTwo.createNewFile()) builder.append(fileTwo.getName()).append(",");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File drawablesFolder = new File(directory, "src/res/drawables");
        if (drawablesFolder.exists()) builder.append(drawablesFolder.getName()).append(",");
        else if (drawablesFolder.mkdirs()) builder.append(drawablesFolder.getName()).append(",");

        File vectorsFolder = new File(directory, "src/res/vectors");
        if (vectorsFolder.exists()) builder.append(testFolder.getName()).append(",");
        else if (vectorsFolder.mkdirs()) builder.append(vectorsFolder.getName()).append(",");

        File iconsFolder = new File(directory, "src/res/icons");
        if (iconsFolder.exists()) builder.append(iconsFolder.getName()).append(",");
        else if (iconsFolder.mkdirs()) builder.append(iconsFolder.getName()).append(",");

        File tempFile = new File(srcFolder, "temp.txt");
        try {
            if (tempFile.exists()) builder.append(tempFile.getName()).append(",");
            else if (tempFile.createNewFile()) builder.append(tempFile.getName()).append(",");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileWriter writer = new FileWriter(tempFile)) {
           writer.write(builder.toString());
           writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
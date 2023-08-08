import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 131343944855L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
    public static void saveGame(String url, GameProgress progress) {
        try(FileOutputStream file = new FileOutputStream(url);
            ObjectOutputStream object = new ObjectOutputStream(file)) {
            object.writeObject(progress);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void zipFiles(String zipFile, List<String> zip) {
        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            for (String filePath : zip) {
                File file = new File(filePath);
                FileInputStream fis = new FileInputStream(file);

                ZipEntry zipEntry = new ZipEntry(file.getName());
                zos.putNextEntry(zipEntry);

                byte[] buffer = new byte[fis.available()];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
                zos.closeEntry();
                fis.close();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public static void deleteFiles(List<String> filesToDelete) {
        for (String filePath : filesToDelete) {
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
        }
    }

}


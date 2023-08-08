import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameRunner {
    public static void main(String[] args) {
        GameProgress game1 = new GameProgress(100, 3, 10, 250.5);
        GameProgress game2 = new GameProgress(80, 5, 15, 500.2);
        GameProgress game3 = new GameProgress(50, 2, 5, 100.0);
        try {
            File path = new File("/Users/mustafatumgoev/Games/GunRunner/savegames");
            path.mkdirs();
            File zip = new File(path, "save1.dat/save2.dat/save3.dat");
            zip.createNewFile();
        } catch (IOException e) {
            e.getMessage();
        }

        GameProgress.saveGame("/Users/mustafatumgoev/Games/GunRunner/savegames/save1.dat", game1);
        GameProgress.saveGame("/Users/mustafatumgoev/Games/GunRunner/savegames/save2.dat", game2);
        GameProgress.saveGame("/Users/mustafatumgoev/Games/GunRunner/savegames/save3.dat", game3);

        List<String> filesToZip = Arrays.asList(
                "/Users/mustafatumgoev/Games/GunRunner/savegames/save1.dat",
                "/Users/mustafatumgoev/Games/GunRunner/savegames/savegames/save2.dat",
                "/Users/mustafatumgoev/Games/GunRunner/savegames//save3.dat");
        GameProgress.zipFiles("/Users/mustafatumgoev/Games/GunRunner/savegames//zip.zip", filesToZip);

        List<String> filesToDelete = Arrays.asList(
                "/Users/mustafatumgoev/Games/GunRunner/savegames/save1.dat",
                "/Users/mustafatumgoev/Games/GunRunner/savegames/save2.dat",
                "/Users/mustafatumgoev/Games/GunRunner/savegames/save3.dat");
        GameProgress.deleteFiles(filesToDelete);

    }

}


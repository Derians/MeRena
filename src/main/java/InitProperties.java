import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class InitProperties {

    private final static String configDir = "./config";
    private final static Path labelsFilePath = FileSystems.getDefault().getPath(configDir, "labels.txt");
    private final static Path configFilePath = FileSystems.getDefault().getPath(configDir, "config.properties");

    public static void initProperties() {

        try {
            if (Files.notExists(labelsFilePath)) {
                Files.createDirectories(labelsFilePath.getParent());
                Files.copy(Paths.get(Main.class.getResource("labels.txt").toURI()), labelsFilePath);
            }

            if (Files.notExists(configFilePath)) {
                Files.copy(Paths.get(Main.class.getResource("config.properties").toURI()), configFilePath);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    static Properties getConfig() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(configFilePath.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    static List<String> getLabels() {
        List<String> labels = new ArrayList<>();
        try {
            labels = Files.readAllLines(labelsFilePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return labels;
    }
}

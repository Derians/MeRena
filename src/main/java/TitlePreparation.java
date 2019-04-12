import org.apache.commons.io.FilenameUtils;

import java.util.List;

public class TitlePreparation {

    public String getPreparedTitle(String souceTitle) {

        //Получаем имя файла
        souceTitle = FilenameUtils.getBaseName(souceTitle);
        //Удаляем пробелы, точки и нижние подчёркивания
        souceTitle = cleanLabels(souceTitle);
        //Отсекаем метки
        souceTitle = cutLabels(souceTitle);

        return souceTitle;
    }

    private String cleanLabels(String souceTitle) {

        souceTitle = souceTitle
                .trim()
                .replaceAll("\\.", " ")
                .replaceAll("_", " ")
                .replaceAll("[\\s]{2,}", " ");

        return souceTitle;
    }

    private String cutLabels(String souceTitle) {
        List<String> labels = InitProperties.getLabels();

        for (String label : labels) {
            souceTitle = souceTitle.split("(?i)" + label)[0];
        }
        return souceTitle;
    }

}

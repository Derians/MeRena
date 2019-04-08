import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;

/**
 * Created by Ivan Chaykin
 * Date: 03.04.2019
 * Time: 13:50
 */
public class Main {

    public static void main(String[] args) {

//        String souceTitle = "  Tihookeanskij.rubezh.2013.RUS..BDRip.XviD.AC3.-HQCLUB.avi";
//        String souceTitle = "D:\\Kopu.v.yibkah.2013.D.TS.1400MB.avi";
        String souceTitle = "D:\\Alita.Battle.Angel.2019.P.WEBRip.14OOMB.avi";

        String result = FilenameUtils.getBaseName(souceTitle);

        // Заменяем все точки на пробелы и удаляем лишние пробелы
        result = result.trim().replaceAll("\\.", " ").replaceAll("[\\s]{2,}", " ");

        System.out.println(result);

        Requests requests = new Requests();
        String request = requests.get(result, "2012");
        ObjectMapper mapper = new ObjectMapper();

        try {
            SearchResult searchResult = mapper.readValue(request, SearchResult.class);

            System.out.println(searchResult.totalResults);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Ivan Chaykin
 * Date: 03.04.2019
 * Time: 13:50
 */
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

Requests requests = new Requests();

        Map<String, Object> parameters = new LinkedHashMap<>();
        TitlePreparation titlePreparation = new TitlePreparation();


        String[] titles = {
                "  Tihookeanskij.rubezh.2013.RUS..BDRip.XviD.AC3.-HQCLUB.avi",
                "D:\\Kopu.v.yibkah.2013.D.TS.1400MB.avi",
                "D:\\Alita.Battle.Angel.2019.P.WEBRip.14OOMB.avi",
                "D:\\How.to.Train.Your.Dragon.The.Hidden.World.2019.BDRip.1080p.seleZen.mkv",
                "D:\\The.Veil.2017.Pof.HDRip.7OOMB.avi",
                "D:\\Where_Birds_Dont_Fly__2017.P.WEb_DL.72Op.mkv",
                "D:\\Ballon.2018.BDRip.1.46Gb.MVO.MegaPeer.avi",
                "D:\\Lazzaro.felice.2018.BDRip.2.18Gb.P.MegaPeer.avi",
                "D:\\Division.19.2017.P.WEB-DLRip.14OOMB.avi",
                "Blade.Runner.1982.Final.Cut.1080p.BluRay.by.zzZGVvv.mkv",
                "Blade.Runner.2049.2017.BDRip.1.46Gb.Dub.MegaPeer.avi"
        };

//        for (String title : titles) {
//            System.out.println(titlePreparation.getPreparedTitle(title));
//        }

        parameters.put("language", "ru-RU");
        parameters.put("page", 1);
        parameters.put("include_adult", true);
        parameters.put("query", "Blade Runner 2049");

        System.out.println(requests.request("search/movie", parameters));


    }
}

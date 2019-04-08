package movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Ivan Chaykin
 * Date: 08.04.2019
 * Time: 12:06
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpokenLanguage {

    @JsonProperty("iso_639_1")
    public String iso6391;
    @JsonProperty("name")
    public String name;

}

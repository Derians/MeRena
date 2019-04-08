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
public class ProductionCompany {

    @JsonProperty("id")
    public Long id;
    @JsonProperty("logo_path")
    public String logoPath;
    @JsonProperty("name")
    public String name;
    @JsonProperty("origin_country")
    public String originCountry;

}

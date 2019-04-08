import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by Ivan Chaykin
 * Date: 08.04.2019
 * Time: 12:49
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult<T> {

    @JsonProperty("page")
    public Long page;

    @JsonProperty("total_results")
    public Long totalResults;

    @JsonProperty("total_pages")
    public Long totalPages;

    @JsonProperty("results")
    public List<T> results = null;

}

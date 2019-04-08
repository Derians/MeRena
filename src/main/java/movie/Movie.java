package movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by Ivan Chaykin
 * Date: 08.04.2019
 * Time: 12:06
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @JsonProperty("adult")
    public Boolean adult;
    @JsonProperty("backdrop_path")
    public String backdropPath;
    @JsonProperty("belongs_to_collection")
    public Object belongsToCollection;
    @JsonProperty("budget")
    public Long budget;
    @JsonProperty("genres")
    public List<Genre> genres = null;
    @JsonProperty("homepage")
    public String homepage;
    @JsonProperty("id")
    public Long id;
    @JsonProperty("imdb_id")
    public String imdbId;
    @JsonProperty("original_language")
    public String originalLanguage;
    @JsonProperty("original_title")
    public String originalTitle;
    @JsonProperty("overview")
    public String overview;
    @JsonProperty("popularity")
    public Double popularity;
    @JsonProperty("poster_path")
    public String posterPath;
    @JsonProperty("production_companies")
    public List<ProductionCompany> productionCompanies = null;
    @JsonProperty("production_countries")
    public List<ProductionCountry> productionCountries = null;
    @JsonProperty("release_date")
    public String releaseDate;
    @JsonProperty("revenue")
    public Long revenue;
    @JsonProperty("runtime")
    public Long runtime;
    @JsonProperty("spoken_languages")
    public List<SpokenLanguage> spokenLanguages = null;
    @JsonProperty("status")
    public String status;
    @JsonProperty("tagline")
    public String tagline;
    @JsonProperty("title")
    public String title;
    @JsonProperty("video")
    public Boolean video;
    @JsonProperty("vote_average")
    public Double voteAverage;
    @JsonProperty("vote_count")
    public Long voteCount;


}

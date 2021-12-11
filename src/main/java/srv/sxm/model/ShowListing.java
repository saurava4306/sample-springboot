package srv.sxm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ShowListing {
    protected List<ShowDescription> shows;
    private int episodeCount;
    private int newEpisodeCount;
    private List<EpisodeList> episodes;

}

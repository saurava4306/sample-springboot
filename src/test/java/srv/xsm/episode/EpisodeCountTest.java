package srv.xsm.episode;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import srv.sxm.configuration.ApplicationConfiguration;


@ContextConfiguration(classes = ApplicationConfiguration.class)
@RunWith(SpringRunner.class)
//@SpringBootTest
public class EpisodeCountTest {

    private static final Logger LOG = LoggerFactory.getLogger(EpisodeCountTest.class);

    @Autowired
    private RestTemplate restTemplate;


    @Ignore
    @Test
    public void testEpisodeCountMismatch(){
        ResponseEntity<String> entity = restTemplate.getForEntity("https://player-devintever3.mountain.siriusxm.com/rest/v2/experience/modules/get/discover-aod?type=2&result-template=tablet&count=10000&request-option=discover-aod-shows&genre=pop&lineup=200&maxEpisodeCt=100&page=1&category=music", String.class);

        LOG.info("Entity body: {}", entity.getBody());
        Assert.assertNotNull(entity);

    }

}

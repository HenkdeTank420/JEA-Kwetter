package services;

import dao.JPA.Interface.ITrendDao;
import domain.Trend;
import org.eclipse.persistence.annotations.TenantTableDiscriminator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TrendServiceTest {

    private Trend trend;
    private TrendService trendService;

    @Mock
    private ITrendDao trendDao;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        trendService = new TrendService(trendDao);
    }

    @Test
    public void createTrend_GivenTrend_TrendCreated(){
        //trendService.create();
    }

    @Test
    public void removeTrend_GivenTrend_TrendRemoved(){
        //trendService.remove();
    }

    @Test
    public void getTrend_TrendName_TrendFound(){
        //trendService.getTrendByName();
    }

    @Test
    public void getAllTrends_None_AllTrendsFound(){
        //trendService.getAllTrends();
    }

    @Test
    public void getAllMessagesWithTrend_TrendID_MessageListFound(){
        //trendService.getAllMessagesOfTrend();
    }
}

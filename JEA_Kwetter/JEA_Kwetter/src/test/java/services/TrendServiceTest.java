package services;

import dao.JPA.Interface.ITrendDao;
import domain.Trend;
import org.junit.Before;
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
}

package services;

import dao.JPA.Interface.ITrendDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Trend;

import javax.inject.Inject;
import java.util.ArrayList;

public class TrendService {

    @Inject
    @JPAKwetter
    private ITrendDao trendDao;

    public TrendService(){

    }

    public Trend create(Trend trend){return this.trendDao.add(trend);}

    public void remove(Trend trend){this.trendDao.delete(trend);}

    public ArrayList<Trend> getAllTrends(){return this.getAllTrends();}

    public Trend getTrendByName(String trend){return this.trendDao.findByName(trend);}
}

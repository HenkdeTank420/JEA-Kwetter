package services;

import dao.JPA.Implementation.TrendDao;
import dao.JPA.Interface.ITrendDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Trend;

import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class TrendService {

    @Inject
    @JPAKwetter
    private ITrendDao trendDao;

    public TrendService(){

    }

    public TrendService(ITrendDao trendDao){
        this.trendDao = trendDao;
    }

    public Trend create(Trend trend){return this.trendDao.add(trend);}

    public void remove(Trend trend){this.trendDao.delete(trend);}

    public ArrayList<Trend> getAllTrends(){return this.trendDao.getAllObjects();}

    public Trend getTrendByName(String trend){return this.trendDao.findByName(trend);}

    public List<JsonObject> convertAllToJson(List<Trend> trends) {
        List<JsonObject> convertedObjects = new ArrayList<>();
        for (Trend trend : trends) {
            convertedObjects.add(trend.convertToJson());
        }
        return convertedObjects;
    }
}

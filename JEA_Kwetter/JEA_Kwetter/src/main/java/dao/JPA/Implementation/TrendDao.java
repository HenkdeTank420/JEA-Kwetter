package dao.JPA.Implementation;

import dao.JPA.Interface.ITrendDao;
import domain.Trend;

public class TrendDao extends GenericDao<Trend> implements ITrendDao {

    public Trend findByName(String trendName) {
        return null;
    }
}

package dao.JPA.Implementation;

import dao.JPA.Interface.ITrendDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Trend;

import javax.ejb.Stateless;

@Stateless
@JPAKwetter
public class TrendDao extends GenericDao<Trend> implements ITrendDao {

    public Trend findByName(String trendName) {
        return null;
    }
}

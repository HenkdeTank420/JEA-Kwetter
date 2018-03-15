package dao.JPA.Implementation;

import dao.JPA.Interface.ITrendDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Trend;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@JPAKwetter
public class TrendDao extends GenericDao<Trend> implements ITrendDao {

    public Trend findByName(String trendName) {
        TypedQuery<Trend> query = em.createNamedQuery("trend.findByname", Trend.class);
        query.setParameter("trendName", trendName);
        List<Trend> result = query.getResultList();
        return result.get(0);
    }
}

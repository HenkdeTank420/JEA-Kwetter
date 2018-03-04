package dao.JPA.Interface;

import domain.Trend;

public interface ITrendDao extends IGenericDao<Trend> {

    Trend findByName(String trendName);
}

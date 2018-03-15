package dao.JPA.Interface;

import domain.Trend;

import java.util.ArrayList;

public interface ITrendDao extends IGenericDao<Trend> {

    Trend findByName(String trendName);

    ArrayList<Trend> getAllObjects();
}

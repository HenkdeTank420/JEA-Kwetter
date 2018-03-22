package dao.JPA.Interface;

import domain.Trend;

import java.util.ArrayList;
import java.util.List;

public interface ITrendDao extends IGenericDao<Trend> {

    Trend findByName(String trendName);

    ArrayList<Trend> getAllObjects();

    List<Trend> getAllMessagesOfTrend(String trendName);
}

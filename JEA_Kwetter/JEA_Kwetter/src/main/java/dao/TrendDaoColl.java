package dao;

import domain.Trend;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrendDaoColl {

    CopyOnWriteArrayList<Trend> trends = new CopyOnWriteArrayList<>();

    public void addTrend(Trend trend){
        trends.add(trend);
    }

    public void removeTrend(Trend trend){
        trends.remove(trend);
    }

    public ArrayList<Trend> getAllTrends(){
        return new ArrayList<>(trends);
    }

    public Trend findByName (String name){
        for(Trend trend : trends){
            if(trend.getName().contentEquals(name)){
                return trend;
            }
        }
        return null;
    }
}

package dao;

import domain.Account;
import domain.Heart;
import domain.Message;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class HeartDaoColl {

    CopyOnWriteArrayList<Heart> hearts = new CopyOnWriteArrayList<>();

    public void addHeart(Heart heart){
        hearts.add(heart);
    }

    public void removeHeart(Heart heart){
        hearts.remove(heart);
    }

    public ArrayList<Heart> getAllHeartsOfMessage(Message message){
        ArrayList<Heart> heartsOfMessage = new ArrayList<>();

        for(Heart heart : hearts){
            if(heart.getLiked().equals(message)){
                heartsOfMessage.add(heart);
            }
        }

        return heartsOfMessage;
    }

    public ArrayList<Account> getAllHeartedAccountsOfMessage(Message message){
        ArrayList<Account> accounts = new ArrayList<>();

        for(Heart heart : hearts){
            if(heart.getLiked().equals(message)){
                accounts.add(heart.getLiker());
            }
        }
        return accounts;
    }
}

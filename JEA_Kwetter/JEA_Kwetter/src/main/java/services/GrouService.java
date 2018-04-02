package services;

import dao.JPA.Interface.IGroupDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Group;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GrouService {

    @Inject
    @JPAKwetter
    private IGroupDao groupDao;

    public GrouService(){

    }
    public Group create(Group group){ return this.groupDao.add(group);}
}

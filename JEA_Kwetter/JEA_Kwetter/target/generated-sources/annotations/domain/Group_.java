package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-05T12:50:05")
@StaticMetamodel(UserGroup.class)
public class Group_ { 

    public static volatile SingularAttribute<UserGroup, String> groupName;
    public static volatile ListAttribute<UserGroup, User> users;

}
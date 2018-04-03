package web;

import domain.User;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionBean implements Serializable{

    private User loggedInUser;

    public void logout() {
        loggedInUser = null;

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/JEA_Kwetter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}

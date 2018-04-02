package web;

import domain.User;
import services.UserService;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named("loginBean")
@ViewScoped
public class LoginBean implements Serializable {
    @Inject
    private UserService userService;
    @Inject
    private SessionBean sessionBean;

    private String username;
    private String password;


    public void login() {
        String username = this.username.toLowerCase();

        if (sessionBean.getLoggedInUser() == null) {
            User user = this.userService.login(username, this.password);
            if (user != null) {
                sessionBean.setLoggedInUser(user);
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/JEA_Kwetter/profile.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



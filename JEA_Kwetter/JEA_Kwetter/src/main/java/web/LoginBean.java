package web;

import domain.User;
import services.UserService;
import utils.RedirectHelper;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
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

    public void init() {
    }

    public void login() {
        String username = this.username.toLowerCase();

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.login(username, this.password);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        User user = this.userService.findByName(request.getRemoteUser());
        sessionBean.setLoggedInUser(user);

        boolean isRegular = request.isUserInRole("regulars");

        if (isRegular) {
            RedirectHelper.redirect("/profile.xhtml");
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



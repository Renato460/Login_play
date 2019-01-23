package controllers;

import Model.LoginModel;
import Model.UserModel;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;
import javax.inject.Inject;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     *
     */

    private Form<LoginModel> userLogin;
    private Form<UserModel> existentUser;
    private LoginModel loginUser;
    private UserModel userMod;

    @Inject
    private FormFactory formFactory;
    /*@Inject
    public HomeController() {
        this.userLogin = formFactory.form(LoginModel.class);
    }*/

    public Result index() {
        this.userLogin = formFactory.form(LoginModel.class);
        return ok(index.render(userLogin));
    }


    public Result user() {
        Form<LoginModel> userLogin = formFactory.form(LoginModel.class).bindFromRequest();
        this.loginUser =  userLogin.get();
        String password = loginUser.getPassword();
        String name = loginUser.getName();
        this.userMod = UserModel.match(password, name);
        if (userMod != null){
            session(loginUser.getName());
            return redirect(controllers.routes.HomeController.inside(name));
            //return ok(user.render(existentUser, userMod.getName(), userMod.getApellidos(),
            //userMod.getPass(),userMod.getMail(), userMod.getDireccion(), userMod.getFono()));
        }else {
            return redirect(controllers.routes.HomeController.index());
        }
    }

    public Result datos (){
        this.existentUser =formFactory.form(UserModel.class);
        this.userMod = UserModel.match(loginUser.getPassword(), loginUser.getName());
        return ok(user.render(existentUser, userMod));
    }

    public Result inside(String name){
       return ok(inside.render(name));
    }

    public Result update(){
        UserModel user = formFactory.form(UserModel.class).bindFromRequest().get();
        UserModel upUsuario = UserModel.find.byId(user.getPass());
        upUsuario = user;
        upUsuario.update();
        return ok(inside.render(user.getName()));
    }

    public Result register(){
        Form<UserModel> newUser = formFactory.form(UserModel.class);
        return ok(register.render(newUser));
    }

    public Result registerform (){
        UserModel newUser = formFactory.form(UserModel.class).bindFromRequest().get();
        newUser.save();
        this.userLogin = formFactory.form(LoginModel.class);
        return ok(index.render(userLogin));
    }

    public Result logout (){
        /*def logout = Action {
            Redirect(routes.Application.login).withNewSession.flashing(
                    "success" -> "You've been logged out"
  )
        }*/
        session().remove(this.userMod.getName());
        return redirect(routes.HomeController.index());
    }

    public Result upload(){
        return TODO;
    }
}

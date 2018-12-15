package controllers;

import Model.Aranceles;
import Model.LoginModel;
import Model.UserModel;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;
import javax.inject.Inject;
import java.util.List;


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
        LoginModel loginUser =  userLogin.get();
        String password = loginUser.getPassword();
        String name = loginUser.getName();
        UserModel userMod = UserModel.match(password, name);
        if (userMod != null){
            this.existentUser =formFactory.form(UserModel.class);
            session(loginUser.getName());
            return redirect(controllers.routes.HomeController.inside());
            //return ok(user.render(existentUser, userMod.getNombre(), userMod.getApellidos(),
            //userMod.getPass(),userMod.getMail(), userMod.getDireccion(), userMod.getFono()));
        }else {
            return redirect(controllers.routes.HomeController.index());
        }
    }

    public Result inside(){
        List<Aranceles> aranceles = Aranceles.matchAll();
        Integer a =0;
        return ok(inside.render(aranceles, a));
    }

    public Result update(){

        return TODO;
    }

    public Result register(){
        return ok(register.render());
    }
}

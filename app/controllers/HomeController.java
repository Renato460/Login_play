package controllers;

import Model.LoginModel;
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

    private final Form<LoginModel> userLogin;

    @Inject
    public HomeController(FormFactory formFactory) {
        this.userLogin = formFactory.form(LoginModel.class);
    }


    public Result index() {

        //ArrayList<String> data = new ArrayList<>();
        return ok(index.render(userLogin));
    }

    public Result user() {
        //Form<UserModel> userForm = formFactory.form(UserModel.class);
        return TODO;
    }
}

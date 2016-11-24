import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

import model.User;
import model.Seller;


/**
 *
 * Simple (JUnit) tests that can call all parts of a play app.
 *
 */
public class ApplicationTest {

    @Test
    public void createUserNotNullCheck() {
        assertNotNull("should not be null", new User("email","userName","firstname","lastname","mdpHash","1234567890","address","35000","city",0));
    }
    
    @Test
    public void createSellerCheck() {
        assertNotNull("should not be null", new Seller("userName","email","firstname","lastname","password","1234567890","address","35000","city", "12345617582369", "lolo.fr"));
    }
    

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertEquals("text/html", html.contentType());
        assertTrue(html.body().contains("Your new application is ready."));
    }


}

import accertions.HttpAssertions;
import dto.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class UserDataApiTest extends BaseApiTest {
    public static String token;
    public static User user;

    @BeforeAll
    public static void initializeUserData() {
        user = new User("string", "string");
        token = restApiBuilder.post("/login", user).as(Token.class).getAccessToken();
    }

    @Test
    public void testRegisteredUser() {
        Response response = restApiBuilder.post("/login", user);
        new HttpAssertions(response,Token.class)
                .statusCode(200)
                .assertionsJsonPathValueNotEmpty("access_token");
    }

    @Test
    public void testUnregisteredUser() {
        User unRegisteredUser = new User("unregistered", "user");
        Response response = restApiBuilder.post("/login", unRegisteredUser);
        new HttpAssertions(response, Message.class)
                .statusCode(401)
                .assertionsMessage("Invalid credentials");
    }


    @Test
    public void testIncorrectPasswordUser() {
        User user = new User("string", "strin");
        Response response = restApiBuilder.post("/login", user);
        new HttpAssertions(response, Message.class)
                .statusCode(401)
                .assertionsMessage("Invalid credentials");
    }

    @Test
    public void testGetProductList() {
        Response response = restApiBuilder.get("/products");

        new HttpAssertions(response, Product.class, true)
                .statusCode(200)
                .assertListNotEmpty();
    }

    @Test
    public void testGetSpecificProduct() {
        CartRequest requestBody = new CartRequest(1, 2);
        Response response = restApiBuilder.get("/products/" + requestBody.getProductId());
        new HttpAssertions(response, Product.class, true)
                .statusCode(200)
                .assertListNotEmpty();
    }

    @Test
    public void testGetUnrealIdProduct() {
        Response response = restApiBuilder.get("/products/111");
        new HttpAssertions(response, Message.class)
                .statusCode(404)
                .assertionsMessage("Product not found");
    }

    @Test
    public void testGetCustomerCart() {
        Response response = restApiBuilder.get("/cart", token);
        new HttpAssertions(response, CartResponse.class)
                .statusCode(200);
    }

    @Test
    public void testAddExistingProductToCart() {
        Response response = restApiBuilder.post("/cart", new CartRequest(1, 2), token);
        new HttpAssertions(response, Message.class)
                .statusCode(201)
                .assertionsMessage("Product added to cart successfully");
    }

    @Test
    public void testAddNotExistingProductToCart() {
        CartRequest requestBody = new CartRequest(111, 2);
        Response response = restApiBuilder.post("/cart", requestBody, token);
        new HttpAssertions(response, Message.class)
                .statusCode(404)
                .assertionsMessage("Product not found");
    }

    @Test
    public void testAddProductWithoutAuthHeader() {
        CartRequest requestBody = new CartRequest(1, 2);
        Response response = restApiBuilder.post("/cart", requestBody);
        new HttpAssertions(response, Msg.class)
                .statusCode(401)
                .assertionsMessage("Missing Authorization Header");
    }

    @Test
    public void testAddProductWithInvalidToken() {
        String wrongToken = token.substring(0, token.length()-1) + ".";
        CartRequest requestBody = new CartRequest(1, 2);
        Response response = restApiBuilder.post("/cart", requestBody, wrongToken);
        new HttpAssertions(response, Msg.class)
                .statusCode(401)
                .assertionsMessage("Missing Authorization Header");
    }

    @Test
    public void testDeleteProductFromCart() {
        CartRequest requestBody = new CartRequest(1, 2);
        Response response = restApiBuilder.delete("/cart/" + requestBody.getProductId(), token);
        new HttpAssertions(response, Message.class)
                .statusCode(200)
                .assertionsMessage("Product removed from cart");
    }

    @Test
    public void testDeleteNotExistProductFromCart() {
        CartRequest requestBody = new CartRequest(111, 2);
        Response response = restApiBuilder.delete("/cart/" + requestBody.getProductId(), token);
        new HttpAssertions(response, Message.class)
                .statusCode(404)
                .assertionsMessage("Product not found in cart");
    }


}


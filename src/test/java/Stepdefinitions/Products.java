package Stepdefinitions;


import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
//import org.openqa.selenium.remote.ResponseCodec;
import static io.restassured.RestAssured.given;
//import static jdk.internal.org.jline.utils.Colors.s;
import static org.junit.Assert.assertEquals;
//import static org.testng.AssertJUnit.assertEquals;
import org.json.simple.JSONObject;


public class Products {
 //   public int statuscode;
    public RequestSpecification httpRequest;
    public  Response response;
    public int ResponseCode;
    public ResponseBody body;
    public JSONObject requestParams;
    public JsonPath jsnpath;

    @Given("I hit the URL of get products API endpoint")
    public void I_hit_the_URL_of_get_products_API_endpoint()
    {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }
    @When("I pass the URL of the products in request")
    public void I_pass_the_URL_of_the_products_in_request() {
        httpRequest = given();
        response = httpRequest.get("Products");

    }
    @Then("I receive the response code as {int}")
    public void I_receive_the_response_code_as(Integer int1) {
        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode,200);

    }

    @Then("I verify that the rate of first product is {}")
    public void i_verify_that_the_rate_of_first_product_is(String rate) {
        body = response.body();

        //Convert json response to string
        String responseBody = body.asString();

       // Json representation from response body
        JsonPath jsnpath = response.jsonPath();

        String s= jsnpath.getJsonObject("rating[0].rate").toString();
        System.out.println("Rate value is:"+s);

       assertEquals(rate, s);

    }

    @Given("I hit the URL of post product API endpoint")
    public void i_hit_the_URL_of_post_product_API_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = given();
        requestParams = new JSONObject();


    }

//    @And("I pass the request body of the product title <>")
//    public void i_pass_the_request_body_of_the_product_title(String title) {
//
//    }

    @And("I pass the request body of the product title {}")
    public void i_pass_the_request_body_of_the_product_title(String title) {

        requestParams.put("title",title);
        requestParams.put("price","15.6");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https: //i.pravatar.cc");
        requestParams.put("category","electronic");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.post("products");
        ResponseBody body= response.getBody();
         jsnpath = response.jsonPath();

        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }


    @Then("I receive the response body with id  as {}")
    public void i_receive_the_response_body_with_id_as(String id) {

        String s = jsnpath.getJsonObject("id").toString();
        assertEquals("21",s);
    }

    @Given("I hit the URL of PUT product API endpoint")
    public void iHitTheURLOfPUTProductAPIEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }

    @When("I pass the URL of the products in request with {}")
    public void iPassTheURLOfTheProductsInRequestWith(String ProductNumber) {
        httpRequest = RestAssured.given();
        requestParams.put("title","Test product");
        requestParams.put("price","13.6");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https: //i.pravatar.cc");
        requestParams.put("category","Watches");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.put("products/"+ProductNumber);
        ResponseBody body= response.getBody();
        jsnpath = response.jsonPath();
        String s = jsnpath.getJsonObject("id").toString();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

    }

    @Given("I hit the URL of delete product API endpoint")
    public void iHitTheURLOfDeleteProductAPIEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }


    @When("I pass the delete URL of the products in request with {int}")
    public void i_pass_the_delete_url_of_the_products_in_request_with(Integer int1) {
        httpRequest = RestAssured.given();
        requestParams.put("title","Test product");
        requestParams.put("price","13.6");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https: //i.pravatar.cc");
        requestParams.put("category","Watches");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.delete("products/"+int1);
        ResponseBody body= response.getBody();

    }


    @Then("I verify that the category of first product is {}")
    public void iVerifyThatTheCategoryOfFirstProductIs(String Category) {
        body = response.body();

        //Convert json response to string
        String responseBody = body.asString();

        // Json representation from response body
        JsonPath jsnpath = response.jsonPath();

        String s= jsnpath.getJsonObject("category[0]").toString();
        System.out.println("category is:"+s);

        assertEquals(Category, s);
    }

    @Then("Print the titles of products")
    public void printTheTitlesOfProducts() {
        body = response.body();

        //Convert json response to string
        String responseBody = body.asString();

        // Json representation from response body
        JsonPath jsnpath = response.jsonPath();

        try {
            // Parse JSON string to JsonNode
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBody);

            // Count the number of titles
            int titleCount = root.size();
            System.out.println("Number of titles: " + titleCount);

            try {

                // Iterate over each object in the array
                for (JsonNode node : root) {
                    // Extract and print the title attribute
                    String title = node.get("title").asText();
                    System.out.println("Title: " + title);
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }



        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }



    }

    @And("I pass the request body of the product Price value {}")
    public void iPassTheRequestBodyOfTheProductPriceValue(String ProductPrice) {

        requestParams.put("title","title");
        requestParams.put("price",ProductPrice);
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https: //i.pravatar.cc");
        requestParams.put("category","electronic");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.post("products");
        ResponseBody body= response.getBody();
        System.out.println("Response Body:" +body);
        jsnpath = response.jsonPath();
        System.out.println("jsnpath Body:" +jsnpath);
        System.out.println(response.getStatusLine());
        System.out.println("Response Body:" +body.asString());


    }

    @Then("I receive the response status code")
    public void iReceiveTheResponseStatusCode() {
        ResponseCode = response.getStatusCode();
        System.out.println("Response code:"+ResponseCode);
    }


    @When("I pass the URL of the products with characters in request with {}")
    public void iPassTheURLOfTheProductsWithCharactersInRequestWith(String ProductId) {

        httpRequest = RestAssured.given();
        requestParams.put("title","Test product");
        requestParams.put("price","13.6");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https: //i.pravatar.cc");
        requestParams.put("category","Watches");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.put("products/"+ProductId);
        ResponseBody body= response.getBody();
        jsnpath = response.jsonPath();
//        String s = jsnpath.getJsonObject("id").toString();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

    @Then("I receive the response code")
    public void iReceiveTheResponseCode() {

        ResponseCode = response.getStatusCode();
        System.out.println("Response code:"+ResponseCode);

    }


    @When("I pass the delete URL of the products with characters in request with {}")
    public void iPassTheDeleteURLOfTheProductsWithCharactersInRequestWith(char ProductId) {

        httpRequest = RestAssured.given();
        requestParams.put("title","Test product");
        requestParams.put("price","13.6");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https: //i.pravatar.cc");
        requestParams.put("category","Watches");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.delete("products/"+ProductId);
        ResponseBody body= response.getBody();
        System.out.println("Response line:"+response.getStatusLine());

    }
}

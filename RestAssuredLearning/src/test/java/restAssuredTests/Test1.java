package restAssuredTests;

import org.testng.annotations.Test;


import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test1 {
	
	@Test
	public void Example_Test1(){
		
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		
		
	}
	
	@Test
	public void Example_Test2()
	{
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200)
		.body("data[2].id", equalTo(8)).log().all();
	}

}

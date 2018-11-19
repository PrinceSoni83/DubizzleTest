package project;


import static com.jayway.restassured.RestAssured.given;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mysample {

	@Test
	public void test() throws FileNotFoundException, IOException, ParseException {
		//First URL Test - Validate the response
		ResponseBody body = given().when().get("https://api.github.com/users/dubizzle").getBody();
		System.out.println(body.asString());
		JsonPath jsonPath = new JsonPath(body.asString());
		String data = jsonPath.get("login");
		System.out.println(data);
//		
//		//Second URL Test - Validate the response
		Response body1 = given().when().get("https://api.github.com/users/dubizzle/repos");
		System.out.println(body1.jsonPath().get());
		System.out.println(body1.jsonPath().get("id[1]").toString());
//		
//		//schema1 validation
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("src/test/java/project/myschema.json"));
		JSONObject jsonObject = (JSONObject) obj;
		given().when().get("https://api.github.com/users/dubizzle").then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonObject.toJSONString()));

		 //schema2 validation
		JSONParser parser1 = new JSONParser();
		Object obj1 = parser1.parse(new FileReader("src/test/java/project/myscema2.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;
		given().when().get("https://api.github.com/users/dubizzle/repos").then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonObject1.toJSONString()));

	}
}

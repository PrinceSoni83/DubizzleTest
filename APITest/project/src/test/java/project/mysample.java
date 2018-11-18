package project;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import io.restassured.module.jsv.JsonSchemaValidator;
public class mysample {

	@Test
	public void test() throws FileNotFoundException, IOException, ParseException {
		//First URL Test
//		ResponseBody body = given().when().get("https://api.github.com/users/dubizzle").getBody();
//		System.out.println(body.asString());
//		JsonPath jsonPath = new JsonPath(body.asString());
//		String data = jsonPath.get("login");
//		System.out.println(data);
		
		//Second URL Test
//		Response body = given().when().get("https://api.github.com/users/dubizzle/repos");
////		System.out.println(body.asString());
////		String[]   jsonPath = body.jsonPath().get();
////		String data = jsonPath.get("login");
//		System.out.println(body.jsonPath().get("id[1]").toString());
		
		//schema1
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(new FileReader("/Users/meherchandan/eclipse-workspace/project/src/test/java/project/myschema.json"));
////		\\Users\\meherchandan\\eclipse-workspace\\project\\src\\test\\java\\project\\myschema.json"
//        JSONObject jsonObject = (JSONObject) obj;
//		 given().when().get("https://api.github.com/users/dubizzle").then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonObject.toJSONString()));

			//schema2
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("/Users/meherchandan/eclipse-workspace/project/src/test/java/project/myscema2.json"));
//			\\Users\\meherchandan\\eclipse-workspace\\project\\src\\test\\java\\project\\myschema.json"
	        JSONObject jsonObject = (JSONObject) obj;
			 given().when().get("https://api.github.com/users/dubizzle/repos").then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonObject.toJSONString()));

	}
}

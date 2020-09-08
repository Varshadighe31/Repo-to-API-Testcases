package ApiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class GetRequest {

	@Test  
	public void Test01()
	{
		when().
		get("https://api.spacexdata.com/v4/launches/latest/").
		then().
		statusCode(200);
	}



	@Test  
	public void Test02()
	{
		when().
		get("https://api.spacexdata.com/v4/launches/latest/").
		then().
		contentType("application/json; charset=utf-8");
	}

	@Test  
	public void Test03()
	{

		Response res=get("https://api.spacexdata.com/v4/launches/latest/");
		JsonPath extractor =res.jsonPath();
		String id =extractor.get("id");
		Assert.assertEquals(id, "5ef6a1e90059c33cee4a828a");

	}


	@Test  
	public void Test04()
	{

		Response res=get("https://api.spacexdata.com/v4/launches/latest/");
		JsonPath extractor =res.jsonPath();
		String lpad =extractor.get("launchpad");
		Assert.assertEquals(lpad, "5e9e4502f509094188566f88");

	}


	@Test  
	public void Test05()
	{

		Response res=get("https://api.spacexdata.com/v4/launches/latest/");
		JsonPath extractor =res.jsonPath();
		int FlightNo =extractor.get("flight_number");
		Assert.assertEquals(FlightNo, 102);

	}

}



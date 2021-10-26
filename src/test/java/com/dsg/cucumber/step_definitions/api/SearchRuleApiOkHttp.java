package com.dsg.cucumber.step_definitions.api;

import com.dsg.cucumber.utilities.ExcelUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class SearchRuleApiOkHttp {
	private static final String GOOGLE_TEST = "https://www.googleapis.com/customsearch/v1";
	private static final String ZETA_DSG = "https://api-search.dickssportinggoods.com/prodauth/catalog-product/v1/search";
	private static final String PROD_DSG = "https://prod-catalog-product-api.dickssportinggoods.com/v1/search";
	public static final String FILE_PATH = System.getProperty("user.dir")
		+"/src/test/java/com/dsg/cucumber/test_data/sb/searchRuleList.xls";

	ExcelUtil excel = new ExcelUtil(
			FILE_PATH, "testFile");
	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";

	@Test
	public void getSearchRule(){
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		int searchTermColumnNumber = 0; //1st column in Excel
		List<String> getList = excel.getDataArrayList(searchTermColumnNumber);
		for (int i = 0; i < getList.size(); i++) {
			String searchTermFromList = getList.get(i);
			String searchTerm = "\"" + searchTermFromList + "\"";
			baseURI = PROD_DSG;
			Response request = (Response) given().header("authority", "api-search.dickssportinggoods.com")
					.header("accept", "application/json, text/plain, */*").header("preview", "false")
					.header("user-agent",
							"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36")
					.header("content-type", "application/json").header("origin", "https://zeta.dickssportinggoods.com")
					.header("sec-fetch-site", "same-site").header("sec-fetch-mode", "cors")
					.header("sec-fetch-dest", "empty").header("referer", "https://zeta.dickssportinggoods.com/")
					.header("accept-language", "en-US,en;q=0.9")
					.body("{\"pageNumber\":0,\"pageSize\":48,\"selectedStore\":\"129\",\"selectedFilters\":{\"facetStore\":[\"ISA\",\"SHIP\"]},\"selectedSort\":\"\",\"searchTerm\":"
							+ searchTerm + ",\"storeId\":\"15108\",\"snbAudience\":\"\"}")
					.when().post();
//        .prettyPeek()
			String jsonString = request.getBody().asString();
			if (jsonString.contains("SEARCHRULE")) {
				System.out.println("SearchRule is fired");
				excel.setCellData(TRUE, i + 1, 1);
			} else if (!jsonString.contains("SEARCHRULE")) {
				System.out.println("SearchRule is NOT fired");
				excel.setCellData(FALSE, i + 1, 1);
			} else {
				System.out.println("SearchRule is undefiend");

			}
			int statusCode = request.getStatusCode(); //
//			System.out.println("Response Body is: " + request.getBody().asString());
			System.out.println("Response Code is: " + statusCode);
		}
	}
}
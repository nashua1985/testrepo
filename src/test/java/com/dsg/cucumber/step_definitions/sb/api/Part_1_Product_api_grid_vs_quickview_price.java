package com.dsg.cucumber.step_definitions.sb.api;

import com.dsg.cucumber.utilities.ExcelUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Part_1_Product_api_grid_vs_quickview_price {
	private static final String GOOGLE_TEST = "https://www.googleapis.com/customsearch/v1";
	private static final String PROD_DSG_SEARCH = "https://prod-catalog-product-api.dickssportinggoods.com/v1/search";
	private static final String PROD_DSG_QUICKVIEW_ECODE = "https://api-search.dickssportinggoods.com/catalog-productdetails/v1/quickview/ecode";
	public static final String FILE_PATH = System.getProperty("user.dir")+
		"/src/test/java/com/dsg/cucumber/test_data/sb/productApi_quickViewApiList.xls";
	public static final String SUCCESS_VALIDATION = "Product API prices ARE MATCHING with Quick View API prices";
	public static final String FAILED_VALIDATION = "Prices ARE NOT MATCHING: Product API vs QuickView API";
	public static final String EXCEL_RECORDED_MESSAGE = "Prices are recorded into Spread Sheet";
	ExcelUtil excel = new ExcelUtil(
			FILE_PATH, "productList");
	public static final String ZETA_DSG_SEARCH = "https://api-search.dickssportinggoods.com/prodauth/catalog-product/v1/search";
	public static final String ZETA_DSG_QUICKVIEW_ECODE = "https://api-search.dickssportinggoods.com/prodauth/catalog-productdetails/v1/quickview/ecode";
	public static final String PERF_DSG_SEARCH = "https://api-search.dickssportinggoods.com/perf/catalog-product/v1/search";
	public static final String PERF_DSG_QUICKVIEW_ECODE = "https://api-search.dickssportinggoods.com/perf/catalog-productdetails/v1/quickview/ecode";

	@Test
	public void getPart_1_Product_api_grid_vs_quickview_price() {
		int productIdColumn = 0; //1st column in Excel
		List<String> getList = excel.getDataArrayList(productIdColumn);
		System.out.println(getList.size());
		for (int i = 0; i < getList.size(); i++) {
			String webIdFromList = getList.get(i);
			String product = "\"" + webIdFromList + "\"";
			baseURI = ZETA_DSG_SEARCH;
			Response searchRequest = (Response) given().header("authority", "prod-catalog-product-api.dickssportinggoods.com")
					.header("pragma", "no-cache")
					.header("cache-control", "no-cache")
					.header("sec-ch-ua", "\"Google Chrome\";v=\"87\", \" Not;A Brand\";v=\"99\", \"Chromium\";v=\"87\"")
					.header("accept", "application/json, text/plain, */*")
					.header("preview", "false")
					.header("sec-ch-ua-mobile", "?0")
					.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36")
					.header("content-type", "application/json")
					.header("origin", "https://www.dickssportinggoods.com")
					.header("sec-fetch-site", "same-site")
					.header("sec-fetch-mode", "cors")
					.header("sec-fetch-dest", "empty")
					.header("referer", "https://www.dickssportinggoods.com/")
					.header("accept-language", "en-US,en;q=0.9")
					.header("Cookie", "ak_bmsc=6423E0F9A40AD888465E28085A6FB6ED48F634655F1100002438FD5FCF360212~pl8X9dRjk+c80NaQvi5KwxA0rrBavdE+MnXvkayKD2oWoiC/4MOoARmwVWsauZiK6ihwizGlknovEpNNNpVUshxB9o/6kTnrPJJgug5NZF/TuxdttzwV6rKXq4a7dGvwfYthlAG4DM0fN27M49WFMTIPKwjsX5iMYrdeiS4C+/lESxy25gzRdBDG0sB/QWaVRoMRfbbsLhk2CzUlGMLe+aL1HOYSaQ4i1FB4LyWzRZGWDhBX1EQE60l04j62tiSxJv; bm_sz=325BF4505A4633D7BB4BAD342C0B208E~YAAQZTT2SLoiS9Z2AQAAwU0j9QpItbgZvSdhmo+FtZGqMIamHUH9ZPL06z2l6mnvkWpBK3+8Y0Mpj/u8rQKOjq5MwtnAUs4QKXjZ+M+gOa6N5YwIcI1U6QKJFEEnkTIR2vinitV226FSoVa1m2oIQZieQnvJZH6jwgYMQ4aj2mpH+xzf9Ea+hd+hSjbirBT79hO1ME/wY3tRbpW9Ot7n6UPiKi7QOlO/sKkldfkYWmPi1QbNtTXFHErUwagkN80f0PQBGjlCtQPvecsSB+FH8YbTEMdulHVwVAeUjY3GepOKfFus5M19+6c=; _abck=CAD98D42910EF0D6672C69BF895C2FEF~-1~YAAQZTT2SLsiS9Z2AQAAwU0j9QWGGo1rlNVqXvpUIdOxs13LmaYR7KaQTT7V7jLVlz/Z4VOeJogLlQVJixcgNDKjixekIyy5xnFGr2uQVjWDcGYEm6zTakkT+MWzfszAU03I/rfLIyJTOYUmYTKd299jSqSAYnh3OE5B5C51M5Q1PqsIgzB/vTy7d37jNLG4Ar52Lq68IIZ4/kEe1sE2GuDm6T0fXjHl8D7A8UHTHb+4eo3LUS2lmuYlrns+hh+S2QnxlxoRCTaiPsQljg8ScWlsYJFgfyOdQ/+1gvodNlCw7AOoU9jDhpB2HSmQiywsY80zmuiMcj0lRjnPAWF+SZ9/3ldpdBhwnqeUTyAt1ZQ7aVhLUfZWtOeCPSh7k4q4WETXFb70Y6DQ~-1~-1~-1")
					.body("{\"pageNumber\":0,\"pageSize\":48,\"selectedStore\":\"1401\",\"selectedFilters\":{\"facetStore\":[\"ISA\",\"SHIP\"]},\"selectedSort\":\"\",\"searchTerm\":"+product+",\"storeId\":\"15108\",\"snbAudience\":\"\"}")
					.when().post();
//        .prettyPeek();
			baseURI = ZETA_DSG_QUICKVIEW_ECODE;
			Response quickViewEcodeRequest = (Response) given().header("authority", "api-search.dickssportinggoods.com")
					.header("pragma", "no-cache")
					.header("cache-control", "no-cache")
					.header("sec-ch-ua", "\"Google Chrome\";v=\"87\", \" Not;A Brand\";v=\"99\", \"Chromium\";v=\"87\"")
					.header("accept", "application/json, text/plain, */*")
					.header("sec-ch-ua-mobile", "?0")
					.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36")
					.header("content-type", "application/json")
					.header("origin", "https://www.dickssportinggoods.com")
					.header("sec-fetch-site", "same-site")
					.header("sec-fetch-mode", "cors")
					.header("sec-fetch-dest", "empty")
					.header("referer", "https://www.dickssportinggoods.com/")
					.header("accept-language", "en-US,en;q=0.9")
					.header("Cookie", "ak_bmsc=6423E0F9A40AD888465E28085A6FB6ED48F634655F1100002438FD5FCF360212~pl8X9dRjk+c80NaQvi5KwxA0rrBavdE+MnXvkayKD2oWoiC/4MOoARmwVWsauZiK6ihwizGlknovEpNNNpVUshxB9o/6kTnrPJJgug5NZF/TuxdttzwV6rKXq4a7dGvwfYthlAG4DM0fN27M49WFMTIPKwjsX5iMYrdeiS4C+/lESxy25gzRdBDG0sB/QWaVRoMRfbbsLhk2CzUlGMLe+aL1HOYSaQ4i1FB4LyWzRZGWDhBX1EQE60l04j62tiSxJv; bm_sz=325BF4505A4633D7BB4BAD342C0B208E~YAAQZTT2SLoiS9Z2AQAAwU0j9QpItbgZvSdhmo+FtZGqMIamHUH9ZPL06z2l6mnvkWpBK3+8Y0Mpj/u8rQKOjq5MwtnAUs4QKXjZ+M+gOa6N5YwIcI1U6QKJFEEnkTIR2vinitV226FSoVa1m2oIQZieQnvJZH6jwgYMQ4aj2mpH+xzf9Ea+hd+hSjbirBT79hO1ME/wY3tRbpW9Ot7n6UPiKi7QOlO/sKkldfkYWmPi1QbNtTXFHErUwagkN80f0PQBGjlCtQPvecsSB+FH8YbTEMdulHVwVAeUjY3GepOKfFus5M19+6c=; _abck=CAD98D42910EF0D6672C69BF895C2FEF~-1~YAAQZTT2SLsiS9Z2AQAAwU0j9QWGGo1rlNVqXvpUIdOxs13LmaYR7KaQTT7V7jLVlz/Z4VOeJogLlQVJixcgNDKjixekIyy5xnFGr2uQVjWDcGYEm6zTakkT+MWzfszAU03I/rfLIyJTOYUmYTKd299jSqSAYnh3OE5B5C51M5Q1PqsIgzB/vTy7d37jNLG4Ar52Lq68IIZ4/kEe1sE2GuDm6T0fXjHl8D7A8UHTHb+4eo3LUS2lmuYlrns+hh+S2QnxlxoRCTaiPsQljg8ScWlsYJFgfyOdQ/+1gvodNlCw7AOoU9jDhpB2HSmQiywsY80zmuiMcj0lRjnPAWF+SZ9/3ldpdBhwnqeUTyAt1ZQ7aVhLUfZWtOeCPSh7k4q4WETXFb70Y6DQ~-1~-1~-1")
					.body("{\"storeId\":15108,\"partNumber\":"+product+",\"includeStyle\":true,\"selectedStore\":\"1401\",\"inventory\":true,\"isClearance\":false}")
					.when().post();
//				.prettyPeek();
			int statusCode = searchRequest.getStatusCode();
			System.out.println("Response Code is: " + statusCode);
			String searchRequestToString = searchRequest.getBody().asString();
			String quickViewEcodeRequestToString = quickViewEcodeRequest.getBody().asString();
//Product API
			JSONObject searchRequestToStringObj = new JSONObject(searchRequestToString);
			JSONObject quickViewEcodeRequestToStringObj = new JSONObject(quickViewEcodeRequestToString);
//Getting PartNumber from Product API
			JSONArray jsonArray = (JSONArray) searchRequestToStringObj.get("productVOs");
			int partNumber=0;
			for (int k = 0; k < jsonArray.length(); k++) {
				JSONObject rec = jsonArray.getJSONObject(k);
				partNumber = rec.getInt("catentryId");
				System.out.println("partNumber: "+partNumber);
			}
			String partNumberToString = String.valueOf(partNumber);
			excel.setCellData(partNumberToString, i + 1, 1);

			double minlistpriceProductApi = searchRequestToStringObj.getJSONObject("productDetails").getJSONObject(partNumberToString).getJSONObject("prices").getDouble("minlistprice");
			double minofferpriceProductApi = searchRequestToStringObj.getJSONObject("productDetails").getJSONObject(partNumberToString).getJSONObject("prices").getDouble("minofferprice");
			double maxlistpriceProductApi = searchRequestToStringObj.getJSONObject("productDetails").getJSONObject(partNumberToString).getJSONObject("prices").getDouble("maxlistprice");
			double maxofferpriceProductApi = searchRequestToStringObj.getJSONObject("productDetails").getJSONObject(partNumberToString).getJSONObject("prices").getDouble("maxofferprice");
			double priceIndicatorProductApi = searchRequestToStringObj.getJSONObject("productDetails").getJSONObject(partNumberToString).getDouble("priceIndicator");
			double mapPriceIndicatorProductApi = searchRequestToStringObj.getJSONObject("productDetails").getJSONObject(partNumberToString).getDouble("mapPriceIndicator");
//QuickView API
			double minlistpriceQuickViewApi = quickViewEcodeRequestToStringObj.getJSONObject("style").getJSONObject("prices").getDouble("minlistprice");
			double minofferpriceQuickViewApi = quickViewEcodeRequestToStringObj.getJSONObject("style").getJSONObject("prices").getDouble("minofferprice");
			double maxlistpriceQuickViewApi = quickViewEcodeRequestToStringObj.getJSONObject("style").getJSONObject("prices").getDouble("maxlistprice");
			double maxofferpriceQuickViewApi = quickViewEcodeRequestToStringObj.getJSONObject("style").getJSONObject("prices").getDouble("maxofferprice");
			double priceIndicatorQuickViewApi = quickViewEcodeRequestToStringObj.getJSONObject("style").getJSONObject("prices").getDouble("priceIndicator");
			double mapPriceIndicatorQuickViewApi = quickViewEcodeRequestToStringObj.getJSONObject("style").getJSONObject("prices").getDouble("mapPriceIndicator");
//Validate if both API match
			List<String> listPrice = new ArrayList<>();
			if (minlistpriceProductApi == minlistpriceQuickViewApi && minofferpriceProductApi == minofferpriceQuickViewApi &&
					maxlistpriceProductApi == maxlistpriceQuickViewApi && maxofferpriceProductApi == maxofferpriceQuickViewApi &&
					priceIndicatorProductApi == priceIndicatorQuickViewApi && mapPriceIndicatorProductApi == mapPriceIndicatorQuickViewApi) {
				System.out.println("Product_ID: "+product);
				System.out.println("Validation Result: "+SUCCESS_VALIDATION);
				listPrice.add(String.valueOf(minlistpriceProductApi));
				listPrice.add(String.valueOf(minofferpriceProductApi));
				listPrice.add(String.valueOf(maxlistpriceProductApi));
				listPrice.add(String.valueOf(maxofferpriceProductApi));
				listPrice.add(String.valueOf(priceIndicatorProductApi));
				listPrice.add(String.valueOf(mapPriceIndicatorProductApi));
			} else {
				Assert.fail("Validation Result: "+FAILED_VALIDATION);
			}
			for(int y=0, z=0;y<listPrice.size();y++, z++){
				excel.setCellData(listPrice.get(y), i+1, z+2);
			}
			System.out.println(EXCEL_RECORDED_MESSAGE);
			System.out.println("___________________");

		}
//Validate if price is changed
//		new Part_2_Product_api_grid_vs_quickview_price().getPart_2_Product_api_grid_vs_quickview_price();
	}
}

//public Part_2_Product_api_grid_vs_quickview_price_execution{
//public void part_2_Product_api_grid_vs_quickview_price_execution(){
//	new Part_2_Product_api_grid_vs_quickview_price().getPart_2_Product_api_grid_vs_quickview_price();
//		}
//}
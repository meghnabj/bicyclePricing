/**
 * 
 */
package com.cycle.test.startingPoint;

import com.cycle.test.core.PricingEngine;
import com.cycle.test.util.PriceEngineUtil;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Meghana
 *
 *
 */
public class BicyclePriceCalculate {

	private static JSONArray enquiry = null;

	private static String readInput(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	public static void main(String[] args) {
		String thisPath = PriceEngineUtil.dataFilePath + "bicycle.json";

		String result = readInput(thisPath);
		String result1 = "[{\n" +
				"  \"order\" : 1,\n" +
				"  \"date\":\"01-02-2020\",\n" +
				"\n" +
				"  \"frame\": {\n" +
				"    \"type\":\"abc\"\n" +
				"  },\n" +
				"  \"handle\": {\n" +
				"    \"type\":\"abc\",\n" +
				"   \"shockLock\": true\n" +
				"  },\n" +
				" \"seat\": {\n" +
				"    \"type\":\"abc\"\n" +
				"  },\n" +
				" \"wheel\": {\n" +
				"    \"spoke\":\"TANGENTIALLACING\",\n" +
				"   \"rim\":\"ALLOY\",\n" +
				"\"tube\":\"abc\",\n" +
				"   \"tyre\":\"abc\"\n" +
				"  },\n" +
				" \"chainAssembly\": {\n" +
				"    \"chainSize\": 10,\n" +
				" \"speed\" : 10\n" +
				"  }\n" +
				" },\n" +
				"{\n" +
				"  \"order\" : 2,\n" +
				"  \"date\":\"01-03-2020\",\n" +
				"\n" +
				"  \"frame\": {\n" +
				"    \"type\":\"ORDINARY\"\n" +
				"  },\n" +
				"  \"handle\": {\n" +
				"    \"type\":\"ORDINARY\",\n" +
				"   \"shockLock\": false\n" +
				"  },\n" +
				" \"seat\": {\n" +
				"    \"type\":\"RACING\"\n" +
				"  },\n" +
				" \"wheel\": {\n" +
				"    \"spoke\":\"TANGENTIALLACING\",\n" +
				"   \"rim\":\"STEEL\",\n" +
				"\"tube\":\"TUBE\",\n" +
				"   \"tyre\":\"TUBULAR\"\n" +
				"  },\n" +
				" \"chainAssembly\": {\n" +
				"    \"chainSize\": 10,\n" +
				" \"speed\" : 8\n" +
				"  }\n" +
				" },\n" +
				"{\n" +
				"  \"order\" : 3,\n" +
				"  \"date\":\"01-04-2020\",\n" +
				"\n" +
				"  \"frame\": {\n" +
				"    \"type\":\"PRONE\"\n" +
				"  },\n" +
				"  \"handle\": {\n" +
				"    \"type\":\"STANDARD\",\n" +
				"   \"shockLock\": true\n" +
				"  },\n" +
				" \"seat\": {\n" +
				"    \"type\":\"COMFORT\"\n" +
				"  },\n" +
				" \"wheel\": {\n" +
				"    \"spoke\":\"TANGENTIALLACING\",\n" +
				"   \"rim\":\"CHROME\",\n" +
				"\"tube\":\"TUBELESS\",\n" +
				"   \"tyre\":\"CLINCHER\"\n" +
				"  },\n" +
				" \"chainAssembly\": {\n" +
				"    \"chainSize\": 10,\n" +
				" \"speed\" : 6\n" +
				"  }\n" +
				" },\n" +
				"{\n" +
				"  \"order\" : 4,\n" +
				"  \"date\":\"01-05-2020\",\n" +
				"\n" +
				"  \"frame\": {\n" +
				"    \"type\":\"DIAMOND\"\n" +
				"  },\n" +
				"  \"handle\": {\n" +
				"    \"type\":\"TRACK\",\n" +
				"   \"shockLock\": true\n" +
				"  },\n" +
				" \"seat\": {\n" +
				"    \"type\":\"COMFORT\"\n" +
				"  },\n" +
				" \"wheel\": {\n" +
				"    \"spoke\":\"TANGENTIALLACING\",\n" +
				"   \"rim\":\"ALLOY\",\n" +
				"\"tube\":\"TUBE\",\n" +
				"   \"tyre\":\"CLINCHER\"\n" +
				"  },\n" +
				" \"chainAssembly\": {\n" +
				"    \"chainSize\": 8,\n" +
				" \"speed\" : 8\n" +
				"  }\n" +
				" }\n" +
				"]";

		try {

			enquiry = new JSONArray(result);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		PricingEngine priceEngine = new PricingEngine(enquiry);
		priceEngine.calculatePrice();

		System.out.println("write to output folder");
	}

}

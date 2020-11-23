package org.ieti.lucrarea6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtility {

	public static void writeToFile(SubscriptionPlan plan){
		XmlMapper xmlMapper = new XmlMapper();

		try {
			xmlMapper.writeValue(new File("src/main/resources/plan.xml"),plan);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SubscriptionPlan readFromFile() {
		XmlMapper xmlMapper = new XmlMapper();

		try {
			String xml = new String(Files.readAllBytes(Paths.get("src/main/resources/plan.xml")));
			SubscriptionPlan subscriptionPlan = xmlMapper.readValue(xml, SubscriptionPlan.class);
			return subscriptionPlan;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}

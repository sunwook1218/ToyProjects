package com.sun.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TestMain {

	private static String apiKey = "G3ijxV0WoghuxvnIseVg7Q";
	private static String code = "99"; // 롯데 글로벌로지스
//	private static String code = "04"; // cj대한통운
//	private static String code = "05";
	private static String invoice = "6064872420649";
//	private static String invoice = "355645168443";
//	private static String invoice = "509954754864";

	public static void main(String[] args)
			throws IOException, ParserConfigurationException, SAXException, TransformerException {

		// xml형식으로 된 문자열을 api를 통해 얻어냅니다.
		String xmlString = getXmlString(apiKey, code, invoice);
		System.out.println(xmlString);

		// 문자열을 document객체로 만들어줍니다. 이 단계에서 document객체를 이용하여 parse할 수 있습니다.
		Document document = getDocument(xmlString);
		
		// document객체를 xml문서로 배포합니다.
		exportXml(document);

	}

	private static String getXmlString(String apiKey, String code, String invoice) throws IOException {

		String xmlString = null;

		Process exec = Runtime.getRuntime()
				.exec("curl -X GET \"https://info.sweettracker.co.kr/api/v1/trackingInfo?t_key=" + apiKey + "&t_code="
						+ code + "&t_invoice=" + invoice + "\" -H  \"accept: application/xml;charset=utf8\"");

		BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));

		Scanner scanner = new Scanner(br);
		scanner.useDelimiter(System.getProperty("line.separator"));

		while (scanner.hasNext()) {
			xmlString = scanner.next();
		}

		scanner.close();

		return xmlString;

	}

	private static Document getDocument(String xmlString)
			throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document document = builder.parse(new InputSource(new StringReader(xmlString)));

		return document;
	}

	private static void exportXml(Document document) throws TransformerException {

		Source src = new DOMSource(document);
		Result dest = new StreamResult(new File("xmlData" + System.currentTimeMillis() + ".xml"));
		
		TransformerFactory transFac = TransformerFactory.newInstance();
		Transformer aTransformer = transFac.newTransformer();
		
		aTransformer.transform(src, dest);

	}

}

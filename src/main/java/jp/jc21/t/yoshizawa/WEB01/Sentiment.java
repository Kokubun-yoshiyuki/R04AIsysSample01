package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Sentiments message = getSentiment("Stepover Toehold With Facelock");
		if (message != null) {
			System.out.println("positive" + message.documents[0].confidenceScores.positive);
			System.out.println("neutral" + message.documents[0].confidenceScores.neutral);
			System.out.println("negative" + message.documents[0].confidenceScores.negative);
		}
	}

	static Sentiments getSentiment(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3a09.cognitiveservices.azure.com/" + "text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "417bf7a8aec2439f8cd3264aa2d31f90");

		Docs doc = new Docs();
		doc.id = "1";
		doc.text = s;

		Source src = new Source();
		src.documents = new Docs[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		JsonReader reader = WebApiConnector.postJsonReader(url, proxy, map, jsonData);
		Sentiments message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Sentiments.class);
			reader.close();
		}
		return message;
	}

}

class Sentiments {
	SDocuments[] documents;
	String[] errors;
	String modelVersion;
}

class SDocuments {
	ConfidenceScores confidenceScores;
	SdetectedLanguage detectedLanguage;
	String id;
	Sentences[] sentences;
	String sentement;
	String[] warnings;
	
}

class ConfidenceScores {
	float negative;
	float neutral;
	float positive;
}

class SdetectedLanguage {
	String name;
}

class Sentences {
	Targets[] targets;
	ConfidenceScores confidenceScores;
	float length;
	float offset;
	Assessment[] assessment;
	String sentiment;
	String text;
}

class Assessment {
	ConfidenceScores confidenceScores;
	float lemgth;
	float offset;
	String sentimenbt;
	String text;
}

class Targets {
	ConfidenceScores confidenceScores;
	float length;
	float offset;
	Relations[] relation;
	String sentiment;
	String text;
}

class Relations {
	String ref;
	String relationType;
}

class SSource {
	Docs[] documents;
}

class SDocs {
	String id;
	String text;
}

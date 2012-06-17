package dmcs.matchfinder.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dmcs.matchfinder.model.Match;
import dmcs.matchfinder.model.MatchLocation;
import dmcs.matchfinder.model.Phase;
import dmcs.matchfinder.model.Stadium;
import dmcs.matchfinder.model.StadiumLocation;

public class JSONDataGate {
	private HttpClient httpClient;
	private final String WEBSERVICES_URL = "http://mateusz.aronnet.com/match_finder/?"; /*web service url*/

	public JSONDataGate() {
		this.httpClient = new DefaultHttpClient();
	}
	
	public JSONArray getData(String parent, HttpGet httpGet) throws ClientProtocolException,
	IOException, JSONException{
		HttpResponse response = httpClient.execute(httpGet);

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));

		StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
		}

		JSONObject jsonObject = new JSONObject(stringBuffer.toString());
		JSONArray jsonArray = jsonObject.getJSONArray(parent);
		return jsonArray;
	}

	public ArrayList<Phase> getPhases() throws ClientProtocolException,
	IOException, JSONException {
		HttpGet httpGet = new HttpGet(WEBSERVICES_URL + "phasesList=1");
		JSONArray phasesArray = getData("phases", httpGet);

		ArrayList<Phase> phasesList = new ArrayList<Phase>();
		for (int i = 0; i < phasesArray.length(); i++) {
			JSONObject currentPhase = phasesArray.getJSONObject(i);
			int id = currentPhase.getInt("id");
			String name = currentPhase.getString("name");
			phasesList.add(new Phase(id, name));
		}

		return phasesList;
	}

	public ArrayList<Stadium> getStadiums() throws ClientProtocolException,
			IOException, JSONException {
		HttpGet httpGet = new HttpGet(WEBSERVICES_URL + "stadiumsList=1");
		JSONArray stadiumsArray = getData("stadiums", httpGet);

		ArrayList<Stadium> stadiumsList = new ArrayList<Stadium>();
		for (int i = 0; i < stadiumsArray.length(); i++) {
			JSONObject currentPhase = stadiumsArray.getJSONObject(i);
			int id = currentPhase.getInt("id");
			String name = currentPhase.getString("name");
			String address = currentPhase.getString("address");
			stadiumsList.add(new Stadium(id, name, address));
		}

		return stadiumsList;
	}

	public ArrayList<Match> getMatches(int indexOfMatchInPhase)
			throws ClientProtocolException, IOException, JSONException {
		HttpGet httpGet = new HttpGet(WEBSERVICES_URL + "matchesListInPhase="
				+ indexOfMatchInPhase);
		JSONArray matchesArray = getData("matches", httpGet);

		ArrayList<Match> matchesList = new ArrayList<Match>();
		for (int i = 0; i < matchesArray.length(); i++) {
			JSONObject currentMatch = matchesArray.getJSONObject(i);
			int id = currentMatch.getInt("id");
			String rep1 = currentMatch.getString("rep1");
			String rep2 = currentMatch.getString("rep2");
			String date = currentMatch.getString("date");
			String score = currentMatch.getString("score");
			String stadium = currentMatch.getString("stadium");
			matchesList.add(new Match(id, rep1, rep2, date, score, stadium));
		}

		return matchesList;
	}
	
	public ArrayList<StadiumLocation> getStadiumLocation(int indexOfStadium)
			throws ClientProtocolException, IOException, JSONException {
		HttpGet httpGet = new HttpGet(WEBSERVICES_URL + "stadiumLocation="
				+ indexOfStadium);
		JSONArray matchesArray = getData("stadiumLocation", httpGet);

		ArrayList<StadiumLocation> matchesList = new ArrayList<StadiumLocation>();
		for (int i = 0; i < matchesArray.length(); i++) {
			JSONObject currentMatch = matchesArray.getJSONObject(i);
			
			String rep1 = currentMatch.getString("lat");
			String rep2 = currentMatch.getString("lon");
			
			matchesList.add(new StadiumLocation(rep1, rep2));
		}

		return matchesList;
	}
	
	public ArrayList<MatchLocation> getMatchLocation(int indexOfMatch)
			throws ClientProtocolException, IOException, JSONException {
		HttpGet httpGet = new HttpGet(WEBSERVICES_URL + "matchLocation=" + indexOfMatch);
		JSONArray matchesLocationArray = getData("matchLocation", httpGet);

		ArrayList<MatchLocation> matchLocation = new ArrayList<MatchLocation>();
		for (int i = 0; i < matchesLocationArray.length(); i++) {
			
			JSONObject currentMatch = matchesLocationArray.getJSONObject(i);	
			String lat = currentMatch.getString("lat");
			String lon = currentMatch.getString("lon");
			String name = currentMatch.getString("name");
			String address = currentMatch.getString("address");		
			matchLocation.add(new MatchLocation(lat, lon, name, address));
		}

		return matchLocation;
	}
}

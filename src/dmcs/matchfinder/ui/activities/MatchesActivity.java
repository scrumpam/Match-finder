package dmcs.matchfinder.ui.activities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import matchfinder.ui.activites.R;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import dmcs.matchfinder.engine.JSONDataGate;
import dmcs.matchfinder.model.Match;

public class MatchesActivity extends ListActivity {
	/** Called when the activity is first created. */

	private final String MATCH_ID = "id meczu";
	private final String MATCH_REP1 = "rep1 meczu";
	private final String MATCH_REP2 = "rep2 meczu";
	private final String MATCH_SCORE = "nazwa meczu";
	private final String MATCH_DATE = "data meczu";
	private final String MATCH_STADIUM = "stadion meczu";
	private JSONDataGate dataGate;
	int idMatch;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);

		Intent in = getIntent();
		String id = in.getStringExtra("id fazy");
		idMatch = Integer.parseInt(id);

		dataGate = new JSONDataGate();
		ArrayList<HashMap<String, String>> exampleItems = new ArrayList<HashMap<String, String>>();

		ArrayList<Match> matches = new ArrayList<Match>();
		try {
			matches = dataGate.getMatches(idMatch);
			for (int i = 0; i < matches.size(); i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(MATCH_ID, "" + matches.get(i).getId());
				map.put(MATCH_REP1, "" + matches.get(i).getRep1());
				map.put(MATCH_REP2, "" + matches.get(i).getRep2());
				map.put(MATCH_DATE, "" + matches.get(i).getDate());
				map.put(MATCH_SCORE, "" + matches.get(i).getScore());
				map.put(MATCH_STADIUM, "" + matches.get(i).getStadium());
				exampleItems.add(map);
			}

			ListAdapter listViewAdapter = new SimpleAdapter(this, exampleItems,
					R.layout.list_item_matches, new String[] { MATCH_ID,
							MATCH_REP1, MATCH_REP2, MATCH_DATE, MATCH_SCORE,
							MATCH_STADIUM }, new int[] { R.id.match_id,
							R.id.match_rep1, R.id.match_rep2, R.id.match_date,
							R.id.match_score, R.id.match_stadium, });
			setListAdapter(listViewAdapter);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

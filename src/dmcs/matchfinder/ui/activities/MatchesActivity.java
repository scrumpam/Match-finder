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
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import dmcs.matchfinder.engine.JSONDataGate;
import dmcs.matchfinder.googlemaps.GoogleMapActivity;
import dmcs.matchfinder.model.Match;
import dmcs.matchfinder.model.MatchLocation;

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
	private static final String TAG = MatchesActivity.class.getSimpleName();

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

			ListView lv = getListView();

			lv.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					ArrayList<MatchLocation> matchesLocation = new ArrayList<MatchLocation>();
					// getting values from selected ListItem
					String idMatch = ((TextView) view
							.findViewById(R.id.match_id)).getText().toString();
					Log.d(TAG, MATCH_ID + idMatch);

					try {
						// String sell = ((TextView)
						// view.findViewById(R.id.sell).getText().toString();

						// Starting new intent
						Toast.makeText(getApplicationContext(), "clik on"
								+ idMatch, Toast.LENGTH_LONG);

						/*
						 * ----------------Doda³em wyszukanie lokalizacji meczu
						 * po kliknieciu na elemetn listy
						 */

						matchesLocation = dataGate.getMatchLocation(Integer
								.parseInt(idMatch));
						double lat = Double.parseDouble(matchesLocation.get(0)
								.getLat());
						double lon = Double.parseDouble(matchesLocation.get(0)
								.getLon());

						Intent in = new Intent(getApplicationContext(),
								GoogleMapActivity.class);

						in.putExtra(MATCH_ID, idMatch);
						in.putExtra("lat", lat);
						in.putExtra("lon", lon);

						startActivity(in);
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
			});

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

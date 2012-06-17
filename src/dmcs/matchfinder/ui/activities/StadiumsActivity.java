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
import dmcs.matchfinder.model.Stadium;
import dmcs.matchfinder.model.StadiumLocation;

public class StadiumsActivity extends ListActivity {
	/** Called when the activity is first created. */
	// private final String PHASE_NAME = "nazwa fazy";
	// private final String PHASE_ID = "id fazy";
	// private JSONDataGate dataGate;
	//
	// @Override
	// public void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.main);
	//
	// dataGate = new JSONDataGate();
	// ArrayList<HashMap<String, String>> exampleItems = new
	// ArrayList<HashMap<String, String>>();
	//
	// ArrayList<Phase> phases = new ArrayList<Phase>();
	// try {
	// phases = dataGate.getPhases();
	// for (int i = 0; i < phases.size(); i++) {
	// HashMap<String, String> map = new HashMap<String, String>();
	// map.put(PHASE_ID, "id: "+phases.get(i).getId());
	// map.put(PHASE_NAME, phases.get(i).getName());
	// exampleItems.add(map);
	// }
	//
	// ListAdapter listViewAdapter = new SimpleAdapter(this, exampleItems,
	// R.layout.list_item_for_phases,
	// new String[] { PHASE_ID, PHASE_NAME }, new int[] {
	// R.id.phase_name, R.id.phase_id });

	private final String STADIUM_NAME = "nazwa stadionu";
	private final String STADIUM_ID = "id stadionu";
	private final String STADIUM_ADDRESS = "address stadionu";
	private JSONDataGate dataGate;
	private static final String TAG = StadiumsActivity.class.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.list_layout);
		dataGate = new JSONDataGate();
		ArrayList<HashMap<String, String>> exampleItems = new ArrayList<HashMap<String, String>>();

		ArrayList<Stadium> stadiums = new ArrayList<Stadium>();
		HashMap<String, HashMap<String, String>> locationsMap = new HashMap<String, HashMap<String, String>>();
		try {
			stadiums = dataGate.getStadiums();
			for (int i = 0; i < stadiums.size(); i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				// HashMap<String, String> a=new HashMap<String, String>(map);
				map.put(STADIUM_ID, "" + stadiums.get(i).getId());
				map.put(STADIUM_NAME, "" + stadiums.get(i).getName());
				map.put(STADIUM_ADDRESS, "" + stadiums.get(i).getAddress());
				exampleItems.add(map);
			}

			ListAdapter listViewAdapter = new SimpleAdapter(this, exampleItems,
					R.layout.list_item_stadiums, new String[] { STADIUM_ID,
							STADIUM_NAME, STADIUM_ADDRESS }, new int[] {
							R.id.stadium_id, R.id.stadium_name,
							R.id.stadium_address });
			setListAdapter(listViewAdapter);

			ListView lv = getListView();
			lv.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					try {
						
						ArrayList<StadiumLocation> stadiumLocation = new ArrayList<StadiumLocation>();
						// getting values from selected ListItem
						String idStadium = ((TextView) view
								.findViewById(R.id.stadium_id)).getText()
								.toString();
						Log.d(TAG, STADIUM_ID + idStadium);
						// String sell = ((TextView)
						// view.findViewById(R.id.sell).getText().toString();

						// Starting new intent
						Toast.makeText(getApplicationContext(), "clik on"
								+ idStadium, Toast.LENGTH_LONG);
						/* ----------------Doda³em wyszukanie lokalizacji stadionu po kliknieciu na element listy */
						stadiumLocation = dataGate.getStadiumLocation(Integer
								.parseInt(idStadium));
						double lat = Double.parseDouble(stadiumLocation.get(0)
								.getLat());
						double lon = Double.parseDouble(stadiumLocation.get(0)
								.getLon());

						Intent in = new Intent(getApplicationContext(),
								GoogleMapActivity.class);
						Log.d(TAG, "Po³ozenie stadionuuuuu ! : " + lat + " , "
								+ lon);
						
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
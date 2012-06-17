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
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import dmcs.matchfinder.engine.JSONDataGate;
import dmcs.matchfinder.model.MatchLocation;


public class MatchLocationActivity extends ListActivity {
    /** Called when the activity is first created. */
//	private final String PHASE_NAME = "nazwa fazy";
//	private final String PHASE_ID = "id fazy";
//	private JSONDataGate dataGate;
//	
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        
//        dataGate = new JSONDataGate();
//        ArrayList<HashMap<String, String>> exampleItems = new ArrayList<HashMap<String, String>>();
//
//        ArrayList<Phase> phases = new ArrayList<Phase>();
//		try {
//			phases = dataGate.getPhases();
//			for (int i = 0; i < phases.size(); i++) {
//	        	HashMap<String, String> map = new HashMap<String, String>();
//	        	map.put(PHASE_ID, "id: "+phases.get(i).getId());
//	        	map.put(PHASE_NAME, phases.get(i).getName());
//	        	exampleItems.add(map);
//	        }
//	        
//	        ListAdapter listViewAdapter = new SimpleAdapter(this, exampleItems, R.layout.list_item_for_phases,
//	        		new String[] { PHASE_ID, PHASE_NAME }, new int[] {
//					R.id.phase_name, R.id.phase_id });
	        
	
	
	
    
	private final String MATCH_LAT = "dl_geogr";
	private final String MATCH_LON = "sz_geogr";
	private final String MATCH_NAME = "nazwa stadionu";
	private final String MATCH_ADDRESS = "address stadionu";
	private JSONDataGate dataGate;
	int idMatch;
	private static final String TAG = MatchesActivity.class.getSimpleName();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
    	
    		setContentView(R.layout.list_layout);
    		dataGate = new JSONDataGate();
    		Intent in = getIntent();
        	String id = in.getStringExtra("id meczu");
        	idMatch = Integer.parseInt(id);
        	Log.d(TAG,"ID meczu dla lokalizacji "+ id);
            ArrayList<HashMap<String ,String>> exampleItems = new ArrayList<HashMap<String ,String>>();

            ArrayList<MatchLocation> matchesLocation = new ArrayList<MatchLocation>();
    		try {
    			matchesLocation = dataGate.getMatchLocation(idMatch);
    			
    			for (int i = 0; i < matchesLocation.size(); i++) {
    	        	HashMap<String, String> map = new HashMap<String, String>();
//    	        	HashMap<String, String> a=new HashMap<String, String>(map);
    	        	map.put(MATCH_LAT, ""+matchesLocation.get(i).getLat());
    	        	Log.d(TAG,"MATCH_LAT "+ matchesLocation.get(i).getLat());
    	        	map.put(MATCH_LON,""+matchesLocation.get(i).getLon());
    	        	Log.d(TAG,"MATCH_LOT "+ matchesLocation.get(i).getLon());
    	        	map.put(MATCH_NAME,""+matchesLocation.get(i).getName());
    	        	Log.d(TAG,"MATCH_NAME "+ matchesLocation.get(i).getName());
    	        	map.put(MATCH_ADDRESS,""+matchesLocation.get(i).getAddress());
    	        	Log.d(TAG,"MATCH_ADDRESS "+ matchesLocation.get(i).getAddress());
    	        	exampleItems.add(map);
    	        }
    	        
    	        ListAdapter listViewAdapter = new SimpleAdapter(this, exampleItems, R.layout.list_item_match_location,
    	        		new String[] { MATCH_LAT, MATCH_LON, MATCH_NAME,MATCH_ADDRESS }, new int[] {
    					R.id.matchlocation_lat, R.id.matchlocation_lon,R.id.matchlocation_name,R.id.matchlocation_address });
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
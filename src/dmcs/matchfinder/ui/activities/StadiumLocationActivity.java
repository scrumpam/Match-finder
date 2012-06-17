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
import dmcs.matchfinder.model.Stadium;
import dmcs.matchfinder.model.StadiumLocation;

public class StadiumLocationActivity extends ListActivity {
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
	        
	
	
	
    
	private final String STADIUM_LAT = "lat stadionu";
	private final String STADIUM_LON= "lon stadionu";
	
	private JSONDataGate dataGate;
	int idStadium;
	private static final String TAG = StadiumLocationActivity.class.getSimpleName();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
    	
    		setContentView(R.layout.list_layout);
    		dataGate = new JSONDataGate();
            ArrayList<HashMap<String ,String>> exampleItems = new ArrayList<HashMap<String ,String>>();
            
            
            Intent in = getIntent();
        	String id = in.getStringExtra("id stadionu");
        	idStadium = Integer.parseInt(id);
        	Log.d(TAG,"ID stadionu dla lokalizacji "+ id);
            ArrayList<StadiumLocation> stadiums = new ArrayList<StadiumLocation>();
    		try {
    			stadiums = dataGate.getStadiumLocation(idStadium);
    			for (int i = 0; i < stadiums.size(); i++) {
    	        	HashMap<String, String> map = new HashMap<String, String>();
//    	        	HashMap<String, String> a=new HashMap<String, String>(map);
    	        	map.put(STADIUM_LAT, ""+stadiums.get(i).getLat());
    	        	map.put(STADIUM_LON,""+stadiums.get(i).getLon());
    	        	
    	        	exampleItems.add(map);
    	        }
    	        
    	        ListAdapter listViewAdapter = new SimpleAdapter(this, exampleItems, R.layout.list_item_stadium_location,
    	        		new String[] { STADIUM_LAT, STADIUM_LON }, new int[] {
    					R.id.stadiumlocation_lat, R.id.stadiumlocation_lon});
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
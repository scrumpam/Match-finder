package my.finder.dmcs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;





import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class JSONActivityForStadiums extends ListActivity {
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
	        
	
	
	
    
	private final String STADIUM_NAME = "nazwa stadionu";
	private final String STADIUM_ID = "id stadionu";
	private final String STADIUM_ADDRESS = "address stadionu";
	private JSONDataGate dataGate;
	

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
    	
    		setContentView(R.layout.main);
    		dataGate = new JSONDataGate();
            ArrayList<HashMap<String ,String>> exampleItems = new ArrayList<HashMap<String ,String>>();

            ArrayList<Stadium> stadiums = new ArrayList<Stadium>();
    		try {
    			stadiums = dataGate.getStadiums();
    			for (int i = 0; i < stadiums.size(); i++) {
    	        	HashMap<String, String> map = new HashMap<String, String>();
//    	        	HashMap<String, String> a=new HashMap<String, String>(map);
    	        	map.put(STADIUM_ID, ""+stadiums.get(i).getId());
    	        	map.put(STADIUM_NAME,""+stadiums.get(i).getName());
    	        	map.put(STADIUM_ADDRESS,""+stadiums.get(i).getAddress());
    	        	exampleItems.add(map);
    	        }
    	        
    	        ListAdapter listViewAdapter = new SimpleAdapter(this, exampleItems, R.layout.list_item_for_stadiums,
    	        		new String[] { STADIUM_ID, STADIUM_NAME,STADIUM_ADDRESS }, new int[] {
    					R.id.stadium_id, R.id.stadium_name,R.id.stadium_address });
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
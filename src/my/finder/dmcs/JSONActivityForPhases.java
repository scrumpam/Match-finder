package my.finder.dmcs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;







import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;



import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class JSONActivityForPhases extends ListActivity {
    /** Called when the activity is first created. */
	private final String PHASE_NAME = "nazwa fazy";
	private final String PHASE_ID = "id fazy";
	private JSONDataGate dataGate;
	 private static final String TAG = JSONActivityForPhases.class.getSimpleName();
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        dataGate = new JSONDataGate();
        ArrayList<HashMap<String, String>> exampleItems = new ArrayList<HashMap<String, String>>();

        ArrayList<Phase> phases = new ArrayList<Phase>();
		try {
			phases = dataGate.getPhases();
			for (int i = 0; i < phases.size(); i++) {
	        	HashMap<String, String> map = new HashMap<String, String>();
	        	map.put(PHASE_ID,""+phases.get(i).getId());
	        	map.put(PHASE_NAME, phases.get(i).getName());
	        	exampleItems.add(map);	        	
	        }
	        
	        ListAdapter listViewAdapter = new SimpleAdapter(this, exampleItems, R.layout.list_item_for_phases,
	        		new String[] { PHASE_NAME, PHASE_ID }, new int[] {
					R.id.phase_name, R.id.phase_id });
	   setListAdapter(listViewAdapter);
	   ListView lv = getListView();

		lv.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				String idPhase = ((TextView) view.findViewById(R.id.phase_id)).getText().toString();
				 Log.d(TAG, idPhase);
//				String sell = ((TextView) view.findViewById(R.id.sell).getText().toString();
				
				// Starting new intent
				Toast.makeText(getApplicationContext(), "clik on" + idPhase, Toast.LENGTH_LONG);
				
				
				Intent in = new Intent(getApplicationContext(), JSONActivityForMatchesInPhases.class);
				in.putExtra(PHASE_ID, idPhase);
				

				
				startActivity(in);

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
	
    }}	
	
    
	

	

	

    

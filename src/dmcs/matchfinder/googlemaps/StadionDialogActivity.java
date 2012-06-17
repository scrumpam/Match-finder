package dmcs.matchfinder.googlemaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import matchfinder.ui.activites.R;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class StadionDialogActivity extends ListActivity{
	
	private static final String MATCH_TEAM1 = "team1";
	private static final String MATCH_TEAM2 = "team2";
	private static final String MATCH_RESULT = "resutl";
	private static final String MATCH_DATE = "date";
	
	List<HashMap<String,String>> myItems = new ArrayList<HashMap<String,String>>();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.stadion_dialog);
		
		
		ListAdapter listViewAdapter = new SimpleAdapter(this, myItems, R.layout.stadion_dialog_macht_item, new String[]{"MATCH_TEAM1","MATCH_TEMA2","MATCH_RESULT","MATCH_DATE"}, new int[]{R.id.team1,R.id.team2,R.id.result, R.id.date});
		setListAdapter(listViewAdapter);
	}
}

package dmcs.matchfinder.googlemaps;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MyItemizedOverlay extends ItemizedOverlay<OverlayItem> {

	private ArrayList<OverlayItem> myOverlays = new ArrayList<OverlayItem>();;
	Context mContext;

	public MyItemizedOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
		populate();
	}

	public MyItemizedOverlay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		mContext = context;
	}

	public void addOverlay(OverlayItem overlay) {
		myOverlays.add(overlay);
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return myOverlays.get(i);
	}

	// Removes overlay item i
	public void removeItem(int i) {
		myOverlays.remove(i);
		populate();
	}

	@Override
	/*
	 * public boolean onTap(int i){
	 * 
	 * System.out.println("On tap event ! "); GeoPoint p =
	 * myOverlays.get(i).getPoint(); double x = p.getLatitudeE6(); double y =
	 * p.getLongitudeE6(); Toast.makeText(GoogleMapActivity.context, "Cost",
	 * Toast.LENGTH_LONG).show();
	 * 
	 * return true; }
	 */
	protected boolean onTap(int index) {
		OverlayItem item = myOverlays.get(index);

		AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
		// Start intecji ktory wyswietla szczego³owe informacje o stadionie
		/*
		 * Intent myIntent = new Intent(mContext, StadionDialogActivity.class);
		 * mContext.startActivity(myIntent); return true;
		 */
	}

	@Override
	public int size() {
		return myOverlays.size();
	}

}

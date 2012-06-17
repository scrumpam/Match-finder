package dmcs.matchfinder.googlemaps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import dmcs.matchfinder.engine.JSONDataGate;
import dmcs.matchfinder.model.Stadium;
import dmcs.matchfinder.model.StadiumLocation;
import dmcs.matchfinder.ui.activities.StadiumLocationActivity;
import matchfinder.ui.activites.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

public class GoogleMapActivity extends MapActivity {

	private final String STADIUM_LAT = "lat stadionu";
	private final String STADIUM_LON = "lon stadionu";

	private JSONDataGate dataGate;
	int idStadium;
	private static final String TAG = GoogleMapActivity.class.getSimpleName();

	MapView mapView;
	MapController mc;
	GeoPoint p;
	List<Overlay> mapOverlays;
	MyItemizedOverlay overlays;
	static Context context;
	Drawable drawable1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.map);
		dataGate = new JSONDataGate();
		Intent in = getIntent();
		double lat = in.getDoubleExtra("lat", 0);
		double lon = in.getDoubleExtra("lon", 0);
		Log.d(TAG, "Lokalizacjaaaaa!!!!!!  " + lat);

		Log.d(TAG, "Latitude stadionu : " + lat);
		Log.d(TAG, "Longitude stadionu : " + lon);

		context = getApplicationContext();
		mapView = (MapView) findViewById(R.id.mapview);

		mapView.setBuiltInZoomControls(true);

		mc = mapView.getController();
		p = new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));

		mc.animateTo(p);
		mc.setZoom(17);

		drawable1 = this.getResources().getDrawable(R.drawable.marker_s);
		mapOverlays = mapView.getOverlays();
		OverlayItem overlayItem = new OverlayItem(p, "Stadion", "Po³o¿enie : "
				+ lat + " , " + lon);
		overlays = new MyItemizedOverlay(drawable1, this);
		overlays.addOverlay(overlayItem);

		mapOverlays.add(overlays);

		mapView.postInvalidate();
		/*
		 * } catch (ClientProtocolException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch
		 * (JSONException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}

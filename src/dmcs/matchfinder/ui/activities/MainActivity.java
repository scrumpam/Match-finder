package dmcs.matchfinder.ui.activities;

import matchfinder.ui.activites.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button findAMatch;
	private Button findAStadium;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		findAMatch = ((Button) findViewById(R.id.button1));
		findAStadium = ((Button) findViewById(R.id.button2));
		Button[] buttons = new Button[2];
		buttons[0] = findAMatch;
		buttons[1] = findAStadium;

		for (int i = 0; i < 2; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener()

			{
				public void onClick(View v) {
					if (v.getId() == R.id.button1) {
						startActivity(new Intent(MainActivity.this,
								PhasesActivity.class));

					}
					if (v.getId() == R.id.button2) {

						startActivity(new Intent(MainActivity.this,
								StadiumsActivity.class));
					}

				}
			});
		}

	}
}

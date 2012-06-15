package my.finder.dmcs;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionScreen extends Activity {
	
	private Button findAMatch;
    private Button findAStadium;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        
        
        findAMatch=((Button) findViewById(R.id.button1));
        findAStadium=((Button) findViewById(R.id.button2));
        Button[] buttons = new Button[2];
        buttons[0]=findAMatch;
        buttons[1]=findAStadium;
        
        
        for(int i=0;i<2;i++)
        {
        	buttons[i].setOnClickListener(new View.OnClickListener()
       	 
       	 {
       		 public void onClick(View v) 
       		 {
       			if(v.getId()==R.id.button1)
       			{
       			startActivity(new Intent(SelectionScreen.this, JSONActivityForPhases.class));
              	 	        	 	             	
              	}
       			if (v.getId()==R.id.button2)
       			{
       				
       				startActivity(new Intent(SelectionScreen.this, JSONActivityForStadiums.class));
       			}
       			    		     		 
       		 }
       	});	}
        
        
        
	}
}

package com.softinus.most;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.softinus.util.ActivitySplitAnimationUtil;

public class LogoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
		
		findViewById(R.id.root1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivitySplitAnimationUtil.startActivity(LogoActivity.this, new Intent(LogoActivity.this, SearchActivity.class));
            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.logo, menu);
		return true;
	}

}

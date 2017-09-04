package com.darwinlabs.darwintask;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentReplacer extends AppCompatActivity {

    TextView  tooltv;
    ImageView tooliv;
    Toolbar secondtool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_replacer);
        String s = getIntent().getStringExtra("send");
        secondtool = (Toolbar)findViewById(R.id.secondtoolbar);
        tooltv = (TextView)findViewById(R.id.secondToolTextView);
        tooliv = (ImageView) findViewById(R.id.secondToolImgView);
        if (s.contains("send"))
        {
            secondtool.setVisibility(View.VISIBLE);
            tooltv.setText("SEND");
            FragmentManager fragmentManager = FragmentReplacer.this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Send fragment = new Send();
            fragmentTransaction.add(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if (s.contains("buysell"))
        {
            secondtool.setVisibility(View.VISIBLE);
            tooltv.setText("ENTER PIN");
            FragmentManager fragmentManager = FragmentReplacer.this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            EnterPin fragment = new EnterPin();
            fragmentTransaction.add(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }else if (s.contains("receive"))
        {
            secondtool.setVisibility(View.VISIBLE);
            tooltv.setText("RECEIVE");
            FragmentManager fragmentManager = FragmentReplacer.this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Receive fragment = new Receive();
            fragmentTransaction.add(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        tooliv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FragmentReplacer.this,Home.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        secondtool.setVisibility(View.GONE);

        Intent i = new Intent(FragmentReplacer.this,Home.class);
        finish();
        startActivity(i);
        super.onBackPressed();
    }
}

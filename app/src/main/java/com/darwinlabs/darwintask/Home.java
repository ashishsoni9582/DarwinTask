package com.darwinlabs.darwintask;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActionBarDrawerToggle toggle;
    ScrollView scrollview;
    ImageButton receiveBtn, sendBtn,buySellBtn;
FrameLayout fragment_container;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
fragment_container = (FrameLayout)findViewById(R.id.contentContainer);
        receiveBtn = (ImageButton)findViewById(R.id.receivebutton);
        sendBtn = (ImageButton)findViewById(R.id.sendbutton);
        buySellBtn = (ImageButton)findViewById(R.id.buysellbutton);

        scrollview = (ScrollView) findViewById(R.id.scroll_view_main);
          toolbar = (Toolbar) findViewById(R.id.toolbar);
         String text = "<font color=#4e4e4e >Ledger</font> <font color=#3d6b99 size=100>EX</font>";
        toolbar.setTitle(Html.fromHtml(text));
        setSupportActionBar(toolbar);
         final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_Layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
         toggle.setHomeAsUpIndicator(R.drawable.menuicon);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        scrollview.setVerticalScrollbarPosition(View.SCROLLBAR_POSITION_LEFT);

        receiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Home.this,FragmentReplacer.class);
                i.putExtra("send","receive");
                startActivity(i);
            }
        });
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,FragmentReplacer.class);
                i.putExtra("send","send");
                startActivity(i);

            }
        });
        buySellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,FragmentReplacer.class);
                i.putExtra("send","buysell");
                startActivity(i);
            }
        });

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_Layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }
    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Nodata) {
            Toast.makeText(this, " Don't Have Data ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.Nodata2) {
            Toast.makeText(this, " It also Don't Have Data  ", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_Layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

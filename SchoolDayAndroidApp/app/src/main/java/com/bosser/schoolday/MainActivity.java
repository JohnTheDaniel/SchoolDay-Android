package com.bosser.schoolday;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Outline;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private ActionBarDrawerToggle drawerToggle;
    boolean useNavigationDrawer = true;
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(useNavigationDrawer){
            setContentView(R.layout.activity_main_drawer);
        }else {
            setContentView(R.layout.activity_main_spinner);
        }
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        //toolbar.setLogo(R.drawable.ic_launcher);
        setSupportActionBar(toolbar);


        if(useNavigationDrawer){
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
            mDrawerLayout.setDrawerListener(drawerToggle);
        }

        Button fab = (Button) findViewById(R.id.fabbutton);

        Outline mOutlineCircle;
        //int shapeSize = getResources().getDimensionPixelSize(R.dimen.shape_size);
        mOutlineCircle = new Outline();
        //mOutlineCircle.setRoundRect(0, 0, shapeSize, shapeSize, shapeSize / 2);

        //fab.setOutLine(mOutlineCircle);
        fab.setClipToOutline(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        /*if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }    */
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(useNavigationDrawer) {
            drawerToggle.syncState();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(useNavigationDrawer) {
            drawerToggle.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(Gravity.LEFT|Gravity.START))   {
            mDrawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }
}

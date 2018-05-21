package com.example.avenflar.formula1.com.example.formula1.Activites;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.avenflar.formula1.R;
import com.example.avenflar.formula1.com.example.formula1.Onglets.PageAdapter;

import static com.example.avenflar.formula1.com.example.formula1.Activites.activity_home.mediaPlayer;

public class ResultsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setTitle(R.string.results);


        //Configure ViewPager
        this.configureViewPagerAndTabs();
    }

    private void configureViewPagerAndTabs(){
        //Get ViewPager from layout
        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
        //Set Adapter PageAdapter and glue it together
        pager.setAdapter(new PageAdapter(getSupportFragmentManager()));

        //Get TabLayout from layout
        TabLayout tabs= (TabLayout)findViewById(R.id.activity_main_tabs);
        //Glue TabLayout and ViewPager together
        tabs.setupWithViewPager(pager);
        //Design purpose. Tabs have the same width
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Home :
                Intent intent = new Intent(ResultsActivity.this,activity_home.class);
                startActivity(intent);
                return true;
            case R.id.Music :
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    item.setIcon(R.drawable.ic_stop);
                }
                else {
                    mediaPlayer.start();
                    item.setIcon(R.drawable.ic_play_arrow);
                }
                return true;
            case R.id.Quit :
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.quit);
                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),getString(R.string.onclickquit),Toast.LENGTH_LONG).show();
                        System.exit(0);
                    }
                });
                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),getString(R.string.onclicknotquit),Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(!mediaPlayer.isPlaying()) {
            menu.getItem(1).setIcon(R.drawable.ic_stop);
        }
        return true;
    }
}

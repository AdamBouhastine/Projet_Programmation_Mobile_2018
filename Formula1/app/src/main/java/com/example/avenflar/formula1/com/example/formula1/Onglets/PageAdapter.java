package com.example.avenflar.formula1.com.example.formula1.Onglets;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.avenflar.formula1.com.example.formula1.Onglets.Fragments.ResultsDriversFragment2018;
import com.example.avenflar.formula1.com.example.formula1.Onglets.Fragments.ResultsTeamsFragment2018;

public class PageAdapter extends FragmentPagerAdapter {


    //Default Constructor
    public PageAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return(2);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: //Page number 1
                return ResultsTeamsFragment2018.newInstance();
           case 1: //Page number 2
               return ResultsDriversFragment2018.newInstance();

            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: //Page number 1
                return "Ecuries";
            case 1: //Page number 2
               return "Pilotes";
            default:
                return null;
        }
    }
}

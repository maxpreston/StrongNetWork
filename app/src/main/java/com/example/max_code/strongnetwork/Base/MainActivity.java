package com.example.max_code.strongnetwork.Base;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.example.max_code.strongnetwork.Fragments.MainFragment;
import com.example.max_code.strongnetwork.Fragments.MainFragment2;
import com.example.max_code.strongnetwork.Fragments.MainFragment3;
import com.example.max_code.strongnetwork.Fragments.MainFragment4;
import com.example.max_code.strongnetwork.Fragments.MainFragment5;
import com.example.max_code.strongnetwork.Fragments.MainFragment6;
import com.example.max_code.strongnetwork.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.main_fragment_tbar)
    Toolbar toolbar;
    @Bind(R.id.main_fragment_tlayout)
    TabLayout tableLayout;
    @Bind(R.id.main_fragment_vp)
    ViewPager vp;
    List<Fragment> list = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list.add(new MainFragment());
        list.add(new MainFragment2());
        list.add(new MainFragment3());
        list.add(new MainFragment4());
        list.add(new MainFragment5());
        list.add(new MainFragment6());
        setSupportActionBar(toolbar);
        vp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                   return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch(position){
                    case 0:
                        return getString(R.string.one);

                    case 1:
                        return getString(R.string.two);

                    case 2:
                        return getString(R.string.three);

                    case 3:
                        return getString(R.string.four);

                    case 4:
                        return getString(R.string.five);

                    case 5:
                        return getString(R.string.six);

                    default:
                        return getString(R.string.one);

                }
            }
        });

        tableLayout.setupWithViewPager(vp);
    }
}

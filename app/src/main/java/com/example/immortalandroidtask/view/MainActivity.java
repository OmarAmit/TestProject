package com.example.immortalandroidtask.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.example.immortalandroidtask.FragmentCollectionAdatpor;
import com.example.immortalandroidtask.MainAdapter;
import com.example.immortalandroidtask.Model.MainModel;
import com.example.immortalandroidtask.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DashboardFragment dashboardFragment;
    private ProfileFragment profileFragment;
    private SettingFragment settingFragment;
    private RecyclerView recyclerView;
    private ArrayList<MainModel> modelArrayList;
    private MainAdapter mainAdapter;
    private FragmentCollectionAdatpor adatpor;
    private Context context;
    private FloatingActionButton fb;
    Integer[] langLong = {R.drawable.turtleorange, R.drawable.turtleblur, R.drawable.turtleblur, R.drawable.turtleblur};
    String[] langName = {"your", "Know you", "Know you", "your"};
    String[] langtype = {"Info", "better", "risk", "family"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        init();
        setrecyclerAdapter();
        setdatatoview();

        SpaceNavigationView spaceNavigationView = findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.showIconOnly();

        spaceNavigationView.addSpaceItem(new SpaceItem("Dashboard", R.drawable.ic_dashboard_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("Profile", R.drawable.ic_person_black_24dp));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                setFragment(settingFragment);

                Toast.makeText(MainActivity.this, "on central button", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {

                switch (itemIndex) {
                    case 0:
                        //   setFragment(dashboardFragment);
                        Toast.makeText(MainActivity.this, "On item1", Toast.LENGTH_SHORT).show();
                        return;
                    case 1:
                        //   setFragment(profileFragment);
                        Toast.makeText(MainActivity.this, "On item2", Toast.LENGTH_SHORT).show();
                        return;
                    default:
                        //   setFragment(dashboardFragment);
                        Toast.makeText(MainActivity.this, "On item Default", Toast.LENGTH_SHORT).show();
                        return;
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(MainActivity.this, "On item Rresesletd", Toast.LENGTH_SHORT).show();
            }
        });

//        fb.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @SuppressLint("RestrictedApi")
//            @Override
//            public void onGlobalLayout() {
//                BadgeDrawable badgeDrawable = BadgeDrawable.create(MainActivity.this);
//                badgeDrawable.setNumber(2);
//                //Important to change the position of the Badge
//                badgeDrawable.setHorizontalOffset(30);
//                badgeDrawable.setVerticalOffset(20);
//
//                BadgeUtils.attachBadgeDrawable(badgeDrawable, fb, null);
//
//                fb.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//            }
//        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void fabbutton(View view) {
        Toast.makeText(this, "Message icon", Toast.LENGTH_SHORT).show();
    }


    public void init() {
        dashboardFragment = new DashboardFragment();
        profileFragment = new ProfileFragment();
        settingFragment = new SettingFragment();
        adatpor = new FragmentCollectionAdatpor(getSupportFragmentManager());
        recyclerView = findViewById(R.id.recyclerview);
    }

    private void setrecyclerAdapter() {
        modelArrayList = new ArrayList<MainModel>();
        mainAdapter = new MainAdapter(context, modelArrayList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 4);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mainAdapter);
    }

    private void setdatatoview() {
        for (int i = 0; i < langLong.length; i++) {
            MainModel model = new MainModel(langLong[i], langName[i],langtype[i]);
            modelArrayList.add(model);
        }
    }
}
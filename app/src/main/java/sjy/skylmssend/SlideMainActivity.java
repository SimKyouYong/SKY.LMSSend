package sjy.skylmssend;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import co.kr.sky.AccumThread;
import sjy.skylmssend.common.CircleImageView;
import sjy.skylmssend.common.CommonUtil;
import sjy.skylmssend.fragment.LMSFragment;


public class SlideMainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Handler mHandler;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private View navHeader;
    private CircleImageView my_img, slide_imageView;
    private LinearLayout my_profile;
    private Boolean cal_list_flag = false;
    private ImageView cal_flag;
    private TextView slide_project_name_txt , my_email ,my_name , main_title;
    private LinearLayout slide_menu1, slide_menu2;
    public static String Year;
    public static String Month;
    public static String Day;
    private CommonUtil dataSet = CommonUtil.getInstance();
    protected ProgressDialog  customDialog = null;

    Activity av;
    Context cv;

    // index to identify current nav menu item
    public static int navItemIndex = 0;
    private AccumThread mThread;
    private Map<String, String> map = new HashMap<String, String>();


    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_HISTORY = "in_out_history";
    private static final String TAG_MOVIES = "movies";
    private static final String TAG_NOTIFICATIONS = "notifications";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;
    private Date d = new Date();


    LMSFragment homeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slidemain_late);
        Init();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    private void Init() {

        av                          = this;
        cv                          = this;
        mHandler                    = new Handler();
        drawer                      = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView              = (NavigationView) findViewById(R.id.nav_view);
        slide_imageView             = (CircleImageView) findViewById(R.id.slideimage);
        my_profile                  = (LinearLayout) findViewById(R.id.my_profile);
        slide_menu1                 = (LinearLayout) findViewById(R.id.slide_menu1);
        slide_menu2                 = (LinearLayout) findViewById(R.id.slide_menu2);
        my_name                     = (TextView) findViewById(R.id.my_name);
        my_email                    = (TextView) findViewById(R.id.my_email);
        main_title                  = (TextView) findViewById(R.id.main_title);

        // Navigation view header
        navHeader                   = navigationView.getHeaderView(0);

        findViewById(R.id.slide).setOnClickListener(btnListener);
        findViewById(R.id.my_profile).setOnClickListener(btnListener);
        findViewById(R.id.slide_menu1).setOnClickListener(btnListener);
        findViewById(R.id.slide_menu2).setOnClickListener(btnListener);

        setUpNavigationView();
    }
    //버튼 리스너 구현 부분
    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.slide:
                    Log.e("SKY", "-- slide --");
                    drawer.openDrawer(navigationView);
                    break;
                case R.id.slide_menu1:          //프로젝트 선택 화면 이동
                    Log.e("SKY", "-- slide_menu1 --");
                    drawer.closeDrawer(GravityCompat.START);
                    break;
                case R.id.slide_menu2:          //입퇴장 관리 화면 이동
                    Log.e("SKY", "-- slide_menu2 --");
                    cal_list_flag = false;
                    drawer.closeDrawer(GravityCompat.START);
                    break;
                case R.id.my_profile:
                    Log.e("SKY", "-- my_profile --");
                    break;

            }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("SKY" , "requestCode ::" + requestCode);
        Log.e("SKY" , "resultCode ::" + resultCode);
        if (requestCode == 1000) {
            //프로젝트 선택후 처리
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
        } else {
        }
    }
    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
//                    case R.id.nav_photos:
//                        navItemIndex = 1;
//                        CURRENT_TAG = TAG_PHOTOS;
//                        break;
//                    case R.id.nav_movies:
//                        navItemIndex = 2;
//                        CURRENT_TAG = TAG_MOVIES;
//                        break;
//                    case R.id.nav_notifications:
//                        navItemIndex = 3;
//                        CURRENT_TAG = TAG_NOTIFICATIONS;
//                        break;
//                    case R.id.nav_settings:
//                        navItemIndex = 4;
//                        CURRENT_TAG = TAG_SETTINGS;
//                        break;
                    default:
                        navItemIndex = 0;
                }
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();
                return true;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };
        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);
        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }
    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }


        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        //invalidateOptionsMenu();
    }
    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home
                homeFragment = new LMSFragment(av , cv);
                return homeFragment;
//            case 1:
//                // photos
////                HistoryFragment photosFragment = new HistoryFragment(av , cv);
////                return photosFragment;
//            case 2:
//                // movies fragment
//                MoviesFragment moviesFragment = new MoviesFragment();
//                return moviesFragment;
//            case 3:
//                // notifications fragment
//                NotificationsFragment notificationsFragment = new NotificationsFragment();
//                return notificationsFragment;
//            case 4:
//                // settings fragment
//                SettingsFragment settingsFragment = new SettingsFragment();
//                return settingsFragment;
            default:
                return new LMSFragment(av , cv);
        }
    }
    public void customProgressPop(){
        try{
            if (customDialog==null){
                customDialog = new ProgressDialog( this , ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
                customDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                customDialog.setMessage("로딩중 입니다.");
                customDialog.setCancelable(false);
                customDialog.show();
            }
        }catch(Exception ex){}
    }
    public void customProgressClose(){
        if (customDialog!=null && customDialog.isShowing()){
            try{
                customDialog.cancel();
                customDialog.dismiss();
                customDialog = null;
            }catch(Exception e)
            {}
        }
    }
}

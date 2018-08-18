package com.example.adib.test;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.adib.test.App.FirstActivity;
import com.example.adib.test.App.Target_Activity;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class Start_Activity extends FragmentActivity {

    ViewPager ViewPager=null;

    AdapterStart myadapter=null;

    NavigationTabStrip nts=null;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInAccount account;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_);

        ViewPager =  findViewById(R.id.viewpager);

        FragmentManager fragmentManager=getSupportFragmentManager();

        myadapter=new AdapterStart(fragmentManager);

        ViewPager.setAdapter(myadapter);


        ViewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                IBinder binder = view.getWindowToken();
                inputManager.hideSoftInputFromWindow(binder,InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        nts =  findViewById(R.id.nts);

        nts.setViewPager(ViewPager, 2);

//        final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts);
//        navigationTabStrip.setTitles("Nav", "Tab", "Strip");
//        navigationTabStrip.setTabIndex(0, true);
        nts.setTitleSize(40);
//        navigationTabStrip.setStripColor(Color.RED);
//        navigationTabStrip.setStripWeight(6);
//        navigationTabStrip.setStripFactor(2);
//        navigationTabStrip.setStripType(NavigationTabStrip.StripType.LINE);
//        navigationTabStrip.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
//        navigationTabStrip.setTypeface("fonts/typeface.ttf");
//        navigationTabStrip.setCornersRadius(3);
        nts.setAnimationDuration(250);
//        navigationTabStrip.setInactiveColor(Color.GRAY);
//        navigationTabStrip.setActiveColor(Color.WHITE);
//        navigationTabStrip.setOnPageChangeListener(...);
      //  nts.setOnTabStripSelectedIndexListener(mViewPager.);


        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        account = GoogleSignIn.getLastSignedInAccount(this);

    }

    public void clicksignin(View view) {
        Log.e("sf","sdgfsdgf");
        signIn();
        this.finish();
    }


    int RC_SIGN_IN=10;
    private void signIn()
    {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            account = completedTask.getResult(ApiException.class);
            Toast.makeText(this,"Name:"+account.getDisplayName(),Toast.LENGTH_LONG).show();
            Toast.makeText(this,"Email:"+account.getEmail(),Toast.LENGTH_LONG).show();
            Toast.makeText(this,"GivenName:"+account.getGivenName(),Toast.LENGTH_LONG).show();
            // Signed in successfully, show authenticated UI.
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(this,"he reject your request",Toast.LENGTH_LONG).show();
        }
    }


    public void clicksigninbut(View view)
    {
        Bundle bundle=new Bundle();
        bundle.putBoolean("isstart",true);
        Intent intent = new Intent(this,Target_Activity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }


    public void clickloginbut(View view)
    {
        Bundle bundle=new Bundle();
        bundle.putBoolean("isstart",false);
        Intent intent = new Intent(this,FirstActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }


}


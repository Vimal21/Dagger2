package com.vimal.dagger2;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vimal.dagger2.data.DataManager;
import com.vimal.dagger2.data.model.User;
import com.vimal.dagger2.di.component.ActivityComponent;
import com.vimal.dagger2.di.component.DaggerActivityComponent;
import com.vimal.dagger2.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    DataManager dataManager;

    private ActivityComponent activityComponent;

    private TextView mTvUserInfo, mTvAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().Inject(this);

        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);
    }

    public ActivityComponent getActivityComponent(){
        if(activityComponent == null){
            activityComponent = DaggerActivityComponent
                    .builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(AppController.get(this).getApplicationComponent())
                    .build();
        }

        return activityComponent;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getuser();
        dataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = dataManager.getAccessToken();
        if(token!=null)
            mTvAccessToken.setText(token);
    }

    private void getuser() {
        try{
            User user = dataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createUser() {
        try{
            dataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

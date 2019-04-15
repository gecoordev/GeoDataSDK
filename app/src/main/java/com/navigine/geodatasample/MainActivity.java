package com.navigine.geodatasample;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.navigine.geodatasdk.GeoDataSdk;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback
{
  static final int REQUEST_CODE = 101;
  
  static final long SERVICE_INTERVAL = 60 * 1000;
  static final long UPLOAD_INTERVAL = 60 * 60 * 1000;
  
  static final String HOST = null;
  static final String USER_HASH = null;
  static final String API_KEY = null;
  
  private TextView mStatusTextView;
  
  @Override protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    mStatusTextView = findViewById(R.id.main__status);
  
    if (checkPermission())
    {
      initialize();
    }
    else
    {
      ActivityCompat
        .requestPermissions(this,
                            new String[] { Manifest.permission.ACCESS_FINE_LOCATION,
                              Manifest.permission.ACCESS_COARSE_LOCATION },
                            REQUEST_CODE);
    }
  }
  
  @Override public void onRequestPermissionsResult(int requestCode,
                                                   @NonNull String[] permissions,
                                                   @NonNull int[] grantResults)
  {
    switch (requestCode)
    {
      case REQUEST_CODE:
        if (checkPermission())
          initialize();
    }
  }
  
  public boolean checkPermission()
  {
    return
      ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) ==
        PackageManager.PERMISSION_GRANTED &&
      ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)   ==
        PackageManager.PERMISSION_GRANTED;
  }
  
  public void initialize()
  {
    Context context = getApplicationContext();
    GeoDataSdk.setServiceInterval(context, SERVICE_INTERVAL);
    GeoDataSdk.setUploadInterval(context, UPLOAD_INTERVAL);
    boolean isInitialized = GeoDataSdk.initialize(context, HOST, USER_HASH, API_KEY);
    
    mStatusTextView.setText(isInitialized ? "Service started successfully"
                                          : "Could not start service");
  }
}

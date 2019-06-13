# GeoDataSDK

## Overview

GeoDataSDK provides service, that periodically collects GPS coordinates and uploads them to remote server. It requires `Manifest.permission.ACCESS_COARSE_LOCATION` and `Manifest.permission.ACCESS_FINE_LOCATION` permissions to work in your application.

The service takes GPS coordinates from `LocationManager.GPS_PROVIDER` and `LocationManager.NETWORK_PROVIDER` and stores them in cache. By default, service starts every minute and uploads batched coordinates every hour. Documentation for GeoDataSDK public interface can be found [here](https://github.com/gecoordev/GeoDataSDK/wiki).

## GeoDataSample app

GeoDataSample app shows basic usage of GeoDataSDK. It requests required permission and initializing SDK.

## Usage

1. Download [aar](https://github.com/gecoordev/GeoDataSDK/blob/master/app/libs/GeoDataSDK.aar?raw=true) to your app's `libs` folder;
2. Add `flatDir { dirs 'libs' }` to your project level `build.gradle` file:
```
allprojects {
   repositories {
      ...
      flatDir { dirs 'libs' }
   }
}
```
3. Add `implementation(name: 'GeoDataSDK', ext:'aar')` to your app level `build.gradle` file:
```
dependencies {
    ...
    implementation(name: 'GeoDataSDK', ext:'aar')
}
```
4. Request `Manifest.permission.ACCESS_COARSE_LOCATION` and `Manifest.permission.ACCESS_FINE_LOCATION` permissions;
5. Initialize SDK with `GeoDataSdk.initialize(Context context, String apiKey)` method.

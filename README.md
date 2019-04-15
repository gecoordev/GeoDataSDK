# GeoDataSDK

## Overview

GeoDataSDK provides service, that periodically collects GPS coordinates and uploads them to remote server. It requires `Manifest.permission.ACCESS_COARSE_LOCATION` and `Manifest.permission.ACCESS_FINE_LOCATION` permissions to work in your application.

The service takes GPS coordinates from `LocationManager.GPS_PROVIDER` and `LocationManager.NETWORK_PROVIDER` and stores them in cache. By default, service starts every minute and uploads batched coordinates every hour. You can specify these intervals with following methods:

```java
GeoDataSdk.setServiceInterval(Context context, long millis);
```

```java
GeoDataSdk.setUploadInterval(Context context, long millis);
```
* `context` - application context;
* `millis` - interval time in milliseconds.

SDK initializes with method:

```java
GeoDataSdk.initialize(Context context, String host, String userHash, String apiKey)
```
* `context` - application context;
* `host` - server URL (in format: `http[s]://host[:port]`);
* `userHash` - user security key;
* `apiKey` - application security key.

To stop service use method:
```java
GeoDataSdk.finish(Context context)
```
* `context` - application context.

The service will restart automatically after device reboot or application re-installation.

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
5. Initialize SDK with `GeoDataSdk.initialize(Context context, String host, String userHash, String apiKey)` method.

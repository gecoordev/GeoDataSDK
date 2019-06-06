# Back log of changes in GeoDataSDK library

## Version 1.0.2

* Added method:
```java
GeoDataSdk.setDebugEnabled(Context context, boolean enabled)
```

## Version 1.0.1

* `GeoDataSdk.initialize` method's parameters changed from:
```java
GeoDataSdk.initialize(Context context, String host, String userHash, String apiKey)
```
to:
```java
GeoDataSdk.initialize(Context context, String apiKey)
```
* `apiKey` parameter in `GeoDataSdk.initialize` must not be `null`

## Version 1.0.0

* Fixed bug with showing service notification
* Fixed bug with service starting after disabling it
* Added following methods in `GeoDataSdk` class:
```java
setServiceInterval(Context context, long millis)
setUploadInterval(Context context, long millis)
setStatisticsEnabled(Context context, boolean enabled)
```
* Renamed library package name

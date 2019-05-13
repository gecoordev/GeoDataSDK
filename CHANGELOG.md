# Back log of changes in GeoDataSDK library

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

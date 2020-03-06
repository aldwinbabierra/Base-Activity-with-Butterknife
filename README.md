# BaseActivity with Butterknife

*Latest version:*

[![](https://api.bintray.com/packages/aldwinb16/BaseActivity-with-Butterknife/libs.aldwinbabierra.baseactivity/images/download.svg) ](https://bintray.com/aldwinb16/BaseActivity-with-Butterknife/libs.aldwinbabierra.baseactivity/_latestVersion)
[![](https://jitpack.io/v/aldwinbabierra/Base-Activity-with-Butterknife.svg)](https://jitpack.io/#aldwinbabierra/Base-Activity-with-Butterknife)


__Project-level Gradle:__
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
		...
	}
}
```


__App-level Gradle:__ 
```
android {
	compileOptions {
		sourceCompatibility JavaVersion.VERSION_1_8
		targetCompatibility JavaVersion.VERSION_1_8
	}
}
```

```
dependencies {
	...
	implementation 'com.jakewharton:butterknife:10.2.1'
	annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.1'
	implementation 'libs.aldwinbabierra:baseactivitywithbk:$latestVersion'
}
```

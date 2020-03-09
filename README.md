# BaseActivity with ButterKnife

*Latest version:*

[ ![](https://api.bintray.com/packages/aldwinb16/BaseActivityWithBK/BaseActivityWithBK/images/download.svg?version=0.0.1) ](https://bintray.com/aldwinb16/BaseActivityWithBK/BaseActivityWithBK/0.0.1/link)
[![](https://jitpack.io/v/aldwinbabierra/Base-Activity-with-Butterknife.svg)](https://jitpack.io/#aldwinbabierra/Base-Activity-with-Butterknife)


### Project Progress:
- [x] ~~BaseActivity~~ - *done*
- [ ] BaseFragment - in progress
<br>
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
	implementation 'libs.aldwinbabierra:BaseActivityWithBK:$latestVersion'
	//or
	implementation 'com.github.aldwinbabierra:Base-Activity-with-Butterknife:$latestVersion'
}
```

<br>

__Functions:__
* __TAG()__: returns the context/activity name as a String.
* __getBaseActivity()__: returns the main context/activity as a Context.

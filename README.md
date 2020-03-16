# BaseActivity with ButterKnife
###### by Aldwin & Josef

*Latest version:*

[![](https://api.bintray.com/packages/aldwinb16/BaseActivityWithBK/BaseActivityWithBK/images/download.svg) ](https://bintray.com/aldwinb16/BaseActivityWithBK/BaseActivityWithBK/_latestVersion)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d476d16b4258485fb25006c68ccd0bcb)](https://app.codacy.com/manual/aldwinbabierra/Base-Activity-with-Butterknife?utm_source=github.com&utm_medium=referral&utm_content=aldwinbabierra/Base-Activity-with-Butterknife&utm_campaign=Badge_Grade_Dashboard)
[![](https://jitpack.io/v/aldwinbabierra/Base-Activity-with-Butterknife.svg)](https://jitpack.io/#aldwinbabierra/Base-Activity-with-Butterknife)


## Implementation (Android):
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

## BaseActivity Functions:
* __TAG()__: returns the class/context/activity name as a String. (*limited to 23 characters*)
* __getBaseActivity()__: returns the main context/activity as a Context.
* __loadFragment()__: loads a fragment on the activity targeting a view for replacement of fragment layout.
* __getBaseFragmentManager()__: returns the supporting fragment manager as FragmentManager.
* __getFragmentStackCount()__: returns the current size of the fragment stack as an Integer.
<br>

## BaseFragment Function:
* __TAG()__: returns the fragment class name as a String. (*limited to 23 characters*)

<br>

#### Change log:
```
0.0.2:

0.0.1:
```

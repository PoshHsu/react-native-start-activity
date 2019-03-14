
# react-native-start-activity

## Getting started

`$ npm install react-native-start-activity --save`

### Mostly automatic installation

`$ react-native link react-native-start-activity`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-start-activity` and add `RNStartActivity.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNStartActivity.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNStartActivityPackage;` to the imports at the top of the file
  - Add `new RNStartActivityPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-start-activity'
  	project(':react-native-start-activity').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-start-activity/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-start-activity')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNStartActivity.sln` in `node_modules/react-native-start-activity/windows/RNStartActivity.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Start.Activity.RNStartActivity;` to the usings at the top of the file
  - Add `new RNStartActivityPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNStartActivity from 'react-native-start-activity';

RNStartActivity.startActivity({
  className: 'com.backgroundstartactivityexample.MainActivity',
  packageName: 'com.backgroundstartactivityexample',
});
```

## Example App

[BackgroundStartActivityExample](https://github.com/PoshHsu/BackgroundStartActivityExample)
  

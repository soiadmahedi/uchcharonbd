## How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root settings.gradle at the end of repositories:
```gradle
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency
```gradle
	dependencies {
	        implementation 'com.github.soiadmahedi:uchcharonbd:v1.X.X'
	}
```

Step 2. Import Classes
```java
import com.soiadmahedi.uchcharonbd.BanglaToEnglishUchcharon;
import com.soiadmahedi.uchcharonbd.BanglaToSylhetiUchcharon;
```

Step 3. Convert Text - Uchcharon BD
```java
String outputText_en = BanglaToEnglishUchcharon.transliterate("আমি");
String outputText_syl = BanglaToSylhetiUchcharon.convertToNagri("আমি");
```

## Results
English: ami ,
Sylheti Nagri: ꠀꠝꠤ

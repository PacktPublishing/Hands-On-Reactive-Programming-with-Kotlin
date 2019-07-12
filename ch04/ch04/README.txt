Go to https://www.themoviedb.org and create your new account.

Login to the account and go to settings.

On left hand side, click on API option.

Click on request an API Key.

Choose Developer or Professional.

Accept the term and conditions and fill the form.

Once all the information is in place submit the form.

In details tab you will get API Key (v3 auth), copy it.

Open build.gradle file in Android studio and paste the key against buildConfigField tag.

android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "com.example.theseus.movieapp"
…		
…
        buildConfigField "String", "API_KEY", "\"REPLACE_API_KEY_WITH_THIS_TEXT\""
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    } }

# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\Fury\AppData\Local\Android\android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keep public class com.android.fury.a30day.food.** {
   *;
}
-keep public class com.android.fury.a30day.food.food_male_plan_10 {
   *;
}
-keep public class com.android.fury.a30day.food.food_male_plan_10_f_1 {
   *;
}
-keep public class com.android.fury.a30day.food.food_male_plan_10_f_2 {
   *;
}
-keep public class com.android.fury.a30day.food.food_male_plan_10_f_3 {
   *;
}
-keep public class com.android.fury.a30day.food.food_male_plan_10_food {
   *;
}
-keep public class com.android.fury.a30day.food.food_male_plan_10_food_1 {
   *;
}
-keep public class com.android.fury.a30day.food.TestRecyclerViewAdapter {
   *;
}
-keep public class com.android.fury.a30day.food.TestRecyclerViewAdapter2 {
   *;
}
-keep public class com.android.fury.a30day.food.TestRecyclerViewAdapter3 {
   *;
}
-keep public class com.android.fury.a30day.food.TestRecyclerViewAdapter_food_1 {
   *;
}
-keep public class com.android.fury.a30day.sport.sport {
   *;
}
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
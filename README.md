# TouchFeedback | Data Binding

This example show how to add a custom attribute in regular Views for TouchFeedback effects using [Android Data Binding].

In the class **[Bindings.java]** there is a method called "touchFeedback" that can be used in XML layout without a CustomView and set a touch feedback for views like:
  - RelativeLayout
  - ImageView
  - LinearLayout

The method **"touchFeedback"** has a ColorDrawable parameter that will be the feedback color. 

```xml
<ImageView
    android:layout_width="100dp"
    android:layout_height="100dp"
    android:layout_weight="1"
    android:background="#F44336"
    android:scaleType="center"
    android:src="@mipmap/ic_launcher"
    app:touchFeedback="@{@color/md_light_blue_A100}" />
```
[Bindings.java]: <https://github.com/renannery/TouchFeedback/blob/master/app/src/main/java/br/com/nery/touchfeedback/Bindings.java>
[Android Data Binding]: <http://developer.android.com/tools/data-binding/guide.html>

The feedback effect for API >= 21 (LOLLIPOP) is a Ripple Effect and for older versions is a selector with a smooth transaction between states


# [ImageSliderWithSwipes](https://myinnos.github.io/ImageSliderWithSwipes/ "View Website - ImageSliderWithSwipes")

This is an Image slider with swipes, Here we used Volley to load URL's from JSON! Here we make it very easy way to load images from Internet and We customized the description font(OpenSans).

First of all thanks to [AndroidImageSlider](https://github.com/daimajia/AndroidImageSlider "AndroidImageSlider"), Here You can easily load images from an internet URL, drawable, or file. And there are many kinds of amazing animations you can choose. Happy Coding!

[![Get it on Google Play](https://raw.github.com/repat/README-template/master/googleplay.png)](https://ff.app.link/gt_get_app)

Kindly use the following links to use this library:

In build.gradle (Project)
```java
allprojects {
  repositories {
			...
		maven { url "https://jitpack.io" }
	}
}
```
And then in the other gradle file(may be your app gradle or your own module library gradle, but never add in both of them to avoid conflict.)
```java
dependencies {
	compile 'com.github.myinnos:ImageSliderWithSwipes:1.0.2'
}
```
## Example

![ImageSliderWithSwipes](https://raw.githubusercontent.com/myinnos/ImageSliderWithSwipes/master/gif/image_slide_example.gif)

##### Create Android Project (set name ImageSliderWithSwipes)

##### Add permissions to AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

##### Add dependencies for Loading Images from URL's(Here we used Volley)

```java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:25.1.0'
    implementation 'com.github.myinnos:ImageSliderWithSwipes:1.0.1'
    implementation 'com.mcxiaoke.volley:library:1.0.+'
}
```

##### Copy this code in to activity_main.xml

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:custom="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <in.myinnos.imagesliderwithswipeslibrary.SliderLayout
        android:id="@+id/slider"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        custom:auto_cycle="true"
        custom:indicator_visibility="visible"
        custom:pager_animation="Stack"
        custom:pager_animation_span="1100" />

</RelativeLayout>
```
##### Copy this code in to MainActivity.java

```java
public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {

    private SliderLayout mDemoSlider;

    // Billionaires json url
    private static final String getURL = "http://api.androidhive.info/json/movies.json";
    HashMap<String, String> url_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        // Creating volley request obj
        JsonArrayRequest billionaireReq = new JsonArrayRequest(getURL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        url_maps = new HashMap<String, String>();
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                url_maps.put(obj.getString("title") + " - " + obj.getString("releaseYear"), obj.getString("image"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        for (String name : url_maps.keySet()) {
                            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
                            // initialize a SliderLayout
                            textSliderView
                                    .description(name)
				    .descriptionSize(20)
                                    .image(url_maps.get(name))
                                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                                    .setOnSliderClickListener(MainActivity.this);

                            //add your extra information
                            textSliderView.bundle(new Bundle());
                            textSliderView.getBundle().putString("extra", name);

                            mDemoSlider.addSlider(textSliderView);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "network issue: please enable wifi/mobile data", Toast.LENGTH_SHORT).show();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(billionaireReq);

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);

        mDemoSlider.setPresetTransformer("Stack");

    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

}

```
## Apps using [ImageSliderWithSwipes](https://myinnos.github.io/ImageSliderWithSwipes/ "View Website - ImageSliderWithSwipes")
If you are using ImageSliderWithSwipes in your app and would like to be listed here, please let us know by opening a [new issue](https://github.com/myinnos/ImageSliderWithSwipes/issues/new)!

 * [Pawan Kalyan : PSPK Fans Adda](https://play.google.com/store/apps/details?id=com.myinnos.pawankalyan "Pawan Kalyan : PSPK Fans Adda")

 * [Chiranjeevi : Fans Adda](https://play.google.com/store/apps/details?id=com.myinnos.chiru "Chiranjeevi : Fans Adda")
 
 * [Niharika Konidela](https://play.google.com/store/apps/details?id=com.fansfolio.niharika "Niharika Konidela")
 
 * [fans folio: Celebrity Lovers](https://play.google.com/store/apps/details?id=in.myinnos.fansfolio "fans folio: Celebrity Lovers")


## Thanks
- [Volley](https://github.com/mcxiaoke/android-volley)
- [Picasso](https://github.com/square/picasso)
- [NineOldAndroids](https://github.com/JakeWharton/NineOldAndroids)
- [ViewPagerTransforms](https://github.com/ToxicBakery/ViewPagerTransforms)
- [AndroidImageSlider](https://github.com/daimajia/AndroidImageSlider)

## Contact
#### Prabhakar Thota
* :globe_with_meridians: Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* :email: e-mail: contact@myinnos.in
* :mag_right: LinkedIn: [PrabhakarThota](https://www.linkedin.com/in/prabhakarthota "Prabhakar Thota on LinkedIn")
* :thumbsup: Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")

[![Flattr this git repo](http://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/submit/auto?user_id=username&url=https://github.com/myinnos/ImageSliderWithSwipes&title=ImageSliderWithSwipes&language=&tags=github&category=software) 

License
-------

    Copyright 2017 MyInnos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

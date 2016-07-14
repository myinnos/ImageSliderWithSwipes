# [ImageSliderWithSwipes](https://myinnos.github.io/ImageSliderWithSwipes/ "View Website - ImageSliderWithSwipes")

This is an Image slider with swipes, Here we used Volley to load URL's from JSON! Here we make it very easy way to load images from Internet and We customized the description font(OpenSans).

First of all thanks to [AndroidImageSlider](https://github.com/daimajia/AndroidImageSlider "AndroidImageSlider"), Here You can easily load images from an internet URL, drawable, or file. And there are many kinds of amazing animations you can choose. Happy Coding!

[![Get it on Google Play](https://raw.github.com/repat/README-template/master/googleplay.png)](http://app.fansfolio.com/G_Android)

Kindly use the following links to use this library:

In build.gradle (Project)

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
	
And then in the other gradle file(may be your app gradle or your own module library gradle, but never add in both of them to avoid conflict.)
	
	 dependencies {
	        compile 'com.github.myinnos:ImageSliderWithSwipes:v1.0'
	        }

## Example

![ImageSliderWithSwipes](https://s19.postimg.org/ltckouhlv/Image_Slider_With_Swipes.png)

##### Create Android Project (set name ImageSliderWithSwipes)

##### Add permissions to AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

##### Add dependencies for Loading Images from URL's(Here we used Volley)

```java
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:24.0.0'
    compile 'com.github.myinnos:ImageSliderWithSwipes:v1.0'
    compile 'com.mcxiaoke.volley:library:1.0.+'
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
If you are using AppIntro in your app and would like to be listed here, please let us know by opening a [new issue](https://github.com/myinnos/ImageSliderWithSwipes/issues/new)!

 * [fans folio](https://play.google.com/store/apps/details?id=in.myinnos.fansfolio "fans folio")

 * [Pawan Kalyan : PSPK Fans Adda](https://play.google.com/store/apps/details?id=com.myinnos.pawankalyan "Pawan Kalyan : PSPK Fans Adda")

 * [Chiranjeevi : Fans Adda](https://play.google.com/store/apps/details?id=com.myinnos.chiru "Chiranjeevi : Fans Adda")

## Thanks
- [Volley](https://github.com/mcxiaoke/android-volley)
- [Picasso](https://github.com/square/picasso)
- [NineOldAndroids](https://github.com/JakeWharton/NineOldAndroids)
- [ViewPagerTransforms](https://github.com/ToxicBakery/ViewPagerTransforms)
- [AndroidImageSlider](https://github.com/daimajia/AndroidImageSlider)

## Contact
#### Prabhakar Thota
* Website: [myinnos.com](https://myinnos.in "Prabhakar Thota")
* e-mail: contact@myinnos.in
* Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")

[![Flattr this git repo](http://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/submit/auto?user_id=username&url=https://github.com/myinnos/ImageSliderWithSwipes&title=ImageSliderWithSwipes&language=&tags=github&category=software) 

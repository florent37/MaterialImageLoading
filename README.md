MaterialImageLoading
=======

[![Build Status](https://travis-ci.org/florent37/MaterialImageLoading.svg)](https://travis-ci.org/florent37/MaterialImageLoading)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MaterialImageLoading-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1951)

Material image loading implementation


[![Build screen](https://raw.githubusercontent.com/florent37/MaterialImageLoading/master/app/src/main/res/drawable/description_small.png)](https://raw.githubusercontent.com/florent37/MaterialImageLoading/master/app/src/main/res/drawable/description.png)

# Sample

<a href="https://play.google.com/store/apps/details?id=com.github.florent37.florent.champigny">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

And have a look on a sample Youtube Video : [Youtube Link](https://www.youtube.com/watch?v=hvHzVnMTYGk)

[![Video](http://share.gifyoutube.com/ygz6n4.gif)] (https://www.youtube.com/watch?v=hvHzVnMTYGk)

# Download

<a href='https://ko-fi.com/A160LCC' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi1.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>

In your module [![Download](https://api.bintray.com/packages/florent37/maven/MaterialImageLoading/images/download.svg)](https://bintray.com/florent37/maven/MaterialImageLoading/_latestVersion)
```groovy
compile 'com.github.florent37:materialimageloading:1.0.2'
```

# Usage

Simply use MaterialImageLoading.animate
for example
```xml
Picasso.with(this).load(url).fit().centerCrop().into(imageView, new Callback() {

            @Override
            public void onSuccess() {
                MaterialImageLoading.animate(imageView).setDuration(2000).start();
            }

            @Override
            public void onError() {

            }
        });
```

# TODO

# Community

Looking for contributors, feel free to fork !

Tell me if you're using my library in your application, I'll share it in this README

# Thanks

* [Picasso][picasso] used for the sample (from Square)

# Credits

Author: Florent Champigny www.florentchampigny.com/

<a href="https://play.google.com/store/apps/details?id=com.github.florent37.florent.champigny">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>
<a href="https://plus.google.com/+florentchampigny">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/florent_champ">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://www.linkedin.com/in/florentchampigny">
  <img alt="Follow me on LinkedIn"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/linkedin.png" />
</a>


License
--------

    Copyright 2015 florent37, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[snap]: https://oss.sonatype.org/content/repositories/snapshots/
[picasso]: https://github.com/square/picasso

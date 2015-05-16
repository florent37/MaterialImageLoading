MaterialImageLoading
=======

[![Build Status](https://travis-ci.org/florent37/MaterialImageLoading.svg)](https://travis-ci.org/florent37/MaterialImageLoading)

Material image loading implementation


[![Build screen](https://raw.githubusercontent.com/florent37/MaterialImageLoading/master/app/src/main/res/drawable/description_small.png)](https://raw.githubusercontent.com/florent37/MaterialImageLoading/master/app/src/main/res/drawable/description.png)

#Sample

You can find a sample APK : [Link](https://github.com/florent37/MaterialImageLoading/releases/download/1.0.0/sample-debug.apk)

And have a look on a sample Youtube Video : [Youtube Link](https://www.youtube.com/watch?v=hvHzVnMTYGk)

[![Video](http://share.gifyoutube.com/ygz6n4.gif)] (https://www.youtube.com/watch?v=hvHzVnMTYGk)

#Download

In your module [![Download](https://api.bintray.com/packages/florent37/maven/MaterialImageLoading/images/download.svg)](https://bintray.com/florent37/maven/MaterialImageLoading/_latestVersion)
```groovy
compile 'com.github.florent37:materialimageloading:1.0.0'
```

#Usage

Simply use MaterialImageLoading.animate
for example
```xml
Picasso.with(this).load(url).fit().centerCrop().into(imageView, new Callback() {

            @Override
            public void onSuccess() {
                MaterialImageLoading.animate(imageView).start();
            }

            @Override
            public void onError() {

            }
        });
```

#TODO

#Community

Looking for contributors, feel free to fork !

Tell me if you're using my library in your application, I'll share it in this README

#Thanks

* [Picasso][picasso] used for the sample (from Square)

#Credits

Author: Florent Champigny

<a href="https://plus.google.com/+florentchampigny">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/florent_champ">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://www.linkedin.com/profile/view?id=297860624">
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

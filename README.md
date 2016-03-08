# Super Duo 

This project consist of 2 apps Alexandria and Football Scores.

Alexandria is a book library and Football Scores show match fixtures and scores.


## Installation

This app requires API key for football-data.org. You can get it from here [football-data.org API](http://api.football-data.org/register "football-data.org API")

Before running the app please replace `FOOTBALLAPIKEY` with your football-data.org API key value in `app/build.gradle`

```
    buildTypes.each {
        it.buildConfigField 'String', 'FOOTBALL_API_KEY', FOOTBALLAPIKEY
    }
```


## Learn
This app was created as a project under _Udacity, Android Developer Nanodegree_ course.

Things you can learn:

* Implement Google vision API bar code scanner
* implement Sync Adapater
* Add Widget
* Add Collection widget


##Issues

The app will not show any data if there are no football matches scheduled. 

To fill the database with dummy data please uncomment following lines in `getData()` function `sync/FootballSyncAdapter.java`

```

	if (matches.length() == 0) {
	    //if there is no data, call the function on dummy data
	    //this is expected behavior during the off season.
	    //PLEASE UNCOMMENT IT IF THERE IS NO REAL DATA
	    //processJSONdata(getContext().getString(R.string.dummy_data), getContext(), false);
	    return;
	}

```

## Screens
<img src="https://cloud.githubusercontent.com/assets/13112999/13420222/969bdc16-dfaa-11e5-8ac5-89735e8f7816.png" /> 
<img src="https://cloud.githubusercontent.com/assets/13112999/13420224/96ff3c48-dfaa-11e5-9043-12328a9c9dec.png" />
 
<img src="https://cloud.githubusercontent.com/assets/13112999/13420223/96fecefc-dfaa-11e5-9688-4b993d1e7700.png" />

## Licence 

The MIT License (MIT)

Copyright (c) 2015 Ashesh Bharadwaj

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
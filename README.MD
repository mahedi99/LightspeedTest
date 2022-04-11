### Lightspeed Test

=====================


## Architectural Design
The MVVM architectural design pattern is used.
Where the design consists 3 layers
1. Model
2. View
3. ViewModel

In the Model layer, we have models, data caching and network calls. All of these are access through
a common access point called repository.

In the View layer, we have all the view related components, where the user gets to interacted. For
example the activity.

In the ViewModel layer, it plays a role to be a middleman who connects the Model layer to View layer.


## Database
To cache WEB response data, the Room library has been used.

## Networks
To connect to Web Service, the Retrofit library has been use. And, Gosn was use to parse Json
to Kotlin Object.

## Tests
To test the UI, the Espresso library has been used. Where both Recyclerview and Room database has
been tested.

## External Libraries
1. Retrofit
2. Glide
3. GSON
4. Junit

## Demo

<img src="https://github.com/mahedi99/LightspeedTest/blob/master/demo.png" width="250">
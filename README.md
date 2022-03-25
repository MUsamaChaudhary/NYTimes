### NY Times Most Viewed Artciles 

Clone this Repository through terminal or version control in Android Studio. Once the project is cloned and all branches are available checkout **main** branch take a pull and synced with Gradle you are ready to go run application.

### Git Branches

* main -> default tracking branch with the lastest code 
* feature/api -> project architecture setup for api calling (Retrofit, Repository, ViewModel, Data fetching).
* feature/listing -> setting articles data to recyclerview and adapter
* feature/detail -> articles detail screen implementation by using parceler library
* (feature/tweaks,finish) -> contains tweaks and update code after code review

### Tools, Techniques and Jetpack Libraries used

* Mac Os -> Android Studio -> Kotlin
* View Model
* Live Data
* View Binding
* MVVM
* Repository Pattern

### Screens and Classes

* Main -> get and list all available articles from api.
* ArticleDetail -> show detail of selected article by using parceler 
* Base -> Abstract class act as a base class for all activities help in binding views and provides classes with same functionality.

### Description and Conclusion


# Before starting

* Architecture setup with api call
* Setting data to recyler view and adapter
* Detail screen implementation
* Code review update and tweaks
* Intial estimate 8 to 12 hours
 
# After completing

* Total hours invested 7 to 9
* [Repository url](https://github.com/MUsamaChaudhary/NYTimes.git)
* [APK file](https://drive.google.com/file/d/1WGJw3AKFLbdIvKGLn1DR5Y_fMQb2OQr8/view?usp=sharing)

# Summary

* Used Jetpack libraries with MVVM architecture and repository pattern
* Retrofit for api calling as it help us mapping data directly
* SDP library for scalable dp help in responsive and optimized layout
* Parceler library for serialize objects easily without writing boiler plate code
* OOP - Abstract class (base class) - Interface (handle click on artciles items)
* DP - Singleton pattern (Utils class, RetrofitService class) - Observer pattern (Getting updates from api , Handle loading)
* Null safety
* Extension function



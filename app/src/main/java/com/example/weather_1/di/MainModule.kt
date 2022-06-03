//import android.content.Context
//import com.example.velmurugan.getcurrentlatitudeandlongitudeandroid.GpsTracker
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ActivityComponent
//import dagger.hilt.android.qualifiers.ActivityContext
//import dagger.hilt.android.scopes.ActivityScoped
//
//@Module
//@InstallIn(ActivityComponent::class)
//object MainModule {
//
//    @ActivityScoped
//    @Provides
//    fun provideGpsTracker(
//        @ActivityContext context: Context
//    ): GpsTracker {
//        return GpsTracker(mContext = context)
//    }
//}

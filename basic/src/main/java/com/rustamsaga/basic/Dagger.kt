package com.rustamsaga.basic

import com.rustamsaga.basic.data.Analytics
import com.rustamsaga.basic.data.NewsRepository
import com.rustamsaga.basic.data.NewsRepositoryImpl
import com.rustamsaga.basic.data.NewsService
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Qualifier

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: NewsDetailsFragment)
}

@Module(includes = [NetworkModule::class, AppBindModule::class])
class AppModule

@Module
class NetworkModule {

    @Provides
    fun provideAndroidNewsService(): NewsService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://developer.android.com/")
            .build()
        return retrofit.create()
    }

    @AlexRetrofit
    @Provides
    fun provideRetrofitNewsService(): NewsService{
        val  retrofit = Retrofit.Builder()
            .baseUrl("https://developer.alexanderklimov.ru/android/library/retrofit.php")
            .build()
        return retrofit.create()
    }
}

@Module
interface AppBindModule{
    @Binds
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Android


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AlexRetrofit
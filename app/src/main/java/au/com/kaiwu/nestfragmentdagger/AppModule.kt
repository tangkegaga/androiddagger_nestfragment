package au.com.kaiwu.nestfragmentdagger


import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * We declare our App wide dependencies in this module. All of the following dependencies will be
 * available at an app wide level.
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun providesTestData(application: MyApplication): TestData {
        return TestData("helloTest")
    }


}
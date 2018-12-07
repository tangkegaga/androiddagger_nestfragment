package au.com.kaiwu.nestfragmentdagger

import au.com.kaiwu.nestfragmentdagger.main.mainfragment.MainFragmentBuilder

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, MainFragmentBuilder::class,
    AppModule::class])
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>()
    /*
    T is MyApplication, all the app can access this T instance
    * @Override
    public final AndroidInjector<T> create(T instance) {
      seedInstance(instance);
      return build();
    }*/

}
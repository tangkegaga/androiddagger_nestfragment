package au.com.kaiwu.nestfragmentdagger.main


import au.com.kaiwu.nestfragmentdagger.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModel::class))
    internal abstract fun bindActivity(): MainActivity

}

@Module
internal class MainActivityModel// add ChildViewModel specific dependencies here
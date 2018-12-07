package au.com.kaiwu.nestfragmentdagger.main.mainfragment


import au.com.kaiwu.nestfragmentdagger.TestData
import au.com.kaiwu.nestfragmentdagger.scope.FragmentScope
import au.com.kaiwu.nestfragmentdagger.main.childfragment.ChildFragmentBuilder
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module
abstract class MainFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(MainFragmentModel::class, ChildFragmentBuilder::class))
    internal abstract fun bindFragment(): MainFragment

}

@Module
internal class MainFragmentModel {

    @FragmentScope
    @Provides
    @Named("MainFragmentTestData")
    fun providesTestData(): TestData {
        return TestData("MainFragmentTestData")
    }
}
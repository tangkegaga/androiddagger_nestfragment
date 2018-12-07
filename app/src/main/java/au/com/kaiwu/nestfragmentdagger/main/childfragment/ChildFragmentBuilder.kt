package au.com.kaiwu.nestfragmentdagger.main.childfragment


import au.com.kaiwu.nestfragmentdagger.TestData
import au.com.kaiwu.nestfragmentdagger.scope.ChildFragmentScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module
abstract class ChildFragmentBuilder {

    @ChildFragmentScope
    @ContributesAndroidInjector(modules = arrayOf(ChildFragmentModel::class))
    internal abstract fun bindChildFragment(): ChildFragment

}

@Module
internal class ChildFragmentModel {

    @ChildFragmentScope
    @Provides
    @Named("ChildFragmentTestData")
    fun providesTestData(): TestData {
        return TestData("ChildFragmentTestData")
    }
}
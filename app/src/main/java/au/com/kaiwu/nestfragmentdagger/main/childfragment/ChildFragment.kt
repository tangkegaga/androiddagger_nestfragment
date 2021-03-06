package au.com.kaiwu.nestfragmentdagger.main.childfragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import au.com.kaiwu.nestfragmentdagger.R
import au.com.kaiwu.nestfragmentdagger.TestData
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

class ChildFragment : DaggerFragment() {

    @Inject
    lateinit var testData: TestData/*singleton within life of app*/

    @Inject
    @field:Named("MainFragmentTestData")
    lateinit var testDataMainFragment: TestData/*singleton within life of MainFragment*/

    @Inject
    @field:Named("ChildFragmentTestData")
    lateinit var ChildFragmentTestData: TestData/*Singleton within life of ChildFragment*/

    companion object {
        fun newInstance() = ChildFragment()
    }

    private lateinit var viewModel: ChildViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.child_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChildViewModel::class.java)
        // TODO: Use the ViewModel


    }

}

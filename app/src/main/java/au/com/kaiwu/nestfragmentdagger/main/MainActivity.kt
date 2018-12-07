package au.com.kaiwu.nestfragmentdagger.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import au.com.kaiwu.nestfragmentdagger.main.mainfragment.MainFragment
import android.util.SparseArray
import au.com.kaiwu.nestfragmentdagger.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commit()
        }
    }



    override fun onBackPressed() {
        val managers = SparseArray<FragmentManager>()
        traverseManagers(supportFragmentManager, managers, 0)
        if (managers.size() > 0) {
            managers.valueAt(managers.size() - 1).popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }

    private fun traverseManagers(manager: FragmentManager, managers: SparseArray<FragmentManager>, intent: Int) {
        if (manager.backStackEntryCount > 0) {
            managers.put(intent, manager)
        }
        if (manager.fragments == null) {
            return
        }
        for (fragment in manager.fragments) {
            if (fragment != null) traverseManagers(fragment.childFragmentManager, managers, intent + 1)
        }
    }
}

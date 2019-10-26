package com.darx.foodscaner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.darx.foodscaner.adapters.PageAdapter
import com.darx.foodscaner.fragments.GroupsFragment
import kotlinx.android.synthetic.main.activity_groups.viewPager
import kotlinx.android.synthetic.main.toolbar.*

class UserGroupsActivity : AppCompatActivity() {

    private val pagerAdapter = PageAdapter(supportFragmentManager, lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pagerAdapter.addFragment(GroupsFragment(false), "MyGroups")
        pagerAdapter.addFragment(GroupsFragment(true), "ShearchGroups")

        setContentView(R.layout.activity_groups)
        viewPager.adapter = pagerAdapter

        setSupportActionBar(toolBar)
    }

//    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
//
//        return super.onCreateView(name, context, attrs)
//    }

    private fun groups(view: View) {
//        GlobalScope.launch(Dispatchers.Main) {
//            val response = apiService.groups().await()
////            username.text = response.toString()
//
//
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}

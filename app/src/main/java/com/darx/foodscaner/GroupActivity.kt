package com.darx.foodscaner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.darx.foodscaner.database.GroupModel
import com.darx.foodscaner.database.GroupViewModel
import kotlinx.android.synthetic.main.activity_group.*
import com.darx.foodscaner.R as R

class GroupActivity : AppCompatActivity() {

    private var groupViewModel: GroupViewModel? = null
    private lateinit var groupToShow: GroupModel
    private var isEnter: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        setSupportActionBar(groupToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel::class.java)

        groupToShow = intent.extras.get("GROUP") as GroupModel
        groupCollapsingToolbar.title = groupToShow.name
        infoGroup.text = groupToShow.about
        // collapsingToolbar.background = R.drawable.group.toDrawable() IMAGE

        groupViewModel?.getOne_(groupToShow.id)?.observe(this@GroupActivity, object : Observer<GroupModel> {
            override fun onChanged(t: GroupModel?) {
                if (t?.id == groupToShow.id) {
                    enterButton.text = resources.getString(R.string.exit_from_group)
                    enterButton.setBackgroundColor(resources.getColor(R.color.strongNegativeColor))
                    isEnter = true
                } else {
                    enterButton.text = resources.getString(R.string.enter_to_group)
                    enterButton.setBackgroundColor(resources.getColor(R.color.strongPositiveColor))
                    isEnter = false
                }
            }
        })

        enterButton.setOnClickListener {
            if (isEnter) {
                groupViewModel?.deleteOne_(groupToShow)
            } else {
                groupViewModel?.add_(groupToShow)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}

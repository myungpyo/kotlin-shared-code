package com.smp.sharedkotlin.app.presentation

import android.os.Bundle
import androidx.fragment.app.transaction
import com.smp.sharedkotlin.app.R
import com.smp.sharedkotlin.app.support.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState ?: supportFragmentManager.transaction(allowStateLoss = true) {
            replace(
                R.id.mainContainerViewGroup,
                MemoListFragment.create()
            )
        }
    }
}

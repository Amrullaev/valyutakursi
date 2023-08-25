package com.amrullaev.valyutakursi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.amrullaev.valyutakursi.drawerUI.AboutFragment
import com.amrullaev.valyutakursi.drawerUI.ShareFragment
import com.amrullaev.valyutakursi.fragments.RublFragment
import com.amrullaev.valyutakursi.fragments.UsaFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UsaFragment()
            1-> RublFragment()

            else -> UsaFragment()
        }
    }
}
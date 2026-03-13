package si.uni_lj.fri.pbd.pbd2026_lab_3

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.fragment.app.FragmentActivity

class TabPagerAdapter(
    fa: FragmentActivity?,
    private val tabCounter: Int) : FragmentStateAdapter(fa!!) {

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            3 -> Tab3Fragment()
            else -> Tab1Fragment()
        }
    }

    override fun getItemCount(): Int {
        return tabCounter
    }
}
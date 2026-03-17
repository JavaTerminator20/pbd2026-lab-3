package si.uni_lj.fri.pbd.pbd2026_lab_3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabPagerAdapter(fa: FragmentActivity?, private val tabCounter: Int) : FragmentStateAdapter(fa!!){
    override fun createFragment(position: Int) : Fragment {
        var returnFrag: Fragment
        when(position){
            0 -> returnFrag = Tab1Fragment()
            1 -> returnFrag = Tab2Fragment()
            else -> returnFrag = Tab3Fragment()
        }
        return returnFrag
    }

    override fun getItemCount(): Int{
        return tabCounter
    }
}
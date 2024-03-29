import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewpager.MainFragment
import com.example.viewpager.OneFragment
import com.example.viewpager.ThreeFragment
import com.example.viewpager.TwoFragment

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    val PAGE_MAX_CNT = 4

    override fun getCount(): Int = PAGE_MAX_CNT

    override fun getItem(position: Int): Fragment? =
        when (position) {
            1 -> OneFragment.newInstance()
            2 -> TwoFragment.newInstance()
            3 -> ThreeFragment.newInstance()
            else -> MainFragment.newInstance()
        }

    override fun getPageTitle(position: Int): CharSequence? =
        when (position) {
            1 -> "one"
            2 -> "two"
            3 -> "three"
            else -> "main"
        }
}
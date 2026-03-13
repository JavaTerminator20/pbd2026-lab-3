package si.uni_lj.fri.pbd.pbd2026_lab_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import si.uni_lj.fri.pbd.pbd2026_lab_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
        private const val NUM_OF_TABS = 3
        private lateinit var binding: ActivityMainBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the view objects from the XML layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        // “Use the root view of this binding as the screen for this Activity.”
        //binding.root = the top-level layout element in activity_main.xml.
        setContentView(binding.root)

        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // val toolbar: Toolbar = findViewById(R.id.toolbar)
        val toolbar = binding.toolbar
        toolbar.setTitle("Nightsky Observer")
        setSupportActionBar(toolbar)

        configureTabLayout()
    }

    private fun configureTabLayout() {
        // val tab_layout = findViewById<TabLayout>(R.id.tab_layout)
        // val view_pager = findViewById<ViewPager2>(R.id.view_pager)
        val tab_layout = binding.tabLayout
        val view_pager = binding.viewPager

        val adapter = TabPagerAdapter(this, NUM_OF_TABS)
        view_pager.adapter = adapter

        TabLayoutMediator(tab_layout, view_pager) { tab, position ->
            // You should set tab titles here
            when (position) {
                0 -> tab.text = "Sky Observations"
                1 -> tab.text = "Planet Wiki"
                2 -> tab.text = "Notes"
            }
        }.attach()
    }

}
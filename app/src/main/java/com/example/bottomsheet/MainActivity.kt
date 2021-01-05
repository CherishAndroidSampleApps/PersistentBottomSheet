package com.example.bottomsheet



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.bottomsheet.databinding.ActivityMainBinding
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewpagerAdapter:ViewPagerAdapter

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        viewpagerAdapter=ViewPagerAdapter(supportFragmentManager)
        viewpagerAdapter.fragments=listOf(
            HomeFragment(),
            ProfileFragment(),
            EtcFragment()
        )

        binding.bottomViewpager.adapter=viewpagerAdapter

        binding.mainBottomNavi.setOnNavigationItemSelectedListener{
            var index:Int by Delegates.notNull<Int>()
            when(it.itemId){
                R.id.main_home->index=0
                R.id.main_person->index=1
                R.id.main_more->index=2
            }
            binding.bottomViewpager.currentItem=index
            true
        }
     }
}
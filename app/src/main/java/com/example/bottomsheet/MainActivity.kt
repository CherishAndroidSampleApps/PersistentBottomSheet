package com.example.bottomsheet


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bottomsheet.databinding.ActivityMainBinding

import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED



class MainActivity : AppCompatActivity() {
    //private lateinit var standardBottomSheet : ConstraintLayout
    private lateinit var binding: ActivityMainBinding
    private lateinit var standardBottomSheetBehavior:BottomSheetBehavior<*>
    private lateinit var standardBottomSheet: ConstraintLayout
    private lateinit var mViewBg:View
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        mViewBg=binding.bgView

        standardBottomSheet=findViewById(R.id.standardBottomSheet)

        standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)
        standardBottomSheetBehavior.state = STATE_COLLAPSED
        standardBottomSheetBehavior.peekHeight = 300
        standardBottomSheetBehavior.expandedOffset = 100


        standardBottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if(newState==STATE_EXPANDED){
                    mViewBg.setAlpha(0.8f)
                    mViewBg.setBackgroundColor(Color.BLACK)
                }
                if(newState== STATE_COLLAPSED){
                    Toast.makeText(this@MainActivity,"collapsed",Toast.LENGTH_SHORT).show()
                    mViewBg.setAlpha(1f)
                    mViewBg.setBackgroundColor(Color.RED)
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                mViewBg.setAlpha(1-0.3f*slideOffset)
            }
        })
        /*
        standardBottomSheetBehavior.removeBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if(newState==STATE_EXPANDED){
                    mViewBg.setAlpha(0.8f)
                    mViewBg.setBackgroundColor(Color.BLACK)
                }
                else if(newState== STATE_COLLAPSED){
                    mViewBg.setAlpha(1f)
                    mViewBg.setBackgroundColor(Color.RED)
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    mViewBg.setAlpha(1-0.3f*slideOffset)
            }
        })*/
     }
}
package com.example.bottomsheet

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.bottomsheet.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED


class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding?=null
    private val binding get()=_binding!!
    private lateinit var standardBottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var standardBottomSheet: ConstraintLayout
    private lateinit var mViewBg:ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewBg=binding.bgView

        standardBottomSheet=view.findViewById(R.id.standardBottomSheet)

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
                    Toast.makeText(context,"collapsed",Toast.LENGTH_SHORT).show()
                    mViewBg.setAlpha(1f)
                    mViewBg.setBackgroundColor(ContextCompat.getColor(context!!,R.color.light_purple))
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                mViewBg.setAlpha(1-0.3f*slideOffset)
            }
        })

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
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}
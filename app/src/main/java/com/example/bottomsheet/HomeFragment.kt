package com.example.bottomsheet

import android.animation.ArgbEvaluator
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var standardBottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var standardBottomSheet: ConstraintLayout
    private lateinit var mainConstraintLayout:ConstraintLayout
    private lateinit var mViewBg: ConstraintLayout
    private lateinit var adapter: MainBottomSheetAdapter
    private var isDown:Int=0



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        adapter = MainBottomSheetAdapter()
        setAdapterData(adapter)
        setAdapter(binding, adapter)
        //binding.mainBottomSheet.mainList.setHasFixedSize(true);

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mViewBg = view.findViewById(R.id.bg_view)

        standardBottomSheet = view.findViewById(R.id.main_bottom_sheet)

        //val bottomSheetFragment=BottomSheetDialog()
        //bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)

        standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)
        standardBottomSheetBehavior.state = STATE_COLLAPSED
        standardBottomSheetBehavior.peekHeight = 300
        standardBottomSheetBehavior.expandedOffset = 100
        standardBottomSheetBehavior.isHideable=false

        initRecyclerView(mViewBg,adapter)

        standardBottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                if (newState == STATE_COLLAPSED) {
                    mViewBg.setBackgroundColor(ContextCompat.getColor(context!!, R.color.light_purple))
                }
                if(newState== STATE_EXPANDED){

                }

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                transitionBottomSheetParentView(slideOffset)
            }
        })

    }

    private fun initRecyclerView(standardBottomSheet: ConstraintLayout?, mainAdapter: MainBottomSheetAdapter) {
        val recyclerView = standardBottomSheet?.findViewById<RecyclerView>(R.id.main_list)
        recyclerView?.apply {
            adapter = mainAdapter
            layoutManager = GridLayoutManager(context, 5)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun transitionBottomSheetParentView(slideOffset: Float) {
        Log.v("onslide", "down$slideOffset")
        if (slideOffset > 0) {
            //Log.e("onslide", "up$slideOffset")
            val argbEvaluator = ArgbEvaluator().evaluate(slideOffset, 0x8189b3, Color.GRAY)
            mViewBg.setBackgroundColor(argbEvaluator as Int)
        } else {
            //Log.v("onslide","down$slideOffset")
            val argbEvaluator = ArgbEvaluator().evaluate(slideOffset, Color.GRAY, 0x8189b3)
            mViewBg.setBackgroundColor(argbEvaluator as Int)
        }

    }

    private fun setAdapterData(adapter: MainBottomSheetAdapter) {
        adapter.data = mutableListOf(
                CherryData("안녕"),
                CherryData("반가워"),
                CherryData("잘가"),
                CherryData("반가워"),
                CherryData("반가워"),
                CherryData("반가워"),
                CherryData("반가워"),
                CherryData("안녕"),
                CherryData("반가워"),
                CherryData("잘가"),
                CherryData("반가워"),
                CherryData("반가워"),
                CherryData("반가워"),
                CherryData("반가워"),
                CherryData("안녕"),
                CherryData("반가워"),
                CherryData("잘가"),
                CherryData("반가워"),
                CherryData("반가워"),
                CherryData("반가워"),
                CherryData("반가워"),
            CherryData("안녕"),
            CherryData("반가워"),
            CherryData("잘가"),
            CherryData("반가워"),
            CherryData("반가워"),
            CherryData("반가워"),
            CherryData("반가워"),
            CherryData("안녕"),
            CherryData("안녕"),
            CherryData("반가워"),
            CherryData("잘가"),
            CherryData("반가워"),
            CherryData("반가워"),
            CherryData("반가워"),
            CherryData("반가워"),
            CherryData("안녕"),
            CherryData("반가워"),
            CherryData("반가워"),
            CherryData("반가워"),
            CherryData("반가워"),
            CherryData("안녕")
        )
        adapter.notifyDataSetChanged()
    }

    private fun setAdapter(binding: FragmentHomeBinding, mainAdapter: MainBottomSheetAdapter) {
        binding.mainBottomSheet.mainList.apply {
            adapter = mainAdapter
            layoutManager = GridLayoutManager(context, 5)
        }

    }


}
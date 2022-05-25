package com.info.custombottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.info.custombottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var customSheet: BottomSheetBehavior<NestedScrollView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        setViews()

    }

    private fun setViews() {
        binding.apply {
            customSheet = BottomSheetBehavior.from(binding.bottomSheet)


            /** button show sheet **/
            btnShowSheet.setOnClickListener {
                showSheet()
            }


        }
    }


    private fun showSheet(){
        customSheet.state = BottomSheetBehavior.STATE_EXPANDED
        binding.attachment.apply {

            /** button ok **/
            btnOk.setOnClickListener {
                val name = name.text.trim().toString()
                Toast.makeText(this@MainActivity,name,Toast.LENGTH_SHORT).show()
                hideSheet()
            }

            /** button hide **/
            btnHide.setOnClickListener {
                hideSheet()
            }

        }
    }

    private fun hideSheet(){
        customSheet.state = BottomSheetBehavior.STATE_COLLAPSED
    }
}
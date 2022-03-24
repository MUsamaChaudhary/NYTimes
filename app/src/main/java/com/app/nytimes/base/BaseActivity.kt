package com.app.nytimes.base

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewbinding.ViewBinding
import com.app.nytimes.R
import com.app.nytimes.utils.Utils


abstract class BaseActivity: AppCompatActivity() {

    private lateinit var binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getLayout()
    }

    protected abstract fun getLayout(): ViewBinding

    protected abstract fun init(savedInstanceState: Bundle?)

    fun getBinding(): ViewBinding {
        return binding
    }

    fun showProgressBar(show: Boolean){
        val progressView = binding.root.findViewById<ConstraintLayout>(R.id.progressView)
        if(show){
            Utils.disableTouch(this)
            progressView.visibility = View.VISIBLE
        }else{
            Utils.enableTouch(this)
            progressView.visibility = View.GONE
        }
    }


}
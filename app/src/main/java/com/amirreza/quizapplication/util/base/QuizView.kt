package com.amirreza.quizapplication.util.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.amirreza.quizeapplication.R

interface QuizView {
    val rootView: ConstraintLayout?
    val viewContext: Context?

    fun setProgressBarIndicator(mustShow: Boolean) {
        rootView?.let { root ->
            viewContext?.let { context ->
                var loadingView = root.findViewById<View>(R.id.viewLoading)
                if (loadingView == null && mustShow) {
                    loadingView =
                        LayoutInflater.from(context).inflate(R.layout.view_progressbar, root, false)
                    root.addView(loadingView)
                }
                loadingView?.visibility = if (mustShow) View.VISIBLE else View.GONE
            }
        }
    }
}
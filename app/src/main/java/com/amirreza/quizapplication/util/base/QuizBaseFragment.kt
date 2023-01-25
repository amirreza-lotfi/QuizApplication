package com.amirreza.quizapplication.util.base

import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

abstract class QuizBaseFragment : Fragment(), QuizView {
    override val rootView: ConstraintLayout?
        get() = view as ConstraintLayout
    override val viewContext: Context?
        get() = context
}
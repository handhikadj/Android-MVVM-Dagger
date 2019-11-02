package com.example.dika.dikaapp.util

import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

class UIHelpers {
    fun closeAppIfBack(context: Fragment, viewLifecycleOwner: LifecycleOwner) =
        context.requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            context.requireActivity().finish()
        }
}

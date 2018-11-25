package com.mainchain.mael.android_native_quick_start.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mainchain.mael.android_native_quick_start.R

/**
 * Fragment for the empty part of the activity
 * Basically show nothing but a text in the center of the view
 * to indicate the user for what to do
 * @author Mael MAINCHAIN
 */
class EmptyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_empty,
                container,
                false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
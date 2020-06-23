package com.hi.dhl.hilt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/23
 *     desc  :
 * </pre>
 */
@AndroidEntryPoint
class HiltFragment : Fragment() {
    @Inject
    lateinit var mHiltSimple: HiltSimple
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hilt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHiltSimple.doSomething()
    }
}
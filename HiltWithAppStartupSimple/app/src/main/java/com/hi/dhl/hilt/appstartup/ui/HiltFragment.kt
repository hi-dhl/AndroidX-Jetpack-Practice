package com.hi.dhl.hilt.appstartup.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.hi.dhl.binding.viewbind
import com.hi.dhl.hilt.appstartup.R
import com.hi.dhl.hilt.appstartup.databinding.FragmentHiltBinding
import com.hi.dhl.hilt.appstartup.di.HiltSimple
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/24
 *     desc  :
 * </pre>
 */

/**
 *  如果 注解 fragment 然后还必须注解  fragment 依赖的 Activity, 否则会抛出以下异常
 * java.lang.IllegalStateException: Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: class com.hi.dhl.hilt.appstartup.ui.MainActivity
 */
@AndroidEntryPoint
class HiltFragment : Fragment(R.layout.fragment_hilt) {

    private val binding: FragmentHiltBinding by viewbind()
    private val hiltViewModel: HiltViewModel by activityViewModels()

    // 使用 @Inject 注解从组件中获取依赖
    @Inject
    lateinit var mHiltSimple: HiltSimple

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHiltSimple.doSomething()

        hiltViewModel.mAdressLiveData.observe(viewLifecycleOwner, Observer {
            binding.tvAddress.setText(it)
        })
    }
}
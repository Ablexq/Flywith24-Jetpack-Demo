package com.flywith24.demo_savestate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.flywith24.demo_savestate.databinding.FragmentHostBinding
import com.flywith24.library.base.BaseFragment

/**
 * @author yyz (杨云召)
 * @date   2020/3/17
 * time   14:30
 * description
 */
class HostFragment : BaseFragment<FragmentHostBinding>(R.layout.fragment_host) {
    override fun initBinding(view: View): FragmentHostBinding = FragmentHostBinding.bind(view)

    override fun init(savedInstanceState: Bundle?) {
        binding.button1.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(null)
                replace<FirstFragment>(R.id.container)
            }
        }
    }
}
package com.flywith24.fragment.stack.multiple

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.commit
import com.flywith24.fragment.R
import com.flywith24.fragment.databinding.FragmentMultipleChildBinding
import com.flywith24.fragment.stack.common.BaseStackFragment
import com.flywith24.library.base.ext.MutedColors
import com.flywith24.library.base.ext.args
import com.flywith24.library.base.ext.isDarkTheme

/**
 * @author yyz (杨云召)
 * @date   2020/3/5
 * time   22:36
 * description 多返回栈 子fragment
 */
class MultipleStackChildFragment :
    BaseStackFragment<FragmentMultipleChildBinding>(R.layout.fragment_multiple_child) {
    override fun initBinding(view: View): FragmentMultipleChildBinding =
        FragmentMultipleChildBinding.bind(view)

    val stableTag: String
        get() = "${javaClass.simpleName}-$name-$depth"
    private var name: String by args()
    var depth: Int by args()

    override fun init(savedInstanceState: Bundle?) {
        with(binding.text) {
            text = getString(R.string.fragmentHint, name, getCount(depth))
            textSize = resources.getDimensionPixelSize(R.dimen.large_text).toFloat()
            movementMethod = LinkMovementMethod.getInstance()
            setTextColor(ContextCompat.getColor(requireContext(), R.color.colorWhite))
            setBackgroundColor(
                MutedColors.colorAt(requireContext().isDarkTheme, depth)
            )
            setOnClickListener {
                if (depth < 13) {
                    parentFragmentManager.commit {
                        addToBackStack(name)
                        replace(R.id.content, newInstance(name, depth + 1))
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.done, name),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    companion object {
        fun newInstance(name: String, depth: Int): MultipleStackChildFragment =
            MultipleStackChildFragment().apply {
                this.name = name
                this.depth = depth
            }
    }
}
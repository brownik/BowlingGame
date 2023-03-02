package com.brownik.bowling_game.common_base.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.brownik.bowling_game.common_base.R
import com.brownik.bowling_game.common_ui.showToastSnackBar
import com.brownik.bowling_game.common_util.util.BaseLog
import com.brownik.bowling_game.common_util.util.LifecycleOwnerWrapper

abstract class BaseFragment<Binding : ViewDataBinding> : Fragment(), LifecycleOwnerWrapper {

    companion object {
        private var TAG = BaseFragment::class.java.simpleName
    }

    private var _binding: Binding? = null
    protected val binding get() = _binding!!
    protected abstract val enableBackPressed: Boolean
    private val backPressedCallback by lazy {
        object : OnBackPressedCallback(enableBackPressed) {
            override fun handleOnBackPressed() {
                finishActivity()
                onFragmentBackPressed()
            }
        }
    }

    protected open fun onFragmentBackPressed(): Unit = Unit

    protected abstract fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): Binding

    protected open fun initFragment(savedInstanceState: Bundle?) = Unit

    override fun initLifecycleOwner(): LifecycleOwner = viewLifecycleOwner

    override fun onAttach(context: Context) {
        super.onAttach(context)

        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = createBinding(inflater, container).apply {
        lifecycleOwner = viewLifecycleOwner
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment(savedInstanceState)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    fun showErrorMessage(log: String = "") {
        BaseLog.e(TAG, log)
        showToastSnackBar(R.string.common_error_message)
    }

    fun finishActivity() {
        if (parentFragmentManager.backStackEntryCount == 1) {
            requireBaseActivity().finishActivity()
        }
    }

    fun Fragment.requireBaseActivity(): BaseActivity<*> {
        val activity = requireActivity()
        require(activity is BaseActivity<*>)

        return activity
    }
}
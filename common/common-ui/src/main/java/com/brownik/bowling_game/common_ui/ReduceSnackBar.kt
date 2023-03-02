package com.brownik.bowling_game.common_ui

import android.app.Activity
import android.graphics.Color
import android.view.*
import android.widget.*
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.brownik.bowling_game.common_ui.databinding.SnackbarCustomBinding
import com.brownik.bowling_game.common_util.extension.toPx
import com.brownik.bowling_game.common_util.util.getShapeDrawable
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.contentView

data class SnackBarButton(
    val backgroundRes: Int = 0,
    val clickListener: SnackBarButtonClickListener? = null
)

interface SnackBarButtonClickListener {
    fun onclick()
}

fun Fragment.showToastSnackBar(message: String) {
    requireView().showToastSnackBar(message)
}

fun Fragment.showToastSnackBar(@StringRes message: Int) {
    requireView().showToastSnackBar(getString(message))
}

fun Activity.showToastSnackBar(message: String) {
    contentView?.showToastSnackBar(message)
}

fun Activity.showToastSnackBar(@StringRes message: Int) {
    contentView?.showToastSnackBar(getString(message))
}

private fun View.showToastSnackBar(message: String) {
    ReduceSnackBar.showSnackBar(
        this,
        message,
        textSize = 14f,
        backgroundColor = "#000000",
        radius = 5f
    )
}

class ReduceSnackBar(
    private val view: View,
    private val message: String,
    private val textSize: Float,
    private val textColor: String,
    private val textGravity: Int,
    duration: Int,
    private val backgroundColor: String,
    private val radius: Float,
    private var params: ViewGroup.LayoutParams?,
    private val buttonData: SnackBarButton?
) {

    companion object {

        fun showSnackBar(
            view: View,
            message: String,
            textSize: Float = 0f,
            textColor: String = "#ffffff",
            textGravity: Int = Gravity.CENTER,
            duration: Int = Toast.LENGTH_SHORT,
            backgroundColor: String = "#E6505050",
            radius: Float = 22f,
            params: ViewGroup.LayoutParams? = null,
            buttonData: SnackBarButton? = null
        ) {
            if(message.isNotEmpty()) ReduceSnackBar(view, message, textSize, textColor, textGravity, duration, backgroundColor, radius, params, buttonData)
        }
    }

    private val context = view.context
    private val coordinatorLayout = CoordinatorLayout(context)

    private val snackBar = Snackbar.make(coordinatorLayout, "", duration)
    private val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val snackBarBinding: SnackbarCustomBinding = DataBindingUtil.inflate(inflater, R.layout.snackbar_custom, null, false)

    init {
        initView()
    }

    private fun initView() {
        when (view) {
            is RelativeLayout -> {
                if(params == null){
                    params = RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        addRule(RelativeLayout.CENTER_IN_PARENT)
                    }
                }
                view.addView(coordinatorLayout, params)
            }
            is ConstraintLayout -> {
                if(params == null) {
                    params = ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                        topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                        leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                        rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
                    }
                }
                view.addView(coordinatorLayout, params)
            }
            else -> {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                return
            }
        }

        snackBar.animationMode = Snackbar.ANIMATION_MODE_FADE // 서서히 나타나는 효과
        with(snackBarLayout) {
            removeAllViews()
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            addView(snackBarBinding.root, 0)
        }

        initData()

        snackBar.show()
    }

    private fun initData() {
        snackBarBinding.snackbarText.apply {
            text = message
            if (this@ReduceSnackBar.textSize > 0f) this.textSize = this@ReduceSnackBar.textSize
            setTextColor(Color.parseColor(textColor))
            gravity = textGravity
        }
        snackBarBinding.snackbarLayout.background = getShapeDrawable(radius.toPx(context).toFloat(), backgroundColor, context)

        if (buttonData != null) {
            snackBarBinding.snackbarButton.apply {
                visibility = View.VISIBLE
                background = ResourcesCompat.getDrawable(resources, buttonData.backgroundRes, this.context.theme)
                setOnClickListener {
                    buttonData.clickListener?.onclick()
                }
            }
        }
        else snackBarBinding.snackbarButton.visibility = View.GONE
    }
}

package com.brownik.bowling_game.common_util.util

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.util.Patterns
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.jsoup.Jsoup
import java.io.File
import java.io.IOException

/** SpannableStringBuilder 특정 텍스트 컬러, 볼드, 사이즈, 언더라인 처리 */
fun setSsbSpan(
    ssb: SpannableStringBuilder,
    text: String,
    changeText: String,
    context: Context? = null,
    colorResId: Int = 0,
    colorHex: String = "",
    fontSize: Int = 0,
    isBold: Boolean = false,
    isUnderLine: Boolean = false)
{
    if(!text.contains(changeText)) return

    val start = text.indexOf(changeText).takeIf { it > 0 } ?: 0
    val end = start + changeText.length // 끝 인덱스보다 +1 해줘야함.

    if (fontSize > 0)
        ssb.setSpan(AbsoluteSizeSpan(fontSize, true), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    if (colorResId > 0)
        context?.let { ssb.setSpan(ForegroundColorSpan(ContextCompat.getColor(it, colorResId)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE ) }
    if (colorHex.isNotEmpty())
        ssb.setSpan(ForegroundColorSpan(Color.parseColor(colorHex)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE )
    if (isBold)
        ssb.setSpan(StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    if (isUnderLine)
        ssb.setSpan(UnderlineSpan(), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}

/** GradientDrawable 만들어 반환 */
fun getShapeDrawable(
    radius: Float,
    background: String,
    context: Context? = null,
    strokeWidth: Int = 0,
    strokeColor: String = "#ffffff"): GradientDrawable
{
    return GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        cornerRadius = radius
        setColor(Color.parseColor(background))
        context?.let {
            setStroke(strokeWidth, Color.parseColor(strokeColor))
        }
    }
}
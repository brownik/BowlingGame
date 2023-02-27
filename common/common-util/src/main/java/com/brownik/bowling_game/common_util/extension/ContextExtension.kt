package com.brownik.bowling_game.common_util.extension

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.provider.Settings
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.*
import com.brownik.bowling_game.common_util.util.SingleToast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners

inline val Context.layoutInflater: LayoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

/** 시스템 디바이스 가져오기 */
@SuppressLint("HardwareIds")
fun Context.getDeviceId(): String =
    Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)

/** 시스템 어플 버전 가져오기 */
fun Context.getAppVersion(): String {
    return try {
        this.packageManager.getPackageInfo(this.packageName, 0).versionName
    } catch (e: Exception) {
        ""
    }
}
/** 기기 버전 가져오기 */
fun Context.getAndroidVersion(): String {
    return try {
        Build.VERSION.RELEASE
    } catch (e: Exception) {
        ""
    }
}

fun Context.convertDpToPx(dp: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, this.resources.displayMetrics)

@SuppressLint("UseCompatLoadingForDrawables")
fun Context.drawable(@DrawableRes id: Int): Drawable? = resources.getDrawable(id, null)

fun Context.color(@ColorRes id: Int): Int = resources.getColor(id, null)

fun Context.string(@StringRes id: Int): String = resources.getString(id)

fun Context.dimen(@DimenRes id: Int): Float = resources.getDimension(id)

fun Context.colorStateList(@ColorRes id: Int): ColorStateList = resources.getColorStateList(id, null)

fun Context.getShapeDrawable(
    @ColorInt backgroundColor: Int,
    @ColorInt strokeColor: Int = 0,
    strokeWidth: Int = 0,
    radius: Float
): GradientDrawable {
    return GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        cornerRadius = radius
        setColor(backgroundColor)
        if (strokeWidth > 0) setStroke(strokeWidth, strokeColor)
    }
}

fun Context.showToast(message: String?, duration: Int = Toast.LENGTH_SHORT): Unit =
    SingleToast.showToast(this, message, duration)

fun Context.showToast(@StringRes message: Int?, duration: Int = Toast.LENGTH_SHORT): Unit =
    SingleToast.showToast(this, message, duration)

fun Context.getDeviceWidth(): Int {
    val mWindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = mWindowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size.x
}

fun Context.getDeviceHeight(): Int {
    val mWindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = mWindowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size.y
}

fun Context.getImageRoundBitmap(url: String, round: Float, @DrawableRes error: Int? = null): Bitmap =
    try {
        Glide.with(this)
            .asBitmap()
            .load(url.ifEmpty { error })
            .transform(CenterCrop(), GranularRoundedCorners(round, round, round, round))
            .error(error)
            .submit().get()
    } catch (e: Exception) {
        Glide.with(this)
            .asBitmap()
            .load(error)
            .transform(CenterCrop(), GranularRoundedCorners(round, round, round, round))
            .error(error)
            .submit().get()
    }

fun Context.copyToClipBoard(data: String) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("deepLink", data)
    clipboard.setPrimaryClip(clip)
}

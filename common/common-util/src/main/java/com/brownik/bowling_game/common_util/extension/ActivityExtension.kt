package com.brownik.bowling_game.common_util.extension

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.annotation.IdRes
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.brownik.bowling_game.common_util.util.AppConfig
import kotlin.system.exitProcess

fun FragmentActivity.addFragment(
    @IdRes containerId: Int,
    fragment: Fragment?,
    addBackStack: Boolean = false
) {
    requireNotNull(fragment)

    val transaction = supportFragmentManager.beginTransaction()
    transaction.add(containerId, fragment).apply {
        if (addBackStack) addToBackStack(null)
    }
    transaction.commitAllowingStateLoss()
}

fun FragmentActivity.replaceFragment(
    @IdRes containerId: Int,
    fragment: Fragment?,
    addBackStack: Boolean = false
) {
    requireNotNull(fragment)

    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(containerId, fragment).apply {
        if (addBackStack) addToBackStack(null)
    }
    transaction.commitAllowingStateLoss()
}

fun FragmentActivity.removeFragment(fragment: Fragment?) {
    if (fragment == null) return

    val transaction = supportFragmentManager.beginTransaction()
    transaction.remove(fragment)
    transaction.commitAllowingStateLoss()
}

// 상태바, 시스템바 영역까지 스크린 확장 해야 높이 계산 가능
fun FragmentActivity.getWindowInsetsHeight(view:View, callback: (Int, Int) -> Unit) {
    WindowCompat.setDecorFitsSystemWindows(window, false) // 스크린 확장
    ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
        val types = WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.ime() or WindowInsetsCompat.Type.systemBars()
        val typeInsets = windowInsets.getInsets(types)
        view.setPadding(typeInsets.left, 0, typeInsets.right, typeInsets.bottom)

        AppConfig.statusBarHeight = typeInsets.top
        AppConfig.systemBarHeight = typeInsets.bottom
        callback(typeInsets.top, typeInsets.bottom)
        WindowInsetsCompat.CONSUMED
    }
}

fun Activity.restart() {
    finishAffinity()

    val intent = packageManager.getLaunchIntentForPackage(packageName)!!
    val mainIntent = Intent.makeRestartActivityTask(intent.component)

    System.runFinalization()

    startActivity(mainIntent)
    exitProcess(0)
}

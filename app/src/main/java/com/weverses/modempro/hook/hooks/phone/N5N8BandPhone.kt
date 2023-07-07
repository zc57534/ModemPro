package com.weverses.modempro.hook.hooks.phone

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.weverses.modempro.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge
object N5N8BandPhone : BaseHook() {
    override fun init() {
        try {
            loadClass("miui.telephony.TelephonyManagerEx").methodFinder().first {
                name == "isN5Supported"
            }.createHook{
                returnConstant(true)
            }
            XposedBridge.log("ModemPro: Hook-phone isN5Supported success!")
        } catch (e: Throwable) {
            XposedBridge.log("ModemPro: Hook-phone isN5Supported failed!")
            XposedBridge.log(e)
        }

        try {
            loadClass("miui.telephony.TelephonyManagerEx").methodFinder().first {
                name == "isN8Supported"
            }.createHook{
                returnConstant(true)
            }
            XposedBridge.log("ModemPro: Hook-phone isN8Supported success!")
        } catch (e: Throwable) {
            XposedBridge.log("ModemPro: Hook-phone isN8Supported failed!")
            XposedBridge.log(e)
        }
    }
}


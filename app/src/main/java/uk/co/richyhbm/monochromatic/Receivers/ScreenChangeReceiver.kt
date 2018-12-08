package uk.co.richyhbm.monochromatic.Receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import uk.co.richyhbm.monochromatic.Utilities.SecureSettings

class ScreenChangeReceiver : BroadcastReceiver() {
    fun registerReceiver(context: Context) {
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        context.registerReceiver(this, filter)
    }

    fun unregisterReceiver(context: Context) {
        context.unregisterReceiver(this)
    }

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_SCREEN_ON -> screenOn(context)
            Intent.ACTION_SCREEN_OFF -> screenOff(context)
        }
    }

    private fun screenOn(context: Context) {
        if(SecureSettings.isMonochromeEnabled(context.contentResolver)) {
            SecureSettings.toggleMonochrome(true, context.contentResolver)
        }
    }

    private fun screenOff(context: Context) {

    }
}


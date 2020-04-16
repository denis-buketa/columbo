package denisbuketa.android.columbo.router

import android.content.Intent
import android.util.Log
import denisbuketa.android.columbo.activities.OpenAndCloseActivity

class RouterImpl : Router {

    private val routingContexts: MutableMap<String, MutableList<RoutingContext>> = mutableMapOf()

    override fun registerRoutingContext(routingContext: RoutingContext) {
        Log.d("debug_log", "Register routing context: $routingContext")
        val specificRoutingContexts: MutableList<RoutingContext>? = routingContexts[routingContext.tag]
        if (specificRoutingContexts == null) {
            routingContexts[routingContext.tag] = mutableListOf(routingContext)
        } else {
            specificRoutingContexts.add(routingContext)
        }
        Log.d("debug_log", "    routingContexts: $routingContexts")
    }

    override fun unregisterRoutingContext(routingContext: RoutingContext) {
        Log.d("debug_log", "Unregister routing context: $routingContext")
        val specificRoutingContexts = routingContexts[routingContext.tag]
        if (specificRoutingContexts == null) {
            return
        } else {
            specificRoutingContexts.remove(routingContext)
        }
        Log.d("debug_log", "    routingContexts: $routingContexts")
    }

    override fun openOpenAndCloseActivity(routingContext: RoutingContext) {
        Log.d("debug_log", "openOpenAndCloseActivity")
        with(routingContext.activity) {
            startActivity(Intent(this, OpenAndCloseActivity::class.java))
        }
    }

    override fun closeActivity(routingContext: RoutingContext) {
        Log.d("debug_log", "closeActivity: $routingContext")
        routingContext.activity.finish()
    }
}
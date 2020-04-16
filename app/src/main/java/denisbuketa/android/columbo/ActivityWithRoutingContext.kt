package denisbuketa.android.columbo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import denisbuketa.android.columbo.dependencyinjection.ObjectGraph
import denisbuketa.android.columbo.router.Router
import denisbuketa.android.columbo.router.RoutingContext

/**
 * Activity that knows how to register and unregister its RoutingContext
 */
abstract class ActivityWithRoutingContext : AppCompatActivity() {

    protected val router: Router = ObjectGraph.provideRouter()

    protected val routerContext by lazy { RoutingContext(getTag(), this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("debug_log", "Activity onCreate() - $this")
        router.registerRoutingContext(routerContext)
    }

    override fun onDestroy() {
        Log.d("debug_log", "Activity onDestroy() - $this")
        router.unregisterRoutingContext(routerContext)
        super.onDestroy()
    }

    abstract fun getTag(): String
}
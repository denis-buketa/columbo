package denisbuketa.android.columbo.router

/**
 * Responsible for routing to every screen (activity or fragment) in the application.
 */
interface Router {

    /**
     * Register routing context so that it can be used when needed
     *
     * Should be called from activity's onCreate()
     */
    fun registerRoutingContext(routingContext: RoutingContext)

    /**
     * Unregister routing context because it is no longer needed
     *
     * Should be called from activity's onDestroy()
     */
    fun unregisterRoutingContext(routingContext: RoutingContext)

    fun openOpenAndCloseActivity(routingContext: RoutingContext)

    fun closeActivity(routingContext: RoutingContext)
}
package denisbuketa.android.columbo.dependencyinjection

import denisbuketa.android.columbo.router.Router
import denisbuketa.android.columbo.router.RouterImpl

object ObjectGraph {

    private
    val router: Router = RouterImpl()

    fun provideRouter(): Router = router
}
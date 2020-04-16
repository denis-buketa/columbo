package denisbuketa.android.columbo

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ActivityWithRoutingContext() {

    override fun getTag(): String = MainActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openAndCloseActivity.setOnClickListener { router.openOpenAndCloseActivity(routerContext) }
    }
}

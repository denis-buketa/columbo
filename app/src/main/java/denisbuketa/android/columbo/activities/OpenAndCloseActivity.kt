package denisbuketa.android.columbo.activities

import android.os.Bundle
import denisbuketa.android.columbo.ActivityWithRoutingContext
import denisbuketa.android.columbo.R
import kotlinx.android.synthetic.main.activity_open_and_close.*

class OpenAndCloseActivity : ActivityWithRoutingContext() {

    override fun getTag(): String = OpenAndCloseActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_and_close)

        close.setOnClickListener { router.closeActivity(routerContext) }
    }
}

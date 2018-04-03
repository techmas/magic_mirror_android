package ru.techmas.magicmirror.interfaces.utils_view

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

import ru.techmas.magicmirror.activities.BaseActivity
import ru.techmas.magicmirror.interfaces.views.BaseView

/**
 * Date: 04.06.2017
 * Time: 12:02
 * Project: Android Template

 * @author Alex Bykov
 * *         You can contact me at me@alexbykov.ru
 */
@StateStrategyType(OneExecutionStateStrategy::class)
interface NavigatorActivityView : BaseView {
    fun startActivity(activityClass: Class<out BaseActivity>)
    fun startActivityForResult(activityClass: Class<out BaseActivity>, requestCode: Int)
}

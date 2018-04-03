package ru.techmas.magicmirror.di.components

import javax.inject.Singleton

import dagger.Component
import ru.techmas.magicmirror.App
import ru.techmas.magicmirror.activities.BaseActivity
import ru.techmas.magicmirror.di.modules.ViewModule
import ru.techmas.magicmirror.fragments.BaseFragment

/**
 * Date: 04.06.2017
 * Time: 10:30
 * Project: Android Template

 * @author Alex Bykov
 * *         You can contact me at me@alexbykov.ru
 */


@Singleton
@Component(modules = arrayOf(ViewModule::class))
interface ViewComponent {
    fun inject(app: App)
    fun inject(baseFragment: BaseFragment)
    fun inject(baseActivity: BaseActivity)
}

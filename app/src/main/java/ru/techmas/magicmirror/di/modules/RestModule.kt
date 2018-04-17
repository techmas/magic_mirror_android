package ru.techmas.magicmirror.di.modules

import android.preference.PreferenceManager

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import ru.techmas.magicmirror.App
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.models.AppData
import ru.techmas.magicmirror.utils.presenter.TokenHelper

/**
 * Date: 04.06.2017
 * Time: 10:46
 * Project: Android Template

 * @author Alex Bykov
 * *         You can contact me at me@alexbykov.ru
 */

@Module
class RestModule(app: App) {

    private val tokenHelper: TokenHelper = TokenHelper(PreferenceManager.getDefaultSharedPreferences(app))
    private val restApi: RestApi
    private val appData: AppData

    init {
        restApi = RestApi(tokenHelper)
        appData = AppData()
    }

    @Singleton
    @Provides
    internal fun provideAppData(): AppData {
        return appData
    }

    @Singleton
    @Provides
    internal fun provideRestApi(): RestApi {
        return restApi
    }

    @Singleton
    @Provides
    internal fun provideTokenHelper(): TokenHelper {
        return tokenHelper
    }

}


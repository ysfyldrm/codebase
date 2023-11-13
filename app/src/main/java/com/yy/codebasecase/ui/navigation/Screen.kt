package com.yy.codebasecase.ui.navigation


/**
 * Uygulama içi ekran rotalarını tanımlayan sealed class.
 * Her ekran için bir rota tanımlamak lazım.
 */
sealed class Screen(val route: String) {
    data object PropertyList : Screen("propertyList")
    data object PropertyDetail : Screen("propertyDetail")
}

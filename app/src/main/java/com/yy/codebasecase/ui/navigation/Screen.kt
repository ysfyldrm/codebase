package com.yy.codebasecase.ui.navigation

sealed class Screen(val route: String) {
    data object PropertyList : Screen("propertyList")
    data object PropertyDetail : Screen("propertyDetail")
}

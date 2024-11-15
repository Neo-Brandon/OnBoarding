package com.example.boardingapp.onBoardViews

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.boardingapp.R
import com.example.boardingapp.data.PageData
import com.example.boardingapp.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class,ExperimentalFoundationApi::class)
@Composable
fun MainOnBoarding(navController: NavController, store: StoreBoarding){
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.page1,
            titulo ="Bienvenido ¿Te gustan los Tacos?",
            descripcion = "Los tacos al pastor son muy buenos - Deslizar para continuar"
        )
    )

    items.add(
        PageData(R.raw.page2,
            titulo = "Quizas tengo algo de hambre ahora",
            descripcion = "Programar da hambre  - Deslizar para continuar")
    )

    items.add(
        PageData(R.raw.page3,
            titulo = "Su aplicación de confianza",
            descripcion = "Bienveido  a su taqueria de confianza" +
                            "Pulse para continuar"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(item=items, pagerState=pagerState, modifier = Modifier
        .fillMaxWidth()
        .background(Color.White),
        navController, store)
}

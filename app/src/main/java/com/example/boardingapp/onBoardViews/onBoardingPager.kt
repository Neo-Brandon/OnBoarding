package com.example.boardingapp.onBoardViews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.boardingapp.data.PageData
import com.example.boardingapp.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item:List<PageData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController,
    store: StoreBoarding
){
    Box(modifier=Modifier){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            HorizontalPager(state=pagerState) {
                // Se agregan 3 elementos, imagen, titulo y descipcion
                page->
                Column(
                    modifier = Modifier
                        .padding(60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    LoaderData(modifier=Modifier
                        .size(200.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                        item[page].imagen
                    )
                }
            }
            PagerIndicator(item.size,pagerState.currentPage)
        }
        Box(modifier=Modifier.align(Alignment.BottomCenter)){
            ButtonFinish(pagerState.currentPage,navController,store)
        }
    }
}
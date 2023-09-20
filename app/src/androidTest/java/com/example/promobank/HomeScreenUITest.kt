package com.example.promobank

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.promobank.data.datasource.fake.promoItemMockList
import com.example.promobank.ui.screen.home.HomeScreenUIContent
import com.example.promobank.ui.screen.home.HomeUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val mockHomeUIState: HomeUiState = HomeUiState(
        isFetching = false,
        tempPromoList = promoItemMockList
    )


    @Composable
    private fun HomeScreenUIContentTest(
        selectedPromo: (actorId: Int) -> Unit = { },
        homeUiState: HomeUiState = mockHomeUIState
    ) {
        HomeScreenUIContent(homeUiState, selectedPromo)
    }

    @Test
    fun assertListPromoIsExist() {
        composeTestRule.setContent {
            HomeScreenUIContentTest()
        }

        composeTestRule.onNodeWithTag("List Promo").assertIsDisplayed()
    }

    @Test
    fun assertItemListPromoIsExist() {
        composeTestRule.setContent {
            HomeScreenUIContentTest()
        }
        composeTestRule.onNodeWithText("BNI Credit Card").assertIsDisplayed()
    }

    @Test
    fun assertPerformClickSomeItemPromo() {
        composeTestRule.setContent {
            HomeScreenUIContentTest(selectedPromo = {  })
        }
        composeTestRule.onNodeWithText("BNI Credit Card").performClick()
        composeTestRule.onNodeWithText("Pejompongan").assertIsDisplayed()
    }

    @Test
    fun assertScrollItemListToSpecificIndexedList() {
        composeTestRule.setContent { HomeScreenUIContentTest() }
        composeTestRule.onNodeWithTag("List Promo").performScrollToIndex(1)
    }
}
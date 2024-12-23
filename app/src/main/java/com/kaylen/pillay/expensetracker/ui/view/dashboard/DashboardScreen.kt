package com.kaylen.pillay.expensetracker.ui.view.dashboard

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.dashboard.event.DashboardScreenEventContract
import com.kaylen.pillay.expensetracker.ui.view.dashboard.state.DashboardStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.TopAppBarSharedComponent
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.state.TopAppBarSharedStateModel

/*
 * Designed and developed by Kaylen Travis Pillay.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@Composable
internal fun DashboardScreen(
    state: DashboardStateModel,
    eventContract: DashboardScreenEventContract?,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarSharedComponent(
                state = state.topAppBar,
                eventContract = eventContract
            )
        }
    ) { contentInsets ->
        Text(
            modifier = Modifier.padding(contentInsets),
            text = "Hi, I'm the expense tracker app."
        )
    }
}

private val previewState = DashboardStateModel(
    topAppBar = TopAppBarSharedStateModel(
        title = "Expense Tracker App"
    )
)

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewDashboardScreen_Night() {
    val previewEventContract: DashboardScreenEventContract? = null

    ExpenseTrackerTheme {
        DashboardScreen(previewState, previewEventContract)
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewDashboardScreen_Day() {
    val previewEventContract: DashboardScreenEventContract? = null

    ExpenseTrackerTheme {
        DashboardScreen(previewState, previewEventContract)
    }
}

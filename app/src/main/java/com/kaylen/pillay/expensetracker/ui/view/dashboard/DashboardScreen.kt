package com.kaylen.pillay.expensetracker.ui.view.dashboard

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.dashboard.component.summary.DashboardSummaryComponent
import com.kaylen.pillay.expensetracker.ui.view.dashboard.component.summary.event.DashboardSummaryEventContract
import com.kaylen.pillay.expensetracker.ui.view.dashboard.component.summary.state.DashboardSummaryStateModel
import com.kaylen.pillay.expensetracker.ui.view.dashboard.event.DashboardScreenEventContract
import com.kaylen.pillay.expensetracker.ui.view.dashboard.state.DashboardStateModel
import com.kaylen.pillay.expensetracker.ui.view.dashboard.state.DashboardSummaryItemStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.BottomAppBarSharedComponent
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.state.BottomAppBarSharedOptionStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.state.BottomAppBarSharedStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.TopAppBarSharedComponent
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.state.TopAppBarSharedStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.transactionsummary.TransactionSummarySharedComponent
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.transactionsummary.state.TransactionSummarySharedStateModel
import kotlinx.collections.immutable.toImmutableList

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
        },
        bottomBar = {
            BottomAppBarSharedComponent(
                state = state.bottomAppBar,
                eventContract = eventContract
            )
        }
    ) { contentInsets ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentInsets)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ) {
            state.summaryItems.forEach { item ->
                when (item) {
                    is DashboardSummaryItemStateModel.TransactionSummary -> {
                        DashboardSummaryTransaction(
                            state = item,
                            eventContract = eventContract
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DashboardSummaryTransaction(
    state: DashboardSummaryItemStateModel.TransactionSummary,
    eventContract: DashboardSummaryEventContract?,
    modifier: Modifier = Modifier
) {
    DashboardSummaryComponent(
        modifier = modifier.fillMaxWidth(),
        state = state.summary,
        eventContract = eventContract
    ) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            state.transactionSummary.forEach { transaction ->
                TransactionSummarySharedComponent(
                    state = transaction,
                    modifier = Modifier
                        .clickable { eventContract?.onDashboardSummaryTransactionClick(transaction) }
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

private val previewState = DashboardStateModel(
    topAppBar = TopAppBarSharedStateModel(
        title = "Expense Tracker App"
    ),
    bottomAppBar = BottomAppBarSharedStateModel(
        options = listOf(
            BottomAppBarSharedOptionStateModel(
                id = "Option-1",
                contentDescription = "Option 1",
                imageVector = Icons.Default.Add
            )
        ).toImmutableList(),
        floatingActionButtonCTA = "Add"
    ),
    summaryItems = listOf(
        DashboardSummaryItemStateModel.TransactionSummary(
            summary = DashboardSummaryStateModel(
                title = "Transaction Summary",
                subtitle = "The last 3 transactions logged. Selecting 'View More' will provide you with a more detailed account of your transactions.",
                expandCTATitle = "View More"
            ),
            transactionSummary = listOf(
                TransactionSummarySharedStateModel(
                    id = "001",
                    date = "27/12/2024",
                    amount = "R121.30",
                    category = "\uD83E\uDD58 Food",
                    account = "Demo Amex",
                    note = "Bought some KFC for a group of friends"
                )
            ).toImmutableList()
        )
    ).toImmutableList()
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

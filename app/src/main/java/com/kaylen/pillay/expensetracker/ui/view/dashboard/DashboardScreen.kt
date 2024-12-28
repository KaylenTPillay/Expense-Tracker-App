package com.kaylen.pillay.expensetracker.ui.view.dashboard

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.dashboard.event.DashboardScreenEventContract
import com.kaylen.pillay.expensetracker.ui.view.dashboard.state.DashboardStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.BottomAppBarSharedComponent
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.state.BottomAppBarSharedOptionStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.state.BottomAppBarSharedStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.TopAppBarSharedComponent
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.state.TopAppBarSharedStateModel
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
            DashboardTransactionSummary(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun DashboardTransactionSummary(
    modifier: Modifier = Modifier
) {
    OutlinedCard(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            DashboardTransactionSummaryTitle()
            DashboardTransactionSummarySubtitle()
        }
    }
}

@Composable
private fun DashboardTransactionSummaryTitle() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(start = 16.dp),
            text = "Transaction Summary",
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.width(16.dp))
        TextButton(
            onClick = {},
            modifier = Modifier
                .padding(end = 4.dp)
        ) {
            Text("View More")
        }
    }
}

@Composable
private fun DashboardTransactionSummarySubtitle() {
    Text(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        style = MaterialTheme.typography.labelMedium,
        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    )
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

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewDashboardTransactionSummary_Night() {
    ExpenseTrackerTheme {
        DashboardTransactionSummary()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewDashboardTransactionSummary_Day() {
    ExpenseTrackerTheme {
        DashboardTransactionSummary()
    }
}

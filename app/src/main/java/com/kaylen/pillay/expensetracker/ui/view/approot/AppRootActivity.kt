package com.kaylen.pillay.expensetracker.ui.view.approot

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import com.kaylen.pillay.expensetracker.R
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.dashboard.DashboardScreen
import com.kaylen.pillay.expensetracker.ui.view.dashboard.component.summary.state.DashboardSummaryStateModel
import com.kaylen.pillay.expensetracker.ui.view.dashboard.event.DashboardScreenEventContract
import com.kaylen.pillay.expensetracker.ui.view.dashboard.state.DashboardStateModel
import com.kaylen.pillay.expensetracker.ui.view.dashboard.state.DashboardSummaryItemStateModel
import com.kaylen.pillay.expensetracker.ui.view.managetransaction.state.ManageTransactionStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.state.BottomAppBarSharedOptionStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.state.BottomAppBarSharedStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.fullscreendialog.state.FullScreenDialogSharedStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.state.TopAppBarSharedStateModel
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

class AppRootActivity : ComponentActivity() {

    private val demoState = DashboardStateModel(
        topAppBar = TopAppBarSharedStateModel(
            title = "Expense Tracker",
            subtitle = "Dashboard"
        ),
        bottomAppBar = BottomAppBarSharedStateModel(
            options = listOf(
                BottomAppBarSharedOptionStateModel(
                    id = "Option-1",
                    contentDescription = "Option 1",
                    resourceId = R.drawable.material_icon_dashboard,
                    isSelected = true
                ),
                BottomAppBarSharedOptionStateModel(
                    id = "Option-2",
                    contentDescription = "Option 2",
                    resourceId = R.drawable.material_icon_analytics,
                ),
                BottomAppBarSharedOptionStateModel(
                    id = "Option-3",
                    contentDescription = "Option 3",
                    resourceId = R.drawable.material_icon_database,
                ),
                BottomAppBarSharedOptionStateModel(
                    id = "Option-4",
                    contentDescription = "Option 4",
                    imageVector = Icons.Default.Settings
                )
            ).toImmutableList(),
            floatingActionButtonCTA = "New"
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
                    ),
                    TransactionSummarySharedStateModel(
                        id = "002",
                        date = "27/12/2024",
                        amount = "R6999.00",
                        category = "\uD83D\uDD79\uFE0F Gaming",
                        account = "Demo Standard Bank",
                        note = "PS5 purchase"
                    ),
                    TransactionSummarySharedStateModel(
                        id = "003",
                        date = "27/12/2024",
                        amount = "R235.50",
                        category = "Insurance",
                        account = "Demo Amex",
                        note = "Paid life insurance"
                    )
                ).toImmutableList()
            )
        ).toImmutableList(),
        fullScreenDialog = FullScreenDialogSharedStateModel(
            topAppBar = TopAppBarSharedStateModel(
                title = "Expense Tracker",
                subtitle = "Manage Transaction",
                navigationIcon = true
            )
        ),
        manageTransactionState = ManageTransactionStateModel()
    )

    private val eventContract: DashboardScreenEventContract =
        object : DashboardScreenEventContract {

            override fun onTopAppBarNavigationIconClick() {
                Toast.makeText(this@AppRootActivity, "Navigation Icon Click", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onBottomAppBarFABClick() {
                Toast.makeText(this@AppRootActivity, "Bottom App Bar FAB Click", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onBottomAppBarOptionClick(optionId: String) {
                Toast.makeText(
                    this@AppRootActivity,
                    "Bottom App Bar Option Click: $optionId",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onDashboardSummaryExpandClick() {
                Toast.makeText(
                    this@AppRootActivity,
                    "Summary item clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onDashboardSummaryTransactionClick(state: TransactionSummarySharedStateModel) {
                Toast.makeText(
                    this@AppRootActivity,
                    "Transaction Summary item clicked: ${state.id}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerTheme {
                DashboardScreen(state = demoState, eventContract = eventContract)
            }
        }
    }

}

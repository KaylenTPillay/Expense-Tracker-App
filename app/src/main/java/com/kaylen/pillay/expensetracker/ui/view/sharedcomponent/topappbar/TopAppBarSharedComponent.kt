package com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.event.TopAppBarSharedEventContract
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSharedComponent(
    state: TopAppBarSharedStateModel,
    eventContract: TopAppBarSharedEventContract?,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = state.title)

                if (state.subtitle != null) {
                    Text(text = state.subtitle, style = MaterialTheme.typography.titleSmall)
                }
            }
        },
        navigationIcon = {
            TopAppBarNavigationIcon(
                displayNavigationIcon = state.navigationIcon,
                eventContract = eventContract
            )
        }
    )
}

@Composable
private fun TopAppBarNavigationIcon(
    displayNavigationIcon: Boolean,
    eventContract: TopAppBarSharedEventContract?
) {
    if (!displayNavigationIcon) return

    IconButton(onClick = { eventContract?.onTopAppBarNavigationIconClick() }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back Navigation Button"
        )
    }
}

private val previewState = TopAppBarSharedStateModel(
    title = "Expense Tracker App",
    subtitle = "Dashboard",
    navigationIcon = true
)

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewTopAppBarSharedComponent_Night() {
    val previewEventContract: TopAppBarSharedEventContract? = null

    ExpenseTrackerTheme {
        TopAppBarSharedComponent(previewState, previewEventContract)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewTopAppBarSharedComponent_Day() {
    val previewEventContract: TopAppBarSharedEventContract? = null

    ExpenseTrackerTheme {
        TopAppBarSharedComponent(previewState, previewEventContract)
    }
}

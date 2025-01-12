package com.kaylen.pillay.expensetracker.ui.view.managetransaction

import android.content.res.Configuration
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.managetransaction.event.ManageTransactionEventContract
import com.kaylen.pillay.expensetracker.ui.view.managetransaction.state.ManageTransactionStateModel
import com.kaylen.pillay.expensetracker.ui.view.managetransaction.state.ManageTransactionType

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
fun ManageTransactionComponent(
    state: ManageTransactionStateModel,
    eventContract: ManageTransactionEventContract?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.scrollable(
            state = rememberScrollState(),
            orientation = Orientation.Vertical
        ).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ManageTransactionTypeContainer(
            state = state.type,
            eventContract = eventContract,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        HorizontalDivider()
    }
}

@Composable
private fun ManageTransactionTypeContainer(
    state: ManageTransactionType,
    eventContract: ManageTransactionEventContract?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.scrollable(
            state = rememberScrollState(),
            orientation = Orientation.Horizontal
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ManageTransactionType.entries.forEach { entry ->
            ManageTransactionTypeChip(
                isChecked = entry == state,
                type = entry.name,
                eventContract = eventContract
            )
        }
    }
}

@Composable
private fun ManageTransactionTypeChip(
    isChecked: Boolean,
    type: String,
    eventContract: ManageTransactionEventContract?,
    modifier: Modifier = Modifier,
) {
    FilterChip(
        onClick = { eventContract?.onTransactionTypeClick(type) },
        label = {
            Text(type)
        },
        selected = isChecked,
        leadingIcon = if (isChecked) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        modifier = modifier
    )
}

private val previewState = ManageTransactionStateModel()
private val previewEventContract: ManageTransactionEventContract? = null

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewManageTransactionComponent_Day() {
    ExpenseTrackerTheme {
        ManageTransactionComponent(previewState, previewEventContract)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewManageTransactionComponent_Night() {
    ExpenseTrackerTheme {
        ManageTransactionComponent(previewState, previewEventContract)
    }
}

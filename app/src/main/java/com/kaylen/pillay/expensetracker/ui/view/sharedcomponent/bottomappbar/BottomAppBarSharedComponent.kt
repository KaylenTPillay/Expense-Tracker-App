package com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.event.BottomAppBarSharedEventContract
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.state.BottomAppBarSharedOptionStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.state.BottomAppBarSharedStateModel
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
fun BottomAppBarSharedComponent(
    state: BottomAppBarSharedStateModel,
    eventContract: BottomAppBarSharedEventContract?,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier,
        actions = {
            state.options.forEach { option ->
                IconButton(
                    onClick = { eventContract?.onBottomAppBarOptionClick(option.id) }
                ) {
                    val iconColor = if (option.isSelected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }

                    if (option.imageVector != null) {
                        Icon(
                            imageVector = option.imageVector,
                            contentDescription = option.contentDescription,
                            tint = iconColor
                        )
                    }

                    if (option.resourceId != null) {
                        Icon(
                            painter = painterResource(option.resourceId),
                            contentDescription = option.contentDescription,
                            tint = iconColor
                        )
                    }
                }
            }
        },
        floatingActionButton = if (state.floatingActionButtonCTA != null) {
            {
                BottomAppBarFloatingActionButton(
                    title = state.floatingActionButtonCTA,
                    eventContract = eventContract
                )
            }
        } else {
            null
        }
    )
}

@Composable
private fun BottomAppBarFloatingActionButton(
    title: String,
    eventContract: BottomAppBarSharedEventContract?,
    modifier: Modifier = Modifier
) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        onClick = {
            eventContract?.onBottomAppBarFABClick()
        },
        icon = {
            Icon(imageVector = Icons.Default.Add, contentDescription = title)
        },
        text = {
            Text(text = title)
        }
    )
}

private val previewState = BottomAppBarSharedStateModel(
    options = listOf(
        BottomAppBarSharedOptionStateModel(
            id = "Option-1",
            contentDescription = "Option 1",
            imageVector = Icons.AutoMirrored.Outlined.List,
        )
    ).toImmutableList(),
    floatingActionButtonCTA = "Add Expense"
)
private val previewEventContract: BottomAppBarSharedEventContract? = null

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewBottomAppBarSharedComponent_Night() {
    ExpenseTrackerTheme {
        BottomAppBarSharedComponent(previewState, previewEventContract)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewBottomAppBarSharedComponent_Day() {
    ExpenseTrackerTheme {
        BottomAppBarSharedComponent(previewState, previewEventContract)
    }
}

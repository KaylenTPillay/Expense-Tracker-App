package com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.fullscreendialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.fullscreendialog.state.FullScreenDialogSharedStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.TopAppBarSharedComponent
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

@Composable
internal fun FullScreenDialogSharedComponent(
    state: FullScreenDialogSharedStateModel,
    modifier: Modifier = Modifier,
    content: @Composable (contentInsets: PaddingValues) -> Unit
) {
    val dialogProperties = remember { DialogProperties(usePlatformDefaultWidth = false) }
    val showDialog = remember { mutableStateOf(true) }

    if (!showDialog.value) return

    Dialog(onDismissRequest = { showDialog.value = false }, properties = dialogProperties) {
        val topAppBarController = object : TopAppBarSharedEventContract {
            override fun onTopAppBarNavigationIconClick() {
                showDialog.value = false
            }
        }

        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                TopAppBarSharedComponent(state.topAppBar, topAppBarController)
            }
        ) { contentInsets ->
            content(contentInsets)
        }
    }
}

private val previewState = FullScreenDialogSharedStateModel(
    topAppBar = TopAppBarSharedStateModel(
        title = "Full Screen Dialog",
        subtitle = "I'm used for demo"
    )
)

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewFullScreenDialogSharedComponent_Day() {
    ExpenseTrackerTheme {
        FullScreenDialogSharedComponent(previewState) { contentInsets ->
            Text(modifier = Modifier.padding(contentInsets), text = "Hello World")
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewFullScreenDialogSharedComponent_Night() {
    ExpenseTrackerTheme {
        FullScreenDialogSharedComponent(previewState) { contentInsets ->
            Text(modifier = Modifier.padding(contentInsets), text = "Hello World")
        }
    }
}

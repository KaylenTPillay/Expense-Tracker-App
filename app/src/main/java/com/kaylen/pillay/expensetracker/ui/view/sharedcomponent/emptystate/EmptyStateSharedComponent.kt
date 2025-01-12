package com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.emptystate

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.emptystate.state.EmptyStateSharedIconType
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.emptystate.state.EmptyStateSharedStateModel

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
fun EmptyStateSharedComponent(
    state: EmptyStateSharedStateModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.icon != null) {
            Icon(
                modifier = Modifier.size(64.dp),
                imageVector = ImageVector.vectorResource(state.icon.iconRes),
                contentDescription = "Empty state icon",
                tint = state.icon.colour ?: LocalContentColor.current
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Text(state.title, style = MaterialTheme.typography.titleSmall)

        if (state.message != null) {
            Text(state.message, style = MaterialTheme.typography.labelSmall)
        }
    }
}

private val previewState = EmptyStateSharedStateModel(
    title = "Empty State title",
    message = "Empty State message",
    icon = EmptyStateSharedIconType.Wallet
)

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewEmptyStateSharedComponent_Day() {
    ExpenseTrackerTheme {
        EmptyStateSharedComponent(previewState)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewEmptyStateSharedComponent_Night() {
    ExpenseTrackerTheme {
        EmptyStateSharedComponent(previewState)
    }
}

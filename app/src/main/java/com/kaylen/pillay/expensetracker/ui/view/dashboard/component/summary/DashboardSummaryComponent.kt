package com.kaylen.pillay.expensetracker.ui.view.dashboard.component.summary

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.dashboard.component.summary.event.DashboardSummaryEventContract
import com.kaylen.pillay.expensetracker.ui.view.dashboard.component.summary.state.DashboardSummaryStateModel

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
internal fun DashboardSummaryComponent(
    state: DashboardSummaryStateModel,
    eventContract: DashboardSummaryEventContract?,
    modifier: Modifier = Modifier,
    content: (@Composable ColumnScope.() -> Unit)? = null
) {
    OutlinedCard(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            DashboardSummaryTitle(
                title = state.title,
                expandCTATitle = state.expandCTATitle,
                eventContract = eventContract
            )
            DashboardSummarySubtitle(
                subtitle = state.subtitle
            )
            HorizontalDivider()
            content?.invoke(this)
        }
    }
}

@Composable
private fun DashboardSummaryTitle(
    title: String,
    expandCTATitle: String?,
    eventContract: DashboardSummaryEventContract?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val titleTopPadding = if (expandCTATitle != null) 0.dp else 16.dp
        val titleEndPadding = if (expandCTATitle != null) 0.dp else 16.dp
        val titleBottomPadding = if (expandCTATitle != null) 0.dp else 8.dp

        Text(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = titleTopPadding,
                    end = titleEndPadding,
                    bottom = titleBottomPadding
                ),
            text = title,
            style = MaterialTheme.typography.titleSmall
        )

        if (expandCTATitle != null) {
            Spacer(modifier = Modifier.width(16.dp))
            TextButton(
                onClick = { eventContract?.onDashboardSummaryExpandClick() },
                modifier = Modifier
                    .padding(end = 4.dp)
            ) {
                Text(expandCTATitle)
            }
        }
    }
}

@Composable
private fun DashboardSummarySubtitle(
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        style = MaterialTheme.typography.labelMedium,
        text = subtitle
    )
}

private val previewState = DashboardSummaryStateModel(
    title = "Summary Example",
    subtitle = "This is an example of a summary subtitle.",
    expandCTATitle = "View More"
)
private val previewEventContract: DashboardSummaryEventContract? = null

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewDashboardSummary_Night() {
    ExpenseTrackerTheme {
        DashboardSummaryComponent(previewState, previewEventContract) {
            Text(modifier = Modifier.padding(16.dp), text = "Preview Content")
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewDashboardSummary_Day() {
    ExpenseTrackerTheme {
        DashboardSummaryComponent(previewState, previewEventContract) {
            Text(modifier = Modifier.padding(16.dp), text = "Preview Content")
        }
    }
}

package com.kaylen.pillay.expensetracker.ui.view.approot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kaylen.pillay.expensetracker.ui.theme.ExpenseTrackerTheme
import com.kaylen.pillay.expensetracker.ui.view.developersetting.colourpalette.DevSettingsColourPaletteScreen
import com.kaylen.pillay.expensetracker.ui.view.developersetting.colourpalette.state.DevSettingsColourPaletteStateModel

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

    private val colourPaletteDemoState = DevSettingsColourPaletteStateModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerTheme {
                DevSettingsColourPaletteScreen(state = colourPaletteDemoState)
            }
        }
    }

}

package com.mostafa.moviesclone.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.mostafa.moviesclone.MoviezDatabase

class AndroidDatabaseDriverFactory(
    private val context: Context
) : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = MoviezDatabase.Schema,
            context = context,
            name = "moviez.db"
        )
    }
}
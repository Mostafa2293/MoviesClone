package com.mostafa.moviesclone.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.mostafa.moviesclone.MoviezDatabase

class IOSDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = MoviezDatabase.Schema,
            name = "moviez.db"
        )
    }
}
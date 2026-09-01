package com.cyberleveling.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface SyncRepository {
    fun syncOfflineProgress(): Flow<Boolean>
}

class SyncRepositoryImpl : SyncRepository {
    override fun syncOfflineProgress(): Flow<Boolean> = flow {
        emit(true)
    }
}

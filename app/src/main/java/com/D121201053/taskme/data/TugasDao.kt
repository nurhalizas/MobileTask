package com.D121201053.taskme.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.D121201053.taskme.model.Tugas

@Dao
interface TugasDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTugas(tugas: Tugas)

    @Query("SELECT * FROM tugas WHERE status_tugas='Belum Selesai'")
    fun readAllDataHome():LiveData<List<Tugas>>

    @Query("SELECT * FROM tugas WHERE status_tugas='Selesai'")
    fun readAllDataRiwayat():LiveData<List<Tugas>>
    @Update
    suspend fun updateTugas(tugas: Tugas)

    @Delete
    suspend fun deleteTugas(tugas: Tugas)
}
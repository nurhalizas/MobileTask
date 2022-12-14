package com.D121201053.taskme.repository

import androidx.lifecycle.LiveData
import com.D121201053.taskme.data.TugasDao
import com.D121201053.taskme.model.Tugas

class TugasRepository(private val tugasDao:TugasDao) {
    val readAllData: LiveData<List<Tugas>> = tugasDao.readAllDataHome()
    val readAllDataHistory: LiveData<List<Tugas>> = tugasDao.readAllDataRiwayat()
    suspend fun addTugas(tugas: Tugas){
        tugasDao.addTugas(tugas)
    }
    suspend fun updateTugas(tugas: Tugas){
        tugasDao.updateTugas(tugas)
    }
    suspend fun deleteTugas(tugas: Tugas){
        tugasDao.deleteTugas(tugas)
    }
}
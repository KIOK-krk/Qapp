package com.example.nekikviz


import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

object DataRepository {
    private val db = Firebase.firestore

    fun dohvatiPredmete(): Flow<List<Predmet>> = callbackFlow addSnapshotListener@{
// ovdje stvaramo pokazivac na kolekciju Predmeti i smjestamo ga u varijablu collectionReferenca
        val collectionReferenca = db.collection("Predmeti")

        // slusaj promjene na kolekciji Predmeti
        val slusajPromjene = collectionReferenca.addSnapshotListener { snapshot, e ->
            if (e != null) {
                close(e)
                return@addSnapshotListener
            }
            // Ako nema greske, mapiramo dokumente u listu Predmeta
            val predmeti =
                snapshot?.documents?.mapNotNull { it.toObject((Predmet::class.java)) }.orEmpty()
            // Pokusamo poslati listu predmeta kroz Flow
            trySend(predmeti).isSuccess
        }
        // Kada nam Flow vise nije potreban, uklanjamo slusaca promjene
        awaitClose { slusajPromjene.remove() }
        }
}
package mongga.regawa.imdb.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movTitle: String,
    val movImage: Int,
    val movYear: Int,
    val movRating: Double,
    val movMpaRating: String,
    val movTime: String,
    val movSynopsis: String,
    val movGenre: String,
    val movTrailer: String
):Parcelable
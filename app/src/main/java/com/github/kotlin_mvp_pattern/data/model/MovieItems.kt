package com.github.kotlin_mvp_pattern.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by User on 1/12/2019.
 */

class MovieItems() : Parcelable {
    @SerializedName("vote_count")
    @Expose
    var voteCount: Int = 0
    var id: Int = 0
    var isVideo: Boolean = false
    @SerializedName("vote_average")
    @Expose
    var voteAverage: String? = null
    var title: String? = null
    var popularity: Double = 0.toDouble()
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null
    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null
    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null
    var isAdult: Boolean = false
    var overview: String? = null
    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    constructor(parcel: Parcel) : this() {
        voteCount = parcel.readInt()
        id = parcel.readInt()
        isVideo = parcel.readByte() != 0.toByte()
        voteAverage = parcel.readString()
        title = parcel.readString()
        popularity = parcel.readDouble()
        posterPath = parcel.readString()
        originalLanguage = parcel.readString()
        originalTitle = parcel.readString()
        backdropPath = parcel.readString()
        isAdult = parcel.readByte() != 0.toByte()
        overview = parcel.readString()
        releaseDate = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(voteCount)
        parcel.writeInt(id)
        parcel.writeByte(if (isVideo) 1 else 0)
        parcel.writeString(voteAverage)
        parcel.writeString(title)
        parcel.writeDouble(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(backdropPath)
        parcel.writeByte(if (isAdult) 1 else 0)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieItems> {
        override fun createFromParcel(parcel: Parcel): MovieItems {
            return MovieItems(parcel)
        }

        override fun newArray(size: Int): Array<MovieItems?> {
            return arrayOfNulls(size)
        }
    }

}

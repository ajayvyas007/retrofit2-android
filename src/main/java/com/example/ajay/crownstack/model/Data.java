package com.example.ajay.crownstack.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {

    private String collectionExplicitness;

    private String trackCensoredName;

    private String artworkUrl60;

    private int collectionId;

    private int discCount;

    private int trackTimeMillis;

    private String collectionViewUrl;

    private String wrapperType;

    private String trackName;

    private String kind;

    private String currency;

    private String releaseDate;

    private String artistId;

    private String collectionCensoredName;

    private String collectionName;

    private int trackCount;

    private int trackId;

    private String artworkUrl30;

    private String primaryGenreName;

    private int trackNumber;

    private int discNumber;

    private String country;

    private String previewUrl;

    private String trackExplicitness;

    private String artistViewUrl;

    private double trackPrice;

    private boolean isStreamable;

    private String artistName;

    private String artworkUrl100;

    private String trackViewUrl;

    private double collectionPrice;

    public Data() {
    }

    protected Data(Parcel in) {
        collectionExplicitness = in.readString();
        trackCensoredName = in.readString();
        artworkUrl60 = in.readString();
        collectionId = in.readInt();
        discCount = in.readInt();
        trackTimeMillis = in.readInt();
        collectionViewUrl = in.readString();
        wrapperType = in.readString();
        trackName = in.readString();
        kind = in.readString();
        currency = in.readString();
        releaseDate = in.readString();
        artistId = in.readString();
        collectionCensoredName = in.readString();
        collectionName = in.readString();
        trackCount = in.readInt();
        trackId = in.readInt();
        artworkUrl30 = in.readString();
        primaryGenreName = in.readString();
        trackNumber = in.readInt();
        discNumber = in.readInt();
        country = in.readString();
        previewUrl = in.readString();
        trackExplicitness = in.readString();
        artistViewUrl = in.readString();
        trackPrice = in.readDouble();
        isStreamable = in.readByte() != 0;
        artistName = in.readString();
        artworkUrl100 = in.readString();
        trackViewUrl = in.readString();
        collectionPrice = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(collectionExplicitness);
        dest.writeString(trackCensoredName);
        dest.writeString(artworkUrl60);
        dest.writeInt(collectionId);
        dest.writeInt(discCount);
        dest.writeInt(trackTimeMillis);
        dest.writeString(collectionViewUrl);
        dest.writeString(wrapperType);
        dest.writeString(trackName);
        dest.writeString(kind);
        dest.writeString(currency);
        dest.writeString(releaseDate);
        dest.writeString(artistId);
        dest.writeString(collectionCensoredName);
        dest.writeString(collectionName);
        dest.writeInt(trackCount);
        dest.writeInt(trackId);
        dest.writeString(artworkUrl30);
        dest.writeString(primaryGenreName);
        dest.writeInt(trackNumber);
        dest.writeInt(discNumber);
        dest.writeString(country);
        dest.writeString(previewUrl);
        dest.writeString(trackExplicitness);
        dest.writeString(artistViewUrl);
        dest.writeDouble(trackPrice);
        dest.writeByte((byte) (isStreamable ? 1 : 0));
        dest.writeString(artistName);
        dest.writeString(artworkUrl100);
        dest.writeString(trackViewUrl);
        dest.writeDouble(collectionPrice);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getCollectionExplicitness ()
    {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness (String collectionExplicitness)
    {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackCensoredName ()
    {
        return trackCensoredName;
    }

    public void setTrackCensoredName (String trackCensoredName)
    {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtworkUrl60 ()
    {
        return artworkUrl60;
    }

    public void setArtworkUrl60 (String artworkUrl60)
    {
        this.artworkUrl60 = artworkUrl60;
    }

    public int getCollectionId ()
    {
        return collectionId;
    }

    public void setCollectionId (int collectionId)
    {
        this.collectionId = collectionId;
    }

    public int getDiscCount ()
    {
        return discCount;
    }

    public void setDiscCount (int discCount)
    {
        this.discCount = discCount;
    }

    public int getTrackTimeMillis ()
    {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis (int trackTimeMillis)
    {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCollectionViewUrl ()
    {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl (String collectionViewUrl)
    {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getWrapperType ()
    {
        return wrapperType;
    }

    public void setWrapperType (String wrapperType)
    {
        this.wrapperType = wrapperType;
    }

    public String getTrackName ()
    {
        return trackName;
    }

    public void setTrackName (String trackName)
    {
        this.trackName = trackName;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    public String getReleaseDate ()
    {
        return releaseDate;
    }

    public void setReleaseDate (String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getArtistId ()
    {
        return artistId;
    }

    public void setArtistId (String artistId)
    {
        this.artistId = artistId;
    }

    public String getCollectionCensoredName ()
    {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName (String collectionCensoredName)
    {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getCollectionName ()
    {
        return collectionName;
    }

    public void setCollectionName (String collectionName)
    {
        this.collectionName = collectionName;
    }

    public int getTrackCount ()
    {
        return trackCount;
    }

    public void setTrackCount (int trackCount)
    {
        this.trackCount = trackCount;
    }

    public int getTrackId ()
    {
        return trackId;
    }

    public void setTrackId (int trackId)
    {
        this.trackId = trackId;
    }

    public String getArtworkUrl30 ()
    {
        return artworkUrl30;
    }

    public void setArtworkUrl30 (String artworkUrl30)
    {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getPrimaryGenreName ()
    {
        return primaryGenreName;
    }

    public void setPrimaryGenreName (String primaryGenreName)
    {
        this.primaryGenreName = primaryGenreName;
    }

    public int getTrackNumber ()
    {
        return trackNumber;
    }

    public void setTrackNumber (int trackNumber)
    {
        this.trackNumber = trackNumber;
    }

    public int getDiscNumber ()
    {
        return discNumber;
    }

    public void setDiscNumber (int discNumber)
    {
        this.discNumber = discNumber;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getPreviewUrl ()
    {
        return previewUrl;
    }

    public void setPreviewUrl (String previewUrl)
    {
        this.previewUrl = previewUrl;
    }

    public String getTrackExplicitness ()
    {
        return trackExplicitness;
    }

    public void setTrackExplicitness (String trackExplicitness)
    {
        this.trackExplicitness = trackExplicitness;
    }

    public String getArtistViewUrl ()
    {
        return artistViewUrl;
    }

    public void setArtistViewUrl (String artistViewUrl)
    {
        this.artistViewUrl = artistViewUrl;
    }

    public double getTrackPrice ()
    {
        return trackPrice;
    }

    public void setTrackPrice (double trackPrice)
    {
        this.trackPrice = trackPrice;
    }

    public boolean isStreamable() {
        return isStreamable;
    }

    public void setStreamable(boolean streamable) {
        isStreamable = streamable;
    }

    public String getArtistName ()
    {
        return artistName;
    }

    public void setArtistName (String artistName)
    {
        this.artistName = artistName;
    }

    public String getArtworkUrl100 ()
    {
        return artworkUrl100;
    }

    public void setArtworkUrl100 (String artworkUrl100)
    {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getTrackViewUrl ()
    {
        return trackViewUrl;
    }

    public void setTrackViewUrl (String trackViewUrl)
    {
        this.trackViewUrl = trackViewUrl;
    }

    public double getCollectionPrice ()
    {
        return collectionPrice;
    }

    public void setCollectionPrice (double collectionPrice)
    {
        this.collectionPrice = collectionPrice;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [collectionExplicitness = "+collectionExplicitness+", trackCensoredName = "+trackCensoredName+", artworkUrl60 = "+artworkUrl60+", collectionId = "+collectionId+", discCount = "+discCount+", trackTimeMillis = "+trackTimeMillis+", collectionViewUrl = "+collectionViewUrl+", wrapperType = "+wrapperType+", trackName = "+trackName+", kind = "+kind+", currency = "+currency+", releaseDate = "+releaseDate+", artistId = "+artistId+", collectionCensoredName = "+collectionCensoredName+", collectionName = "+collectionName+", trackCount = "+trackCount+", trackId = "+trackId+", artworkUrl30 = "+artworkUrl30+", primaryGenreName = "+primaryGenreName+", trackNumber = "+trackNumber+", discNumber = "+discNumber+", country = "+country+", previewUrl = "+previewUrl+", trackExplicitness = "+trackExplicitness+", artistViewUrl = "+artistViewUrl+", trackPrice = "+trackPrice+", isStreamable = "+isStreamable+", artistName = "+artistName+", artworkUrl100 = "+artworkUrl100+", trackViewUrl = "+trackViewUrl+", collectionPrice = "+collectionPrice+"]";
    }
}

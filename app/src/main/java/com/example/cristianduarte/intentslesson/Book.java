package com.example.cristianduarte.intentslesson;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cduarte on 1/8/16.
 */
public class Book implements Parcelable {
    public String bookName;
    public String author;
    public int publishTime;

    public static final Parcelable.Creator<Book> CREATOR = new Creator<Book>() {

        public Book createFromParcel(Parcel source) {
            Book mBook = new Book();
            mBook.bookName = source.readString();
            mBook.author = source.readString();
            mBook.publishTime = source.readInt();
            return mBook;
        }
        public Book[] newArray(int size) {
            return new Book[size];
        }

    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(bookName);
        parcel.writeString(author);
        parcel.writeInt(publishTime);
    }
}

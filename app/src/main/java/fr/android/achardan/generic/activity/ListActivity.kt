package fr.android.achardan.generic.activity

import android.os.Parcelable
import fr.android.achardan.generic.ItemListener

interface ListActivity<T: Parcelable> : ItemListener<T>
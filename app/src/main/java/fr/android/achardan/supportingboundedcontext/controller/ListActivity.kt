package fr.android.achardan.supportingboundedcontext.controller

import android.os.Parcelable
import fr.android.achardan.supportingboundedcontext.ui.handler.ItemListener

interface ListActivity<T: Parcelable> : ItemListener<T>
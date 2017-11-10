package fr.android.androidexercises

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Step0Fragment : Fragment() {

    private var textView: TextView? = null
    private var nextButton: Button? = null
    private var listener: OnNextStep0Listener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.listener = context as OnNextStep0Listener?
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_step0, container, false)

        this.textView = view.findViewById(R.id.textView)
        this.nextButton = view.findViewById(R.id.nextButton)

        nextButton!!.setOnClickListener { listener!!.onNext() }

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.textView!!.text = step0
    }

    @FunctionalInterface
    interface OnNextStep0Listener {
        fun onNext()
    }

    companion object {

        private val step0 = "This is step 0"
    }
}

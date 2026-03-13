package si.uni_lj.fri.pbd.pbd2026_lab_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*


class Tab1Fragment : Fragment() {
    private val listItems = ArrayList<String>()
    private var adapter: ArrayAdapter<String>? = null
    private var myListView: ListView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tab1, container, false)

        myListView = view.findViewById(R.id.listView)
        adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, listItems)
        myListView?.adapter = adapter


        // TODO: Find FloatingActionButton and set the behaviour
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { v ->
            addListItem()
            Snackbar.make(v, "Item added to list", Snackbar.LENGTH_LONG)
                .setAction("Undo", undoOnClickListener).show()

        }

        return view
    }

    private val undoOnClickListener = View.OnClickListener { view ->
        listItems.removeAt(listItems.size - 1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Item removed", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    private fun addListItem() {
        val dateformat = SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
            Locale.US)
        listItems.add(dateformat.format(Date()))
        adapter?.notifyDataSetChanged()
    }
}
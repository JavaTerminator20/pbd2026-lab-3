package si.uni_lj.fri.pbd.pbd2026_lab_3

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter :  RecyclerView.Adapter<RecyclerAdapter.CardViewHolder?>() {

    private val titles = arrayOf("Mercury",
        "Venus",
        "Earth",
        "Mars",
        "Jupiter",
        "Saturn",
        "Uranus",
        "Neptune")
    private val details = arrayOf("The smallest planet",
        "The second brightest object in the night sky", "The only known to harbour life",
        "Named after the Roman god of war", "The largest planet in the Solar system",
        "Famous for its rings", "The coldest planet",
        "The farthest from the Sun")
    private val images = intArrayOf(R.drawable.mercury,
        R.drawable.venus,
        R.drawable.earth,
        R.drawable.mars,
        R.drawable.jupiter,
        R.drawable.saturn,
        R.drawable.uranus,
        R.drawable.neptune)

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView!!) {
        var itemImage: ImageView = itemView.findViewById<ImageView>(R.id.item_image)
        var itemTitle: TextView = itemView.findViewById<TextView>(R.id.item_title)
        var itemDetail: TextView = itemView.findViewById<TextView>(R.id.item_detail)

        // Show a Snackbar every time a user clicks on an item.
        init {
            itemView.setOnClickListener {
                Snackbar.make(itemView, "Card position: $adapterPosition", Snackbar.LENGTH_LONG)
                .show()
            }
        }
    }

    // Ensures that we have a CardViewHolder created when needed.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,
            parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.itemImage.setImageResource(images[position])
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
    }
}
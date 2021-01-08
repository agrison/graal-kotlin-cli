import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.asciitable.CWC_FixedWidth
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER
import org.apache.commons.io.IOUtils
import java.lang.System.currentTimeMillis
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.atomic.AtomicLong

fun main(args: Array<String>) {
    fetchRepositories(if (args.isNotEmpty()) args[0] else "agrison").let { json ->
        timeIt("Fetching repositories")
        parseRepositories(json).top20().let { reps ->
            timeIt("Parsing repositories")
            display(reps)
            timeIt("Displaying repositories")
        }
    }
}

// region ----- API -----
fun fetchRepositories(user: String): String {
    val url = URL("https://api.github.com/users/${user}/repos?per_page=100")
    with(url.openConnection() as HttpURLConnection) {
        setRequestProperty("Accept", "application/json")
        return IOUtils.toString(inputStream.bufferedReader())
    }
}

fun parseRepositories(json: String): List<Repository> {
    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()
    val sType = object : TypeToken<List<Repository>>() {}.type
    return gson.fromJson(json, sType)
}

fun List<Repository>.top20() = filter { !it.fork }.sortedByDescending { it.stargazersCount }.take(20)
// endregion

// region ----- Table display -----
fun display(repositories: List<Repository>) {
    fun display(table: AsciiTable, r: Repository) {
        with(table) {
            val row = addRow(
                r.fullName,
                r.description ?: "-",
                r.language ?: "-",
                r.stargazersCount,
                r.watchers,
                r.forksCount
            )
            row.cells.subList(2, 6).forEach { it.context.textAlignment = CENTER }
            addRule()
        }
    }

    AsciiTable().let { table ->
        val cwc = CWC_FixedWidth()
        with(cwc) {
            add(40) // name
            add(80) // description
            add(15) // language
            add(10) // stars
            add(10) // watchers
            add(10) // forks
        }
        with(table) {
            addRule()
            val row = addRow("Name", "Description", "Language", "Stars", "Watchers", "Forks")
            row.cells.subList(2, 6).forEach { it.context.textAlignment = CENTER }
            addRule()
            repositories.forEach { reps -> display(table, reps) }
            table.renderer.cwc = cwc
        }
        println(table.render())
    }
}
// endregion

// region ----- models ------
data class Owner(
    var login: String, var avatarUrl: String, var htmlUrl: String
)

data class Repository(
    var id: Int, var fullName: String,
    var htmlUrl: String, var description: String?,
    var stargazersCount: Int, var watchersCount: Int,
    var forksCount: Int, var watchers: Int,
    var language: String?, var size: Int,
    var owner: Owner, var fork: Boolean
)
// endregion

// region ----- timer -----
val lastTimestamp = AtomicLong(currentTimeMillis())
fun timeIt(label: String) {
    currentTimeMillis().let {
        println("$label took ${it - lastTimestamp.get()}ms")
        lastTimestamp.set(it)
    }
}
// endregion
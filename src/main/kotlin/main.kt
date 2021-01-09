import com.google.gson.*
import com.google.gson.reflect.TypeToken
import de.vandermeer.asciitable.*
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER
import org.apache.commons.io.IOUtils
import java.lang.System.currentTimeMillis
import java.net.*
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
    val columns = linkedMapOf(
        "Name" to 40, "Description" to 80, "Language" to 15, "Stars" to 10, "Watchers" to 10, "Forks" to 10
    )

    fun AT_Row.layout() = cells.subList(2, 6).forEach { it.context.textAlignment = CENTER }

    fun AsciiTable.addRepository(r: Repository) {
        addRow(r.entries()).layout()
        addRule()
    }

    AsciiTable().let { table ->
        CWC_FixedWidth().let { cwc ->
            columns.values.forEach { cwc.add(it) }
            with(table) {
                addRule()
                addRow(columns.keys).layout()
                addRule()
                repositories.forEach { table.addRepository(it) }
                renderer.cwc = cwc
            }
            println(table.render())
        }
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
) {
    fun entries() = listOf(
        fullName, description ?: "-", language ?: "-",
        stargazersCount.toString(), watchers.toString(), forksCount.toString()
    )
}
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
package moviemodule


fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie> {
    var results: MutableList<Movie> = mutableListOf()

    do {
        val movie = collection.removeAt(0)
        if (movie.title.contains(query)) {
            results.add(movie)
        }
    } while (collection.size > 0)

    return results
}

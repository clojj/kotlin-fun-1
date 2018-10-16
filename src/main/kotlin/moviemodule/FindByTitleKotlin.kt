package moviemodule


// findByTitle :: (String, [Movie]) -> [Movie]
fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie> {
    var results: List<Movie> = listOf()

    // matches :: (String, Film) -> Boolean
    val predicate = ::matches

    val add = fun(movie: Movie) = fun(movies: List<Movie>) = movies.plus(movie)

    for (movie: Movie in collection) {
        val fn = addIf(predicate, query, movie, add)
        results = fn(movie)(results)
    }

    return results
}

fun addIf(predicate: (String, Movie) -> Boolean, query: String, movie: Movie, add: (Movie) -> (List<Movie>) -> List<Movie>): (Movie) -> (List<Movie>) -> List<Movie> {
    if (predicate(query, movie)) {
        return add
    }
    return nop()
}

fun nop() = fun(_: Movie) = fun(_: List<Movie>) = listOf<Movie>()

fun matches(query: String, movie: Movie) = movie.title.contains(query)


package moviemodule


// findByTitle :: (String, [Movie]) -> [Movie]
fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie>{
    var results: MutableList<Movie> = mutableListOf()

    // Use of functions as variables (predicate and add) : functions as first class citizen

    // matches :: (String, Film) -> Boolean
    val predicate = ::matches

    // TODO side effect moved up (still on results)
    // add :: (Film) -> Boolean
    val add = fun (movie: Movie) = results.add(movie)

    for (movie: Movie in collection){
        val fn = addIf(predicate, query, movie, add)
        fn(movie)
    }

    return results
}

// addIf :: ((String, Movie) -> Boolean, String, Movie, [Movie] -> (Boolean)) -> (Movie) -> (Boolean)
fun addIf(predicate: (String, Movie) -> Boolean, query: String, movie: Movie, add: (Movie) -> (Boolean)): (Movie) -> (Boolean){
    if (predicate(query, movie)){
        return add
    }
    return fun (_: Movie) = false
}

fun matches(query: String, movie: Movie) = movie.title.contains(query)


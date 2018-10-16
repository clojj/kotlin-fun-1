package moviemodule


fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie>{
    var results: MutableList<Movie> = mutableListOf()

    do {
        val movie = collection.removeAt(0)
        addIfMatches(query, movie, results)
    }
    while (collection.size > 0)

    return results
}

fun addIfMatches(query: String, movie: Movie, results: MutableList<Movie>){
    if (movie.title.contains(query)){
        results.add(movie)
    }
}


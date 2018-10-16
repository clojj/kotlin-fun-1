package moviemodule


val findByTitle = { query: String ->
    { collection: MutableList<Movie> ->
        val predicate = matches(query)
        filter(predicate)(collection)
    }
}

val filter = { predicate: (Movie) -> Boolean ->
    { collection: List<Movie> ->
        collection.filter(predicate)
    }
}

val matches = { query: String -> { movie: Movie -> movie.title.contains(query) } }


package moviemodule


// findByTitle :: (String, [Movie]) -> [Movie]
val findByTitle =
        { query: String ->
            { collection: MutableList<Movie> ->
                var results: List<Movie> = listOf()

                // matches :: (String, Film) -> Boolean
                val predicate = matches

                val add = { movie: Movie -> { movies: List<Movie> -> movies.plus(movie) } }

                for (movie: Movie in collection) {
                    results = addIf(predicate)(query)(movie)(add)(results)
                }

                results
            }
        }

val addIf = { predicate: (String) -> (Movie) -> Boolean ->
    { query: String ->
        { movie: Movie ->
            { add: (Movie) -> (List<Movie>) -> List<Movie> ->
                if (matches(query)(movie)) {
                    add(movie)
                } else {
                    nop
                }
            }
        }
    }
}

val nop = { _: List<Movie> -> listOf<Movie>() }

val matches = { query: String -> { movie: Movie -> movie.title.contains(query) } }


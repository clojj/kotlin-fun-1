package moviemodule


val findByTitle: (String) -> (MutableList<Movie>) -> List<Movie> =
        { query: String ->
            { collection: MutableList<Movie> ->
                val predicate = matches(query)
                filter(predicate)(collection)
            }
        }

val filter: ((Movie) -> Boolean) -> (List<Movie>) -> List<Movie> =
        { predicate: (Movie) -> Boolean ->
            { collection: List<Movie> ->
                collection.filter(predicate)
            }
        }

val matches: (String) -> (Movie) -> Boolean =
        { query: String -> { movie: Movie -> movie.title.contains(query) } }


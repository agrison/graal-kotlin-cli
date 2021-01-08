# Sample Kotlin CLI app using GraalVM

## Building & running

See `build.sh`

## Output

This app just fetches my repositories from Github and display them.

### TLDR

* The binary is 25MB large, takes 35MB of memory and runs in 300ms using GraalVM native image
* The JAR is 7.7MB large, takes 300MB of memory and runs in 1.4s without GraalVM native image

### With Graal VM

```text
Fetching JSON took 145ms
Loading data took 2ms
┌────────────────────────────────────────┬────────────────────────────────────────────────────────────────────────────────┬───────────────┬──────────┬──────────┬──────────┐
│Name                                    │Description                                                                     │   Language    │  Stars   │ Watchers │  Forks   │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/harpoon                         │GitHub WebHook server written in Go                                             │      Go       │   240    │   240    │    17    │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/go-tablib                       │Go Module for Tabular Datasets in CSV, JSON, YAML, etc.                         │      Go       │   139    │   139    │    14    │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/jtoml                           │TOML for Java                                                                   │     Java      │    40    │    40    │    11    │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/redux4j                         │Java 13 implementation of redux with Vavr                                       │     Java      │    27    │    27    │    4     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/jssg                            │Java static site generator                                                      │     Java      │    18    │    18    │    3     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/go-commons-lang                 │go-commons-lang                                                                 │      Go       │    14    │    14    │    3     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/raytraclj                       │A raytracer implementation in Clojure                                           │    Clojure    │    11    │    11    │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/scalocco                        │Scalocco, a quick and dirty implementation of Docco in Scala                    │     Scala     │    9     │    9     │    3     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/catastrophic                    │Catastrophic: a Monster Component in Java & Spring                              │     Java      │    8     │    8     │    2     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/covid19-babashka                │-                                                                               │    Clojure    │    8     │    8     │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/advent-of-code                  │Solutions to the Advent of Code editions, mainly using Kotlin.                  │    Kotlin     │    7     │    7     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/ocamail                         │Simple SMTP Server in OCaml                                                     │     OCaml     │    6     │    6     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/duct-mongodb                    │Integrant methods for connecting to a MongoDB database via Monger               │    Clojure    │    5     │    5     │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/cljwebauthn                     │Webauthn for Clojure                                                            │    Clojure    │    4     │    4     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/duct-elasticsearch              │Integrant multimethods for connecting to ElasticSearch via Spandex.             │    Clojure    │    2     │    2     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/isfates-c-2018                  │-                                                                               │     HTML      │    2     │    2     │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/legacy4j                        │Legacy flat files for Java                                                      │     Java      │    2     │    2     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/sermonis                        │sermonis                                                                        │  JavaScript   │    2     │    2     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/clean-fb-wall                   │Clean your Facebook Wall                                                        │       -       │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/duct-immutant                   │Integrant methods for running an Immutant web server                            │    Clojure    │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/grison.me                       │Website pulled by DryDrop on Google App Engine                                  │      CSS      │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/kree                            │Simple indentation Guide for Eclipse                                            │       -       │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/realworld-server-tester         │Realworld sample app backend tester                                             │    Clojure    │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/agrison                         │My Github profile README                                                        │       -       │    0     │    0     │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/cljwebauthn-sample              │A sample app using cljwebauthn                                                  │     HTML      │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/clojure-north-2020-fp-katas     │-                                                                               │    Clojure    │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/duct-pohjavirta                 │Integrant methods for running an Undertow web server through Pohjavirta         │    Clojure    │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/gilded-rose-kata-vavr           │Gilded Rose Kata using Java 14 and Vavr                                         │     Java      │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/graal-kotlin-cli                │Sample of using Kotlin & GraalVM to write a small CLI application fetching  data│    Kotlin     │    0     │    0     │    0     │
│                                        │from Github.                                                                    │               │          │          │          │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/gravitas                        │Gravitas                                                                        │       -       │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/hello-clj-clever-cloud          │Sample clojure app running on clever-cloud                                      │    Clojure    │    0     │    0     │    2     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/MonMet                          │Sauve les horaires du Met' à tes arrêts, consulte-les facilement.               │  JavaScript   │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/ocamlbyexample                  │OCaml by Example http://ocamlbyexample.com                                      │       -       │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/realworld-spark                 │real world exemple app using spark                                              │       -       │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/recall-popcorn                  │-                                                                               │  JavaScript   │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/vavr-football-data              │-                                                                               │     Java      │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/vavr-sb-demo                    │-                                                                               │     Java      │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/vimopen                         │Open eclipse current file in gvim                                               │       -       │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/workshops                       │-                                                                               │     Java      │    0     │    0     │    0     │
└────────────────────────────────────────┴────────────────────────────────────────────────────────────────────────────────┴───────────────┴──────────┴──────────┴──────────┘
Displaying data took 26ms
        Command being timed: "./github"
        User time (seconds): 0.03
        System time (seconds): 0.01
        Percent of CPU this job got: 19%
        Elapsed (wall clock) time (h:mm:ss or m:ss): 0:00.18
        Average shared text size (kbytes): 0
        Average unshared data size (kbytes): 0
        Average stack size (kbytes): 0
        Average total size (kbytes): 0
        Maximum resident set size (kbytes): 35324
        Exit status: 0
```

### Without Graal VM

```text
Fetching JSON took 748ms
Loading data took 76ms
┌────────────────────────────────────────┬────────────────────────────────────────────────────────────────────────────────┬───────────────┬──────────┬──────────┬──────────┐
│Name                                    │Description                                                                     │   Language    │  Stars   │ Watchers │  Forks   │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/harpoon                         │GitHub WebHook server written in Go                                             │      Go       │   240    │   240    │    17    │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/go-tablib                       │Go Module for Tabular Datasets in CSV, JSON, YAML, etc.                         │      Go       │   139    │   139    │    14    │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/jtoml                           │TOML for Java                                                                   │     Java      │    40    │    40    │    11    │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/redux4j                         │Java 13 implementation of redux with Vavr                                       │     Java      │    27    │    27    │    4     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/jssg                            │Java static site generator                                                      │     Java      │    18    │    18    │    3     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/go-commons-lang                 │go-commons-lang                                                                 │      Go       │    14    │    14    │    3     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/raytraclj                       │A raytracer implementation in Clojure                                           │    Clojure    │    11    │    11    │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/scalocco                        │Scalocco, a quick and dirty implementation of Docco in Scala                    │     Scala     │    9     │    9     │    3     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/catastrophic                    │Catastrophic: a Monster Component in Java & Spring                              │     Java      │    8     │    8     │    2     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/covid19-babashka                │-                                                                               │    Clojure    │    8     │    8     │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/advent-of-code                  │Solutions to the Advent of Code editions, mainly using Kotlin.                  │    Kotlin     │    7     │    7     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/ocamail                         │Simple SMTP Server in OCaml                                                     │     OCaml     │    6     │    6     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/duct-mongodb                    │Integrant methods for connecting to a MongoDB database via Monger               │    Clojure    │    5     │    5     │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/cljwebauthn                     │Webauthn for Clojure                                                            │    Clojure    │    4     │    4     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/duct-elasticsearch              │Integrant multimethods for connecting to ElasticSearch via Spandex.             │    Clojure    │    2     │    2     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/isfates-c-2018                  │-                                                                               │     HTML      │    2     │    2     │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/legacy4j                        │Legacy flat files for Java                                                      │     Java      │    2     │    2     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/sermonis                        │sermonis                                                                        │  JavaScript   │    2     │    2     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/clean-fb-wall                   │Clean your Facebook Wall                                                        │       -       │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/duct-immutant                   │Integrant methods for running an Immutant web server                            │    Clojure    │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/grison.me                       │Website pulled by DryDrop on Google App Engine                                  │      CSS      │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/kree                            │Simple indentation Guide for Eclipse                                            │       -       │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/realworld-server-tester         │Realworld sample app backend tester                                             │    Clojure    │    1     │    1     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/agrison                         │My Github profile README                                                        │       -       │    0     │    0     │    1     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/cljwebauthn-sample              │A sample app using cljwebauthn                                                  │     HTML      │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/clojure-north-2020-fp-katas     │-                                                                               │    Clojure    │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/duct-pohjavirta                 │Integrant methods for running an Undertow web server through Pohjavirta         │    Clojure    │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/gilded-rose-kata-vavr           │Gilded Rose Kata using Java 14 and Vavr                                         │     Java      │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/graal-kotlin-cli                │Sample of using Kotlin & GraalVM to write a small CLI application fetching  data│    Kotlin     │    0     │    0     │    0     │
│                                        │from Github.                                                                    │               │          │          │          │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/gravitas                        │Gravitas                                                                        │       -       │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/hello-clj-clever-cloud          │Sample clojure app running on clever-cloud                                      │    Clojure    │    0     │    0     │    2     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/MonMet                          │Sauve les horaires du Met' à tes arrêts, consulte-les facilement.               │  JavaScript   │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/ocamlbyexample                  │OCaml by Example http://ocamlbyexample.com                                      │       -       │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/realworld-spark                 │real world exemple app using spark                                              │       -       │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/recall-popcorn                  │-                                                                               │  JavaScript   │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/vavr-football-data              │-                                                                               │     Java      │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/vavr-sb-demo                    │-                                                                               │     Java      │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/vimopen                         │Open eclipse current file in gvim                                               │       -       │    0     │    0     │    0     │
├────────────────────────────────────────┼────────────────────────────────────────────────────────────────────────────────┼───────────────┼──────────┼──────────┼──────────┤
│agrison/workshops                       │-                                                                               │     Java      │    0     │    0     │    0     │
└────────────────────────────────────────┴────────────────────────────────────────────────────────────────────────────────┴───────────────┴──────────┴──────────┴──────────┘
Displaying data took 107ms
        Command being timed: "java -jar graal-github-repos-kt-1.0-SNAPSHOT-all.jar"
        User time (seconds): 1.40
        System time (seconds): 0.56
        Percent of CPU this job got: 258%
        Elapsed (wall clock) time (h:mm:ss or m:ss): 0:00.76
        Average shared text size (kbytes): 0
        Average unshared data size (kbytes): 0
        Average stack size (kbytes): 0
        Average total size (kbytes): 0
        Maximum resident set size (kbytes): 300300
        Exit status: 0
```

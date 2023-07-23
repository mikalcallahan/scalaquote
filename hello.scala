#!/usr/bin/env -S scala-cli -S 3

// using upickle.default latest
//> using toolkit latest
//> using dep com.lihaoyi::upickle:3.1.2
// using dep com.spray::spray-json:1.3.6
// import upickle.default.*

case class Quote(
    author: String,
    text: String
) //  derives upickle.default.ReadWriter
case class Quotes(quotes: List[Quote])

val readQuotes = Quotes(
  List(
    Quote(
      "Edward S. Balian",
      "Are you treating yourself like a business?"
    ),
    Quote(
      "Eckhart Tolle",
      "Accept every moment as if you had chosen it"
    )
  )
)

@main def hello(): Unit = {
  /*
  val readQuotes: Quotes = upickle.default.read[Quotes](
    os.read(os.pwd / "quotes.json")
  ) //  ujson.read(os.read(os.pwd / "quotes.json")) //
   */
  val index = (new scala.util.Random).nextInt(readQuotes.quotes.length)
  // println(s"somethinggg ${readQuotes.quotes}")

  println(
    s"${readQuotes.quotes(index).text}\n- ${readQuotes.quotes(index).author}"
  )

}
